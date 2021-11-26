package com.mopub.mobileads;

import com.mopub.common.MoPubReward;

/* compiled from: AdLifecycleListener.kt */
public interface AdLifecycleListener {

    /* compiled from: AdLifecycleListener.kt */
    public interface FullscreenInteractionListener {

        /* renamed from: com.mopub.mobileads.AdLifecycleListener$FullscreenInteractionListener$-CC  reason: invalid class name */
        /* compiled from: AdLifecycleListener.kt */
        public final /* synthetic */ class CC {
            public static void $default$onAdComplete(FullscreenInteractionListener fullscreenInteractionListener, MoPubReward moPubReward) {
            }

            public static void $default$onAdDismissed(FullscreenInteractionListener fullscreenInteractionListener) {
            }
        }

        void onAdComplete(MoPubReward moPubReward);

        void onAdDismissed();
    }

    /* compiled from: AdLifecycleListener.kt */
    public interface InlineInteractionListener {

        /* renamed from: com.mopub.mobileads.AdLifecycleListener$InlineInteractionListener$-CC  reason: invalid class name */
        /* compiled from: AdLifecycleListener.kt */
        public final /* synthetic */ class CC {
            public static void $default$onAdCollapsed(InlineInteractionListener inlineInteractionListener) {
            }

            public static void $default$onAdExpanded(InlineInteractionListener inlineInteractionListener) {
            }

            public static void $default$onAdPauseAutoRefresh(InlineInteractionListener inlineInteractionListener) {
            }

            public static void $default$onAdResumeAutoRefresh(InlineInteractionListener inlineInteractionListener) {
            }
        }

        void onAdCollapsed();

        void onAdExpanded();

        void onAdPauseAutoRefresh();

        void onAdResumeAutoRefresh();
    }

    /* compiled from: AdLifecycleListener.kt */
    public interface InteractionListener extends InlineInteractionListener, FullscreenInteractionListener {

        /* renamed from: com.mopub.mobileads.AdLifecycleListener$InteractionListener$-CC  reason: invalid class name */
        /* compiled from: AdLifecycleListener.kt */
        public final /* synthetic */ class CC {
        }

        void onAdClicked();

        /* bridge */ /* synthetic */ void onAdCollapsed();

        /* bridge */ /* synthetic */ void onAdComplete(MoPubReward moPubReward);

        /* bridge */ /* synthetic */ void onAdDismissed();

        /* bridge */ /* synthetic */ void onAdExpanded();

        void onAdFailed(MoPubErrorCode moPubErrorCode);

        void onAdImpression();

        /* bridge */ /* synthetic */ void onAdPauseAutoRefresh();

        /* bridge */ /* synthetic */ void onAdResumeAutoRefresh();

        void onAdShown();
    }

    /* compiled from: AdLifecycleListener.kt */
    public interface LoadListener {
        void onAdLoadFailed(MoPubErrorCode moPubErrorCode);

        void onAdLoaded();
    }
}
