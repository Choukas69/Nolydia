package com.nolydia.common.command.requirement;

import com.nolydia.common.command.Condition;
import com.nolydia.common.command.sender.CommandSender;

import java.util.List;

/**
 * TODO to comment
 */
public interface Requirement {

    List<Condition<CommandSender>> getConditions();
}
