package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzbw extends zzhn<zzbx, zzbw> implements zzix {
    private zzbw() {
        super(zzbx.zzm);
    }

    public final String zza() {
        return ((zzbx) this.zza).zzc();
    }

    public final zzbw zzb(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbx.zzp((zzbx) this.zza, str);
        return this;
    }

    public final int zzc() {
        return ((zzbx) this.zza).zze();
    }

    public final zzbz zzd(int i) {
        return ((zzbx) this.zza).zzf(i);
    }

    public final zzbw zze(int i, zzbz zzbz) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbx.zzq((zzbx) this.zza, i, zzbz);
        return this;
    }

    /* synthetic */ zzbw(zzbt zzbt) {
        super(zzbx.zzm);
    }
}
