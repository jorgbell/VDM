package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzjk;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzjl<T extends Context & zzjk> {
    private final T zza;

    public zzjl(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    private final zzem zzk() {
        return zzfp.zzC(this.zza, (zzz) null, (Long) null).zzau();
    }

    public final void zza() {
        zzfp zzC = zzfp.zzC(this.zza, (zzz) null, (Long) null);
        zzem zzau = zzC.zzau();
        zzC.zzat();
        zzau.zzk().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzfp zzC = zzfp.zzC(this.zza, (zzz) null, (Long) null);
        zzem zzau = zzC.zzau();
        zzC.zzat();
        zzau.zzk().zza("Local AppMeasurementService is shutting down");
    }

    public final int zzc(Intent intent, int i, int i2) {
        zzfp zzC = zzfp.zzC(this.zza, (zzz) null, (Long) null);
        zzem zzau = zzC.zzau();
        if (intent == null) {
            zzau.zze().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzC.zzat();
        zzau.zzk().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzd(new zzjh(this, i2, zzau, intent));
        }
        return 2;
    }

    public final void zzd(Runnable runnable) {
        zzki zza2 = zzki.zza(this.zza);
        zza2.zzav().zzh(new zzjj(this, zza2, runnable));
    }

    public final IBinder zze(Intent intent) {
        if (intent == null) {
            zzk().zzb().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgh(zzki.zza(this.zza), (String) null);
        }
        zzk().zze().zzb("onBind received unknown action", action);
        return null;
    }

    public final boolean zzf(Intent intent) {
        if (intent == null) {
            zzk().zzb().zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzk().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @TargetApi(24)
    public final boolean zzg(JobParameters jobParameters) {
        zzfp zzC = zzfp.zzC(this.zza, (zzz) null, (Long) null);
        zzem zzau = zzC.zzau();
        String string = jobParameters.getExtras().getString("action");
        zzC.zzat();
        zzau.zzk().zzb("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzd(new zzji(this, zzau, jobParameters));
        return true;
    }

    public final void zzh(Intent intent) {
        if (intent == null) {
            zzk().zzb().zza("onRebind called with null intent");
            return;
        }
        zzk().zzk().zzb("onRebind called. action", intent.getAction());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzem zzem, JobParameters jobParameters) {
        zzem.zzk().zza("AppMeasurementJobService processed last upload request.");
        ((zzjk) this.zza).zzb(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, zzem zzem, Intent intent) {
        if (((zzjk) this.zza).zza(i)) {
            zzem.zzk().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzk().zzk().zza("Completed wakeful intent.");
            ((zzjk) this.zza).zzc(intent);
        }
    }
}
