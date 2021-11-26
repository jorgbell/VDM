package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzha implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhr zzb;

    zzha(zzhr zzhr, long j) {
        this.zzb = zzhr;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzG(this.zza, true);
        this.zzb.zzs.zzy().zzv(new AtomicReference());
    }
}
