package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeuj {
    zzeuj() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzeui zzeui = (zzeui) obj;
        zzeuh zzeuh = (zzeuh) obj2;
        if (zzeui.isEmpty()) {
            return 0;
        }
        Iterator it = zzeui.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzeui) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzeui zzeui = (zzeui) obj;
        zzeui zzeui2 = (zzeui) obj2;
        if (!zzeui2.isEmpty()) {
            if (!zzeui.zze()) {
                zzeui = zzeui.zzc();
            }
            zzeui.zzb(zzeui2);
        }
        return zzeui;
    }
}
