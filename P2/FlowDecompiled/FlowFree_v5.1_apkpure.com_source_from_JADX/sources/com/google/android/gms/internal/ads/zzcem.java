package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcem implements Runnable {
    private final zzcff zza;

    private zzcem(zzcff zzcff) {
        this.zza = zzcff;
    }

    static Runnable zza(zzcff zzcff) {
        return new zzcem(zzcff);
    }

    public final void run() {
        this.zza.zzu();
    }
}
