package com.nolydia.common.configuration;

import java.util.Map;

public interface Configuration {

    String getName();

    String get(String path);

    Map<String, String> getContent();
}
