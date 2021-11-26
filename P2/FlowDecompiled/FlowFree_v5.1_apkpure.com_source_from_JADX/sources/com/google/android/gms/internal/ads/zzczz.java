package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczz implements zzcvy<zzdrx, zzcxt> {
    @GuardedBy("this")
    private final Map<String, zzcvz<zzdrx, zzcxt>> zza = new HashMap();
    private final zzclg zzb;

    public zzczz(zzclg zzclg) {
        this.zzb = zzclg;
    }

    public final zzcvz<zzdrx, zzcxt> zza(String str, JSONObject jSONObject) throws zzdrl {
        zzcvz<zzdrx, zzcxt> zzcvz;
        synchronized (this) {
            zzcvz = this.zza.get(str);
            if (zzcvz == null) {
                zzcvz = new zzcvz<>(this.zzb.zzb(str, jSONObject), new zzcxt(), str);
                this.zza.put(str, zzcvz);
            }
        }
        return zzcvz;
    }
}
