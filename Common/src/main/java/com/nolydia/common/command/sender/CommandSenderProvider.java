package com.nolydia.common.command.sender;

public interface CommandSenderProvider<T> {

    CommandSender provide(T sender);
}
