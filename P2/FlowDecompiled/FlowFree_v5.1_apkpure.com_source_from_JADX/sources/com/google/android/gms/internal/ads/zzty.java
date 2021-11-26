package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzty implements Runnable {
    private final zzbcb zza;
    private final Future zzb;

    zzty(zzbcb zzbcb, Future future) {
        this.zza = zzbcb;
        this.zzb = future;
    }

    public final void run() {
        zzbcb zzbcb = this.zza;
        Future future = this.zzb;
        if (zzbcb.isCancelled()) {
            future.cancel(true);
        }
    }
}
