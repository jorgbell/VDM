package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbus implements zzeyl<zzbuq> {
    private final zzeyw<zzbup> zza;
    private final zzeyw<Set<zzcav<zzbuj>>> zzb;
    private final zzeyw<Executor> zzc;

    public zzbus(zzeyw<zzbup> zzeyw, zzeyw<Set<zzcav<zzbuj>>> zzeyw2, zzeyw<Executor> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbup zza2 = ((zzbur) this.zza).zzb();
        Set zzc2 = ((zzeyu) this.zzb).zzb();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzbuq(zza2, zzc2, zzefx);
    }
}
