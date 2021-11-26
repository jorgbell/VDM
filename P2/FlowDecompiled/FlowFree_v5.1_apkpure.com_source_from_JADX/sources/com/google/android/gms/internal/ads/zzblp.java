package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzblp {
    private final Map<String, zzbls> zza;
    private final Map<String, zzblr> zzb;

    zzblp(Map<String, zzbls> map, Map<String, zzblr> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzdra zzdra) throws Exception {
        for (zzdqy next : zzdra.zzb.zzc) {
            if (this.zza.containsKey(next.zza)) {
                this.zza.get(next.zza).zza(next.zzb);
            } else if (this.zzb.containsKey(next.zza)) {
                zzblr zzblr = this.zzb.get(next.zza);
                JSONObject jSONObject = next.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    String optString = jSONObject.optString(next2);
                    if (optString != null) {
                        hashMap.put(next2, optString);
                    }
                }
                zzblr.zza(hashMap);
            }
        }
    }
}
