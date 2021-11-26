package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbkf implements zzdov {
    final /* synthetic */ zzbko zza;
    private Context zzb;
    private String zzc;
    private zzyx zzd;

    /* synthetic */ zzbkf(zzbko zzbko, zzbjd zzbjd) {
        this.zza = zzbko;
    }

    public final zzdow zza() {
        zzeyr.zzc(this.zzb, Context.class);
        zzeyr.zzc(this.zzc, String.class);
        zzeyr.zzc(this.zzd, zzyx.class);
        return new zzbkg(this.zza, this.zzb, this.zzc, this.zzd, (zzbjd) null);
    }

    public final /* bridge */ /* synthetic */ zzdov zzb(zzyx zzyx) {
        Objects.requireNonNull(zzyx);
        this.zzd = zzyx;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdov zzc(String str) {
        Objects.requireNonNull(str);
        this.zzc = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdov zzd(Context context) {
        Objects.requireNonNull(context);
        this.zzb = context;
        return this;
    }
}
