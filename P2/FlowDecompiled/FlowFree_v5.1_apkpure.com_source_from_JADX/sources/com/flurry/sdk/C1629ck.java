package com.flurry.sdk;

import android.util.SparseArray;
import com.flurry.sdk.C1605by;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.ck */
public final class C1629ck {

    /* renamed from: a */
    Map<C1623cg, SparseArray<C1628cj>> f4121a;

    /* renamed from: b */
    Map<C1623cg, Map<String, C1605by>> f4122b;

    /* renamed from: c */
    Map<C1623cg, Map<String, C1605by>> f4123c;

    /* renamed from: d */
    long f4124d;

    public C1629ck() {
        mo11399a();
    }

    /* renamed from: a */
    public final synchronized void mo11401a(List<C1628cj> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                m4251a(list, this.f4121a);
                m4256c(list);
            }
        }
    }

    /* renamed from: b */
    public final synchronized boolean mo11404b(List<C1628cj> list) {
        if (list == null) {
            return false;
        }
        if (list.size() != mo11407e()) {
            return true;
        }
        for (C1628cj next : list) {
            SparseArray sparseArray = this.f4121a.get(next.f4116a);
            if (sparseArray == null) {
                return true;
            }
            C1628cj cjVar = (C1628cj) sparseArray.get(next.f4117b);
            if (cjVar == null) {
                return true;
            }
            if (next.f4118c != cjVar.f4118c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final synchronized boolean mo11402a(List<C1628cj> list, boolean z) {
        if (list == null) {
            return true;
        }
        if (list.isEmpty()) {
            m4257f();
            return true;
        } else if (z) {
            m4257f();
            m4251a(list, this.f4121a);
            m4255b(list, this.f4123c);
            return true;
        } else {
            HashMap hashMap = new HashMap();
            m4254a(this.f4121a, (Map<C1623cg, SparseArray<C1628cj>>) hashMap, true, true);
            HashMap hashMap2 = new HashMap();
            m4253a(this.f4123c, (Map<C1623cg, Map<String, C1605by>>) hashMap2, (C1623cg) null, true);
            m4252a(list, (Map<C1623cg, SparseArray<C1628cj>>) hashMap, (Map<C1623cg, Map<String, C1605by>>) hashMap2);
            m4251a(list, (Map<C1623cg, SparseArray<C1628cj>>) hashMap);
            m4255b(list, hashMap2);
            C1648cy.m4319a("VariantsManager", "Verify ETag merged JSON: ".concat(String.valueOf(mo11398a((Map<C1623cg, SparseArray<C1628cj>>) hashMap, (Map<C1623cg, Map<String, C1605by>>) hashMap2, true))));
            m4254a((Map<C1623cg, SparseArray<C1628cj>>) hashMap, this.f4121a, false, false);
            m4253a((Map<C1623cg, Map<String, C1605by>>) hashMap2, this.f4123c, (C1623cg) null, false);
            return true;
        }
    }

    /* renamed from: a */
    private static void m4254a(Map<C1623cg, SparseArray<C1628cj>> map, Map<C1623cg, SparseArray<C1628cj>> map2, boolean z, boolean z2) {
        SparseArray sparseArray;
        for (Map.Entry next : map.entrySet()) {
            C1623cg cgVar = (C1623cg) next.getKey();
            if (z) {
                SparseArray sparseArray2 = (SparseArray) next.getValue();
                sparseArray = new SparseArray(sparseArray2.size());
                for (int i = 0; i < sparseArray2.size(); i++) {
                    C1628cj cjVar = (C1628cj) sparseArray2.valueAt(i);
                    int i2 = cjVar.f4117b;
                    if (z2) {
                        cjVar = new C1628cj(cjVar);
                    }
                    sparseArray.put(i2, cjVar);
                }
            } else {
                sparseArray = (SparseArray) next.getValue();
            }
            map2.put(cgVar, sparseArray);
        }
    }

    /* renamed from: a */
    private synchronized void m4252a(List<C1628cj> list, Map<C1623cg, SparseArray<C1628cj>> map, Map<C1623cg, Map<String, C1605by>> map2) {
        HashMap hashMap = new HashMap();
        m4254a(map, (Map<C1623cg, SparseArray<C1628cj>>) hashMap, true, false);
        for (C1628cj next : list) {
            SparseArray sparseArray = (SparseArray) hashMap.get(next.f4116a);
            if (sparseArray != null) {
                sparseArray.remove(next.f4117b);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            C1623cg cgVar = (C1623cg) entry.getKey();
            SparseArray sparseArray2 = (SparseArray) entry.getValue();
            SparseArray sparseArray3 = map.get(cgVar);
            Map map3 = map2.get(cgVar);
            for (int i = 0; i < sparseArray2.size(); i++) {
                C1628cj cjVar = (C1628cj) sparseArray2.valueAt(i);
                sparseArray3.remove(cjVar.f4117b);
                for (String remove : cjVar.f4120e.keySet()) {
                    map3.remove(remove);
                }
            }
        }
    }

    /* renamed from: a */
    private synchronized void m4251a(List<C1628cj> list, Map<C1623cg, SparseArray<C1628cj>> map) {
        for (C1628cj next : list) {
            int i = next.f4117b;
            C1623cg cgVar = next.f4116a;
            SparseArray sparseArray = map.get(cgVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                map.put(cgVar, sparseArray);
            } else {
                C1628cj cjVar = (C1628cj) sparseArray.get(i);
                if (cjVar != null) {
                    next.mo11392a(cjVar);
                }
            }
            sparseArray.put(i, next);
        }
    }

    /* renamed from: a */
    private static void m4253a(Map<C1623cg, Map<String, C1605by>> map, Map<C1623cg, Map<String, C1605by>> map2, C1623cg cgVar, boolean z) {
        for (Map.Entry next : map.entrySet()) {
            C1623cg cgVar2 = (C1623cg) next.getKey();
            if (cgVar == null || cgVar == cgVar2) {
                Map map3 = (Map) next.getValue();
                if (z) {
                    map3 = new HashMap(map3);
                }
                map2.put(cgVar2, map3);
            }
        }
    }

    /* renamed from: c */
    private synchronized void m4256c(List<C1628cj> list) {
        for (C1628cj next : list) {
            C1623cg cgVar = next.f4116a;
            Map map = this.f4122b.get(cgVar);
            if (map == null) {
                map = new HashMap();
                this.f4122b.put(cgVar, map);
            }
            Map map2 = this.f4123c.get(cgVar);
            if (map2 == null) {
                map2 = new HashMap();
                this.f4123c.put(cgVar, map2);
            }
            for (Map.Entry next2 : next.mo11391a()) {
                String str = (String) next2.getKey();
                C1605by byVar = (C1605by) next2.getValue();
                map.put(str, byVar);
                map2.put(str, byVar);
            }
        }
    }

    /* renamed from: b */
    private synchronized void m4255b(List<C1628cj> list, Map<C1623cg, Map<String, C1605by>> map) {
        for (C1628cj next : list) {
            C1623cg cgVar = next.f4116a;
            Map map2 = map.get(cgVar);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(cgVar, map2);
            }
            for (Map.Entry next2 : next.mo11391a()) {
                String str = (String) next2.getKey();
                C1605by byVar = (C1605by) next2.getValue();
                if (byVar.f4040a == C1605by.C1606a.Tombstone) {
                    map2.remove(str);
                } else {
                    map2.put(str, byVar);
                }
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo11400a(C1623cg cgVar) {
        C1648cy.m4317a(3, "VariantsManager", "original Variants properties:" + this.f4122b.keySet().toString() + " with: " + this.f4121a.values().toString());
        m4253a(this.f4123c, this.f4122b, cgVar, true);
        StringBuilder sb = new StringBuilder("new Variants properties:");
        sb.append(this.f4122b.keySet().toString());
        C1648cy.m4317a(3, "VariantsManager", sb.toString());
    }

    /* renamed from: a */
    public final C1605by mo11397a(String str, C1623cg cgVar) {
        if (cgVar == null) {
            for (Map<String, C1605by> map : this.f4122b.values()) {
                C1605by byVar = (C1605by) map.get(str);
                if (byVar != null) {
                    return byVar;
                }
            }
            return null;
        }
        Map map2 = this.f4122b.get(cgVar);
        if (map2 != null) {
            return (C1605by) map2.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public final synchronized void mo11399a() {
        m4257f();
        this.f4122b = new HashMap();
        for (C1623cg put : C1623cg.m4239b()) {
            this.f4122b.put(put, new HashMap());
        }
    }

    /* renamed from: f */
    private synchronized void m4257f() {
        this.f4121a = new HashMap();
        this.f4123c = new HashMap();
        for (C1623cg next : C1623cg.m4239b()) {
            this.f4121a.put(next, new SparseArray());
            this.f4123c.put(next, new HashMap());
        }
    }

    /* renamed from: b */
    public final synchronized List<C1628cj> mo11403b() {
        return m4250a(this.f4121a);
    }

    /* renamed from: a */
    private synchronized List<C1628cj> m4250a(Map<C1623cg, SparseArray<C1628cj>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (SparseArray next : map.values()) {
            for (int i = 0; i < next.size(); i++) {
                arrayList.add(next.valueAt(i));
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final synchronized String mo11405c() {
        StringBuilder sb;
        sb = new StringBuilder();
        int i = 0;
        for (SparseArray next : this.f4121a.values()) {
            i += next.size();
            for (int i2 = 0; i2 < next.size(); i2++) {
                C1628cj cjVar = (C1628cj) next.valueAt(i2);
                sb.append("," + cjVar.f4117b);
                sb.append("," + cjVar.f4118c);
            }
        }
        sb.insert(0, i);
        return sb.toString();
    }

    /* renamed from: d */
    public final synchronized List<C1623cg> mo11406d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry next : this.f4121a.entrySet()) {
            if (((SparseArray) next.getValue()).size() > 0) {
                arrayList.add(next.getKey());
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public final synchronized int mo11407e() {
        int i;
        i = 0;
        for (SparseArray<C1628cj> size : this.f4121a.values()) {
            i += size.size();
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final JSONObject mo11398a(Map<C1623cg, SparseArray<C1628cj>> map, Map<C1623cg, Map<String, C1605by>> map2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            List<C1628cj> a = m4250a(map);
            if (z) {
                Collections.sort(a);
            }
            for (C1628cj next : a) {
                Map map3 = map2.get(next.f4116a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", next.f4117b);
                jSONObject2.put(MediationMetaData.KEY_VERSION, next.f4118c);
                jSONObject2.put("document", next.f4116a.toString());
                JSONArray jSONArray2 = new JSONArray();
                for (Map.Entry<String, C1605by> key : z ? new TreeMap(next.f4120e).entrySet() : next.mo11391a()) {
                    String str = (String) key.getKey();
                    C1605by byVar = (C1605by) map3.get(str);
                    if (byVar != null) {
                        jSONArray2.put(byVar.mo11363a(str));
                    }
                }
                jSONObject2.put("items", jSONArray2);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("variants", jSONArray);
            jSONObject.put("refreshInSeconds", this.f4124d);
            return jSONObject;
        } catch (JSONException e) {
            C1648cy.m4320a("VariantsManager", "Error to create JSON object.", (Throwable) e);
            return null;
        }
    }
}
