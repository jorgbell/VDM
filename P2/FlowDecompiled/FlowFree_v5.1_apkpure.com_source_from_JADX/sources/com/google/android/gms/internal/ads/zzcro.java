package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcro implements zzcsj {
    /* access modifiers changed from: private */
    public static final Pattern zzf = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzcqp zza;
    private final zzefx zzb;
    private final zzdrg zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzcuo zze;

    zzcro(zzdrg zzdrg, zzcqp zzcqp, zzefx zzefx, ScheduledExecutorService scheduledExecutorService, zzcuo zzcuo) {
        this.zzc = zzdrg;
        this.zza = zzcqp;
        this.zzb = zzefx;
        this.zzd = scheduledExecutorService;
        this.zze = zzcuo;
    }

    public final zzefw<zzdra> zza(zzawc zzawc) {
        zzefw<zzdra> zzh = zzefo.zzh(this.zza.zza(zzawc), new zzcrl(this), this.zzb);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdG)).booleanValue()) {
            zzh = zzefo.zzf(zzefo.zzg(zzh, (long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzdH)).intValue(), TimeUnit.SECONDS, this.zzd), TimeoutException.class, zzcrm.zza, zzbbw.zzf);
        }
        zzefo.zzo(zzh, new zzcrn(this), zzbbw.zzf);
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzb(InputStream inputStream) throws Exception {
        return zzefo.zza(new zzdra(new zzdqx(this.zzc), zzdqz.zza(new InputStreamReader(inputStream))));
    }
}
