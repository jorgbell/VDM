package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbjz implements zzcoh {
    final /* synthetic */ zzbkb zza;
    private Long zzb;
    private String zzc;

    /* synthetic */ zzbjz(zzbkb zzbkb, zzbjd zzbjd) {
        this.zza = zzbkb;
    }

    public final zzcoi zza() {
        zzeyr.zzc(this.zzb, Long.class);
        zzeyr.zzc(this.zzc, String.class);
        return new zzbka(this.zza, this.zzb, this.zzc, (zzbjd) null);
    }

    public final /* bridge */ /* synthetic */ zzcoh zzb(String str) {
        Objects.requireNonNull(str);
        this.zzc = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzcoh zzc(long j) {
        this.zzb = Long.valueOf(j);
        return this;
    }
}
