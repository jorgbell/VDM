package com.applovin.impl.p018a;

import android.net.Uri;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.b */
public class C0541b {

    /* renamed from: a */
    private int f169a;

    /* renamed from: b */
    private int f170b;

    /* renamed from: c */
    private Uri f171c;

    /* renamed from: d */
    private C0544e f172d;

    /* renamed from: e */
    private Set<C0547g> f173e = new HashSet();

    /* renamed from: f */
    private Map<String, Set<C0547g>> f174f = new HashMap();

    private C0541b() {
    }

    /* renamed from: a */
    public static C0541b m252a(C1166t tVar, C0541b bVar, C0542c cVar, C1062k kVar) {
        C1166t b;
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (kVar != null) {
            if (bVar == null) {
                try {
                    bVar = new C0541b();
                } catch (Throwable th) {
                    kVar.mo9411z().mo9585b("VastCompanionAd", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (bVar.f169a == 0 && bVar.f170b == 0) {
                int a = C1155o.m2660a(tVar.mo9699b().get("width"));
                int a2 = C1155o.m2660a(tVar.mo9699b().get("height"));
                if (a > 0 && a2 > 0) {
                    bVar.f169a = a;
                    bVar.f170b = a2;
                }
            }
            bVar.f172d = C0544e.m266a(tVar, bVar.f172d, kVar);
            if (bVar.f171c == null && (b = tVar.mo9698b("CompanionClickThrough")) != null) {
                String c = b.mo9701c();
                if (C1155o.m2673b(c)) {
                    bVar.f171c = Uri.parse(c);
                }
            }
            C0549i.m290a(tVar.mo9697a("CompanionClickTracking"), bVar.f173e, cVar, kVar);
            C0549i.m289a(tVar, bVar.f174f, cVar, kVar);
            return bVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo7854a() {
        return this.f171c;
    }

    /* renamed from: b */
    public C0544e mo7855b() {
        return this.f172d;
    }

    /* renamed from: c */
    public Set<C0547g> mo7856c() {
        return this.f173e;
    }

    /* renamed from: d */
    public Map<String, Set<C0547g>> mo7857d() {
        return this.f174f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0541b)) {
            return false;
        }
        C0541b bVar = (C0541b) obj;
        if (this.f169a != bVar.f169a || this.f170b != bVar.f170b) {
            return false;
        }
        Uri uri = this.f171c;
        if (uri == null ? bVar.f171c != null : !uri.equals(bVar.f171c)) {
            return false;
        }
        C0544e eVar = this.f172d;
        if (eVar == null ? bVar.f172d != null : !eVar.equals(bVar.f172d)) {
            return false;
        }
        Set<C0547g> set = this.f173e;
        if (set == null ? bVar.f173e != null : !set.equals(bVar.f173e)) {
            return false;
        }
        Map<String, Set<C0547g>> map = this.f174f;
        Map<String, Set<C0547g>> map2 = bVar.f174f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i = ((this.f169a * 31) + this.f170b) * 31;
        Uri uri = this.f171c;
        int i2 = 0;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        C0544e eVar = this.f172d;
        int hashCode2 = (hashCode + (eVar != null ? eVar.hashCode() : 0)) * 31;
        Set<C0547g> set = this.f173e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C0547g>> map = this.f174f;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f169a + ", height=" + this.f170b + ", destinationUri=" + this.f171c + ", nonVideoResource=" + this.f172d + ", clickTrackers=" + this.f173e + ", eventTrackers=" + this.f174f + '}';
    }
}
