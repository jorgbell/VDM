package com.google.ads;

import androidx.annotation.RecentlyNonNull;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class AdSize {
    @RecentlyNonNull
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    @RecentlyNonNull
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    @RecentlyNonNull
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    @RecentlyNonNull
    public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
    @RecentlyNonNull
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    @RecentlyNonNull
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    private final com.google.android.gms.ads.AdSize zza;

    public AdSize(@RecentlyNonNull com.google.android.gms.ads.AdSize adSize) {
        this.zza = adSize;
    }

    public boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.zza.equals(((AdSize) obj).zza);
    }

    public int getHeight() {
        return this.zza.getHeight();
    }

    public int getWidth() {
        return this.zza.getWidth();
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @RecentlyNonNull
    public String toString() {
        return this.zza.toString();
    }

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }
}
