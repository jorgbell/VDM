package com.noodlecake.ads;

import android.app.Activity;
import android.util.Log;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubRewardedAdListener;
import com.mopub.mobileads.MoPubRewardedAdManager;
import com.mopub.mobileads.MoPubRewardedAds;
import com.noodlecake.flow.MoPubInitializationListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MoPubInterstitialBridge implements IInterstitialProvider, MoPubInterstitial.InterstitialAdListener, MoPubRewardedAdListener {
    private static final String TAG = "MoPubInterstitialBridge";
    protected boolean _cacheInterstitialOnDismiss = true;
    Activity _context = null;
    Map<String, String> _interstitialIds = null;
    Map<String, MoPubInterstitial> _interstitials = null;
    String _keywords = null;
    String _rewardedId = null;

    private static native void onRewardedClosed();

    private static native void onRewardedCompleted();

    private static native void onRewardedExpired();

    private static native void onRewardedLoadFailure();

    private static native void onRewardedLoadSuccess();

    private static native void onRewardedPlaybackError();

    private static native void onRewardedStarted();

    public void onRewardedAdClicked(String str) {
    }

    public void onCreate() {
        MoPub.onCreate(this._context);
    }

    public void onStart() {
        MoPub.onStart(this._context);
    }

    public void onRestart() {
        MoPub.onRestart(this._context);
    }

    public boolean onBackPressed() {
        MoPub.onBackPressed(this._context);
        return false;
    }

    public void onStop() {
        MoPub.onStop(this._context);
    }

    public void onPause() {
        MoPub.onPause(this._context);
    }

    public void onResume() {
        MoPub.onResume(this._context);
    }

    public void onDestroy() {
        Log.i(TAG, "MoPub interstitials and rewarded videos destroying...");
        for (MoPubInterstitial destroy : this._interstitials.values()) {
            destroy.destroy();
        }
        this._interstitials.clear();
        MoPub.onDestroy(this._context);
    }

    public MoPubInterstitialBridge(Activity activity, boolean z, Map<String, String> map, String str, String str2) {
        Log.i(TAG, "MoPub interstitials and rewarded videos initializing...");
        this._context = activity;
        this._keywords = str2;
        this._interstitialIds = map;
        this._interstitials = new HashMap();
        for (String next : this._interstitialIds.keySet()) {
            MoPubInterstitial moPubInterstitial = new MoPubInterstitial(activity, this._interstitialIds.get(next));
            moPubInterstitial.setInterstitialAdListener(this);
            moPubInterstitial.setKeywords(this._keywords);
            if (z) {
                moPubInterstitial.setTesting(true);
            }
            this._interstitials.put(next, moPubInterstitial);
            Log.i(TAG, "Interstitial placement '" + next + "' initialized.");
        }
        this._rewardedId = str;
        MoPubRewardedAds.setRewardedAdListener(this);
    }

    private MoPubInterstitial getAdForPlacement(String str) {
        if (this._interstitials.containsKey(str)) {
            MoPubInterstitial moPubInterstitial = this._interstitials.get(str);
            Log.i(TAG, "Interstitial placement '" + str + "' retrieved.");
            return moPubInterstitial;
        }
        Log.w(TAG, "WARNING: Interstitial placement '" + str + "' not found.");
        return null;
    }

    private String getPlacementFromAd(MoPubInterstitial moPubInterstitial) {
        for (String next : this._interstitials.keySet()) {
            if (this._interstitials.get(next) == moPubInterstitial) {
                return next;
            }
        }
        return null;
    }

    public void loadInterstitial(String str) {
        MoPubInterstitial adForPlacement = getAdForPlacement(str);
        if (MoPub.isSdkInitialized()) {
            if (adForPlacement != null && !adForPlacement.isReady()) {
                adForPlacement.load();
            }
        } else if (str.equals("Break")) {
            MoPubInitializationListener.loadMoPubInterstitialOnInit = true;
        } else {
            onInterstitialFailed(adForPlacement, MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    public void preloadInterstitial(String str) {
        Log.i(TAG, "MoPub preload interstitial ad: " + str);
        MoPubInterstitial adForPlacement = getAdForPlacement(str);
        if (adForPlacement != null) {
            if (!adForPlacement.isReady()) {
                Log.i(TAG, "MoPub preloading interstitial ad");
                loadInterstitial(str);
                return;
            }
            Log.i(TAG, "MoPub already preloaded interstitial ad");
        }
    }

    public boolean hasPreloadedInterstitial(String str) {
        Log.i(TAG, "MoPub checking has preloaded interstitial ad:" + str);
        MoPubInterstitial adForPlacement = getAdForPlacement(str);
        if (adForPlacement == null) {
            return false;
        }
        return adForPlacement.isReady();
    }

    public void showInterstitial(String str, boolean z) {
        Log.i(TAG, "MoPub show interstitial ad: " + str + ", cacheOnDismiss: " + z);
        this._cacheInterstitialOnDismiss = z;
        MoPubInterstitial adForPlacement = getAdForPlacement(str);
        if (adForPlacement != null) {
            if (adForPlacement.isReady()) {
                Log.i(TAG, "MoPub showing interstitial ad");
                adForPlacement.show();
                return;
            }
            Log.i(TAG, "MoPub preloading interstitial ad, none to show");
            loadInterstitial(str);
        }
    }

    public void loadRewardedVideo() {
        if (MoPub.isSdkInitialized()) {
            MoPubRewardedAds.loadRewardedAd(this._rewardedId, new MoPubRewardedAdManager.RequestParameters(this._keywords), new MediationSettings[0]);
        } else {
            MoPubInitializationListener.loadMoPubRewardedOnInit = true;
        }
    }

    public void preloadRewardedVideo() {
        Log.i(TAG, "MoPub preload rewarded video");
        if (!MoPubRewardedAds.hasRewardedAd(this._rewardedId)) {
            Log.i(TAG, "MoPub preloading rewarded video");
            loadRewardedVideo();
            return;
        }
        Log.i(TAG, "MoPub already preloaded rewarded video");
    }

    public boolean hasPreloadedRewardedVideo() {
        Log.i(TAG, "MoPub checking has preloaded rewarded video");
        return MoPubRewardedAds.hasRewardedAd(this._rewardedId);
    }

    public void showRewardedVideo() {
        Log.i(TAG, "MoPub show rewarded video");
        if (MoPubRewardedAds.hasRewardedAd(this._rewardedId)) {
            Log.i(TAG, "MoPub showing rewarded video");
            Set<MoPubReward> availableRewards = MoPubRewardedAds.getAvailableRewards(this._rewardedId);
            if (availableRewards != null && availableRewards.size() > 0) {
                MoPubRewardedAds.selectReward(this._rewardedId, availableRewards.iterator().next());
            }
            MoPubRewardedAds.showRewardedAd(this._rewardedId);
            return;
        }
        Log.i(TAG, "MoPub preloading rewarded video, none to show");
        loadRewardedVideo();
    }

    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
        Log.i(TAG, "MoPub interstitial ad clicked (" + getPlacementFromAd(moPubInterstitial) + ")");
    }

    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
        if (this._cacheInterstitialOnDismiss) {
            Log.i(TAG, "MoPub interstitial ad dismissed, will recache (" + getPlacementFromAd(moPubInterstitial) + ")");
            moPubInterstitial.load();
            return;
        }
        Log.i(TAG, "MoPub interstitial ad dismissed, will NOT recache (" + getPlacementFromAd(moPubInterstitial) + ")");
    }

    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
        if (moPubErrorCode == MoPubErrorCode.EXPIRED) {
            Log.i(TAG, "MoPub interstitial ad expired, will recache (" + getPlacementFromAd(moPubInterstitial) + ")");
            moPubInterstitial.load();
            return;
        }
        Log.i(TAG, "MoPub interstitial ad failed to load (" + getPlacementFromAd(moPubInterstitial) + ")");
    }

    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
        Log.i(TAG, "MoPub interstitial ad loaded (" + getPlacementFromAd(moPubInterstitial) + ")");
    }

    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
        Log.i(TAG, "MoPub interstitial ad shown (" + getPlacementFromAd(moPubInterstitial) + ")");
    }

    public void onRewardedAdLoadSuccess(String str) {
        onRewardedLoadSuccess();
    }

    public void onRewardedAdLoadFailure(String str, MoPubErrorCode moPubErrorCode) {
        if (moPubErrorCode == MoPubErrorCode.EXPIRED) {
            onRewardedExpired();
        } else {
            onRewardedLoadFailure();
        }
    }

    public void onRewardedAdStarted(String str) {
        onRewardedStarted();
    }

    public void onRewardedAdShowError(String str, MoPubErrorCode moPubErrorCode) {
        onRewardedPlaybackError();
    }

    public void onRewardedAdClosed(String str) {
        onRewardedClosed();
    }

    public void onRewardedAdCompleted(Set<String> set, MoPubReward moPubReward) {
        onRewardedCompleted();
    }
}
