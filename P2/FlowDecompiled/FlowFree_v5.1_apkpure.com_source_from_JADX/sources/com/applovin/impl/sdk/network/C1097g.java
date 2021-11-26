package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0965b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.g */
public class C1097g<T> extends C1085b {

    /* renamed from: a */
    private String f2348a;

    /* renamed from: b */
    private boolean f2349b;

    /* renamed from: com.applovin.impl.sdk.network.g$a */
    public static class C1098a<T> extends C1085b.C1086a<T> {
        /* access modifiers changed from: private */

        /* renamed from: p */
        public String f2350p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public boolean f2351q;

        public C1098a(C1062k kVar) {
            super(kVar);
            this.f2302h = ((Integer) kVar.mo9350a(C0965b.f1691cK)).intValue();
            this.f2303i = ((Integer) kVar.mo9350a(C0965b.f1690cJ)).intValue();
            this.f2304j = ((Integer) kVar.mo9350a(C0965b.f1695cO)).intValue();
        }

        /* renamed from: b */
        public C1098a mo9480a(T t) {
            this.f2301g = t;
            return this;
        }

        /* renamed from: b */
        public C1098a mo9483a(JSONObject jSONObject) {
            this.f2300f = jSONObject;
            return this;
        }

        /* renamed from: b */
        public C1097g<T> mo9485a() {
            return new C1097g<>(this);
        }

        /* renamed from: c */
        public C1098a mo9482a(Map<String, String> map) {
            this.f2298d = map;
            return this;
        }

        /* renamed from: d */
        public C1098a mo9479a(int i) {
            this.f2302h = i;
            return this;
        }

        /* renamed from: d */
        public C1098a mo9481a(String str) {
            this.f2296b = str;
            return this;
        }

        /* renamed from: d */
        public C1098a mo9488b(Map<String, String> map) {
            this.f2299e = map;
            return this;
        }

        /* renamed from: e */
        public C1098a mo9486b(int i) {
            this.f2303i = i;
            return this;
        }

        /* renamed from: e */
        public C1098a mo9491c(String str) {
            this.f2297c = str;
            return this;
        }

        /* renamed from: f */
        public C1098a mo9490c(int i) {
            this.f2304j = i;
            return this;
        }

        /* renamed from: f */
        public C1098a mo9487b(String str) {
            this.f2295a = str;
            return this;
        }

        /* renamed from: f */
        public C1098a mo9492c(boolean z) {
            this.f2307m = z;
            return this;
        }

        /* renamed from: g */
        public C1098a mo9547g(String str) {
            this.f2350p = str;
            return this;
        }

        /* renamed from: g */
        public C1098a mo9493d(boolean z) {
            this.f2308n = z;
            return this;
        }

        /* renamed from: h */
        public C1098a mo9549h(boolean z) {
            this.f2351q = z;
            return this;
        }
    }

    protected C1097g(C1098a aVar) {
        super(aVar);
        this.f2348a = aVar.f2350p;
        this.f2349b = aVar.f2351q;
    }

    /* renamed from: b */
    public static C1098a m2402b(C1062k kVar) {
        return new C1098a(kVar);
    }

    /* renamed from: q */
    public boolean mo9532q() {
        return this.f2348a != null;
    }

    /* renamed from: r */
    public String mo9533r() {
        return this.f2348a;
    }

    /* renamed from: s */
    public boolean mo9534s() {
        return this.f2349b;
    }
}
