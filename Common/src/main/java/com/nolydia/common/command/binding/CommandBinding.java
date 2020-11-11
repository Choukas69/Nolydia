package com.nolydia.common.command.binding;

public class CommandBinding {

    private final Class<?> command;

    public CommandBinding(Class<?> command) {
        System.out.println("A");
        this.command = command;
    }

    public Class<?> getCommand() {
        return this.command;
    }
}
