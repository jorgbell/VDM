package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdff implements zzeyl<zzdfe> {
    private final zzeyw<Executor> zza;
    private final zzeyw<zzbav> zzb;

    public zzdff(zzeyw<Executor> zzeyw, zzeyw<zzbav> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public static zzdfe zza(Executor executor, zzbav zzbav) {
        return new zzdfe(executor, zzbav);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdfe(zzefx, this.zzb.zzb());
    }
}
