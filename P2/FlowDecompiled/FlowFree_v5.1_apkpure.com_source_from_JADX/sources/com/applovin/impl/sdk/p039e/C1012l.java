package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1160r;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.l */
public class C1012l extends C0989a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1014a f2018a;

    /* renamed from: com.applovin.impl.sdk.e.l$a */
    public interface C1014a {
        /* renamed from: a */
        void mo8942a();
    }

    public C1012l(C1062k kVar, C1014a aVar) {
        super("TaskFetchVariables", kVar);
        this.f2018a = aVar;
    }

    /* renamed from: a */
    private Map<String, String> m1971a() {
        return C1160r.m2719a(this.f1980b.mo9343T().mo9426a((Map<String, String>) null, false, false));
    }

    public void run() {
        C10131 r1 = new C1033t<JSONObject>(C1085b.m2299a(this.f1980b).mo9481a(C1120h.m2558i(this.f1980b)).mo9491c(C1120h.m2559j(this.f1980b)).mo9482a(m1971a()).mo9487b("GET").mo9480a(new JSONObject()).mo9486b(((Integer) this.f1980b.mo9350a(C0965b.f1762dd)).intValue()).mo9485a(), this.f1980b) {
            /* renamed from: a */
            public void mo8530a(int i) {
                mo9216d("Unable to fetch variables: server returned " + i);
                C1107r.m2484i("AppLovinVariableService", "Failed to load variables.");
                C1012l.this.f2018a.mo8942a();
            }

            /* renamed from: a */
            public void mo8531a(JSONObject jSONObject, int i) {
                C1120h.m2549d(jSONObject, this.f1980b);
                C1120h.m2548c(jSONObject, this.f1980b);
                C1120h.m2557h(jSONObject, this.f1980b);
                C1120h.m2551e(jSONObject, this.f1980b);
                C1012l.this.f2018a.mo8942a();
            }
        };
        r1.mo9285a(C0965b.f1594aS);
        r1.mo9287b(C0965b.f1595aT);
        this.f1980b.mo9340Q().mo9265a((C0989a) r1);
    }
}
