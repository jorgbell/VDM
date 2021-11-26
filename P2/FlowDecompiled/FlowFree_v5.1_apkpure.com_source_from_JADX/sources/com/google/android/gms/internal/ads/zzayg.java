package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzayg implements Runnable {
    private final zzayl zza;
    private final Bitmap zzb;

    zzayg(zzayl zzayl, Bitmap bitmap) {
        this.zza = zzayl;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
