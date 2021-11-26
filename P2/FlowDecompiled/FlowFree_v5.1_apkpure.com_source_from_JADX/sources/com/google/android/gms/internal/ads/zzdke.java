package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdke implements zzdiy<JSONObject> {
    private final String zza;

    public zzdke(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        try {
            JSONObject zzg = zzbk.zzg((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.zza)) {
                zzg.put("attok", this.zza);
            }
        } catch (JSONException e) {
            zze.zzb("Failed putting attestation token.", e);
        }
    }
}
