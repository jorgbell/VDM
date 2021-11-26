package com.chartboost.sdk;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Banner.BannerSize;
import com.chartboost.sdk.Banner.C1207c;
import com.chartboost.sdk.Banner.C1210e;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C1293c;
import com.chartboost.sdk.impl.C1363q;

public class ChartboostBanner extends RelativeLayout implements C1210e, C1293c {

    /* renamed from: b */
    private static final String f2653b = ChartboostBanner.class.getSimpleName();

    /* renamed from: a */
    private C1207c f2654a;

    public ChartboostBanner(Context context) {
        super(context);
        C1207c cVar = new C1207c();
        this.f2654a = cVar;
        cVar.mo9947a(this, "", BannerSize.STANDARD, (ChartboostBannerListener) null, new C1363q());
    }

    public C1414j.C1416b attachBannerToSDKCommand(C1414j.C1416b bVar) {
        bVar.f3529e = this;
        return bVar;
    }

    public void cache() {
        this.f2654a.mo9954c();
    }

    public void detachBanner() {
        this.f2654a.mo9955d();
    }

    public void didCacheBanner(String str, String str2, ChartboostCacheError chartboostCacheError) {
        this.f2654a.didCacheBanner(str, str2, chartboostCacheError);
    }

    public void didClickBanner(String str, String str2, ChartboostClickError chartboostClickError) {
        this.f2654a.didClickBanner(str, str2, chartboostClickError);
    }

    public void didShowBanner(String str, String str2, ChartboostShowError chartboostShowError) {
        this.f2654a.didShowBanner(str, str2, chartboostShowError);
    }

    public int getBannerHeight() {
        return BannerSize.getHeight(this.f2654a.f2634b);
    }

    public int getBannerWidth() {
        return BannerSize.getWidth(this.f2654a.f2634b);
    }

    public DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public String getLocation() {
        return this.f2654a.mo9959e();
    }

    public C1414j.C1416b getSdkCommand() {
        C1414j b = C1414j.m3867b();
        if (b == null) {
            return null;
        }
        b.getClass();
        return new C1414j.C1416b(6);
    }

    public ViewGroup.LayoutParams getViewLayoutParams() {
        return getLayoutParams();
    }

    public boolean isBelowLollipop() {
        return Build.VERSION.SDK_INT < 21;
    }

    public Boolean isCached() {
        return this.f2654a.mo9960f();
    }

    public void onBannerCacheFail(String str, String str2, ChartboostCacheError chartboostCacheError) {
        this.f2654a.onBannerCacheFail(str, str2, chartboostCacheError);
    }

    public void onBannerClickFail(String str, String str2, ChartboostClickError chartboostClickError) {
        this.f2654a.mo9950a(str, str2, chartboostClickError);
    }

    public void onBannerShowFail(String str, String str2, ChartboostShowError chartboostShowError) {
        this.f2654a.onBannerShowFail(str, str2, chartboostShowError);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f2654a.mo9963m();
            this.f2654a.mo9964n();
            return;
        }
        this.f2654a.mo9961h();
        this.f2654a.mo9962i();
    }

    public void setAutomaticallyRefreshesContent(boolean z) {
        this.f2654a.mo9951a(z);
    }

    public void setListener(ChartboostBannerListener chartboostBannerListener) {
        this.f2654a.mo9948a(chartboostBannerListener);
    }

    public String setLocation(String str) {
        return this.f2654a.mo9953c(str);
    }

    public void setViewLayoutParams(ViewGroup.LayoutParams layoutParams) {
        setLayoutParams(layoutParams);
    }

    public void show() {
        this.f2654a.mo9967q();
    }

    public void cache(String str) {
        this.f2654a.mo9949a(str);
    }

    public ChartboostBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        String str;
        BannerSize bannerSize;
        C1207c cVar = new C1207c();
        this.f2654a = cVar;
        C1207c.C1208a a = cVar.mo9945a(context.getTheme(), attributeSet);
        if (a == null || (str = a.f2640a) == null || (bannerSize = a.f2641b) == null) {
            CBLogging.m2905b(f2653b, "Error creating ChartboostBanner, make sure the attributes declared in the XML are correct");
            return;
        }
        this.f2654a.mo9947a(this, str, bannerSize, (ChartboostBannerListener) null, new C1363q());
    }

    public ChartboostBanner(Context context, String str, BannerSize bannerSize, ChartboostBannerListener chartboostBannerListener) {
        super(context);
        C1207c cVar = new C1207c();
        this.f2654a = cVar;
        cVar.mo9947a(this, str, bannerSize, chartboostBannerListener, new C1363q());
    }

    public ChartboostBanner(Context context, C1210e eVar, String str, BannerSize bannerSize, ChartboostBannerListener chartboostBannerListener) {
        super(context);
        C1207c cVar = new C1207c();
        this.f2654a = cVar;
        cVar.mo9947a(eVar, str, bannerSize, chartboostBannerListener, new C1363q());
    }
}
