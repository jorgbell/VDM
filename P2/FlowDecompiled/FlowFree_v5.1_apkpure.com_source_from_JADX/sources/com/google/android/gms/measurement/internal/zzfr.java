package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzfr implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgh zzc;

    zzfr(zzgh zzgh, zzaa zzaa, zzp zzp) {
        this.zzc = zzgh;
        this.zza = zzaa;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzH();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzT(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzR(this.zza, this.zzb);
        }
    }
}
