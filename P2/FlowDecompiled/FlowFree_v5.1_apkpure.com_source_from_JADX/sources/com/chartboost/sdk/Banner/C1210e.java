package com.chartboost.sdk.Banner;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.chartboost.sdk.C1414j;

/* renamed from: com.chartboost.sdk.Banner.e */
public interface C1210e {
    C1414j.C1416b attachBannerToSDKCommand(C1414j.C1416b bVar);

    DisplayMetrics getDisplayMetrics();

    C1414j.C1416b getSdkCommand();

    ViewGroup.LayoutParams getViewLayoutParams();

    boolean isBelowLollipop();

    void setViewLayoutParams(ViewGroup.LayoutParams layoutParams);
}
