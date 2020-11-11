package com.nolydia.bungee.api.plugin;

import com.google.inject.Injector;
import com.nolydia.bungee.api.plugin.boostrap.BungeePluginBootstrapper;
import com.nolydia.common.plugin.ConfigurablePlugin;
import net.md_5.bungee.api.plugin.Plugin;

public abstract class BungeePlugin extends Plugin implements ConfigurablePlugin {

    protected Injector injector;

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            if (!getDataFolder().mkdirs()) {
                getProxy().stop();
            }
        }

        BungeePluginBootstrapper bootstrapper = new BungeePluginBootstrapper(this);
        injector = bootstrapper.bootstrap();
    }
}
