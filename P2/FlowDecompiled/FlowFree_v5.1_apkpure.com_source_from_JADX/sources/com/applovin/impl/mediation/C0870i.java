package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.mediation.p021a.C0740g;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.i */
public class C0870i {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f1232a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1062k f1233b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1107r f1234c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f1235d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0737e f1236e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f1237f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MaxAdapter f1238g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f1239h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0733a f1240i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f1241j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C0887a f1242k = new C0887a();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public MaxAdapterResponseParameters f1243l;

    /* renamed from: m */
    private final AtomicBoolean f1244m = new AtomicBoolean(true);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f1245n = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final AtomicBoolean f1246o = new AtomicBoolean(false);

    /* renamed from: com.applovin.impl.mediation.i$a */
    private class C0887a implements MaxAdViewAdapterListener, MaxInterstitialAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C0789d f1292b;

        private C0887a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1460a(C0789d dVar) {
            if (dVar != null) {
                this.f1292b = dVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1463a(String str, int i) {
            m1466a(str, new MaxAdapterError(i));
        }

        /* renamed from: a */
        private void m1464a(String str, final Bundle bundle) {
            C0870i.this.f1246o.set(true);
            m1465a(str, (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    if (C0870i.this.f1245n.compareAndSet(false, true)) {
                        C0887a.this.f1292b.mo8364a((MaxAd) C0870i.this.f1240i, bundle);
                    }
                }
            });
        }

        /* renamed from: a */
        private void m1465a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            C0870i.this.f1232a.post(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        MaxAdListener maxAdListener = maxAdListener;
                        String name = maxAdListener != null ? maxAdListener.getClass().getName() : null;
                        C1107r.m2480c("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + name, e);
                    }
                }
            });
        }

        /* renamed from: a */
        private void m1466a(String str, final MaxAdapterError maxAdapterError) {
            m1465a(str, (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    if (C0870i.this.f1245n.compareAndSet(false, true)) {
                        C0887a.this.f1292b.mo8367a(C0870i.this.f1239h, (C0861e) maxAdapterError);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m1468b(String str, int i) {
            m1470b(str, new MaxAdapterError(i));
        }

        /* renamed from: b */
        private void m1469b(String str, final Bundle bundle) {
            if (C0870i.this.f1240i.mo8406n().compareAndSet(false, true)) {
                m1465a(str, (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                    public void run() {
                        C0887a.this.f1292b.mo8368b(C0870i.this.f1240i, bundle);
                    }
                });
            }
        }

        /* renamed from: b */
        private void m1470b(String str, final MaxAdapterError maxAdapterError) {
            m1465a(str, (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.mo8365a((MaxAd) C0870i.this.f1240i, (C0861e) maxAdapterError);
                }
            });
        }

        public void onAdViewAdClicked() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad clicked");
            m1465a("onAdViewAdClicked", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdClicked(C0870i.this.f1240i);
                }
            });
        }

        public void onAdViewAdCollapsed() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad collapsed");
            m1465a("onAdViewAdCollapsed", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdCollapsed(C0870i.this.f1240i);
                }
            });
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad failed to display with code: " + maxAdapterError);
            m1470b("onAdViewAdDisplayFailed", maxAdapterError);
        }

        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed((Bundle) null);
        }

        public void onAdViewAdDisplayed(Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad displayed with extra info: " + bundle);
            m1469b("onAdViewAdDisplayed", bundle);
        }

        public void onAdViewAdExpanded() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad expanded");
            m1465a("onAdViewAdExpanded", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdExpanded(C0870i.this.f1240i);
                }
            });
        }

        public void onAdViewAdHidden() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad hidden");
            m1465a("onAdViewAdHidden", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdHidden(C0870i.this.f1240i);
                }
            });
        }

        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad ad failed to load with code: " + maxAdapterError);
            m1466a("onAdViewAdLoadFailed", maxAdapterError);
        }

        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, (Bundle) null);
        }

        public void onAdViewAdLoaded(View view, Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": adview ad loaded with extra info: " + bundle);
            View unused = C0870i.this.f1241j = view;
            m1464a("onAdViewAdLoaded", bundle);
        }

        public void onInterstitialAdClicked() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": interstitial ad clicked");
            m1465a("onInterstitialAdClicked", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdClicked(C0870i.this.f1240i);
                }
            });
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": interstitial ad failed to display with code " + maxAdapterError);
            m1470b("onInterstitialAdDisplayFailed", maxAdapterError);
        }

        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed((Bundle) null);
        }

        public void onInterstitialAdDisplayed(Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": interstitial ad displayed with extra info: " + bundle);
            m1469b("onInterstitialAdDisplayed", bundle);
        }

        public void onInterstitialAdHidden() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": interstitial ad hidden");
            m1465a("onInterstitialAdHidden", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdHidden(C0870i.this.f1240i);
                }
            });
        }

        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": interstitial ad failed to load with error " + maxAdapterError);
            m1466a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded((Bundle) null);
        }

        public void onInterstitialAdLoaded(Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": interstitial ad loaded with extra info: " + bundle);
            m1464a("onInterstitialAdLoaded", bundle);
        }

        public void onRewardedAdClicked() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded ad clicked");
            m1465a("onRewardedAdClicked", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdClicked(C0870i.this.f1240i);
                }
            });
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded ad display failed with error: " + maxAdapterError);
            m1470b("onRewardedAdDisplayFailed", maxAdapterError);
        }

        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed((Bundle) null);
        }

        public void onRewardedAdDisplayed(Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded ad displayed with extra info: " + bundle);
            m1469b("onRewardedAdDisplayed", bundle);
        }

        public void onRewardedAdHidden() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded ad hidden");
            m1465a("onRewardedAdHidden", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdHidden(C0870i.this.f1240i);
                }
            });
        }

        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded ad failed to load with error: " + maxAdapterError);
            m1466a("onRewardedAdLoadFailed", maxAdapterError);
        }

        public void onRewardedAdLoaded() {
            onRewardedAdLoaded((Bundle) null);
        }

        public void onRewardedAdLoaded(Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded ad loaded with extra info: " + bundle);
            m1464a("onRewardedAdLoaded", bundle);
        }

        public void onRewardedAdVideoCompleted() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded video completed");
            m1465a("onRewardedAdVideoCompleted", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onRewardedVideoCompleted(C0870i.this.f1240i);
                }
            });
        }

        public void onRewardedAdVideoStarted() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded video started");
            m1465a("onRewardedAdVideoStarted", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onRewardedVideoStarted(C0870i.this.f1240i);
                }
            });
        }

        public void onRewardedInterstitialAdClicked() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded interstitial ad clicked");
            m1465a("onRewardedInterstitialAdClicked", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdClicked(C0870i.this.f1240i);
                }
            });
        }

        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            m1470b("onRewardedInterstitialAdDisplayFailed", maxAdapterError);
        }

        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed((Bundle) null);
        }

        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded interstitial ad displayed with extra info: " + bundle);
            m1469b("onRewardedInterstitialAdDisplayed", bundle);
        }

        public void onRewardedInterstitialAdHidden() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded interstitial ad hidden");
            m1465a("onRewardedInterstitialAdHidden", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onAdHidden(C0870i.this.f1240i);
                }
            });
        }

        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1107r g = C0870i.this.f1234c;
            g.mo9587d("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded ad failed to load with error: " + maxAdapterError);
            m1466a("onRewardedInterstitialAdLoadFailed", maxAdapterError);
        }

        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded((Bundle) null);
        }

        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded interstitial ad loaded with extra info: " + bundle);
            m1464a("onRewardedInterstitialAdLoaded", bundle);
        }

        public void onRewardedInterstitialAdVideoCompleted() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded interstitial completed");
            m1465a("onRewardedInterstitialAdVideoCompleted", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onRewardedVideoCompleted(C0870i.this.f1240i);
                }
            });
        }

        public void onRewardedInterstitialAdVideoStarted() {
            C1107r g = C0870i.this.f1234c;
            g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": rewarded interstitial started");
            m1465a("onRewardedInterstitialAdVideoStarted", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                public void run() {
                    C0887a.this.f1292b.onRewardedVideoStarted(C0870i.this.f1240i);
                }
            });
        }

        public void onUserRewarded(final MaxReward maxReward) {
            if (C0870i.this.f1240i instanceof C0735c) {
                final C0735c cVar = (C0735c) C0870i.this.f1240i;
                if (cVar.mo8428F().compareAndSet(false, true)) {
                    C1107r g = C0870i.this.f1234c;
                    g.mo9586c("MediationAdapterWrapper", C0870i.this.f1237f + ": user was rewarded: " + maxReward);
                    m1465a("onUserRewarded", (MaxAdListener) this.f1292b, (Runnable) new Runnable() {
                        public void run() {
                            C0887a.this.f1292b.onUserRewarded(cVar, maxReward);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.i$b */
    private static class C0908b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C0740g f1322a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final MaxSignalCollectionListener f1323b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final AtomicBoolean f1324c = new AtomicBoolean();

        C0908b(C0740g gVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.f1322a = gVar;
            this.f1323b = maxSignalCollectionListener;
        }
    }

    /* renamed from: com.applovin.impl.mediation.i$c */
    private class C0909c extends C0989a {
        private C0909c() {
            super("TaskTimeoutMediatedAd", C0870i.this.f1233b);
        }

        public void run() {
            if (!C0870i.this.f1245n.get()) {
                mo9216d(C0870i.this.f1237f + " is timing out " + C0870i.this.f1240i + "...");
                this.f1980b.mo9330F().mo8846a(C0870i.this.f1240i);
                C0870i.this.f1242k.m1463a(mo9217e(), -5101);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.i$d */
    private class C0910d extends C0989a {

        /* renamed from: c */
        private final C0908b f1327c;

        private C0910d(C0908b bVar) {
            super("TaskTimeoutSignalCollection", C0870i.this.f1233b);
            this.f1327c = bVar;
        }

        public void run() {
            if (!this.f1327c.f1324c.get()) {
                mo9216d(C0870i.this.f1237f + " is timing out " + this.f1327c.f1322a + "...");
                C0870i iVar = C0870i.this;
                iVar.m1434b("The adapter (" + C0870i.this.f1237f + ") timed out", this.f1327c);
            }
        }
    }

    C0870i(C0737e eVar, MaxAdapter maxAdapter, C1062k kVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        } else if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        } else if (kVar != null) {
            this.f1235d = eVar.mo8443J();
            this.f1238g = maxAdapter;
            this.f1233b = kVar;
            this.f1234c = kVar.mo9411z();
            this.f1236e = eVar;
            this.f1237f = maxAdapter.getClass().getSimpleName();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1429a(String str) {
        C1107r rVar = this.f1234c;
        rVar.mo9586c("MediationAdapterWrapper", "Marking " + this.f1237f + " as disabled due to: " + str);
        this.f1244m.set(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1430a(String str, C0908b bVar) {
        if (bVar.f1324c.compareAndSet(false, true) && bVar.f1323b != null) {
            bVar.f1323b.onSignalCollected(str);
        }
    }

    /* renamed from: a */
    private void m1431a(final String str, final Runnable runnable) {
        C08825 r0 = new Runnable() {
            public void run() {
                try {
                    C1107r g = C0870i.this.f1234c;
                    g.mo9584b("MediationAdapterWrapper", C0870i.this.f1237f + ": running " + str + "...");
                    runnable.run();
                    C1107r g2 = C0870i.this.f1234c;
                    g2.mo9584b("MediationAdapterWrapper", C0870i.this.f1237f + ": finished " + str + "");
                } catch (Throwable th) {
                    C1107r.m2480c("MediationAdapterWrapper", "Unable to run adapter operation " + str + ", marking " + C0870i.this.f1237f + " as disabled", th);
                    C0870i iVar = C0870i.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("fail_");
                    sb.append(str);
                    iVar.m1429a(sb.toString());
                    if (!str.equals("destroy")) {
                        C0870i.this.f1233b.mo9325A().mo8749a(C0870i.this.f1236e.mo8442I(), str, C0870i.this.f1240i);
                    }
                }
            }
        };
        if (this.f1236e.mo8449P()) {
            this.f1232a.post(r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1434b(String str, C0908b bVar) {
        if (bVar.f1324c.compareAndSet(false, true) && bVar.f1323b != null) {
            bVar.f1323b.onSignalCollectionFailed(str);
        }
    }

    /* renamed from: a */
    public View mo8756a() {
        return this.f1241j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8757a(final C0733a aVar, final Activity activity) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (aVar.mo8391f() == null) {
            this.f1242k.m1468b("ad_show", -5201);
        } else if (aVar.mo8391f() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (!this.f1244m.get()) {
            C1107r.m2484i("MediationAdapterWrapper", "Mediation adapter '" + this.f1237f + "' is disabled. Showing ads with this adapter is disabled.");
            this.f1242k.m1468b("ad_show", -5103);
        } else if (mo8765e()) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) C0870i.this.f1238g).showInterstitialAd(C0870i.this.f1243l, activity, C0870i.this.f1242k);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) C0870i.this.f1238g).showRewardedAd(C0870i.this.f1243l, activity, C0870i.this.f1242k);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) C0870i.this.f1238g).showRewardedInterstitialAd(C0870i.this.f1243l, activity, C0870i.this.f1242k);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            m1431a("show_ad", (Runnable) new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        C1107r.m2480c("MediationAdapterWrapper", "Failed to start displaying ad" + aVar, th);
                        C0870i.this.f1242k.m1468b("show_ad", (int) MaxAdapterError.ERROR_CODE_UNSPECIFIED);
                        C0870i.this.m1429a("show_ad");
                        C0870i.this.f1233b.mo9325A().mo8749a(C0870i.this.f1236e.mo8442I(), "show_ad", C0870i.this.f1240i);
                    }
                }
            });
        } else {
            throw new IllegalStateException("Mediation adapter '" + this.f1237f + "' does not have an ad loaded. Please load an ad first");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8758a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity) {
        m1431a("initialize", (Runnable) new Runnable() {
            public void run() {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                C0870i.this.f1238g.initialize(maxAdapterInitializationParameters, activity, new MaxAdapter.OnCompletionListener() {
                    public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                C08721 r2 = C08721.this;
                                C0870i.this.f1233b.mo9326B().mo8740a(C0870i.this.f1236e, elapsedRealtime - elapsedRealtime, initializationStatus, str);
                            }
                        }, C0870i.this.f1236e.mo8452S());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8759a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, C0740g gVar, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (!this.f1244m.get()) {
            C1107r.m2484i("MediationAdapterWrapper", "Mediation adapter '" + this.f1237f + "' is disabled. Signal collection ads with this adapter is disabled.");
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.f1237f + ") is disabled");
        } else {
            final C0908b bVar = new C0908b(gVar, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.f1238g;
            if (maxAdapter instanceof MaxSignalProvider) {
                final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
                final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters2 = maxAdapterSignalCollectionParameters;
                final Activity activity2 = activity;
                final C0740g gVar2 = gVar;
                m1431a("collect_signal", (Runnable) new Runnable() {
                    public void run() {
                        StringBuilder sb;
                        try {
                            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters2, activity2, new MaxSignalCollectionListener() {
                                public void onSignalCollected(String str) {
                                    C08793 r0 = C08793.this;
                                    C0870i.this.m1430a(str, bVar);
                                }

                                public void onSignalCollectionFailed(String str) {
                                    C08793 r0 = C08793.this;
                                    C0870i.this.m1434b(str, bVar);
                                }
                            });
                        } catch (Throwable th) {
                            C0870i iVar = C0870i.this;
                            iVar.m1434b("Failed signal collection for " + C0870i.this.f1235d + " due to exception: " + th, bVar);
                            C0870i.this.m1429a("collect_signal");
                            C0870i.this.f1233b.mo9325A().mo8749a(C0870i.this.f1236e.mo8442I(), "collect_signal", C0870i.this.f1240i);
                        }
                        if (bVar.f1324c.get()) {
                            return;
                        }
                        if (gVar2.mo8451R() == 0) {
                            C1107r g = C0870i.this.f1234c;
                            g.mo9584b("MediationAdapterWrapper", "Failing signal collection " + gVar2 + " since it has 0 timeout");
                            C0870i iVar2 = C0870i.this;
                            iVar2.m1434b("The adapter (" + C0870i.this.f1237f + ") has 0 timeout", bVar);
                            return;
                        }
                        int i = (gVar2.mo8451R() > 0 ? 1 : (gVar2.mo8451R() == 0 ? 0 : -1));
                        C1107r g2 = C0870i.this.f1234c;
                        if (i > 0) {
                            sb.append("Setting timeout ");
                            sb.append(gVar2.mo8451R());
                            sb.append("ms. for ");
                            sb.append(gVar2);
                            g2.mo9584b("MediationAdapterWrapper", sb.toString());
                            C0870i.this.f1233b.mo9340Q().mo9267a(new C0910d(bVar), C1020o.C1022a.MEDIATION_TIMEOUT, gVar2.mo8451R());
                            return;
                        }
                        sb = new StringBuilder();
                        sb.append("Negative timeout set for ");
                        sb.append(gVar2);
                        sb.append(", not scheduling a timeout");
                        g2.mo9584b("MediationAdapterWrapper", sb.toString());
                    }
                });
                return;
            }
            m1434b("The adapter (" + this.f1237f + ") does not support signal collection", bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8760a(String str, C0733a aVar) {
        this.f1239h = str;
        this.f1240i = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8761a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final C0733a aVar, final Activity activity, C0789d dVar) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.f1244m.get()) {
            C1107r.m2484i("MediationAdapterWrapper", "Mediation adapter '" + this.f1237f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.");
            dVar.onAdLoadFailed(str, -5103);
        } else {
            this.f1243l = maxAdapterResponseParameters;
            this.f1242k.m1460a(dVar);
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) C0870i.this.f1238g).loadInterstitialAd(maxAdapterResponseParameters, activity, C0870i.this.f1242k);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) C0870i.this.f1238g).loadRewardedAd(maxAdapterResponseParameters, activity, C0870i.this.f1242k);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) C0870i.this.f1238g).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, C0870i.this.f1242k);
                    }
                };
            } else if (aVar.getFormat().isAdViewAd()) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxAdViewAdapter) C0870i.this.f1238g).loadAdViewAd(maxAdapterResponseParameters, aVar.getFormat(), activity, C0870i.this.f1242k);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to load " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            m1431a("load_ad", (Runnable) new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        C1107r.m2480c("MediationAdapterWrapper", "Failed start loading " + aVar, th);
                        C0870i.this.f1242k.m1463a("load_ad", -1);
                        C0870i.this.m1429a("load_ad");
                        C0870i.this.f1233b.mo9325A().mo8749a(C0870i.this.f1236e.mo8442I(), "load_ad", C0870i.this.f1240i);
                    }
                    if (!C0870i.this.f1245n.get()) {
                        long R = C0870i.this.f1236e.mo8451R();
                        if (R > 0) {
                            C1107r g = C0870i.this.f1234c;
                            g.mo9584b("MediationAdapterWrapper", "Setting timeout " + R + "ms. for " + aVar);
                            C0870i.this.f1233b.mo9340Q().mo9267a(new C0909c(), C1020o.C1022a.MEDIATION_TIMEOUT, R);
                            return;
                        }
                        C1107r g2 = C0870i.this.f1234c;
                        g2.mo9584b("MediationAdapterWrapper", "Negative timeout set for " + aVar + ", not scheduling a timeout");
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public String mo8762b() {
        return this.f1235d;
    }

    /* renamed from: c */
    public C0789d mo8763c() {
        return this.f1242k.f1292b;
    }

    /* renamed from: d */
    public boolean mo8764d() {
        return this.f1244m.get();
    }

    /* renamed from: e */
    public boolean mo8765e() {
        return this.f1245n.get() && this.f1246o.get();
    }

    /* renamed from: f */
    public String mo8766f() {
        MaxAdapter maxAdapter = this.f1238g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            C1107r.m2480c("MediationAdapterWrapper", "Unable to get adapter's SDK version, marking " + this + " as disabled", th);
            m1429a("sdk_version");
            this.f1233b.mo9325A().mo8749a(this.f1236e.mo8442I(), "sdk_version", this.f1240i);
            return null;
        }
    }

    /* renamed from: g */
    public String mo8767g() {
        MaxAdapter maxAdapter = this.f1238g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            C1107r.m2480c("MediationAdapterWrapper", "Unable to get adapter version, marking " + this + " as disabled", th);
            m1429a("adapter_version");
            this.f1233b.mo9325A().mo8749a(this.f1236e.mo8442I(), "adapter_version", this.f1240i);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo8768h() {
        m1431a("destroy", (Runnable) new Runnable() {
            public void run() {
                C0870i.this.m1429a("destroy");
                C0870i.this.f1238g.onDestroy();
                MaxAdapter unused = C0870i.this.f1238g = null;
            }
        });
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f1237f + "'" + '}';
    }
}
