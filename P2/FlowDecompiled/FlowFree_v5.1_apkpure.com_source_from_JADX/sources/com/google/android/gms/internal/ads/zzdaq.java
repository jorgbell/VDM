package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdaq implements zzcvy<zzasi, zzcxs> {
    private final zzdbu zza;

    public zzdaq(zzdbu zzdbu) {
        this.zza = zzdbu;
    }

    public final zzcvz<zzasi, zzcxs> zza(String str, JSONObject jSONObject) throws zzdrl {
        zzasi zzb = this.zza.zzb(str);
        if (zzb == null) {
            return null;
        }
        return new zzcvz<>(zzb, new zzcxs(), str);
    }
}
