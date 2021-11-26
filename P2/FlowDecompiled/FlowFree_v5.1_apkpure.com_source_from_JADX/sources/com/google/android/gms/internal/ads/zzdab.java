package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdab implements Runnable {
    private final zzckx zza;

    private zzdab(zzckx zzckx) {
        this.zza = zzckx;
    }

    static Runnable zza(zzckx zzckx) {
        return new zzdab(zzckx);
    }

    public final void run() {
        this.zza.zzb();
    }
}
