package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbql;
import com.google.android.gms.internal.ads.zzbto;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdnk<R extends zzbto<AdT>, AdT extends zzbql> implements zzdtm<AdT> {
    private final zzdof<R, zzdta<AdT>> zza;

    public zzdnk(zzdof<R, zzdta<AdT>> zzdof) {
        this.zza = zzdof;
    }

    public final zzefw<zzdta<AdT>> zza(zzdtn zzdtn) {
        zzdnl zzdnl = (zzdnl) zzdtn;
        return this.zza.zzb(zzdnl.zzb, zzdnl.zza);
    }

    public final void zzb(zzdta<AdT> zzdta) {
        zzdta.zza = ((zzdng) this.zza).zza().zzc();
    }
}
