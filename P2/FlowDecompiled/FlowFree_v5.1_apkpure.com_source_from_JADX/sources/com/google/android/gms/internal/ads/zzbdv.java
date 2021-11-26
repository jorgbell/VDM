package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbdv implements Runnable {
    private final zzbef zza;
    private final String zzb;

    zzbdv(zzbef zzbef, String str) {
        this.zza = zzbef;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzE(this.zzb);
    }
}
