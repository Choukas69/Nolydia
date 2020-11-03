package com.nolydia.bungee.api.plugin.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.nolydia.bungee.api.listener.BungeeListenerRegisterer;
import com.nolydia.common.plugin.annotations.DataFolder;
import com.nolydia.common.listener.ListenerRegisterer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

import java.nio.file.Path;

public class PluginModule extends AbstractModule {

    private final Plugin plugin;

    public PluginModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);
        bind(PluginManager.class).toInstance(plugin.getProxy().getPluginManager());

        bind(ListenerRegisterer.class).to(BungeeListenerRegisterer.class);
    }

    @Provides
    @DataFolder
    public Path provideDataFolder() {
        return plugin.getDataFolder().toPath();
    }
}
