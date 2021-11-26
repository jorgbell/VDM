package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdif implements Callable {
    private final List zza;

    zzdif(List list) {
        this.zza = list;
    }

    public final Object call() {
        List<zzefw> list = this.zza;
        JSONArray jSONArray = new JSONArray();
        for (zzefw zzefw : list) {
            if (((JSONObject) zzefw.get()) != null) {
                jSONArray.put(zzefw.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzdih(jSONArray.toString());
    }
}
