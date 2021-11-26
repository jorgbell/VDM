package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeoo extends zzetd<zzeop, zzeoo> implements zzeup {
    private zzeoo() {
        super(zzeop.zzh);
    }

    public final zzeoo zza(String str) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzeop.zzd((zzeop) this.zza, str);
        return this;
    }

    public final zzeoo zzb(zzeoa zzeoa) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeop) this.zza).zze = zzeoa.zza();
        return this;
    }

    public final zzeoo zzc(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeop) this.zza).zzf = i;
        return this;
    }

    public final zzeoo zzd(zzepe zzepe) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeop) this.zza).zzg = zzepe.zza();
        return this;
    }

    /* synthetic */ zzeoo(zzeom zzeom) {
        super(zzeop.zzh);
    }
}
