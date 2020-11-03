package com.nolydia.bukkit.api.command.sender;

import com.google.inject.Inject;
import com.nolydia.common.command.sender.CommandSenderProvider;
import com.nolydia.common.command.sender.exceptions.UnsupportedSenderException;
import com.nolydia.common.console.Console;
import com.nolydia.common.player.PlayerRepository;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BukkitCommandSenderProvider implements CommandSenderProvider<CommandSender> {

    private final PlayerRepository playerRepository;
    private final Console console;

    @Inject
    public BukkitCommandSenderProvider(PlayerRepository playerRepository, Console console) {
        this.playerRepository = playerRepository;
        this.console = console;
    }

    public com.nolydia.common.command.sender.CommandSender provide(CommandSender bukkitSender) {
        if (bukkitSender instanceof Player) {
            return playerRepository.getPlayer(((Player) bukkitSender).getUniqueId());
        } else if (bukkitSender instanceof ConsoleCommandSender) {
            return console;
        } else {
            throw new UnsupportedSenderException();
        }
    }
}
