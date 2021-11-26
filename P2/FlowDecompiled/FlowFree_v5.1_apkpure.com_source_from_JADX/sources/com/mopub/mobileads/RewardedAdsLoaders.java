package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.network.AdLoader;
import com.mopub.network.AdResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.util.HashMap;

class RewardedAdsLoaders {
    private final HashMap<String, AdLoaderRewardedAd> mAdUnitToAdLoader = new HashMap<>();
    /* access modifiers changed from: private */
    public final MoPubRewardedAdManager moPubRewardedAdManager;

    public class RewardedAdRequestListener implements AdLoader.Listener {
        public final String adUnitId;

        RewardedAdRequestListener(String str) {
            this.adUnitId = str;
        }

        public void onSuccess(AdResponse adResponse) {
            RewardedAdsLoaders.this.moPubRewardedAdManager.onAdSuccess(adResponse);
        }

        public void onErrorResponse(VolleyError volleyError) {
            RewardedAdsLoaders.this.moPubRewardedAdManager.onAdError(volleyError, this.adUnitId);
        }
    }

    RewardedAdsLoaders(MoPubRewardedAdManager moPubRewardedAdManager2) {
        this.moPubRewardedAdManager = moPubRewardedAdManager2;
    }

    /* access modifiers changed from: package-private */
    public Request<?> loadNextAd(Context context, String str, String str2, MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(context);
        AdLoaderRewardedAd adLoaderRewardedAd = this.mAdUnitToAdLoader.get(str);
        if (adLoaderRewardedAd == null || !adLoaderRewardedAd.hasMoreAds()) {
            adLoaderRewardedAd = new AdLoaderRewardedAd(str2, AdFormat.REWARDED_AD, str, context, new RewardedAdRequestListener(str));
            this.mAdUnitToAdLoader.put(str, adLoaderRewardedAd);
        }
        return adLoaderRewardedAd.loadNextAd(moPubErrorCode);
    }

    /* access modifiers changed from: package-private */
    public boolean isLoading(String str) {
        return this.mAdUnitToAdLoader.containsKey(str) && this.mAdUnitToAdLoader.get(str).isRunning();
    }

    /* access modifiers changed from: package-private */
    public void markFail(String str) {
        Preconditions.checkNotNull(str);
        this.mAdUnitToAdLoader.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void markPlayed(String str) {
        Preconditions.checkNotNull(str);
        this.mAdUnitToAdLoader.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void onRewardedAdStarted(String str, Context context) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(context);
        AdLoaderRewardedAd adLoaderRewardedAd = this.mAdUnitToAdLoader.get(str);
        if (adLoaderRewardedAd != null) {
            adLoaderRewardedAd.trackImpression(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void onRewardedAdClicked(String str, Context context) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(context);
        AdLoaderRewardedAd adLoaderRewardedAd = this.mAdUnitToAdLoader.get(str);
        if (adLoaderRewardedAd != null) {
            adLoaderRewardedAd.trackClick(context);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canPlay(String str) {
        AdLoaderRewardedAd adLoaderRewardedAd = this.mAdUnitToAdLoader.get(str);
        if (adLoaderRewardedAd == null || adLoaderRewardedAd.getLastDeliveredResponse() == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean hasMoreAds(String str) {
        AdLoaderRewardedAd adLoaderRewardedAd = this.mAdUnitToAdLoader.get(str);
        return adLoaderRewardedAd != null && adLoaderRewardedAd.hasMoreAds();
    }

    /* access modifiers changed from: package-private */
    public void creativeDownloadSuccess(String str) {
        AdLoaderRewardedAd adLoaderRewardedAd = this.mAdUnitToAdLoader.get(str);
        if (adLoaderRewardedAd != null) {
            adLoaderRewardedAd.creativeDownloadSuccess();
        }
    }
}
