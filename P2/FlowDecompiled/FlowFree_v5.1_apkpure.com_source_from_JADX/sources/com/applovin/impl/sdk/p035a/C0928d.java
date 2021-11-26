package com.applovin.impl.sdk.p035a;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.d */
public final class C0928d {

    /* renamed from: a */
    private static final Map<String, C0928d> f1406a = new HashMap();

    /* renamed from: b */
    private static final Object f1407b = new Object();

    /* renamed from: c */
    private C1062k f1408c;

    /* renamed from: d */
    private JSONObject f1409d;

    /* renamed from: e */
    private final String f1410e;

    /* renamed from: f */
    private AppLovinAdSize f1411f;

    /* renamed from: g */
    private AppLovinAdType f1412g;

    private C0928d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, C1062k kVar) {
        String str2;
        if (!TextUtils.isEmpty(str) || !(appLovinAdType == null || appLovinAdSize == null)) {
            this.f1408c = kVar;
            this.f1411f = appLovinAdSize;
            this.f1412g = appLovinAdType;
            if (C1155o.m2673b(str)) {
                str2 = str.trim();
            } else {
                str2 = appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel();
            }
            this.f1410e = str2.toLowerCase(Locale.ENGLISH);
            return;
        }
        throw new IllegalArgumentException("No zone identifier or type or size specified");
    }

    /* renamed from: a */
    public static C0928d m1538a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, C1062k kVar) {
        return m1539a(appLovinAdSize, appLovinAdType, (String) null, kVar);
    }

    /* renamed from: a */
    public static C0928d m1539a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, C1062k kVar) {
        C0928d dVar = new C0928d(appLovinAdSize, appLovinAdType, str, kVar);
        synchronized (f1407b) {
            String str2 = dVar.f1410e;
            Map<String, C0928d> map = f1406a;
            if (map.containsKey(str2)) {
                dVar = map.get(str2);
            } else {
                map.put(str2, dVar);
            }
        }
        return dVar;
    }

    /* renamed from: a */
    public static C0928d m1540a(String str, C1062k kVar) {
        return m1539a((AppLovinAdSize) null, (AppLovinAdType) null, str, kVar);
    }

    /* renamed from: a */
    public static C0928d m1541a(String str, JSONObject jSONObject, C1062k kVar) {
        C0928d a = m1540a(str, kVar);
        a.f1409d = jSONObject;
        return a;
    }

    /* renamed from: a */
    public static Collection<C0928d> m1542a(C1062k kVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(5);
        Collections.addAll(linkedHashSet, new C0928d[]{m1544b(kVar), m1546c(kVar), m1547d(kVar), m1548e(kVar), m1549f(kVar)});
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: a */
    public static void m1543a(JSONObject jSONObject, C1062k kVar) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has("ad_type")) {
            synchronized (f1407b) {
                C0928d dVar = f1406a.get(C1123j.m2594b(jSONObject, "zone_id", "", kVar));
                if (dVar != null) {
                    dVar.f1411f = AppLovinAdSize.fromString(C1123j.m2594b(jSONObject, "ad_size", "", kVar));
                    dVar.f1412g = AppLovinAdType.fromString(C1123j.m2594b(jSONObject, "ad_type", "", kVar));
                }
            }
        }
    }

    /* renamed from: b */
    public static C0928d m1544b(C1062k kVar) {
        return m1538a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR, kVar);
    }

    /* renamed from: b */
    public static C0928d m1545b(String str, C1062k kVar) {
        return m1539a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str, kVar);
    }

    /* renamed from: c */
    public static C0928d m1546c(C1062k kVar) {
        return m1538a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR, kVar);
    }

    /* renamed from: d */
    public static C0928d m1547d(C1062k kVar) {
        return m1538a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR, kVar);
    }

    /* renamed from: e */
    public static C0928d m1548e(C1062k kVar) {
        return m1538a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR, kVar);
    }

    /* renamed from: f */
    public static C0928d m1549f(C1062k kVar) {
        return m1538a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, kVar);
    }

    /* renamed from: a */
    public String mo8972a() {
        return this.f1410e;
    }

    /* renamed from: b */
    public MaxAdFormat mo8973b() {
        AppLovinAdSize c = mo8974c();
        if (c == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (c == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (c == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (c == AppLovinAdSize.CROSS_PROMO) {
            return MaxAdFormat.CROSS_PROMO;
        }
        if (c != AppLovinAdSize.INTERSTITIAL) {
            return null;
        }
        if (mo8975d() == AppLovinAdType.REGULAR) {
            return MaxAdFormat.INTERSTITIAL;
        }
        if (mo8975d() == AppLovinAdType.INCENTIVIZED) {
            return MaxAdFormat.REWARDED;
        }
        if (mo8975d() == AppLovinAdType.AUTO_INCENTIVIZED) {
            return MaxAdFormat.REWARDED_INTERSTITIAL;
        }
        return null;
    }

    /* renamed from: c */
    public AppLovinAdSize mo8974c() {
        if (this.f1411f == null && C1123j.m2591a(this.f1409d, "ad_size")) {
            this.f1411f = AppLovinAdSize.fromString(C1123j.m2594b(this.f1409d, "ad_size", (String) null, this.f1408c));
        }
        return this.f1411f;
    }

    /* renamed from: d */
    public AppLovinAdType mo8975d() {
        if (this.f1412g == null && C1123j.m2591a(this.f1409d, "ad_type")) {
            this.f1412g = AppLovinAdType.fromString(C1123j.m2594b(this.f1409d, "ad_type", (String) null, this.f1408c));
        }
        return this.f1412g;
    }

    /* renamed from: e */
    public boolean mo8976e() {
        return m1542a(this.f1408c).contains(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0928d.class != obj.getClass()) {
            return false;
        }
        return this.f1410e.equalsIgnoreCase(((C0928d) obj).f1410e);
    }

    public int hashCode() {
        return this.f1410e.hashCode();
    }

    public String toString() {
        return "AdZone{id=" + this.f1410e + ", zoneObject=" + this.f1409d + '}';
    }
}
