package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbkh implements zzdqh {
    final /* synthetic */ zzbko zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzbkh(zzbko zzbko, zzbjd zzbjd) {
        this.zza = zzbko;
    }

    public final zzdqi zza() {
        zzeyr.zzc(this.zzb, Context.class);
        return new zzbki(this.zza, this.zzb, this.zzc, (zzbjd) null);
    }

    public final /* bridge */ /* synthetic */ zzdqh zzb(String str) {
        this.zzc = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdqh zzc(Context context) {
        Objects.requireNonNull(context);
        this.zzb = context;
        return this;
    }
}
