package com.chartboost.sdk.impl;

import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;

/* renamed from: com.chartboost.sdk.impl.c */
public interface C1293c {
    void didCacheBanner(String str, String str2, ChartboostCacheError chartboostCacheError);

    void didClickBanner(String str, String str2, ChartboostClickError chartboostClickError);

    void didShowBanner(String str, String str2, ChartboostShowError chartboostShowError);

    void onBannerCacheFail(String str, String str2, ChartboostCacheError chartboostCacheError);

    void onBannerShowFail(String str, String str2, ChartboostShowError chartboostShowError);
}
