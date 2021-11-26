package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzkb implements Runnable {
    final /* synthetic */ zzkj zza;
    final /* synthetic */ zzki zzb;

    zzkb(zzki zzki, zzkj zzkj) {
        this.zzb = zzki;
        this.zza = zzkj;
    }

    public final void run() {
        zzki.zzX(this.zzb, this.zza);
        this.zzb.zzc();
    }
}
