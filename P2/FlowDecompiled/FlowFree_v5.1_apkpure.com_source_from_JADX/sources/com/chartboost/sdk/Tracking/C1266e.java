package com.chartboost.sdk.Tracking;

import android.content.Context;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Model.C1239i;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.impl.C1377u0;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.chartboost.sdk.Tracking.e */
public class C1266e {

    /* renamed from: a */
    private Context f2940a;

    /* renamed from: b */
    private C1265d f2941b;

    /* renamed from: c */
    private C1247g f2942c;

    /* renamed from: d */
    private C1234g f2943d;

    /* renamed from: e */
    private ScheduledExecutorService f2944e;

    /* renamed from: f */
    private HashMap<String, LinkedList<C1270i>> f2945f = new HashMap<>();

    /* renamed from: g */
    private HashMap<String, LinkedList<C1270i>> f2946g = new HashMap<>();

    /* renamed from: h */
    private HashMap<String, LinkedList<C1270i>> f2947h = new HashMap<>();

    /* renamed from: i */
    private HashMap<String, LinkedList<C1270i>> f2948i = new HashMap<>();

    /* renamed from: j */
    private HashMap<String, C1269h> f2949j = new HashMap<>();

    /* renamed from: k */
    private C1239i f2950k;

    public C1266e(Context context, C1265d dVar, C1247g gVar, C1234g gVar2, ScheduledExecutorService scheduledExecutorService, C1239i iVar) {
        this.f2940a = context;
        this.f2941b = dVar;
        this.f2942c = gVar;
        this.f2943d = gVar2;
        this.f2944e = scheduledExecutorService;
        this.f2950k = iVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m3219b(C1270i iVar) {
        if (!m3222d(iVar)) {
            HashMap<String, C1269h> hashMap = this.f2949j;
            C1269h hVar = hashMap.get(iVar.mo10279d() + iVar.mo10269a());
            if (hVar != null) {
                iVar.mo10271a(hVar);
            }
            iVar.mo10270a(m3211a(iVar));
            m3213a(this.f2950k, iVar);
            CBLogging.m2903a("EventTracker", "Event: " + iVar.toString());
        }
    }

    /* renamed from: d */
    private boolean m3222d(C1270i iVar) {
        if (!m3216a(iVar.mo10282f())) {
            return false;
        }
        String a = iVar.mo10269a();
        String d = iVar.mo10279d();
        LinkedList<C1270i> c = m3220c(a, d);
        if (c == null) {
            c = new LinkedList<>();
        }
        c.add(iVar);
        m3215a(a, d, c);
        return true;
    }

    /* renamed from: e */
    public static void m3223e(C1270i iVar) {
        C1266e b = m3217b();
        if (b != null) {
            b.mo10257f(iVar);
        }
    }

    /* renamed from: a */
    public void mo10254a(C1239i iVar) {
        this.f2950k = iVar;
    }

    /* renamed from: f */
    public C1270i mo10257f(C1270i iVar) {
        ScheduledExecutorService scheduledExecutorService;
        if (iVar == null) {
            return null;
        }
        if (!this.f2950k.mo10140d()) {
            return iVar;
        }
        CBLogging.m2903a("EventTracker", "Track: " + iVar.mo10282f());
        C1270i b = this.f2941b.mo10253b(iVar);
        if (!(this.f2940a == null || (scheduledExecutorService = this.f2944e) == null || b == null)) {
            scheduledExecutorService.schedule(new Runnable(b) {
                public final /* synthetic */ C1270i f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C1266e.this.m3219b(this.f$1);
                }
            }, 1, TimeUnit.MILLISECONDS);
        }
        return b;
    }

    /* renamed from: a */
    public void mo10255a(C1269h hVar) {
        HashMap<String, C1269h> hashMap = this.f2949j;
        hashMap.put(hVar.mo10267d() + hVar.mo10266c(), hVar);
    }

    /* renamed from: b */
    public void mo10256b(String str, String str2) {
        if ("Interstitial".equals(str)) {
            this.f2945f.remove(str2);
        } else if ("Rewarded".equals(str)) {
            this.f2946g.remove(str2);
        } else if ("Banner".equals(str)) {
            this.f2947h.remove(str2);
        } else {
            this.f2948i.remove(str2);
        }
    }

    /* renamed from: a */
    private boolean m3216a(String str) {
        return "cache_start".equals(str) || "show_start".equals(str);
    }

    /* renamed from: a */
    private float m3211a(C1270i iVar) {
        if (!iVar.mo10276b()) {
            return 0.0f;
        }
        try {
            LinkedList<C1270i> c = m3220c(iVar.mo10269a(), iVar.mo10279d());
            C1270i iVar2 = null;
            if (c != null) {
                iVar2 = c.remove();
            }
            if (iVar2 != null) {
                return ((float) (iVar.mo10283g() - iVar2.mo10283g())) / 1000.0f;
            }
            return 0.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    /* renamed from: b */
    public static void m3218b(C1269h hVar) {
        C1266e b = m3217b();
        if (b != null) {
            b.mo10255a(hVar);
        }
    }

    /* renamed from: b */
    private static C1266e m3217b() {
        C1414j b = C1414j.m3867b();
        if (b != null) {
            return b.mo10712e();
        }
        return null;
    }

    /* renamed from: c */
    private LinkedList<C1270i> m3220c(String str, String str2) {
        if ("Interstitial".equals(str)) {
            return this.f2945f.get(str2);
        }
        if ("Rewarded".equals(str)) {
            return this.f2946g.get(str2);
        }
        if ("Banner".equals(str)) {
            return this.f2947h.get(str2);
        }
        return this.f2948i.get(str2);
    }

    /* renamed from: a */
    private void m3215a(String str, String str2, LinkedList<C1270i> linkedList) {
        if ("Interstitial".equals(str)) {
            this.f2945f.put(str2, linkedList);
        } else if ("Rewarded".equals(str)) {
            this.f2946g.put(str2, linkedList);
        } else if ("Banner".equals(str)) {
            this.f2947h.put(str2, linkedList);
        } else {
            this.f2948i.put(str2, linkedList);
        }
    }

    /* renamed from: a */
    private void m3213a(C1239i iVar, C1270i iVar2) {
        if (this.f2943d != null && this.f2940a != null) {
            C1377u0 u0Var = new C1377u0(iVar.mo10137a(), iVar2, m3212a());
            C1247g gVar = this.f2942c;
            if (gVar != null) {
                gVar.mo10147a(u0Var);
            }
        }
    }

    /* renamed from: a */
    private C1261b m3212a() {
        return C1261b.m3130a(this.f2940a, this.f2943d.mo10121e(), this.f2943d.mo10125i(), this.f2943d.mo10119c());
    }

    /* renamed from: a */
    public static void m3214a(String str, String str2) {
        C1266e b = m3217b();
        if (b != null) {
            b.mo10256b(str, str2);
        }
    }
}
