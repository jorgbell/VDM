package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcjd implements zzeev {
    private final zzcjo zza;
    private final String zzb;
    private final JSONObject zzc;

    zzcjd(zzcjo zzcjo, String str, JSONObject jSONObject) {
        this.zza = zzcjo;
        this.zzb = str;
        this.zzc = jSONObject;
    }

    public final zzefw zza(Object obj) {
        return this.zza.zzi(this.zzb, this.zzc, (zzbgf) obj);
    }
}
