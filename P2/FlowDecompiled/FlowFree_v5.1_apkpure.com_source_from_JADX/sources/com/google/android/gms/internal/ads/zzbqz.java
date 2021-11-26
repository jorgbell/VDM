package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbqz {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzefw<zzbqs> zzc;
    private volatile boolean zzd = true;

    public zzbqz(Executor executor, ScheduledExecutorService scheduledExecutorService, zzefw<zzbqs> zzefw) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzefw;
    }

    static /* synthetic */ void zze(zzbqz zzbqz, List list, zzefk zzefk) {
        if (list == null || list.isEmpty()) {
            zzbqz.zza.execute(new zzbqt(zzefk));
            return;
        }
        zzefw<O> zza2 = zzefo.zza(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zza2 = zzefo.zzh(zzefo.zzf(zza2, Throwable.class, new zzbqu(zzefk), zzbqz.zza), new zzbqv(zzbqz, zzefk, (zzefw) it.next()), zzbqz.zza);
        }
        zzefo.zzo(zza2, new zzbqy(zzbqz, zzefk), zzbqz.zza);
    }

    public final void zza(zzefk<zzbql> zzefk) {
        zzefo.zzo(this.zzc, new zzbqx(this, zzefk), this.zza);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zzd = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzd(zzefk zzefk, zzefw zzefw, zzbql zzbql) throws Exception {
        if (zzbql != null) {
            zzefk.zzb(zzbql);
        }
        return zzefo.zzg(zzefw, zzagn.zzb.zze().longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }
}
