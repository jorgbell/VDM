package com.applovin.impl.sdk;

import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.applovin.impl.sdk.t */
class C1110t {

    /* renamed from: a */
    private final Queue<AppLovinAdBase> f2381a = new LinkedList();

    /* renamed from: b */
    private final Object f2382b = new Object();

    C1110t() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo9592a() {
        int size;
        synchronized (this.f2382b) {
            size = this.f2381a.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9593a(AppLovinAdBase appLovinAdBase) {
        synchronized (this.f2382b) {
            if (mo9592a() <= 25) {
                this.f2381a.offer(appLovinAdBase);
            } else {
                C1107r.m2484i("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9594b() {
        boolean z;
        synchronized (this.f2382b) {
            z = mo9592a() == 0;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public AppLovinAdBase mo9595c() {
        AppLovinAdBase poll;
        synchronized (this.f2382b) {
            poll = !mo9594b() ? this.f2381a.poll() : null;
        }
        return poll;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public AppLovinAdBase mo9596d() {
        AppLovinAdBase peek;
        synchronized (this.f2382b) {
            peek = this.f2381a.peek();
        }
        return peek;
    }
}
