package com.applovin.impl.adview.activity.p020b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0623b;
import com.applovin.impl.adview.C0638d;
import com.applovin.impl.adview.C0666m;
import com.applovin.impl.adview.C0667n;
import com.applovin.impl.adview.activity.C0577b;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1044f;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p036b.C0951b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1035u;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1112a;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1157p;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.impl.sdk.utils.C1163s;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.a */
public abstract class C0578a implements C0951b.C0961a {

    /* renamed from: a */
    protected final C0934g f324a;

    /* renamed from: b */
    protected final C1062k f325b;

    /* renamed from: c */
    protected final C1107r f326c;

    /* renamed from: d */
    protected final AppLovinFullscreenActivity f327d;

    /* renamed from: e */
    protected final C0981d f328e;

    /* renamed from: f */
    protected final AppLovinAdView f329f;

    /* renamed from: g */
    protected final C0666m f330g;

    /* renamed from: h */
    protected final long f331h = SystemClock.elapsedRealtime();

    /* renamed from: i */
    protected long f332i = -1;

    /* renamed from: j */
    protected int f333j = C1044f.f2116a;

    /* renamed from: k */
    protected boolean f334k;

    /* renamed from: l */
    protected final AppLovinAdClickListener f335l;

    /* renamed from: m */
    protected final AppLovinAdDisplayListener f336m;

    /* renamed from: n */
    protected final AppLovinAdVideoPlaybackListener f337n;

    /* renamed from: o */
    protected final C0951b f338o;

    /* renamed from: p */
    protected C1157p f339p;

    /* renamed from: q */
    protected C1157p f340q;

    /* renamed from: r */
    private final Handler f341r = new Handler(Looper.getMainLooper());

    /* renamed from: s */
    private final C1112a f342s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final AppLovinBroadcastManager.Receiver f343t;

    /* renamed from: u */
    private final C1044f.C1046a f344u;

    /* renamed from: v */
    private final AtomicBoolean f345v = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final AtomicBoolean f346w = new AtomicBoolean();

    /* renamed from: x */
    private long f347x;

    /* renamed from: com.applovin.impl.adview.activity.b.a$a */
    private class C0590a implements View.OnClickListener, AppLovinAdClickListener {
        private C0590a() {
        }

        public void adClicked(AppLovinAd appLovinAd) {
            C0578a.this.f326c.mo9584b("InterActivityV2", "Clicking through graphic");
            C1124k.m2615a(C0578a.this.f335l, appLovinAd);
            C0578a.this.f328e.mo9173b();
        }

        public void onClick(View view) {
            C0578a aVar = C0578a.this;
            if (view == aVar.f330g) {
                if (aVar.f324a.mo9011T()) {
                    C0578a.this.mo7979b("javascript:al_onCloseButtonTapped();");
                }
                C0578a.this.mo7985f();
                return;
            }
            C1107r rVar = aVar.f326c;
            rVar.mo9588e("InterActivityV2", "Unhandled click on widget: " + view);
        }
    }

    C0578a(final C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, final C1062k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f324a = gVar;
        this.f325b = kVar;
        this.f326c = kVar.mo9411z();
        this.f327d = appLovinFullscreenActivity;
        this.f335l = appLovinAdClickListener;
        this.f336m = appLovinAdDisplayListener;
        this.f337n = appLovinAdVideoPlaybackListener;
        C0951b bVar = new C0951b(appLovinFullscreenActivity, kVar);
        this.f338o = bVar;
        bVar.mo9096a((C0951b.C0961a) this);
        C0981d dVar = new C0981d(gVar, kVar);
        this.f328e = dVar;
        C0590a aVar = new C0590a();
        C0667n nVar = new C0667n(kVar.mo9347X(), AppLovinAdSize.INTERSTITIAL, appLovinFullscreenActivity);
        this.f329f = nVar;
        nVar.setAdClickListener(aVar);
        nVar.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
                C0578a.this.f326c.mo9584b("InterActivityV2", "Web content rendered");
            }

