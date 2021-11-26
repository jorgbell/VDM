package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvb extends zzetd<zzvc, zzvb> implements zzeup {
    private zzvb() {
        super(zzvc.zzh);
    }

    public final zzvb zza(boolean z) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzvc.zzd((zzvc) this.zza, z);
        return this;
    }

    public final zzvb zzb(boolean z) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzvc.zze((zzvc) this.zza, z);
        return this;
    }

    public final zzvb zzc(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzvc.zzf((zzvc) this.zza, i);
        return this;
    }

    /* synthetic */ zzvb(zzun zzun) {
        super(zzvc.zzh);
    }
}
