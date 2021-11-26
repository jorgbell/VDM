package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzddn {
    private final zzcfi zza;
    private final zzdda zzb;
    private final zzbui zzc;

    public zzddn(zzcfi zzcfi, zzdvo zzdvo) {
        this.zza = zzcfi;
        zzdda zzdda = new zzdda(zzdvo);
        this.zzb = zzdda;
        this.zzc = new zzddm(zzdda, zzcfi.zze());
    }

    public final void zza(zzaah zzaah) {
        this.zzb.zzn(zzaah);
    }

    public final zzcdg zzb() {
        return new zzcdg(this.zza, this.zzb.zzl());
    }

    public final zzdda zzc() {
        return this.zzb;
    }

    public final zzbvr zzd() {
        return this.zzb;
    }

    public final zzbui zze() {
        return this.zzc;
    }
}
