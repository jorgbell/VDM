package com.applovin.impl.sdk.p039e;

import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.p018a.C0541b;
import com.applovin.impl.p018a.C0542c;
import com.applovin.impl.p018a.C0543d;
import com.applovin.impl.p018a.C0546f;
import com.applovin.impl.p018a.C0547g;
import com.applovin.impl.p018a.C0549i;
import com.applovin.impl.p018a.C0550j;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1166t;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.e.s */
class C1032s extends C0989a {

    /* renamed from: a */
    private C0542c f2096a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f2097c;

    C1032s(C0542c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        super("TaskRenderVastAd", kVar);
        this.f2097c = appLovinAdLoadListener;
        this.f2096a = cVar;
    }

    public void run() {
        mo9211a("Rendering VAST ad...");
        int size = this.f2096a.mo7862b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        C0546f fVar = null;
        C0550j jVar = null;
        C0541b bVar = null;
        String str2 = str;
        for (C1166t next : this.f2096a.mo7862b()) {
            C1166t c = next.mo9700c(C0549i.m294a(next) ? "Wrapper" : "InLine");
            if (c != null) {
                C1166t c2 = c.mo9700c("AdSystem");
                if (c2 != null) {
                    fVar = C0546f.m273a(c2, fVar, this.f1980b);
                }
                str = C0549i.m285a(c, "AdTitle", str);
                str2 = C0549i.m285a(c, "Description", str2);
                C0549i.m290a(c.mo9697a("Impression"), (Set<C0547g>) hashSet, this.f2096a, this.f1980b);
                C1166t b = c.mo9698b("ViewableImpression");
                if (b != null) {
                    C0549i.m290a(b.mo9697a("Viewable"), (Set<C0547g>) hashSet, this.f2096a, this.f1980b);
                }
                C0549i.m290a(c.mo9697a("Error"), (Set<C0547g>) hashSet2, this.f2096a, this.f1980b);
                C1166t b2 = c.mo9698b("Creatives");
                if (b2 != null) {
                    for (C1166t next2 : b2.mo9702d()) {
                        C1166t b3 = next2.mo9698b("Linear");
                        if (b3 != null) {
                            jVar = C0550j.m300a(b3, jVar, this.f2096a, this.f1980b);
                        } else {
                            C1166t c3 = next2.mo9700c("CompanionAds");
                            if (c3 != null) {
                                C1166t c4 = c3.mo9700c("Companion");
                                if (c4 != null) {
                                    bVar = C0541b.m252a(c4, bVar, this.f2096a, this.f1980b);
                                }
                            } else {
                                mo9216d("Received and will skip rendering for an unidentified creative: " + next2);
                            }
                        }
                    }
                }
            } else {
                mo9216d("Did not find wrapper or inline response for node: " + next);
            }
        }
        C0536a a = C0536a.m198aQ().mo7846a(this.f1980b).mo7849a(this.f2096a.mo7863c()).mo7853b(this.f2096a.mo7864d()).mo7845a(this.f2096a.mo7865e()).mo7841a(this.f2096a.mo7866f()).mo7847a(str).mo7851b(str2).mo7843a(fVar).mo7844a(jVar).mo7842a(bVar).mo7848a((Set<C0547g>) hashSet).mo7852b((Set<C0547g>) hashSet2).mo7850a();
        C0543d a2 = C0549i.m281a(a);
        if (a2 == null) {
            C0998e eVar = new C0998e(a, this.f1980b, this.f2097c);
            C1020o.C1022a aVar = C1020o.C1022a.CACHING_OTHER;
            if (((Boolean) this.f1980b.mo9350a(C0965b.f1657bc)).booleanValue()) {
                if (a.getType() == AppLovinAdType.REGULAR) {
                    aVar = C1020o.C1022a.CACHING_INTERSTITIAL;
                } else if (a.getType() == AppLovinAdType.INCENTIVIZED) {
                    aVar = C1020o.C1022a.CACHING_INCENTIVIZED;
                }
            }
            this.f1980b.mo9340Q().mo9266a((C0989a) eVar, aVar);
            return;
        }
        C0549i.m288a(this.f2096a, this.f2097c, a2, -6, this.f1980b);
    }
}
