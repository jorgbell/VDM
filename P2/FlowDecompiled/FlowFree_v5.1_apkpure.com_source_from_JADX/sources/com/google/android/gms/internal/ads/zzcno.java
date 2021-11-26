package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcno implements Runnable {
    private final zzcnp zza;
    private final String zzb;

    zzcno(zzcnp zzcnp, String str) {
        this.zza = zzcnp;
        this.zzb = str;
    }

    public final void run() {
        zzcnp zzcnp = this.zza;
        zzcnp.zzd.zza(this.zzb);
    }
}
