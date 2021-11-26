package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzchl implements zzecb {
    static final zzecb zza = new zzchl();

    private zzchl() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzagu zzagu : (List) obj) {
            if (zzagu != null) {
                arrayList.add(zzagu);
            }
        }
        return arrayList;
    }
}
