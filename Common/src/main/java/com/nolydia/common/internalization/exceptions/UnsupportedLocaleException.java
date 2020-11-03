package com.nolydia.common.internalization.exceptions;

public class UnsupportedLocaleException extends RuntimeException {

    public UnsupportedLocaleException(String localeName) {
        super(String.format("Locale %s is currently unsupported", localeName));
    }
}
