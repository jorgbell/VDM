package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1123j;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.v */
public abstract class C1036v extends C1040x {
    protected C1036v(String str, C1062k kVar) {
        super(str, kVar);
    }

    /* renamed from: a */
    private JSONObject m2028a(C0962c cVar) {
        JSONObject i = mo9294i();
        C1123j.m2584a(i, "result", cVar.mo9110b(), this.f1980b);
        Map<String, String> a = cVar.mo9109a();
        if (a != null) {
            C1123j.m2586a(i, "params", new JSONObject(a), this.f1980b);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract C0962c mo8544b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo8545b(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo8546c();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public int mo9220h() {
        return ((Integer) this.f1980b.mo9350a(C0965b.f1667bm)).intValue();
    }

    public void run() {
        C0962c b = mo8544b();
        if (b != null) {
            mo9293a(m2028a(b), new C1081a.C1084c<JSONObject>() {
                /* renamed from: a */
                public void mo8530a(int i) {
                    C1036v.this.mo8542a(i);
                }

                /* renamed from: a */
                public void mo8531a(JSONObject jSONObject, int i) {
                    C1036v.this.mo8545b(jSONObject);
                }
            });
        } else {
            mo8546c();
        }
    }
}
