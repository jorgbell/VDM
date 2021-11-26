package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzchj {
    private final zzefx zza;
    private final zzcht zzb;
    private final zzchy zzc;

    public zzchj(zzefx zzefx, zzcht zzcht, zzchy zzchy) {
        this.zza = zzefx;
        this.zzb = zzcht;
        this.zzc = zzchy;
    }

    public final zzefw<zzcex> zza(zzdra zzdra, zzdqo zzdqo, JSONObject jSONObject) {
        zzefw zzh;
        JSONObject jSONObject2 = jSONObject;
        zzdra zzdra2 = zzdra;
        zzefw zzb2 = this.zza.zzb(new zzchh(this, zzdra, zzdqo, jSONObject2));
        zzefw<List<zzagu>> zzb3 = this.zzb.zzb(jSONObject2, "images");
        zzefw<zzagu> zza2 = this.zzb.zza(jSONObject2, "secondary_image");
        zzefw<zzagu> zza3 = this.zzb.zza(jSONObject2, "app_icon");
        zzefw<zzagr> zzc2 = this.zzb.zzc(jSONObject2, "attribution");
        zzefw<zzbgf> zzd = this.zzb.zzd(jSONObject2);
        zzcht zzcht = this.zzb;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzh = zzefo.zza(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzh = zzefo.zza(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzh = zzefo.zza(null);
                } else {
                    zzh = zzefo.zzh(zzefo.zza(null), new zzcho(zzcht, optString), zzbbw.zze);
                }
            }
        }
        zzefw zzefw = zzh;
        zzefw<List<zzchx>> zza4 = this.zzc.zza(jSONObject2, "custom_assets");
        return zzefo.zzk(zzb2, zzb3, zza2, zza3, zzc2, zzd, zzefw, zza4).zza(new zzchi(this, zzb2, zzb3, zza3, zza2, zzc2, jSONObject, zzd, zzefw, zza4), this.zza);
    }
}
