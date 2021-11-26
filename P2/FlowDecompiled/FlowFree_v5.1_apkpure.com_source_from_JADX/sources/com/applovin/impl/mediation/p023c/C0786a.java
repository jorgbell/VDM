package com.applovin.impl.mediation.p023c;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

/* renamed from: com.applovin.impl.mediation.c.a */
public class C0786a implements MaxAdListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    private final C1062k f904a;

    /* renamed from: b */
    private final MaxAdListener f905b;

    public C0786a(MaxAdListener maxAdListener, C1062k kVar) {
        this.f904a = kVar;
        this.f905b = maxAdListener;
    }

    public void onAdClicked(MaxAd maxAd) {
        C1124k.m2632d(this.f905b, maxAd);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        C1124k.m2636h(this.f905b, maxAd);
    }

    public void onAdDisplayFailed(MaxAd maxAd, int i) {
        C1124k.m2612a(this.f905b, maxAd, i);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        C1124k.m2626b(this.f905b, maxAd);
    }

    public void onAdExpanded(MaxAd maxAd) {
        C1124k.m2635g(this.f905b, maxAd);
    }

    public void onAdHidden(MaxAd maxAd) {
        C1124k.m2630c(this.f905b, maxAd);
    }

    public void onAdLoadFailed(String str, int i) {
        C1124k.m2614a(this.f905b, str, i);
    }

    public void onAdLoaded(MaxAd maxAd) {
        C1124k.m2611a(this.f905b, maxAd);
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        C1124k.m2634f(this.f905b, maxAd);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        C1124k.m2633e(this.f905b, maxAd);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        C1124k.m2613a(this.f905b, maxAd, maxReward);
    }
}
