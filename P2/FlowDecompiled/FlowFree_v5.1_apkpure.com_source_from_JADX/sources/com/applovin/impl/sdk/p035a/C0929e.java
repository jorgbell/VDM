package com.applovin.impl.sdk.p035a;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.e */
public class C0929e {

    /* renamed from: a */
    private final C1062k f1413a;

    /* renamed from: b */
    private final C1107r f1414b;

    /* renamed from: c */
    private final AtomicBoolean f1415c;

    /* renamed from: d */
    private final Map<MaxAdFormat, C0930f> f1416d;

    /* renamed from: e */
    private LinkedHashSet<C0928d> f1417e = new LinkedHashSet<>();

    /* renamed from: f */
    private final Object f1418f = new Object();

    /* renamed from: g */
    private volatile boolean f1419g;

    public C0929e(C1062k kVar) {
        this.f1413a = kVar;
        this.f1414b = kVar.mo9411z();
        this.f1415c = new AtomicBoolean();
        HashMap hashMap = new HashMap(5);
        this.f1416d = hashMap;
        MaxAdFormat maxAdFormat = MaxAdFormat.BANNER;
        hashMap.put(maxAdFormat, new C0930f(maxAdFormat, kVar));
        MaxAdFormat maxAdFormat2 = MaxAdFormat.LEADER;
        hashMap.put(maxAdFormat2, new C0930f(maxAdFormat2, kVar));
        MaxAdFormat maxAdFormat3 = MaxAdFormat.MREC;
        hashMap.put(maxAdFormat3, new C0930f(maxAdFormat3, kVar));
        MaxAdFormat maxAdFormat4 = MaxAdFormat.INTERSTITIAL;
        hashMap.put(maxAdFormat4, new C0930f(maxAdFormat4, kVar));
        MaxAdFormat maxAdFormat5 = MaxAdFormat.REWARDED;
        hashMap.put(maxAdFormat5, new C0930f(maxAdFormat5, kVar));
        MaxAdFormat maxAdFormat6 = MaxAdFormat.REWARDED_INTERSTITIAL;
        hashMap.put(maxAdFormat6, new C0930f(maxAdFormat6, kVar));
    }

    /* renamed from: a */
    private boolean m1555a() {
        return ((Boolean) this.f1413a.mo9350a(C0965b.f1799eO)).booleanValue() && this.f1415c.get();
    }

    /* renamed from: c */
    private LinkedHashSet<C0928d> m1556c(JSONArray jSONArray) {
        LinkedHashSet<C0928d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject a = C1123j.m2581a(jSONArray, i, (JSONObject) null, this.f1413a);
            linkedHashSet.add(C0928d.m1541a(C1123j.m2594b(a, "id", (String) null, this.f1413a), a, this.f1413a));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public void mo8980a(AppLovinAdBase appLovinAdBase, boolean z, boolean z2) {
        if (m1555a()) {
            this.f1416d.get(appLovinAdBase.getAdZone().mo8973b()).mo8986a(appLovinAdBase, z, z2);
        }
    }

    /* renamed from: a */
    public void mo8981a(C0928d dVar, boolean z, int i) {
        if (m1555a()) {
            MaxAdFormat b = dVar.mo8973b();
            if (b != null) {
                this.f1416d.get(b).mo8987a(dVar, z, i);
            } else {
                C0930f.m1564a(dVar, i, this.f1413a);
            }
        }
    }

    /* renamed from: a */
    public void mo8982a(C0934g gVar) {
        if (m1555a()) {
            this.f1416d.get(gVar.getAdZone().mo8973b()).mo8985a();
        }
    }

    /* renamed from: a */
    public void mo8983a(JSONArray jSONArray) {
        if (((Boolean) this.f1413a.mo9350a(C0965b.f1799eO)).booleanValue()) {
            if (this.f1415c.compareAndSet(false, true)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject a = C1123j.m2581a(jSONArray, i, (JSONObject) null, this.f1413a);
                    C0928d a2 = C0928d.m1541a(C1123j.m2594b(a, "id", (String) null, this.f1413a), a, this.f1413a);
                    MaxAdFormat b = a2.mo8973b();
                    if (b == MaxAdFormat.BANNER) {
                        arrayList.add(a2);
                    } else if (b == MaxAdFormat.LEADER) {
                        arrayList2.add(a2);
                    } else if (b == MaxAdFormat.MREC) {
                        arrayList3.add(a2);
                    } else if (b == MaxAdFormat.INTERSTITIAL) {
                        arrayList4.add(a2);
                    } else if (b == MaxAdFormat.REWARDED_INTERSTITIAL) {
                        arrayList6.add(a2);
                    } else if (b == MaxAdFormat.REWARDED) {
                        arrayList5.add(a2);
                    }
                }
                this.f1416d.get(MaxAdFormat.BANNER).mo8988a((List<C0928d>) arrayList);
                this.f1416d.get(MaxAdFormat.LEADER).mo8988a((List<C0928d>) arrayList2);
                this.f1416d.get(MaxAdFormat.MREC).mo8988a((List<C0928d>) arrayList3);
                this.f1416d.get(MaxAdFormat.INTERSTITIAL).mo8988a((List<C0928d>) arrayList4);
                this.f1416d.get(MaxAdFormat.REWARDED).mo8988a((List<C0928d>) arrayList5);
                this.f1416d.get(MaxAdFormat.REWARDED_INTERSTITIAL).mo8988a((List<C0928d>) arrayList6);
            }
        }
    }

    /* renamed from: b */
    public LinkedHashSet<C0928d> mo8984b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new LinkedHashSet<>();
        }
        LinkedHashSet<C0928d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        synchronized (this.f1418f) {
            if (!this.f1419g) {
                C1107r rVar = this.f1414b;
                rVar.mo9584b("AdZoneManager", "Found " + jSONArray.length() + " zone(s)...");
                linkedHashSet = m1556c(jSONArray);
                this.f1417e = linkedHashSet;
                this.f1419g = true;
            }
        }
        return linkedHashSet;
    }
}
