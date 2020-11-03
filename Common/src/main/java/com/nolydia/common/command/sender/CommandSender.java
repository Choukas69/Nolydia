package com.nolydia.common.command.sender;

import com.nolydia.common.internalization.InternalizationMessage;
import com.nolydia.common.internalization.Internationalizable;
import com.nolydia.common.message.MessageReceiver;
import com.nolydia.common.permission.PermissionEntity;

public interface CommandSender extends Internationalizable, PermissionEntity, MessageReceiver {

    void sendMessage(InternalizationMessage message);
}
