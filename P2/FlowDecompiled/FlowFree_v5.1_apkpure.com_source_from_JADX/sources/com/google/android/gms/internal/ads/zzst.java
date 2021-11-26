package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzst implements Comparator<zzsi> {
    public zzst(zzsu zzsu) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzsi zzsi = (zzsi) obj;
        zzsi zzsi2 = (zzsi) obj2;
        if (zzsi.zzb() >= zzsi2.zzb()) {
            if (zzsi.zzb() > zzsi2.zzb()) {
                return 1;
            }
            if (zzsi.zza() >= zzsi2.zza()) {
                if (zzsi.zza() > zzsi2.zza()) {
                    return 1;
                }
                float zzd = (zzsi.zzd() - zzsi.zzb()) * (zzsi.zzc() - zzsi.zza());
                float zzd2 = (zzsi2.zzd() - zzsi2.zzb()) * (zzsi2.zzc() - zzsi2.zza());
                if (zzd <= zzd2) {
                    if (zzd < zzd2) {
                        return 1;
                    }
                    return 0;
                }
            }
        }
        return -1;
    }
}
