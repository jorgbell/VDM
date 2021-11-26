package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcti implements zzaox<zzctj> {
    zzcti() {
    }

    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzctj zzctj = (zzctj) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzctj.zzc.zzc());
        jSONObject2.put("signals", zzctj.zzb);
        jSONObject3.put("body", zzctj.zza.zzc);
        jSONObject3.put("headers", zzs.zzc().zzf(zzctj.zza.zzb));
        jSONObject3.put("response_code", zzctj.zza.zza);
        jSONObject3.put("latency", zzctj.zza.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzctj.zzc.zzh());
        return jSONObject;
    }
}
