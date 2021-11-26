package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdix implements zzeyl<zzdiw> {
    private final zzeyw<zzefx> zza;
    private final zzeyw<Context> zzb;

    public zzdix(zzeyw<zzefx> zzeyw, zzeyw<Context> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public static zzdiw zza(zzefx zzefx, Context context) {
        return new zzdiw(zzefx, context);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdiw(zzefx, ((zzdsk) this.zzb).zza());
    }
}
