package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.C0761a;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MaxRewardedAd implements MaxFullscreenAdImpl.C0754a {

    /* renamed from: a */
    private static final Map<String, MaxRewardedAd> f2561a = new HashMap();

    /* renamed from: b */
    private static final Object f2562b = new Object();

    /* renamed from: c */
    private static WeakReference<Activity> f2563c = new WeakReference<>((Object) null);

    /* renamed from: d */
    private final MaxFullscreenAdImpl f2564d;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk) {
        this.f2564d = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.coreSdk);
    }

    public static MaxRewardedAd getInstance(String str, Activity activity) {
        return getInstance(str, AppLovinSdk.getInstance(activity), activity);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Activity activity) {
        C0761a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            updateActivity(activity);
            synchronized (f2562b) {
                Map<String, MaxRewardedAd> map = f2561a;
                MaxRewardedAd maxRewardedAd = map.get(str);
                if (maxRewardedAd != null) {
                    return maxRewardedAd;
                }
                MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk);
                map.put(str, maxRewardedAd2);
                return maxRewardedAd2;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void updateActivity(Activity activity) {
        C0761a.logApiCall("MaxRewardedAd", "updateActivity(activity=" + activity + ")");
        if (activity != null) {
            f2563c = new WeakReference<>(activity);
        }
    }

    public void destroy() {
        this.f2564d.logApiCall("destroy()");
        synchronized (f2562b) {
            f2561a.remove(this.f2564d.getAdUnitId());
        }
        this.f2564d.destroy();
    }

    public Activity getActivity() {
        this.f2564d.logApiCall("getActivity()");
        return (Activity) f2563c.get();
    }

    public String getAdUnitId() {
        return this.f2564d.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f2564d.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2564d;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.f2564d.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f2564d.logApiCall("loadAd()");
        this.f2564d.loadAd(getActivity());
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2564d;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f2564d.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2564d;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f2564d.setListener(maxRewardedAdListener);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2564d;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ")");
        this.f2564d.showAd(str, getActivity());
    }

    public String toString() {
        return "" + this.f2564d;
    }
}
