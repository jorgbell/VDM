package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwh implements zzeyl<zzdwg> {
    private final zzeyw<Executor> zza;
    private final zzeyw<zzbbp> zzb;

    public zzdwh(zzeyw<Executor> zzeyw, zzeyw<zzbbp> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdwg(zzefx, this.zzb.zzb());
    }
}
