package com.nolydia.common.player;

import com.google.inject.AbstractModule;

public class PlayerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PlayerRepository.class).to(PluginPlayerRepository.class);
    }
}
