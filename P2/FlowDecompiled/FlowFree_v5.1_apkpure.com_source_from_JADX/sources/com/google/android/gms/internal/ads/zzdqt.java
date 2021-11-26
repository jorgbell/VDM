package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbk;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdqt {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    zzdqt(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzc2 = zzbk.zzc(jsonReader);
        this.zzd = zzc2;
        this.zza = zzc2.optString("ad_html", (String) null);
        this.zzb = zzc2.optString("ad_base_url", (String) null);
        this.zzc = zzc2.optJSONObject("ad_json");
    }
}
