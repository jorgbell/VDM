package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzemz extends zzetd<zzena, zzemz> implements zzeup {
    private zzemz() {
        super(zzena.zzg);
    }

    public final zzemz zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzena) this.zza).zzb = 0;
        return this;
    }

    public final zzemz zzb(zzend zzend) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzena.zzi((zzena) this.zza, zzend);
        return this;
    }

    public final zzemz zzc(zzesf zzesf) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzena) this.zza).zzf = zzesf;
        return this;
    }

    /* synthetic */ zzemz(zzemy zzemy) {
        super(zzena.zzg);
    }
}
