package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdkl implements zzdiz<zzdiy<JSONObject>> {
    private final JSONObject zza;

    zzdkl(Context context) {
        this.zza = zzawm.zzb(context);
    }

    public final zzefw<zzdiy<JSONObject>> zza() {
        return zzefo.zza(new zzdkk(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zza);
        } catch (JSONException unused) {
            zze.zza("Failed putting version constants.");
        }
    }
}
