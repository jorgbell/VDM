package com.iab.omid.library.mopub.p042b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.mopub.adsession.C2370a;
import com.iab.omid.library.mopub.p041a.C2366b;
import com.iab.omid.library.mopub.p041a.C2367c;
import com.iab.omid.library.mopub.p041a.C2368d;
import com.iab.omid.library.mopub.p041a.C2369e;
import com.iab.omid.library.mopub.p042b.C2373b;
import com.iab.omid.library.mopub.walking.TreeWalker;

/* renamed from: com.iab.omid.library.mopub.b.f */
public class C2380f implements C2367c, C2373b.C2375a {

    /* renamed from: a */
    private static C2380f f5381a;

    /* renamed from: b */
    private float f5382b = 0.0f;

    /* renamed from: c */
    private final C2369e f5383c;

    /* renamed from: d */
    private final C2366b f5384d;

    /* renamed from: e */
    private C2368d f5385e;

    /* renamed from: f */
    private C2372a f5386f;

    public C2380f(C2369e eVar, C2366b bVar) {
        this.f5383c = eVar;
        this.f5384d = bVar;
    }

    /* renamed from: a */
    public static C2380f m5545a() {
        if (f5381a == null) {
            f5381a = new C2380f(new C2369e(), new C2366b());
        }
        return f5381a;
    }

    /* renamed from: e */
    private C2372a m5546e() {
        if (this.f5386f == null) {
            this.f5386f = C2372a.m5503a();
        }
        return this.f5386f;
    }

    /* renamed from: a */
    public void mo23954a(float f) {
        this.f5382b = f;
        for (C2370a adSessionStatePublisher : m5546e().mo24023c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo24066a(f);
        }
    }

    /* renamed from: a */
    public void mo24055a(Context context) {
        this.f5385e = this.f5383c.mo23958a(new Handler(), context, this.f5384d.mo23953a(), this);
    }

    /* renamed from: a */
    public void mo24032a(boolean z) {
        if (z) {
            TreeWalker.getInstance().mo24090a();
        } else {
            TreeWalker.getInstance().mo24092c();
        }
    }

    /* renamed from: b */
    public void mo24056b() {
        C2373b.m5510a().mo24027a((C2373b.C2375a) this);
        C2373b.m5510a().mo24028b();
        if (C2373b.m5510a().mo24030d()) {
            TreeWalker.getInstance().mo24090a();
        }
        this.f5385e.mo23955a();
    }

    /* renamed from: c */
    public void mo24057c() {
        TreeWalker.getInstance().mo24091b();
        C2373b.m5510a().mo24029c();
        this.f5385e.mo23956b();
    }

    /* renamed from: d */
    public float mo24058d() {
        return this.f5382b;
    }
}
