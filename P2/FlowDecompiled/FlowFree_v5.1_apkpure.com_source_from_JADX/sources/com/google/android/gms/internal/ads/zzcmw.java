package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcmw implements zzbww, zzbvr, zzbui {
    private final zzcne zza;
    private final zzcnn zzb;

    public zzcmw(zzcne zzcne, zzcnn zzcnn) {
        this.zza = zzcne;
        this.zzb = zzcnn;
    }

    public final void zzbC(zzym zzym) {
        this.zza.zzc().put("action", "ftl");
        this.zza.zzc().put("ftl", String.valueOf(zzym.zza));
        this.zza.zzc().put("ed", zzym.zzc);
        this.zzb.zzb(this.zza.zzc());
    }

    public final void zzbD() {
        this.zza.zzc().put("action", "loaded");
        this.zzb.zzb(this.zza.zzc());
    }

    public final void zzj(zzawc zzawc) {
        this.zza.zzb(zzawc.zza);
    }

    public final void zzq(zzdra zzdra) {
        this.zza.zza(zzdra);
    }
}
