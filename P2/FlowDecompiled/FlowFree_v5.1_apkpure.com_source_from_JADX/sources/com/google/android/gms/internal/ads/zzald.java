package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzald implements zzakp<Object> {
    private final Object zza = new Object();
    @GuardedBy("lock")
    private final Map<String, zzalc> zzb = new HashMap();

    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2 = map.get("id");
        String str3 = map.get("fail");
        String str4 = map.get("fail_reason");
        String str5 = map.get("fail_stack");
        String str6 = map.get("result");
        if (true == TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            String valueOf = String.valueOf(str5);
            str = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.zza) {
            zzalc remove = this.zzb.remove(str2);
            if (remove == null) {
                String valueOf2 = String.valueOf(str2);
                zzbbk.zzi(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str3)) {
                String valueOf3 = String.valueOf(str4);
                String valueOf4 = String.valueOf(str);
                remove.zzb(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str6 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zze.zzc()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zze.zza(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zza(jSONObject);
                } catch (JSONException e) {
                    remove.zzb(e.getMessage());
                }
            } else {
                remove.zza((JSONObject) null);
            }
        }
    }

    public final void zzb(String str, zzalc zzalc) {
        synchronized (this.zza) {
            this.zzb.put(str, zzalc);
        }
    }

    public final <EngineT extends zzanu> zzefw<JSONObject> zzc(EngineT enginet, String str, JSONObject jSONObject) {
        zzbcb zzbcb = new zzbcb();
        zzs.zzc();
        String uuid = UUID.randomUUID().toString();
        zzb(uuid, new zzalb(this, zzbcb));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", uuid);
            jSONObject2.put("args", jSONObject);
            enginet.zzr(str, jSONObject2);
        } catch (Exception e) {
            zzbcb.zzd(e);
        }
        return zzbcb;
    }
}
