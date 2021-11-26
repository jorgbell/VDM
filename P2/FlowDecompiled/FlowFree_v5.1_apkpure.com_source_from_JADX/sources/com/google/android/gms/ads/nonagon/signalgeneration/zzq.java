package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbir;
import com.google.android.gms.internal.ads.zzcjo;
import com.google.android.gms.internal.ads.zzdry;
import com.google.android.gms.internal.ads.zzefx;
import com.google.android.gms.internal.ads.zzeyl;
import com.google.android.gms.internal.ads.zzeyr;
import com.google.android.gms.internal.ads.zzeyw;
import com.google.android.gms.internal.ads.zzfh;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzq implements zzeyl<zzp> {
    private final zzeyw<zzbid> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<zzfh> zzc;
    private final zzeyw<zzbbq> zzd;
    private final zzeyw<zzdry<zzcjo>> zze;
    private final zzeyw<zzefx> zzf;
    private final zzeyw<ScheduledExecutorService> zzg;

    public zzq(zzeyw<zzbid> zzeyw, zzeyw<Context> zzeyw2, zzeyw<zzfh> zzeyw3, zzeyw<zzbbq> zzeyw4, zzeyw<zzdry<zzcjo>> zzeyw5, zzeyw<zzefx> zzeyw6, zzeyw<ScheduledExecutorService> zzeyw7) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzp(this.zza.zzb(), ((zzbii) this.zzb).zza(), this.zzc.zzb(), ((zzbir) this.zzd).zza(), this.zze.zzb(), zzefx, this.zzg.zzb());
    }
}
