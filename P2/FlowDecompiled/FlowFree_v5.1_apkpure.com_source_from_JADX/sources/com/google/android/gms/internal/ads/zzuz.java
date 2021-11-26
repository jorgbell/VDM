package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzuz extends zzetd<zzva, zzuz> implements zzeup {
    private zzuz() {
        super(zzva.zzg);
    }

    public final zzuz zza(boolean z) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzva.zzd((zzva) this.zza, z);
        return this;
    }

    public final zzuz zzb(int i) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzva.zze((zzva) this.zza, i);
        return this;
    }

    /* synthetic */ zzuz(zzun zzun) {
        super(zzva.zzg);
    }
}
