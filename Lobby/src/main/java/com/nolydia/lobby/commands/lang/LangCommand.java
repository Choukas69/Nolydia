package com.nolydia.lobby.commands.lang;

import com.nolydia.common.command.annotations.Command;
import com.nolydia.lobby.commands.lang.set.LangSetCommand;
import com.nolydia.lobby.commands.lang.show.LangShowCommand;

@Command(
        name = "lang",
        subCommands = {
                LangSetCommand.class,
                LangShowCommand.class
        }
)
public class LangCommand {

}
