package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzafu;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzdiw;
import com.google.android.gms.internal.ads.zzys;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzq {
    private final Context zza;
    private final String zzb;
    private final Map<String, String> zzc = new TreeMap();
    private String zzd;
    private String zze;

    public zzq(Context context, String str) {
        this.zza = context.getApplicationContext();
        this.zzb = str;
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final Map<String, String> zzd() {
        return this.zzc;
    }

    public final void zze(zzys zzys, zzbbq zzbbq) {
        this.zzd = zzys.zzj.zza;
        Bundle bundle = zzys.zzm;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 != null) {
            String zze2 = zzafu.zzc.zze();
            for (String str : bundle2.keySet()) {
                if (zze2.equals(str)) {
                    this.zze = bundle2.getString(str);
                } else if (str.startsWith("csa_")) {
                    this.zzc.put(str.substring(4), bundle2.getString(str));
                }
            }
            this.zzc.put("SDKVersion", zzbbq.zza);
            if (zzafu.zza.zze().booleanValue()) {
                try {
                    Bundle zzb2 = zzdiw.zzb(this.zza, new JSONArray(zzafu.zzb.zze()));
                    for (String str2 : zzb2.keySet()) {
                        this.zzc.put(str2, zzb2.get(str2).toString());
                    }
                } catch (JSONException e) {
                    zzbbk.zzg("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e);
                }
            }
        }
    }
}
