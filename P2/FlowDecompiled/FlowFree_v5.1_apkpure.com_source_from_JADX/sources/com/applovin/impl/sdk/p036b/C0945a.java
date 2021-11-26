package com.applovin.impl.sdk.p036b;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p035a.C0940h;
import com.applovin.impl.sdk.p035a.C0941i;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1035u;
import com.applovin.impl.sdk.p039e.C1043z;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b.a */
public class C0945a {

    /* renamed from: a */
    protected final C1062k f1481a;

    /* renamed from: b */
    protected final AppLovinAdServiceImpl f1482b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinAd f1483c;

    /* renamed from: d */
    private String f1484d;

    /* renamed from: e */
    private SoftReference<AppLovinAdLoadListener> f1485e;

    /* renamed from: f */
    private final Object f1486f = new Object();

    /* renamed from: g */
    private volatile String f1487g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f1488h = false;

    /* renamed from: com.applovin.impl.sdk.b.a$a */
    private class C0947a implements AppLovinAdLoadListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final AppLovinAdLoadListener f1491b;

        C0947a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f1491b = appLovinAdLoadListener;
        }

        public void adReceived(final AppLovinAd appLovinAd) {
            AppLovinAd unused = C0945a.this.f1483c = appLovinAd;
            if (this.f1491b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C0947a.this.f1491b.adReceived(appLovinAd);
                        } catch (Throwable th) {
                            C1107r.m2480c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                        }
                    }
                });
            }
        }

        public void failedToReceiveAd(final int i) {
            if (this.f1491b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C0947a.this.f1491b.failedToReceiveAd(i);
                        } catch (Throwable th) {
                            C1107r.m2480c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.b.a$b */
    private class C0950b implements C0941i, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

        /* renamed from: b */
        private final AppLovinAdDisplayListener f1497b;

        /* renamed from: c */
        private final AppLovinAdClickListener f1498c;

        /* renamed from: d */
        private final AppLovinAdVideoPlaybackListener f1499d;

        /* renamed from: e */
        private final AppLovinAdRewardListener f1500e;

        private C0950b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f1497b = appLovinAdDisplayListener;
            this.f1498c = appLovinAdClickListener;
            this.f1499d = appLovinAdVideoPlaybackListener;
            this.f1500e = appLovinAdRewardListener;
        }

        /* renamed from: a */
        private void m1720a(C0934g gVar) {
            String str;
            int i;
            if (!C1155o.m2673b(C0945a.this.m1712e()) || !C0945a.this.f1488h) {
                gVar.mo9028aG();
                if (C0945a.this.f1488h) {
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                    str = "network_timeout";
                } else {
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                    str = "user_closed_video";
                }
                gVar.mo9020a(C0962c.m1734a(str));
                C1124k.m2618a(this.f1500e, (AppLovinAd) gVar, i);
            }
            C0945a.this.m1703a((AppLovinAd) gVar);
            C1124k.m2627b(this.f1497b, (AppLovinAd) gVar);
            if (!gVar.mo9037ae().getAndSet(true)) {
                C0945a.this.f1481a.mo9340Q().mo9266a((C0989a) new C1035u(gVar, C0945a.this.f1481a), C1020o.C1022a.REWARD);
            }
        }

        public void adClicked(AppLovinAd appLovinAd) {
            C1124k.m2615a(this.f1498c, appLovinAd);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            C1124k.m2616a(this.f1497b, appLovinAd);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (appLovinAd instanceof C0940h) {
                appLovinAd = ((C0940h) appLovinAd).mo9075a();
            }
            if (appLovinAd instanceof C0934g) {
                m1720a((C0934g) appLovinAd);
                return;
            }
            C1107r z = C0945a.this.f1481a.mo9411z();
            z.mo9588e("IncentivizedAdController", "Something is terribly wrong. Received `adHidden` callback for invalid ad of type: " + appLovinAd);
        }

        public void onAdDisplayFailed(String str) {
            C1124k.m2617a(this.f1497b, str);
        }

        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            C0945a.this.m1706a("quota_exceeded");
            C1124k.m2628b(this.f1500e, appLovinAd, map);
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            C0945a.this.m1706a("rejected");
            C1124k.m2631c(this.f1500e, appLovinAd, map);
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            C0945a.this.m1706a("accepted");
            C1124k.m2619a(this.f1500e, appLovinAd, map);
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            C0945a.this.m1706a("network_timeout");
            C1124k.m2618a(this.f1500e, appLovinAd, i);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            C1124k.m2620a(this.f1499d, appLovinAd);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            C1124k.m2621a(this.f1499d, appLovinAd, d, z);
            boolean unused = C0945a.this.f1488h = z;
        }
    }

    public C0945a(String str, AppLovinSdk appLovinSdk) {
        this.f1481a = appLovinSdk.coreSdk;
        this.f1482b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f1484d = str;
    }

    /* renamed from: a */
    private void m1699a(AppLovinAdBase appLovinAdBase, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdBase.getType() == AppLovinAdType.INCENTIVIZED || appLovinAdBase.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            AppLovinAd a = C1160r.m2706a((AppLovinAd) appLovinAdBase, this.f1481a);
            if (a != null) {
                AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f1481a.mo9347X(), context);
                C0950b bVar = new C0950b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
                create.setAdDisplayListener(bVar);
                create.setAdVideoPlaybackListener(bVar);
                create.setAdClickListener(bVar);
                create.showAndRender(a);
                if (a instanceof C0934g) {
                    m1700a((C0934g) a, (AppLovinAdRewardListener) bVar);
                    return;
                }
                return;
            }
            m1705a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
            return;
        }
        C1107r z = this.f1481a.mo9411z();
        z.mo9588e("IncentivizedAdController", "Failed to render an ad of type " + appLovinAdBase.getType() + " in an Incentivized Ad interstitial.");
        m1705a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
    }

    /* renamed from: a */
    private void m1700a(C0934g gVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f1481a.mo9340Q().mo9266a((C0989a) new C1043z(gVar, appLovinAdRewardListener, this.f1481a), C1020o.C1022a.REWARD);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1703a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f1483c;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof C0940h) {
                if (appLovinAd != ((C0940h) appLovinAd2).mo9075a()) {
                    return;
                }
            } else if (appLovinAd != appLovinAd2) {
                return;
            }
            this.f1483c = null;
        }
    }

    /* renamed from: a */
    private void m1704a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.f1483c;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
        if (appLovinAdBase != null) {
            m1699a(appLovinAdBase, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        C1107r.m2484i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m1711d();
    }

    /* renamed from: a */
    private void m1705a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f1481a.mo9341R().mo9199a(C0986g.f1963j);
        C1124k.m2621a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        C1124k.m2627b(appLovinAdDisplayListener, appLovinAd);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1706a(String str) {
        synchronized (this.f1486f) {
            this.f1487g = str;
        }
    }

    /* renamed from: b */
    private void m1709b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1482b.loadNextIncentivizedAd(this.f1484d, appLovinAdLoadListener);
    }

    /* renamed from: d */
    private void m1711d() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.f1485e;
        if (softReference != null && (appLovinAdLoadListener = softReference.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public String m1712e() {
        String str;
        synchronized (this.f1486f) {
            str = this.f1487g;
        }
        return str;
    }

    /* renamed from: f */
    private AppLovinAdRewardListener m1713f() {
        return new AppLovinAdRewardListener() {
            public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
                C0945a.this.f1481a.mo9411z().mo9584b("IncentivizedAdController", "User declined to view");
            }

            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                C1107r z = C0945a.this.f1481a.mo9411z();
                z.mo9584b("IncentivizedAdController", "User over quota: " + map);
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                C1107r z = C0945a.this.f1481a.mo9411z();
                z.mo9584b("IncentivizedAdController", "Reward rejected: " + map);
            }

            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                C1107r z = C0945a.this.f1481a.mo9411z();
                z.mo9584b("IncentivizedAdController", "Reward validated: " + map);
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                C1107r z = C0945a.this.f1481a.mo9411z();
                z.mo9584b("IncentivizedAdController", "Reward validation failed: " + i);
            }
        };
    }

    /* renamed from: a */
    public void mo9082a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = m1713f();
        }
        m1704a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    public void mo9083a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1481a.mo9411z().mo9584b("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.f1485e = new SoftReference<>(appLovinAdLoadListener);
        if (mo9084a()) {
            C1107r.m2484i("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f1483c);
                return;
            }
            return;
        }
        m1709b((AppLovinAdLoadListener) new C0947a(appLovinAdLoadListener));
    }

    /* renamed from: a */
    public boolean mo9084a() {
        return this.f1483c != null;
    }

    /* renamed from: b */
    public String mo9085b() {
        return this.f1484d;
    }

    /* renamed from: c */
    public void mo9086c() {
    }
}
