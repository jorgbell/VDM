package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzgb implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgh zzc;

    zzgb(zzgh zzgh, zzas zzas, String str) {
        this.zzc = zzgh;
        this.zza = zzas;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzH();
        this.zzc.zza.zzv(this.zza, this.zzb);
    }
}
