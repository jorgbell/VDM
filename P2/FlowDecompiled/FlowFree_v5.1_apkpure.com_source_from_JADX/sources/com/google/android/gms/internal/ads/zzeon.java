package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeon extends zzetd<zzeoq, zzeon> implements zzeup {
    private zzeon() {
        super(zzeoq.zzf);
    }

    public final zzeon zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeoq) this.zza).zzb = i;
        return this;
    }

    public final zzeon zzb(zzeop zzeop) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzeoq.zze((zzeoq) this.zza, zzeop);
        return this;
    }

    /* synthetic */ zzeon(zzeom zzeom) {
        super(zzeoq.zzf);
    }
}
