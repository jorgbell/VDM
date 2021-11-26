package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.flurry.sdk.C1508ao;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.flurry.sdk.ap */
public final class C1510ap extends C1907m<C1508ao> implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: d */
    private static String f3804d;

    /* renamed from: a */
    public int f3805a = 0;

    /* renamed from: b */
    private final Set<String> f3806b;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m4009a(activity, C1508ao.C1509a.CREATED);
        synchronized (this) {
            if (f3804d == null) {
                f3804d = activity.getClass().getName();
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
        this.f3806b.add(activity.toString());
        m4009a(activity, C1508ao.C1509a.STARTED);
    }

    public final void onActivityResumed(Activity activity) {
        m4009a(activity, C1508ao.C1509a.RESUMED);
    }

    public final void onActivityPaused(Activity activity) {
        m4009a(activity, C1508ao.C1509a.PAUSED);
    }

    public final void onActivityStopped(Activity activity) {
        this.f3806b.remove(activity.toString());
        m4009a(activity, C1508ao.C1509a.STOPPED);
        if (this.f3806b.isEmpty()) {
            m4009a(activity, C1508ao.C1509a.APP_BACKGROUND);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m4009a(activity, C1508ao.C1509a.SAVE_STATE);
    }

    public final void onActivityDestroyed(Activity activity) {
        m4009a(activity, C1508ao.C1509a.DESTROYED);
    }

    public final void onTrimMemory(int i) {
        m4008a(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (this.f3805a != i) {
            this.f3805a = i;
            Bundle bundle = new Bundle();
            bundle.putInt("orientation_name", this.f3805a);
            notifyObservers(new C1508ao(C1508ao.C1509a.APP_ORIENTATION_CHANGE, bundle));
        }
    }

    public final void onLowMemory() {
        m4008a(80);
    }

    public C1510ap() {
        super("ApplicationLifecycleProvider");
        Application application = (Application) C1536b.m4057a();
        if (application != null) {
            this.f3805a = application.getResources().getConfiguration().orientation;
            application.registerActivityLifecycleCallbacks(this);
            application.registerComponentCallbacks(this);
        } else {
            C1648cy.m4317a(6, "ApplicationLifecycleProvider", "Context is null when initializing.");
        }
        this.f3806b = new HashSet();
    }

    public final void destroy() {
        super.destroy();
        Application application = (Application) C1536b.m4057a();
        application.unregisterActivityLifecycleCallbacks(this);
        application.unregisterComponentCallbacks(this);
    }

    /* renamed from: a */
    private void m4009a(Activity activity, C1508ao.C1509a aVar) {
        Bundle extras;
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", activity.getLocalClassName());
        if (C1508ao.C1509a.CREATED.equals(aVar)) {
            try {
                Intent intent = activity.getIntent();
                if (!(intent == null || (extras = intent.getExtras()) == null)) {
                    bundle.putBundle("launch_options", extras);
                }
            } catch (Throwable unused) {
                C1648cy.m4317a(6, "ApplicationLifecycleProvider", "Error to get Launch Options from the Intent.");
            }
        }
        notifyObservers(new C1508ao(aVar, bundle));
    }

    /* renamed from: a */
    private void m4008a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("trim_memory_level", i);
        notifyObservers(new C1508ao(C1508ao.C1509a.TRIM_MEMORY, bundle));
    }
}
