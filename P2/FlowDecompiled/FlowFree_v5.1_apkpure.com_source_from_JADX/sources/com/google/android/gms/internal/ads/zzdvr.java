package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdvr implements zzdvo {
    private final zzdvo zza;
    private final Queue<zzdvn> zzb = new LinkedBlockingQueue();
    private final int zzc = ((Integer) zzaaa.zzc().zzb(zzaeq.zzfL)).intValue();
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzdvr(zzdvo zzdvo, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzdvo;
        long intValue = (long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzfK)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new zzdvq(this), intValue, intValue, TimeUnit.MILLISECONDS);
    }

    public final void zza(zzdvn zzdvn) {
        if (this.zzb.size() < this.zzc) {
            this.zzb.offer(zzdvn);
        } else if (!this.zzd.getAndSet(true)) {
            Queue<zzdvn> queue = this.zzb;
            zzdvn zza2 = zzdvn.zza("dropped_event");
            Map<String, String> zzj = zzdvn.zzj();
            if (zzj.containsKey("action")) {
                zza2.zzc("dropped_action", zzj.get("action"));
            }
            queue.offer(zza2);
        }
    }

    public final String zzb(zzdvn zzdvn) {
        return this.zza.zzb(zzdvn);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzc() {
        while (!this.zzb.isEmpty()) {
            this.zza.zza(this.zzb.remove());
        }
    }
}
