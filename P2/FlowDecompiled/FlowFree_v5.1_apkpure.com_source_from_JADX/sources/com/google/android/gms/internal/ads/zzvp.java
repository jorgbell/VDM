package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvp extends zzetd<zzvq, zzvp> implements zzeup {
    private zzvp() {
        super(zzvq.zzm);
    }

    public final zzvp zza(String str) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzvq.zzd((zzvq) this.zza, str);
        return this;
    }

    public final zzvp zzb(zzxk zzxk) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zzvq.zze((zzvq) this.zza, zzxk);
        return this;
    }

    /* synthetic */ zzvp(zzun zzun) {
        super(zzvq.zzm);
    }
}
