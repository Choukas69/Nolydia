package com.nolydia.common.command.binding;

public class CommandBinding {

    private final Class<?> command;

    public CommandBinding(Class command) {
        this.command = command;
    }

    public Class<?> getCommand() {
        return this.command;
    }
}
