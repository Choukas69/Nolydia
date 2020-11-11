package com.nolydia.common.command.requirement.provided;

import com.nolydia.common.command.Condition;
import com.nolydia.common.command.requirement.Requirement;
import com.nolydia.common.command.sender.CommandSender;
import com.nolydia.common.internalization.InternalizationMessage;
import com.nolydia.common.player.Player;

import java.util.Collections;
import java.util.List;

public class SenderIsPlayerRequirement implements Requirement {

    @Override
    public List<Condition<CommandSender>> getConditions() {
        return Collections.singletonList(new Condition<>() {
            @Override
            public boolean check(CommandSender o) {
                return o instanceof Player;
            }

            @Override
            public InternalizationMessage getErrorMessage(CommandSender o) {
                return new InternalizationMessage("requirement.sender_is_player");
            }
        });
    }
}
