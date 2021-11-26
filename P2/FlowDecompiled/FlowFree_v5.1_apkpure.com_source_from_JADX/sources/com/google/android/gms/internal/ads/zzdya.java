package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdya {
    private JSONObject zza;
    private final zzdyj zzb;

    public zzdya(zzdyj zzdyj) {
        this.zzb = zzdyj;
    }

    public final void zza(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.zzb.zza(new zzdym(this, hashSet, jSONObject, j, (long) null));
    }

    public final void zzb(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.zzb.zza(new zzdyl(this, hashSet, jSONObject, j, (long) null));
    }

    public final void zzc() {
        this.zzb.zza(new zzdyk(this, (byte[]) null));
    }

    public final JSONObject zzd() {
        return this.zza;
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
