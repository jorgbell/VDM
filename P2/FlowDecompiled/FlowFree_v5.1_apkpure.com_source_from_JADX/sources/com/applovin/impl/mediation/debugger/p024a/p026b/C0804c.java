package com.applovin.impl.mediation.debugger.p024a.p026b;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1114c;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.c */
public class C0804c {

    /* renamed from: a */
    private final boolean f981a;

    /* renamed from: b */
    private final boolean f982b;

    /* renamed from: c */
    private final boolean f983c;

    /* renamed from: d */
    private final String f984d;

    public C0804c(JSONObject jSONObject, C1062k kVar) {
        this.f981a = C1114c.m2509a(kVar.mo9334J()).mo9606a();
        JSONObject b = C1123j.m2600b(jSONObject, "cleartext_traffic", (JSONObject) null, kVar);
        boolean z = false;
        if (b != null) {
            this.f982b = true;
            this.f984d = C1123j.m2594b(b, "description", "", kVar);
            if (C1120h.m2542a()) {
                this.f983c = true;
                return;
            }
            List a = C1123j.m2574a(b, "domains", (List) new ArrayList(), kVar);
            if (a.size() > 0) {
                Iterator it = a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!C1120h.m2545a((String) it.next())) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            }
            this.f983c = z;
            return;
        }
        this.f982b = false;
        this.f984d = "";
        this.f983c = C1120h.m2542a();
    }

    /* renamed from: a */
    public boolean mo8612a() {
        return this.f982b;
    }

    /* renamed from: b */
    public boolean mo8613b() {
        return this.f983c;
    }

    /* renamed from: c */
    public String mo8614c() {
        return this.f981a ? this.f984d : "You must include an entry in your AndroidManifest.xml to point to your network_security_config.xml.\n\nFor more information, visit: https://developer.android.com/training/articles/security-config";
    }
}
