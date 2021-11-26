package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class AdValue {
    private AdValue(int i, String str, long j) {
    }

    @RecentlyNonNull
    public static AdValue zza(int i, @RecentlyNonNull String str, long j) {
        return new AdValue(i, str, j);
    }
}
