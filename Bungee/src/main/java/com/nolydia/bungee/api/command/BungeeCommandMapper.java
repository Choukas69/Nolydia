package com.nolydia.bungee.api.command;

import com.google.inject.Inject;
import com.nolydia.common.command.BaseCommand;
import com.nolydia.common.command.sender.CommandSenderProvider;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.TabExecutor;

public class BungeeCommandMapper extends net.md_5.bungee.api.plugin.Command implements TabExecutor {

    private final CommandSenderProvider<CommandSender> commandSenderProvider;
    private final BaseCommand baseCommand;

    @Inject
    public BungeeCommandMapper(CommandSenderProvider<CommandSender> commandSenderProvider,
                               BaseCommand baseCommand) {
        super(baseCommand.getName());

        this.commandSenderProvider = commandSenderProvider;
        this.baseCommand = baseCommand;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        baseCommand.execute(commandSenderProvider.provide(sender), args);
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        return baseCommand.tabComplete(commandSenderProvider.provide(sender), args);
    }
}
