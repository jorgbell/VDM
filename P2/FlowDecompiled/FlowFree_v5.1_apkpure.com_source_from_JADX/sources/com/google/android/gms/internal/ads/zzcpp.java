package com.google.android.gms.internal.ads;

import android.os.IBinder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcpp implements zzbui, zzbww, zzbvv {
    private final zzcpz zza;
    private final String zzb;
    private int zzc = 0;
    private zzcpo zzd = zzcpo.AD_REQUESTED;
    private zzbty zze;
    private zzym zzf;

    zzcpp(zzcpz zzcpz, zzdrg zzdrg) {
        this.zza = zzcpz;
        this.zzb = zzdrg.zzf;
    }

    private static JSONObject zzd(zzbty zzbty) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzbty.zze());
        jSONObject2.put("responseSecsSinceEpoch", zzbty.zzc());
        jSONObject2.put("responseId", zzbty.zzf());
        JSONArray jSONArray = new JSONArray();
        List<zzzb> zzg = zzbty.zzg();
        if (zzg != null) {
            for (zzzb next : zzg) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("adapterClassName", next.zza);
                jSONObject3.put("latencyMillis", next.zzb);
                zzym zzym = next.zzc;
                if (zzym == null) {
                    jSONObject = null;
                } else {
                    jSONObject = zze(zzym);
                }
                jSONObject3.put("error", jSONObject);
                jSONArray.put(jSONObject3);
            }
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    private static JSONObject zze(zzym zzym) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zzym.zzc);
        jSONObject.put("errorCode", zzym.zza);
        jSONObject.put("errorDescription", zzym.zzb);
        zzym zzym2 = zzym.zzd;
        jSONObject.put("underlyingError", zzym2 == null ? null : zze(zzym2));
        return jSONObject;
    }

    public final void zza(zzbql zzbql) {
        this.zze = zzbql.zzm();
        this.zzd = zzcpo.AD_LOADED;
    }

    public final boolean zzb() {
        return this.zzd != zzcpo.AD_REQUESTED;
    }

    public final void zzbC(zzym zzym) {
        this.zzd = zzcpo.AD_LOAD_FAILED;
        this.zzf = zzym;
    }

    public final JSONObject zzc() throws JSONException {
        String str;
        IBinder iBinder;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", this.zzd);
        switch (this.zzc) {
            case 1:
                str = "BANNER";
                break;
            case 2:
                str = "INTERSTITIAL";
                break;
            case 3:
                str = "NATIVE_EXPRESS";
                break;
            case 4:
                str = "NATIVE";
                break;
            case 5:
                str = "REWARDED";
                break;
            case 6:
                str = "APP_OPEN_AD";
                break;
            case 7:
                str = "REWARDED_INTERSTITIAL";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        jSONObject.put("format", str);
        zzbty zzbty = this.zze;
        JSONObject jSONObject2 = null;
        if (zzbty != null) {
            jSONObject2 = zzd(zzbty);
        } else {
            zzym zzym = this.zzf;
            if (!(zzym == null || (iBinder = zzym.zze) == null)) {
                zzbty zzbty2 = (zzbty) iBinder;
                jSONObject2 = zzd(zzbty2);
                List<zzzb> zzg = zzbty2.zzg();
                if (zzg != null && zzg.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zze(this.zzf));
                    jSONObject2.put("errors", jSONArray);
                }
            }
        }
        jSONObject.put("responseInfo", jSONObject2);
        return jSONObject;
    }

    public final void zzj(zzawc zzawc) {
        this.zza.zzg(this.zzb, this);
    }

    public final void zzq(zzdra zzdra) {
        this.zzc = zzdra.zzb.zza.get(0).zzb;
    }
}
