package com.nolydia.common.listener;

import com.google.inject.Inject;

import java.util.Set;

public class ListenerPostExecutorImpl<T> implements ListenerPostExecutor {

    private final Set<T> listeners;
    private final ListenerRegisterer<T> registerer;

    @Inject
    public ListenerPostExecutorImpl(Set<T> listeners, ListenerRegisterer<T> registerer) {
        this.listeners = listeners;
        this.registerer = registerer;
    }

    @Override
    public void registerListeners() {
        listeners.forEach(registerer::registerListener);
    }
}
