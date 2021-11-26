package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.measurement.internal.zzgq;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
public class AppMeasurementSdk {
    private final zzbs zza;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
    public interface OnEventListener extends zzgq {
    }

    public AppMeasurementSdk(zzbs zzbs) {
        this.zza = zzbs;
    }

    public void beginAdUnitExposure(@RecentlyNonNull String str) {
        this.zza.zzu(str);
    }

    public void clearConditionalUserProperty(@RecentlyNonNull String str, String str2, Bundle bundle) {
        this.zza.zzl(str, str2, bundle);
    }

    public void endAdUnitExposure(@RecentlyNonNull String str) {
        this.zza.zzv(str);
    }

    public long generateEventId() {
        return this.zza.zzy();
    }

    @RecentlyNullable
    public String getAppIdOrigin() {
        return this.zza.zzG();
    }

    @RecentlyNullable
    public String getAppInstanceId() {
        return this.zza.zzx();
    }

    @RecentlyNonNull
    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    @RecentlyNullable
    public String getCurrentScreenClass() {
        return this.zza.zzA();
    }

    @RecentlyNullable
    public String getCurrentScreenName() {
        return this.zza.zzz();
    }

    @RecentlyNullable
    public String getGmpAppId() {
        return this.zza.zzw();
    }

    public int getMaxUserProperties(@RecentlyNonNull String str) {
        return this.zza.zzE(str);
    }

    @RecentlyNonNull
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zza.zzB(str, str2, z);
    }

    public void logEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        this.zza.zzh(str, str2, bundle);
    }

    @RecentlyNullable
    public void performAction(@RecentlyNonNull Bundle bundle) {
        this.zza.zzD(bundle, false);
    }

    @RecentlyNullable
    public Bundle performActionWithResponse(@RecentlyNonNull Bundle bundle) {
        return this.zza.zzD(bundle, true);
    }

    public void registerOnMeasurementEventListener(@RecentlyNonNull OnEventListener onEventListener) {
        this.zza.zze(onEventListener);
    }

    public void setConditionalUserProperty(@RecentlyNonNull Bundle bundle) {
        this.zza.zzk(bundle);
    }

    public void setConsent(@RecentlyNonNull Bundle bundle) {
        this.zza.zzq(bundle);
    }

    public void setCurrentScreen(@RecentlyNonNull Activity activity, String str, String str2) {
        this.zza.zzo(activity, str, str2);
    }

    public void setUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Object obj) {
        this.zza.zzj(str, str2, obj, true);
    }

    public final void zza(boolean z) {
        this.zza.zzI(z);
    }

    @RecentlyNonNull
    public static AppMeasurementSdk getInstance(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull String str2, String str3, @RecentlyNonNull Bundle bundle) {
        return zzbs.zza(context, str, str2, str3, bundle).zzb();
    }
}
