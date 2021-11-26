package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzgd implements Runnable {
    final /* synthetic */ zzkl zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgh zzc;

    zzgd(zzgh zzgh, zzkl zzkl, zzp zzp) {
        this.zzc = zzgh;
        this.zza = zzkl;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzH();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzL(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzK(this.zza, this.zzb);
        }
    }
}
