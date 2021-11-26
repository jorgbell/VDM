package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class AdListener {
    public void onAdClicked() {
    }

    public abstract void onAdClosed();

    public abstract void onAdFailedToLoad(@RecentlyNonNull LoadAdError loadAdError);

    public void onAdImpression() {
    }

    public abstract void onAdLoaded();

    public abstract void onAdOpened();
}
