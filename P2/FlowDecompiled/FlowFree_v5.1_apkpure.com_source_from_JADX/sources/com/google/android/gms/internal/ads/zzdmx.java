package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdmx implements Runnable {
    private final zzdda zza;

    private zzdmx(zzdda zzdda) {
        this.zza = zzdda;
    }

    static Runnable zza(zzdda zzdda) {
        return new zzdmx(zzdda);
    }

    public final void run() {
        this.zza.zzbD();
    }
}
