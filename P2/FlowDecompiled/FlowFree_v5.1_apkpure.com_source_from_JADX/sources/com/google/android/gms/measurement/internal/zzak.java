package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzak implements Runnable {
    final /* synthetic */ zzgk zza;
    final /* synthetic */ zzal zzb;

    zzak(zzal zzal, zzgk zzgk) {
        this.zzb = zzal;
        this.zza = zzgk;
    }

    public final void run() {
        this.zza.zzat();
        if (zzz.zza()) {
            this.zza.zzav().zzh(this);
            return;
        }
        boolean zzc = this.zzb.zzc();
        long unused = this.zzb.zzd = 0;
        if (zzc) {
            this.zzb.zza();
        }
    }
}
