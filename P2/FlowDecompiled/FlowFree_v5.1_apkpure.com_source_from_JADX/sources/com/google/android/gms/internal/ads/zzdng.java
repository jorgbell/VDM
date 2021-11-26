package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbql;
import com.google.android.gms.internal.ads.zzbto;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdng<R extends zzbto<AdT>, AdT extends zzbql> implements zzdof<R, zzdta<AdT>> {
    private R zza;
    private final Executor zzb = zzegd.zza();

    public final R zza() {
        return this.zza;
    }

    public final zzefw<zzdta<AdT>> zzb(zzdog zzdog, zzdoe<R> zzdoe) {
        zzefw<zzdra> zzefw;
        zzbtn<R> zza2 = zzdoe.zza(zzdog.zzb);
        zza2.zzh(new zzdol(true));
        R r = (zzbto) zza2.zzf();
        this.zza = r;
        zzbro zzc = r.zzc();
        zzdta zzdta = new zzdta();
        zzawc zzawc = zzdog.zza;
        if (zzawc != null) {
            zzefw = zzc.zza(zzefo.zza(zzawc));
        } else {
            zzefw = zzc.zzb();
        }
        return zzefo.zzi(zzefo.zzh(zzeff.zzw(zzefw), new zzdne(this, zzdta, zzc), this.zzb), new zzdnf(zzdta), this.zzb);
    }

    public final /* bridge */ /* synthetic */ Object zzc() {
        return this.zza;
    }
}
