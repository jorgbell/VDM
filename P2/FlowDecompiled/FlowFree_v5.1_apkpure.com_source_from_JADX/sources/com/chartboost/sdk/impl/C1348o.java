package com.chartboost.sdk.impl;

import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1229b;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Tracking.C1264c;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1357p0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.o */
public class C1348o implements C1357p0.C1358a {

    /* renamed from: a */
    public C1344n f3306a;

    /* renamed from: b */
    private final C1220g f3307b;

    /* renamed from: c */
    private final C1247g f3308c;

    /* renamed from: d */
    private final C1234g f3309d;

    /* renamed from: e */
    private final AtomicReference<C1236h> f3310e;

    /* renamed from: f */
    private int f3311f = 1;

    /* renamed from: g */
    private int f3312g = 0;

    /* renamed from: h */
    private long f3313h = 0;

    /* renamed from: i */
    private C1357p0 f3314i = null;

    /* renamed from: j */
    private AtomicInteger f3315j = null;

    public C1348o(C1344n nVar, C1220g gVar, C1247g gVar2, C1234g gVar3, AtomicReference<C1236h> atomicReference) {
        this.f3306a = nVar;
        this.f3307b = gVar;
        this.f3308c = gVar2;
        this.f3309d = gVar3;
        this.f3310e = atomicReference;
    }

    /* renamed from: a */
    private void m3644a(C1236h hVar) {
        boolean z = hVar.f2823q;
        boolean z2 = !z && hVar.f2811e;
        int i = this.f3312g;
        if ((i == 1 && !z2) || (i == 2 && !z)) {
            CBLogging.m2903a("Prefetcher", "Change state to IDLE");
            this.f3311f = 1;
            this.f3312g = 0;
            this.f3313h = 0;
            this.f3314i = null;
            AtomicInteger atomicInteger = this.f3315j;
            this.f3315j = null;
            if (atomicInteger != null) {
                this.f3306a.mo10521a(atomicInteger);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo10531b() {
        try {
            CBLogging.m2907c("Chartboost SDK", "Sdk Version = 8.2.0, Commit: f71d6860a00fdbd99288c1173607cbbf70005dbc");
            C1236h hVar = this.f3310e.get();
            m3644a(hVar);
            if (!hVar.f2809c && !hVar.f2808b) {
                if (C1418k.f3546p) {
                    if (this.f3311f == 3) {
                        if (this.f3315j.get() <= 0) {
                            CBLogging.m2903a("Prefetcher", "Change state to COOLDOWN");
                            this.f3311f = 4;
                            this.f3315j = null;
                        } else {
                            return;
                        }
                    }
                    if (this.f3311f == 4) {
                        if (this.f3313h - System.nanoTime() > 0) {
                            CBLogging.m2903a("Prefetcher", "Prefetch session is still active. Won't be making any new prefetch until the prefetch session expires");
                            return;
                        }
                        CBLogging.m2903a("Prefetcher", "Change state to IDLE");
                        this.f3311f = 1;
                        this.f3312g = 0;
                        this.f3313h = 0;
                    }
                    if (this.f3311f == 1) {
                        if (hVar.f2823q) {
                            C1364q0 q0Var = new C1364q0(hVar.f2830x, this.f3309d, 2, this);
                            q0Var.mo10594a("cache_assets", this.f3307b.mo10053d(), 0);
                            q0Var.f3342m = true;
                            CBLogging.m2903a("Prefetcher", "Change state to AWAIT_PREFETCH_RESPONSE");
                            this.f3311f = 2;
                            this.f3312g = 2;
                            this.f3313h = System.nanoTime() + TimeUnit.MINUTES.toNanos((long) hVar.f2827u);
                            this.f3314i = q0Var;
                        } else if (hVar.f2811e) {
                            C1357p0 p0Var = new C1357p0("https://live.chartboost.com", "/api/video-prefetch", this.f3309d, 2, this);
                            p0Var.mo10562a("local-videos", (Object) this.f3307b.mo10051c());
                            p0Var.f3342m = true;
                            CBLogging.m2903a("Prefetcher", "Change state to AWAIT_PREFETCH_RESPONSE");
                            this.f3311f = 2;
                            this.f3312g = 1;
                            this.f3313h = System.nanoTime() + TimeUnit.MINUTES.toNanos((long) hVar.f2815i);
                            this.f3314i = p0Var;
                        } else {
                            CBLogging.m2905b("Prefetcher", "Did not prefetch because neither native nor webview are enabled.");
                            return;
                        }
                        this.f3308c.mo10147a(this.f3314i);
                    } else {
                        return;
                    }
                }
            }
            mo10530a();
        } catch (Exception e) {
            if (this.f3311f == 2) {
                CBLogging.m2903a("Prefetcher", "Change state to COOLDOWN");
                this.f3311f = 4;
                this.f3314i = null;
            }
            CBLogging.m2905b("Prefetcher", "prefetch: " + e.toString());
        }
    }

    /* renamed from: a */
    public synchronized void mo10530a() {
        int i = this.f3311f;
        if (i == 2) {
            CBLogging.m2903a("Prefetcher", "Change state to COOLDOWN");
            this.f3311f = 4;
            this.f3314i = null;
        } else if (i == 3) {
            CBLogging.m2903a("Prefetcher", "Change state to COOLDOWN");
            this.f3311f = 4;
            AtomicInteger atomicInteger = this.f3315j;
            this.f3315j = null;
            if (atomicInteger != null) {
                this.f3306a.mo10521a(atomicInteger);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo10427a(C1357p0 p0Var, JSONObject jSONObject) {
        try {
            if (this.f3311f == 2) {
                if (p0Var == this.f3314i) {
                    CBLogging.m2903a("Prefetcher", "Change state to DOWNLOAD_ASSETS");
                    this.f3311f = 3;
                    this.f3314i = null;
                    this.f3315j = new AtomicInteger();
                    if (jSONObject != null) {
                        CBLogging.m2903a("Prefetcher", "Got Asset list for Prefetch from server :)" + jSONObject);
                        int i = this.f3312g;
                        if (i == 1) {
                            this.f3306a.mo10519a(3, C1229b.m2982b(jSONObject), this.f3315j, (C1328j) null, "");
                        } else if (i == 2) {
                            this.f3306a.mo10519a(3, C1229b.m2983b(jSONObject, this.f3310e.get().f2820n), this.f3315j, (C1328j) null, "");
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Exception e) {
            CBLogging.m2905b("Prefetcher", "prefetch onSuccess: " + e.toString());
        }
        return;
    }

    /* renamed from: a */
    public synchronized void mo10426a(C1357p0 p0Var, CBError cBError) {
        String str = "Prefetch failure";
        if (cBError != null) {
            str = cBError.getErrorDesc();
        }
        C1266e.m3223e(new C1264c("prefetch_request_error", str, "", ""));
        if (this.f3311f == 2) {
            if (p0Var == this.f3314i) {
                this.f3314i = null;
                CBLogging.m2903a("Prefetcher", "Change state to COOLDOWN");
                this.f3311f = 4;
            }
        }
    }
}
