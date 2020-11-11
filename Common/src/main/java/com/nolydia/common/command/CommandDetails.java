package com.nolydia.common.command;

import com.nolydia.common.internalization.InternalizationMessage;

import java.util.List;

public class CommandDetails {

    private final String name;
    private final String permission;
    private final List<String> aliases;
    private final InternalizationMessage description;

    public CommandDetails(String name,
                          String permission,
                          List<String> aliases,
                          InternalizationMessage description) {
        this.name = name;
        this.permission = permission;
        this.aliases = aliases;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public InternalizationMessage getDescription() {
        return description;
    }
}
