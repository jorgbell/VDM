package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcvl implements zzeyl<zzcvk> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzefx> zzb;

    public zzcvl(zzeyw<Context> zzeyw, zzeyw<zzefx> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzbii) this.zza).zza();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcvk(zza2, zzefx);
    }
}
