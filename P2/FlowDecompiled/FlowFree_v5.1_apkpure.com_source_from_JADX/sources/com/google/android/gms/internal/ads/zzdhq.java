package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdhq implements zzeyl<zzdho> {
    private final zzeyw<zzefx> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<Set<String>> zzc;

    public zzdhq(zzeyw<zzefx> zzeyw, zzeyw<Context> zzeyw2, zzeyw<Set<String>> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdho(this.zza.zzb(), ((zzdsk) this.zzb).zza(), this.zzc.zzb());
    }
}
