package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p021a.C0737e;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.h */
public class C0868h {

    /* renamed from: a */
    private final C1062k f1221a;

    /* renamed from: b */
    private final C1107r f1222b;

    /* renamed from: c */
    private final Object f1223c = new Object();

    /* renamed from: d */
    private final Map<String, Class<? extends MaxAdapter>> f1224d = new HashMap();

    /* renamed from: e */
    private final Set<String> f1225e = new HashSet();

    /* renamed from: f */
    private final Object f1226f = new Object();

    /* renamed from: g */
    private final Set<C0869a> f1227g = new HashSet();

    /* renamed from: com.applovin.impl.mediation.h$a */
    private static class C0869a {

        /* renamed from: a */
        private final String f1228a;

        /* renamed from: b */
        private final String f1229b;

        /* renamed from: c */
        private final MaxAdFormat f1230c;

        /* renamed from: d */
        private final JSONObject f1231d;

        C0869a(String str, String str2, C0733a aVar, C1062k kVar) {
            this.f1228a = str;
            this.f1229b = str2;
            JSONObject jSONObject = new JSONObject();
            this.f1231d = jSONObject;
            C1123j.m2584a(jSONObject, "class", str, kVar);
            C1123j.m2584a(jSONObject, "operation", str2, kVar);
            if (aVar != null) {
                this.f1230c = aVar.getFormat();
                if (aVar.getFormat() != null) {
                    C1123j.m2584a(jSONObject, "format", aVar.getFormat().getLabel(), kVar);
                    return;
                }
                return;
            }
            this.f1230c = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public JSONObject mo8752a() {
            return this.f1231d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0869a aVar = (C0869a) obj;
            if (!this.f1228a.equals(aVar.f1228a) || !this.f1229b.equals(aVar.f1229b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.f1230c;
            MaxAdFormat maxAdFormat2 = aVar.f1230c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int hashCode = ((this.f1228a.hashCode() * 31) + this.f1229b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.f1230c;
            return hashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f1228a + '\'' + ", operationTag='" + this.f1229b + '\'' + ", format=" + this.f1230c + '}';
        }
    }

    public C0868h(C1062k kVar) {
        if (kVar != null) {
            this.f1221a = kVar;
            this.f1222b = kVar.mo9411z();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C0870i m1416a(C0737e eVar, Class<? extends MaxAdapter> cls) {
        try {
            return new C0870i(eVar, (MediationAdapterBase) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{this.f1221a.mo9347X()}), this.f1221a);
        } catch (Throwable th) {
            C1107r.m2480c("MediationAdapterManager", "Failed to load adapter: " + eVar, th);
            return null;
        }
    }

    /* renamed from: a */
    private Class<? extends MaxAdapter> m1417a(String str) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return cls2.asSubclass(cls);
            }
            C1107r.m2484i("MediationAdapterManager", str + " error: not an instance of '" + cls.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0870i mo8747a(C0737e eVar) {
        Class<? extends MaxAdapter> cls;
        if (eVar != null) {
            String J = eVar.mo8443J();
            String I = eVar.mo8442I();
            if (TextUtils.isEmpty(J)) {
                C1107r rVar = this.f1222b;
                rVar.mo9588e("MediationAdapterManager", "No adapter name provided for " + I + ", not loading the adapter ");
                return null;
            } else if (TextUtils.isEmpty(I)) {
                C1107r rVar2 = this.f1222b;
                rVar2.mo9588e("MediationAdapterManager", "Unable to find default className for '" + J + "'");
                return null;
            } else {
                synchronized (this.f1223c) {
                    if (!this.f1225e.contains(I)) {
                        if (this.f1224d.containsKey(I)) {
                            cls = this.f1224d.get(I);
                        } else {
                            cls = m1417a(I);
                            if (cls == null) {
                                this.f1225e.add(I);
                                return null;
                            }
                        }
                        C0870i a = m1416a(eVar, cls);
                        if (a != null) {
                            C1107r rVar3 = this.f1222b;
                            rVar3.mo9584b("MediationAdapterManager", "Loaded " + J);
                            this.f1224d.put(I, cls);
                            return a;
                        }
                        C1107r rVar4 = this.f1222b;
                        rVar4.mo9588e("MediationAdapterManager", "Failed to load " + J);
                        this.f1225e.add(I);
                        return null;
                    }
                    C1107r rVar5 = this.f1222b;
                    rVar5.mo9584b("MediationAdapterManager", "Not attempting to load " + J + " due to prior errors");
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("No adapter spec specified");
        }
    }

    /* renamed from: a */
    public Collection<String> mo8748a() {
        Set unmodifiableSet;
        synchronized (this.f1223c) {
            HashSet hashSet = new HashSet(this.f1224d.size());
            for (Class<? extends MaxAdapter> name : this.f1224d.values()) {
                hashSet.add(name.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    /* renamed from: a */
    public void mo8749a(String str, String str2, C0733a aVar) {
        synchronized (this.f1226f) {
            C1107r z = this.f1221a.mo9411z();
            z.mo9588e("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            this.f1227g.add(new C0869a(str, str2, aVar, this.f1221a));
        }
    }

    /* renamed from: b */
    public Collection<String> mo8750b() {
        Set<T> unmodifiableSet;
        synchronized (this.f1223c) {
            unmodifiableSet = Collections.unmodifiableSet(this.f1225e);
        }
        return unmodifiableSet;
    }

    /* renamed from: c */
    public Collection<JSONObject> mo8751c() {
        ArrayList arrayList;
        synchronized (this.f1226f) {
            arrayList = new ArrayList(this.f1227g.size());
            for (C0869a a : this.f1227g) {
                arrayList.add(a.mo8752a());
            }
        }
        return arrayList;
    }
}
