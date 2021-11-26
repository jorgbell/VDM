package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzym;
import com.google.android.gms.internal.ads.zzzb;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class AdapterResponseInfo {
    private final zzzb zza;
    private final AdError zzb;

    private AdapterResponseInfo(zzzb zzzb) {
        this.zza = zzzb;
        zzym zzym = zzzb.zzc;
        this.zzb = zzym == null ? null : zzym.zza();
    }

    public static AdapterResponseInfo zza(zzzb zzzb) {
        if (zzzb != null) {
            return new AdapterResponseInfo(zzzb);
        }
        return null;
    }

    @RecentlyNonNull
    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @RecentlyNonNull
    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zza.zza);
        jSONObject.put("Latency", this.zza.zzb);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zza.zzd.keySet()) {
            jSONObject2.put(str, this.zza.zzd.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzb;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzb());
        }
        return jSONObject;
    }
}
