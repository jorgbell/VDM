package com.flurry.sdk;

import java.lang.Thread;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.flurry.sdk.ab */
public final class C1476ab extends C1907m<C1475aa> implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public C1926w f3704a = new C1926w();

    /* renamed from: b */
    public boolean f3705b = false;

    public C1476ab() {
        super("FlurryErrorProvider");
        C1929z a = C1929z.m4834a();
        synchronized (a.f4777b) {
            a.f4777b.put(this, (Object) null);
        }
    }

    public final void destroy() {
        super.destroy();
        C1929z.m4835b();
        C1926w wVar = this.f3704a;
        if (wVar != null) {
            wVar.f4768a = null;
            this.f3704a = null;
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String str;
        th.printStackTrace();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f3705b) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                str = th.getMessage() != null ? th.getMessage() : "";
            } else {
                StringBuilder sb = new StringBuilder();
                if (th.getMessage() != null) {
                    sb.append(" (");
                    sb.append(th.getMessage());
                    sb.append(")\n");
                }
                str = sb.toString();
            }
            notifyObservers(new C1475aa(C1928y.UNCAUGHT_EXCEPTION_ID.f4774c, currentTimeMillis, str, th.getClass().getName(), th, C1927x.m4825a(), (Map<String, String>) null, this.f3704a.mo11577a()));
        }
    }

    /* renamed from: a */
    public final void mo11260a(String str, long j, String str2, String str3, Throwable th, Map<String, String> map, Map<String, String> map2) {
        notifyObservers(new C1475aa(str, j, str2, str3, th, map, map2, Collections.emptyList()));
    }
}
