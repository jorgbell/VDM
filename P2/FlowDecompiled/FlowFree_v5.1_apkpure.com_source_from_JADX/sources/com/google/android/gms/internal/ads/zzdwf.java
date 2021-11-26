package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdwf implements Runnable {
    private final zzdwg zza;
    private final String zzb;

    zzdwf(zzdwg zzdwg, String str) {
        this.zza = zzdwg;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
