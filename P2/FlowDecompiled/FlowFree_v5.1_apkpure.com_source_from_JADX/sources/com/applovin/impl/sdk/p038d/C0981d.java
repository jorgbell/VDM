package com.applovin.impl.sdk.p038d;

import android.annotation.TargetApi;
import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p038d.C0975c;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1120h;

/* renamed from: com.applovin.impl.sdk.d.d */
public class C0981d {

    /* renamed from: a */
    private final C1062k f1933a;

    /* renamed from: b */
    private final C0987h f1934b;

    /* renamed from: c */
    private final C0975c.C0979b f1935c;

    /* renamed from: d */
    private final Object f1936d = new Object();

    /* renamed from: e */
    private final long f1937e;

    /* renamed from: f */
    private long f1938f;

    /* renamed from: g */
    private long f1939g;

    /* renamed from: h */
    private long f1940h;

    public C0981d(AppLovinAdBase appLovinAdBase, C1062k kVar) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (kVar != null) {
            this.f1933a = kVar;
            this.f1934b = kVar.mo9341R();
            C0975c.C0979b a = kVar.mo9367ab().mo9158a(appLovinAdBase);
            this.f1935c = a;
            a.mo9167a(C0974b.f1893a, (long) appLovinAdBase.getSource().ordinal()).mo9169a();
            this.f1937e = appLovinAdBase.getCreatedAtMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static void m1830a(long j, AppLovinAdBase appLovinAdBase, C1062k kVar) {
        if (appLovinAdBase != null && kVar != null) {
            kVar.mo9367ab().mo9158a(appLovinAdBase).mo9167a(C0974b.f1894b, j).mo9169a();
        }
    }

    /* renamed from: a */
    public static void m1831a(AppLovinAdBase appLovinAdBase, C1062k kVar) {
        if (appLovinAdBase != null && kVar != null) {
            kVar.mo9367ab().mo9158a(appLovinAdBase).mo9167a(C0974b.f1895c, appLovinAdBase.getFetchLatencyMillis()).mo9167a(C0974b.f1896d, appLovinAdBase.getFetchResponseSize()).mo9169a();
        }
    }

    /* renamed from: a */
    private void m1832a(C0974b bVar) {
        synchronized (this.f1936d) {
            if (this.f1938f > 0) {
                this.f1935c.mo9167a(bVar, System.currentTimeMillis() - this.f1938f).mo9169a();
            }
        }
    }

    /* renamed from: a */
    public static void m1833a(C0982e eVar, AppLovinAdBase appLovinAdBase, C1062k kVar) {
        if (appLovinAdBase != null && kVar != null && eVar != null) {
            kVar.mo9367ab().mo9158a(appLovinAdBase).mo9167a(C0974b.f1897e, eVar.mo9186c()).mo9167a(C0974b.f1898f, eVar.mo9187d()).mo9167a(C0974b.f1913u, eVar.mo9190g()).mo9167a(C0974b.f1914v, eVar.mo9191h()).mo9167a(C0974b.f1915w, eVar.mo9185b() ? 1 : 0).mo9169a();
        }
    }

    @TargetApi(24)
    /* renamed from: a */
    public void mo9171a() {
        this.f1935c.mo9167a(C0974b.f1902j, this.f1934b.mo9199a(C0986g.f1955b)).mo9167a(C0974b.f1901i, this.f1934b.mo9199a(C0986g.f1957d));
        synchronized (this.f1936d) {
            long j = 0;
            if (this.f1937e > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f1938f = currentTimeMillis;
                long M = currentTimeMillis - this.f1933a.mo9336M();
                long j2 = this.f1938f - this.f1937e;
                long j3 = C1120h.m2544a(this.f1933a.mo9334J()) ? 1 : 0;
                Activity a = this.f1933a.mo9370ae().mo8944a();
                if (C1119g.m2533f() && a != null && a.isInMultiWindowMode()) {
                    j = 1;
                }
                this.f1935c.mo9167a(C0974b.f1900h, M).mo9167a(C0974b.f1899g, j2).mo9167a(C0974b.f1908p, j3).mo9167a(C0974b.f1916x, j);
            }
        }
        this.f1935c.mo9169a();
    }

    /* renamed from: a */
    public void mo9172a(long j) {
        this.f1935c.mo9167a(C0974b.f1910r, j).mo9169a();
    }

    /* renamed from: b */
    public void mo9173b() {
        synchronized (this.f1936d) {
            if (this.f1939g < 1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f1939g = currentTimeMillis;
                long j = this.f1938f;
                if (j > 0) {
                    this.f1935c.mo9167a(C0974b.f1905m, currentTimeMillis - j).mo9169a();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo9174b(long j) {
        this.f1935c.mo9167a(C0974b.f1909q, j).mo9169a();
    }

    /* renamed from: c */
    public void mo9175c() {
        m1832a(C0974b.f1903k);
    }

    /* renamed from: c */
    public void mo9176c(long j) {
        this.f1935c.mo9167a(C0974b.f1911s, j).mo9169a();
    }

    /* renamed from: d */
    public void mo9177d() {
        m1832a(C0974b.f1906n);
    }

    /* renamed from: d */
    public void mo9178d(long j) {
        synchronized (this.f1936d) {
            if (this.f1940h < 1) {
                this.f1940h = j;
                this.f1935c.mo9167a(C0974b.f1912t, j).mo9169a();
            }
        }
    }

    /* renamed from: e */
    public void mo9179e() {
        m1832a(C0974b.f1907o);
    }

    /* renamed from: f */
    public void mo9180f() {
        m1832a(C0974b.f1904l);
    }

    /* renamed from: g */
    public void mo9181g() {
        this.f1935c.mo9166a(C0974b.f1917y).mo9169a();
    }
}
