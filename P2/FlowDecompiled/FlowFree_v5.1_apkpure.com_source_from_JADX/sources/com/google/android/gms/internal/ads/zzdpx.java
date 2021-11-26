package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdpx implements Runnable {
    private final zzdps zza;

    private zzdpx(zzdps zzdps) {
        this.zza = zzdps;
    }

    static Runnable zza(zzdps zzdps) {
        return new zzdpx(zzdps);
    }

    public final void run() {
        this.zza.zzbD();
    }
}
