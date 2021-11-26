package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeew<V> extends zzeey<V, List<V>> {
    zzeew(zzedb<? extends zzefw<? extends V>> zzedb, boolean z) {
        super(zzedb, true);
        zza();
    }

    public final /* bridge */ /* synthetic */ Object zzI(List list) {
        ArrayList zza = zzedm.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzeex zzeex = (zzeex) it.next();
            zza.add(zzeex != null ? zzeex.zza : null);
        }
        return Collections.unmodifiableList(zza);
    }
}
