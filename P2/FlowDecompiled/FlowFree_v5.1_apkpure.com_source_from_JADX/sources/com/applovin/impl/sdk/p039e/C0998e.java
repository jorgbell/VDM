package com.applovin.impl.sdk.p039e;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.p018a.C0541b;
import com.applovin.impl.p018a.C0544e;
import com.applovin.impl.p018a.C0553k;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.e.e */
class C0998e extends C0994c {

    /* renamed from: c */
    private final C0536a f1999c;

    public C0998e(C0536a aVar, C1062k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, kVar, appLovinAdLoadListener);
        this.f1999c = aVar;
    }

    /* renamed from: j */
    private void m1930j() {
        String str;
        String str2;
        String str3;
        if (!mo9231b()) {
            if (this.f1999c.mo7820aO()) {
                C0541b n = this.f1999c.mo7839n();
                if (n != null) {
                    C0544e b = n.mo7855b();
                    if (b != null) {
                        Uri b2 = b.mo7873b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo7874c();
                        if (URLUtil.isValidUrl(uri) || C1155o.m2673b(c)) {
                            if (b.mo7870a() == C0544e.C0545a.STATIC) {
                                mo9211a("Caching static companion ad at " + uri + "...");
                                Uri b3 = mo9230b(uri, Collections.emptyList(), false);
                                if (b3 != null) {
                                    b.mo7871a(b3);
                                } else {
                                    str2 = "Failed to cache static companion ad";
                                }
                            } else if (b.mo7870a() == C0544e.C0545a.HTML) {
                                if (C1155o.m2673b(uri)) {
                                    mo9211a("Begin caching HTML companion ad. Fetching from " + uri + "...");
                                    c = mo9234f(uri);
                                    if (C1155o.m2673b(c)) {
                                        str3 = "HTML fetched. Caching HTML now...";
                                    } else {
                                        str2 = "Unable to load companion ad resources from " + uri;
                                    }
                                } else {
                                    str3 = "Caching provided HTML for companion ad. No fetch required. HTML: " + c;
                                }
                                mo9211a(str3);
                                b.mo7872a(mo9227a(c, (List<String>) Collections.emptyList(), (C0934g) this.f1999c));
                            } else if (b.mo7870a() == C0544e.C0545a.IFRAME) {
                                str = "Skip caching of iFrame resource...";
                            } else {
                                return;
                            }
                            this.f1999c.mo9021a(true);
                            return;
                        }
                        mo9214c("Companion ad does not have any resources attached. Skipping...");
                        return;
                    }
                    str2 = "Failed to retrieve non-video resources from companion ad. Skipping...";
                    mo9216d(str2);
                    return;
                }
                str = "No companion ad provided. Skipping...";
            } else {
                str = "Companion ad caching disabled. Skipping...";
            }
            mo9211a(str);
        }
    }

    /* renamed from: k */
    private void m1931k() {
        C0553k m;
        Uri b;
        if (!mo9231b()) {
            if (!this.f1999c.mo7821aP()) {
                mo9211a("Video caching disabled. Skipping...");
            } else if (this.f1999c.mo7837l() != null && (m = this.f1999c.mo7838m()) != null && (b = m.mo7901b()) != null) {
                Uri a = mo9225a(b.toString(), (List<String>) Collections.emptyList(), false);
                if (a != null) {
                    mo9211a("Video file successfully cached into: " + a);
                    m.mo7900a(a);
                    return;
                }
                mo9216d("Failed to cache video file: " + m);
            }
        }
    }

    /* renamed from: l */
    private void m1932l() {
        String str;
        String str2;
        if (!mo9231b()) {
            if (this.f1999c.mo7819aN() != null) {
                mo9211a("Begin caching HTML template. Fetching from " + this.f1999c.mo7819aN() + "...");
                str = mo9226a(this.f1999c.mo7819aN().toString(), this.f1999c.mo9000I());
            } else {
                str = this.f1999c.mo7818aM();
            }
            if (C1155o.m2673b(str)) {
                C0536a aVar = this.f1999c;
                aVar.mo7816a(mo9227a(str, aVar.mo9000I(), (C0934g) this.f1999c));
                str2 = "Finish caching HTML template " + this.f1999c.mo7818aM() + " for ad #" + this.f1999c.getAdIdNumber();
            } else {
                str2 = "Unable to load HTML template";
            }
            mo9211a(str2);
        }
    }

    public void run() {
        super.run();
        if (this.f1999c.mo7826e()) {
            mo9211a("Begin caching for VAST streaming ad #" + this.f1986a.getAdIdNumber() + "...");
            mo9232c();
            if (this.f1999c.mo7831h()) {
                mo9236i();
            }
            C0536a.C0539b f = this.f1999c.mo7828f();
            C0536a.C0539b bVar = C0536a.C0539b.COMPANION_AD;
            if (f == bVar) {
                m1930j();
                m1932l();
            } else {
                m1931k();
            }
            if (!this.f1999c.mo7831h()) {
                mo9236i();
            }
            if (this.f1999c.mo7828f() == bVar) {
                m1931k();
            } else {
                m1930j();
                m1932l();
            }
        } else {
            mo9211a("Begin caching for VAST ad #" + this.f1986a.getAdIdNumber() + "...");
            mo9232c();
            m1930j();
            m1931k();
            m1932l();
            mo9236i();
        }
        mo9211a("Finished caching VAST ad #" + this.f1999c.getAdIdNumber());
        long currentTimeMillis = System.currentTimeMillis() - this.f1999c.getCreatedAtMillis();
        C0981d.m1831a(this.f1999c, this.f1980b);
        C0981d.m1830a(currentTimeMillis, (AppLovinAdBase) this.f1999c, this.f1980b);
        mo9229a((AppLovinAdBase) this.f1999c);
        this.f1999c.mo7824c();
        mo9228a();
    }
}
