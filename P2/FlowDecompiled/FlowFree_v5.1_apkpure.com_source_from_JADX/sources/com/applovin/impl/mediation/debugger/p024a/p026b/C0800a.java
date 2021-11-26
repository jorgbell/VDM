package com.applovin.impl.mediation.debugger.p024a.p026b;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.a */
public class C0800a {

    /* renamed from: a */
    private final String f942a;

    /* renamed from: b */
    private final String f943b;

    /* renamed from: c */
    private final boolean f944c;

    C0800a(JSONObject jSONObject, C1062k kVar) {
        boolean z;
        this.f942a = C1123j.m2594b(jSONObject, MediationMetaData.KEY_NAME, "", kVar);
        this.f943b = C1123j.m2594b(jSONObject, "description", "", kVar);
        List a = C1123j.m2574a(jSONObject, "existence_classes", (List) null, kVar);
        if (a != null) {
            z = false;
            Iterator it = a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (C1160r.m2753d((String) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            z = C1160r.m2753d(C1123j.m2594b(jSONObject, "existence_class", "", kVar));
        }
        this.f944c = z;
    }

    /* renamed from: a */
    public String mo8583a() {
        return this.f942a;
    }

    /* renamed from: b */
    public String mo8584b() {
        return this.f943b;
    }

    /* renamed from: c */
    public boolean mo8585c() {
        return this.f944c;
    }
}
