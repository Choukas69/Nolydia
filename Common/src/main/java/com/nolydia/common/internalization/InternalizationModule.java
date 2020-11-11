package com.nolydia.common.internalization;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.nolydia.common.configuration.Configuration;
import com.nolydia.common.configuration.ConfigurationFactory;
import com.nolydia.common.plugin.annotations.DataFolder;
import com.nolydia.common.internalization.exceptions.UnsupportedLocaleException;
import com.nolydia.common.io.FileDirectory;
import com.nolydia.common.io.FileDirectoryFactory;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// TODO add a common file in the root of the plugins folder for shared translations
public class InternalizationModule extends AbstractModule {

    private static final Path INTERNALIZATION_DIRECTORY_PATH = Path.of("internalization");

    @Override
    protected void configure() {
        bind(InternalizationService.class).to(BasicInternalizationService.class);
    }

    @Provides
    @Named("InternalizationDirectory")
    public FileDirectory provideInternalizationDirectory(@DataFolder Path dataFolder, FileDirectoryFactory fileDirectoryFactory) {
        return fileDirectoryFactory.createFileDirectory(dataFolder.resolve(INTERNALIZATION_DIRECTORY_PATH));
    }

    @Provides
    @Named("TranslationMap")
    public Map<Locale, Map<String, String>> provideTranslationMap(@Named("InternalizationDirectory") FileDirectory directory, ConfigurationFactory configurationFactory) {
        Map<Locale, Map<String, String>> translations = new HashMap<>();

        directory.listDirectory().forEach(path -> {
            Configuration configuration = configurationFactory.createConfiguration(path);

            String localeTag = configuration.getName();
            Optional<Locale> optionalLocale = Locale.getByTag(localeTag);
            optionalLocale.ifPresentOrElse(
                    locale -> translations.put(locale, configuration.getContent()),
                    () -> {
                        throw new UnsupportedLocaleException(localeTag);
                    });
        });

        return translations;
    }
}
