package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzemc extends zzetd<zzemd, zzemc> implements zzeup {
    private zzemc() {
        super(zzemd.zzf);
    }

    public final zzemc zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzemd) this.zza).zzb = 0;
        return this;
    }

    public final zzemc zzb(zzesf zzesf) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzemd) this.zza).zze = zzesf;
        return this;
    }

    /* synthetic */ zzemc(zzemb zzemb) {
        super(zzemd.zzf);
    }
}
