package com.iab.omid.library.vungle.p048b;

import com.iab.omid.library.vungle.adsession.C2421a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.vungle.b.a */
public class C2423a {

    /* renamed from: a */
    private static C2423a f5469a = new C2423a();

    /* renamed from: b */
    private final ArrayList<C2421a> f5470b = new ArrayList<>();

    /* renamed from: c */
    private final ArrayList<C2421a> f5471c = new ArrayList<>();

    private C2423a() {
    }

    /* renamed from: a */
    public static C2423a m5714a() {
        return f5469a;
    }

    /* renamed from: a */
    public void mo24166a(C2421a aVar) {
        this.f5470b.add(aVar);
    }

    /* renamed from: b */
    public Collection<C2421a> mo24167b() {
        return Collections.unmodifiableCollection(this.f5470b);
    }

    /* renamed from: b */
    public void mo24168b(C2421a aVar) {
        boolean d = mo24171d();
        this.f5471c.add(aVar);
        if (!d) {
            C2430f.m5747a().mo24196b();
        }
    }

    /* renamed from: c */
    public Collection<C2421a> mo24169c() {
        return Collections.unmodifiableCollection(this.f5471c);
    }

    /* renamed from: c */
    public void mo24170c(C2421a aVar) {
        boolean d = mo24171d();
        this.f5470b.remove(aVar);
        this.f5471c.remove(aVar);
        if (d && !mo24171d()) {
            C2430f.m5747a().mo24197c();
        }
    }

    /* renamed from: d */
    public boolean mo24171d() {
        return this.f5471c.size() > 0;
    }
}
