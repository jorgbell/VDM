package com.google.android.gms.internal.ads;

import android.graphics.Rect;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcko implements zzri {
    private final zzbgf zza;

    zzcko(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    public final void zzc(zzrh zzrh) {
        zzbht zzR = this.zza.zzR();
        Rect rect = zzrh.zzd;
        zzR.zza(rect.left, rect.top, false);
    }
}
