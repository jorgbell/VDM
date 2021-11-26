package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcrq implements zzeev {
    private final zzyk zzb;

    zzcrq(zzcrt zzcrt, zzyk zzyk) {
        this.zzb = zzyk;
    }

    public final zzefw zza(Object obj) {
        zzyk zzyk = this.zzb;
        String str = (String) obj;
        String str2 = zzyk.zza;
        String str3 = zzyk.zzb;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzefo.zza(jSONObject);
    }
}
