package com.applovin.impl.mediation.debugger.p024a.p025a;

import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.mediation.MaxAdFormat;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.a */
public class C0796a implements Comparable<C0796a> {

    /* renamed from: a */
    private final String f926a;

    /* renamed from: b */
    private final String f927b;

    /* renamed from: c */
    private final MaxAdFormat f928c;

    /* renamed from: d */
    private final C0798c f929d;

    /* renamed from: e */
    private final List<C0798c> f930e;

    public C0796a(JSONObject jSONObject, Map<String, C0801b> map, C1062k kVar) {
        this.f926a = C1123j.m2594b(jSONObject, MediationMetaData.KEY_NAME, "", kVar);
        this.f927b = C1123j.m2594b(jSONObject, "display_name", "", kVar);
        this.f928c = MaxAdFormat.formatFromString(C1123j.m2594b(jSONObject, "format", (String) null, kVar));
        JSONArray b = C1123j.m2599b(jSONObject, "waterfalls", new JSONArray(), kVar);
        this.f930e = new ArrayList(b.length());
        C0798c cVar = null;
        for (int i = 0; i < b.length(); i++) {
            JSONObject a = C1123j.m2581a(b, i, (JSONObject) null, kVar);
            if (a != null) {
                C0798c cVar2 = new C0798c(a, map, kVar);
                this.f930e.add(cVar2);
                if (cVar == null && cVar2.mo8580c()) {
                    cVar = cVar2;
                }
            }
        }
        this.f929d = cVar;
    }

    /* renamed from: g */
    private C0798c m1138g() {
        if (!this.f930e.isEmpty()) {
            return this.f930e.get(0);
        }
        return null;
    }

    /* renamed from: a */
    public int compareTo(C0796a aVar) {
        return this.f927b.compareToIgnoreCase(aVar.f927b);
    }

    /* renamed from: a */
    public String mo8565a() {
        return this.f926a;
    }

    /* renamed from: b */
    public String mo8566b() {
        return this.f927b;
    }

    /* renamed from: c */
    public String mo8567c() {
        MaxAdFormat maxAdFormat = this.f928c;
        return maxAdFormat != null ? maxAdFormat.getDisplayName() : "Unknown";
    }

    /* renamed from: d */
    public MaxAdFormat mo8569d() {
        return this.f928c;
    }

    /* renamed from: e */
    public C0798c mo8570e() {
        C0798c cVar = this.f929d;
        return cVar != null ? cVar : m1138g();
    }

    /* renamed from: f */
    public String mo8571f() {
        return "\n---------- " + this.f927b + " ----------" + "\nIdentifier - " + this.f926a + "\nFormat     - " + mo8567c();
    }
}
