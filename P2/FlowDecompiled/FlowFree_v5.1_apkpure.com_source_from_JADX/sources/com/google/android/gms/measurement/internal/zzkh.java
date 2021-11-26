package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdk;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzkh {
    zzdk zza;
    List<Long> zzb;
    List<zzdc> zzc;
    long zzd;
    final /* synthetic */ zzki zze;

    /* synthetic */ zzkh(zzki zzki, zzkb zzkb) {
        this.zze = zzki;
    }

    private static final long zzb(zzdc zzdc) {
        return ((zzdc.zzf() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, zzdc zzdc) {
        Preconditions.checkNotNull(zzdc);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (this.zzc.size() > 0 && zzb(this.zzc.get(0)) != zzb(zzdc)) {
            return false;
        }
        long zzbw = this.zzd + ((long) zzdc.zzbw());
        this.zze.zzd();
        if (zzbw >= ((long) Math.max(0, zzea.zzh.zzb(null).intValue()))) {
            return false;
        }
        this.zzd = zzbw;
        this.zzc.add(zzdc);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        this.zze.zzd();
        if (size >= Math.max(1, zzea.zzi.zzb(null).intValue())) {
            return false;
        }
        return true;
    }
}
