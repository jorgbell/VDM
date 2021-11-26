package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbde implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzbdf zzb;

    zzbde(zzbdf zzbdf, boolean z) {
        this.zzb = zzbdf;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzH("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
