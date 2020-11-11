package com.nolydia.common.command;

import com.nolydia.common.command.execution.CommandExecutor;

public interface BaseCommandFactory {

    BaseCommand createCommand(CommandDetails details, CommandExecutor executor);
}
