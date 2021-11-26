package com.applovin.impl.mediation.p021a;

import com.applovin.impl.mediation.C0870i;

/* renamed from: com.applovin.impl.mediation.a.f */
public class C0738f {

    /* renamed from: a */
    private final C0740g f776a;

    /* renamed from: b */
    private final String f777b;

    /* renamed from: c */
    private final String f778c;

    /* renamed from: d */
    private final String f779d;

    /* renamed from: e */
    private final String f780e;

    /* renamed from: com.applovin.impl.mediation.a.f$a */
    public interface C0739a {
        /* renamed from: a */
        void mo8480a(C0738f fVar);
    }

    private C0738f(C0740g gVar, C0870i iVar, String str, String str2) {
        String str3;
        this.f776a = gVar;
        this.f779d = str;
        this.f780e = str2;
        if (iVar != null) {
            this.f777b = iVar.mo8766f();
            str3 = iVar.mo8767g();
        } else {
            str3 = null;
            this.f777b = null;
        }
        this.f778c = str3;
    }

    /* renamed from: a */
    public static C0738f m964a(C0740g gVar, C0870i iVar, String str) {
        if (gVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (iVar != null) {
            return new C0738f(gVar, iVar, str, (String) null);
        } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
    }

    /* renamed from: a */
    public static C0738f m965a(C0740g gVar, String str) {
        return m966b(gVar, (C0870i) null, str);
    }

    /* renamed from: b */
    public static C0738f m966b(C0740g gVar, C0870i iVar, String str) {
        if (gVar != null) {
            return new C0738f(gVar, iVar, (String) null, str);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    /* renamed from: a */
    public C0740g mo8474a() {
        return this.f776a;
    }

    /* renamed from: b */
    public String mo8475b() {
        return this.f777b;
    }

    /* renamed from: c */
    public String mo8476c() {
        return this.f778c;
    }

    /* renamed from: d */
    public String mo8477d() {
        return this.f779d;
    }

    /* renamed from: e */
    public String mo8478e() {
        return this.f780e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f776a);
        sb.append(", mSdkVersion='");
        sb.append(this.f777b);
        sb.append('\'');
        sb.append(", mAdapterVersion='");
        sb.append(this.f778c);
        sb.append('\'');
        sb.append(", mSignalDataLength='");
        String str = this.f779d;
        sb.append(str != null ? str.length() : 0);
        sb.append('\'');
        sb.append(", mErrorMessage=");
        sb.append(this.f780e);
        sb.append('}');
        return sb.toString();
    }
}
