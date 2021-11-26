package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzfy implements zzeax {
    private final zzdyw zza;
    private final zzdzn zzb;
    private final zzgl zzc;
    private final zzfx zzd;

    zzfy(zzdyw zzdyw, zzdzn zzdzn, zzgl zzgl, zzfx zzfx) {
        this.zza = zzdyw;
        this.zzb = zzdzn;
        this.zzc = zzgl;
        this.zzd = zzfx;
    }

    private final Map<String, Object> zze() {
        HashMap hashMap = new HashMap();
        zzdc zzc2 = this.zzb.zzc();
        hashMap.put("v", this.zza.zza());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzc2.zzc());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void zza(View view) {
        this.zzc.zza(view);
    }

    public final Map<String, Object> zzb() {
        Map<String, Object> zze = zze();
        zzdc zzb2 = this.zzb.zzb();
        zze.put("gai", Boolean.valueOf(this.zza.zzb()));
        zze.put("did", zzb2.zzd());
        zze.put("dst", Integer.valueOf(zzb2.zze().zza()));
        zze.put("doo", Boolean.valueOf(zzb2.zzf()));
        return zze;
    }

    public final Map<String, Object> zzc() {
        return zze();
    }

    public final Map<String, Object> zzd() {
        Map<String, Object> zze = zze();
        zze.put("lts", Long.valueOf(this.zzc.zzc()));
        return zze;
    }
}
