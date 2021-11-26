package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcse implements zzbww {
    private final Context zza;
    private final zzazt zzb;

    zzcse(Context context, zzazt zzazt) {
        this.zza = context;
        this.zzb = zzazt;
    }

    public final void zzj(zzawc zzawc) {
    }

    public final void zzq(zzdra zzdra) {
        if (!TextUtils.isEmpty(zzdra.zzb.zzb.zzd)) {
            this.zzb.zzd(this.zza, zzdra.zza.zza.zzd);
            this.zzb.zzp(this.zza, zzdra.zzb.zzb.zzd);
        }
    }
}
