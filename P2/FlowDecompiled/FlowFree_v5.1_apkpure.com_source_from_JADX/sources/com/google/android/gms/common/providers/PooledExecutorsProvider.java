package com.google.android.gms.common.providers;

import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.ScheduledExecutorService;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface PooledExecutorFactory {
        @RecentlyNonNull
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    @RecentlyNonNull
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zza == null) {
                zza = new zza();
            }
            pooledExecutorFactory = zza;
        }
        return pooledExecutorFactory;
    }
}
