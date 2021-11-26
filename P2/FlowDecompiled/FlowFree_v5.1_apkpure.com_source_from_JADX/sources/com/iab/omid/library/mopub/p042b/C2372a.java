package com.iab.omid.library.mopub.p042b;

import com.iab.omid.library.mopub.adsession.C2370a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.mopub.b.a */
public class C2372a {

    /* renamed from: a */
    private static C2372a f5362a = new C2372a();

    /* renamed from: b */
    private final ArrayList<C2370a> f5363b = new ArrayList<>();

    /* renamed from: c */
    private final ArrayList<C2370a> f5364c = new ArrayList<>();

    private C2372a() {
    }

    /* renamed from: a */
    public static C2372a m5503a() {
        return f5362a;
    }

    /* renamed from: a */
    public void mo24020a(C2370a aVar) {
        this.f5363b.add(aVar);
    }

    /* renamed from: b */
    public Collection<C2370a> mo24021b() {
        return Collections.unmodifiableCollection(this.f5363b);
    }

    /* renamed from: b */
    public void mo24022b(C2370a aVar) {
        boolean d = mo24025d();
        this.f5364c.add(aVar);
        if (!d) {
            C2380f.m5545a().mo24056b();
        }
    }

    /* renamed from: c */
    public Collection<C2370a> mo24023c() {
        return Collections.unmodifiableCollection(this.f5364c);
    }

    /* renamed from: c */
    public void mo24024c(C2370a aVar) {
        boolean d = mo24025d();
        this.f5363b.remove(aVar);
        this.f5364c.remove(aVar);
        if (d && !mo24025d()) {
            C2380f.m5545a().mo24057c();
        }
    }

    /* renamed from: d */
    public boolean mo24025d() {
        return this.f5364c.size() > 0;
    }
}
