package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzapw {
    public final List<zzapv> zza;
    public final List<String> zzb;
    public final List<String> zzc;
    public final List<String> zzd;
    public final List<String> zze;
    public final List<String> zzf;

    public zzapw(JSONObject jSONObject) throws JSONException {
        String str;
        if (zzbbk.zzm(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            if (valueOf.length() != 0) {
                str = "Mediation Response JSON: ".concat(valueOf);
            } else {
                str = new String("Mediation Response JSON: ");
            }
            zze.zza(str);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzapv zzapv = new zzapv(jSONArray.getJSONObject(i2));
                "banner".equalsIgnoreCase(zzapv.zzv);
                arrayList.add(zzapv);
                if (i < 0) {
                    Iterator<String> it = zzapv.zzc.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                i = i2;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzs.zzu();
            this.zzb = zzapx.zza(optJSONObject, "click_urls");
            zzs.zzu();
            this.zzc = zzapx.zza(optJSONObject, "imp_urls");
            zzs.zzu();
            this.zzd = zzapx.zza(optJSONObject, "downloaded_imp_urls");
            zzs.zzu();
            this.zze = zzapx.zza(optJSONObject, "nofill_urls");
            zzs.zzu();
            this.zzf = zzapx.zza(optJSONObject, "remote_ping_urls");
            optJSONObject.optBoolean("render_in_browser", false);
            optJSONObject.optLong("refresh", -1);
            zzaxe zza2 = zzaxe.zza(optJSONObject.optJSONArray("rewards"));
            if (zza2 != null) {
                String str2 = zza2.zza;
            }
            optJSONObject.optBoolean("use_displayed_impression", false);
            optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            optJSONObject.optBoolean("allow_custom_click_gesture", false);
        }
    }
}
