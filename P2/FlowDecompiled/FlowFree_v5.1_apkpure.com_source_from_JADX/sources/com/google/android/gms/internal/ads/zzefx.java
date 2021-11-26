package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public interface zzefx extends ExecutorService {
    zzefw<?> zza(Runnable runnable);

    <T> zzefw<T> zzb(Callable<T> callable);
}
