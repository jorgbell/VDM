package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbdd implements Runnable {
    final /* synthetic */ zzbdf zza;

    zzbdd(zzbdf zzbdf) {
        this.zza = zzbdf;
    }

    public final void run() {
        this.zza.zzH("surfaceDestroyed", new String[0]);
    }
}
