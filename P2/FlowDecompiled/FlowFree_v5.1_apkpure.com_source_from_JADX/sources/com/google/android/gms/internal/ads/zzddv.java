package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzddv implements Runnable {
    private final zzddw zza;
    private final zzym zzb;

    zzddv(zzddw zzddw, zzym zzym) {
        this.zza = zzddw;
        this.zzb = zzym;
    }

    public final void run() {
        zzddw zzddw = this.zza;
        zzddw.zzc.zzd.zze().zzbC(this.zzb);
    }
}
