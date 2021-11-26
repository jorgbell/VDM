package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcmy implements zzeyl<zzcav<zzbww>> {
    private final zzeyw<zzcmw> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzctu> zzc;

    public zzcmy(zzeyw<zzcmw> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzctu> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcmw zzb2 = this.zza.zzb();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        zzctu zzb3 = this.zzc.zzb();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
            return new zzcav(zzb3, zzefx);
        }
        return new zzcav(zzb2, zzefx);
    }
}
