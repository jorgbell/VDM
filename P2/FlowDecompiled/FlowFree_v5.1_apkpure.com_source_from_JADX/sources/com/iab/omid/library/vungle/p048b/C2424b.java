package com.iab.omid.library.vungle.p048b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.iab.omid.library.vungle.adsession.C2421a;

/* renamed from: com.iab.omid.library.vungle.b.b */
public class C2424b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C2424b f5472a = new C2424b();

    /* renamed from: d */
    private boolean f5473d;

    /* renamed from: com.iab.omid.library.vungle.b.b$a */
    public interface C2425a {
    }

    private C2424b() {
    }

    /* renamed from: a */
    public static C2424b m5721a() {
        return f5472a;
    }

    /* renamed from: e */
    private void m5722e() {
        boolean z = !this.f5473d;
        for (C2421a adSessionStatePublisher : C2423a.m5714a().mo24167b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo24212a(z);
        }
    }

    /* renamed from: a */
    public void mo24172a(Context context) {
        context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo24173a(C2425a aVar) {
    }

    /* renamed from: b */
    public void mo24174b() {
        m5722e();
    }

    /* renamed from: c */
    public void mo24175c() {
        this.f5473d = false;
    }

    /* renamed from: d */
    public boolean mo24176d() {
        return !this.f5473d;
    }
}
