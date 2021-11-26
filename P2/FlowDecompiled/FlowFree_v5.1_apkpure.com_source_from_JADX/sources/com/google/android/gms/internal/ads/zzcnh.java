package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcnh {
    final /* synthetic */ zzcni zza;
    private final Map<String, String> zzb = new ConcurrentHashMap();

    zzcnh(zzcni zzcni) {
        this.zza = zzcni;
    }

    public final zzcnh zza(zzdqr zzdqr) {
        this.zzb.put("gqi", zzdqr.zzb);
        return this;
    }

    public final zzcnh zzb(zzdqo zzdqo) {
        this.zzb.put("aai", zzdqo.zzv);
        return this;
    }

    public final zzcnh zzc(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final void zzd() {
        this.zza.zzb.execute(new zzcng(this));
    }

    public final String zze() {
        return this.zza.zza.zzc(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zza.zza.zzb(this.zzb);
    }
}
