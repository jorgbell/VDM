package com.google.android.gms.internal.ads;

import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzchy {
    private final Executor zza;
    private final zzcht zzb;

    public zzchy(Executor executor, zzcht zzcht) {
        this.zza = executor;
        this.zzb = zzcht;
    }

    public final zzefw<List<zzchx>> zza(JSONObject jSONObject, String str) {
        zzefw<O> zzefw;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzefo.zza(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                zzefw = zzefo.zza(null);
            } else {
                String optString = optJSONObject.optString(MediationMetaData.KEY_NAME);
                if (optString == null) {
                    zzefw = zzefo.zza(null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        zzefw = zzefo.zza(new zzchx(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        zzefw = zzefo.zzi(this.zzb.zza(optJSONObject, "image_value"), new zzchw(optString), this.zza);
                    } else {
                        zzefw = zzefo.zza(null);
                    }
                }
            }
            arrayList.add(zzefw);
        }
        return zzefo.zzi(zzefo.zzj(arrayList), zzchv.zza, this.zza);
    }
}
