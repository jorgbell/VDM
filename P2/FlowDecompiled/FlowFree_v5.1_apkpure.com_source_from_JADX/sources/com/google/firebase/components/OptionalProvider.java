package com.google.firebase.components;

import com.google.firebase.inject.Deferred$DeferredHandler;
import com.google.firebase.inject.Provider;

class OptionalProvider<T> implements Provider<T> {
    private static final Provider<Object> EMPTY_PROVIDER = OptionalProvider$$Lambda$5.lambdaFactory$();
    private static final Deferred$DeferredHandler<Object> NOOP_HANDLER = OptionalProvider$$Lambda$4.lambdaFactory$();
    private volatile Provider<T> delegate;
    private Deferred$DeferredHandler<T> handler;

    static /* synthetic */ void lambda$static$0(Provider provider) {
    }

    static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    private OptionalProvider(Deferred$DeferredHandler<T> deferred$DeferredHandler, Provider<T> provider) {
        this.handler = deferred$DeferredHandler;
        this.delegate = provider;
    }

    static <T> OptionalProvider<T> empty() {
        return new OptionalProvider<>(NOOP_HANDLER, EMPTY_PROVIDER);
    }

    public T get() {
        return this.delegate.get();
    }

    /* access modifiers changed from: package-private */
    public void set(Provider<T> provider) {
        Deferred$DeferredHandler<T> deferred$DeferredHandler;
        if (this.delegate == EMPTY_PROVIDER) {
            synchronized (this) {
                deferred$DeferredHandler = this.handler;
                this.handler = null;
                this.delegate = provider;
            }
            deferred$DeferredHandler.handle(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }
}
