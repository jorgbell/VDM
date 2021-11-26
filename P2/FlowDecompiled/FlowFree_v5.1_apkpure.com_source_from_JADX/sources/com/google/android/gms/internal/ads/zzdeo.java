package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdeo implements zzdiz<zzdiy<Bundle>> {
    private final Set<String> zza;

    zzdeo(Set<String> set) {
        this.zza = set;
    }

    public final zzefw<zzdiy<Bundle>> zza() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zza) {
            arrayList.add(add);
        }
        return zzefo.zza(new zzden(arrayList));
    }
}
