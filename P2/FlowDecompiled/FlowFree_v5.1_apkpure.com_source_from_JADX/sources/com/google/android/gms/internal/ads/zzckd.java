package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzckd implements zzeyl<zzcvw<zzcjw>> {
    private final zzeyw<zzdax<zzcjw, zzdrx, zzcxt>> zza;
    private final zzeyw<zzdax<zzcjw, zzdrx, zzcxs>> zzb;
    private final zzeyw<zzdrg> zzc;

    public zzckd(zzeyw<zzdax<zzcjw, zzdrx, zzcxt>> zzeyw, zzeyw<zzdax<zzcjw, zzdrx, zzcxs>> zzeyw2, zzeyw<zzdrg> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeyw<zzdax<zzcjw, zzdrx, zzcxt>> zzeyw = this.zza;
        zzeyw<zzdax<zzcjw, zzdrx, zzcxs>> zzeyw2 = this.zzb;
        int i = ((zzbtw) this.zzc).zza().zzo.zza;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        } else if (i2 != 0) {
            return ((zzday) zzeyw2).zzb();
        } else {
            return ((zzday) zzeyw).zzb();
        }
    }
}
