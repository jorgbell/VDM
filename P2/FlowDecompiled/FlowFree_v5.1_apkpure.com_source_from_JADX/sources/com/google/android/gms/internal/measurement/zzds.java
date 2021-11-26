package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzds extends zzhn<zzdt, zzds> implements zzix {
    private zzds() {
        super(zzdt.zzg);
    }

    public final zzds zza(int i) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdt.zzh((zzdt) this.zza, i);
        return this;
    }

    public final zzds zzb(Iterable<? extends Long> iterable) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdt.zzi((zzdt) this.zza, iterable);
        return this;
    }

    /* synthetic */ zzds(zzct zzct) {
        super(zzdt.zzg);
    }
}
