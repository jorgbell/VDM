package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbql;
import com.google.android.gms.internal.ads.zzbto;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdnm<R extends zzbto<AdT>, AdT extends zzbql> implements zzdof<R, AdT> {
    private final zzdof<R, AdT> zza;
    private final zzdof<R, zzdnr<AdT>> zzb;
    private final zzdto<AdT> zzc;
    @GuardedBy("this")
    private R zzd;
    private final Executor zze;

    public zzdnm(zzdof<R, AdT> zzdof, zzdof<R, zzdnr<AdT>> zzdof2, zzdto<AdT> zzdto, Executor executor) {
        this.zza = zzdof;
        this.zzb = zzdof2;
        this.zzc = zzdto;
        this.zze = executor;
    }

    private final zzefw<AdT> zzf(zzdta<AdT> zzdta, zzdog zzdog, zzdoe<R> zzdoe) {
        zzbtn<R> zza2 = zzdoe.zza(zzdog.zzb);
        if (zzdta.zzc != null) {
            zzbto zzbto = (zzbto) zza2.zzf();
            if (zzbto.zzd() != null) {
                zzdta.zzc.zzn().zzo(zzbto.zzd());
            }
            return zzefo.zza(zzdta.zzc);
        }
        zza2.zzi(zzdta.zzb);
        zzefw<AdT> zzb2 = this.zza.zzb(zzdog, new zzdni(zza2));
        this.zzd = ((zzdnw) this.zza).zzc();
        return zzb2;
    }

    /* renamed from: zza */
    public final synchronized R zzc() {
        return this.zzd;
    }

    public final synchronized zzefw<AdT> zzb(zzdog zzdog, zzdoe<R> zzdoe) {
        zzdrg zza2;
        zzdoe<R> zzdoe2;
        zzdog zzdog2;
        zza2 = ((zzbto) zzdoe.zza(zzdog.zzb).zzf()).zza();
        zzdoe2 = zzdoe;
        zzdog2 = zzdog;
        return zzefo.zzh(zzeff.zzw(this.zzb.zzb(zzdog, zzdoe)), new zzdnh(this, zzdog, new zzdnl(zzdoe2, zzdog2, zza2.zzd, zza2.zzf, this.zze, zza2.zzj, (zzdtb) null), zzdoe), this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zze(zzdog zzdog, zzdnl zzdnl, zzdoe zzdoe, zzdnr zzdnr) throws Exception {
        if (zzdnr != null) {
            zzdnl zzdnl2 = new zzdnl(zzdnl.zza, zzdnl.zzb, zzdnl.zzc, zzdnl.zzd, zzdnl.zze, zzdnl.zzf, zzdnr.zza);
            if (zzdnr.zzc != null) {
                this.zzd = null;
                this.zzc.zza(zzdnl2);
                return zzf(zzdnr.zzc, zzdog, zzdoe);
            }
            zzefw<zzdtl<AdT>> zzb2 = this.zzc.zzb(zzdnl2);
            if (zzb2 != null) {
                this.zzd = (zzbto) zzdoe.zza(zzdog.zzb).zzf();
                return zzefo.zzh(zzb2, new zzdnj(this, zzdoe), this.zze);
            }
            this.zzc.zza(zzdnl2);
            zzdog = new zzdog(zzdog.zzb, zzdnr.zzb);
        }
        zzefw<AdT> zzb3 = this.zza.zzb(zzdog, zzdoe);
        this.zzd = ((zzdnw) this.zza).zzc();
        return zzb3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzd(zzdoe zzdoe, zzdtl zzdtl) throws Exception {
        zzdtn zzdtn;
        if (zzdtl == null || zzdtl.zza == null || (zzdtn = zzdtl.zzb) == null) {
            throw new zzcql(1, "Empty prefetch");
        }
        zzuv zza2 = zzvd.zza();
        zzut zza3 = zzuu.zza();
        zza3.zza(zzuy.IN_MEMORY);
        zza3.zzb(zzva.zza());
        zza2.zza(zza3);
        zzdtl.zza.zza.zzd().zzm((zzvd) zza2.zzah());
        return zzf(zzdtl.zza, ((zzdnl) zzdtn).zzb, zzdoe);
    }
}
