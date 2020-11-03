package com.nolydia.common.command;

import com.nolydia.common.command.binding.CommandBinding;

import java.util.Set;

public class CommandPostExecutor {

    private final Set<CommandBinding> commands;

    public CommandPostExecutor(Set<CommandBinding> commands) {
        this.commands = commands;
    }

    public void registerCommands() {
        commands.forEach(commandBinding -> System.out.println(commandBinding.getCommand()));
    }
}
