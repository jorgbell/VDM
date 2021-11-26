package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzqx implements Runnable {
    final /* synthetic */ zzit zza;
    final /* synthetic */ zzrc zzb;

    zzqx(zzrc zzrc, zzit zzit) {
        this.zzb = zzrc;
        this.zza = zzit;
    }

    public final void run() {
        this.zzb.zzb.zzl(this.zza);
    }
}
