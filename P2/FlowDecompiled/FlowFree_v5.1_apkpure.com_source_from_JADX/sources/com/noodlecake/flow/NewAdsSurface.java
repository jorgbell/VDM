package com.noodlecake.flow;

import android.graphics.Paint;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.bigduckgames.flow.AnalyticsManager;
import com.bigduckgames.flow.CrashReportManager;
import com.bigduckgames.flow.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubConversionTracker;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.network.ImpressionData;
import com.mopub.network.ImpressionListener;
import com.mopub.network.ImpressionsEmitter;
import com.noodlecake.flow.config.FlowConfig;
import java.util.HashMap;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.json.JSONException;

public class NewAdsSurface {
    private static NewAdsSurface instance = null;
    /* access modifiers changed from: private */
    public static boolean isBannerHiding = false;
    private static boolean isNativeShowingAds = false;
    /* access modifiers changed from: private */
    public static boolean maxNativeAdHeightSet = false;
    private String adMobPhoneID = "";
    private String adMobTabletID = "";
    /* access modifiers changed from: private */
    public C2702flow air = null;
    /* access modifiers changed from: private */
    public FrameLayout bannerAdFrame = null;
    /* access modifiers changed from: private */
    public int bannerAdHeight = 0;
    /* access modifiers changed from: private */
    public AdView mGoogleAdView = null;
    private ImpressionListener mImpressionListener;
    /* access modifiers changed from: private */
    public MoPubView moPubAdView = null;
    private String moPubBootPhoneID = "";
    private String moPubBootTabletID = "";
    private String moPubBreakPhoneID = "";
    private String moPubBreakTabletID = "";
    private String moPubPhoneID = "";
    private String moPubRewardedPhoneID = "";
    private String moPubRewardedTabletID = "";
    private String moPubTabletID = "";

    /* access modifiers changed from: private */
    public static native void onAdSizeChanged(int i);

    public NewAdsSurface(C2702flow flow) {
        Log.d("NewAdsSurface", "construct");
        instance = this;
        this.air = flow;
        if (FlowConfig.isBridges) {
            this.moPubPhoneID = "354c141465c611e281c11231392559e4";
            this.moPubTabletID = "fbf9635665cf11e281c11231392559e4";
            this.moPubBootPhoneID = "e18d343051244058af9ac22af2869a08";
            this.moPubBootTabletID = "61ee720a0e1146cd954a624e7b5d38b3";
            this.moPubBreakPhoneID = "f4710c09f07a499f86a1c742f4f89966";
            this.moPubBreakTabletID = "40ee1da1a913495b98c222fa040e75a9";
            this.moPubRewardedPhoneID = "ec2f81e09288443fbb7507fa7cb4c75e";
            this.moPubRewardedTabletID = "e152081c3e034d0688e9d1fc4f101b24";
            this.adMobPhoneID = "ca-app-pub-2528427488288769/9733170137";
            this.adMobTabletID = "ca-app-pub-2528427488288769/2209903335";
        } else if (FlowConfig.isHexes) {
            this.moPubPhoneID = "f7239012d9c044eaaa7e28a5b2e8ff1d";
            this.moPubTabletID = "cf9020f1737041b0bd97441276ac6356";
            this.moPubBootPhoneID = "784ced6f7e334742ae1301a8f6f68182";
            this.moPubBootTabletID = "f25f3cf468334115a5c67a6498205cfa";
            this.moPubBreakPhoneID = "1a49446100ff4d1a9bf4f573dd2108e4";
            this.moPubBreakTabletID = "2d7a7ef7fe3e4e90857fa791ca733795";
            this.moPubRewardedPhoneID = "c1d9fc2034ed4c67baaee46d71238d16";
            this.moPubRewardedTabletID = "2d711b8e1dca4ea1815e9afdf55d743e";
            this.adMobPhoneID = "ca-app-pub-2528427488288769/2630551333";
            this.adMobTabletID = "ca-app-pub-2528427488288769/4107284535";
        } else if (FlowConfig.isWarps) {
            this.moPubPhoneID = "646ad50511b64390a6241a9dad299d5a";
            this.moPubTabletID = "a7b601ecb2b242a786a22bcb40189201";
            this.moPubBootPhoneID = "2cb22a5148724f7f936199312d617f3e";
            this.moPubBootTabletID = "8747650a72eb47739c38d6cc1f552477";
            this.moPubBreakPhoneID = "aea48c3a72ae456e809f8060d45a6a80";
            this.moPubBreakTabletID = "43d33f8e27f94d708f9bb03047fc1d45";
            this.moPubRewardedPhoneID = "c18cc7c4934748bc8251227316f48c79";
            this.moPubRewardedTabletID = "40fdcfa64f1149a8a8281649d7ce5f91";
            this.adMobPhoneID = "ca-app-pub-2528427488288769/4216375336";
            this.adMobTabletID = "ca-app-pub-2528427488288769/5693108538";
        } else {
            this.moPubPhoneID = "cfbb1c329a8911e295fa123138070049";
            this.moPubTabletID = "2f3c621a9a8a11e281c11231392559e4";
            this.moPubBootPhoneID = "a60ad619717c496ead561b6cf952be3c";
            this.moPubBootTabletID = "0a86728250774744909e9c15cf213023";
            this.moPubBreakPhoneID = "3f9b2a0a689348d191f21798a1076648";
            this.moPubBreakTabletID = "2f5bc1d3f6d448b58f74ab43a35e42dc";
            this.moPubRewardedPhoneID = "69bd9b7f025941bf93bc5dc09bba4707";
            this.moPubRewardedTabletID = "c3401d1411164ebcbceca6a8631ee1d7";
            this.adMobPhoneID = "ca-app-pub-2528427488288769/3826237334";
            this.adMobTabletID = "ca-app-pub-2528427488288769/5302970537";
        }
    }

