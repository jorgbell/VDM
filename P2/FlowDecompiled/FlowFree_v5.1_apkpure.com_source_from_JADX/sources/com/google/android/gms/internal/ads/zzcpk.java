package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcpk implements zzeyl<zzcpj> {
    private final zzeyw<Executor> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<WeakReference<Context>> zzc;
    private final zzeyw<Executor> zzd;
    private final zzeyw<zzclg> zze;
    private final zzeyw<ScheduledExecutorService> zzf;
    private final zzeyw<zzcnr> zzg;
    private final zzeyw<zzbbq> zzh;
    private final zzeyw<zzcah> zzi;

    public zzcpk(zzeyw<Executor> zzeyw, zzeyw<Context> zzeyw2, zzeyw<WeakReference<Context>> zzeyw3, zzeyw<Executor> zzeyw4, zzeyw<zzclg> zzeyw5, zzeyw<ScheduledExecutorService> zzeyw6, zzeyw<zzcnr> zzeyw7, zzeyw<zzbbq> zzeyw8, zzeyw<zzcah> zzeyw9) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
        this.zzh = zzeyw8;
        this.zzi = zzeyw9;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzbii) this.zzb).zza();
        WeakReference<Context> zza3 = ((zzbij) this.zzc).zza();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcpj(this.zza.zzb(), zza2, zza3, zzefx, this.zze.zzb(), this.zzf.zzb(), this.zzg.zzb(), ((zzbir) this.zzh).zza(), ((zzcai) this.zzi).zzb());
    }
}
