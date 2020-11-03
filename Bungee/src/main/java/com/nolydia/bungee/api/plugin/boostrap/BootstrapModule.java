package com.nolydia.bungee.api.plugin.boostrap;

import com.google.inject.AbstractModule;
import com.nolydia.bungee.api.plugin.modules.PluginModule;
import com.nolydia.bungee.core.CoreModule;
import com.nolydia.common.CommonModule;
import net.md_5.bungee.api.plugin.Plugin;

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
