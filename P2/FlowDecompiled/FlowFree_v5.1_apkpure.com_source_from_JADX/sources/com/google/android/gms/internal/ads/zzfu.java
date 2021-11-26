package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzfu implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzb;
    private boolean zzc = false;

    public zzfu(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference<>(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzfm(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzfs(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzfp(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzfo(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzfr(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzfn(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzfq(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzft zzft) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzft.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
