package com.nolydia.common.command.sender.exceptions;

public class UnsupportedSenderException extends RuntimeException {

    public UnsupportedSenderException() {
        super("Unsupported sender");
    }
}
