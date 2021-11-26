package com.flurry.sdk;

import android.os.Handler;
import com.flurry.android.FlurryConfigListener;
import java.util.Map;

/* renamed from: com.flurry.sdk.cf */
public final class C1622cf {

    /* renamed from: b */
    private static C1622cf f4099b;

    /* renamed from: a */
    public C1607bz f4100a = C1607bz.m4189a();

    /* renamed from: a */
    public static synchronized C1622cf m4232a() {
        C1622cf cfVar;
        synchronized (C1622cf.class) {
            if (f4099b == null) {
                if (C1439a.m3912i()) {
                    f4099b = new C1622cf();
                } else {
                    throw new IllegalStateException("Flurry SDK must be initialized before starting config");
                }
            }
            cfVar = f4099b;
        }
        return cfVar;
    }

    private C1622cf() {
    }

    /* renamed from: a */
    public final boolean mo11385a(C1623cg cgVar) {
        return this.f4100a.mo11368a(cgVar);
    }

    /* renamed from: a */
    public final void mo11384a(FlurryConfigListener flurryConfigListener, C1623cg cgVar) {
        this.f4100a.mo11366a(flurryConfigListener, cgVar, (Handler) null);
    }

    /* renamed from: a */
    public final String mo11383a(String str, String str2, C1623cg cgVar) {
        return this.f4100a.mo11369c().mo11355a(str, str2, cgVar);
    }

    /* renamed from: b */
    public final Map<String, String> mo11386b(C1623cg cgVar) {
        return this.f4100a.mo11369c().mo11356a(cgVar);
    }
}
