package com.chartboost.sdk.Banner;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;

/* renamed from: com.chartboost.sdk.Banner.d */
class C1209d {
    C1209d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9968a(C1210e eVar, BannerSize bannerSize) {
        m2900a(eVar, BannerSize.getWidth(bannerSize), BannerSize.getHeight(bannerSize));
    }

    /* renamed from: a */
    private void m2900a(C1210e eVar, int i, int i2) {
        DisplayMetrics displayMetrics = eVar.getDisplayMetrics();
        ViewGroup.LayoutParams viewLayoutParams = eVar.getViewLayoutParams();
        viewLayoutParams.width = (int) m2899a(i, displayMetrics);
        viewLayoutParams.height = (int) m2899a(i2, displayMetrics);
        eVar.setViewLayoutParams(viewLayoutParams);
    }

    /* renamed from: a */
    private float m2899a(int i, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, (float) i, displayMetrics);
    }
}
