package com.nolydia.common.listener;

import com.google.inject.TypeLiteral;
import com.nolydia.common.utils.Types;

public class TA<T> extends TypeLiteral<T> {

    public TypeLiteral<T> in(Class<?> clazz) {
        return Types.resolve(this, clazz);
    }
}
