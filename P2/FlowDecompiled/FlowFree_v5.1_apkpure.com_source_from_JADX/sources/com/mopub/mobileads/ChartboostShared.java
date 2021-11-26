package com.mopub.mobileads;

import android.text.TextUtils;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Model.CBError;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ChartboostShared {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = ChartboostShared.class.getSimpleName();
    public static final String LOCATION_DEFAULT = "Default";
    public static final String LOCATION_KEY = "location";
    private static volatile ChartboostSingletonDelegate sDelegate = new ChartboostSingletonDelegate();

    public static ChartboostSingletonDelegate getDelegate() {
        return sDelegate;
    }

    public static class ChartboostSingletonDelegate extends ChartboostDelegate implements AdLifecycleListener.LoadListener, AdLifecycleListener.InteractionListener {
        private static final AdLifecycleListener.InteractionListener NULL_INTERACTION_LISTENER = new AdLifecycleListener.InteractionListener() {
            public void onAdClicked() {
            }

            public void onAdCollapsed() {
            }

            public void onAdComplete(MoPubReward moPubReward) {
            }

            public void onAdDismissed() {
            }

            public void onAdExpanded() {
            }

            public void onAdFailed(MoPubErrorCode moPubErrorCode) {
            }

            public void onAdImpression() {
            }

            public void onAdPauseAutoRefresh() {
            }

            public void onAdResumeAutoRefresh() {
            }

            public void onAdShown() {
            }
        };
        private static final AdLifecycleListener.LoadListener NULL_LOAD_LISTENER = new AdLifecycleListener.LoadListener() {
            public void onAdLoadFailed(MoPubErrorCode moPubErrorCode) {
            }

            public void onAdLoaded() {
            }
        };
        private static Map<String, AdLifecycleListener.InteractionListener> mInteractionListenersForLocation = Collections.synchronizedMap(new TreeMap());
        private static Map<String, AdLifecycleListener.LoadListener> mLoadListenersForLocation = Collections.synchronizedMap(new TreeMap());
        private Set<String> mRewardedVideoLocationsToLoad = Collections.synchronizedSet(new TreeSet());

        public void onAdClicked() {
        }

        public /* bridge */ /* synthetic */ void onAdCollapsed() {
            AdLifecycleListener.InlineInteractionListener.CC.$default$onAdCollapsed(this);
        }

        public /* bridge */ /* synthetic */ void onAdComplete(MoPubReward moPubReward) {
            AdLifecycleListener.FullscreenInteractionListener.CC.$default$onAdComplete(this, moPubReward);
        }

        public /* bridge */ /* synthetic */ void onAdDismissed() {
            AdLifecycleListener.FullscreenInteractionListener.CC.$default$onAdDismissed(this);
        }

        public /* bridge */ /* synthetic */ void onAdExpanded() {
            AdLifecycleListener.InlineInteractionListener.CC.$default$onAdExpanded(this);
        }

        public void onAdFailed(MoPubErrorCode moPubErrorCode) {
        }

        public void onAdImpression() {
        }

        public void onAdLoadFailed(MoPubErrorCode moPubErrorCode) {
        }

        public void onAdLoaded() {
        }

        public /* bridge */ /* synthetic */ void onAdPauseAutoRefresh() {
            AdLifecycleListener.InlineInteractionListener.CC.$default$onAdPauseAutoRefresh(this);
        }

        public /* bridge */ /* synthetic */ void onAdResumeAutoRefresh() {
            AdLifecycleListener.InlineInteractionListener.CC.$default$onAdResumeAutoRefresh(this);
        }

        public void onAdShown() {
        }

        public boolean shouldDisplayMoreApps(String str) {
            return false;
        }

        public boolean shouldRequestMoreApps(String str) {
            return false;
        }

        public void registerLoadListener(String str, AdLifecycleListener.LoadListener loadListener) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(loadListener);
            mLoadListenersForLocation.put(str, loadListener);
        }

        public void registerInteractionListener(String str, AdLifecycleListener.InteractionListener interactionListener) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(interactionListener);
            mInteractionListenersForLocation.put(str, interactionListener);
        }

        public void unregisterLoadListener(String str) {
            Preconditions.checkNotNull(str);
            mLoadListenersForLocation.remove(str);
        }

        public void unregisterInteractionListener(String str) {
            Preconditions.checkNotNull(str);
            mInteractionListenersForLocation.remove(str);
        }

        public void registerRewardedVideoLocation(String str) {
            Preconditions.checkNotNull(str);
            this.mRewardedVideoLocationsToLoad.add(str);
        }

        public void unregisterRewardedVideoLocation(String str) {
            Preconditions.checkNotNull(str);
            this.mRewardedVideoLocationsToLoad.remove(str);
        }

        private void invalidateLocation(String str) {
            if (!TextUtils.isEmpty(str)) {
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adapterLogEvent, ChartboostShared.ADAPTER_NAME, "Invalidating listeners for location: " + str);
                unregisterLoadListener(str);
                unregisterInteractionListener(str);
            }
        }

        public AdLifecycleListener.LoadListener getLoadListener(String str) {
            AdLifecycleListener.LoadListener loadListener = mLoadListenersForLocation.get(str);
            return loadListener != null ? loadListener : NULL_LOAD_LISTENER;
        }

        public AdLifecycleListener.InteractionListener getInteractionListener(String str) {
            AdLifecycleListener.InteractionListener interactionListener = mInteractionListenersForLocation.get(str);
            return interactionListener != null ? interactionListener : NULL_INTERACTION_LISTENER;
        }

        public boolean hasLoadLocation(String str) {
            return mLoadListenersForLocation.containsKey(str);
        }

        public boolean hasInteractionlLocation(String str) {
            return mInteractionListenersForLocation.containsKey(str);
        }

        public void didCacheInterstitial(String str) {
            getLoadListener(str).onAdLoaded();
            MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_SUCCESS, ChartboostShared.ADAPTER_NAME);
        }

        public void didFailToLoadInterstitial(String str, CBError.CBImpressionError cBImpressionError) {
            String str2;
            MoPubErrorCode moPubErrorCode;
            if (cBImpressionError != null) {
                str2 = "Error: " + cBImpressionError.name();
            } else {
                str2 = "";
            }
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ChartboostShared.ADAPTER_NAME, "Chartboost interstitial ad failed to load." + str2);
            MoPubErrorCode moPubErrorCode2 = null;
            if (cBImpressionError != null) {
                switch (C25341.$SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[cBImpressionError.ordinal()]) {
                    case 1:
                        moPubErrorCode = MoPubErrorCode.NETWORK_INVALID_STATE;
                        break;
                    case 2:
                        moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
                        break;
                    case 3:
                        moPubErrorCode = MoPubErrorCode.CANCELLED;
                        break;
                    case 4:
                        moPubErrorCode = MoPubErrorCode.NETWORK_TIMEOUT;
                        break;
                    case 5:
                        moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                        break;
                    case 6:
                        moPubErrorCode = MoPubErrorCode.VIDEO_NOT_AVAILABLE;
                        break;
                    case 7:
                        moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
                        break;
                    default:
                        moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
                        break;
                }
                moPubErrorCode2 = moPubErrorCode;
                MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_FAILED, ChartboostShared.ADAPTER_NAME, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
            }
            getLoadListener(str).onAdLoadFailed(moPubErrorCode2);
            invalidateLocation(str);
        }

        public void didDismissInterstitial(String str) {
            getInteractionListener(str).onAdDismissed();
            invalidateLocation(str);
        }

        public void didCloseInterstitial(String str) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ChartboostShared.ADAPTER_NAME, "Chartboost interstitial ad closed.");
        }

        public void didClickInterstitial(String str) {
            getInteractionListener(str).onAdClicked();
            MoPubLog.log(MoPubLog.AdapterLogEvent.CLICKED, ChartboostShared.ADAPTER_NAME);
        }

        public void didDisplayInterstitial(String str) {
            getInteractionListener(str).onAdShown();
            getInteractionListener(str).onAdImpression();
            MoPubLog.log(MoPubLog.AdapterLogEvent.SHOW_SUCCESS, ChartboostShared.ADAPTER_NAME);
        }

        public void didCacheRewardedVideo(String str) {
            super.didCacheRewardedVideo(str);
            if (this.mRewardedVideoLocationsToLoad.contains(str)) {
                this.mRewardedVideoLocationsToLoad.remove(str);
                MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_SUCCESS, ChartboostShared.ADAPTER_NAME);
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adapterLogEvent, ChartboostShared.ADAPTER_NAME, "Chartboost rewarded video cached for location " + str + ".");
                getLoadListener(str).onAdLoaded();
            }
        }

        public void didFailToLoadRewardedVideo(String str, CBError.CBImpressionError cBImpressionError) {
            String str2;
            MoPubErrorCode moPubErrorCode;
            super.didFailToLoadRewardedVideo(str, cBImpressionError);
            if (cBImpressionError != null) {
                str2 = " with error: " + cBImpressionError.name();
            } else {
                str2 = "";
            }
            if (this.mRewardedVideoLocationsToLoad.contains(str)) {
                MoPubErrorCode moPubErrorCode2 = null;
                if (cBImpressionError != null) {
                    switch (C25341.$SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[cBImpressionError.ordinal()]) {
                        case 1:
                            moPubErrorCode = MoPubErrorCode.NETWORK_INVALID_STATE;
                            break;
                        case 2:
                            moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
                            break;
                        case 3:
                            moPubErrorCode = MoPubErrorCode.CANCELLED;
                            break;
                        case 4:
                            moPubErrorCode = MoPubErrorCode.NETWORK_TIMEOUT;
                            break;
                        case 5:
                            moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                            break;
                        case 6:
                            moPubErrorCode = MoPubErrorCode.VIDEO_NOT_AVAILABLE;
                            break;
                        case 7:
                            moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
                            break;
                        default:
                            moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
                            break;
                    }
                    moPubErrorCode2 = moPubErrorCode;
                    MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_FAILED, ChartboostShared.ADAPTER_NAME, Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
                    MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, ChartboostShared.ADAPTER_NAME, "Chartboost rewarded video cache failed for location " + str + str2);
                }
                this.mRewardedVideoLocationsToLoad.remove(str);
                getLoadListener(str).onAdLoadFailed(moPubErrorCode2);
            }
        }

        public void didDismissRewardedVideo(String str) {
            super.didDismissRewardedVideo(str);
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, ChartboostShared.ADAPTER_NAME, "Chartboost rewarded video dismissed for location " + str + ".");
            getInteractionListener(str).onAdDismissed();
        }

        public void didCloseRewardedVideo(String str) {
            super.didCloseRewardedVideo(str);
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, ChartboostShared.ADAPTER_NAME, "Chartboost rewarded video closed for location " + str + ".");
        }

        public void didClickRewardedVideo(String str) {
            super.didClickRewardedVideo(str);
            MoPubLog.log(MoPubLog.AdapterLogEvent.CLICKED, ChartboostShared.ADAPTER_NAME);
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, ChartboostShared.ADAPTER_NAME, "Chartboost rewarded video clicked for location " + str + ".");
            getInteractionListener(str).onAdClicked();
        }

        public void didCompleteRewardedVideo(String str, int i) {
            super.didCompleteRewardedVideo(str, i);
            MoPubLog.log(MoPubLog.AdapterLogEvent.SHOULD_REWARD, ChartboostShared.ADAPTER_NAME, Integer.valueOf(i), str);
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, ChartboostShared.ADAPTER_NAME, "Chartboost rewarded video completed for location " + str + " with reward amount " + i);
            getInteractionListener(str).onAdComplete(MoPubReward.success("", i));
        }

        public void didDisplayRewardedVideo(String str) {
            super.didDisplayRewardedVideo(str);
            MoPubLog.log(MoPubLog.AdapterLogEvent.SHOW_SUCCESS, ChartboostShared.ADAPTER_NAME);
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, ChartboostShared.ADAPTER_NAME, "Chartboost rewarded video displayed for location " + str + ".");
            getInteractionListener(str).onAdShown();
            getInteractionListener(str).onAdImpression();
        }
    }

    /* renamed from: com.mopub.mobileads.ChartboostShared$1 */
    static /* synthetic */ class C25341 {
        static final /* synthetic */ int[] $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.chartboost.sdk.Model.CBError$CBImpressionError[] r0 = com.chartboost.sdk.Model.CBError.CBImpressionError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError = r0
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.INTERNAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x001d }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.INTERNET_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.TOO_MANY_CONNECTIONS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.NETWORK_FAILURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x003e }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.NO_AD_FOUND     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.VIDEO_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.chartboost.sdk.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.Model.CBError.CBImpressionError.ERROR_PLAYING_VIDEO     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.ChartboostShared.C25341.<clinit>():void");
        }
    }
}
