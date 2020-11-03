package com.nolydia.lobby.commands.lang.show;

import com.google.inject.Inject;
import com.nolydia.common.command.annotations.Command;
import com.nolydia.common.command.execution.argument.ArgumentBuffer;
import com.nolydia.common.command.execution.CommandExecutor;
import com.nolydia.common.command.sender.CommandSender;
import com.nolydia.common.internalization.InternalizationMessage;
import com.nolydia.common.internalization.InternalizationService;
import com.nolydia.common.player.Player;

@Command(name = "show", description = "command.lang.set.description")
public class LangShowCommand implements CommandExecutor {

    private final InternalizationService internalizationService;

    @Inject
    public LangShowCommand(InternalizationService internalizationService) {
        this.internalizationService = internalizationService;
    }

    @Override
    public void execute(CommandSender sender, ArgumentBuffer buffer) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage(internalizationService.getMessage(player, new InternalizationMessage("locale.show", player.getLocale().getName())));
        }
    }
}
