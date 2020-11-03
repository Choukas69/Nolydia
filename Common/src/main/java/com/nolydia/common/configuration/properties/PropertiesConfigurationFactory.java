package com.nolydia.common.configuration.properties;

import com.nolydia.common.configuration.ConfigurationFactory;

import java.nio.file.Path;

public class PropertiesConfigurationFactory implements ConfigurationFactory {

    public PropertiesConfiguration createConfiguration(Path path) {
        return new PropertiesConfiguration(path);
    }
}
