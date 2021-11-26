package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.cj */
public final class C1628cj implements Comparable<C1628cj> {

    /* renamed from: a */
    C1623cg f4116a;

    /* renamed from: b */
    public int f4117b;

    /* renamed from: c */
    public int f4118c;

    /* renamed from: d */
    JSONObject f4119d;

    /* renamed from: e */
    Map<String, C1605by> f4120e = new HashMap();

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C1628cj cjVar = (C1628cj) obj;
        C1623cg cgVar = this.f4116a;
        if (cgVar != cjVar.f4116a) {
            return cgVar == C1623cg.f4101a ? -1 : 1;
        }
        return this.f4117b - cjVar.f4117b;
    }

    public C1628cj(C1628cj cjVar) {
        this.f4116a = cjVar.f4116a;
        this.f4117b = cjVar.f4117b;
        this.f4118c = cjVar.f4118c;
        this.f4119d = cjVar.f4119d;
        this.f4120e = new HashMap(cjVar.f4120e);
    }

    public C1628cj(C1623cg cgVar) {
        this.f4116a = cgVar;
    }

    /* renamed from: a */
    public final C1605by mo11390a(String str) {
        return this.f4120e.get(str);
    }

    /* renamed from: a */
    public final Set<Map.Entry<String, C1605by>> mo11391a() {
        return this.f4120e.entrySet();
    }

    /* renamed from: a */
    public final void mo11392a(C1628cj cjVar) {
        for (Map.Entry next : cjVar.mo11391a()) {
            String str = (String) next.getKey();
            if (!this.f4120e.containsKey(str)) {
                this.f4120e.put(str, next.getValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1628cj)) {
            return false;
        }
        C1628cj cjVar = (C1628cj) obj;
        return this.f4116a == cjVar.f4116a && this.f4117b == cjVar.f4117b;
    }

    public final int hashCode() {
        return (this.f4116a.hashCode() * 31) + this.f4117b;
    }

    public final String toString() {
        return this.f4116a + ":" + this.f4117b + ":" + this.f4118c;
    }
}
