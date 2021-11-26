package com.amazon.device.iap.internal.p008b;

import com.amazon.android.framework.util.KiwiLogger;
import com.amazon.device.iap.internal.C0473a;

/* renamed from: com.amazon.device.iap.internal.b.f */
/* compiled from: KiwiLogHandler */
public class C0507f implements C0473a {

    /* renamed from: a */
    private static KiwiLogger f64a = new KiwiLogger("In App Purchasing SDK - Production Mode");

    /* renamed from: a */
    public boolean mo7429a() {
        return KiwiLogger.TRACE_ON;
    }

    /* renamed from: b */
    public boolean mo7431b() {
        return KiwiLogger.ERROR_ON;
    }

    /* renamed from: a */
    public void mo7428a(String str, String str2) {
        f64a.trace(m100c(str, str2));
    }

    /* renamed from: b */
    public void mo7430b(String str, String str2) {
        f64a.error(m100c(str, str2));
    }

    /* renamed from: c */
    private static String m100c(String str, String str2) {
        return str + ": " + str2;
    }
}
