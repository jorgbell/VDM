package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzacg;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzzb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class ResponseInfo {
    private final zzacg zza;
    private final List<AdapterResponseInfo> zzb = new ArrayList();

    private ResponseInfo(zzacg zzacg) {
        this.zza = zzacg;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfx)).booleanValue() && zzacg != null) {
            try {
                List<zzzb> zzg = zzacg.zzg();
                if (zzg != null) {
                    for (zzzb zza2 : zzg) {
                        AdapterResponseInfo zza3 = AdapterResponseInfo.zza(zza2);
                        if (zza3 != null) {
                            this.zzb.add(zza3);
                        }
                    }
                }
            } catch (RemoteException e) {
                zzbbk.zzg("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
    }

    public static ResponseInfo zzb(zzacg zzacg) {
        if (zzacg != null) {
            return new ResponseInfo(zzacg);
        }
        return null;
    }

    @RecentlyNullable
    public String getMediationAdapterClassName() {
        try {
            zzacg zzacg = this.zza;
            if (zzacg != null) {
                return zzacg.zze();
            }
            return null;
        } catch (RemoteException e) {
            zzbbk.zzg("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    @RecentlyNullable
    public String getResponseId() {
        try {
            zzacg zzacg = this.zza;
            if (zzacg != null) {
                return zzacg.zzf();
            }
            return null;
        } catch (RemoteException e) {
            zzbbk.zzg("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    @RecentlyNonNull
    public String toString() {
        try {
            return zza().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @RecentlyNonNull
    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo zzb2 : this.zzb) {
            jSONArray.put(zzb2.zzb());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        return jSONObject;
    }
}
