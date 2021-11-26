package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.sdk.dk */
public final class C1673dk {

    /* renamed from: b */
    private static C1673dk f4249b;

    /* renamed from: a */
    final List<C1675a> f4250a = new ArrayList();

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f4251c;

    /* renamed from: com.flurry.sdk.dk$a */
    public interface C1675a {
        /* renamed from: a */
        void mo11446a();

        /* renamed from: a */
        void mo11447a(Activity activity);

        /* renamed from: b */
        void mo11448b(Activity activity);

        /* renamed from: c */
        void mo11449c(Activity activity);
    }

    private C1673dk() {
    }

    /* renamed from: a */
    public static synchronized C1673dk m4390a() {
        C1673dk dkVar;
        synchronized (C1673dk.class) {
            if (f4249b == null) {
                f4249b = new C1673dk();
            }
            dkVar = f4249b;
        }
        return dkVar;
    }

    /* renamed from: a */
    public final void mo11469a(C1675a aVar) {
        synchronized (this.f4250a) {
            this.f4250a.add(aVar);
        }
    }

    /* renamed from: a */
    public final void mo11468a(Context context, Cursor cursor) {
        if (this.f4251c == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                if (context instanceof Application) {
                    C1666di.m4374a().mo11443a(applicationContext, cursor);
                }
                C1679dn.m4408a().mo11477b();
                C16741 r3 = new Application.ActivityLifecycleCallbacks() {
                    public final void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    public final void onActivityDestroyed(Activity activity) {
                    }

                    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public final void onActivityStarted(Activity activity) {
                        C1648cy.m4317a(3, "PerformanceMonitor", "onActivityStarted for activity: " + activity.toString());
                        for (C1675a a : C1673dk.this.f4250a) {
                            a.mo11447a(activity);
                        }
                    }

                    public final void onActivityResumed(Activity activity) {
                        C1648cy.m4317a(3, "PerformanceMonitor", "onActivityResumed for activity: " + activity.toString());
                        for (C1675a b : C1673dk.this.f4250a) {
                            b.mo11448b(activity);
                        }
                    }

                    public final void onActivityPaused(Activity activity) {
                        C1648cy.m4317a(3, "PerformanceMonitor", "onActivityPaused for activity: " + activity.toString());
                        for (C1675a a : C1673dk.this.f4250a) {
                            a.mo11446a();
                        }
                    }

                    public final void onActivityStopped(Activity activity) {
                        C1648cy.m4317a(3, "PerformanceMonitor", "onActivityStopped for activity: " + activity.toString());
                        for (C1675a c : C1673dk.this.f4250a) {
                            c.mo11449c(activity);
                        }
                    }
                };
                this.f4251c = r3;
                ((Application) applicationContext).registerActivityLifecycleCallbacks(r3);
            }
        }
    }
}
