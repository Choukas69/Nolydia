package com.nolydia.bungee.api.plugin.boostrap;

import com.google.inject.Injector;
import com.nolydia.bungee.api.plugin.BungeePlugin;
import com.nolydia.common.plugin.boostrap.AbstractPluginBootstrapper;

public class BungeePluginBootstrapper extends AbstractPluginBootstrapper {

    private final BungeePlugin plugin;

    public BungeePluginBootstrapper(BungeePlugin plugin) {
        this.plugin = plugin;
    }

    public Injector bootstrap() {
        return super.boostrap(new BootstrapModule(plugin), plugin.getConfiguration());
    }
}
