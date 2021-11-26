package com.flurry.sdk;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.cu */
public final class C1639cu<K, V> {

    /* renamed from: a */
    public final Map<K, List<V>> f4141a = new HashMap();

    /* renamed from: b */
    private int f4142b;

    /* renamed from: a */
    public final List<V> mo11419a(K k, boolean z) {
        ArrayList arrayList;
        List<V> list = this.f4141a.get(k);
        if (!z || list != null) {
            return list;
        }
        if (this.f4142b > 0) {
            arrayList = new ArrayList(this.f4142b);
        } else {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        this.f4141a.put(k, arrayList2);
        return arrayList2;
    }

    /* renamed from: a */
    public final void mo11420a(K k, V v) {
        if (k != null) {
            mo11419a(k, true).add(v);
        }
    }

    /* renamed from: a */
    public final Collection<Map.Entry<K, V>> mo11418a() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f4141a.entrySet()) {
            for (Object simpleImmutableEntry : (List) next.getValue()) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(next.getKey(), simpleImmutableEntry));
            }
        }
        return arrayList;
    }
}
