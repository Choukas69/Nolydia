package com.nolydia.common.command.annotations;

import com.nolydia.common.command.argument.Argument;
import com.nolydia.common.command.requirement.Requirement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {

    String name();

    String[] aliases() default {};

    String permission() default "";

    String description() default "";

    Class<? extends Requirement>[] requirements() default {};

    Class<? extends Argument<?>>[] arguments() default {};

    Class<?>[] subCommands() default {};
}
