package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzakl implements zzakp<zzbgf> {
    zzakl() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbgf.zzbl();
        } else if ("resume".equals(str)) {
            zzbgf.zzbm();
        }
    }
}
