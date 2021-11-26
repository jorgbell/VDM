package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdll implements zzeyl<zzdlk> {
    private final zzeyw<Context> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzbid> zzc;
    private final zzeyw<zzdof<zzbnp, zzbnv>> zzd;
    private final zzeyw<zzdmm> zze;
    private final zzeyw<zzdrf> zzf;

    public zzdll(zzeyw<Context> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzbid> zzeyw3, zzeyw<zzdof<zzbnp, zzbnv>> zzeyw4, zzeyw<zzdmm> zzeyw5, zzeyw<zzdrf> zzeyw6) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdlk(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), ((zzdoj) this.zzd).zzb(), this.zze.zzb(), new zzdrf());
    }
}
