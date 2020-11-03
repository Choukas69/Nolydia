package com.nolydia.lobby;

import com.google.inject.AbstractModule;
import com.nolydia.common.command.CommandModule;
import com.nolydia.lobby.listeners.ListenerModule;

public class LobbyModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new CommandModule());
        install(new ListenerModule());
    }
}
