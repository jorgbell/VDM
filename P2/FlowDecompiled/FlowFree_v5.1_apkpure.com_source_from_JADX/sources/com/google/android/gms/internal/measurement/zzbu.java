package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzbu extends zzhn<zzbv, zzbu> implements zzix {
    private zzbu() {
        super(zzbv.zzj);
    }

    public final int zza() {
        return ((zzbv) this.zza).zzd();
    }

    public final zzcg zzb(int i) {
        return ((zzbv) this.zza).zze(i);
    }

    public final zzbu zzc(int i, zzcf zzcf) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbv.zzj((zzbv) this.zza, i, (zzcg) zzcf.zzaA());
        return this;
    }

    public final int zzd() {
        return ((zzbv) this.zza).zzg();
    }

    public final zzbx zze(int i) {
        return ((zzbv) this.zza).zzh(i);
    }

    public final zzbu zzf(int i, zzbw zzbw) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbv.zzk((zzbv) this.zza, i, (zzbx) zzbw.zzaA());
        return this;
    }

    /* synthetic */ zzbu(zzbt zzbt) {
        super(zzbv.zzj);
    }
}
