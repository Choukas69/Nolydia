package com.nolydia.common.command;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommandRepository {

    private final List<BaseCommand> commands = new ArrayList<>();

    public void addCommand(BaseCommand command) {
        commands.add(command);
    }
}
