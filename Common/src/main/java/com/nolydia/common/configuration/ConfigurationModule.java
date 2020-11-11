package com.nolydia.common.configuration;

import com.google.inject.AbstractModule;
import com.nolydia.common.configuration.yaml.YAMLConfigurationFactory;

public class ConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ConfigurationFactory.class).to(YAMLConfigurationFactory.class);
    }
}
