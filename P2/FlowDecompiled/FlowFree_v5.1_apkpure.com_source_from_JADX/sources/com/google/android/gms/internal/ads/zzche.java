package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzche implements zzecb<zzy, Bitmap> {
    final /* synthetic */ double zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzchf zzc;

    zzche(zzchf zzchf, double d, boolean z) {
        this.zzc = zzchf;
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        return zzchf.zzb(this.zzc, ((zzy) obj).zzb, this.zza, this.zzb);
    }
}
