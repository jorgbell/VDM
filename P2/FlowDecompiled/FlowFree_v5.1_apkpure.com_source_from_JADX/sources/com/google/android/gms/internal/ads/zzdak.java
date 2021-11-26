package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdak implements zzccx {
    private final zzcvz zza;

    zzdak(zzcvz zzcvz) {
        this.zza = zzcvz;
    }

    public final void zza(boolean z, Context context) {
        zzcvz zzcvz = this.zza;
        try {
            ((zzdrx) zzcvz.zzb).zzs(z);
            ((zzdrx) zzcvz.zzb).zzm();
        } catch (zzdrl e) {
            zzbbk.zzj("Cannot show rewarded video.", e);
            throw new zzccw(e.getCause());
        }
    }
}
