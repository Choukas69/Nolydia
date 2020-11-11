package com.nolydia.lobby.commands.lang.set;

import com.google.inject.Inject;
import com.nolydia.common.command.annotations.Command;
import com.nolydia.common.command.execution.CommandExecutor;
import com.nolydia.common.command.execution.argument.ArgumentBuffer;
import com.nolydia.common.command.sender.CommandSender;
import com.nolydia.common.internalization.InternalizationMessage;
import com.nolydia.common.internalization.InternalizationService;
import com.nolydia.common.internalization.Locale;
import com.nolydia.common.player.Player;
import com.nolydia.lobby.commands.lang.set.arguments.LocaleArgument;

@Command(
        name = "set",
        description = "command.lang.set.description",
        //requirements = {SenderIsPlayerRequirement.class},
        arguments = {LocaleArgument.class}
)
public class LangSetCommand implements CommandExecutor {

    private final InternalizationService internalizationService;

    @Inject
    public LangSetCommand(InternalizationService internalizationService) {
        this.internalizationService = internalizationService;
    }

    @Override
    public void execute(CommandSender sender, ArgumentBuffer buffer) {
        Player player = (Player) sender;
        Locale locale = buffer.readArgument();

        player.setLocale(locale);
        player.sendMessage(internalizationService.getMessage(player, new InternalizationMessage("locale.change")));
    }
}