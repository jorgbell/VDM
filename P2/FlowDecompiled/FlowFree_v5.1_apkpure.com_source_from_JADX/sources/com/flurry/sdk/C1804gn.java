package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gn */
public final class C1804gn extends C1891jm {

    /* renamed from: a */
    public final String f4516a;

    /* renamed from: b */
    public int f4517b;

    /* renamed from: c */
    public final Map<String, String> f4518c;

    /* renamed from: d */
    public final Map<String, String> f4519d;

    /* renamed from: e */
    public final boolean f4520e;

    /* renamed from: f */
    public final boolean f4521f;

    /* renamed from: g */
    public long f4522g;

    /* renamed from: h */
    public final C1805a f4523h;

    /* renamed from: i */
    public final long f4524i;

    /* renamed from: j */
    public final long f4525j;

    /* renamed from: com.flurry.sdk.gn$a */
    public enum C1805a {
        CUSTOM_EVENT,
        PURCHASE_EVENT
    }

    public C1804gn(String str, int i, C1805a aVar, Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2, long j, long j2) {
        this.f4516a = C1698dz.m4447b(C1698dz.m4440a(str));
        this.f4517b = i;
        this.f4523h = aVar;
        this.f4518c = map != null ? m4663a(map, list) : new HashMap<>();
        this.f4519d = map2 != null ? m4663a(map2, list) : new HashMap<>();
        this.f4520e = z;
        this.f4521f = z2;
        this.f4524i = j;
        this.f4525j = j2;
        this.f4522g = 0;
    }

    public C1804gn(String str, int i, Map<String, String> map, Map<String, String> map2, long j, long j2, long j3) {
        this.f4516a = str;
        this.f4517b = i;
        this.f4523h = C1805a.CUSTOM_EVENT;
        this.f4518c = map;
        this.f4519d = map2;
        this.f4520e = true;
        this.f4521f = false;
        this.f4524i = j;
        this.f4525j = j2;
        this.f4522g = j3;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.event.name", this.f4516a);
        a.put("fl.event.id", this.f4517b);
        a.put("fl.event.type", this.f4523h.toString());
        a.put("fl.event.timed", this.f4520e);
        a.put("fl.timed.event.starting", this.f4521f);
        long j = this.f4522g;
        if (j > 0) {
            a.put("fl.timed.event.duration", j);
        }
        a.put("fl.event.timestamp", this.f4524i);
        a.put("fl.event.uptime", this.f4525j);
        a.put("fl.event.user.parameters", C1701ea.m4452a(this.f4518c));
        a.put("fl.event.flurry.parameters", C1701ea.m4452a(this.f4519d));
        return a;
    }

    /* renamed from: a */
    private static Map<String, String> m4663a(Map<String, String> map, List<String> list) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (!list.contains(next.getKey())) {
                str = C1698dz.m4447b((String) next.getKey());
                str2 = C1698dz.m4447b((String) next.getValue());
            } else {
                str = C1698dz.m4447b((String) next.getKey());
                str2 = (String) next.getValue();
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }
}
