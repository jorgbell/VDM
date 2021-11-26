package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public final class zzhd {
    static final zzhd zza = new zzhd(true);
    private static volatile zzhd zzc;
    private static volatile zzhd zzd;
    private final Map<zzhc, zzhp<?, ?>> zze;

    zzhd() {
        this.zze = new HashMap();
    }

    public static zzhd zza() {
        zzhd zzhd = zzc;
        if (zzhd == null) {
            synchronized (zzhd.class) {
                zzhd = zzc;
                if (zzhd == null) {
                    zzhd = zza;
                    zzc = zzhd;
                }
            }
        }
        return zzhd;
    }

    public final <ContainingType extends zziw> zzhp<ContainingType, ?> zzc(ContainingType containingtype, int i) {
        return this.zze.get(new zzhc(containingtype, i));
    }

    zzhd(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzhd zzb() {
        Class<zzhd> cls = zzhd.class;
        zzhd zzhd = zzd;
        if (zzhd != null) {
            return zzhd;
        }
        synchronized (cls) {
            zzhd zzhd2 = zzd;
            if (zzhd2 != null) {
                return zzhd2;
            }
            zzhd zzb = zzhl.zzb(cls);
            zzd = zzb;
            return zzb;
        }
    }
}
