package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbfs {
    private final ArrayList<zzpi> zza = new ArrayList<>();
    private long zzb;

    zzbfs() {
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        Iterator<zzpi> it = this.zza.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> zze = it.next().zze();
            if (zze != null) {
                for (Map.Entry next : zze.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) next.getKey())) {
                            this.zzb = Math.max(this.zzb, Long.parseLong((String) ((List) next.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzpi zzpi) {
        this.zza.add(zzpi);
    }
}
