package com.google.android.gms.common.util.concurrent;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class NamedThreadFactory implements ThreadFactory {
    private final String zza;
    private final ThreadFactory zzb = Executors.defaultThreadFactory();

    public NamedThreadFactory(@RecentlyNonNull String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
    }

    @RecentlyNonNull
    public final Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread newThread = this.zzb.newThread(new zza(runnable, 0));
        newThread.setName(this.zza);
        return newThread;
    }
}
