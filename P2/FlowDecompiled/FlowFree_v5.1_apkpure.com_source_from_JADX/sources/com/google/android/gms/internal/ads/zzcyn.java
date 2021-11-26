package com.google.android.gms.internal.ads;

import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcyn implements zzeev {
    private final zzcyr zza;
    private final zzdra zzb;
    private final zzdqo zzc;

    zzcyn(zzcyr zzcyr, zzdra zzdra, zzdqo zzdqo) {
        this.zza = zzcyr;
        this.zzb = zzdra;
        this.zzc = zzdqo;
    }

    public final zzefw zza(Object obj) {
        return this.zza.zze(this.zzb, this.zzc, (JSONArray) obj);
    }
}
