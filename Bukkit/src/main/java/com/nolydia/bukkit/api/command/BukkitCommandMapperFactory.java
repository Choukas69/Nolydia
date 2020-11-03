package com.nolydia.bukkit.api.command;

import com.nolydia.common.command.BaseCommand;

public interface BukkitCommandMapperFactory {

    BukkitCommandMapper createBukkitCommandMapper(BaseCommand baseCommand);
}
