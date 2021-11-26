package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdkd implements zzdiz<zzdke> {
    private final zzbav zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;

    public zzdkd(zzbao zzbao, int i, Context context, zzbav zzbav, ScheduledExecutorService scheduledExecutorService, Executor executor, byte[] bArr) {
        this.zzb = zzbav;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
    }

    public final zzefw<zzdke> zza() {
        return zzefo.zze((zzeff) zzefo.zzg(zzefo.zzi(zzeff.zzw(zzefo.zzd(new zzdka(this), this.zzd)), zzdkb.zza, this.zzd), ((Long) zzaaa.zzc().zzb(zzaeq.zzaG)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzdkc(this), zzegd.zza());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdke zzb(Exception exc) {
        this.zzb.zzg(exc, "AttestationTokenSignal");
        return null;
    }
}
