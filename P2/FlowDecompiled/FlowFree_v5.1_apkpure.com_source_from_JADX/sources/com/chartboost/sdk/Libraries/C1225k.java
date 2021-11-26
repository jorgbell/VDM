package com.chartboost.sdk.Libraries;

import android.app.Activity;
import com.chartboost.sdk.impl.C1317h1;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.Libraries.k */
public final class C1225k extends WeakReference<Activity> {

    /* renamed from: a */
    public final int f2694a;

    public C1225k(Activity activity) {
        super(activity);
        C1317h1.m3506a("WeakActivity.WeakActivity", (Object) activity);
        this.f2694a = activity.hashCode();
    }

    /* renamed from: a */
    public boolean mo10068a(Activity activity) {
        return activity != null && activity.hashCode() == this.f2694a;
    }

    public int hashCode() {
        return this.f2694a;
    }
}
