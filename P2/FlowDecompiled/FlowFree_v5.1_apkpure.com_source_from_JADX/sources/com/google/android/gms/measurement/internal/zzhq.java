package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhq implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzhr zza;

    /* synthetic */ zzhq(zzhr zzhr, zzhd zzhd) {
        this.zza = zzhr;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfp zzfp;
        try {
            this.zza.zzs.zzau().zzk().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzfp = this.zza.zzs;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzs.zzl();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "auto" : "gs";
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z = false;
                        }
                        this.zza.zzs.zzav().zzh(new zzhp(this, z, data, str, queryParameter));
                        zzfp = this.zza.zzs;
                    }
                }
                zzfp = this.zza.zzs;
            }
        } catch (Exception e) {
            this.zza.zzs.zzau().zzb().zzb("Throwable caught in onActivityCreated", e);
            zzfp = this.zza.zzs;
        } catch (Throwable th) {
            this.zza.zzs.zzx().zzo(activity, bundle);
            throw th;
        }
        zzfp.zzx().zzo(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzs.zzx().zzt(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzs.zzx().zzr(activity);
        zzju zzh = this.zza.zzs.zzh();
        zzh.zzs.zzav().zzh(new zzjn(zzh, zzh.zzs.zzay().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzju zzh = this.zza.zzs.zzh();
        zzh.zzs.zzav().zzh(new zzjm(zzh, zzh.zzs.zzay().elapsedRealtime()));
        this.zza.zzs.zzx().zzq(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzs.zzx().zzs(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
