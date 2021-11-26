package com.applovin.impl.mediation.debugger.p028ui.p029a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0796a;
import com.applovin.impl.mediation.debugger.p024a.p025a.C0797b;
import com.applovin.impl.mediation.debugger.p028ui.C0808a;
import com.applovin.impl.mediation.debugger.p028ui.p029a.C0816b;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0844a;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0846c;
import com.applovin.impl.mediation.debugger.p028ui.p033d.C0850d;
import com.applovin.impl.mediation.debugger.p028ui.testmode.AdControlButton;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.sdk.C1199R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.a */
public class C0811a extends C0808a implements AdControlButton.C0857a, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    private C1062k f994a;

    /* renamed from: b */
    private C0796a f995b;

    /* renamed from: c */
    private C0816b f996c;

    /* renamed from: d */
    private C0797b f997d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MaxAdView f998e;

    /* renamed from: f */
    private MaxInterstitialAd f999f;

    /* renamed from: g */
    private MaxRewardedInterstitialAd f1000g;

    /* renamed from: h */
    private MaxRewardedAd f1001h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0823d f1002i;

    /* renamed from: j */
    private ListView f1003j;

    /* renamed from: k */
    private View f1004k;

    /* renamed from: l */
    private AdControlButton f1005l;

    /* renamed from: m */
    private TextView f1006m;

    /* renamed from: a */
    private void m1208a() {
        String a = this.f995b.mo8565a();
        if (this.f995b.mo8569d().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(a, this.f995b.mo8569d(), this.f994a.mo9347X(), this);
            this.f998e = maxAdView;
            maxAdView.setListener(this);
        } else if (MaxAdFormat.INTERSTITIAL == this.f995b.mo8569d()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(a, this.f994a.mo9347X(), this);
            this.f999f = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f995b.mo8569d()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(a, this.f994a.mo9347X(), this);
            this.f1000g = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED == this.f995b.mo8569d()) {
            MaxRewardedAd instance = MaxRewardedAd.getInstance(a, this.f994a.mo9347X(), this);
            this.f1001h = instance;
            instance.setListener(this);
        }
    }

    /* renamed from: a */
    private void m1209a(DialogInterface.OnShowListener onShowListener) {
        if (this.f1002i == null) {
            C0823d dVar = new C0823d(this.f998e, this.f995b.mo8569d(), this);
            this.f1002i = dVar;
            dVar.setOnShowListener(onShowListener);
            this.f1002i.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    C0811a.this.f998e.stopAutoRefresh();
                    C0823d unused = C0811a.this.f1002i = null;
                }
            });
            this.f1002i.show();
        }
    }

    /* renamed from: a */
    private void m1211a(MaxAdFormat maxAdFormat) {
        if (this.f997d != null) {
            this.f994a.mo9332H().mo8726a(this.f997d.mo8573b());
            this.f994a.mo9332H().mo8728a(true);
        }
        if (maxAdFormat.isAdViewAd()) {
            this.f998e.loadAd();
        } else if (MaxAdFormat.INTERSTITIAL == this.f995b.mo8569d()) {
            this.f999f.loadAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f995b.mo8569d()) {
            this.f1000g.loadAd();
        } else if (MaxAdFormat.REWARDED == this.f995b.mo8569d()) {
            this.f1001h.loadAd();
        }
    }

    /* renamed from: b */
    private void m1212b(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            m1209a((DialogInterface.OnShowListener) new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    C0811a.this.f998e.startAutoRefresh();
                }
            });
        } else if (MaxAdFormat.INTERSTITIAL == this.f995b.mo8569d()) {
            this.f999f.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f995b.mo8569d()) {
            this.f1000g.showAd();
        } else if (MaxAdFormat.REWARDED == this.f995b.mo8569d()) {
            this.f1001h.showAd();
        }
    }

    public void initialize(final C0796a aVar, C0797b bVar, final C1062k kVar) {
        this.f994a = kVar;
        this.f995b = aVar;
        this.f997d = bVar;
        C0816b bVar2 = new C0816b(aVar, bVar, this);
        this.f996c = bVar2;
        bVar2.mo8704a((C0850d.C0851a) new C0850d.C0851a() {
            /* renamed from: a */
            public void mo8627a(C0844a aVar, final C0846c cVar) {
                if (cVar instanceof C0816b.C0817a) {
                    C0811a.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, kVar.mo9370ae(), new C0808a.C0810a<MaxDebuggerAdUnitDetailActivity>() {
                        /* renamed from: a */
                        public void mo8623a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                            C0797b a = ((C0816b.C0817a) cVar).mo8636a();
                            C08121 r1 = C08121.this;
                            maxDebuggerAdUnitDetailActivity.initialize(aVar, a, kVar);
                        }
                    });
                }
            }
        });
        m1208a();
    }

    public void onAdClicked(MaxAd maxAd) {
        C1160r.m2721a("onAdClicked", maxAd, (Context) this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        C1160r.m2721a("onAdCollapsed", maxAd, (Context) this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, int i) {
        this.f1005l.setControlState(AdControlButton.C0858b.LOAD);
        this.f1006m.setText("");
        C1160r.m2723a("", "Failed to display with error code: " + i, (Context) this);
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
        this.f1005l.setControlState(AdControlButton.C0858b.LOAD);
        this.f1006m.setText("");
        if (204 == i) {
            C1160r.m2723a("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", (Context) this);
            return;
        }
        C1160r.m2723a("", "Failed to load with error code: " + i, (Context) this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        TextView textView = this.f1006m;
        textView.setText(maxAd.getNetworkName() + " ad loaded");
        this.f1005l.setControlState(AdControlButton.C0858b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            m1209a((DialogInterface.OnShowListener) null);
        }
    }

    public void onClick(AdControlButton adControlButton) {
        if (this.f994a.mo9332H().mo8729a()) {
            C1160r.m2723a("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", (Context) this);
            return;
        }
        AdControlButton.C0858b bVar = AdControlButton.C0858b.LOAD;
        if (bVar == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.C0858b.LOADING);
            m1211a(this.f995b.mo8569d());
        } else if (AdControlButton.C0858b.SHOW == adControlButton.getControlState()) {
            if (!this.f995b.mo8569d().isAdViewAd()) {
                adControlButton.setControlState(bVar);
            }
            m1212b(this.f995b.mo8569d());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1199R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.f996c.mo8632a());
        this.f1003j = (ListView) findViewById(C1199R.C1201id.listView);
        this.f1004k = findViewById(C1199R.C1201id.ad_presenter_view);
        this.f1005l = (AdControlButton) findViewById(C1199R.C1201id.ad_control_button);
        this.f1006m = (TextView) findViewById(C1199R.C1201id.status_textview);
        this.f1003j.setAdapter(this.f996c);
        this.f1006m.setText(this.f994a.mo9332H().mo8729a() ? "Not Supported while Test Mode is enabled" : "Tap to load an ad");
        this.f1006m.setTypeface(Typeface.DEFAULT_BOLD);
        this.f1005l.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer((float) 10, 0.0f, (float) -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.f1004k.setBackground(layerDrawable);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f997d != null) {
            this.f994a.mo9332H().mo8726a((String) null);
            this.f994a.mo9332H().mo8728a(false);
        }
        MaxAdView maxAdView = this.f998e;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f999f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f1001h;
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
