package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubAd;

public class AdViewControllerFactory {
    protected static AdViewControllerFactory instance = new AdViewControllerFactory();

    @Deprecated
    public static void setInstance(AdViewControllerFactory adViewControllerFactory) {
        instance = adViewControllerFactory;
    }

    public static AdViewController create(Context context, MoPubAd moPubAd) {
        return instance.internalCreate(context, moPubAd);
    }

    /* access modifiers changed from: protected */
    public AdViewController internalCreate(Context context, MoPubAd moPubAd) {
        return new AdViewController(context, moPubAd);
    }
}
