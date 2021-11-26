package com.applovin.impl.sdk.p039e;

import com.applovin.impl.p018a.C0542c;
import com.applovin.impl.p018a.C0543d;
import com.applovin.impl.p018a.C0549i;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import com.applovin.impl.sdk.utils.C1167u;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.q */
abstract class C1027q extends C0989a {

    /* renamed from: a */
    private final AppLovinAdLoadListener f2088a;

    /* renamed from: c */
    private final C1028a f2089c;

    /* renamed from: com.applovin.impl.sdk.e.q$a */
    private static final class C1028a extends C0542c {
        C1028a(JSONObject jSONObject, JSONObject jSONObject2, C0925b bVar, C1062k kVar) {
            super(jSONObject, jSONObject2, bVar, kVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9280a(C1166t tVar) {
            if (tVar != null) {
                this.f176a.add(tVar);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }

    /* renamed from: com.applovin.impl.sdk.e.q$b */
    private static final class C1029b extends C1027q {

        /* renamed from: a */
        private final JSONObject f2090a;

        C1029b(C0542c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
            super(cVar, appLovinAdLoadListener, kVar);
            if (appLovinAdLoadListener != null) {
                this.f2090a = cVar.mo7863c();
                return;
            }
            throw new IllegalArgumentException("No callback specified.");
        }

        public void run() {
            C0543d dVar;
            mo9211a("Processing SDK JSON response...");
            String b = C1123j.m2594b(this.f2090a, "xml", (String) null, this.f1980b);
            if (!C1155o.m2673b(b)) {
                mo9216d("No VAST response received.");
                dVar = C0543d.NO_WRAPPER_RESPONSE;
            } else if (b.length() < ((Integer) this.f1980b.mo9350a(C0965b.f1809eb)).intValue()) {
                try {
                    mo9279a(C1167u.m2781a(b, this.f1980b));
                    return;
                } catch (Throwable th) {
                    mo9212a("Unable to parse VAST response", th);
                }
            } else {
                mo9216d("VAST response is over max length");
                dVar = C0543d.XML_PARSING;
            }
            mo9278a(dVar);
        }
    }

    /* renamed from: com.applovin.impl.sdk.e.q$c */
    private static final class C1030c extends C1027q {

        /* renamed from: a */
        private final C1166t f2091a;

        C1030c(C1166t tVar, C0542c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
            super(cVar, appLovinAdLoadListener, kVar);
            if (tVar == null) {
                throw new IllegalArgumentException("No response specified.");
            } else if (cVar == null) {
                throw new IllegalArgumentException("No context specified.");
            } else if (appLovinAdLoadListener != null) {
                this.f2091a = tVar;
            } else {
                throw new IllegalArgumentException("No callback specified.");
            }
        }

        public void run() {
            mo9211a("Processing VAST Wrapper response...");
            mo9279a(this.f2091a);
        }
    }

    C1027q(C0542c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        super("TaskProcessVastResponse", kVar);
        if (cVar != null) {
            this.f2088a = appLovinAdLoadListener;
            this.f2089c = (C1028a) cVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    /* renamed from: a */
    public static C1027q m2004a(C1166t tVar, C0542c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        return new C1030c(tVar, cVar, appLovinAdLoadListener, kVar);
    }

    /* renamed from: a */
    public static C1027q m2005a(JSONObject jSONObject, JSONObject jSONObject2, C0925b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        return new C1029b(new C1028a(jSONObject, jSONObject2, bVar, kVar), appLovinAdLoadListener, kVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9278a(C0543d dVar) {
        mo9216d("Failed to process VAST response due to VAST error code " + dVar);
        C0549i.m288a((C0542c) this.f2089c, this.f2088a, dVar, -6, this.f1980b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9279a(C1166t tVar) {
        C0543d dVar;
        C0989a aVar;
        int a = this.f2089c.mo7861a();
        mo9211a("Finished parsing XML at depth " + a);
        this.f2089c.mo9280a(tVar);
        if (C0549i.m294a(tVar)) {
            int intValue = ((Integer) this.f1980b.mo9350a(C0965b.f1810ec)).intValue();
            if (a < intValue) {
                mo9211a("VAST response is wrapper. Resolving...");
                aVar = new C1038w(this.f2089c, this.f2088a, this.f1980b);
            } else {
                mo9216d("Reached beyond max wrapper depth of " + intValue);
                dVar = C0543d.WRAPPER_LIMIT_REACHED;
                mo9278a(dVar);
                return;
            }
        } else if (C0549i.m297b(tVar)) {
            mo9211a("VAST response is inline. Rendering ad...");
            aVar = new C1032s(this.f2089c, this.f2088a, this.f1980b);
        } else {
            mo9216d("VAST response is an error");
            dVar = C0543d.NO_WRAPPER_RESPONSE;
            mo9278a(dVar);
            return;
        }
        this.f1980b.mo9340Q().mo9265a(aVar);
    }
}
