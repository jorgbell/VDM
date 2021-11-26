package com.applovin.impl.p018a;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.impl.sdk.utils.C1166t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.c */
public class C0542c {

    /* renamed from: c */
    private static final List<String> f175c = Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});

    /* renamed from: a */
    protected List<C1166t> f176a = new ArrayList();

    /* renamed from: b */
    private final C1062k f177b;

    /* renamed from: d */
    private final JSONObject f178d;

    /* renamed from: e */
    private final JSONObject f179e;

    /* renamed from: f */
    private final C0925b f180f;

    /* renamed from: g */
    private final long f181g = System.currentTimeMillis();

    public C0542c(JSONObject jSONObject, JSONObject jSONObject2, C0925b bVar, C1062k kVar) {
        this.f177b = kVar;
        this.f178d = jSONObject;
        this.f179e = jSONObject2;
        this.f180f = bVar;
    }

    /* renamed from: a */
    public int mo7861a() {
        return this.f176a.size();
    }

    /* renamed from: b */
    public List<C1166t> mo7862b() {
        return this.f176a;
    }

    /* renamed from: c */
    public JSONObject mo7863c() {
        return this.f178d;
    }

    /* renamed from: d */
    public JSONObject mo7864d() {
        return this.f179e;
    }

    /* renamed from: e */
    public C0925b mo7865e() {
        return this.f180f;
    }

    /* renamed from: f */
    public long mo7866f() {
        return this.f181g;
    }

    /* renamed from: g */
    public List<String> mo7867g() {
        List<String> a = C1117e.m2521a(C1123j.m2594b(this.f178d, "vast_preferred_video_types", (String) null, (C1062k) null));
        return !a.isEmpty() ? a : f175c;
    }

    /* renamed from: h */
    public int mo7868h() {
        return C1160r.m2701a(this.f178d);
    }
}
