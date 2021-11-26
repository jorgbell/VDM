package com.chartboost.sdk.Banner;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.chartboost.sdk.C1257R;
import com.chartboost.sdk.C1273b;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.ChartboostBannerListener;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostCacheEvent;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostClickEvent;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Events.ChartboostShowEvent;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.Tracking.C1267f;
import com.chartboost.sdk.impl.C1293c;
import com.chartboost.sdk.impl.C1363q;
import com.chartboost.sdk.impl.C1366r;
import com.chartboost.sdk.impl.C1372t;

/* renamed from: com.chartboost.sdk.Banner.c */
public class C1207c implements C1293c, C1366r, C1372t {

    /* renamed from: a */
    public String f2633a;

    /* renamed from: b */
    public BannerSize f2634b;

    /* renamed from: c */
    private ChartboostBannerListener f2635c;

    /* renamed from: d */
    private C1210e f2636d;

    /* renamed from: e */
    private C1209d f2637e;

    /* renamed from: f */
    private C1273b f2638f;

    /* renamed from: g */
    private C1363q f2639g;

    /* renamed from: com.chartboost.sdk.Banner.c$a */
    public static class C1208a {

        /* renamed from: a */
        public String f2640a;

        /* renamed from: b */
        public BannerSize f2641b;
    }

    /* renamed from: b */
    private void m2867b(String str) {
        if (str != null) {
            this.f2638f.mo10291a(mo9959e(), str, "");
        } else {
            this.f2638f.mo10290a(mo9959e(), "");
        }
    }

    /* renamed from: g */
    private void m2873g() {
        m2876l();
        this.f2637e.mo9968a(this.f2636d, this.f2634b);
        this.f2638f.mo10295c(mo9959e(), "");
    }

