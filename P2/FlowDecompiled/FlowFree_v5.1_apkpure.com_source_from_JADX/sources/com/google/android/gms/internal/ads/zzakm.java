package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzakm implements zzakp<zzbgf> {
    zzakm() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        if (map.keySet().contains("start")) {
            zzbgf.zzR().zzi();
        } else if (map.keySet().contains("stop")) {
            zzbgf.zzR().zzj();
        } else if (map.keySet().contains("cancel")) {
            zzbgf.zzR().zzk();
        }
    }
}
