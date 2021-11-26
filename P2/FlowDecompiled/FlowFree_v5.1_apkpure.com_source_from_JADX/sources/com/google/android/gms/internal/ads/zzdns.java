package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbql;
import com.google.android.gms.internal.ads.zzbto;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdns<R extends zzbto<AdT>, AdT extends zzbql> implements zzdof<R, zzdnr<AdT>> {
    private final zzdsr zza;
    private final Executor zzb;
    private final zzefk<Void> zzc = new zzdnq(this);

    public zzdns(zzdsr zzdsr, Executor executor) {
        this.zza = zzdsr;
        this.zzb = executor;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zza(zzdog zzdog, zzdoe zzdoe, zzdoa zzdoa) throws Exception {
        zzdtb zzdtb = zzdoa.zzb;
        zzawc zzawc = zzdoa.zza;
        zzdta<?> zza2 = zzdtb != null ? this.zza.zza(zzdtb) : null;
        if (zzdtb == null) {
            return zzefo.zza(null);
        }
        if (!(zza2 == null || zzawc == null)) {
            zzefo.zzo(((zzbto) zzdoe.zza(zzdog.zzb).zzf()).zzc().zzf(zzawc), this.zzc, this.zzb);
        }
        return zzefo.zza(new zzdnr(zzdtb, zzawc, zza2));
    }

    public final zzefw<zzdnr<AdT>> zzb(zzdog zzdog, zzdoe<R> zzdoe) {
        return zzefo.zze(zzefo.zzh(zzeff.zzw(new zzdob(this.zza, zzdog.zzb, zzdoe, this.zzb).zza()), new zzdno(this, zzdog, zzdoe), this.zzb), Exception.class, new zzdnp(this), this.zzb);
    }

    public final /* bridge */ /* synthetic */ Object zzc() {
        return null;
    }
}
