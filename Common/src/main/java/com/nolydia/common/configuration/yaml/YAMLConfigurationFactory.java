package com.nolydia.common.configuration.yaml;

import com.nolydia.common.configuration.ConfigurationFactory;

import java.nio.file.Path;

public class YAMLConfigurationFactory implements ConfigurationFactory {

    public YAMLConfiguration createConfiguration(Path path) {
        return new YAMLConfiguration(path);
    }
}