    /* renamed from: j */
    private void m2874j() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Register refresh for location: " + mo9959e() + " at intervals of " + this.f2639g.mo10584f() + " sec");
            this.f2639g.mo10579a((C1366r) this);
            this.f2639g.mo10588j();
        }
    }

    /* renamed from: k */
    private void m2875k() {
        if (this.f2638f == null) {
            C1273b c = C1414j.m3869c();
            this.f2638f = c;
            if (c != null) {
                m2878p();
                this.f2639g.mo10579a((C1366r) this);
                this.f2639g.mo10580a((C1372t) this);
            }
        }
    }

    /* renamed from: l */
    private void m2876l() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Register timeout for location: " + mo9959e() + " at intervals of " + this.f2639g.mo10585g() + " sec");
            this.f2639g.mo10580a((C1372t) this);
            this.f2639g.mo10589k();
        }
    }

    /* renamed from: o */
    private boolean m2877o() {
        C1414j b = C1414j.m3867b();
        return b == null || !b.mo10719m();
    }

    /* renamed from: p */
    private void m2878p() {
        C1414j b = C1414j.m3867b();
        C1210e eVar = this.f2636d;
        if (eVar == null || b == null) {
            CBLogging.m2905b("BannerPresenter", "Please start with Chartboost SDK before creating any ChartboostBanner objects");
            return;
        }
        C1414j.C1416b sdkCommand = eVar.getSdkCommand();
        if (sdkCommand != null) {
            C1414j.m3873e(this.f2636d.attachBannerToSDKCommand(sdkCommand));
        }
    }

    /* renamed from: r */
    private void m2879r() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Unregister refresh for location: " + mo9959e());
            this.f2639g.mo10592n();
        }
    }

    /* renamed from: s */
    private void m2880s() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Un-register timeout for location: " + mo9959e());
            this.f2639g.mo10593o();
        }
    }

    /* renamed from: a */
    public C1208a mo9945a(Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C1257R.styleable.ChartboostBanner, 0, 0);
        String string = obtainStyledAttributes.getString(C1257R.styleable.ChartboostBanner_location);
        BannerSize fromInteger = BannerSize.fromInteger(obtainStyledAttributes.getInt(C1257R.styleable.ChartboostBanner_size, 0));
        obtainStyledAttributes.recycle();
        C1208a aVar = new C1208a();
        aVar.f2640a = string;
        aVar.f2641b = fromInteger;
        return aVar;
    }

    /* renamed from: c */
    public String mo9953c(String str) {
        this.f2633a = str;
        return str;
    }

    /* renamed from: d */
    public void mo9955d() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Unregister refresh and timeout for location: " + mo9959e());
            this.f2639g.mo10593o();
            this.f2639g.mo10592n();
            this.f2639g.mo10578a();
            this.f2639g = null;
        }
        this.f2636d = null;
        this.f2633a = null;
        this.f2635c = null;
        this.f2637e = null;
        this.f2638f = null;
    }

    public void didCacheBanner(String str, String str2, ChartboostCacheError chartboostCacheError) {
        m2868c(chartboostCacheError);
        ChartboostBannerListener chartboostBannerListener = this.f2635c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(str2), chartboostCacheError);
        }
    }

    public void didClickBanner(String str, String str2, ChartboostClickError chartboostClickError) {
        C1363q qVar = this.f2639g;
        if (qVar != null && qVar.mo10583d()) {
            mo9967q();
        }
        ChartboostBannerListener chartboostBannerListener = this.f2635c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdClicked(new ChartboostClickEvent(str2), chartboostClickError);
        }
    }

    public void didShowBanner(String str, String str2, ChartboostShowError chartboostShowError) {
        m2871d(chartboostShowError);
        m2869c(chartboostShowError);
        m2880s();
        ChartboostShowEvent chartboostShowEvent = new ChartboostShowEvent(str2);
        chartboostShowEvent.location = str;
        ChartboostBannerListener chartboostBannerListener = this.f2635c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdShown(chartboostShowEvent, chartboostShowError);
            C1363q qVar = this.f2639g;
            if (qVar != null && qVar.mo10583d()) {
                mo9954c();
                m2874j();
            }
        }
    }

    /* renamed from: e */
    public String mo9959e() {
        return this.f2633a;
    }

    /* renamed from: f */
    public Boolean mo9960f() {
        C1273b bVar = this.f2638f;
        if (bVar != null) {
            return Boolean.valueOf(bVar.mo10294b(mo9959e()));
        }
        ChartboostBannerListener chartboostBannerListener = this.f2635c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(""), new ChartboostCacheError(ChartboostCacheError.Code.INTERNAL));
        }
        return Boolean.FALSE;
    }

    /* renamed from: h */
    public void mo9961h() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Pause refresh for location: " + mo9959e());
            this.f2639g.mo10586h();
        }
    }

    /* renamed from: i */
    public void mo9962i() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Pause timeout for location: " + mo9959e());
            this.f2639g.mo10587i();
        }
    }

    /* renamed from: m */
    public void mo9963m() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Restart refresh if was paused for location: " + mo9959e());
            this.f2639g.mo10590l();
        }
    }

    /* renamed from: n */
    public void mo9964n() {
        if (this.f2639g != null) {
            CBLogging.m2903a("BannerPresenter", "Resume timeout if was paused for location: " + mo9959e());
            this.f2639g.mo10591m();
        }
    }

    public void onBannerCacheFail(String str, String str2, ChartboostCacheError chartboostCacheError) {
        m2874j();
        didCacheBanner(str, str2, chartboostCacheError);
    }

    public void onBannerShowFail(String str, String str2, ChartboostShowError chartboostShowError) {
        m2874j();
        didShowBanner(str, str2, chartboostShowError);
        if (chartboostShowError != null && chartboostShowError.shouldRetry) {
            mo9967q();
        }
    }

    /* renamed from: q */
    public void mo9967q() {
        if (m2877o()) {
            CBLogging.m2905b("BannerPresenter", "Chartboost SDK is not initialised");
            ChartboostBannerListener chartboostBannerListener = this.f2635c;
            if (chartboostBannerListener != null) {
                chartboostBannerListener.onAdShown(new ChartboostShowEvent(""), new ChartboostShowError(ChartboostShowError.Code.SESSION_NOT_STARTED, false));
                return;
            }
            return;
        }
        C1210e eVar = this.f2636d;
        if (eVar == null) {
            CBLogging.m2905b("BannerPresenter", "Banner View is not attached, re-create banner.");
            ChartboostBannerListener chartboostBannerListener2 = this.f2635c;
            if (chartboostBannerListener2 != null) {
                chartboostBannerListener2.onAdShown(new ChartboostShowEvent(""), new ChartboostShowError(ChartboostShowError.Code.BANNER_VIEW_IS_DETACHED, false));
            }
        } else if (eVar.isBelowLollipop()) {
            CBLogging.m2905b("BannerPresenter", "Banner is not supported for this Android version");
            ChartboostBannerListener chartboostBannerListener3 = this.f2635c;
            if (chartboostBannerListener3 != null) {
                chartboostBannerListener3.onAdShown(new ChartboostShowEvent(""), new ChartboostShowError(ChartboostShowError.Code.NO_CACHED_AD, false));
            }
        } else {
            m2875k();
            if (m2870c(2)) {
                m2880s();
                m2879r();
                m2873g();
            }
        }
    }

    /* renamed from: c */
    public void mo9954c() {
        m2872d((String) null);
    }

    /* renamed from: c */
    private boolean m2870c(int i) {
        C1273b bVar = this.f2638f;
        if (bVar == null) {
            m2864b(i);
            return false;
        } else if (bVar.mo10293b()) {
            return true;
        } else {
            m2863a(i);
            return false;
        }
    }

    /* renamed from: b */
    private void m2864b(int i) {
        ChartboostBannerListener chartboostBannerListener = this.f2635c;
        if (chartboostBannerListener == null) {
            return;
        }
        if (i == 1) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(""), new ChartboostCacheError(ChartboostCacheError.Code.INTERNAL));
        } else if (i == 2) {
            chartboostBannerListener.onAdShown(new ChartboostShowEvent(""), new ChartboostShowError(ChartboostShowError.Code.INTERNAL, false));
        }
    }

    /* renamed from: a */
    public void mo9947a(C1210e eVar, String str, BannerSize bannerSize, ChartboostBannerListener chartboostBannerListener, C1363q qVar) {
        this.f2636d = eVar;
        this.f2633a = str;
        this.f2634b = bannerSize;
        this.f2635c = chartboostBannerListener;
        this.f2639g = qVar;
        this.f2637e = new C1209d();
    }

    /* renamed from: b */
    public void mo9952b() {
        CBLogging.m2903a("BannerPresenter", "Notify timeout finished for location: " + mo9959e());
        m2880s();
        m2874j();
        ChartboostBannerListener chartboostBannerListener = this.f2635c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdShown(new ChartboostShowEvent(""), new ChartboostShowError(ChartboostShowError.Code.INTERNAL, false));
            C1414j b = C1414j.m3867b();
            if (b != null) {
                b.mo10720o();
            }
        }
    }

    /* renamed from: c */
    private void m2869c(ChartboostShowError chartboostShowError) {
        if (chartboostShowError != null) {
            m2866b(chartboostShowError);
        } else {
            C1266e.m3223e(new C1267f("show_finish_success", "", "Banner", this.f2633a));
        }
    }

    /* renamed from: d */
    private void m2872d(String str) {
        if (m2877o()) {
            CBLogging.m2905b("BannerPresenter", "Chartboost SDK is not initialised");
            ChartboostBannerListener chartboostBannerListener = this.f2635c;
            if (chartboostBannerListener != null) {
                chartboostBannerListener.onAdCached(new ChartboostCacheEvent(""), new ChartboostCacheError(ChartboostCacheError.Code.SESSION_NOT_STARTED));
                return;
            }
            return;
        }
        C1210e eVar = this.f2636d;
        if (eVar == null) {
            CBLogging.m2905b("BannerPresenter", "Banner View is not attached, re-create banner.");
            ChartboostBannerListener chartboostBannerListener2 = this.f2635c;
            if (chartboostBannerListener2 != null) {
                chartboostBannerListener2.onAdCached(new ChartboostCacheEvent(""), new ChartboostCacheError(ChartboostCacheError.Code.BANNER_VIEW_IS_DETACHED));
            }
        } else if (eVar.isBelowLollipop()) {
            CBLogging.m2905b("BannerPresenter", "Banner is not supported for this Android version");
            ChartboostBannerListener chartboostBannerListener3 = this.f2635c;
            if (chartboostBannerListener3 != null) {
                chartboostBannerListener3.onAdCached(new ChartboostCacheEvent(""), new ChartboostCacheError(ChartboostCacheError.Code.NO_AD_FOUND));
            }
        } else {
            m2875k();
            if (m2870c(1)) {
                m2867b(str);
            } else {
                CBLogging.m2903a("BannerPresenter", "Banner is currently processing action cache");
            }
        }
    }

    /* renamed from: c */
    private void m2868c(ChartboostCacheError chartboostCacheError) {
        if (chartboostCacheError != null) {
            m2865b(chartboostCacheError);
        } else {
            C1266e.m3223e(new C1267f("cache_finish_success", "", "Banner", this.f2633a));
        }
    }

    /* renamed from: a */
    public void mo9948a(ChartboostBannerListener chartboostBannerListener) {
        this.f2635c = chartboostBannerListener;
    }

    /* renamed from: a */
    public void mo9951a(boolean z) {
        C1363q qVar = this.f2639g;
        if (qVar != null) {
            qVar.mo10581a(z);
        }
    }

    /* renamed from: b */
    private void m2866b(ChartboostShowError chartboostShowError) {
        String a = m2862a(chartboostShowError);
        C1266e.m3223e(new C1267f("show_finish_failure", a, "Banner", this.f2633a));
        CBLogging.m2903a("BannerPresenter", "onBannerShowFail: " + a);
    }

    /* renamed from: a */
    public void mo9949a(String str) {
        m2872d(str);
    }

    /* renamed from: a */
    private void m2863a(int i) {
        ChartboostBannerListener chartboostBannerListener = this.f2635c;
        if (chartboostBannerListener == null) {
            return;
        }
        if (i == 1) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(""), new ChartboostCacheError(ChartboostCacheError.Code.BANNER_DISABLED));
        } else if (i == 2) {
            chartboostBannerListener.onAdShown(new ChartboostShowEvent(""), new ChartboostShowError(ChartboostShowError.Code.BANNER_DISABLED, false));
        }
    }

    /* renamed from: b */
    private void m2865b(ChartboostCacheError chartboostCacheError) {
        String a = m2861a(chartboostCacheError);
        C1266e.m3223e(new C1267f("cache_finish_failure", a, "Banner", this.f2633a));
        CBLogging.m2903a("BannerPresenter", "onBannerCacheFail: " + a);
    }

    /* renamed from: a */
    public void mo9950a(String str, String str2, ChartboostClickError chartboostClickError) {
        CBLogging.m2903a("BannerPresenter", "onBannerClickFail: " + chartboostClickError.code.name());
        m2874j();
        didClickBanner(str, str2, chartboostClickError);
    }

    /* renamed from: a */
    public void mo9946a() {
        CBLogging.m2903a("BannerPresenter", "Notify refresh finished for location: " + mo9959e());
        mo9967q();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.code;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2862a(com.chartboost.sdk.Events.ChartboostShowError r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x000b
            com.chartboost.sdk.Events.ChartboostShowError$Code r1 = r1.code
            if (r1 == 0) goto L_0x000b
            java.lang.String r1 = r1.name()
            goto L_0x000d
        L_0x000b:
            java.lang.String r1 = ""
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Banner.C1207c.m2862a(com.chartboost.sdk.Events.ChartboostShowError):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.code;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2861a(com.chartboost.sdk.Events.ChartboostCacheError r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x000b
            com.chartboost.sdk.Events.ChartboostCacheError$Code r1 = r1.code
            if (r1 == 0) goto L_0x000b
            java.lang.String r1 = r1.name()
            goto L_0x000d
        L_0x000b:
            java.lang.String r1 = ""
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Banner.C1207c.m2861a(com.chartboost.sdk.Events.ChartboostCacheError):java.lang.String");
    }

    /* renamed from: d */
    private void m2871d(ChartboostShowError chartboostShowError) {
        C1414j b = C1414j.m3867b();
        if (b != null && chartboostShowError == null) {
            b.mo10706a(3);
        }
    }
}
