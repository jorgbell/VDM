package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcyq implements Callable {
    private final zzcyr zza;
    private final zzefw zzb;
    private final zzefw zzc;
    private final zzdra zzd;
    private final zzdqo zze;
    private final JSONObject zzf;

    zzcyq(zzcyr zzcyr, zzefw zzefw, zzefw zzefw2, zzdra zzdra, zzdqo zzdqo, JSONObject jSONObject) {
        this.zza = zzcyr;
        this.zzb = zzefw;
        this.zzc = zzefw2;
        this.zzd = zzdra;
        this.zze = zzdqo;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
