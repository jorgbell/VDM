package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcz extends zzhn<zzda, zzcz> implements zzix {
    private zzcz() {
        super(zzda.zzg);
    }

    public final zzcz zza(int i) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzda.zzg((zzda) this.zza, i);
        return this;
    }

    public final zzcz zzb(long j) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzda.zzh((zzda) this.zza, j);
        return this;
    }

    /* synthetic */ zzcz(zzct zzct) {
        super(zzda.zzg);
    }
}
