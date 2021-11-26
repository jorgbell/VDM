package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzsk implements Comparator<zzsq> {
    zzsk(zzsm zzsm) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzsq zzsq = (zzsq) obj;
        zzsq zzsq2 = (zzsq) obj2;
        int i = zzsq.zzc - zzsq2.zzc;
        if (i != 0) {
            return i;
        }
        return (int) (zzsq.zza - zzsq2.zza);
    }
}
