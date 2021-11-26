package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzqh {
    public static void zza(String str) {
        if (zzqj.zza >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void zzb() {
        if (zzqj.zza >= 18) {
            Trace.endSection();
        }
    }
}
