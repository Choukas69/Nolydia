package com.nolydia.common.message;

public interface Message {

    void send(MessageReceiver sender);

    String getContent();
}
