package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdrn implements zzakp {
    private final zzdwg zza;
    private final zzcvk zzb;

    zzdrn(zzdwg zzdwg, zzcvk zzcvk) {
        this.zza = zzdwg;
        this.zzb = zzcvk;
    }

    public final void zza(Object obj, Map map) {
        zzdwg zzdwg = this.zza;
        zzcvk zzcvk = this.zzb;
        zzbfw zzbfw = (zzbfw) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzbbk.zzi("URL missing from httpTrack GMSG.");
        } else if (!zzbfw.zzF().zzad) {
            zzdwg.zzb(str);
        } else {
            zzcvk.zze(new zzcvm(zzs.zzj().currentTimeMillis(), ((zzbhc) zzbfw).zzaB().zzb, str, 2));
        }
    }
}
