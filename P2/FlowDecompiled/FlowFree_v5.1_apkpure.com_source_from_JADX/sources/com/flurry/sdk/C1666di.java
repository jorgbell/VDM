package com.flurry.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.view.ViewTreeObserver;
import com.flurry.android.FlurryAgent;
import com.flurry.sdk.C1673dk;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.di */
public final class C1666di {

    /* renamed from: d */
    private static C1666di f4225d;

    /* renamed from: e */
    private static final long f4226e = System.nanoTime();

    /* renamed from: a */
    public boolean f4227a = false;

    /* renamed from: b */
    public boolean f4228b = false;

    /* renamed from: c */
    public boolean f4229c = false;

    /* renamed from: f */
    private long f4230f;

    /* renamed from: g */
    private long f4231g;

    /* renamed from: h */
    private long f4232h;

    /* renamed from: i */
    private Map<String, String> f4233i = new HashMap();

    /* renamed from: j */
    private C1673dk.C1675a f4234j;

    private C1666di() {
    }

    /* renamed from: a */
    public static synchronized C1666di m4374a() {
        C1666di diVar;
        synchronized (C1666di.class) {
            if (f4225d == null) {
                f4225d = new C1666di();
            }
            diVar = f4225d;
        }
        return diVar;
    }

    /* renamed from: a */
    public final void mo11443a(Context context, Cursor cursor) {
        if (this.f4234j == null) {
            boolean z = true;
            if (cursor != null) {
                cursor.moveToFirst();
                this.f4230f = cursor.getLong(0);
                this.f4231g = cursor.getLong(1);
                this.f4232h = cursor.getLong(2);
                cursor.close();
            } else {
                Runtime runtime = Runtime.getRuntime();
                ActivityManager.MemoryInfo a = C1676dl.m4398a(context);
                this.f4230f = f4226e;
                this.f4231g = runtime.totalMemory() - runtime.freeMemory();
                this.f4232h = a.totalMem - a.availMem;
            }
            StringBuilder sb = new StringBuilder("Registered with Content Provider: ");
            if (cursor == null) {
                z = false;
            }
            sb.append(z);
            sb.append(", start time: ");
            sb.append(this.f4230f);
            sb.append(", runtime memory: ");
            sb.append(this.f4231g);
            sb.append(", system memory: ");
            sb.append(this.f4232h);
            C1648cy.m4317a(3, "ColdStartMonitor", sb.toString());
            this.f4234j = new C1673dk.C1675a() {
                /* renamed from: a */
                public final void mo11446a() {
                }

                /* renamed from: c */
                public final void mo11449c(Activity activity) {
                }

                /* renamed from: a */
                public final void mo11447a(final Activity activity) {
                    activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            activity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            C1666di diVar = C1666di.this;
                            activity.getApplication();
                            C1666di.m4375a(diVar);
                            C1666di.this.mo11444a(activity, "onGlobalLayout", "fl.layout.time", "fl.layout.runtime.memory", "fl.layout.system.memory");
                            boolean unused = C1666di.this.f4228b = true;
                            if (C1666di.this.f4227a) {
                                C1666di.this.mo11445b();
                            }
                        }
                    });
                }

                /* renamed from: b */
                public final void mo11448b(Activity activity) {
                    C1666di.this.mo11444a(activity, "onActivityResumed", "fl.resume.time", "fl.resume.runtime.memory", "fl.resume.system.memory");
                }
            };
            C1673dk.m4390a().mo11469a(this.f4234j);
        }
    }

    /* renamed from: b */
    public final synchronized void mo11445b() {
        if (!this.f4233i.isEmpty()) {
            C1648cy.m4317a(4, "ColdStartMonitor", "Log Cold Start time event: " + this.f4233i);
            FlurryAgent.logEvent("Flurry.ColdStartTime", this.f4233i);
            this.f4233i.clear();
        }
    }

    /* renamed from: a */
    public final void mo11444a(Context context, String str, String str2, String str3, String str4) {
        double nanoTime = (double) (System.nanoTime() - this.f4230f);
        Double.isNaN(nanoTime);
        long j = (long) (nanoTime / 1000000.0d);
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.totalMemory() - runtime.freeMemory();
        long j2 = freeMemory - this.f4231g;
        long j3 = 0;
        if (j2 < 0) {
            j2 = 0;
        }
        ActivityManager.MemoryInfo a = C1676dl.m4398a(context);
        long j4 = a.totalMem - a.availMem;
        long j5 = j4 - this.f4232h;
        if (j5 >= 0) {
            j3 = j5;
        }
        C1648cy.m4317a(3, "ColdStartMonitor", str + " time: " + j + ", runtime memory usage: " + freeMemory + ", system memory usage: " + j4);
        this.f4233i.put(str2, Long.toString(j));
        this.f4233i.put(str3, Long.toString(j2));
        this.f4233i.put(str4, Long.toString(j3));
    }

    /* renamed from: a */
    static /* synthetic */ void m4375a(C1666di diVar) {
        if (diVar.f4234j != null) {
            C1673dk a = C1673dk.m4390a();
            C1673dk.C1675a aVar = diVar.f4234j;
            synchronized (a.f4250a) {
                a.f4250a.remove(aVar);
            }
            diVar.f4234j = null;
        }
    }
}
