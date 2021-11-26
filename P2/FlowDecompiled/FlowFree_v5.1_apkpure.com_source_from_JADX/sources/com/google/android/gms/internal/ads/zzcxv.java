package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcxv implements Runnable {
    private final zzckx zza;

    private zzcxv(zzckx zzckx) {
        this.zza = zzckx;
    }

    static Runnable zza(zzckx zzckx) {
        return new zzcxv(zzckx);
    }

    public final void run() {
        this.zza.zzb();
    }
}
