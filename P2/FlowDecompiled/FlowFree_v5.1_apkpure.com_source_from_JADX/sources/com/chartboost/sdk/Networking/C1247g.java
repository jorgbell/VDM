package com.chartboost.sdk.Networking;

import android.os.Handler;
import com.chartboost.sdk.Libraries.C1224j;
import com.chartboost.sdk.Libraries.CBLogging;
import java.util.concurrent.Executor;

/* renamed from: com.chartboost.sdk.Networking.g */
public class C1247g {

    /* renamed from: a */
    private final Executor f2863a;

    /* renamed from: b */
    private final Executor f2864b;

    /* renamed from: c */
    private final C1255m f2865c;

    /* renamed from: d */
    private final C1248h f2866d;

    /* renamed from: e */
    private final C1224j f2867e;

    /* renamed from: f */
    private final Handler f2868f;

    public C1247g(Executor executor, C1255m mVar, C1248h hVar, C1224j jVar, Handler handler, Executor executor2) {
        this.f2863a = executor2;
        this.f2864b = executor;
        this.f2865c = mVar;
        this.f2866d = hVar;
        this.f2867e = jVar;
        this.f2868f = handler;
    }

    /* renamed from: a */
    public <T> void mo10147a(C1243c<T> cVar) {
        CBLogging.m2908d("CBRequest", "Execute request: " + cVar.f2848b);
        this.f2863a.execute(new C1254l(this.f2864b, this.f2865c, this.f2866d, this.f2867e, this.f2868f, cVar));
    }
}
