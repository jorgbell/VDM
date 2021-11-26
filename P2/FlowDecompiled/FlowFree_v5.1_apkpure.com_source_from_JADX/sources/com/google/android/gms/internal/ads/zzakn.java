package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzakn implements zzakp<zzbgf> {
    zzakn() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        if (map.keySet().contains("start")) {
            zzbgf.zzar(true);
        }
        if (map.keySet().contains("stop")) {
            zzbgf.zzar(false);
        }
    }
}
