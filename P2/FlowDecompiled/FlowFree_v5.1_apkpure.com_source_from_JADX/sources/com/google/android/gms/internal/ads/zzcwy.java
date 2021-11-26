package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzak;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcwy implements zzeyl<zzcwx> {
    private final zzeyw<zzbpj> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<Executor> zzc;
    private final zzeyw<zzckt> zzd;
    private final zzeyw<zzdrg> zze;
    private final zzeyw<zzecb<zzdqo, zzak>> zzf;

    public zzcwy(zzeyw<zzbpj> zzeyw, zzeyw<Context> zzeyw2, zzeyw<Executor> zzeyw3, zzeyw<zzckt> zzeyw4, zzeyw<zzdrg> zzeyw5, zzeyw<zzecb<zzdqo, zzak>> zzeyw6) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
    }

    /* renamed from: zza */
    public final zzcwx zzb() {
        return new zzcwx(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), ((zzbtw) this.zze).zza(), this.zzf.zzb());
    }
}
