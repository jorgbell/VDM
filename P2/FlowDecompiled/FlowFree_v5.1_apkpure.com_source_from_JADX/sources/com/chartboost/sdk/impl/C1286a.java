package com.chartboost.sdk.impl;

import com.chartboost.sdk.C1272a;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.Tracking.C1267f;

/* renamed from: com.chartboost.sdk.impl.a */
public class C1286a {

    /* renamed from: a */
    public final int f3035a;

    /* renamed from: b */
    public final String f3036b;

    /* renamed from: c */
    public final String f3037c;

    /* renamed from: d */
    public final String f3038d;

    /* renamed from: e */
    public final String f3039e;

    /* renamed from: f */
    public final boolean f3040f;

    /* renamed from: g */
    public final boolean f3041g;

    /* renamed from: com.chartboost.sdk.impl.a$a */
    public class C1287a implements Runnable {

        /* renamed from: a */
        private final int f3042a;

        /* renamed from: b */
        private final String f3043b;

        /* renamed from: c */
        private final CBError.CBImpressionError f3044c;

        /* renamed from: d */
        private final ChartboostError f3045d;

        /* renamed from: e */
        private final boolean f3046e;

        /* renamed from: f */
        private final String f3047f;

        public C1287a(int i, String str, CBError.CBImpressionError cBImpressionError, ChartboostError chartboostError, boolean z, String str2) {
            this.f3042a = i;
            this.f3043b = str;
            this.f3044c = cBImpressionError;
            this.f3045d = chartboostError;
            this.f3046e = z;
            this.f3047f = str2;
        }

        public void run() {
            switch (this.f3042a) {
                case 0:
                    C1286a.this.mo10367a(this.f3043b, this.f3047f);
                    return;
                case 1:
                    C1286a.this.mo10371b(this.f3043b, this.f3047f);
                    return;
                case 2:
                    C1286a.this.mo10373c(this.f3043b, this.f3047f);
                    return;
                case 3:
                    C1286a.this.mo10374d(this.f3043b, this.f3047f);
                    return;
                case 4:
                    C1286a.this.mo10366a(this.f3043b, this.f3044c, this.f3046e, this.f3047f);
                    return;
                case 5:
                    C1286a.this.mo10375e(this.f3043b, this.f3047f);
                    return;
                case 6:
                    C1286a.this.mo10368a(this.f3043b, this.f3047f, (ChartboostCacheError) this.f3045d);
                    return;
                case 7:
                    C1286a.this.mo10369a(this.f3043b, this.f3047f, (ChartboostShowError) this.f3045d);
                    return;
                default:
                    return;
            }
        }
    }

    protected C1286a(int i, String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.f3035a = i;
        this.f3036b = str;
        this.f3037c = str2;
        this.f3038d = str3;
        this.f3039e = str4;
        this.f3040f = z;
        this.f3041g = z2;
    }

    /* renamed from: b */
    public static C1286a m3351b() {
        return new C1286a(2, "inplay", "/inplay/get", "no webview endpoint", "/inplay/show", false, true);
    }

    /* renamed from: c */
    public static C1286a m3352c() {
        return new C1286a(0, "Interstitial", "/interstitial/get", "webview/%s/interstitial/get", "/interstitial/show", false, false);
    }

    /* renamed from: d */
    public static C1286a m3353d() {
        return new C1286a(1, "Rewarded", "/reward/get", "webview/%s/reward/get", "/reward/show", true, false);
    }

    /* renamed from: a */
    public void mo10367a(String str, String str2) {
        C1266e.m3223e(new C1267f("cache_finish_success", "", this.f3036b, str));
        C1272a aVar = C1418k.f3534d;
        if (aVar != null) {
            int i = this.f3035a;
            if (i == 0) {
                aVar.didCacheInterstitial(str);
            } else if (i == 1) {
                aVar.didCacheRewardedVideo(str);
            } else if (i == 2) {
                aVar.didCacheInPlay(str);
            }
        }
    }

    /* renamed from: a */
    public void mo10368a(String str, String str2, ChartboostCacheError chartboostCacheError) {
    }

    /* renamed from: a */
    public void mo10369a(String str, String str2, ChartboostShowError chartboostShowError) {
    }

    /* renamed from: e */
    public void mo10375e(String str, String str2) {
        C1414j b = C1414j.m3867b();
        if (b != null) {
            b.mo10706a(this.f3035a);
        }
        C1266e.m3223e(new C1267f("show_finish_success", "", this.f3036b, str));
        C1272a aVar = C1418k.f3534d;
        if (aVar != null) {
            int i = this.f3035a;
            if (i == 0) {
                aVar.didDisplayInterstitial(str);
            } else if (i == 1) {
                aVar.didDisplayRewardedVideo(str);
            }
        }
    }

    /* renamed from: b */
    public void mo10371b(String str, String str2) {
        C1272a aVar = C1418k.f3534d;
        if (aVar != null) {
            int i = this.f3035a;
            if (i == 0) {
                aVar.didClickInterstitial(str);
            } else if (i == 1) {
                aVar.didClickRewardedVideo(str);
            }
        }
    }

    /* renamed from: c */
    public void mo10373c(String str, String str2) {
        C1272a aVar = C1418k.f3534d;
        if (aVar != null) {
            int i = this.f3035a;
            if (i == 0) {
                aVar.didCloseInterstitial(str);
            } else if (i == 1) {
                aVar.didCloseRewardedVideo(str);
            }
        }
    }

    /* renamed from: d */
    public void mo10374d(String str, String str2) {
        C1272a aVar = C1418k.f3534d;
        if (aVar != null) {
            int i = this.f3035a;
            if (i == 0) {
                aVar.didDismissInterstitial(str);
            } else if (i == 1) {
                aVar.didDismissRewardedVideo(str);
            }
        }
    }

    /* renamed from: b */
    public boolean mo10372b(String str) {
        C1272a aVar = C1418k.f3534d;
        if (aVar == null || this.f3035a != 0) {
            return true;
        }
        return aVar.shouldRequestInterstitial(str);
    }

    /* renamed from: a */
    public void mo10366a(String str, CBError.CBImpressionError cBImpressionError, boolean z, String str2) {
        if (z) {
            C1266e.m3223e(new C1267f("show_finish_failure", cBImpressionError.name(), this.f3036b, str));
        } else {
            C1266e.m3223e(new C1267f("cache_finish_failure", cBImpressionError.name(), this.f3036b, str));
        }
        cBImpressionError.setAdId(str2);
        C1272a aVar = C1418k.f3534d;
        if (aVar != null) {
            int i = this.f3035a;
            if (i == 0) {
                aVar.didFailToLoadInterstitial(str, cBImpressionError);
            } else if (i == 1) {
                aVar.didFailToLoadRewardedVideo(str, cBImpressionError);
            } else if (i == 2) {
                aVar.didFailToLoadInPlay(str, cBImpressionError);
            }
        }
    }

    /* renamed from: a */
    public boolean mo10370a(String str) {
        C1272a aVar = C1418k.f3534d;
        if (aVar == null) {
            return true;
        }
        int i = this.f3035a;
        if (i == 0) {
            return aVar.shouldDisplayInterstitial(str);
        }
        if (i != 1) {
            return true;
        }
        return aVar.shouldDisplayRewardedVideo(str);
    }

    /* renamed from: a */
    public String mo10365a() {
        return this.f3036b;
    }
}
