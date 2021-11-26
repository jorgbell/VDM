package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zznm implements Runnable {
    final /* synthetic */ IOException zza;
    final /* synthetic */ zznq zzb;

    zznm(zznq zznq, IOException iOException) {
        this.zzb = zznq;
        this.zza = iOException;
    }

    public final void run() {
        this.zzb.zze.zzi(this.zza);
    }
}
