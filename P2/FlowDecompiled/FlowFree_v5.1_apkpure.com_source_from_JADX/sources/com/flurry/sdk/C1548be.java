package com.flurry.sdk;

import com.flurry.android.FlurryAgent;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.flurry.sdk.be */
public final class C1548be {

    /* renamed from: b */
    private static boolean f3914b = false;

    /* renamed from: c */
    private static boolean f3915c = false;

    /* renamed from: d */
    private static C1548be f3916d;

    /* renamed from: a */
    public int f3917a = 0;

    /* renamed from: com.flurry.sdk.be$a */
    public static class C1549a {

        /* renamed from: a */
        public int f3918a = 0;

        /* renamed from: b */
        public Set<C1893jo> f3919b = new TreeSet();

        /* renamed from: c */
        public int f3920c = 0;
    }

    /* renamed from: com.flurry.sdk.be$c */
    public static class C1551c {

        /* renamed from: a */
        public int f3934a = 0;
    }

    /* renamed from: com.flurry.sdk.be$b */
    public enum C1550b {
        UNKNOWN(0),
        SUCCEED(1),
        IOEXCEPTION(2),
        EOF(3),
        PAYLOAD_ERROR(4),
        FRAME_MISSING(5);
        

        /* renamed from: g */
        public String f3928g;

        /* renamed from: h */
        public int f3929h;

        /* renamed from: i */
        public int f3930i;

        /* renamed from: j */
        public List<C1893jo> f3931j;

        /* renamed from: k */
        public Set<C1893jo> f3932k;

        /* renamed from: l */
        private final int f3933l;

        private C1550b(int i) {
            this.f3928g = null;
            this.f3929h = 0;
            this.f3930i = 0;
            this.f3931j = null;
            this.f3932k = null;
            this.f3933l = i;
        }
    }

    private C1548be() {
    }

    /* renamed from: a */
    public static synchronized C1548be m4072a() {
        C1548be beVar;
        synchronized (C1548be.class) {
            if (f3916d == null) {
                f3916d = new C1548be();
            }
            beVar = f3916d;
        }
        return beVar;
    }

    /* renamed from: b */
    public final void mo11316b() {
        C1551c b = C1735fb.m4502a().f4348d.mo11494b();
        C1549a c = C1735fb.m4502a().f4346b.f4360a.mo11520c();
        HashMap hashMap = new HashMap();
        hashMap.put("fl.invalid.payload.count", String.valueOf(this.f3917a));
        hashMap.put("fl.payload.queue.size", String.valueOf(b.f3934a));
        hashMap.put("fl.drop.frame.count", String.valueOf(c.f3918a));
        hashMap.put("fl.drop.frame.types", String.valueOf(c.f3919b));
        hashMap.put("fl.auto.end.timed.events", String.valueOf(c.f3920c));
        this.f3917a = 0;
        b.f3934a = 0;
        c.f3918a = 0;
        c.f3919b.clear();
        c.f3920c = 0;
        m4074a("Flurry.SDKReport.SessionSummary", hashMap);
    }

    /* renamed from: a */
    public static void m4074a(String str, Map<String, String> map) {
        if (f3915c) {
            FlurryAgent.logEvent(str, map);
            C1648cy.m4317a(4, "SDKLogManager", "Log SDK events: " + str + " with " + map);
            if ("Flurry.SDKReport.DropFrame".equals(str)) {
                String str2 = map.get("fl.drop.reason");
                if (C1770fu.f4414b.f4422a.f4434j.equals(str2) || C1770fu.f4416d.f4422a.f4434j.equals(str2)) {
                    f3915c = false;
                    f3914b = false;
                }
            }
        }
    }

    /* renamed from: b */
    public static void m4075b(String str, Map<String, String> map) {
        if (f3914b) {
            FlurryAgent.logEvent(str, map);
            C1648cy.m4317a(4, "SDKLogManager", "Log SDK internal events. " + str + "SDKLogManager");
        }
    }

    /* renamed from: a */
    public static void m4073a(String str, String str2, Throwable th) {
        FlurryAgent.onError(str, str2, th, (Map<String, String>) Collections.emptyMap());
        C1648cy.m4317a(4, "SDKLogManager", "Log SDK internal errors. " + str2 + "SDKLogManager");
    }
}
