package com.iab.omid.library.vungle.adsession;

import android.view.View;
import com.iab.omid.library.vungle.p048b.C2423a;
import com.iab.omid.library.vungle.p048b.C2426c;
import com.iab.omid.library.vungle.p048b.C2430f;
import com.iab.omid.library.vungle.p050d.C2441e;
import com.iab.omid.library.vungle.p051e.C2443a;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.publisher.C2446a;
import com.iab.omid.library.vungle.publisher.C2447b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* renamed from: com.iab.omid.library.vungle.adsession.a */
public class C2421a extends AdSession {

    /* renamed from: b */
    private final AdSessionContext f5461b;

    /* renamed from: d */
    private final List<C2426c> f5462d = new ArrayList();

    /* renamed from: e */
    private C2443a f5463e;

    /* renamed from: f */
    private AdSessionStatePublisher f5464f;

    /* renamed from: g */
    private boolean f5465g = false;

    /* renamed from: h */
    private boolean f5466h = false;

    /* renamed from: i */
    private String f5467i;

    static {
        Pattern.compile("^[a-zA-Z0-9 ]+$");
    }

    C2421a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f5461b = adSessionContext;
        this.f5467i = UUID.randomUUID().toString();
        m5705c((View) null);
        this.f5464f = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new C2446a(adSessionContext.getWebView()) : new C2447b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f5464f.mo24205a();
        C2423a.m5714a().mo24166a(this);
        this.f5464f.mo24208a(adSessionConfiguration);
    }

    /* renamed from: c */
    private void m5705c(View view) {
        this.f5463e = new C2443a(view);
    }

    /* renamed from: d */
    private void m5706d(View view) {
        Collection<C2421a> b = C2423a.m5714a().mo24167b();
        if (b != null && b.size() > 0) {
            for (C2421a next : b) {
                if (next != this && next.mo24158d() == view) {
                    next.f5463e.clear();
                }
            }
        }
    }

    /* renamed from: a */
    public List<C2426c> mo24157a() {
        return this.f5462d;
    }

    /* renamed from: d */
    public View mo24158d() {
        return (View) this.f5463e.get();
    }

    /* renamed from: e */
    public boolean mo24159e() {
        return this.f5465g && !this.f5466h;
    }

    public void finish() {
        if (!this.f5466h) {
            this.f5463e.clear();
            removeAllFriendlyObstructions();
            this.f5466h = true;
            getAdSessionStatePublisher().mo24216f();
            C2423a.m5714a().mo24170c(this);
            getAdSessionStatePublisher().mo24213b();
            this.f5464f = null;
        }
    }

    public String getAdSessionId() {
        return this.f5467i;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f5464f;
    }

    public void registerAdView(View view) {
        if (!this.f5466h) {
            C2441e.m5791a((Object) view, "AdView is null");
            if (mo24158d() != view) {
                m5705c(view);
                getAdSessionStatePublisher().mo24218i();
                m5706d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f5466h) {
            this.f5462d.clear();
        }
    }

    public void start() {
        if (!this.f5465g) {
            this.f5465g = true;
            C2423a.m5714a().mo24168b(this);
            this.f5464f.mo24206a(C2430f.m5747a().mo24198d());
            this.f5464f.mo24209a(this, this.f5461b);
        }
    }
}
