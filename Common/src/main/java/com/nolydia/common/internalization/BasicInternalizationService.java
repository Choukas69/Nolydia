package com.nolydia.common.internalization;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.nolydia.common.internalization.exceptions.UnsupportedLocaleException;

import java.util.Map;

public class BasicInternalizationService implements InternalizationService {

    private final Map<Locale, Map<String, String>> translations;

    @Inject
    public BasicInternalizationService(@Named("TranslationMap") Map<Locale, Map<String, String>> translations) {
        this.translations = translations;
    }

    @Override
    public String getMessage(Internationalizable internationalizable, InternalizationMessage internalizationMessage) {
        return this.getMessage(internationalizable.getLocale(), internalizationMessage);
    }

    private String getMessage(Locale locale, InternalizationMessage internalizationMessage) {
        if (!this.translations.containsKey(locale)) {
            throw new UnsupportedLocaleException(locale.getTag());
        }

        Map<String, String> translations = this.translations.get(locale);

        String path = internalizationMessage.getPath();
        if (!translations.containsKey(path)) {
            throw new IllegalArgumentException(String.format("No message with path %s has been found", path));
        }

        String message = translations.get(path);
        message = String.format(message, internalizationMessage.getArguments());

        return message;
    }
}
