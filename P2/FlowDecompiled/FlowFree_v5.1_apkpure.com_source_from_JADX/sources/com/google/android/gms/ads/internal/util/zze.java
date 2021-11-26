package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzage;
import com.google.android.gms.internal.ads.zzbbk;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zze extends zzbbk {
    public static void zza(String str) {
        if (zzc()) {
            Log.v("Ads", str);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzc()) {
            Log.v("Ads", str, th);
        }
    }

    public static boolean zzc() {
        return zzbbk.zzm(2) && zzage.zza.zze().booleanValue();
    }
}
