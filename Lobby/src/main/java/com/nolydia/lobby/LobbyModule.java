package com.nolydia.lobby;

import com.google.inject.AbstractModule;
import com.nolydia.lobby.commands.lang.CommandModule;
import com.nolydia.lobby.listeners.ListenerModule;

public class LobbyModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new CommandModule());
        install(new ListenerModule());
    }
}
