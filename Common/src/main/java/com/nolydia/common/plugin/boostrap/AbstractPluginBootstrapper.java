package com.nolydia.common.plugin.boostrap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.nolydia.common.command.CommandPostExecutor;
import com.nolydia.common.listener.ListenerPostExecutor;
import com.nolydia.common.plugin.configuration.PluginConfiguration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractPluginBootstrapper {

    public Injector boostrap(Module bootstrapModule, PluginConfiguration configuration) {
        Injector injector = null;

        try {
            injector = Guice.createInjector(Stream
                    .concat(Stream.of(bootstrapModule),
                            configuration.getModules().stream())
                    .collect(Collectors.toList()));

            injector.getInstance(CommandPostExecutor.class).registerCommands();
            injector.getInstance(ListenerPostExecutor.class).registerListeners();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return injector;
    }
}
