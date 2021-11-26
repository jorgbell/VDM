package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdrk {
    public static zzdqp zza(List<zzdqp> list, zzdqp zzdqp) {
        return list.get(0);
    }

    public static zzyx zzb(Context context, List<zzdqp> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdqp next : list) {
            if (next.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(next.zza, next.zzb));
            }
        }
        return new zzyx(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdqp zzc(zzyx zzyx) {
        if (zzyx.zzi) {
            return new zzdqp(-3, 0, true);
        }
        return new zzdqp(zzyx.zze, zzyx.zzb, false);
    }
}
