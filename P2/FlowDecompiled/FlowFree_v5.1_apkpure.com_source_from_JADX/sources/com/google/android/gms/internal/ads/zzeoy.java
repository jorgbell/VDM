package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeoy extends zzetd<zzeoz, zzeoy> implements zzeup {
    private zzeoy() {
        super(zzeoz.zzf);
    }

    public final zzeoy zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeoz) this.zza).zzb = 0;
        return this;
    }

    public final zzeoy zzb(zzepc zzepc) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzeoz.zzh((zzeoz) this.zza, zzepc);
        return this;
    }

    /* synthetic */ zzeoy(zzeox zzeox) {
        super(zzeoz.zzf);
    }
}
