package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxg {
    private final zzdyn zza;
    private final String zzb;
    private final zzdwu zzc;
    private final String zzd;

    public zzdxg(View view, zzdwu zzdwu, String str) {
        this.zza = new zzdyn(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzdwu;
        this.zzd = str;
    }

    public final zzdyn zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzdwu zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
