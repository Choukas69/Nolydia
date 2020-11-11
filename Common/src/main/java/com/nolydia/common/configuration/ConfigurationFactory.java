package com.nolydia.common.configuration;

import java.nio.file.Path;

public interface ConfigurationFactory {

    Configuration createConfiguration(Path path);
}
