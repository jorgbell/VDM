package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbdx implements Runnable {
    private final zzbef zza;
    private final String zzb;

    zzbdx(zzbef zzbef, String str) {
        this.zza = zzbef;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzM(this.zzb);
    }
}
