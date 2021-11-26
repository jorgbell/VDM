package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcld {
    @GuardedBy("this")
    private final Map<String, zzclc> zza = new HashMap();

    zzcld() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzdrx zzdrx) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzclc(str, zzdrx.zzz(), zzdrx.zzA()));
            } catch (zzdrl unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb(String str, zzasi zzasi) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzclc(str, zzasi.zzf(), zzasi.zzg()));
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    public final synchronized zzclc zzc(String str) {
        return this.zza.get(str);
    }

    @Nullable
    public final zzclc zzd(List<String> list) {
        for (String zzc : list) {
            zzclc zzc2 = zzc(zzc);
            if (zzc2 != null) {
                return zzc2;
            }
        }
        return null;
    }
}
