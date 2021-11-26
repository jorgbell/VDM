package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcok {
    /* access modifiers changed from: private */
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public Integer zzf;

    /* synthetic */ zzcok(String str, zzcoj zzcoj) {
        this.zzb = str;
    }

    static /* synthetic */ String zza(zzcok zzcok) {
        String str = (String) zzaaa.zzc().zzb(zzaeq.zzgi);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzcok.zza);
            jSONObject.put("eventCategory", zzcok.zzb);
            jSONObject.putOpt("event", zzcok.zzc);
            jSONObject.putOpt("errorCode", zzcok.zzd);
            jSONObject.putOpt("rewardType", zzcok.zze);
            jSONObject.putOpt("rewardAmount", zzcok.zzf);
        } catch (JSONException unused) {
            zzbbk.zzi("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(\"h5adsEvent\",");
        sb.append(jSONObject2);
        sb.append(");");
        return sb.toString();
    }
}
