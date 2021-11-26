package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzenv extends zzetd<zzeny, zzenv> implements zzeup {
    private zzenv() {
        super(zzeny.zzg);
    }

    public final zzenv zza(String str) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeny) this.zza).zzb = str;
        return this;
    }

    public final zzenv zzb(zzesf zzesf) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeny) this.zza).zze = zzesf;
        return this;
    }

    public final zzenv zzc(zzenx zzenx) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzeny) this.zza).zzf = zzenx.zza();
        return this;
    }

    /* synthetic */ zzenv(zzenu zzenu) {
        super(zzeny.zzg);
    }
}
