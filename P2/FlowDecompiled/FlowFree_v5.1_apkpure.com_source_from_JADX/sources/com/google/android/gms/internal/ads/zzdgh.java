package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdgh implements zzeyl<zzdgg> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzefx> zzb;

    public zzdgh(zzeyw<Context> zzeyw, zzeyw<zzefx> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public static zzdgg zza(Context context, zzefx zzefx) {
        return new zzdgg(context, zzefx);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzdsk) this.zza).zza();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdgg(zza2, zzefx);
    }
}
