package com.nolydia.common.utils;

import com.google.common.reflect.TypeToken;
import com.google.inject.TypeLiteral;

public final class Types {

    @SuppressWarnings("unchecked")
    public static <T> TypeLiteral<T> toLiteral(TypeToken<T> typeToken) {
        return (TypeLiteral<T>) TypeLiteral.get(typeToken.getType());
    }

    @SuppressWarnings("unchecked")
    public static <T> TypeLiteral<T> resolve(TypeLiteral<T> type, Class<?> declaringClass) {
        return (TypeLiteral<T>) toLiteral(TypeToken.of(declaringClass).resolveType(type.getType()));
    }
}
