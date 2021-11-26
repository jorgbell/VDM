package com.applovin.impl.mediation.debugger.p028ui.testmode;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.mediation.debugger.p028ui.C0808a;
import com.applovin.impl.mediation.debugger.p028ui.testmode.AdControlButton;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1199R;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.a */
public class C0859a extends C0808a implements AdControlButton.C0857a, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    private C0801b f1174a;

    /* renamed from: b */
    private C1062k f1175b;

    /* renamed from: c */
    private MaxAdView f1176c;

    /* renamed from: d */
    private MaxAdView f1177d;

    /* renamed from: e */
    private MaxInterstitialAd f1178e;

    /* renamed from: f */
    private MaxRewardedInterstitialAd f1179f;

    /* renamed from: g */
    private MaxRewardedAd f1180g;

    /* renamed from: h */
    private String f1181h;

    /* renamed from: i */
    private AdControlButton f1182i;

    /* renamed from: j */
    private AdControlButton f1183j;

    /* renamed from: k */
    private AdControlButton f1184k;

    /* renamed from: l */
    private AdControlButton f1185l;

    /* renamed from: m */
    private AdControlButton f1186m;

    /* renamed from: a */
    private AdControlButton m1372a(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.f1182i;
        }
        if (str.equals("test_mode_mrec")) {
            return this.f1183j;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.f1184k;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.f1185l;
        }
        if (str.equals(this.f1181h)) {
            return this.f1186m;
        }
        throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
    }

    /* renamed from: a */
    private void m1373a() {
        String str;
        MaxAdFormat maxAdFormat;
        boolean isTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(C1199R.C1201id.banner_ad_view_container);
        if (isTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(C1199R.C1201id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.f1174a.mo8602o().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.f1175b.mo9347X(), this);
            this.f1176c = maxAdView;
            maxAdView.setListener(this);
            frameLayout.addView(this.f1176c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(C1199R.C1201id.banner_control_button);
            this.f1182i = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1182i.setFormat(maxAdFormat);
            return;
        }
        findViewById(C1199R.C1201id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    /* renamed from: a */
    private void m1374a(MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        this.f1175b.mo9332H().mo8726a(this.f1174a.mo8594g());
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.f1176c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.f1177d;
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f1178e.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f1179f.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f1180g.loadAd();
            return;
        } else {
            return;
        }
        maxAdView.loadAd();
    }

    /* renamed from: b */
    private void m1375b() {
        FrameLayout frameLayout = (FrameLayout) findViewById(C1199R.C1201id.mrec_ad_view_container);
        List<MaxAdFormat> o = this.f1174a.mo8602o();
        MaxAdFormat maxAdFormat = MaxAdFormat.MREC;
        if (o.contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", maxAdFormat, this.f1175b.mo9347X(), this);
            this.f1177d = maxAdView;
            maxAdView.setListener(this);
            frameLayout.addView(this.f1177d, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(C1199R.C1201id.mrec_control_button);
            this.f1183j = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1183j.setFormat(maxAdFormat);
            return;
        }
        findViewById(C1199R.C1201id.mrec_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    /* renamed from: b */
    private void m1376b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f1178e.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f1179f.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f1180g.showAd();
        }
    }

    /* renamed from: c */
    private void m1377c() {
        List<MaxAdFormat> o = this.f1174a.mo8602o();
        MaxAdFormat maxAdFormat = MaxAdFormat.INTERSTITIAL;
        if (o.contains(maxAdFormat)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.f1175b.mo9347X(), this);
            this.f1178e = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(C1199R.C1201id.interstitial_control_button);
            this.f1184k = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1184k.setFormat(maxAdFormat);
            return;
        }
        findViewById(C1199R.C1201id.interstitial_control_view).setVisibility(8);
    }

    /* renamed from: d */
    private void m1378d() {
        List<MaxAdFormat> o = this.f1174a.mo8602o();
        MaxAdFormat maxAdFormat = MaxAdFormat.REWARDED;
        if (o.contains(maxAdFormat)) {
            String str = "test_mode_rewarded_" + this.f1174a.mo8594g();
            this.f1181h = str;
            MaxRewardedAd instance = MaxRewardedAd.getInstance(str, this.f1175b.mo9347X(), this);
            this.f1180g = instance;
            instance.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(C1199R.C1201id.rewarded_control_button);
            this.f1186m = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1186m.setFormat(maxAdFormat);
            return;
        }
        findViewById(C1199R.C1201id.rewarded_control_view).setVisibility(8);
    }

    public void initialize(C0801b bVar) {
        this.f1174a = bVar;
        this.f1175b = bVar.mo8606s();
    }

    public void onAdClicked(MaxAd maxAd) {
        C1160r.m2721a("onAdClicked", maxAd, (Context) this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        C1160r.m2721a("onAdCollapsed", maxAd, (Context) this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, int i) {
        AdControlButton a = m1372a(maxAd.getAdUnitId());
        a.setControlState(AdControlButton.C0858b.LOAD);
        C1160r.m2723a("", "Failed to display " + a.getFormat().getDisplayName() + " with error code: " + i, (Context) this);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        C1160r.m2721a("onAdDisplayed", maxAd, (Context) this);
    }

    public void onAdExpanded(MaxAd maxAd) {
        C1160r.m2721a("onAdExpanded", maxAd, (Context) this);
    }

    public void onAdHidden(MaxAd maxAd) {
        C1160r.m2721a("onAdHidden", maxAd, (Context) this);
    }

    public void onAdLoadFailed(String str, int i) {
        AdControlButton a = m1372a(str);
        a.setControlState(AdControlButton.C0858b.LOAD);
        C1160r.m2723a("", "Failed to load " + a.getFormat().getLabel() + " with error code: " + i, (Context) this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        m1372a(maxAd.getAdUnitId()).setControlState(maxAd.getFormat().isAdViewAd() ? AdControlButton.C0858b.LOAD : AdControlButton.C0858b.SHOW);
    }

    public void onClick(AdControlButton adControlButton) {
        AdControlButton.C0858b bVar = AdControlButton.C0858b.LOAD;
        if (bVar == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.C0858b.LOADING);
            m1374a(adControlButton.getFormat());
        } else if (AdControlButton.C0858b.SHOW == adControlButton.getControlState()) {
            adControlButton.setControlState(bVar);
            m1376b(adControlButton.getFormat());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1199R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.f1174a.mo8595h() + " Test Ads");
        m1373a();
        m1375b();
        m1377c();
        m1378d();
        findViewById(C1199R.C1201id.rewarded_interstitial_control_view).setVisibility(8);
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            C1107r.m2480c("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f1175b.mo9332H().mo8726a((String) null);
        MaxAdView maxAdView = this.f1176c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.f1177d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f1178e;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f1180g;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        C1160r.m2721a("onRewardedVideoCompleted", maxAd, (Context) this);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        C1160r.m2721a("onRewardedVideoStarted", maxAd, (Context) this);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        C1160r.m2721a("onUserRewarded", maxAd, (Context) this);
    }
}
