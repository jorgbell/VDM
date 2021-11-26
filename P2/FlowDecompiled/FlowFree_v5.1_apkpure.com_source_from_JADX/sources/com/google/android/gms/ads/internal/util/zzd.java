package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbbj;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzefw;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzd {
    public static void zza(Context context) {
        if (zzbbj.zzk(context) && !zzbbj.zzi()) {
            zzefw<?> zzb = new zzc(context).zzb();
            zzbbk.zzh("Updating ad debug logging enablement.");
            zzbbz.zza(zzb, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
