package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdtf {
    private final HashMap<zzdsv, zzdte<? extends zzbql>> zza = new HashMap<>();

    public final <AdT extends zzbql> zzdte<AdT> zza(zzdsv zzdsv, Context context, zzdsn zzdsn, zzdtm<AdT> zzdtm) {
        zzdte<AdT> zzdte = this.zza.get(zzdsv);
        if (zzdte != null) {
            return zzdte;
        }
        zzdss zzdss = new zzdss(zzdsy.zza(zzdsv, context));
        zzdte<AdT> zzdte2 = new zzdte<>(zzdss, new zzdto(zzdss, zzdsn, zzdtm));
        this.zza.put(zzdsv, zzdte2);
        return zzdte2;
    }
}
