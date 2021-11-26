package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdnl<R> implements zzdtn {
    public final zzdoe<R> zza;
    public final zzdog zzb;
    public final zzys zzc;
    public final String zzd;
    public final Executor zze;
    public final zzzd zzf;
    @Nullable
    public final zzdtb zzg;

    public zzdnl(zzdoe<R> zzdoe, zzdog zzdog, zzys zzys, String str, Executor executor, zzzd zzzd, @Nullable zzdtb zzdtb) {
        this.zza = zzdoe;
        this.zzb = zzdog;
        this.zzc = zzys;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzzd;
        this.zzg = zzdtb;
    }

    public final Executor zza() {
        return this.zze;
    }

    @Nullable
    public final zzdtb zzb() {
        return this.zzg;
    }

    public final zzdtn zzc() {
        return new zzdnl(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
