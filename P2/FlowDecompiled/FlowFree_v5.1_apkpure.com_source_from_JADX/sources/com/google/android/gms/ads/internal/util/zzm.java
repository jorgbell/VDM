package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzm implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzr zzb;

    zzm(zzr zzr, Context context) {
        this.zzb = zzr;
        this.zza = context;
    }

    public final void run() {
        synchronized (this.zzb.zzf) {
            String unused = this.zzb.zzg = zzr.zzS(this.zza);
            this.zzb.zzf.notifyAll();
        }
    }
}
