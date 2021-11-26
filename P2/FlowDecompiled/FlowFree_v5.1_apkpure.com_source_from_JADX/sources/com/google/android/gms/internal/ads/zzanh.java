package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final /* synthetic */ class zzanh {
    public static void zza(zzani zzani, String str, JSONObject jSONObject) {
        zzani.zzb(str, jSONObject.toString());
    }

    public static void zzb(zzani zzani, String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzani.zza(sb.toString());
    }

    public static void zzc(zzani zzani, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzbbk.zzd(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzani.zza(sb.toString());
    }

    public static void zzd(zzani zzani, String str, Map map) {
        try {
            zzani.zzd(str, zzs.zzc().zzf(map));
        } catch (JSONException unused) {
            zzbbk.zzi("Could not convert parameters to JSON.");
        }
    }
}
