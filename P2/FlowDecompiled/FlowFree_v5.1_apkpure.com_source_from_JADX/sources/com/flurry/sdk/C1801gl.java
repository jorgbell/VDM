package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gl */
public final class C1801gl extends C1891jm {

    /* renamed from: a */
    public final int f4494a;

    /* renamed from: b */
    public final String f4495b;

    /* renamed from: c */
    public final long f4496c;

    /* renamed from: d */
    public final String f4497d;

    /* renamed from: e */
    public final String f4498e;

    /* renamed from: f */
    public final String f4499f;

    /* renamed from: g */
    public final int f4500g;

    /* renamed from: h */
    public final int f4501h;

    /* renamed from: i */
    public final String f4502i;

    /* renamed from: j */
    public final String f4503j;

    /* renamed from: k */
    public final Map<String, String> f4504k;

    /* renamed from: l */
    public final Map<String, String> f4505l;

    /* renamed from: m */
    public int f4506m;

    /* renamed from: n */
    public List<C1925v> f4507n;

    public C1801gl(int i, String str, long j, String str2, String str3, String str4, int i2, int i3, Map<String, String> map, Map<String, String> map2, int i4, List<C1925v> list, String str5, String str6) {
        String str7;
        this.f4494a = i;
        this.f4495b = str;
        this.f4496c = j;
        this.f4497d = str2 == null ? "" : str2;
        this.f4498e = str3 == null ? "" : str3;
        this.f4499f = str4 == null ? "" : str4;
        this.f4500g = i2;
        this.f4501h = i3;
        this.f4504k = map == null ? new HashMap<>() : map;
        this.f4505l = map2 == null ? new HashMap<>() : map2;
        this.f4506m = i4;
        this.f4507n = list == null ? new ArrayList<>() : list;
        if (str5 != null) {
            str7 = C1698dz.m4447b(str5);
        } else {
            str7 = "";
        }
        this.f4502i = str7;
        this.f4503j = str6 == null ? "" : str6;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.error.id", this.f4494a);
        a.put("fl.error.name", this.f4495b);
        a.put("fl.error.timestamp", this.f4496c);
        a.put("fl.error.message", this.f4497d);
        a.put("fl.error.class", this.f4498e);
        a.put("fl.error.type", this.f4500g);
        a.put("fl.crash.report", this.f4499f);
        a.put("fl.crash.platform", this.f4501h);
        a.put("fl.error.user.crash.parameter", C1701ea.m4452a(this.f4505l));
        a.put("fl.error.sdk.crash.parameter", C1701ea.m4452a(this.f4504k));
        a.put("fl.breadcrumb.version", this.f4506m);
        JSONArray jSONArray = new JSONArray();
        List<C1925v> list = this.f4507n;
        if (list != null) {
            for (C1925v next : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fl.breadcrumb.message", next.f4760a);
                jSONObject.put("fl.breadcrumb.timestamp", next.f4761b);
                jSONArray.put(jSONObject);
            }
        }
        a.put("fl.breadcrumb", jSONArray);
        a.put("fl.nativecrash.minidump", this.f4502i);
        a.put("fl.nativecrash.logcat", this.f4503j);
        return a;
    }
}
