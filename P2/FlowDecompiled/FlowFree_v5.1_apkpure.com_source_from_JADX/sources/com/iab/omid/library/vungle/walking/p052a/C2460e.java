package com.iab.omid.library.vungle.walking.p052a;

import com.iab.omid.library.vungle.adsession.C2421a;
import com.iab.omid.library.vungle.p048b.C2423a;
import com.iab.omid.library.vungle.walking.p052a.C2455b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.walking.a.e */
public class C2460e extends C2454a {
    public C2460e(C2455b.C2457b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m5863b(String str) {
        C2423a a = C2423a.m5714a();
        if (a != null) {
            for (C2421a next : a.mo24167b()) {
                if (this.f5533a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo24214b(str, this.f5535c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f5534b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        m5863b(str);
        super.onPostExecute(str);
    }
}
