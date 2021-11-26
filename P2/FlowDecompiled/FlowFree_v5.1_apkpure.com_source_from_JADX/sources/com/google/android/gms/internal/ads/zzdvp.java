package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdvp implements zzeyl<zzdvo> {
    private final zzeyw<zzdvu> zza;
    private final zzeyw<zzdwb> zzb;
    private final zzeyw<ScheduledExecutorService> zzc;

    public zzdvp(zzeyw<zzdvu> zzeyw, zzeyw<zzdwb> zzeyw2, zzeyw<ScheduledExecutorService> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Object obj;
        zzeyf<zzdvu> zzc2 = zzeyk.zzc(this.zza);
        zzeyf<zzdwb> zzc3 = zzeyk.zzc(this.zzb);
        ScheduledExecutorService zzb2 = this.zzc.zzb();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfJ)).booleanValue()) {
            obj = new zzdvr(zzc2.zzb(), zzb2);
        } else {
            obj = zzc3.zzb();
        }
        zzeyr.zzb(obj);
        return obj;
    }
}
