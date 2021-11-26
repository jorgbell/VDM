package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzfx implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgh zzb;

    zzfx(zzgh zzgh, zzp zzp) {
        this.zzb = zzgh;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzH();
        this.zzb.zza.zzJ(this.zza);
    }
}
