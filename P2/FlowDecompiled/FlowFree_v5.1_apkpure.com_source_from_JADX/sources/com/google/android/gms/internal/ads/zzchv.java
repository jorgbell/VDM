package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzchv implements zzecb {
    static final zzecb zza = new zzchv();

    private zzchv() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzchx zzchx : (List) obj) {
            if (zzchx != null) {
                arrayList.add(zzchx);
            }
        }
        return arrayList;
    }
}
