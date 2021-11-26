package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbng implements zzeyl<JSONObject> {
    private final zzeyw<zzdqo> zza;

    public zzbng(zzeyw<zzdqo> zzeyw) {
        this.zza = zzeyw;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzbrb) this.zza).zza().zzy);
        } catch (JSONException unused) {
            return null;
        }
    }
}
