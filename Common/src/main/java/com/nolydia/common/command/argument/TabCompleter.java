package com.nolydia.common.command.argument;

import com.nolydia.common.command.sender.CommandSender;

import java.util.Collection;
import java.util.Collections;

/**
 * TODO to comment
 * @param <T>
 */
public interface TabCompleter<T> {

    default Collection<T> tabComplete(CommandSender sender) {
        return Collections.emptyList();
    }
}
