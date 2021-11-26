package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbjy implements zzcop {
    final /* synthetic */ zzbko zza;
    private Context zzb;
    private zzalk zzc;

    /* synthetic */ zzbjy(zzbko zzbko, zzbjd zzbjd) {
        this.zza = zzbko;
    }

    public final zzcoq zza() {
        zzeyr.zzc(this.zzb, Context.class);
        zzeyr.zzc(this.zzc, zzalk.class);
        return new zzbkb(this.zza, this.zzb, this.zzc, (zzbjd) null);
    }

    public final /* bridge */ /* synthetic */ zzcop zzb(zzalk zzalk) {
        Objects.requireNonNull(zzalk);
        this.zzc = zzalk;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzcop zzc(Context context) {
        Objects.requireNonNull(context);
        this.zzb = context;
        return this;
    }
}
