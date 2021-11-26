package com.iab.omid.library.vungle;

import android.content.Context;
import com.iab.omid.library.vungle.p048b.C2424b;
import com.iab.omid.library.vungle.p048b.C2427d;
import com.iab.omid.library.vungle.p048b.C2430f;
import com.iab.omid.library.vungle.p050d.C2437b;
import com.iab.omid.library.vungle.p050d.C2441e;

/* renamed from: com.iab.omid.library.vungle.b */
public class C2422b {

    /* renamed from: a */
    private boolean f5468a;

    /* renamed from: b */
    private void m5710b(Context context) {
        C2441e.m5791a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24163a(Context context) {
        m5710b(context);
        if (!mo24165b()) {
            mo24164a(true);
            C2430f.m5747a().mo24195a(context);
            C2424b.m5721a().mo24172a(context);
            C2437b.m5772a(context);
            C2427d.m5732a().mo24181a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24164a(boolean z) {
        this.f5468a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo24165b() {
        return this.f5468a;
    }
}
