package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfb extends zzcfc {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;

    public zzcfb(zzdqo zzdqo, JSONObject jSONObject) {
        super(zzdqo);
        this.zzb = zzbk.zzh(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzc = zzbk.zzi(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = zzbk.zzi(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zze = zzbk.zzi(false, jSONObject, "enable_omid");
        this.zzf = jSONObject.optJSONObject("overlay") != null ? true : z;
    }

    public final JSONObject zza() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzy);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzd;
    }
}
