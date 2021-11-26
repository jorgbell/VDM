package com.chartboost.sdk.impl;

import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Model.CBError;

/* renamed from: com.chartboost.sdk.impl.d */
public class C1296d extends C1286a {

    /* renamed from: h */
    private C1293c f3059h;

    private C1296d(C1293c cVar, C1290b bVar) {
        super(3, bVar.mo10393a(), bVar.mo10394b(), bVar.mo10396d(), bVar.mo10395c(), bVar.mo10398f(), bVar.mo10397e());
        this.f3059h = cVar;
    }

    /* renamed from: a */
    public static C1296d m3390a(C1293c cVar) {
        return new C1296d(cVar, new C1290b());
    }

    /* renamed from: a */
    public void mo10366a(String str, CBError.CBImpressionError cBImpressionError, boolean z, String str2) {
    }

    /* renamed from: b */
    public void mo10371b(String str, String str2) {
        this.f3059h.didClickBanner(str, str2, (ChartboostClickError) null);
    }

    /* renamed from: e */
    public void mo10375e(String str, String str2) {
        this.f3059h.didShowBanner(str, str2, (ChartboostShowError) null);
    }

    /* renamed from: a */
    public void mo10367a(String str, String str2) {
        this.f3059h.didCacheBanner(str, str2, (ChartboostCacheError) null);
    }

    /* renamed from: a */
    public void mo10368a(String str, String str2, ChartboostCacheError chartboostCacheError) {
        this.f3059h.onBannerCacheFail(str, str2, chartboostCacheError);
    }

    /* renamed from: a */
    public void mo10369a(String str, String str2, ChartboostShowError chartboostShowError) {
        this.f3059h.onBannerShowFail(str, str2, chartboostShowError);
    }
}
