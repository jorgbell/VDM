package com.amazon.device.iap.internal.p007a;

import com.amazon.device.iap.internal.C0473a;
import com.amazon.device.iap.internal.C0479b;
import com.amazon.device.iap.internal.C0517c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amazon.device.iap.internal.a.d */
/* compiled from: SandboxImplementationRegistry */
public final class C0478d implements C0479b {

    /* renamed from: a */
    private static final Map<Class, Class> f28a;

    static {
        HashMap hashMap = new HashMap();
        f28a = hashMap;
        hashMap.put(C0517c.class, C0476c.class);
        hashMap.put(C0473a.class, C0474a.class);
    }

    /* renamed from: a */
    public <T> Class<T> mo7440a(Class<T> cls) {
        return f28a.get(cls);
    }
}
