package com.iab.omid.library.vungle.walking.p052a;

import android.text.TextUtils;
import com.iab.omid.library.vungle.adsession.C2421a;
import com.iab.omid.library.vungle.p048b.C2423a;
import com.iab.omid.library.vungle.p050d.C2437b;
import com.iab.omid.library.vungle.walking.p052a.C2455b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.walking.a.f */
public class C2461f extends C2454a {
    public C2461f(C2455b.C2457b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m5866b(String str) {
        C2423a a = C2423a.m5714a();
        if (a != null) {
            for (C2421a next : a.mo24167b()) {
                if (this.f5533a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo24211a(str, this.f5535c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (C2437b.m5781b(this.f5534b, this.f5537d.mo24249b())) {
            return null;
        }
        this.f5537d.mo24248a(this.f5534b);
        return this.f5534b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m5866b(str);
        }
        super.onPostExecute(str);
    }
}
