package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzazu {
    static zzazu zza;

    public static synchronized zzazu zzd(Context context) {
        synchronized (zzazu.class) {
            zzazu zzazu = zza;
            if (zzazu != null) {
                return zzazu;
            }
            Context applicationContext = context.getApplicationContext();
            zzaeq.zza(applicationContext);
            zzg zzl = zzs.zzg().zzl();
            zzl.zza(applicationContext);
            zzayz zzayz = new zzayz((zzayy) null);
            zzayz.zza(applicationContext);
            zzayz.zzb(zzs.zzj());
            zzayz.zzc(zzl);
            zzayz.zzd(zzs.zzA());
            zzazu zze = zzayz.zze();
            zza = zze;
            zze.zza().zza();
            zza.zzb().zze();
            zzazz zzc = zza.zzc();
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzal)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) zzaaa.zzc().zzb(zzaeq.zzan));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String optString = optJSONArray.optString(i);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String zzb : hashMap.keySet()) {
                        zzc.zzb(zzb);
                    }
                    zzc.zza(new zzazw(zzc, hashMap));
                } catch (JSONException e) {
                    zzbbk.zze("Failed to parse listening list", e);
                }
            }
            zzazu zzazu2 = zza;
            return zzazu2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract zzays zza();

    /* access modifiers changed from: package-private */
    public abstract zzayw zzb();

    /* access modifiers changed from: package-private */
    public abstract zzazz zzc();
}
