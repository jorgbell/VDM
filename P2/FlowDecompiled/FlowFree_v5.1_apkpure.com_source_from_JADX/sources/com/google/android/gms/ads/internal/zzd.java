package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzeev;
import com.google.android.gms.internal.ads.zzefo;
import com.google.android.gms.internal.ads.zzefw;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzd implements zzeev {
    static final zzeev zza = new zzd();

    private zzd() {
    }

    public final zzefw zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzs.zzg().zzl().zzm(jSONObject.getString("appSettingsJson"));
        }
        return zzefo.zza(null);
    }
}
