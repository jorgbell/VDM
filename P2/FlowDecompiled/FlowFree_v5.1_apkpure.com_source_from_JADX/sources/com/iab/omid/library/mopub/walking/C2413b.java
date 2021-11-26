package com.iab.omid.library.mopub.walking;

import com.iab.omid.library.mopub.walking.p046a.C2406b;
import com.iab.omid.library.mopub.walking.p046a.C2409c;
import com.iab.omid.library.mopub.walking.p046a.C2410d;
import com.iab.omid.library.mopub.walking.p046a.C2411e;
import com.iab.omid.library.mopub.walking.p046a.C2412f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.walking.b */
public class C2413b implements C2406b.C2408b {

    /* renamed from: a */
    private JSONObject f5449a;

    /* renamed from: b */
    private final C2409c f5450b;

    public C2413b(C2409c cVar) {
        this.f5450b = cVar;
    }

    /* renamed from: a */
    public void mo24126a() {
        this.f5450b.mo24119b(new C2410d(this));
    }

    /* renamed from: a */
    public void mo24117a(JSONObject jSONObject) {
        this.f5449a = jSONObject;
    }

    /* renamed from: a */
    public void mo24127a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5450b.mo24119b(new C2412f(this, hashSet, jSONObject, j));
    }

    /* renamed from: b */
    public JSONObject mo24118b() {
        return this.f5449a;
    }

    /* renamed from: b */
    public void mo24128b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f5450b.mo24119b(new C2411e(this, hashSet, jSONObject, j));
    }
}
