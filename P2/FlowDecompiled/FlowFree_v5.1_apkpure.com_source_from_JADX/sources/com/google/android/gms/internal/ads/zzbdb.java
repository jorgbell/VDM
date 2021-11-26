package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbdb implements Runnable {
    private final zzbdf zza;
    private final boolean zzb;

    zzbdb(zzbdf zzbdf, boolean z) {
        this.zza = zzbdf;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzE(this.zzb);
    }
}
