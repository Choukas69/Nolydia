package com.nolydia.lobby;

import com.nolydia.bukkit.api.plugin.BukkitPlugin;
import com.nolydia.common.plugin.configuration.PluginConfiguration;

import java.util.Collections;

public class LobbyPlugin extends BukkitPlugin {

    @Override
    public PluginConfiguration getConfiguration() {
        return () -> Collections.singletonList(new LobbyModule());
    }
}
