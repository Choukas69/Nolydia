package com.nolydia.common.command.execution.argument;

import java.util.Optional;

public interface ArgumentBuffer {

    <T> T readArgument();

    <T> Optional<T> readOptionalArgument();
}
