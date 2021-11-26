package com.flurry.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.ak */
public final class C1501ak {

    /* renamed from: a */
    protected Map<C1502al, String> f3769a;

    /* renamed from: b */
    public boolean f3770b;

    C1501ak() {
        this.f3769a = new HashMap();
    }

    private C1501ak(Map<C1502al, String> map, boolean z) {
        this.f3769a = map;
        this.f3770b = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo11284a(C1502al alVar, String str) {
        this.f3769a.put(alVar, str);
    }

    /* renamed from: a */
    public final Map<C1502al, String> mo11283a() {
        return this.f3769a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3769a);
        sb.append(this.f3770b);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C1501ak mo11285b() {
        return new C1501ak(Collections.unmodifiableMap(this.f3769a), this.f3770b);
    }
}
