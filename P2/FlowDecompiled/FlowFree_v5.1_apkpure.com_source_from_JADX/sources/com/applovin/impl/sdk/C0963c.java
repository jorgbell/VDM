package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.p035a.C0940h;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.c */
public class C0963c {

    /* renamed from: a */
    private final C1062k f1518a;

    /* renamed from: b */
    private final C1107r f1519b;

    /* renamed from: c */
    private final Object f1520c = new Object();

    /* renamed from: d */
    private final Map<C0928d, C1110t> f1521d = new HashMap();

    /* renamed from: e */
    private final Map<C0928d, C1110t> f1522e = new HashMap();

    C0963c(C1062k kVar) {
        this.f1518a = kVar;
        this.f1519b = kVar.mo9411z();
        for (C0928d next : C0928d.m1542a(kVar)) {
            this.f1521d.put(next, new C1110t());
            this.f1522e.put(next, new C1110t());
        }
    }

    /* renamed from: e */
    private C1110t m1738e(C0928d dVar) {
        C1110t tVar;
        synchronized (this.f1520c) {
            tVar = this.f1521d.get(dVar);
            if (tVar == null) {
                tVar = new C1110t();
                this.f1521d.put(dVar, tVar);
            }
        }
        return tVar;
    }

    /* renamed from: f */
    private C1110t m1739f(C0928d dVar) {
        C1110t tVar;
        synchronized (this.f1520c) {
            tVar = this.f1522e.get(dVar);
            if (tVar == null) {
                tVar = new C1110t();
                this.f1522e.put(dVar, tVar);
            }
        }
        return tVar;
    }

    /* renamed from: g */
    private C1110t m1740g(C0928d dVar) {
        synchronized (this.f1520c) {
            C1110t f = m1739f(dVar);
            if (f.mo9592a() > 0) {
                return f;
            }
            C1110t e = m1738e(dVar);
            return e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9111a(AppLovinAdBase appLovinAdBase) {
        synchronized (this.f1520c) {
            m1738e(appLovinAdBase.getAdZone()).mo9593a(appLovinAdBase);
            C1107r rVar = this.f1519b;
            rVar.mo9584b("AdPreloadManager", "Ad enqueued: " + appLovinAdBase);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9112a(com.applovin.impl.sdk.p035a.C0928d r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1520c
            monitor-enter(r0)
            com.applovin.impl.sdk.t r1 = r3.m1739f(r4)     // Catch:{ all -> 0x001e }
            int r1 = r1.mo9592a()     // Catch:{ all -> 0x001e }
            r2 = 1
            if (r1 <= 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r2
        L_0x0010:
            com.applovin.impl.sdk.t r4 = r3.m1738e(r4)     // Catch:{ all -> 0x001e }
            int r4 = r4.mo9592a()     // Catch:{ all -> 0x001e }
            if (r4 <= 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r2
        L_0x001e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0963c.mo9112a(com.applovin.impl.sdk.a.d):boolean");
    }

    /* renamed from: b */
    public AppLovinAdBase mo9113b(C0928d dVar) {
        C0940h hVar;
        StringBuilder sb;
        String str;
        synchronized (this.f1520c) {
            C1110t e = m1738e(dVar);
            if (e.mo9592a() > 0) {
                m1739f(dVar).mo9593a(e.mo9595c());
                hVar = new C0940h(dVar, this.f1518a);
            } else {
                hVar = null;
            }
        }
        C1107r rVar = this.f1519b;
        if (hVar != null) {
            str = "Retrieved ad of zone ";
        } else {
            sb = new StringBuilder();
            str = "Unable to retrieve ad of zone ";
        }
        sb.append(str);
        sb.append(dVar);
        sb.append("...");
        rVar.mo9584b("AdPreloadManager", sb.toString());
        return hVar;
    }

    /* renamed from: c */
    public AppLovinAdBase mo9114c(C0928d dVar) {
        AppLovinAdBase c;
        synchronized (this.f1520c) {
            c = m1740g(dVar).mo9595c();
        }
        return c;
    }

    /* renamed from: d */
    public AppLovinAdBase mo9115d(C0928d dVar) {
        AppLovinAdBase d;
        synchronized (this.f1520c) {
            d = m1740g(dVar).mo9596d();
        }
        return d;
    }
}
