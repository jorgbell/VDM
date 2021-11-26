package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcsi implements zzcsj {
    private final Map<String, zzeyw<zzcsj>> zza;
    private final zzefx zzb;
    /* access modifiers changed from: private */
    public final zzbwv zzc;

    public zzcsi(Map<String, zzeyw<zzcsj>> map, zzefx zzefx, zzbwv zzbwv) {
        this.zza = map;
        this.zzb = zzefx;
        this.zzc = zzbwv;
    }

    public final zzefw<zzdra> zza(zzawc zzawc) {
        this.zzc.zzj(zzawc);
        zzefw<zzdra> zzb2 = zzefo.zzb(new zzcql(3));
        for (String trim : ((String) zzaaa.zzc().zzb(zzaeq.zzfr)).split(",")) {
            zzeyw zzeyw = this.zza.get(trim.trim());
            if (zzeyw != null) {
                zzb2 = zzefo.zzf(zzb2, zzcql.class, new zzcsg(zzeyw, zzawc), this.zzb);
            }
        }
        zzefo.zzo(zzb2, new zzcsh(this), zzbbw.zzf);
        return zzb2;
    }
}
