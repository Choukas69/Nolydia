package com.nolydia.bukkit.api.plugin.boostrap;

import com.google.inject.AbstractModule;
import com.nolydia.bukkit.api.plugin.PluginModule;
import com.nolydia.bukkit.core.CoreModule;
import com.nolydia.common.CommonModule;
import org.bukkit.plugin.Plugin;

public class BootstrapModule extends AbstractModule {

    private final Plugin plugin;

    public BootstrapModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        install(new PluginModule(plugin));
        install(new CommonModule());
        install(new CoreModule());
    }
}
