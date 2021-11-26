package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzecb;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzi implements zzecb {
    static final zzecb zza = new zzi();

    private zzi() {
    }

    public final Object apply(Object obj) {
        int i = zzp.zze;
        return ((JSONObject) obj).optString("nas");
    }
}
