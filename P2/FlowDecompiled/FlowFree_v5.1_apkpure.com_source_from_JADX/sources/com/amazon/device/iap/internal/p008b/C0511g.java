package com.amazon.device.iap.internal.p008b;

import com.amazon.device.iap.internal.C0473a;
import com.amazon.device.iap.internal.C0479b;
import com.amazon.device.iap.internal.C0517c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amazon.device.iap.internal.b.g */
/* compiled from: KiwiImplementationRegistry */
public final class C0511g implements C0479b {

    /* renamed from: a */
    private static final Map<Class, Class> f65a;

    static {
        HashMap hashMap = new HashMap();
        f65a = hashMap;
        hashMap.put(C0517c.class, C0491c.class);
        hashMap.put(C0473a.class, C0507f.class);
    }

    /* renamed from: a */
    public <T> Class<T> mo7440a(Class<T> cls) {
        return f65a.get(cls);
    }
}
