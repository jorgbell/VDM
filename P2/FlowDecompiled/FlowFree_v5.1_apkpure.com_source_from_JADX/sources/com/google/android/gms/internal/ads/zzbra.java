package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbra {
    private final zzdra zza;
    private final zzdqo zzb;
    private final String zzc;

    public zzbra(zzdra zzdra, zzdqo zzdqo, String str) {
        this.zza = zzdra;
        this.zzb = zzdqo;
        this.zzc = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzdra zza() {
        return this.zza;
    }

    public final zzdqo zzb() {
        return this.zzb;
    }

    public final zzdqr zzc() {
        return this.zza.zzb.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
