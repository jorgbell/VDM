package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1099h;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.utils.C1113b;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1152l;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.adview.b */
public class C0623b implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    private volatile AppLovinAdClickListener f450A;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f451a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f452b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1062k f453c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinAdServiceImpl f454d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1107r f455e;

    /* renamed from: f */
    private AppLovinCommunicator f456f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AppLovinAdSize f457g;

    /* renamed from: h */
    private String f458h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0981d f459i;

    /* renamed from: j */
    private C0644e f460j;

    /* renamed from: k */
    private C0636c f461k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C0638d f462l;

    /* renamed from: m */
    private Runnable f463m;

    /* renamed from: n */
    private Runnable f464n;

    /* renamed from: o */
    private C1099h.C1101a f465o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public volatile C0934g f466p = null;

    /* renamed from: q */
    private volatile AppLovinAd f467q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C0658l f468r = null;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C0658l f469s = null;

    /* renamed from: t */
    private final AtomicReference<AppLovinAd> f470t = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final AtomicBoolean f471u = new AtomicBoolean();

    /* renamed from: v */
    private volatile boolean f472v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public volatile boolean f473w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile AppLovinAdLoadListener f474x;

    /* renamed from: y */
    private volatile AppLovinAdDisplayListener f475y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public volatile AppLovinAdViewEventListener f476z;

    /* renamed from: com.applovin.impl.adview.b$a */
    private class C0634a implements Runnable {
        private C0634a() {
        }

        public void run() {
            if (C0623b.this.f462l != null) {
                C0623b.this.f462l.setVisibility(8);
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.b$b */
    private class C0635b implements Runnable {
        private C0635b() {
        }

        public void run() {
            if (C0623b.this.f466p == null) {
                return;
            }
            if (C0623b.this.f462l != null) {
                C0623b.this.m561u();
                C1107r c = C0623b.this.f455e;
                c.mo9584b("AppLovinAdView", "Rendering advertisement ad for #" + C0623b.this.f466p.getAdIdNumber() + "...");
                C0623b.m541b((View) C0623b.this.f462l, C0623b.this.f466p.getSize());
                C0623b.this.f462l.mo8127a(C0623b.this.f466p);
                if (C0623b.this.f466p.getSize() != AppLovinAdSize.INTERSTITIAL && !C0623b.this.f473w) {
                    C0623b bVar = C0623b.this;
                    C0981d unused = bVar.f459i = new C0981d(bVar.f466p, C0623b.this.f453c);
                    C0623b.this.f459i.mo9171a();
                    C0623b.this.f462l.setStatsManagerHelper(C0623b.this.f459i);
                    C0623b.this.f466p.setHasShown(true);
                }
                if (C0623b.this.f462l.getStatsManagerHelper() != null) {
                    C0623b.this.f462l.getStatsManagerHelper().mo9172a(C0623b.this.f466p.mo9073y() ? 0 : 1);
                    return;
                }
                return;
            }
            C1107r.m2484i("AppLovinAdView", "Unable to render advertisement for ad #" + C0623b.this.f466p.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
            C1124k.m2610a(C0623b.this.f476z, (AppLovinAd) C0623b.this.f466p, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
        }
    }

    /* renamed from: com.applovin.impl.adview.b$c */
    static class C0636c implements AppLovinAdLoadListener {

        /* renamed from: a */
        private final C0623b f493a;

        C0636c(C0623b bVar, C1062k kVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("No view specified");
            } else if (kVar != null) {
                this.f493a = bVar;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        /* renamed from: a */
        private C0623b m592a() {
            return this.f493a;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            C0623b a = m592a();
            if (a != null) {
                a.mo8095b(appLovinAd);
            } else {
                C1107r.m2484i("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        public void failedToReceiveAd(int i) {
            C0623b a = m592a();
            if (a != null) {
                a.mo8081a(i);
            }
        }
    }

    /* renamed from: a */
    private void m537a(AppLovinAdView appLovinAdView, C1062k kVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize != null) {
            this.f453c = kVar;
            this.f454d = kVar.mo9404t();
            this.f455e = kVar.mo9411z();
            this.f456f = AppLovinCommunicator.getInstance(context);
            this.f457g = appLovinAdSize;
            this.f458h = str;
            this.f451a = context;
            this.f452b = appLovinAdView;
            this.f460j = new C0644e(this, kVar);
            this.f464n = new C0634a();
            this.f463m = new C0635b();
            this.f461k = new C0636c(this, kVar);
            this.f465o = new C1099h.C1101a();
            mo8093a(appLovinAdSize);
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    /* renamed from: a */
    private void m538a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m541b(View view, AppLovinAdSize appLovinAdSize) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            String label = appLovinAdSize.getLabel();
            AppLovinAdSize appLovinAdSize2 = AppLovinAdSize.INTERSTITIAL;
            int i = -1;
            int applyDimension = label.equals(appLovinAdSize2.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            if (!appLovinAdSize.getLabel().equals(appLovinAdSize2.getLabel())) {
                i = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = applyDimension;
            layoutParams.height = i;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: q */
    private void m556q() {
        C1107r rVar = this.f455e;
        if (rVar != null) {
            rVar.mo9584b("AppLovinAdView", "Destroying...");
        }
        C0638d dVar = this.f462l;
        if (dVar != null) {
            ViewParent parent = dVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f462l);
            }
            this.f462l.removeAllViews();
            this.f462l.loadUrl("about:blank");
            this.f462l.onPause();
            this.f462l.destroyDrawingCache();
            this.f462l.destroy();
            this.f462l = null;
            this.f453c.mo9376ak().mo9441b(this.f466p);
        }
        this.f473w = true;
    }

    /* renamed from: r */
    private void m558r() {
        m538a((Runnable) new Runnable() {
            public void run() {
                if (C0623b.this.f468r != null) {
                    C1107r c = C0623b.this.f455e;
                    c.mo9584b("AppLovinAdView", "Detaching expanded ad: " + C0623b.this.f468r.mo8202a());
                    C0623b bVar = C0623b.this;
                    C0658l unused = bVar.f469s = bVar.f468r;
                    C0658l unused2 = C0623b.this.f468r = null;
                    C0623b bVar2 = C0623b.this;
                    bVar2.mo8093a(bVar2.f457g);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m559s() {
        m538a((Runnable) new Runnable() {
            public void run() {
                C0924a aVar;
                if (C0623b.this.f469s != null || C0623b.this.f468r != null) {
                    if (C0623b.this.f469s != null) {
                        aVar = C0623b.this.f469s.mo8202a();
                        C0623b.this.f469s.dismiss();
                        C0658l unused = C0623b.this.f469s = null;
                    } else {
                        aVar = C0623b.this.f468r.mo8202a();
                        C0623b.this.f468r.dismiss();
                        C0658l unused2 = C0623b.this.f468r = null;
                    }
                    C1124k.m2625b(C0623b.this.f476z, (AppLovinAd) aVar, (AppLovinAdView) C0623b.this.f452b);
                }
            }
        });
    }

    /* renamed from: t */
    private void m560t() {
        C0981d dVar = this.f459i;
        if (dVar != null) {
            dVar.mo9175c();
            this.f459i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m561u() {
        C0934g gVar = this.f466p;
        C1152l lVar = new C1152l();
        lVar.mo9643a().mo9646a(gVar).mo9644a(mo8108o());
        if (!C1160r.m2733a(gVar.getSize())) {
            lVar.mo9643a().mo9648a("Fullscreen Ad Properties").mo9651b(gVar);
        }
        lVar.mo9647a(this.f453c);
        lVar.mo9643a();
        C1107r.m2481f("AppLovinAdView", lVar.toString());
    }

    /* renamed from: a */
    public void mo8080a() {
        if (this.f453c == null || this.f461k == null || this.f451a == null || !this.f472v) {
            C1107r.m2482g("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
            return;
        }
        C0638d dVar = this.f462l;
        if (dVar != null) {
            this.f465o.mo9553a("viewport_width", String.valueOf(AppLovinSdkUtils.pxToDp(this.f451a, dVar.getWidth()))).mo9553a("viewport_height", String.valueOf(AppLovinSdkUtils.pxToDp(this.f451a, this.f462l.getHeight())));
        }
        this.f454d.loadNextAd(this.f458h, this.f457g, this.f465o.mo9554a(), this.f461k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8081a(final int i) {
        if (!this.f473w) {
            m538a(this.f464n);
        }
        m538a((Runnable) new Runnable() {
            public void run() {
                try {
                    if (C0623b.this.f474x != null) {
                        C0623b.this.f474x.failedToReceiveAd(i);
                    }
                } catch (Throwable th) {
                    C1107r.m2480c("AppLovinAdView", "Exception while running app load  callback", th);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo8082a(final PointF pointF) {
        m538a((Runnable) new Runnable() {
            public void run() {
                if (C0623b.this.f468r == null && (C0623b.this.f466p instanceof C0924a) && C0623b.this.f462l != null) {
                    C0924a aVar = (C0924a) C0623b.this.f466p;
                    Activity a = C0623b.this.f451a instanceof Activity ? (Activity) C0623b.this.f451a : C1160r.m2703a((View) C0623b.this.f462l, C0623b.this.f453c);
                    if (a != null) {
                        if (C0623b.this.f452b != null) {
                            C0623b.this.f452b.removeView(C0623b.this.f462l);
                        }
                        C0658l unused = C0623b.this.f468r = new C0658l(aVar, C0623b.this.f462l, a, C0623b.this.f453c);
                        C0623b.this.f468r.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                C0623b.this.mo8103j();
                            }
                        });
                        C0623b.this.f468r.show();
                        C1124k.m2609a(C0623b.this.f476z, (AppLovinAd) C0623b.this.f466p, (AppLovinAdView) C0623b.this.f452b);
                        if (C0623b.this.f459i != null) {
                            C0623b.this.f459i.mo9177d();
                            return;
                        }
                        return;
                    }
                    C1107r.m2484i("AppLovinAdView", "Unable to expand ad. No Activity found.");
                    Uri i = aVar.mo7834i();
                    if (i != null) {
                        C0623b.this.f454d.trackAndLaunchClick(aVar, C0623b.this.mo8108o(), C0623b.this, i, pointF);
                        if (C0623b.this.f459i != null) {
                            C0623b.this.f459i.mo9173b();
                        }
                    }
                    C0623b.this.f462l.mo8128a("javascript:al_onFailedExpand();");
                }
            }
        });
    }

    /* renamed from: a */
    public void mo8083a(final WebView webView) {
        m538a((Runnable) new Runnable() {
            public void run() {
                webView.setVisibility(0);
            }
        });
        try {
            if (this.f466p != this.f467q && this.f475y != null) {
                this.f467q = this.f466p;
                C1124k.m2616a(this.f475y, (AppLovinAd) this.f466p);
                this.f453c.mo9376ak().mo9440a((Object) this.f466p);
                this.f462l.mo8128a("javascript:al_onAdViewRendered();");
            }
        } catch (Throwable th) {
            C1107r.m2480c("AppLovinAdView", "Exception while notifying ad display listener", th);
        }
    }

    /* renamed from: a */
    public void mo8084a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            C1107r.m2484i("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null && (appLovinAdSize = C1113b.m2505a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m537a(appLovinAdView, appLovinSdk.coreSdk, appLovinAdSize2, str, context);
                if (C1113b.m2508b(attributeSet)) {
                    mo8080a();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8085a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f476z = appLovinAdViewEventListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8086a(C0934g gVar, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        C1124k.m2615a(this.f450A, (AppLovinAd) gVar);
        if (appLovinAdView != null) {
            this.f454d.trackAndLaunchClick(gVar, appLovinAdView, this, uri, pointF);
        } else {
            this.f455e.mo9588e("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
    }

    /* renamed from: a */
    public void mo8087a(C0981d dVar) {
        C0638d dVar2 = this.f462l;
        if (dVar2 != null) {
            dVar2.setStatsManagerHelper(dVar);
        }
    }

    /* renamed from: a */
    public void mo8088a(AppLovinAd appLovinAd) {
        mo8089a(appLovinAd, (String) null);
    }

    /* renamed from: a */
    public void mo8089a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            C1160r.m2742b(appLovinAd, this.f453c);
            if (this.f472v) {
                C0934g gVar = (C0934g) C1160r.m2706a(appLovinAd, this.f453c);
                if (gVar != null && gVar != this.f466p) {
                    C1107r rVar = this.f455e;
                    rVar.mo9584b("AppLovinAdView", "Rendering ad #" + gVar.getAdIdNumber() + " (" + gVar.getSize() + ")");
                    C1124k.m2627b(this.f475y, (AppLovinAd) this.f466p);
                    this.f453c.mo9376ak().mo9441b(this.f466p);
                    if (gVar.getSize() != AppLovinAdSize.INTERSTITIAL) {
                        m560t();
                    }
                    this.f470t.set((Object) null);
                    this.f467q = null;
                    this.f466p = gVar;
                    if (!this.f473w && C1160r.m2733a(this.f457g)) {
                        this.f453c.mo9404t().trackImpression(gVar);
                    }
                    if (this.f468r != null) {
                        m558r();
                    }
                    m538a(this.f463m);
                } else if (gVar == null) {
                    this.f455e.mo9587d("AppLovinAdView", "Unable to render ad. Ad is null. Internal inconsistency error.");
                } else {
                    C1107r rVar2 = this.f455e;
                    rVar2.mo9587d("AppLovinAdView", "Ad #" + gVar.getAdIdNumber() + " is already showing, ignoring");
                    if (((Boolean) this.f453c.mo9350a(C0965b.f1645bQ)).booleanValue()) {
                        throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
                    }
                }
            } else {
                C1107r.m2482g("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            }
        } else {
            throw new IllegalArgumentException("No ad specified");
        }
    }

    /* renamed from: a */
    public void mo8090a(AppLovinAdClickListener appLovinAdClickListener) {
        this.f450A = appLovinAdClickListener;
    }

    /* renamed from: a */
    public void mo8091a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f475y = appLovinAdDisplayListener;
    }

    /* renamed from: a */
    public void mo8092a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f474x = appLovinAdLoadListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8093a(AppLovinAdSize appLovinAdSize) {
        try {
            C0638d dVar = new C0638d(this.f460j, this.f453c, this.f451a);
            this.f462l = dVar;
            dVar.setBackgroundColor(0);
            this.f462l.setWillNotCacheDrawing(false);
            this.f452b.setBackgroundColor(0);
            this.f452b.addView(this.f462l);
            m541b((View) this.f462l, appLovinAdSize);
            if (!this.f472v) {
                m538a(this.f464n);
            }
            m538a((Runnable) new Runnable() {
                public void run() {
                    C0623b.this.f462l.loadDataWithBaseURL("/", "<html></html>", "text/html", (String) null, "");
                }
            });
            this.f472v = true;
        } catch (Throwable th) {
            C1107r.m2480c("AppLovinAdView", "Failed to initialize AdWebView", th);
            this.f471u.set(true);
        }
    }

    /* renamed from: b */
    public AppLovinAdSize mo8094b() {
        return this.f457g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8095b(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.f473w) {
                mo8088a(appLovinAd);
            } else {
                this.f470t.set(appLovinAd);
                this.f455e.mo9584b("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
            }
            m538a((Runnable) new Runnable() {
                public void run() {
                    if (C0623b.this.f471u.compareAndSet(true, false)) {
                        C0623b bVar = C0623b.this;
                        bVar.mo8093a(bVar.f457g);
                    }
                    try {
                        if (C0623b.this.f474x != null) {
                            C0623b.this.f474x.adReceived(appLovinAd);
                        }
                    } catch (Throwable th) {
                        C1107r.m2484i("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
                    }
                }
            });
            return;
        }
        this.f455e.mo9588e("AppLovinAdView", "No provided when to the view controller");
        mo8081a(-1);
    }

    /* renamed from: c */
    public String mo8096c() {
        return this.f458h;
    }

    /* renamed from: d */
    public void mo8097d() {
        if (this.f472v && !this.f473w) {
            this.f473w = true;
        }
    }

    /* renamed from: e */
    public void mo8098e() {
        if (this.f472v) {
            AppLovinAd andSet = this.f470t.getAndSet((Object) null);
            if (andSet != null) {
                mo8088a(andSet);
            }
            this.f473w = false;
        }
    }

    /* renamed from: f */
    public void mo8099f() {
        if (!(this.f462l == null || this.f468r == null)) {
            mo8103j();
        }
        m556q();
    }

    /* renamed from: g */
    public AppLovinAdViewEventListener mo8100g() {
        return this.f476z;
    }

    public String getCommunicatorId() {
        return C0623b.class.getSimpleName();
    }

    /* renamed from: h */
    public void mo8101h() {
        if (C1113b.m2507a((View) this.f462l)) {
            this.f453c.mo9341R().mo9199a(C0986g.f1966m);
        }
    }

    /* renamed from: i */
    public void mo8102i() {
        if (this.f472v) {
            C1124k.m2627b(this.f475y, (AppLovinAd) this.f466p);
            this.f453c.mo9376ak().mo9441b(this.f466p);
            if (this.f462l == null || this.f468r == null) {
                this.f455e.mo9584b("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
                return;
            }
            this.f455e.mo9584b("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
            m558r();
        }
    }

    /* renamed from: j */
    public void mo8103j() {
        m538a((Runnable) new Runnable() {
            public void run() {
                C0623b.this.m559s();
                if (C0623b.this.f452b != null && C0623b.this.f462l != null && C0623b.this.f462l.getParent() == null) {
                    C0623b.this.f452b.addView(C0623b.this.f462l);
                    C0623b.m541b((View) C0623b.this.f462l, C0623b.this.f466p.getSize());
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo8104k() {
        if (this.f468r == null && this.f469s == null) {
            C1107r rVar = this.f455e;
            rVar.mo9584b("AppLovinAdView", "Ad: " + this.f466p + " closed.");
            m538a(this.f464n);
            C1124k.m2627b(this.f475y, (AppLovinAd) this.f466p);
            this.f453c.mo9376ak().mo9441b(this.f466p);
            this.f466p = null;
            return;
        }
        mo8103j();
    }

    /* renamed from: l */
    public void mo8105l() {
        if ((this.f451a instanceof C0657k) && this.f466p != null) {
            if (this.f466p.mo8999H() == C0934g.C0936a.DISMISS) {
                ((C0657k) this.f451a).dismiss();
            }
        }
    }

    /* renamed from: m */
    public C0934g mo8106m() {
        return this.f466p;
    }

    /* renamed from: n */
    public C1062k mo8107n() {
        return this.f453c;
    }

    /* renamed from: o */
    public AppLovinAdView mo8108o() {
        return (AppLovinAdView) this.f452b;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            m538a((Runnable) new Runnable() {
                public void run() {
                    C0623b.this.mo8109p().loadUrl("chrome://crash");
                }
            });
        }
    }

    /* renamed from: p */
    public C0638d mo8109p() {
        return this.f462l;
    }
}
