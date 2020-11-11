package com.nolydia.bukkit.api.command;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.nolydia.bukkit.api.command.sender.BukkitCommandSenderProvider;
import com.nolydia.common.command.AbstractCommandRepository;
import com.nolydia.common.command.sender.CommandSenderProvider;
import org.bukkit.command.CommandSender;

public class CommandModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AbstractCommandRepository.class).to(BukkitCommandRepository.class);
        bind(new TypeLiteral<CommandSenderProvider<CommandSender>>() {}).to(BukkitCommandSenderProvider.class);

        install(new FactoryModuleBuilder()
                .build(BukkitCommandMapperFactory.class));
    }
}
