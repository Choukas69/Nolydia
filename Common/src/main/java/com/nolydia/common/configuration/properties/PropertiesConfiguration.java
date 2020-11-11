package com.nolydia.common.configuration.properties;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.nolydia.common.configuration.AbstractConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesConfiguration extends AbstractConfiguration {

    private final Map<String, String> content = new HashMap<>();

    @Inject
    public PropertiesConfiguration(@Assisted Path path) {
        super(path);

        try (InputStream in = Files.newInputStream(path)) {
            Properties content = new Properties();
            content.load(in);

            this.content.putAll(Maps.fromProperties(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String get(String path) {
        return content.get(path);
    }

    @Override
    public Map<String, String> getContent() {
        return content;
    }
}
