package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdjb implements Callable {
    private final List zza;
    private final Object zzb;

    zzdjb(List list, Object obj) {
        this.zza = list;
        this.zzb = obj;
    }

    public final Object call() {
        List<zzefw> list = this.zza;
        Object obj = this.zzb;
        for (zzefw zzefw : list) {
            zzdiy zzdiy = (zzdiy) zzefw.get();
            if (zzdiy != null) {
                zzdiy.zzd(obj);
            }
        }
        return obj;
    }
}
