package com.nolydia.bukkit.api.plugin;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.nolydia.bukkit.api.command.CommandModule;
import com.nolydia.bukkit.api.console.BukkitConsole;
import com.nolydia.bukkit.api.listener.ListenerModule;
import com.nolydia.common.console.Console;
import com.nolydia.common.plugin.annotations.DataFolder;
import com.nolydia.common.plugin.annotations.Logging;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.nio.file.Path;
import java.util.logging.Logger;

public class PluginModule extends AbstractModule {

    private final Plugin plugin;

    public PluginModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(Plugin.class).toInstance(plugin);
        bind(PluginManager.class).toInstance(plugin.getServer().getPluginManager());

        bind(Console.class).to(BukkitConsole.class);

        install(new CommandModule());
        install(new ListenerModule());
    }

    @Provides
    @DataFolder
    public Path provideDataFolder() {
        return plugin.getDataFolder().toPath();
    }

    @Provides
    @Logging
    public Logger provideLogger() {
        return plugin.getLogger();
    }
}
