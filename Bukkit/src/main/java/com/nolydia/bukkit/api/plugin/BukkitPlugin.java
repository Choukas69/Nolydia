package com.nolydia.bukkit.api.plugin;

import com.google.inject.Injector;
import com.nolydia.bukkit.api.plugin.boostrap.BukkitPluginBootstrapper;
import com.nolydia.common.plugin.ConfigurablePlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public abstract class BukkitPlugin extends JavaPlugin implements ConfigurablePlugin {

    protected Injector injector;

    @Override
    public void onEnable() {
        File dataFolder = getDataFolder();

        if (!dataFolder.exists()) {
            if (!dataFolder.mkdirs()) {
                Bukkit.shutdown();
            }
        }

        BukkitPluginBootstrapper bootstrapper = new BukkitPluginBootstrapper(this);
        injector = bootstrapper.bootstrap();
    }
}
