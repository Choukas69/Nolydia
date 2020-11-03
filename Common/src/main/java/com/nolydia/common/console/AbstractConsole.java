package com.nolydia.common.console;

import com.nolydia.common.internalization.InternalizationMessage;
import com.nolydia.common.internalization.InternalizationService;
import com.nolydia.common.internalization.Locale;

public abstract class AbstractConsole implements Console {

    private final InternalizationService internalizationService;

    public AbstractConsole(InternalizationService internalizationService) {
        this.internalizationService = internalizationService;
    }

    @Override
    public void sendMessage(InternalizationMessage message) {
        sendMessage(internalizationService.getMessage(this, message));
    }

    @Override
    public Locale getLocale() {
        return Locale.ENGLISH;
    }

    @Override
    public void setLocale(Locale locale) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasPermission(String permission) {
        return true;
    }
}
