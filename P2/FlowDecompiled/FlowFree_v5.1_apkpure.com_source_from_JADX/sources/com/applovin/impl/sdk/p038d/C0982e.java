package com.applovin.impl.sdk.p038d;

/* renamed from: com.applovin.impl.sdk.d.e */
public final class C0982e {

    /* renamed from: a */
    private long f1941a;

    /* renamed from: b */
    private long f1942b;

    /* renamed from: c */
    private boolean f1943c;

    /* renamed from: d */
    private long f1944d;

    /* renamed from: e */
    private long f1945e;

    /* renamed from: a */
    public void mo9182a() {
        this.f1943c = true;
    }

    /* renamed from: a */
    public void mo9183a(long j) {
        this.f1941a += j;
    }

    /* renamed from: b */
    public void mo9184b(long j) {
        this.f1942b += j;
    }

    /* renamed from: b */
    public boolean mo9185b() {
        return this.f1943c;
    }

    /* renamed from: c */
    public long mo9186c() {
        return this.f1941a;
    }

    /* renamed from: d */
    public long mo9187d() {
        return this.f1942b;
    }

    /* renamed from: e */
    public void mo9188e() {
        this.f1944d++;
    }

    /* renamed from: f */
    public void mo9189f() {
        this.f1945e++;
    }

    /* renamed from: g */
    public long mo9190g() {
        return this.f1944d;
    }

    /* renamed from: h */
    public long mo9191h() {
        return this.f1945e;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.f1941a + ", totalCachedBytes=" + this.f1942b + ", isHTMLCachingCancelled=" + this.f1943c + ", htmlResourceCacheSuccessCount=" + this.f1944d + ", htmlResourceCacheFailureCount=" + this.f1945e + '}';
    }
}
