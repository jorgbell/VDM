package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyb implements zzeyl<zzcya> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzbbq> zzb;
    private final zzeyw<zzdrg> zzc;
    private final zzeyw<Executor> zzd;
    private final zzeyw<zzccp> zze;
    private final zzeyw<zzckt> zzf;
    private final zzeyw<zzaks> zzg;

    public zzcyb(zzeyw<Context> zzeyw, zzeyw<zzbbq> zzeyw2, zzeyw<zzdrg> zzeyw3, zzeyw<Executor> zzeyw4, zzeyw<zzccp> zzeyw5, zzeyw<zzckt> zzeyw6, zzeyw<zzaks> zzeyw7) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcya(this.zza.zzb(), ((zzbir) this.zzb).zza(), ((zzbtw) this.zzc).zza(), this.zzd.zzb(), this.zze.zzb(), this.zzf.zzb(), new zzaks());
    }
}
