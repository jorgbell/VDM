package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhe implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzhr zzd;

    zzhe(zzhr zzhr, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzd = zzhr;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final void run() {
        this.zzd.zzs.zzy().zzn(this.zza, (String) null, this.zzb, this.zzc);
    }
}
