package com.nolydia.lobby.commands.lang.set.arguments;

import com.nolydia.common.command.Condition;
import com.nolydia.common.command.argument.Argument;
import com.nolydia.common.command.sender.CommandSender;
import com.nolydia.common.internalization.InternalizationMessage;
import com.nolydia.common.internalization.Locale;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LocaleArgument implements Argument<Locale> {

    private Locale locale;

    @Override
    public InternalizationMessage getName() {
        return new InternalizationMessage("argument.locale");
    }

    @Override
    public List<Condition<String>> getConditions(CommandSender sender) {
        return Collections.singletonList(new Condition<>() {
            @Override
            public boolean check(String o) {
                Optional<Locale> optionalLocale = Locale.getByName(o);
                optionalLocale.ifPresent(value -> locale = value);

                return optionalLocale.isPresent();
            }

            @Override
            public InternalizationMessage getErrorMessage(String o) {
                return new InternalizationMessage("argument.locale.error");
            }
        });
    }

    @Override
    public Locale get(String argument) {
        return locale;
    }
}
