package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzelh extends zzetd<zzeli, zzelh> implements zzeup {
    private zzelh() {
        super(zzeli.zzg);
    }

    public final zzelh zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeli) this.zza).zzb = 0;
        return this;
    }

    public final zzelh zzb(zzelo zzelo) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzeli.zzi((zzeli) this.zza, zzelo);
        return this;
    }

    public final zzelh zzc(zzesf zzesf) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeli) this.zza).zzf = zzesf;
        return this;
    }

    /* synthetic */ zzelh(zzelg zzelg) {
        super(zzeli.zzg);
    }
}
