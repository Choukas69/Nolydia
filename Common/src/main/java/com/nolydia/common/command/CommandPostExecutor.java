package com.nolydia.common.command;

import com.google.inject.Inject;
import com.nolydia.common.command.binding.CommandBinding;

import java.util.Set;

public class CommandPostExecutor {

    private final Set<CommandBinding> commands;

    @Inject
    public CommandPostExecutor(Set<CommandBinding> commands) {
        this.commands = commands;
    }

    public void registerCommands() {
        commands.forEach(commandBinding -> System.out.println(commandBinding.getCommand()));
    }
}
