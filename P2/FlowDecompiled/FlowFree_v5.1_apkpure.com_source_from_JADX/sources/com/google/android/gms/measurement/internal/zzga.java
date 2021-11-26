package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzga implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgh zzc;

    zzga(zzgh zzgh, zzas zzas, zzp zzp) {
        this.zzc = zzgh;
        this.zza = zzas;
        this.zzb = zzp;
    }

    public final void run() {
        zzas zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzH();
        this.zzc.zza.zzy(zzb2, this.zzb);
    }
}
