package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeos extends zzetd<zzeot, zzeos> implements zzeup {
    private zzeos() {
        super(zzeot.zzf);
    }

    public final zzeos zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeot) this.zza).zzb = 0;
        return this;
    }

    public final zzeos zzb(zzeow zzeow) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzeot.zzh((zzeot) this.zza, zzeow);
        return this;
    }

    /* synthetic */ zzeos(zzeor zzeor) {
        super(zzeot.zzf);
    }
}
