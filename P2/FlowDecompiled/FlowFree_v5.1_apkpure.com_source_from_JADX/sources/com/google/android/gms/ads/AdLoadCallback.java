package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class AdLoadCallback<AdT> {
    public abstract void onAdFailedToLoad(@RecentlyNonNull LoadAdError loadAdError);

    public abstract void onAdLoaded(@RecentlyNonNull AdT adt);
}
