package com.chartboost.sdk.Networking;

import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.C1222i;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.chartboost.sdk.Networking.j */
public class C1252j {

    /* renamed from: a */
    private final C1220g f2882a;

    /* renamed from: b */
    private final Map<String, C1222i.C1223a> f2883b = new HashMap();

    public C1252j(C1220g gVar) {
        this.f2882a = gVar;
    }

    /* renamed from: a */
    private boolean m3107a(String str) {
        return this.f2882a.mo10049b(String.format("%s%s", new Object[]{str, ".png"}));
    }

    /* renamed from: b */
    public C1222i.C1223a mo10160b(String str) {
        if (!m3107a(str)) {
            this.f2883b.remove(str);
            return null;
        } else if (this.f2883b.containsKey(str)) {
            return this.f2883b.get(str);
        } else {
            C1222i.C1223a aVar = new C1222i.C1223a(str, new File(this.f2882a.mo10046a().f2681b, String.format("%s%s", new Object[]{str, ".png"})), this.f2882a);
            this.f2883b.put(str, aVar);
            return aVar;
        }
    }
}
