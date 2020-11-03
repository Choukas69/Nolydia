package com.nolydia.common.listener;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.nolydia.common.utils.Types;

public class ListenerBinder<T> {

    private final Multibinder<T> multibinder;

    public ListenerBinder(Binder binder) {
        this.multibinder = Multibinder.newSetBinder(binder, Types.resolve(new TypeLiteral<T>() {
        }, getClass()));
        //this.multibinder = Multibinder.newSetBinder(binder, new TypeLiteral<>() {});
    }

    public void bind(Class<? extends T> listener) {
        multibinder.addBinding().to(listener);
    }
}
