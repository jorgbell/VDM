package com.applovin.impl.mediation.debugger.p024a.p025a;

import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.b */
public class C0797b {

    /* renamed from: a */
    private final C0801b f931a;

    /* renamed from: b */
    private final String f932b;

    /* renamed from: c */
    private final String f933c;

    /* renamed from: d */
    private final C0799d f934d;

    /* renamed from: e */
    private final List<C0799d> f935e;

    public C0797b(JSONObject jSONObject, C0801b bVar, C1062k kVar) {
        this.f931a = bVar;
        this.f932b = C1123j.m2594b(jSONObject, MediationMetaData.KEY_NAME, "", kVar);
        this.f933c = C1123j.m2594b(jSONObject, "display_name", "", kVar);
        JSONObject b = C1123j.m2600b(jSONObject, "bidder_placement", (JSONObject) null, kVar);
        if (b != null) {
            this.f934d = new C0799d(b, kVar);
        } else {
            this.f934d = null;
        }
        JSONArray b2 = C1123j.m2599b(jSONObject, "placements", new JSONArray(), kVar);
        this.f935e = new ArrayList(b2.length());
        for (int i = 0; i < b2.length(); i++) {
            JSONObject a = C1123j.m2581a(b2, i, (JSONObject) null, kVar);
            if (a != null) {
                this.f935e.add(new C0799d(a, kVar));
            }
        }
    }

    /* renamed from: a */
    public C0801b mo8572a() {
        return this.f931a;
    }

    /* renamed from: b */
    public String mo8573b() {
        return this.f932b;
    }

    /* renamed from: c */
    public String mo8574c() {
        return this.f933c;
    }

    /* renamed from: d */
    public C0799d mo8575d() {
        return this.f934d;
    }

    /* renamed from: e */
    public boolean mo8576e() {
        return this.f934d != null;
    }

    /* renamed from: f */
    public List<C0799d> mo8577f() {
        return this.f935e;
    }
}
