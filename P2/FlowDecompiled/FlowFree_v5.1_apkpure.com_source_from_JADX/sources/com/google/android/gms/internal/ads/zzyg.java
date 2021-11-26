package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzyg extends zzetd<zzyh, zzyg> implements zzeup {
    private zzyg() {
        super(zzyh.zzg);
    }

    public final boolean zza() {
        return ((zzyh) this.zza).zza();
    }

    public final zzyg zzb(boolean z) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzyh.zze((zzyh) this.zza, z);
        return this;
    }

    public final zzyg zzc(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzyh.zzf((zzyh) this.zza, i);
        return this;
    }

    /* synthetic */ zzyg(zzun zzun) {
        super(zzyh.zzg);
    }
}
