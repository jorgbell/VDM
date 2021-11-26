package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdli implements zzdiy<JSONObject> {
    private final Map<String, Object> zza;

    public zzdli(Map<String, Object> map) {
        this.zza = map;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzs.zzc().zzf(this.zza));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zze.zza(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
