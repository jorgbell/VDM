package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdvk implements Runnable {
    private final zzdvl zza;
    private final String zzb;

    zzdvk(zzdvl zzdvl, String str) {
        this.zza = zzdvl;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
