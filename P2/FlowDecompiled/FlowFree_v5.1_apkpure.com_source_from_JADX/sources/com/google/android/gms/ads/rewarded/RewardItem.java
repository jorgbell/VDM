package com.google.android.gms.ads.rewarded;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface RewardItem {
    int getAmount();

    @RecentlyNonNull
    String getType();
}
