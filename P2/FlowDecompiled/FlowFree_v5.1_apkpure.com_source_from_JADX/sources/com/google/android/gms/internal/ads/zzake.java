package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzake implements zzakp<zzbgf> {
    zzake() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzc;
        zzbgf zzbgf = (zzbgf) obj;
        zzagw zzaq = zzbgf.zzaq();
        if (zzaq == null || (zzc = zzaq.zzc()) == null) {
            zzbgf.zzd("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzbgf.zzd("nativeAdViewSignalsReady", zzc);
        }
    }
}
