package com.amazon.device.iap.internal.p007a;

import android.util.Log;
import com.amazon.device.iap.internal.C0473a;

/* renamed from: com.amazon.device.iap.internal.a.a */
/* compiled from: SandboxLogHandler */
public class C0474a implements C0473a {
    /* renamed from: a */
    public boolean mo7429a() {
        return true;
    }

    /* renamed from: b */
    public boolean mo7431b() {
        return true;
    }

    /* renamed from: a */
    public void mo7428a(String str, String str2) {
        Log.d(str, m29a(str2));
    }

    /* renamed from: b */
    public void mo7430b(String str, String str2) {
        Log.e(str, m29a(str2));
    }

    /* renamed from: a */
    private static String m29a(String str) {
        return "In App Purchasing SDK - Sandbox Mode: " + str;
    }
}
