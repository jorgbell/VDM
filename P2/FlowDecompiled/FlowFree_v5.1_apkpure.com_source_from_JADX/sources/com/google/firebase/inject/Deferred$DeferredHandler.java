package com.google.firebase.inject;

public interface Deferred$DeferredHandler<T> {
    void handle(Provider<T> provider);
}
