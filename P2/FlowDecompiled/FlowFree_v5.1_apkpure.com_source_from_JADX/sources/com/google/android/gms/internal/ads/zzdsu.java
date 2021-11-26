package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdsu {
    private final zzdst zza = new zzdst();
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    zzdsu() {
    }

    public final void zza() {
        this.zzd++;
    }

    public final void zzb() {
        this.zze++;
    }

    public final void zzc() {
        this.zzb++;
        this.zza.zza = true;
    }

    public final void zzd() {
        this.zzc++;
        this.zza.zzb = true;
    }

    public final void zze() {
        this.zzf++;
    }

    public final zzdst zzf() {
        zzdst zza2 = this.zza.clone();
        zzdst zzdst = this.zza;
        zzdst.zza = false;
        zzdst.zzb = false;
        return zza2;
    }

    public final String zzg() {
        return "\n\tPool does not exist: " + this.zzd + "\n\tNew pools created: " + this.zzb + "\n\tPools removed: " + this.zzc + "\n\tEntries added: " + this.zzf + "\n\tNo entries retrieved: " + this.zze + "\n";
    }
}
