package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.utils.C1112a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.a */
public class C0923a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final List<C1112a> f1385a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private WeakReference<Activity> f1386b = new WeakReference<>((Object) null);

    /* renamed from: c */
    private WeakReference<Activity> f1387c = new WeakReference<>((Object) null);

    public C0923a(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.f1386b = new WeakReference<>(activity);
            if (activity.hasWindowFocus()) {
                this.f1387c = this.f1386b;
            }
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    /* renamed from: a */
    public Activity mo8944a() {
        return (Activity) this.f1386b.get();
    }

    /* renamed from: a */
    public void mo8945a(C1112a aVar) {
        this.f1385a.add(aVar);
    }

    /* renamed from: b */
    public Activity mo8946b() {
        return (Activity) this.f1387c.get();
    }

    /* renamed from: b */
    public void mo8947b(C1112a aVar) {
        this.f1385a.remove(aVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (C1112a onActivityCreated : new ArrayList(this.f1385a)) {
            onActivityCreated.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (C1112a onActivityDestroyed : new ArrayList(this.f1385a)) {
            onActivityDestroyed.onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        this.f1387c = new WeakReference<>((Object) null);
        for (C1112a onActivityPaused : new ArrayList(this.f1385a)) {
            onActivityPaused.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.f1386b = weakReference;
        this.f1387c = weakReference;
        for (C1112a onActivityResumed : new ArrayList(this.f1385a)) {
            onActivityResumed.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (C1112a onActivitySaveInstanceState : new ArrayList(this.f1385a)) {
            onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        for (C1112a onActivityStarted : new ArrayList(this.f1385a)) {
            onActivityStarted.onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        for (C1112a onActivityStopped : new ArrayList(this.f1385a)) {
            onActivityStopped.onActivityStopped(activity);
        }
    }
}
