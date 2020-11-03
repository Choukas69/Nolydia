package com.nolydia.common.command.binding;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

public class CommandBinder {

    private final Multibinder<CommandBinding> multibinder;

    public CommandBinder(Binder binder) {
        multibinder = Multibinder.newSetBinder(binder, CommandBinding.class);
    }

    public void addCommand(Class<?> command) {
        multibinder.addBinding().toProvider(() -> new CommandBinding(command));
    }
}
