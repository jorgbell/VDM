package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbjx {
    private zzbig zza;
    private zzbkq zzb;
    private zzdvi zzc;
    private zzbkz zzd;
    private zzdsc zze;

    /* synthetic */ zzbjx(zzbjd zzbjd) {
    }

    public final zzbjx zza(zzbig zzbig) {
        this.zza = zzbig;
        return this;
    }

    public final zzbjx zzb(zzbkq zzbkq) {
        this.zzb = zzbkq;
        return this;
    }

    public final zzbid zzc() {
        zzeyr.zzc(this.zza, zzbig.class);
        zzeyr.zzc(this.zzb, zzbkq.class);
        if (this.zzc == null) {
            this.zzc = new zzdvi();
        }
        if (this.zzd == null) {
            this.zzd = new zzbkz();
        }
        if (this.zze == null) {
            this.zze = new zzdsc();
        }
        return new zzbko(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzbjd) null);
    }
}
