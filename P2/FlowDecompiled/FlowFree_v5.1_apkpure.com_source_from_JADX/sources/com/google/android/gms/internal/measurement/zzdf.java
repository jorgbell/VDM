package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdf extends zzhn<zzdg, zzdf> implements zzix {
    private zzdf() {
        super(zzdg.zzk);
    }

    public final zzdf zza(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzp((zzdg) this.zza, str);
        return this;
    }

    public final zzdf zzb(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzq((zzdg) this.zza, str);
        return this;
    }

    public final zzdf zzc() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzr((zzdg) this.zza);
        return this;
    }

    public final zzdf zzd(long j) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzs((zzdg) this.zza, j);
        return this;
    }

    public final zzdf zze() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzt((zzdg) this.zza);
        return this;
    }

    public final zzdf zzf(double d) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzu((zzdg) this.zza, d);
        return this;
    }

    public final zzdf zzg() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzv((zzdg) this.zza);
        return this;
    }

    public final int zzh() {
        return ((zzdg) this.zza).zzm();
    }

    public final zzdf zzi(zzdf zzdf) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzw((zzdg) this.zza, (zzdg) zzdf.zzaA());
        return this;
    }

    public final zzdf zzj(Iterable<? extends zzdg> iterable) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdg.zzx((zzdg) this.zza, iterable);
        return this;
    }

    public final zzdf zzk() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        ((zzdg) this.zza).zzj = zzhr.zzbE();
        return this;
    }

    /* synthetic */ zzdf(zzct zzct) {
        super(zzdg.zzk);
    }
}
