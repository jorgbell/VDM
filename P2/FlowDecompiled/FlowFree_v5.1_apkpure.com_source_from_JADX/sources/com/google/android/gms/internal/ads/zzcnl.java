package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcnl implements zzdvf {
    private final Map<zzduy, Long> zza = new HashMap();
    private final zzcne zzb;
    private final Clock zzc;
    private final Map<zzduy, zzcnk> zzd = new HashMap();

    public zzcnl(zzcne zzcne, Set<zzcnk> set, Clock clock) {
        this.zzb = zzcne;
        for (zzcnk next : set) {
            this.zzd.put(next.zzc, next);
        }
        this.zzc = clock;
    }

    private final void zze(zzduy zzduy, boolean z) {
        zzduy zzb2 = this.zzd.get(zzduy).zzb;
        String str = true != z ? "f." : "s.";
        if (this.zza.containsKey(zzb2)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzb2).longValue();
            Map<String, String> zzc2 = this.zzb.zzc();
            String zzc3 = this.zzd.get(zzduy).zza;
            String concat = zzc3.length() != 0 ? "label.".concat(zzc3) : new String("label.");
            String valueOf = String.valueOf(Long.toString(elapsedRealtime));
            zzc2.put(concat, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public final void zzbE(zzduy zzduy, String str) {
    }

    public final void zzbF(zzduy zzduy, String str) {
        this.zza.put(zzduy, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    public final void zzbG(zzduy zzduy, String str, Throwable th) {
        if (this.zza.containsKey(zzduy)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzduy).longValue();
            Map<String, String> zzc2 = this.zzb.zzc();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzc2.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzd.containsKey(zzduy)) {
            zze(zzduy, false);
        }
    }

    public final void zzbH(zzduy zzduy, String str) {
        if (this.zza.containsKey(zzduy)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzduy).longValue();
            Map<String, String> zzc2 = this.zzb.zzc();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzc2.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzd.containsKey(zzduy)) {
            zze(zzduy, true);
        }
    }
}
