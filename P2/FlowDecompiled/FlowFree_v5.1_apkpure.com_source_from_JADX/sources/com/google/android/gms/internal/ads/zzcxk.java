package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcxk implements zzccx {
    private final zzbcb zza;

    zzcxk(zzbcb zzbcb) {
        this.zza = zzbcb;
    }

    public final void zza(boolean z, Context context) {
        zzbcb zzbcb = this.zza;
        try {
            zzs.zzb();
            zzn.zza(context, (AdOverlayInfoParcel) zzbcb.get(), true);
        } catch (Exception unused) {
        }
    }
}
