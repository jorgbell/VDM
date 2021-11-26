package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ExecutionModule_ExecutorFactory INSTANCE = new ExecutionModule_ExecutorFactory();
    }

    public Executor get() {
        return executor();
    }

    public static ExecutionModule_ExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Executor executor() {
        Executor executor = ExecutionModule.executor();
        Preconditions.checkNotNull(executor, "Cannot return null from a non-@Nullable @Provides method");
        return executor;
    }
}
