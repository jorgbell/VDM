package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.adview.C0703p;
import com.applovin.impl.sdk.C1107r;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class AppLovinInterstitialAd {

    /* renamed from: a */
    private static final Object f129a = new Object();

    /* renamed from: b */
    private static C0703p f130b;

    /* renamed from: c */
    private static WeakReference<Context> f131c = new WeakReference<>((Object) null);

    /* renamed from: a */
    private static C0703p m194a(AppLovinSdk appLovinSdk, Context context) {
        synchronized (f129a) {
            if (f130b != null) {
                if (f131c.get() == context) {
                    C1107r.m2484i("AppLovinInterstitialAd", "An interstitial is already showing");
                }
            }
            f130b = new C0703p(appLovinSdk, context);
            f131c = new WeakReference<>(context);
        }
        return f130b;
    }

    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            return m194a(appLovinSdk, context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    @Deprecated
    public static boolean isAdReadyToDisplay(Context context) {
        return AppLovinSdk.getInstance(context).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public static void show(Context context) {
        if (context != null) {
            m194a(AppLovinSdk.getInstance(context), context).show();
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    public String toString() {
        return "AppLovinInterstitialAd{}";
    }
}
