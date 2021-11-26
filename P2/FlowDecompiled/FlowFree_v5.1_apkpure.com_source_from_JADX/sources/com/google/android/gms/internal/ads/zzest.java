package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzest {
    static final zzest zza = new zzest(true);
    private static volatile zzest zzc;
    private static volatile zzest zzd;
    private final Map<zzess, zzetf<?, ?>> zze;

    zzest() {
        this.zze = new HashMap();
    }

    public static zzest zza() {
        zzest zzest = zzc;
        if (zzest == null) {
            synchronized (zzest.class) {
                zzest = zzc;
                if (zzest == null) {
                    zzest = zza;
                    zzc = zzest;
                }
            }
        }
        return zzest;
    }

    public final <ContainingType extends zzeuo> zzetf<ContainingType, ?> zzc(ContainingType containingtype, int i) {
        return this.zze.get(new zzess(containingtype, i));
    }

    zzest(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzest zzb() {
        Class<zzest> cls = zzest.class;
        zzest zzest = zzd;
        if (zzest != null) {
            return zzest;
        }
        synchronized (cls) {
            zzest zzest2 = zzd;
            if (zzest2 != null) {
                return zzest2;
            }
            zzest zzb = zzetb.zzb(cls);
            zzd = zzb;
            return zzb;
        }
    }
}
