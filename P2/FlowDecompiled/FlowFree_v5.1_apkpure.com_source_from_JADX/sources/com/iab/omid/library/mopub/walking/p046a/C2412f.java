package com.iab.omid.library.mopub.walking.p046a;

import android.text.TextUtils;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.p042b.C2372a;
import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.walking.p046a.C2406b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mopub.walking.a.f */
public class C2412f extends C2405a {
    public C2412f(C2406b.C2408b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m5688b(String str) {
        C2372a a = C2372a.m5503a();
        if (a != null) {
            for (C2370a next : a.mo24021b()) {
                if (this.f5440a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo24074a(str, this.f5442c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (C2388b.m5586b(this.f5441b, this.f5444d.mo24118b())) {
            return null;
        }
        this.f5444d.mo24117a(this.f5441b);
        return this.f5441b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m5688b(str);
        }
        super.onPostExecute(str);
    }
}
