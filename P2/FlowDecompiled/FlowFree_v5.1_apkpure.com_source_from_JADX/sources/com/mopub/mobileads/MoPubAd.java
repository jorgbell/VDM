package com.mopub.mobileads;

import android.graphics.Point;
import android.location.Location;
import android.view.View;
import com.mopub.common.AdFormat;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MoPubAd.kt */
public interface MoPubAd extends AdLifecycleListener.LoadListener, AdLifecycleListener.InteractionListener {
    AdFormat getAdFormat();

    int getAdHeight();

    String getAdUnitId();

    AdViewController getAdViewController();

    int getAdWidth();

    String getKeywords();

    Map<String, Object> getLocalExtras();

    Location getLocation();

    String getUserDataKeywords();

    void loadAd();

    boolean loadFailUrl(MoPubErrorCode moPubErrorCode);

    /* synthetic */ void onAdClicked();

    /* bridge */ /* synthetic */ void onAdCollapsed();

    /* bridge */ /* synthetic */ void onAdComplete(MoPubReward moPubReward);

    /* bridge */ /* synthetic */ void onAdDismissed();

    /* bridge */ /* synthetic */ void onAdExpanded();

    /* synthetic */ void onAdFailed(MoPubErrorCode moPubErrorCode);

    /* synthetic */ void onAdImpression();

    /* synthetic */ void onAdLoadFailed(MoPubErrorCode moPubErrorCode);

    /* synthetic */ void onAdLoaded();

    /* bridge */ /* synthetic */ void onAdPauseAutoRefresh();

    /* bridge */ /* synthetic */ void onAdResumeAutoRefresh();

    /* synthetic */ void onAdShown();

    void pauseAutoRefresh();

    Point resolveAdSize();

    void resumeAutoRefresh();

    void setAdContentView(View view);

    void setAdUnitId(String str);

    void setAdViewController(AdViewController adViewController);

    void setKeywords(String str);

    void setLocalExtras(Map<String, ? extends Object> map);

    void setUserDataKeywords(String str);

    /* renamed from: com.mopub.mobileads.MoPubAd$-CC  reason: invalid class name */
    /* compiled from: MoPubAd.kt */
    public final /* synthetic */ class CC {
        public static void $default$loadAd(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.setRequestedAdSize(_this.resolveAdSize());
                adViewController.loadAd();
            }
        }

        public static void $default$setAdContentView(MoPubAd _this, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.setAdContentView(view);
            }
        }

        public static void $default$setAdUnitId(MoPubAd _this, String str) {
            Intrinsics.checkNotNullParameter(str, "adUnitId");
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.setAdUnitId(str);
            }
        }

        public static String $default$getAdUnitId(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                return adViewController.getAdUnitId();
            }
            return null;
        }

        public static void $default$setKeywords(MoPubAd _this, String str) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.setKeywords(str);
            }
        }

        public static String $default$getKeywords(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                return adViewController.getKeywords();
            }
            return null;
        }

        public static void $default$setUserDataKeywords(MoPubAd _this, String str) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.setUserDataKeywords(str);
            }
        }

        public static String $default$getUserDataKeywords(MoPubAd _this) {
            AdViewController adViewController;
            if (!MoPub.canCollectPersonalInformation() || (adViewController = _this.getAdViewController()) == null) {
                return null;
            }
            return adViewController.getUserDataKeywords();
        }

        public static int $default$getAdWidth(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                return adViewController.getAdWidth();
            }
            return 0;
        }

        public static int $default$getAdHeight(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                return adViewController.getAdHeight();
            }
            return 0;
        }

        public static boolean $default$loadFailUrl(MoPubAd _this, MoPubErrorCode moPubErrorCode) {
            Intrinsics.checkNotNullParameter(moPubErrorCode, "errorCode");
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                return adViewController.loadFailUrl(moPubErrorCode);
            }
            return false;
        }

        public static void $default$pauseAutoRefresh(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.pauseRefresh();
            }
        }

        public static void $default$resumeAutoRefresh(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.resumeRefresh();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r0.getLocalExtras();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.util.Map $default$getLocalExtras(com.mopub.mobileads.MoPubAd r1) {
            /*
                com.mopub.mobileads.AdViewController r0 = r1.getAdViewController()
                if (r0 == 0) goto L_0x000d
                java.util.Map r0 = r0.getLocalExtras()
                if (r0 == 0) goto L_0x000d
                goto L_0x0012
            L_0x000d:
                java.util.TreeMap r0 = new java.util.TreeMap
                r0.<init>()
            L_0x0012:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.MoPubAd.CC.$default$getLocalExtras(com.mopub.mobileads.MoPubAd):java.util.Map");
        }

        public static void $default$setLocalExtras(MoPubAd _this, Map map) {
            Intrinsics.checkNotNullParameter(map, "localExtras");
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                adViewController.setLocalExtras(map);
            }
        }

        public static Location $default$getLocation(MoPubAd _this) {
            AdViewController adViewController = _this.getAdViewController();
            if (adViewController != null) {
                return adViewController.getLocation();
            }
            return null;
        }
    }
}
