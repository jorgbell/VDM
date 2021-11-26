package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.t */
public class C1166t {

    /* renamed from: a */
    public static final C1166t f2500a = new C1166t();

    /* renamed from: b */
    protected String f2501b;

    /* renamed from: c */
    protected final List<C1166t> f2502c;

    /* renamed from: d */
    private final C1166t f2503d;

    /* renamed from: e */
    private final String f2504e;

    /* renamed from: f */
    private final Map<String, String> f2505f;

    private C1166t() {
        this.f2503d = null;
        this.f2504e = "";
        this.f2505f = Collections.emptyMap();
        this.f2501b = "";
        this.f2502c = Collections.emptyList();
    }

    public C1166t(String str, Map<String, String> map, C1166t tVar) {
        this.f2503d = tVar;
        this.f2504e = str;
        this.f2505f = Collections.unmodifiableMap(map);
        this.f2502c = new ArrayList();
    }

    /* renamed from: a */
    public String mo9696a() {
        return this.f2504e;
    }

    /* renamed from: a */
    public List<C1166t> mo9697a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.f2502c.size());
            for (C1166t next : this.f2502c) {
                if (str.equalsIgnoreCase(next.mo9696a())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public C1166t mo9698b(String str) {
        if (str != null) {
            for (C1166t next : this.f2502c) {
                if (str.equalsIgnoreCase(next.mo9696a())) {
                    return next;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public Map<String, String> mo9699b() {
        return this.f2505f;
    }

    /* renamed from: c */
    public C1166t mo9700c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        } else if (this.f2502c.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            while (!arrayList.isEmpty()) {
                C1166t tVar = (C1166t) arrayList.get(0);
                arrayList.remove(0);
                if (str.equalsIgnoreCase(tVar.mo9696a())) {
                    return tVar;
                }
                arrayList.addAll(tVar.mo9702d());
            }
            return null;
        }
    }

    /* renamed from: c */
    public String mo9701c() {
        return this.f2501b;
    }

    /* renamed from: d */
    public List<C1166t> mo9702d() {
        return Collections.unmodifiableList(this.f2502c);
    }

    public String toString() {
        return "XmlNode{elementName='" + this.f2504e + '\'' + ", text='" + this.f2501b + '\'' + ", attributes=" + this.f2505f + '}';
    }
}
