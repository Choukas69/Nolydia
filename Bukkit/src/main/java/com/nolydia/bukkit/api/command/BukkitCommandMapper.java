package com.nolydia.bukkit.api.command;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.nolydia.common.command.BaseCommand;
import com.nolydia.common.command.sender.CommandSenderProvider;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import javax.annotation.Nonnull;
import java.util.List;

public class BukkitCommandMapper extends Command {

    private final CommandSenderProvider<CommandSender> commandSenderProvider;
    private final BaseCommand baseCommand;

    @Inject
    public BukkitCommandMapper(CommandSenderProvider<CommandSender> commandSenderProvider, @Assisted BaseCommand baseCommand) {
        super(baseCommand.getName(), "", "", baseCommand.getAliases());

        this.commandSenderProvider = commandSenderProvider;
        this.baseCommand = baseCommand;
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String commandLabel, @Nonnull String[] args) {
        baseCommand.execute(commandSenderProvider.provide(sender), args);

        return true;
    }

    @Nonnull
    @Override
    public List<String> tabComplete(@Nonnull CommandSender sender, @Nonnull String alias, @Nonnull String[] args) throws IllegalArgumentException {
        return baseCommand.tabComplete(commandSenderProvider.provide(sender), args);
    }
}
