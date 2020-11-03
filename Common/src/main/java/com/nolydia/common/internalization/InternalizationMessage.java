package com.nolydia.common.internalization;

public class InternalizationMessage {

    private final String path;
    private final Object[] arguments;

    public InternalizationMessage(String path, Object... arguments) {
        this.path = path;
        this.arguments = arguments;
    }

    public String getPath() {
        return this.path;
    }

    public Object[] getArguments() {
        return this.arguments;
    }
}
