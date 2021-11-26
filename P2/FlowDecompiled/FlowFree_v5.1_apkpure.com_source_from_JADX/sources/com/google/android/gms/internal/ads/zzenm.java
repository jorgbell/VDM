package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzenm extends zzetd<zzenn, zzenm> implements zzeup {
    private zzenm() {
        super(zzenn.zzg);
    }

    public final zzenm zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzenn) this.zza).zzb = 0;
        return this;
    }

    public final zzenm zzb(zzent zzent) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzenn.zzj((zzenn) this.zza, zzent);
        return this;
    }

    public final zzenm zzc(zzesf zzesf) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzenn) this.zza).zzf = zzesf;
        return this;
    }

    /* synthetic */ zzenm(zzenl zzenl) {
        super(zzenn.zzg);
    }
}