    private void adMobBannerInit() {
        if (this.mGoogleAdView == null) {
            boolean willDipsFitScreen = willDipsFitScreen(728, 90);
            String str = willDipsFitScreen ? this.adMobTabletID : this.adMobPhoneID;
            AdView adView = new AdView(this.air);
            this.mGoogleAdView = adView;
            try {
                adView.getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this.mGoogleAdView, new Object[]{1, null});
            } catch (Throwable unused) {
            }
            this.mGoogleAdView.setAdListener(new AdViewListener());
            this.mGoogleAdView.setAdUnitId(str);
            this.mGoogleAdView.setAdSize(willDipsFitScreen ? AdSize.LEADERBOARD : AdSize.BANNER);
            this.mGoogleAdView.setVisibility(8);
            this.bannerAdFrame.addView(this.mGoogleAdView);
            Log.v("NewAdsSurface", "AdMob Fallback: Banner initialized (" + str + ")");
        }
    }

    public void onCreate(C2702flow flow) {
        Log.d("NewAdsSurface", "onCreate");
        this.air = flow;
        C26951 r3 = new ImpressionListener() {
            public void onImpression(String str, ImpressionData impressionData) {
                Log.i("NewAdsSurface", "impression for adUnitId= " + str);
                if (impressionData == null) {
                    Log.w("NewAdsSurface", "impression data not available for adUnitId= " + str);
                    return;
                }
                try {
                    Log.i("NewAdsSurface", "impression data adUnitId= " + str + "data=\n" + impressionData.getJsonRepresentation().toString(2));
                    Double publisherRevenue = impressionData.getPublisherRevenue();
                    HashMap hashMap = new HashMap();
                    hashMap.put("ad_platform", MoPubLog.LOGTAG);
                    hashMap.put(FullscreenAdService.DATA_KEY_AD_SOURCE, impressionData.getNetworkName());
                    hashMap.put("ad_format", impressionData.getAdUnitFormat());
                    hashMap.put("ad_unit_name", impressionData.getAdUnitName());
                    hashMap.put("value", publisherRevenue != null ? publisherRevenue.toString() : null);
                    hashMap.put("currency", impressionData.getCurrency());
                    hashMap.put(ImpressionData.PRECISION, impressionData.getPrecision());
                    AnalyticsManager.logEvent(NewAdsSurface.this.air, "ad_impression", hashMap);
                } catch (JSONException e) {
                    Log.e("NewAdsSurface", "Can't format impression data. e=" + e.toString());
                }
            }
        };
        this.mImpressionListener = r3;
        ImpressionsEmitter.addListener(r3);
        initMoPub();
    }

    public void onPause() {
        Log.d("NewAdsSurface", "onPause");
        MoPubView moPubView = this.moPubAdView;
        if (moPubView != null && moPubView.getParent() != null) {
            this.moPubAdView.setAutorefreshEnabled(false);
        }
    }

    public void onResume() {
        Log.d("NewAdsSurface", "onResume");
        MoPubView moPubView = this.moPubAdView;
        if (!(moPubView == null || moPubView.getParent() == null)) {
            this.moPubAdView.setAutorefreshEnabled(true);
            this.moPubAdView.forceRefresh();
        }
        AdView adView = this.mGoogleAdView;
        if (adView != null && adView.getParent() != null) {
            refreshAdMobBanner();
        }
    }

    public void onDestroy() {
        Log.d("NewAdsSurface", "onDestroy");
        destroyBannerAds();
        ImpressionsEmitter.removeListener(this.mImpressionListener);
    }

    private void initMoPub() {
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Throwable unused) {
        }
        MoPub.setLocationAwareness(MoPub.LocationAwareness.DISABLED);
        SdkConfiguration.Builder builder = new SdkConfiguration.Builder(moPubId());
        builder.withLogLevel(MoPubLog.LogLevel.NONE);
        MoPub.initializeSdk(this.air, builder.build(), new MoPubInitializationListener());
        new MoPubConversionTracker(this.air).reportAppOpen();
        if (isNativeShowingAds) {
            showAds();
        }
    }

    /* access modifiers changed from: private */
    public int dipsToPixels(float f) {
        return Math.round(TypedValue.applyDimension(1, f, this.air.getResources().getDisplayMetrics()));
    }

    public boolean willDipsFitScreen(int i, int i2) {
        DisplayMetrics displayMetrics = this.air.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int dipsToPixels = dipsToPixels((float) i);
        int dipsToPixels2 = dipsToPixels((float) i2);
        boolean z = dipsToPixels <= i3 && dipsToPixels2 <= i4;
        Log.v("NewAdsSurface", "willDipsFitScreen - Check size   " + i + "x" + i2 + " dips -> " + dipsToPixels + "x" + dipsToPixels2 + " pixels");
        StringBuilder sb = new StringBuilder();
        sb.append("willDipsFitScreen - Display size ");
        sb.append(i3);
        sb.append("x");
        sb.append(i4);
        sb.append(" pixels");
        Log.v("NewAdsSurface", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("willDipsFitScreen - ");
        sb2.append(z ? "Will fit" : "Won't fit");
        Log.v("NewAdsSurface", sb2.toString());
        return z;
    }

    public String getMoPubKeywords() {
        String str;
        if (FlowConfig.isBridges) {
            str = "FFB_a";
        } else if (FlowConfig.isHexes) {
            str = "FFX_a";
        } else {
            str = FlowConfig.isWarps ? "FFW_a" : "FF_a";
        }
        return "appName:" + str + ",appVersion:" + C2702flow.getVersionName() + ",appStore:" + "gp";
    }

    /* access modifiers changed from: private */
    public void adLoaded() {
        Log.v("NewAdsSurface", "Banner Ad Loaded (Height=" + this.bannerAdHeight + ")");
        onAdSizeChanged(this.bannerAdHeight);
    }

    /* access modifiers changed from: private */
    public void adsFailed() {
        Log.v("NewAdsSurface", "Banner Ads Failed (Height=0)");
        onAdSizeChanged(0);
    }

    /* access modifiers changed from: private */
    public void destroyBannerAds() {
        MoPubView moPubView = this.moPubAdView;
        if (moPubView != null) {
            if (moPubView.getParent() != null) {
                ((FrameLayout) this.moPubAdView.getParent()).removeView(this.moPubAdView);
            }
            this.moPubAdView.destroy();
            this.moPubAdView = null;
        }
        if (this.mGoogleAdView != null) {
            adMobBannerDestroy();
        }
    }

    public static void refreshBannerAd() {
        instance.refreshBannerAdInternal();
    }

    private void refreshBannerAdInternal() {
        Log.v("NewAdsSurface", "Refresh banner ad");
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (!(NewAdsSurface.this.moPubAdView == null || NewAdsSurface.this.moPubAdView.getParent() == null)) {
                        Log.d("NewAdsSurface", "Refreshing MoPub banner");
                        NewAdsSurface.this.loadBannerAdInternal();
                    }
                    if (NewAdsSurface.this.mGoogleAdView != null && NewAdsSurface.this.mGoogleAdView.getParent() != null) {
                        Log.d("NewAdsSurface", "Refreshing AdMob fallback banner");
                        NewAdsSurface.this.refreshAdMobBanner();
                    }
                }
            });
        }
    }

    public static void hideBannerAd() {
        instance.hideBannerAdInternal();
    }

    private void hideBannerAdInternal() {
        Log.v("NewAdsSurface", "Hide banner ad");
        isBannerHiding = true;
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (!(NewAdsSurface.this.moPubAdView == null || NewAdsSurface.this.moPubAdView.getParent() == null)) {
                        Log.v("NewAdsSurface", "Hiding MoPub banner");
                        NewAdsSurface.this.moPubAdView.setAutorefreshEnabled(false);
                        ((FrameLayout) NewAdsSurface.this.moPubAdView.getParent()).removeView(NewAdsSurface.this.moPubAdView);
                    }
                    if (NewAdsSurface.this.mGoogleAdView != null && NewAdsSurface.this.mGoogleAdView.getParent() != null) {
                        Log.v("NewAdsSurface", "Hiding AdMob fallback banner");
                        ((FrameLayout) NewAdsSurface.this.mGoogleAdView.getParent()).removeView(NewAdsSurface.this.mGoogleAdView);
                    }
                }
            });
        }
    }

    public static void showBannerAd() {
        instance.showBannerAdInternal();
    }

    private void showBannerAdInternal() {
        Log.v("NewAdsSurface", "Show banner ad");
        isBannerHiding = false;
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (NewAdsSurface.this.bannerAdFrame != null) {
                        if (NewAdsSurface.this.moPubAdView != null && NewAdsSurface.this.moPubAdView.getParent() == null) {
                            Log.v("NewAdsSurface", "Showing MoPub banner");
                            NewAdsSurface.this.bannerAdFrame.addView(NewAdsSurface.this.moPubAdView);
                            NewAdsSurface.this.moPubAdView.setAutorefreshEnabled(true);
                        }
                        if (NewAdsSurface.this.mGoogleAdView != null && NewAdsSurface.this.mGoogleAdView.getParent() == null) {
                            Log.v("NewAdsSurface", "Showing AdMob fallback banner");
                            NewAdsSurface.this.bannerAdFrame.addView(NewAdsSurface.this.mGoogleAdView);
                            NewAdsSurface.this.refreshAdMobBanner();
                        }
                    }
                }
            });
        }
    }

    public static void loadBannerAd() {
        instance.loadBannerAdInternal();
    }

    /* access modifiers changed from: protected */
    public void loadBannerAdInternal() {
        if (MoPub.isSdkInitialized()) {
            MoPubView moPubView = this.moPubAdView;
            if (moPubView != null) {
                moPubView.loadAd();
                return;
            }
            return;
        }
        MoPubInitializationListener.loadMoPubBannerOnInit = true;
    }

    public static void showAds() {
        instance.showAdsInternal();
    }

    public boolean useTabletBanners() {
        return willDipsFitScreen(728, 90);
    }

    public String moPubId() {
        return useTabletBanners() ? this.moPubTabletID : this.moPubPhoneID;
    }

    private void showAdsInternal() {
        isNativeShowingAds = true;
        CrashReportManager.setCustomKey("Ads", true);
        CrashReportManager.setCustomKey("Ads_State", isNativeShowingAds ? "ads_enabled" : "ads_disabled");
        Log.v("NewAdsSurface", "show mopub ads java");
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (NewAdsSurface.this.moPubAdView == null) {
                        int i = NewAdsSurface.this.useTabletBanners() ? 728 : 320;
                        int i2 = NewAdsSurface.this.useTabletBanners() ? 90 : 50;
                        int access$600 = NewAdsSurface.this.dipsToPixels((float) i);
                        int access$6002 = NewAdsSurface.this.dipsToPixels((float) i2);
                        Log.v("NewAdsSurface", "Starting MoPub banner with ID=" + NewAdsSurface.this.moPubId());
                        MoPubView unused = NewAdsSurface.this.moPubAdView = new MoPubView(NewAdsSurface.this.air);
                        try {
                            NewAdsSurface.this.moPubAdView.getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(NewAdsSurface.this.moPubAdView, new Object[]{1, null});
                        } catch (Throwable unused2) {
                        }
                        NewAdsSurface.this.moPubAdView.setAdUnitId(NewAdsSurface.this.moPubId());
                        String moPubKeywords = NewAdsSurface.this.getMoPubKeywords();
                        NewAdsSurface.this.moPubAdView.setKeywords(moPubKeywords);
                        Log.v("NewAdsSurface", "MoPub banner keywords set (" + moPubKeywords + ")");
                        FrameLayout frameLayout = (FrameLayout) NewAdsSurface.this.air.findViewById(R.id.adFrame);
                        frameLayout.getLayoutParams().width = access$600;
                        frameLayout.getLayoutParams().height = access$6002;
                        frameLayout.requestLayout();
                        int unused3 = NewAdsSurface.this.bannerAdHeight = access$6002;
                        NewAdsSurface.this.moPubAdView.setVisibility(8);
                        FrameLayout unused4 = NewAdsSurface.this.bannerAdFrame = frameLayout;
                        NewAdsSurface.this.bannerAdFrame.addView(NewAdsSurface.this.moPubAdView);
                        if (!NewAdsSurface.maxNativeAdHeightSet) {
                            NewAdsSurface.onAdSizeChanged(NewAdsSurface.this.bannerAdHeight);
                            NewAdsSurface.onAdSizeChanged(0);
                            boolean unused5 = NewAdsSurface.maxNativeAdHeightSet = true;
                        }
                        NewAdsSurface.this.moPubAdView.setBannerAdListener(new MoPubView.BannerAdListener() {
                            public void onBannerClicked(MoPubView moPubView) {
                            }

                            public void onBannerCollapsed(MoPubView moPubView) {
                            }

                            public void onBannerExpanded(MoPubView moPubView) {
                            }

                            public void onBannerLoaded(MoPubView moPubView) {
                                Log.v("NewAdsSurface", "MoPub banner successfully loaded (" + moPubView.getAdWidth() + "x" + moPubView.getAdHeight() + "), (" + NewAdsSurface.this.dipsToPixels((float) moPubView.getAdWidth()) + "x" + NewAdsSurface.this.dipsToPixels((float) moPubView.getAdHeight()) + ")");
                                if (NewAdsSurface.this.mGoogleAdView != null) {
                                    NewAdsSurface.this.endAdMobFallback();
                                }
                                NewAdsSurface.this.moPubAdView.setVisibility(0);
                                NewAdsSurface.this.adLoaded();
                            }

                            public void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode) {
                                Log.v("NewAdsSurface", "MoPub banner failed to load (" + moPubErrorCode.toString() + ")");
                                NewAdsSurface.this.moPubAdView.setVisibility(8);
                                if (NewAdsSurface.this.mGoogleAdView == null) {
                                    NewAdsSurface.this.startAdMobFallback();
                                }
                            }
                        });
                        NewAdsSurface.this.moPubAdView.setAutorefreshEnabled(true);
                        NewAdsSurface.this.loadBannerAdInternal();
                        if (NewAdsSurface.isBannerHiding) {
                            NewAdsSurface.hideBannerAd();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void startAdMobFallback() {
        Log.v("NewAdsSurface", "Falling back to AdMob Banners");
        adMobBannerInit();
        refreshAdMobBanner();
    }

    /* access modifiers changed from: private */
    public void endAdMobFallback() {
        if (this.mGoogleAdView != null) {
            Log.v("NewAdsSurface", "Ending fallback to AdMob Banners");
            adMobBannerDestroy();
        }
    }

    private void adMobBannerDestroy() {
        AdView adView = this.mGoogleAdView;
        if (adView != null) {
            if (adView.getParent() != null) {
                ((FrameLayout) this.mGoogleAdView.getParent()).removeView(this.mGoogleAdView);
            }
            this.mGoogleAdView.setAdListener((AdListener) null);
            this.mGoogleAdView.destroy();
            this.mGoogleAdView = null;
        }
    }

    /* access modifiers changed from: private */
    public void refreshAdMobBanner() {
        if (this.mGoogleAdView != null) {
            try {
                this.mGoogleAdView.loadAd(new AdRequest.Builder().build());
            } catch (NoClassDefFoundError unused) {
                Log.d("NewAdsSurface", "Fallback AdMob banner ad failed load call.");
                this.mGoogleAdView.setVisibility(8);
                adsFailed();
            }
        }
    }

    public static void hideAds() {
        instance.hideAdsInternal();
    }

    private void hideAdsInternal() {
        isNativeShowingAds = false;
        maxNativeAdHeightSet = false;
        Log.v("NewAdsSurface", "hide mopub ads - java");
        Handler handler = Cocos2dxActivity.getHandler();
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    NewAdsSurface.this.destroyBannerAds();
                }
            });
        }
    }

    public static void setSoundVolumePercent(float f) {
        MoPub.applicationVolume = f;
        MoPub.applicationMuted = f <= 0.0f;
    }

    private class AdViewListener extends AdListener {
        public void onAdClosed() {
        }

        private AdViewListener() {
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Log.d("NewAdsSurface", "Fallback AdMob banner ad failed to load.");
            NewAdsSurface.this.mGoogleAdView.setVisibility(8);
            NewAdsSurface.this.adsFailed();
        }

        public void onAdLoaded() {
            Log.d("NewAdsSurface", "Fallback AdMob banner ad loaded successfully.");
            HashMap hashMap = new HashMap();
            hashMap.put("ad_platform", "AdMob");
            hashMap.put(FullscreenAdService.DATA_KEY_AD_SOURCE, "AdMob Fallback");
            hashMap.put("ad_format", "Banner");
            AnalyticsManager.logEvent(NewAdsSurface.this.air, "ad_impression", hashMap);
            NewAdsSurface.this.mGoogleAdView.setVisibility(0);
            NewAdsSurface.this.adLoaded();
        }

        public void onAdOpened() {
            Log.d("NewAdsSurface", "Fallback AdMob banner ad clicked.");
        }
    }

    public boolean getIsShowingAds() {
        return isNativeShowingAds;
    }

    public String getMoPubBootPhoneID() {
        return this.moPubBootPhoneID;
    }

    public String getMoPubBootTabletID() {
        return this.moPubBootTabletID;
    }

    public String getMoPubBreakPhoneID() {
        return this.moPubBreakPhoneID;
    }

    public String getMoPubBreakTabletID() {
        return this.moPubBreakTabletID;
    }

    public String getMoPubRewardedPhoneID() {
        return this.moPubRewardedPhoneID;
    }

    public String getMoPubRewardedTabletID() {
        return this.moPubRewardedTabletID;
    }
}
