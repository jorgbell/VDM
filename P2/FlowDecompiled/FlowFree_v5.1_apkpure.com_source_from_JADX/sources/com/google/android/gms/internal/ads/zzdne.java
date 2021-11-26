package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdne implements zzeev {
    private final zzdta zzb;
    private final zzbro zzc;

    zzdne(zzdng zzdng, zzdta zzdta, zzbro zzbro) {
        this.zzb = zzdta;
        this.zzc = zzbro;
    }

    public final zzefw zza(Object obj) {
        zzdta zzdta = this.zzb;
        zzbro zzbro = this.zzc;
        zzdra zzdra = (zzdra) obj;
        zzdta.zzb = zzdra;
        Iterator<zzdqo> it = zzdra.zzb.zza.iterator();
        boolean z = false;
        loop0:
        while (true) {
            if (it.hasNext()) {
                Iterator<String> it2 = it.next().zza.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z = true;
                    }
                }
            } else if (z) {
                return zzbro.zzc(zzefo.zza(zzdra));
            }
        }
        return zzefo.zza(null);
    }
}
