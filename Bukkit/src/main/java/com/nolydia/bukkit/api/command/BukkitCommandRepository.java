package com.nolydia.bukkit.api.command;

import com.google.inject.Inject;
import com.nolydia.common.command.AbstractCommandRepository;
import com.nolydia.common.command.BaseCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;

public class BukkitCommandRepository extends AbstractCommandRepository {

    private final BukkitCommandMapperFactory mapperFactory;

    private final CommandMap commandMap;

    @Inject
    public BukkitCommandRepository(BukkitCommandMapperFactory mapperFactory) throws Exception {
        this.mapperFactory = mapperFactory;

        Field commandMapField = SimplePluginManager.class.getDeclaredField("commandMap");
        commandMapField.setAccessible(true);

        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        this.commandMap = (CommandMap) commandMapField.get(pluginManager);
    }

    @Override
    public void addCommand(BaseCommand command) {
        super.addCommand(command);
        this.commandMap.register("", mapperFactory.createBukkitCommandMapper(command));
    }
}
