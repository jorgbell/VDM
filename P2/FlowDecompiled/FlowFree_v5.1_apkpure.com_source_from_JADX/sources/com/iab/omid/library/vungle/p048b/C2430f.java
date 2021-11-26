package com.iab.omid.library.vungle.p048b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.vungle.adsession.C2421a;
import com.iab.omid.library.vungle.p047a.C2417b;
import com.iab.omid.library.vungle.p047a.C2418c;
import com.iab.omid.library.vungle.p047a.C2419d;
import com.iab.omid.library.vungle.p047a.C2420e;
import com.iab.omid.library.vungle.p048b.C2424b;
import com.iab.omid.library.vungle.walking.TreeWalker;

/* renamed from: com.iab.omid.library.vungle.b.f */
public class C2430f implements C2418c, C2424b.C2425a {

    /* renamed from: a */
    private static C2430f f5483a;

    /* renamed from: b */
    private float f5484b = 0.0f;

    /* renamed from: c */
    private final C2420e f5485c;

    /* renamed from: d */
    private final C2417b f5486d;

    /* renamed from: e */
    private C2419d f5487e;

    /* renamed from: f */
    private C2423a f5488f;

    public C2430f(C2420e eVar, C2417b bVar) {
        this.f5485c = eVar;
        this.f5486d = bVar;
    }

    /* renamed from: a */
    public static C2430f m5747a() {
        if (f5483a == null) {
            f5483a = new C2430f(new C2420e(), new C2417b());
        }
        return f5483a;
    }

    /* renamed from: e */
    private C2423a m5748e() {
        if (this.f5488f == null) {
            this.f5488f = C2423a.m5714a();
        }
        return this.f5488f;
    }

    /* renamed from: a */
    public void mo24131a(float f) {
        this.f5484b = f;
        for (C2421a adSessionStatePublisher : m5748e().mo24169c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo24206a(f);
        }
    }

    /* renamed from: a */
    public void mo24195a(Context context) {
        this.f5487e = this.f5485c.mo24135a(new Handler(), context, this.f5486d.mo24130a(), this);
    }

    /* renamed from: b */
    public void mo24196b() {
        C2424b.m5721a().mo24173a((C2424b.C2425a) this);
        C2424b.m5721a().mo24174b();
        if (C2424b.m5721a().mo24176d()) {
            TreeWalker.getInstance().mo24221a();
        }
        this.f5487e.mo24132a();
    }

    /* renamed from: c */
    public void mo24197c() {
        TreeWalker.getInstance().mo24222b();
        C2424b.m5721a().mo24175c();
        this.f5487e.mo24133b();
    }

    /* renamed from: d */
    public float mo24198d() {
        return this.f5484b;
    }
}
