package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbjp implements zzdls {
    final /* synthetic */ zzbko zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzbjp(zzbko zzbko, zzbjd zzbjd) {
        this.zza = zzbko;
    }

    public final zzdlt zza() {
        zzeyr.zzc(this.zzb, Context.class);
        zzeyr.zzc(this.zzc, String.class);
        return new zzbjq(this.zza, this.zzb, this.zzc, (zzbjd) null);
    }

    public final /* bridge */ /* synthetic */ zzdls zzb(String str) {
        Objects.requireNonNull(str);
        this.zzc = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdls zzc(Context context) {
        Objects.requireNonNull(context);
        this.zzb = context;
        return this;
    }
}
