package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbda implements Runnable {
    private final zzbcy zza;

    private zzbda(zzbcy zzbcy) {
        this.zza = zzbcy;
    }

    static Runnable zza(zzbcy zzbcy) {
        return new zzbda(zzbcy);
    }

    public final void run() {
        this.zza.zzd();
    }
}
