package com.nolydia.common.plugin.configuration;

import com.google.inject.Module;

import java.util.List;

public interface PluginConfiguration {

    List<Module> getModules();
}
