package com.iab.omid.library.vungle.walking;

import com.iab.omid.library.vungle.walking.p052a.C2455b;
import com.iab.omid.library.vungle.walking.p052a.C2458c;
import com.iab.omid.library.vungle.walking.p052a.C2459d;
import com.iab.omid.library.vungle.walking.p052a.C2460e;
import com.iab.omid.library.vungle.walking.p052a.C2461f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.walking.b */
public class C2462b implements C2455b.C2457b {

    /* renamed from: a */
    private JSONObject f5542a;

    /* renamed from: b */
    private final C2458c f5543b;

    public C2462b(C2458c cVar) {
        this.f5543b = cVar;
    }

    /* renamed from: a */
    public void mo24257a() {
        this.f5543b.mo24250b(new C2459d(this));
    }

    /* renamed from: a */
    public void mo24248a(JSONObject jSONObject) {
        this.f5542a = jSONObject;
    }

    /* renamed from: a */
    public void mo24258a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5543b.mo24250b(new C2461f(this, hashSet, jSONObject, j));
    }

    /* renamed from: b */
    public JSONObject mo24249b() {
        return this.f5542a;
    }

    /* renamed from: b */
    public void mo24259b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5543b.mo24250b(new C2460e(this, hashSet, jSONObject, j));
    }
}
