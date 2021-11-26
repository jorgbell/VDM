package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzaka implements zzakp {
    static final zzakp zza = new zzaka();

    private zzaka() {
    }

    public final void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        zzakp<zzbgf> zzakp = zzako.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzbbk.zzi("URL missing from click GMSG.");
        } else {
            zzefo.zzo(zzako.zza(zzbgf, str), new zzakf(zzbgf), zzbbw.zza);
        }
    }
}
