package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeks extends zzetd<zzekt, zzeks> implements zzeup {
    private zzeks() {
        super(zzekt.zzg);
    }

    public final zzeks zza(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        ((zzekt) this.zza).zzb = i;
        return this;
    }

    public final zzeks zzb(zzekz zzekz) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzekt.zzi((zzekt) this.zza, zzekz);
        return this;
    }

    public final zzeks zzc(zzenn zzenn) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzekt.zzj((zzekt) this.zza, zzenn);
        return this;
    }

    /* synthetic */ zzeks(zzekr zzekr) {
        super(zzekt.zzg);
    }
}
