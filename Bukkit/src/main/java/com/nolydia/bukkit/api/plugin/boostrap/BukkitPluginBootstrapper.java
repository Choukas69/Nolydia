package com.nolydia.bukkit.api.plugin.boostrap;

import com.google.inject.Injector;
import com.nolydia.bukkit.api.plugin.BukkitPlugin;
import com.nolydia.common.plugin.boostrap.AbstractPluginBootstrapper;

public class BukkitPluginBootstrapper extends AbstractPluginBootstrapper {

    private final BukkitPlugin plugin;

    public BukkitPluginBootstrapper(BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    public Injector bootstrap() {
        return super.boostrap(new BootstrapModule(plugin), plugin.getConfiguration());
    }
}
