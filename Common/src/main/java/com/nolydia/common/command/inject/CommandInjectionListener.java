package com.nolydia.common.command.inject;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.nolydia.common.command.AbstractCommandRepository;
import com.nolydia.common.command.BaseCommand;
import com.nolydia.common.command.BaseCommandFactory;
import com.nolydia.common.command.CommandDetails;
import com.nolydia.common.command.annotations.Command;
import com.nolydia.common.command.execution.CommandExecutor;
import com.nolydia.common.internalization.InternalizationMessage;

import java.util.Arrays;

public class CommandInjectionListener {

    private final Injector injector;
    private final BaseCommandFactory factory;
    private final AbstractCommandRepository repository;

    @Inject
    public CommandInjectionListener(Injector injector, BaseCommandFactory factory, AbstractCommandRepository repository) {
        this.injector = injector;
        this.factory = factory;
        this.repository = repository;
    }

    public void hear(ClassLoader classLoader) {
        /*ClassIndex.getAnnotated(RegistrableCommand.class, classLoader).forEach(type -> {
            if (type.getAnnotation(RegistrableCommand.class).value()) {
                repository.addCommand(buildCommand(type));
            }
        });*/
    }

    private BaseCommand buildCommand(Class<?> mappedCommand) {
        Command annotation = mappedCommand.getAnnotation(Command.class);

        CommandDetails details = new CommandDetails(annotation.name(),
                annotation.permission(),
                Arrays.asList(annotation.aliases()),
                new InternalizationMessage(annotation.description()));

        CommandExecutor executor = CommandExecutor.class.isAssignableFrom(mappedCommand)
                ? (CommandExecutor) injector.getInstance(mappedCommand)
                : null;

        BaseCommand command = factory.createCommand(details, executor);

        Arrays.stream(annotation.requirements()).forEach(requirement ->
                command.addRequirement(injector.getInstance(requirement)));

        Arrays.stream(annotation.arguments()).forEach(argument ->
                command.addArgument(injector.getInstance(argument)));

        Arrays.stream(annotation.subCommands()).forEach(subCommand ->
                command.addSubCommand(buildCommand(subCommand)));

        return command;
    }
}
