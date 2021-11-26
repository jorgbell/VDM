package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrj {
    private final ScheduledExecutorService zza;
    private final zzefx zzb;
    private final zzcrz zzc;
    private final zzeyf<zzctk> zzd;

    public zzcrj(ScheduledExecutorService scheduledExecutorService, zzefx zzefx, zzcrz zzcrz, zzeyf<zzctk> zzeyf) {
        this.zza = scheduledExecutorService;
        this.zzb = zzefx;
        this.zzc = zzcrz;
        this.zzd = zzeyf;
    }

    public final zzefw<InputStream> zza(zzawc zzawc) {
        zzefw zzefw;
        String str = zzawc.zzd;
        zzs.zzc();
        if (zzr.zzE(str)) {
            zzefw = zzefo.zzb(new zzcsk(1));
        } else {
            zzcrz zzcrz = this.zzc;
            synchronized (zzcrz.zzb) {
                if (zzcrz.zzc) {
                    zzefw = zzcrz.zza;
                } else {
                    zzcrz.zzc = true;
                    zzcrz.zze = zzawc;
                    zzcrz.zzf.checkAvailabilityAndConnect();
                    zzcrz.zza.zze(new zzcry(zzcrz), zzbbw.zzf);
                    zzefw = zzcrz.zza;
                }
            }
        }
        int callingUid = Binder.getCallingUid();
        zzeff zzw = zzeff.zzw(zzefw);
        long intValue = (long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzdH)).intValue();
        return zzefo.zzf((zzeff) zzefo.zzg(zzw, intValue, TimeUnit.SECONDS, this.zza), Throwable.class, new zzcri(this, zzawc, callingUid), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzb(zzawc zzawc, int i, Throwable th) throws Exception {
        return this.zzd.zzb().zzi(zzawc, i);
    }
}
