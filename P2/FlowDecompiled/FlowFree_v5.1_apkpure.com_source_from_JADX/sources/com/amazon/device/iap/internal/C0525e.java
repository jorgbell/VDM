package com.amazon.device.iap.internal;

import android.util.Log;
import com.amazon.device.iap.internal.p007a.C0478d;
import com.amazon.device.iap.internal.p008b.C0511g;

/* renamed from: com.amazon.device.iap.internal.e */
/* compiled from: ImplementationFactory */
public final class C0525e {

    /* renamed from: a */
    private static final String f105a = "com.amazon.device.iap.internal.e";

    /* renamed from: b */
    private static volatile boolean f106b;

    /* renamed from: c */
    private static volatile boolean f107c;

    /* renamed from: d */
    private static volatile C0517c f108d;

    /* renamed from: e */
    private static volatile C0473a f109e;

    /* renamed from: f */
    private static volatile C0479b f110f;

    /* renamed from: d */
    private static C0479b m171d() {
        if (f110f == null) {
            synchronized (C0525e.class) {
                if (f110f == null) {
                    if (m168a()) {
                        f110f = new C0478d();
                    } else {
                        f110f = new C0511g();
                    }
                }
            }
        }
        return f110f;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:11|12|13|14|15|16|17|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0020 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m168a() {
        /*
            java.lang.Class<com.amazon.device.iap.internal.e> r0 = com.amazon.device.iap.internal.C0525e.class
            boolean r1 = f107c
            if (r1 == 0) goto L_0x0009
            boolean r0 = f106b
            return r0
        L_0x0009:
            monitor-enter(r0)
            boolean r1 = f107c     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0012
            boolean r1 = f106b     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return r1
        L_0x0012:
            r1 = 1
            java.lang.ClassLoader r2 = r0.getClassLoader()     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = "com.amazon.android.Kiwi"
            r2.loadClass(r3)     // Catch:{ all -> 0x0020 }
            r2 = 0
            f106b = r2     // Catch:{ all -> 0x0020 }
            goto L_0x0022
        L_0x0020:
            f106b = r1     // Catch:{ all -> 0x0028 }
        L_0x0022:
            f107c = r1     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            boolean r0 = f106b
            return r0
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.C0525e.m168a():boolean");
    }

    /* renamed from: b */
    public static C0517c m169b() {
        if (f108d == null) {
            synchronized (C0525e.class) {
                if (f108d == null) {
                    f108d = (C0517c) m167a(C0517c.class);
                }
            }
        }
        return f108d;
    }

    /* renamed from: c */
    public static C0473a m170c() {
        if (f109e == null) {
            synchronized (C0525e.class) {
                if (f109e == null) {
                    f109e = (C0473a) m167a(C0473a.class);
                }
            }
        }
        return f109e;
    }

    /* renamed from: a */
    private static <T> T m167a(Class<T> cls) {
        try {
            return m171d().mo7440a(cls).newInstance();
        } catch (Exception e) {
            String str = f105a;
            Log.e(str, "error getting instance for " + cls, e);
            return null;
        }
    }
}
