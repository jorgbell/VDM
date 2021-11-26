package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzctr implements zzdui<zzctq, zzctm> {
    private final String zza;

    public zzctr(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzctq zzctq = (zzctq) obj;
        int optInt = zzctq.zza.optInt("http_timeout_millis", 60000);
        zzawf zzb = zzctq.zzb;
        if (zzb.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzctq.zzb.zzg() && !TextUtils.isEmpty(this.zza)) {
                hashMap.put("Cookie", this.zza);
            }
            String str = "";
            if (zzctq.zzb.zzf()) {
                JSONObject optJSONObject = zzctq.zza.optJSONObject("pii");
                if (optJSONObject != null) {
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos", str))) {
                        hashMap.put("x-afma-drt-cookie", optJSONObject.optString("doritos", str));
                    }
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", str))) {
                        hashMap.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", str));
                    }
                } else {
                    zze.zza("DSID signal does not exist.");
                }
            }
            if (zzctq.zzb != null && !TextUtils.isEmpty(zzctq.zzb.zzd())) {
                str = zzctq.zzb.zzd();
            }
            return new zzctm(zzctq.zzb.zze(), optInt, hashMap, str);
        } else if (zzb.zza() == 1) {
            if (zzb.zzb() != null) {
                zzbbk.zzf(TextUtils.join(", ", zzb.zzb()));
            }
            throw new zzcql(2, "Error building request URL.");
        } else {
            throw new zzcql(1);
        }
    }
}
