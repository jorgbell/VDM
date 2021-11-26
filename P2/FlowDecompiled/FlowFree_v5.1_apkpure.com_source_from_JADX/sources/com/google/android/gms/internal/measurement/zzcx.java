package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcx extends zzhn<zzcy, zzcx> implements zzix {
    private zzcx() {
        super(zzcy.zzi);
    }

    public final zzcx zza(int i) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcy.zzj((zzcy) this.zza, i);
        return this;
    }

    public final zzcx zzb(zzdq zzdq) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcy.zzk((zzcy) this.zza, (zzdr) zzdq.zzaA());
        return this;
    }

    public final zzcx zzc(zzdr zzdr) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcy.zzm((zzcy) this.zza, zzdr);
        return this;
    }

    public final zzcx zzd(boolean z) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcy.zzn((zzcy) this.zza, z);
        return this;
    }

    /* synthetic */ zzcx(zzct zzct) {
        super(zzcy.zzi);
    }
}
