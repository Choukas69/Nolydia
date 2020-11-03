package com.nolydia.lobby.listeners;

import com.google.inject.Inject;
import com.nolydia.common.internalization.InternalizationService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final InternalizationService internalizationService;

    @Inject
    public PlayerJoinListener(InternalizationService internalizationService) {
        this.internalizationService = internalizationService;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("HELLo frr");
    }
}
