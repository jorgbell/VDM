package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzgr {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzz zzg;
    boolean zzh = true;
    final Long zzi;
    String zzj;

    public zzgr(Context context, zzz zzz, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzz != null) {
            this.zzg = zzz;
            this.zzb = zzz.zzf;
            this.zzc = zzz.zze;
            this.zzd = zzz.zzd;
            this.zzh = zzz.zzc;
            this.zzf = zzz.zzb;
            this.zzj = zzz.zzh;
            Bundle bundle = zzz.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
