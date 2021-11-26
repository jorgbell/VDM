package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaex {
    public static boolean zza(zzaff zzaff, zzafc zzafc, String... strArr) {
        if (zzafc == null) {
            return false;
        }
        zzaff.zzb(zzafc, zzs.zzj().elapsedRealtime(), strArr);
        return true;
    }
}
