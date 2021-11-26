package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcde implements zzbqo<zzbqs> {
    private final Map<String, zzcvw<zzbqs>> zza;
    private final Map<String, zzcvw<zzces>> zzb;
    private final Map<String, zzcyl<zzces>> zzc;
    private final zzeyw<zzbqo<zzbom>> zzd;
    private final zzcfi zze;

    zzcde(Map<String, zzcvw<zzbqs>> map, Map<String, zzcvw<zzces>> map2, Map<String, zzcyl<zzces>> map3, zzeyw<zzbqo<zzbom>> zzeyw, zzcfi zzcfi) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzeyw;
        this.zze = zzcfi;
    }

    public final zzcvw<zzbqs> zza(int i, String str) {
        zzcvw zza2;
        zzcvw<zzbqs> zzcvw = this.zza.get(str);
        if (zzcvw != null) {
            return zzcvw;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzcyl zzcyl = this.zzc.get(str);
            if (zzcyl != null) {
                return zzbqs.zza(zzcyl);
            }
            zzcvw zzcvw2 = this.zzb.get(str);
            if (zzcvw2 == null) {
                return null;
            }
            return zzbqs.zzb(zzcvw2);
        } else if (this.zze.zzd() == null || (zza2 = this.zzd.zzb().zza(i, str)) == null) {
            return null;
        } else {
            return zzbqs.zzb(zza2);
        }
    }
}
