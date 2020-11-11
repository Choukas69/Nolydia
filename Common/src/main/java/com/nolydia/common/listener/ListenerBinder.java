package com.nolydia.common.listener;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

public class ListenerBinder<T> {

    private final Multibinder<T> multibinder;

    public ListenerBinder(Binder binder, Class<T> clazz) {
        this.multibinder = Multibinder.newSetBinder(binder, clazz);
    }

    public void bind(Class<? extends T> listener) {
        multibinder.addBinding().to(listener);
    }
}
