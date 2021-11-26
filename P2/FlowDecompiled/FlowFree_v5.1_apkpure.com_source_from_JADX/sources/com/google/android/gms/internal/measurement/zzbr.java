package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzbr implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzbs zza;

    zzbr(zzbs zzbs) {
        this.zza = zzbs;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.zza.zzS(new zzbk(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzS(new zzbq(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzS(new zzbn(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.zza.zzS(new zzbm(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzn zzn = new zzn();
        this.zza.zzS(new zzbp(this, activity, zzn));
        Bundle zzd = zzn.zzd(50);
        if (zzd != null) {
            bundle.putAll(zzd);
        }
    }

    public final void onActivityStarted(Activity activity) {
        this.zza.zzS(new zzbl(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.zza.zzS(new zzbo(this, activity));
    }
}
