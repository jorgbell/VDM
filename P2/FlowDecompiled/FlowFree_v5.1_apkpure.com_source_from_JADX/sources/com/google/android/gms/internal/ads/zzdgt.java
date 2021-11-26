package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdgt implements zzeyl<zzdgr> {
    private final zzeyw<zzefx> zza;
    private final zzeyw<ViewGroup> zzb;
    private final zzeyw<Context> zzc;
    private final zzeyw<Set<String>> zzd;

    public zzdgt(zzeyw<zzefx> zzeyw, zzeyw<ViewGroup> zzeyw2, zzeyw<Context> zzeyw3, zzeyw<Set<String>> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgr(this.zza.zzb(), ((zzbok) this.zzb).zza(), this.zzc.zzb(), ((zzeyu) this.zzd).zzb());
    }
}
