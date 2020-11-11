package com.nolydia.bukkit.api.console;

import com.google.inject.Inject;
import com.nolydia.common.console.AbstractConsole;
import com.nolydia.common.internalization.InternalizationService;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;

public class BukkitConsole extends AbstractConsole {

    @Inject
    public BukkitConsole(InternalizationService internalizationService) {
       super(internalizationService);
    }

    @Override
    public void sendMessage(BaseComponent[] components) {
        Bukkit.getConsoleSender().spigot().sendMessage(components);
    }
}
