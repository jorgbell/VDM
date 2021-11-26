package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcqp {
    private final zzefx zza;
    private final zzefx zzb;
    private final zzcrv zzc;
    private final zzeyf<zzctk> zzd;

    public zzcqp(zzefx zzefx, zzefx zzefx2, zzcrv zzcrv, zzeyf<zzctk> zzeyf) {
        this.zza = zzefx;
        this.zzb = zzefx2;
        this.zzc = zzcrv;
        this.zzd = zzeyf;
    }

    public final zzefw<InputStream> zza(zzawc zzawc) {
        zzefw<V> zzefw;
        String str = zzawc.zzd;
        zzs.zzc();
        if (zzr.zzE(str)) {
            zzefw = zzefo.zzb(new zzcsk(1));
        } else {
            zzefw = zzefo.zzf(this.zza.zzb(new zzcqm(this, zzawc)), ExecutionException.class, zzcqn.zza, this.zzb);
        }
        return zzefo.zzf(zzefw, zzcsk.class, new zzcqo(this, zzawc, Binder.getCallingUid()), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzb(zzawc zzawc, int i, zzcsk zzcsk) throws Exception {
        return this.zzd.zzb().zzb(zzawc, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzc(zzawc zzawc) throws Exception {
        zzbcb<InputStream> zzbcb;
        zzcrv zzcrv = this.zzc;
        synchronized (zzcrv.zzb) {
            if (zzcrv.zzc) {
                zzbcb = zzcrv.zza;
            } else {
                zzcrv.zzc = true;
                zzcrv.zze = zzawc;
                zzcrv.zzf.checkAvailabilityAndConnect();
                zzcrv.zza.zze(new zzcru(zzcrv), zzbbw.zzf);
                zzbcb = zzcrv.zza;
            }
        }
        return (InputStream) zzbcb.get((long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzdH)).intValue(), TimeUnit.SECONDS);
    }
}
