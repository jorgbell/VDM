package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzfj implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzfm zza;
    private final String zzb;

    public zzfj(zzfm zzfm, String str) {
        this.zza = zzfm;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzs.zzau().zzb().zzb(this.zzb, th);
    }
}
