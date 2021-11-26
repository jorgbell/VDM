package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbsl implements zzeyl<zzcav<zzbuj>> {
    private final zzeyw<zzcmu> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzcts> zzc;

    public zzbsl(zzeyw<zzcmu> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzcts> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcmu zzb2 = this.zza.zzb();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        zzcts zzb3 = this.zzc.zzb();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
            return new zzcav(zzb3, zzefx);
        }
        return new zzcav(zzb2, zzefx);
    }
}
