package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcuw implements zzeyl<zzcuv> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzbtl> zzb;
    private final zzeyw<zzcuo> zzc;
    private final zzeyw<zzcuk> zzd;
    private final zzeyw<zzg> zze;

    public zzcuw(zzeyw<Context> zzeyw, zzeyw<zzbtl> zzeyw2, zzeyw<zzcuo> zzeyw3, zzeyw<zzcuk> zzeyw4, zzeyw<zzg> zzeyw5) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
    }

    /* renamed from: zza */
    public final zzcuv zzb() {
        return new zzcuv(((zzdsk) this.zza).zza(), ((zzbtm) this.zzb).zzb(), this.zzc.zzb(), ((zzcul) this.zzd).zzb(), ((zzdsj) this.zze).zzb());
    }
}
