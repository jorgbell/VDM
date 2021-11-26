package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzany implements zzank {
    private final zzaoq zza;
    private final zzaop zzb;
    private final zzanl zzc;

    zzany(zzaoq zzaoq, zzaop zzaop, zzanl zzanl) {
        this.zza = zzaoq;
        this.zzb = zzaop;
        this.zzc = zzanl;
    }

    public final void zza() {
        zzr.zza.postDelayed(new zzanz(this.zza, this.zzb, this.zzc), 10000);
    }
}
