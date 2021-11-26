package com.iab.omid.library.mopub;

import android.content.Context;
import com.iab.omid.library.mopub.p042b.C2373b;
import com.iab.omid.library.mopub.p042b.C2377d;
import com.iab.omid.library.mopub.p042b.C2380f;
import com.iab.omid.library.mopub.p044d.C2388b;
import com.iab.omid.library.mopub.p044d.C2392e;

/* renamed from: com.iab.omid.library.mopub.b */
public class C2371b {

    /* renamed from: a */
    private boolean f5361a;

    /* renamed from: b */
    private void m5498b(Context context) {
        C2392e.m5597a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo24016a() {
        return "1.3.4-Mopub";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24017a(Context context) {
        m5498b(context);
        if (!mo24019b()) {
            mo24018a(true);
            C2380f.m5545a().mo24055a(context);
            C2373b.m5510a().mo24026a(context);
            C2388b.m5577a(context);
            C2377d.m5526a().mo24037a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24018a(boolean z) {
        this.f5361a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo24019b() {
        return this.f5361a;
    }
}
