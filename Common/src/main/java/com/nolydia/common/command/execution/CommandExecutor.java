package com.nolydia.common.command.execution;

import com.nolydia.common.command.execution.argument.ArgumentBuffer;
import com.nolydia.common.command.sender.CommandSender;

public interface CommandExecutor {

    void execute(CommandSender sender, ArgumentBuffer buffer);
}
