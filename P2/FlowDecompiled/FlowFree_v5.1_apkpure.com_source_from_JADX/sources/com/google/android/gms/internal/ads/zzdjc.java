package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdjc<T> {
    private final Set<zzdiz<? extends zzdiy<T>>> zza;
    private final Executor zzb;

    public zzdjc(Executor executor, Set<zzdiz<? extends zzdiy<T>>> set) {
        this.zzb = executor;
        this.zza = set;
    }

    public final zzefw<T> zza(T t) {
        ArrayList arrayList = new ArrayList(this.zza.size());
        for (zzdiz next : this.zza) {
            zzefw zza2 = next.zza();
            if (zzage.zza.zze().booleanValue()) {
                zza2.zze(new zzdja(next, zzs.zzj().elapsedRealtime()), zzbbw.zzf);
            }
            arrayList.add(zza2);
        }
        return zzefo.zzn(arrayList).zza(new zzdjb(arrayList, t), this.zzb);
    }
}
