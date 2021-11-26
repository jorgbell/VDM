package com.chartboost.sdk;

import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostCacheEvent;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostClickEvent;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Events.ChartboostShowEvent;

public interface ChartboostAdListener {
    void onAdCached(ChartboostCacheEvent chartboostCacheEvent, ChartboostCacheError chartboostCacheError);

    void onAdClicked(ChartboostClickEvent chartboostClickEvent, ChartboostClickError chartboostClickError);

    void onAdShown(ChartboostShowEvent chartboostShowEvent, ChartboostShowError chartboostShowError);
}
