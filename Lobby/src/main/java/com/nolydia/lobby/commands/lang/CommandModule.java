package com.nolydia.lobby.commands.lang;

import com.google.inject.AbstractModule;
import com.nolydia.common.command.binding.CommandBinder;

public class CommandModule extends AbstractModule {

    @Override
    protected void configure() {
        CommandBinder binder = new CommandBinder(binder());
        binder.addCommand(LangCommand.class);
    }
}
