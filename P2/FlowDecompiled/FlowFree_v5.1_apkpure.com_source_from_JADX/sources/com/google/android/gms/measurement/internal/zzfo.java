package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzfo implements Runnable {
    final /* synthetic */ zzgr zza;
    final /* synthetic */ zzfp zzb;

    zzfo(zzfp zzfp, zzgr zzgr) {
        this.zzb = zzfp;
        this.zza = zzgr;
    }

    public final void run() {
        zzfp.zzO(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
