package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzckq implements zzbhr {
    private final zzbcb zza;

    zzckq(zzbcb zzbcb) {
        this.zza = zzbcb;
    }

    public final void zza(boolean z) {
        zzbcb zzbcb = this.zza;
        if (z) {
            zzbcb.zzc(null);
        } else {
            zzbcb.zzd(new Exception("Ad Web View failed to load."));
        }
    }
}
