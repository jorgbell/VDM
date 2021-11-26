package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzfs implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzgh zzb;

    zzfs(zzgh zzgh, zzaa zzaa) {
        this.zzb = zzgh;
        this.zza = zzaa;
    }

    public final void run() {
        this.zzb.zza.zzH();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzS(this.zza);
        } else {
            this.zzb.zza.zzQ(this.zza);
        }
    }
}
