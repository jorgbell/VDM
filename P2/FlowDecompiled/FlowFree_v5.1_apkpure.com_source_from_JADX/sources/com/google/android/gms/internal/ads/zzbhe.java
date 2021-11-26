package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbhe implements Runnable {
    private final zzbhg zza;
    private final String zzb;

    zzbhe(zzbhg zzbhg, String str) {
        this.zza = zzbhg;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
