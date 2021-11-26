package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();
    }

    public Clock get() {
        return uptimeClock();
    }

    public static TimeModule_UptimeClockFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Clock uptimeClock() {
        Clock uptimeClock = TimeModule.uptimeClock();
        Preconditions.checkNotNull(uptimeClock, "Cannot return null from a non-@Nullable @Provides method");
        return uptimeClock;
    }
}
