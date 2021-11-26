package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbtf implements zzbuf, zzcan, zzbyn, zzbut {
    /* access modifiers changed from: private */
    public final zzbuv zza;
    private final zzdqo zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzege<Boolean> zze = zzege.zza();
    private ScheduledFuture<?> zzf;

    public zzbtf(zzbuv zzbuv, zzdqo zzdqo, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zza = zzbuv;
        this.zzb = zzdqo;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
    }

    public final void zza() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzba)).booleanValue()) {
            zzdqo zzdqo = this.zzb;
            if (zzdqo.zzS != 2) {
                return;
            }
            if (zzdqo.zzp == 0) {
                this.zza.zza();
                return;
            }
            zzefo.zzo(this.zze, new zzbte(this), this.zzd);
            this.zzf = this.zzc.schedule(new zzbtd(this), (long) this.zzb.zzp, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void zzb() {
        if (!this.zze.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzh(Boolean.TRUE);
        }
    }

    public final void zzc() {
        int i = this.zzb.zzS;
        if (i == 0 || i == 1) {
            this.zza.zza();
        }
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    public final void zzf(zzaws zzaws, String str, String str2) {
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final synchronized void zzi(zzym zzym) {
        if (!this.zze.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzi(new Exception());
        }
    }

    public final void zzj() {
    }

    public final void zzk() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzh(Boolean.TRUE);
            }
        }
    }
}
