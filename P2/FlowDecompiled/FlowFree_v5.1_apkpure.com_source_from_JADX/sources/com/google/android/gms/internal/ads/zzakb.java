package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzakb implements zzakp {
    static final zzakp zza = new zzakb();

    private zzakb() {
    }

    public final void zza(Object obj, Map map) {
        zzbhh zzbhh = (zzbhh) obj;
        zzakp<zzbgf> zzakp = zzako.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzbbk.zzi("URL missing from httpTrack GMSG.");
        } else {
            new zzbo(zzbhh.getContext(), ((zzbhp) zzbhh).zzt().zza, str).zzb();
        }
    }
}
