package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzchh implements Callable {
    private final zzdra zzb;
    private final zzdqo zzc;
    private final JSONObject zzd;

    zzchh(zzchj zzchj, zzdra zzdra, zzdqo zzdqo, JSONObject jSONObject) {
        this.zzb = zzdra;
        this.zzc = zzdqo;
        this.zzd = jSONObject;
    }

    public final Object call() {
        zzdra zzdra = this.zzb;
        zzdqo zzdqo = this.zzc;
        JSONObject jSONObject = this.zzd;
        zzcex zzcex = new zzcex();
        zzcex.zza(jSONObject.optInt("template_id", -1));
        zzcex.zzk(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzcex.zzr(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzdrg zzdrg = zzdra.zza.zza;
        if (zzdrg.zzg.contains(Integer.toString(zzcex.zzt()))) {
            if (zzcex.zzt() == 3) {
                if (zzcex.zzN() == null) {
                    throw new zzczn(1, "No custom template id for custom template ad response.");
                } else if (!zzdrg.zzh.contains(zzcex.zzN())) {
                    throw new zzczn(1, "Unexpected custom template id in the response.");
                }
            }
            zzcex.zzh(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzdqo.zzH) {
                zzs.zzc();
                String zzB = zzr.zzB();
                StringBuilder sb = new StringBuilder(String.valueOf(zzB).length() + 3 + String.valueOf(optString).length());
                sb.append(zzB);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzcex.zzo("headline", optString);
            zzcex.zzo("body", jSONObject.optString("body", (String) null));
            zzcex.zzo("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzcex.zzo(TransactionErrorDetailsUtilities.STORE, jSONObject.optString(TransactionErrorDetailsUtilities.STORE, (String) null));
            zzcex.zzo("price", jSONObject.optString("price", (String) null));
            zzcex.zzo("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzcex;
        }
        int zzt = zzcex.zzt();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(zzt);
        throw new zzczn(1, sb2.toString());
    }
}
