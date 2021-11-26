package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzk implements Runnable {
    private final zzl zza;
    private final Drawable zzb;

    zzk(zzl zzl, Drawable drawable) {
        this.zza = zzl;
        this.zzb = drawable;
    }

    public final void run() {
        zzl zzl = this.zza;
        zzl.zza.zzb.getWindow().setBackgroundDrawable(this.zzb);
    }
}
