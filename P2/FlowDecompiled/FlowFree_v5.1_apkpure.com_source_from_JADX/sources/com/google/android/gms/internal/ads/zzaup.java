package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaup {
    public final boolean zza;
    public final String zzb;

    public zzaup(boolean z, String str) {
        this.zza = z;
        this.zzb = str;
    }

    public static zzaup zza(JSONObject jSONObject) {
        return new zzaup(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
