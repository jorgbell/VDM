package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzsa implements Application.ActivityLifecycleCallbacks {
    private Activity zza;
    private Context zzb;
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public boolean zzd = true;
    /* access modifiers changed from: private */
    public boolean zze = false;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final List<zzsb> zzf = new ArrayList();
    @GuardedBy("lock")
    private final List<zzsp> zzg = new ArrayList();
    private Runnable zzh;
    private boolean zzi = false;
    private long zzj;

    zzsa() {
    }

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.zza = activity;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.zza = null;
                }
                Iterator<zzsp> it = this.zzg.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza()) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzs.zzg().zzg(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbbk.zzg("", e);
                    }
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            for (zzsp zzb2 : this.zzg) {
                try {
                    zzb2.zzb();
                } catch (Exception e) {
                    zzs.zzg().zzg(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbbk.zzg("", e);
                }
            }
        }
        this.zze = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            zzr.zza.removeCallbacks(runnable);
        }
        zzebq zzebq = zzr.zza;
        zzrz zzrz = new zzrz(this);
        this.zzh = zzrz;
        zzebq.postDelayed(zzrz, this.zzj);
    }

    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z = !this.zzd;
        this.zzd = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            zzr.zza.removeCallbacks(runnable);
        }
        synchronized (this.zzc) {
            for (zzsp zzc2 : this.zzg) {
                try {
                    zzc2.zzc();
                } catch (Exception e) {
                    zzs.zzg().zzg(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbbk.zzg("", e);
                }
            }
            if (z) {
                for (zzsb zza2 : this.zzf) {
                    try {
                        zza2.zza(true);
                    } catch (Exception e2) {
                        zzbbk.zzg("", e2);
                    }
                }
            } else {
                zzbbk.zzd("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzi) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                zzk((Activity) context);
            }
            this.zzb = application;
            this.zzj = ((Long) zzaaa.zzc().zzb(zzaeq.zzaD)).longValue();
            this.zzi = true;
        }
    }

    public final void zzb(zzsb zzsb) {
        synchronized (this.zzc) {
            this.zzf.add(zzsb);
        }
    }

    public final void zzc(zzsb zzsb) {
        synchronized (this.zzc) {
            this.zzf.remove(zzsb);
        }
    }

    public final Activity zzd() {
        return this.zza;
    }

    public final Context zze() {
        return this.zzb;
    }
}
