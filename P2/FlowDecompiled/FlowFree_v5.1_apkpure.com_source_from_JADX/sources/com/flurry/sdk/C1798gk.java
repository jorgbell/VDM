package com.flurry.sdk;

import com.flurry.android.FlurryEventRecordStatus;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.flurry.sdk.gk */
public final class C1798gk extends C1892jn {

    /* renamed from: a */
    private static final AtomicInteger f4483a = new AtomicInteger(0);

    private C1798gk(C1894jp jpVar) {
        super(jpVar);
    }

    /* renamed from: com.flurry.sdk.gk$a */
    public enum C1799a {
        RECOVERABLE_ERROR(1),
        CAUGHT_EXCEPTION(2),
        UNRECOVERABLE_CRASH(3);
        

        /* renamed from: d */
        public int f4488d;

        private C1799a(int i) {
            this.f4488d = i;
        }
    }

    /* renamed from: com.flurry.sdk.gk$b */
    public enum C1800b {
        NO_LOG(0),
        ANDROID_LOG_ATTACHED(2),
        NATIVE_CRASH_ATTACHED(3);
        

        /* renamed from: d */
        public int f4493d;

        private C1800b(int i) {
            this.f4493d = i;
        }
    }

    /* renamed from: a */
    public final C1893jo mo11542a() {
        return C1893jo.ANALYTICS_ERROR;
    }

    /* renamed from: a */
    public static FlurryEventRecordStatus m4649a(C1475aa aaVar) {
        int i;
        int i2;
        C1475aa aaVar2 = aaVar;
        if (aaVar2 == null) {
            C1648cy.m4331d("StreamingErrorFrame", "Error is null, do not send the frame.");
            return FlurryEventRecordStatus.kFlurryEventFailed;
        }
        C1928y yVar = C1928y.UNCAUGHT_EXCEPTION_ID;
        boolean equals = yVar.f4774c.equals(aaVar2.f3696a);
        List<C1925v> list = equals ? aaVar2.f3703h : null;
        int incrementAndGet = f4483a.incrementAndGet();
        String str = aaVar2.f3696a;
        long j = aaVar2.f3697b;
        String str2 = aaVar2.f3698c;
        String str3 = aaVar2.f3699d;
        String a = m4651a(aaVar2.f3700e);
        String str4 = aaVar2.f3696a;
        if (aaVar2.f3700e != null) {
            if (yVar.f4774c.equals(str4)) {
                i = C1799a.UNRECOVERABLE_CRASH.f4488d;
            } else {
                i = C1799a.CAUGHT_EXCEPTION.f4488d;
            }
        } else if (C1928y.NATIVE_CRASH.f4774c.equals(str4)) {
            i = C1799a.UNRECOVERABLE_CRASH.f4488d;
        } else {
            i = C1799a.RECOVERABLE_ERROR.f4488d;
        }
        int i3 = i;
        if (aaVar2.f3700e == null) {
            i2 = C1800b.NO_LOG.f4493d;
        } else {
            i2 = C1800b.ANDROID_LOG_ATTACHED.f4493d;
        }
        C1798gk gkVar = new C1798gk(new C1801gl(incrementAndGet, str, j, str2, str3, a, i3, i2, aaVar2.f3701f, aaVar2.f3702g, C1926w.m4822b(), list, "", ""));
        if (equals) {
            C1735fb.m4502a().f4346b.f4360a.mo11519b(gkVar);
        } else {
            C1735fb.m4502a().mo11504a(gkVar);
        }
        return FlurryEventRecordStatus.kFlurryEventRecorded;
    }

    /* renamed from: a */
    public static C1798gk m4650a(C1801gl glVar) {
        return new C1798gk(glVar);
    }

    /* renamed from: b */
    public static AtomicInteger m4652b() {
        return f4483a;
    }

    /* renamed from: a */
    private static String m4651a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append(append);
            sb.append(C1736fc.f4349a);
        }
        if (th.getCause() != null) {
            sb.append(C1736fc.f4349a);
            sb.append("Caused by: ");
            for (StackTraceElement append2 : th.getCause().getStackTrace()) {
                sb.append(append2);
                sb.append(C1736fc.f4349a);
            }
        }
        return sb.toString();
    }
}
