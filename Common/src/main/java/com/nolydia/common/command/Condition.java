package com.nolydia.common.command;

import com.nolydia.common.internalization.InternalizationMessage;

/**
 * TODO to comment
 */
public interface Condition<T> {

    default boolean abort(T o) {
        return !check(o);
    }

    boolean check(T o);

    InternalizationMessage getErrorMessage(T o);
}