            public void adHidden(AppLovinAd appLovinAd) {
                C0578a.this.f326c.mo9584b("InterActivityV2", "Closing from WebView");
                C0578a.this.mo7985f();
            }
        });
        C0623b adViewController = nVar.getAdViewController();
        adViewController.mo8087a(dVar);
        adViewController.mo8109p().setIsShownOutOfContext(gVar.mo9043ak());
        kVar.mo9404t().trackImpression(gVar);
        if (gVar.mo9068t() >= 0) {
            C0666m mVar = new C0666m(gVar.mo9069u(), appLovinFullscreenActivity);
            this.f330g = mVar;
            mVar.setVisibility(8);
            mVar.setOnClickListener(aVar);
        } else {
            this.f330g = null;
        }
        if (((Boolean) kVar.mo9350a(C0965b.f1721co)).booleanValue()) {
            C05802 r6 = new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    kVar.mo9404t().trackAppKilled(gVar);
                    kVar.mo9375aj().unregisterReceiver(this);
                }
            };
            this.f343t = r6;
            kVar.mo9375aj().registerReceiver(r6, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        } else {
            this.f343t = null;
        }
        if (gVar.mo9042aj()) {
            C05813 r5 = new C1044f.C1046a() {
                public void onRingerModeChanged(int i) {
                    String str;
                    C0578a aVar = C0578a.this;
                    if (aVar.f333j != C1044f.f2116a) {
                        aVar.f334k = true;
                    }
                    C0638d p = aVar.f329f.getAdViewController().mo8109p();
                    if (!C1044f.m2057a(i) || C1044f.m2057a(C0578a.this.f333j)) {
                        if (i == 2) {
                            str = "javascript:al_muteSwitchOff();";
                        }
                        C0578a.this.f333j = i;
                    }
                    str = "javascript:al_muteSwitchOn();";
                    p.mo8128a(str);
                    C0578a.this.f333j = i;
                }
            };
            this.f344u = r5;
            kVar.mo9374ai().mo9298a((C1044f.C1046a) r5);
        } else {
            this.f344u = null;
        }
        if (((Boolean) kVar.mo9350a(C0965b.f1832ey)).booleanValue()) {
            C05824 r52 = new C1112a() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (!C0578a.this.f346w.get()) {
                        if (activity.getClass().getName().equals(C1160r.m2747c(activity.getApplicationContext()))) {
                            kVar.mo9340Q().mo9266a((C0989a) new C1042y(kVar, new Runnable() {
                                public void run() {
                                    C1107r.m2484i("InterActivityV2", "Dismissing on-screen ad due to app relaunched via launcher.");
                                    C0578a.this.mo7985f();
                                }
                            }), C1020o.C1022a.MAIN);
                        }
                    }
                }
            };
            this.f342s = r52;
            kVar.mo9370ae().mo8945a(r52);
            return;
        }
        this.f342s = null;
    }

    /* renamed from: a */
    public void mo7969a(int i, KeyEvent keyEvent) {
        C1107r rVar = this.f326c;
        if (rVar != null) {
            rVar.mo9586c("InterActivityV2", "onKeyDown(int, KeyEvent) -  " + i + ", " + keyEvent);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7970a(int i, boolean z, boolean z2, long j) {
        int i2 = i;
        if (this.f345v.compareAndSet(false, true)) {
            if (this.f324a.hasVideoUrl() || mo7996q()) {
                C1124k.m2621a(this.f337n, (AppLovinAd) this.f324a, (double) i2, z2);
            }
            if (this.f324a.hasVideoUrl()) {
                this.f328e.mo9176c((long) i2);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f331h;
            this.f325b.mo9404t().trackVideoEnd(this.f324a, TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime), i, z);
            long j2 = -1;
            if (this.f332i != -1) {
                j2 = SystemClock.elapsedRealtime() - this.f332i;
            }
            this.f325b.mo9404t().trackFullScreenAdClosed(this.f324a, j2, j, this.f334k, this.f333j);
            C1107r rVar = this.f326c;
            rVar.mo9584b("InterActivityV2", "Video ad ended at percent: " + i2 + "%, elapsedTime: " + elapsedRealtime + "ms, skipTimeMillis: " + j + "ms, closeTimeMillis: " + j2 + "ms");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7971a(long j) {
        C1107r rVar = this.f326c;
        rVar.mo9584b("InterActivityV2", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j) + " seconds...");
        this.f339p = C1157p.m2682a(j, this.f325b, new Runnable() {
            public void run() {
                if (!C0578a.this.f324a.mo9037ae().getAndSet(true)) {
                    C0578a aVar = C0578a.this;
                    C0578a.this.f325b.mo9340Q().mo9266a((C0989a) new C1035u(aVar.f324a, aVar.f325b), C1020o.C1022a.REWARD);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo7972a(Configuration configuration) {
        C1107r rVar = this.f326c;
        rVar.mo9586c("InterActivityV2", "onConfigurationChanged(Configuration) -  " + configuration);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7973a(final C0666m mVar, long j, final Runnable runnable) {
        C05867 r0 = new Runnable() {
            public void run() {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        C1163s.m2766a((View) mVar, 400, (Runnable) new Runnable() {
                            public void run() {
                                mVar.bringToFront();
                                runnable.run();
                            }
                        });
                    }
                });
            }
        };
        if (((Boolean) this.f325b.mo9350a(C0965b.f1689cI)).booleanValue()) {
            this.f340q = C1157p.m2682a(TimeUnit.SECONDS.toMillis(j), this.f325b, r0);
        } else {
            this.f325b.mo9340Q().mo9268a((C0989a) new C1042y(this.f325b, r0), C1020o.C1022a.MAIN, TimeUnit.SECONDS.toMillis(j), true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7974a(Runnable runnable, long j) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j, this.f341r);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7975a(String str) {
        if (this.f324a.mo9012U()) {
            mo7976a(str, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7976a(final String str, long j) {
        if (j >= 0) {
            mo7974a((Runnable) new Runnable() {
                public void run() {
                    C0638d p;
                    if (C1155o.m2673b(str) && (p = C0578a.this.f329f.getAdViewController().mo8109p()) != null) {
                        p.mo8128a(str);
                    }
                }
            }, j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7977a(boolean z) {
        List<Uri> a = C1160r.m2717a(z, this.f324a, this.f325b, (Context) this.f327d);
        if (a.isEmpty()) {
            return;
        }
        if (!((Boolean) this.f325b.mo9350a(C0965b.f1787eC)).booleanValue()) {
            this.f324a.mo7815a();
            return;
        }
        throw new IllegalStateException("Missing cached resource(s): " + a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7978a(boolean z, long j) {
        if (this.f324a.mo9010S()) {
            mo7976a(z ? "javascript:al_mute();" : "javascript:al_unmute();", j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7979b(String str) {
        mo7976a(str, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7980b(boolean z) {
        mo7978a(z, ((Long) this.f325b.mo9350a(C0965b.f1686cF)).longValue());
        C1124k.m2616a(this.f336m, (AppLovinAd) this.f324a);
        this.f325b.mo9369ad().mo9572a((Object) this.f324a);
        this.f325b.mo9377al().mo9417a((Object) this.f324a);
        if (this.f324a.hasVideoUrl() || mo7996q()) {
            C1124k.m2620a(this.f337n, (AppLovinAd) this.f324a);
        }
        new C0577b(this.f327d).mo7968a(this.f324a);
        this.f328e.mo9171a();
        this.f324a.setHasShown(true);
    }

    /* renamed from: c */
    public abstract void mo7981c();

    /* renamed from: c */
    public void mo7982c(boolean z) {
        C1107r rVar = this.f326c;
        rVar.mo9586c("InterActivityV2", "onWindowFocusChanged(boolean) - " + z);
        mo7975a("javascript:al_onWindowFocusChanged( " + z + " );");
        C1157p pVar = this.f340q;
        if (pVar == null) {
            return;
        }
        if (z) {
            pVar.mo9663c();
        } else {
            pVar.mo9662b();
        }
    }

    /* renamed from: d */
    public void mo7983d() {
        this.f326c.mo9586c("InterActivityV2", "onResume()");
        this.f328e.mo9178d(SystemClock.elapsedRealtime() - this.f347x);
        mo7975a("javascript:al_onAppResumed();");
        mo7993n();
        if (this.f338o.mo9099d()) {
            this.f338o.mo9094a();
        }
    }

    /* renamed from: e */
    public void mo7984e() {
        this.f326c.mo9586c("InterActivityV2", "onPause()");
        this.f347x = SystemClock.elapsedRealtime();
        mo7975a("javascript:al_onAppPaused();");
        this.f338o.mo9094a();
        mo7992m();
    }

    /* renamed from: f */
    public void mo7985f() {
        this.f326c.mo9586c("InterActivityV2", "dismiss()");
        this.f341r.removeCallbacksAndMessages((Object) null);
        mo7976a("javascript:al_onPoststitialDismiss();", (long) this.f324a.mo9009R());
        mo7991l();
        this.f328e.mo9175c();
        if (this.f343t != null) {
            C1157p.m2682a(TimeUnit.SECONDS.toMillis(2), this.f325b, new Runnable() {
                public void run() {
                    C0578a.this.f327d.stopService(new Intent(C0578a.this.f327d.getApplicationContext(), AppKilledService.class));
                    C0578a.this.f325b.mo9375aj().unregisterReceiver(C0578a.this.f343t);
                }
            });
        }
        if (this.f344u != null) {
            this.f325b.mo9374ai().mo9299b(this.f344u);
        }
        if (this.f342s != null) {
            this.f325b.mo9370ae().mo8947b(this.f342s);
        }
        this.f327d.finish();
    }

    /* renamed from: g */
    public void mo7986g() {
        this.f326c.mo9586c("InterActivityV2", "onStop()");
    }

    /* renamed from: h */
    public void mo7987h() {
        AppLovinAdView appLovinAdView = this.f329f;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.f329f.destroy();
        }
        mo7990k();
        mo7991l();
    }

    /* renamed from: i */
    public void mo7988i() {
        C1107r.m2484i("InterActivityV2", "---low memory detected - running garbage collection---");
        System.gc();
    }

    /* renamed from: j */
    public void mo7989j() {
        this.f326c.mo9586c("InterActivityV2", "onBackPressed()");
        if (this.f324a.mo9011T()) {
            mo7979b("javascript:onBackPressed();");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public abstract void mo7990k();

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo7991l() {
        if (this.f346w.compareAndSet(false, true)) {
            C1124k.m2627b(this.f336m, (AppLovinAd) this.f324a);
            this.f325b.mo9369ad().mo9575b((Object) this.f324a);
            this.f325b.mo9377al().mo9416a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo7992m() {
        C1157p pVar = this.f339p;
        if (pVar != null) {
            pVar.mo9662b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo7993n() {
        C1157p pVar = this.f339p;
        if (pVar != null) {
            pVar.mo9663c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public abstract boolean mo7994o();

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public abstract boolean mo7995p();

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public boolean mo7996q() {
        return AppLovinAdType.INCENTIVIZED == this.f324a.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.f324a.getType();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public abstract void mo7997r();

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public boolean mo7998s() {
        return ((Boolean) this.f325b.mo9350a(C0965b.f1726ct)).booleanValue() ? this.f325b.mo9400p().isMuted() : ((Boolean) this.f325b.mo9350a(C0965b.f1724cr)).booleanValue();
    }
}
