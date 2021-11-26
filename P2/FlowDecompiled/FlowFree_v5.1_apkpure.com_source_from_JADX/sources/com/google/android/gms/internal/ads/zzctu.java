package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzctu implements zzbww, zzbvr, zzbui {
    private final zzdvn zza;
    private final zzdvo zzb;
    private final zzbaz zzc;

    public zzctu(zzdvn zzdvn, zzdvo zzdvo, zzbaz zzbaz) {
        this.zza = zzdvn;
        this.zzb = zzdvo;
        this.zzc = zzbaz;
    }

    public final void zzbC(zzym zzym) {
        zzdvn zzdvn = this.zza;
        zzdvn.zzc("action", "ftl");
        zzdvn.zzc("ftl", String.valueOf(zzym.zza));
        zzdvn.zzc("ed", zzym.zzc);
        this.zzb.zza(this.zza);
    }

    public final void zzbD() {
        zzdvo zzdvo = this.zzb;
        zzdvn zzdvn = this.zza;
        zzdvn.zzc("action", "loaded");
        zzdvo.zza(zzdvn);
    }

    public final void zzj(zzawc zzawc) {
        this.zza.zzf(zzawc.zza);
    }

    public final void zzq(zzdra zzdra) {
        this.zza.zzg(zzdra, this.zzc);
    }
}
