package com.applovin.impl.adview.activity.p020b;

import android.os.SystemClock;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.p019a.C0573b;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.utils.C1115d;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.b */
public class C0591b extends C0578a {

    /* renamed from: r */
    private final C0573b f366r = new C0573b(this.f324a, this.f327d, this.f325b);

    /* renamed from: s */
    private C1115d f367s;

    /* renamed from: t */
    private long f368t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public AtomicBoolean f369u = new AtomicBoolean();

    public C0591b(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
    }

    /* renamed from: t */
    private long m401t() {
        C0934g gVar = this.f324a;
        if (!(gVar instanceof C0924a)) {
            return 0;
        }
        float k = ((C0924a) gVar).mo8959k();
        if (k <= 0.0f) {
            k = (float) this.f324a.mo9068t();
        }
        double b = (double) C1160r.m2738b(k);
        double P = (double) this.f324a.mo9007P();
        Double.isNaN(P);
        Double.isNaN(b);
        return (long) (b * (P / 100.0d));
    }

    /* renamed from: a */
    public void mo8010a() {
    }

    /* renamed from: b */
    public void mo8011b() {
    }

    /* renamed from: c */
    public void mo7981c() {
        this.f366r.mo7963a(this.f330g, this.f329f);
        mo7977a(false);
        this.f329f.renderAd(this.f324a);
        mo7976a("javascript:al_onPoststitialShow();", (long) this.f324a.mo9008Q());
        if (mo7996q()) {
            long t = m401t();
            this.f368t = t;
            if (t > 0) {
                C1107r rVar = this.f326c;
                rVar.mo9584b("InterActivityV2", "Scheduling timer for ad fully watched in " + this.f368t + "ms...");
                this.f367s = C1115d.m2514a(this.f368t, this.f325b, new Runnable() {
                    public void run() {
                        C0591b.this.f326c.mo9584b("InterActivityV2", "Marking ad as fully watched");
                        C0591b.this.f369u.set(true);
                    }
                });
            }
        }
        if (this.f330g != null) {
            if (this.f324a.mo9068t() >= 0) {
                mo7973a(this.f330g, this.f324a.mo9068t(), new Runnable() {
                    public void run() {
                        C0591b.this.f332i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                this.f330g.setVisibility(0);
            }
        }
        mo7997r();
        super.mo7980b(mo7998s());
    }

    /* renamed from: f */
    public void mo7985f() {
        mo7990k();
        C1115d dVar = this.f367s;
        if (dVar != null) {
            dVar.mo9609a();
            this.f367s = null;
        }
        super.mo7985f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo7990k() {
        C1115d dVar;
        boolean o = mo7994o();
        int i = 100;
        if (mo7996q()) {
            if (!o && (dVar = this.f367s) != null) {
                double b = (double) (this.f368t - dVar.mo9610b());
                double d = (double) this.f368t;
                Double.isNaN(b);
                Double.isNaN(d);
                i = (int) Math.min(100.0d, (b / d) * 100.0d);
            }
            C1107r rVar = this.f326c;
            rVar.mo9584b("InterActivityV2", "Ad engaged at " + i + "%");
        }
        super.mo7970a(i, false, o, -2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public boolean mo7994o() {
        if (mo7996q()) {
            return this.f369u.get();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo7995p() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo7997r() {
        long j;
        long millis;
        long j2 = 0;
        if (this.f324a.mo9034ab() >= 0 || this.f324a.mo9035ac() >= 0) {
            int i = (this.f324a.mo9034ab() > 0 ? 1 : (this.f324a.mo9034ab() == 0 ? 0 : -1));
            C0934g gVar = this.f324a;
            if (i >= 0) {
                j = gVar.mo9034ab();
            } else {
                if (gVar.mo9036ad()) {
                    int k = (int) ((C0924a) this.f324a).mo8959k();
                    if (k > 0) {
                        millis = TimeUnit.SECONDS.toMillis((long) k);
                    } else {
                        int t = (int) this.f324a.mo9068t();
                        if (t > 0) {
                            millis = TimeUnit.SECONDS.toMillis((long) t);
                        }
                    }
                    j2 = 0 + millis;
                }
                double d = (double) j2;
                double ac = (double) this.f324a.mo9035ac();
                Double.isNaN(ac);
                Double.isNaN(d);
                j = (long) (d * (ac / 100.0d));
            }
            mo7971a(j);
        }
    }
}
