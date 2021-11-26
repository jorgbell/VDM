package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyk implements zzcvy<zzdrx, zzcxs> {
    private final zzclg zza;

    public zzcyk(zzclg zzclg) {
        this.zza = zzclg;
    }

    public final zzcvz<zzdrx, zzcxs> zza(String str, JSONObject jSONObject) throws zzdrl {
        return new zzcvz<>(this.zza.zzb(str, jSONObject), new zzcxs(), str);
    }
}
