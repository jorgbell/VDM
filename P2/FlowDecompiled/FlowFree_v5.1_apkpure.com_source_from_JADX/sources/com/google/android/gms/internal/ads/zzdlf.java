package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdlf implements zzeyl<zzdjc<JSONObject>> {
    public static zzdjc<JSONObject> zza(zzbam zzbam, Object obj, zzdju zzdju, zzdks zzdks, zzeyf<zzdjo> zzeyf, zzeyf<zzdjx> zzeyf2, zzeyf<zzdkd> zzeyf3, zzeyf<zzdkh> zzeyf4, zzeyf<zzdko> zzeyf5, zzeyf<zzdkv> zzeyf6, zzeyf<zzdlh> zzeyf7, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdkl) obj);
        hashSet.add(zzdju);
        hashSet.add(zzdks);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdQ)).booleanValue()) {
            hashSet.add(zzeyf.zzb());
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdR)).booleanValue()) {
            hashSet.add(zzeyf2.zzb());
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdS)).booleanValue()) {
            hashSet.add(zzeyf3.zzb());
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdT)).booleanValue()) {
            hashSet.add(zzeyf4.zzb());
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdX)).booleanValue()) {
            hashSet.add(zzeyf6.zzb());
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdY)).booleanValue()) {
            hashSet.add(zzeyf7.zzb());
        }
        return new zzdjc<>(executor, hashSet);
    }
}
