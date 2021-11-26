package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbto;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdob<R extends zzbto<? extends zzbql>> {
    private final zzdsr zza;
    private final zzdod zzb;
    private final zzdoe<R> zzc;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public zzdoa zze;

    public zzdob(zzdsr zzdsr, zzdod zzdod, zzdoe<R> zzdoe, Executor executor) {
        this.zza = zzdsr;
        this.zzb = zzdod;
        this.zzc = zzdoe;
        this.zzd = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzdtb zze() {
        zzdrg zza2 = ((zzbto) this.zzc.zza(this.zzb).zzf()).zza();
        return this.zza.zzd(zza2.zzd, zza2.zzf, zza2.zzj);
    }

    public final zzefw<zzdoa> zza() {
        zzefw<V> zzefw;
        zzdoa zzdoa = this.zze;
        if (zzdoa != null) {
            return zzefo.zza(zzdoa);
        }
        if (!zzagh.zza.zze().booleanValue()) {
            zzdoa zzdoa2 = new zzdoa((zzawc) null, zze(), (zzdny) null);
            this.zze = zzdoa2;
            zzefw = zzefo.zza(zzdoa2);
        } else {
            zzbtn<R> zza2 = this.zzc.zza(this.zzb);
            zza2.zzg(new zzdnn(this.zza.zze().zzf));
            zzefw = zzefo.zze(zzefo.zzi(zzeff.zzw(((zzbto) zza2.zzf()).zzc().zze(this.zza.zze())), new zzdnz(this), this.zzd), zzcsk.class, new zzdny(this), this.zzd);
        }
        return zzefo.zzi(zzefw, zzdnx.zza, this.zzd);
    }
}
