package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdzs extends zzetd<zzdzt, zzdzs> implements zzeup {
    private zzdzs() {
        super(zzdzt.zzj);
    }

    public final zzdzs zza(zzdzr zzdzr) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzdzt.zzd((zzdzt) this.zza, zzdzr);
        return this;
    }

    public final zzdzs zzb(String str) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzdzt.zze((zzdzt) this.zza, str);
        return this;
    }

    /* synthetic */ zzdzs(zzdzo zzdzo) {
        super(zzdzt.zzj);
    }
}
