package com.flurry.sdk;

/* renamed from: com.flurry.sdk.fb */
public final class C1735fb {

    /* renamed from: a */
    static C1735fb f4345a;

    /* renamed from: b */
    public C1744fi f4346b = new C1744fi();

    /* renamed from: c */
    public C1900jv f4347c;

    /* renamed from: d */
    public C1896jr f4348d;

    private C1735fb() {
        C1896jr jrVar;
        int a = C1650d.m4333a();
        if (a == 0 || a == 2) {
            jrVar = C1650d.m4340c() ? new C1728ez() : new C1725ey();
        } else {
            jrVar = null;
        }
        this.f4348d = jrVar;
        this.f4347c = new C1900jv(this.f4348d);
    }

    /* renamed from: a */
    public static synchronized C1735fb m4502a() {
        C1735fb fbVar;
        synchronized (C1735fb.class) {
            if (f4345a == null) {
                f4345a = new C1735fb();
            }
            fbVar = f4345a;
        }
        return fbVar;
    }

    /* renamed from: a */
    public final void mo11504a(C1895jq jqVar) {
        if (jqVar != null) {
            this.f4346b.mo11507a(jqVar);
        } else {
            C1648cy.m4317a(5, "StreamingManager", "sendFrameToStreaming failed -- message is null");
        }
    }

    /* renamed from: b */
    public static void m4503b() {
        C1735fb fbVar = f4345a;
        if (fbVar != null) {
            C1900jv jvVar = fbVar.f4347c;
            if (jvVar != null) {
                jvVar.f4696a.stopWatching();
                jvVar.f4697b = null;
                fbVar.f4347c = null;
            }
            C1744fi fiVar = fbVar.f4346b;
            if (fiVar != null) {
                fiVar.f4360a.mo11518b();
                fiVar.f4360a = null;
                fbVar.f4346b = null;
            }
            f4345a = null;
        }
    }
}
