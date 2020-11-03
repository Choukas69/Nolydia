package com.nolydia.common;

import com.google.inject.AbstractModule;
import com.nolydia.common.command.CommandModule;
import com.nolydia.common.configuration.ConfigurationModule;
import com.nolydia.common.internalization.InternalizationModule;
import com.nolydia.common.io.IOModule;
import com.nolydia.common.player.PlayerModule;

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new CommandModule());
        install(new ConfigurationModule());
        install(new InternalizationModule());
        install(new IOModule());
        install(new PlayerModule());
    }
}
