package com.applovin.impl.p018a;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import com.unity3d.ads.metadata.MediationMetaData;

/* renamed from: com.applovin.impl.a.f */
public class C0546f {

    /* renamed from: a */
    private String f205a;

    /* renamed from: b */
    private String f206b;

    private C0546f() {
    }

    /* renamed from: a */
    public static C0546f m273a(C1166t tVar, C0546f fVar, C1062k kVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (kVar != null) {
            if (fVar == null) {
                try {
                    fVar = new C0546f();
                } catch (Throwable th) {
                    kVar.mo9411z().mo9585b("VastSystemInfo", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (!C1155o.m2673b(fVar.f205a)) {
                String c = tVar.mo9701c();
                if (C1155o.m2673b(c)) {
                    fVar.f205a = c;
                }
            }
            if (!C1155o.m2673b(fVar.f206b)) {
                String str = tVar.mo9699b().get(MediationMetaData.KEY_VERSION);
                if (C1155o.m2673b(str)) {
                    fVar.f206b = str;
                }
            }
            return fVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo7878a() {
        return this.f205a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0546f)) {
            return false;
        }
        C0546f fVar = (C0546f) obj;
        String str = this.f205a;
        if (str == null ? fVar.f205a != null : !str.equals(fVar.f205a)) {
            return false;
        }
        String str2 = this.f206b;
        String str3 = fVar.f206b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f205a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f206b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f205a + '\'' + ", version='" + this.f206b + '\'' + '}';
    }
}
