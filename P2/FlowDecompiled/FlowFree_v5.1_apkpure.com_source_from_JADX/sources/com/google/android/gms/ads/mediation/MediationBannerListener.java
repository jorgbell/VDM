package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface MediationBannerListener {
    void onAdClicked(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdClosed(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdFailedToLoad(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter, @RecentlyNonNull AdError adError);

    void onAdLoaded(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdOpened(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void zza(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter, @RecentlyNonNull String str, @RecentlyNonNull String str2);
}
