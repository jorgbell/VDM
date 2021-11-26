package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekj extends zzetd<zzekk, zzekj> implements zzeup {
    private zzekj() {
        super(zzekk.zzg);
    }

    public final zzekj zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzekk) this.zza).zzb = 0;
        return this;
    }

    public final zzekj zzb(zzesf zzesf) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzekk) this.zza).zze = zzesf;
        return this;
    }

    public final zzekj zzc(zzekq zzekq) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzekk.zzj((zzekk) this.zza, zzekq);
        return this;
    }

    /* synthetic */ zzekj(zzeki zzeki) {
        super(zzekk.zzg);
    }
}
