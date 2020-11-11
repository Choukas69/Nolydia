package com.nolydia.bungee.api.console;

import com.google.inject.Inject;
import com.nolydia.common.console.AbstractConsole;
import com.nolydia.common.internalization.InternalizationService;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;

public class BungeeConsole extends AbstractConsole {

    @Inject
    public BungeeConsole(InternalizationService internalizationService) {
        super(internalizationService);
    }

    @Override
    public void sendMessage(BaseComponent[] components) {
        ProxyServer.getInstance().getConsole().sendMessage(components);
    }
}
