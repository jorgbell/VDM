package com.applovin.impl.sdk.network;

import android.os.Bundle;

/* renamed from: com.applovin.impl.sdk.network.h */
public class C1099h {

    /* renamed from: a */
    private final Bundle f2352a;

    /* renamed from: com.applovin.impl.sdk.network.h$a */
    public static class C1101a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Bundle f2353a;

        public C1101a() {
            this((C1099h) null);
        }

        public C1101a(C1099h hVar) {
            this.f2353a = new Bundle();
            if (hVar != null) {
                for (String str : hVar.mo9550a().keySet()) {
                    mo9553a(str, hVar.mo9550a().getString(str));
                }
            }
        }

        /* renamed from: a */
        public C1101a mo9552a(String str) {
            if (str != null) {
                this.f2353a.remove(str);
                return this;
            }
            throw new IllegalArgumentException("No key specified.");
        }

        /* renamed from: a */
        public C1101a mo9553a(String str, String str2) {
            if (str != null) {
                this.f2353a.putString(str, str2);
                return this;
            }
            throw new IllegalArgumentException("No key specified");
        }

        /* renamed from: a */
        public C1099h mo9554a() {
            return new C1099h(this);
        }
    }

    private C1099h(C1101a aVar) {
        this.f2352a = new Bundle(aVar.f2353a);
    }

    /* renamed from: a */
    public Bundle mo9550a() {
        return this.f2352a;
    }

    public String toString() {
        return "RequestParameters{extraParameters=" + this.f2352a + '}';
    }
}
