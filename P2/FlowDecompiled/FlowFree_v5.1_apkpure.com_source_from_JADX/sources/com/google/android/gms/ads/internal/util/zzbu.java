package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbu {
    private static zzbu zzb;
    String zza;

    private zzbu() {
    }

    public static zzbu zza() {
        if (zzb == null) {
            zzb = new zzbu();
        }
        return zzb;
    }
}
