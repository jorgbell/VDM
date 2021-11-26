package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhl implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzhr zzb;

    zzhl(zzhr zzhr, Boolean bool) {
        this.zzb = zzhr;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzY(this.zza, true);
    }
}
