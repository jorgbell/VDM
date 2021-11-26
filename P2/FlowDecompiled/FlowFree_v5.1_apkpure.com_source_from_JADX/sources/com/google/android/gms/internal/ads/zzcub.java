package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcub implements zzdvf {
    private final Map<zzduy, String> zza = new HashMap();
    private final Map<zzduy, String> zzb = new HashMap();
    private final zzdvn zzc;

    public zzcub(Set<zzcua> set, zzdvn zzdvn) {
        this.zzc = zzdvn;
        for (zzcua next : set) {
            this.zza.put(next.zzb, next.zza);
            this.zzb.put(next.zzc, next.zza);
        }
    }

    public final void zzbE(zzduy zzduy, String str) {
    }

    public final void zzbF(zzduy zzduy, String str) {
        zzdvn zzdvn = this.zzc;
        String valueOf = String.valueOf(str);
        zzdvn.zzd(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."));
        if (this.zza.containsKey(zzduy)) {
            zzdvn zzdvn2 = this.zzc;
            String valueOf2 = String.valueOf(this.zza.get(zzduy));
            zzdvn2.zzd(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."));
        }
    }

    public final void zzbG(zzduy zzduy, String str, Throwable th) {
        zzdvn zzdvn = this.zzc;
        String valueOf = String.valueOf(str);
        zzdvn.zze(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."), "f.");
        if (this.zzb.containsKey(zzduy)) {
            zzdvn zzdvn2 = this.zzc;
            String valueOf2 = String.valueOf(this.zzb.get(zzduy));
            zzdvn2.zze(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "f.");
        }
    }

    public final void zzbH(zzduy zzduy, String str) {
        zzdvn zzdvn = this.zzc;
        String valueOf = String.valueOf(str);
        zzdvn.zze(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."), "s.");
        if (this.zzb.containsKey(zzduy)) {
            zzdvn zzdvn2 = this.zzc;
            String valueOf2 = String.valueOf(this.zzb.get(zzduy));
            zzdvn2.zze(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "s.");
        }
    }
}
