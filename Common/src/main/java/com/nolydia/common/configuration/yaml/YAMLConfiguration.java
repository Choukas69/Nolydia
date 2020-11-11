package com.nolydia.common.configuration.yaml;

import com.nolydia.common.configuration.AbstractConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class YAMLConfiguration extends AbstractConfiguration {

    private final Map<String, String> content = new HashMap<>();

    public YAMLConfiguration(Path path) {
        super(path);

        try (InputStream in = Files.newInputStream(path)) {
           Yaml yaml = new Yaml();

           Map<String, String> content = yaml.load(in);
           this.content.putAll(content);
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
