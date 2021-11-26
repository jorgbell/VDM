package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcmp implements zzeyl<Set<zzcav<zzdvf>>> {
    private final zzeyw<String> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<Executor> zzc;
    private final zzeyw<Map<zzduy, zzcmr>> zzd;

    public zzcmp(zzeyw<String> zzeyw, zzeyw<Context> zzeyw2, zzeyw<Executor> zzeyw3, zzeyw<Map<zzduy, zzcmr>> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String zza2 = ((zzdlb) this.zza).zza();
        Context zza3 = ((zzbii) this.zzb).zza();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        Map zzd2 = ((zzeyp) this.zzd).zzb();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdc)).booleanValue()) {
            zzug zzug = new zzug(new zzum(zza3));
            zzug.zzc(new zzcmq(zza2));
            set = Collections.singleton(new zzcav(new zzcms(zzug, zzd2), zzefx));
        } else {
            set = Collections.emptySet();
        }
        zzeyr.zzb(set);
        return set;
    }
}
