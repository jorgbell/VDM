package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzir {
    zzir() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zziq zziq = (zziq) obj;
        zzip zzip = (zzip) obj2;
        if (zziq.isEmpty()) {
            return 0;
        }
        Iterator it = zziq.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zziq zziq = (zziq) obj;
        zziq zziq2 = (zziq) obj2;
        if (!zziq2.isEmpty()) {
            if (!zziq.zze()) {
                zziq = zziq.zzc();
            }
            zziq.zzb(zziq2);
        }
        return zziq;
    }
}
