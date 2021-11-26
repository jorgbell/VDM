package com.google.android.gms.common.stats;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class WakeLockTracker {
    private static WakeLockTracker zza = new WakeLockTracker();

    @RecentlyNonNull
    public static WakeLockTracker getInstance() {
        return zza;
    }

    public void registerEvent(@RecentlyNonNull Context context, @RecentlyNonNull String str, int i, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull String str4, int i2, @RecentlyNonNull List<String> list) {
    }

    public void registerEvent(@RecentlyNonNull Context context, @RecentlyNonNull String str, int i, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull String str4, int i2, @RecentlyNonNull List<String> list, long j) {
    }
}
