package com.nolydia.lobby.listeners;

import com.google.inject.AbstractModule;
import com.nolydia.common.listener.ListenerBinder;
import org.bukkit.event.Listener;

public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        ListenerBinder<Listener> binder = new ListenerBinder<>(binder(), Listener.class);
        binder.bind(PlayerJoinListener.class);
    }
}
