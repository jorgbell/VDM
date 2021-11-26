package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzanz implements Runnable {
    private final zzaoq zza;
    private final zzaop zzb;
    private final zzanl zzc;

    zzanz(zzaoq zzaoq, zzaop zzaop, zzanl zzanl) {
        this.zza = zzaoq;
        this.zzb = zzaop;
        this.zzc = zzanl;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc);
    }
}
