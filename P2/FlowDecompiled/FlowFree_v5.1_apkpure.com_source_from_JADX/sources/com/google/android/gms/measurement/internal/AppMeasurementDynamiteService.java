package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzlf;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.internal.measurement.zzz;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.3 */
public class AppMeasurementDynamiteService extends zzp {
    zzfp zza = null;
    private final Map<Integer, zzgq> zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzt zzt, String str) {
        zzb();
        this.zza.zzl().zzad(zzt, str);
    }

    public void beginAdUnitExposure(@RecentlyNonNull String str, long j) throws RemoteException {
        zzb();
        this.zza.zzB().zza(str, j);
    }

    public void clearConditionalUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzk().zzO(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzn((Boolean) null);
    }

    public void endAdUnitExposure(@RecentlyNonNull String str, long j) throws RemoteException {
        zzb();
        this.zza.zzB().zzb(str, j);
    }

    public void generateEventId(zzt zzt) throws RemoteException {
        zzb();
        long zzd = this.zza.zzl().zzd();
        zzb();
        this.zza.zzl().zzae(zzt, zzd);
    }

    public void getAppInstanceId(zzt zzt) throws RemoteException {
        zzb();
        this.zza.zzav().zzh(new zzh(this, zzt));
    }

    public void getCachedAppInstanceId(zzt zzt) throws RemoteException {
        zzb();
        zzc(zzt, this.zza.zzk().zzD());
    }

    public void getConditionalUserProperties(String str, String str2, zzt zzt) throws RemoteException {
        zzb();
        this.zza.zzav().zzh(new zzl(this, zzt, str, str2));
    }

    public void getCurrentScreenClass(zzt zzt) throws RemoteException {
        zzb();
        zzc(zzt, this.zza.zzk().zzS());
    }

    public void getCurrentScreenName(zzt zzt) throws RemoteException {
        zzb();
        zzc(zzt, this.zza.zzk().zzR());
    }

    public void getGmpAppId(zzt zzt) throws RemoteException {
        zzb();
        zzc(zzt, this.zza.zzk().zzT());
    }

    public void getMaxUserProperties(String str, zzt zzt) throws RemoteException {
        zzb();
        this.zza.zzk().zzL(str);
        zzb();
        this.zza.zzl().zzaf(zzt, 25);
    }

    public void getTestFlag(zzt zzt, int i) throws RemoteException {
        zzb();
        if (i == 0) {
            this.zza.zzl().zzad(zzt, this.zza.zzk().zzj());
        } else if (i == 1) {
            this.zza.zzl().zzae(zzt, this.zza.zzk().zzk().longValue());
        } else if (i == 2) {
            zzkp zzl = this.zza.zzl();
            double doubleValue = this.zza.zzk().zzm().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzt.zzb(bundle);
            } catch (RemoteException e) {
                zzl.zzs.zzau().zze().zzb("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzl().zzaf(zzt, this.zza.zzk().zzl().intValue());
        } else if (i == 4) {
            this.zza.zzl().zzah(zzt, this.zza.zzk().zzi().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzt zzt) throws RemoteException {
        zzb();
        this.zza.zzav().zzh(new zzj(this, zzt, str, str2, z));
    }

    public void initForTests(@RecentlyNonNull Map map) throws RemoteException {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzz zzz, long j) throws RemoteException {
        zzfp zzfp = this.zza;
        if (zzfp == null) {
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            Preconditions.checkNotNull(context);
            this.zza = zzfp.zzC(context, zzz, Long.valueOf(j));
            return;
        }
        zzfp.zzau().zze().zza("Attempting to initialize multiple times");
    }

    public void isDataCollectionEnabled(zzt zzt) throws RemoteException {
        zzb();
        this.zza.zzav().zzh(new zzm(this, zzt));
    }

    public void logEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzv(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzt zzt, long j) throws RemoteException {
        zzb();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzav().zzh(new zzi(this, zzt, new zzas(str2, new zzaq(bundle), "app", j), str));
    }

    public void logHealthData(int i, @RecentlyNonNull String str, @RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull IObjectWrapper iObjectWrapper2, @RecentlyNonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzau().zzm(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(@RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhq zzhq = this.zza.zzk().zza;
        if (zzhq != null) {
            this.zza.zzk().zzh();
            zzhq.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhq zzhq = this.zza.zzk().zza;
        if (zzhq != null) {
            this.zza.zzk().zzh();
            zzhq.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhq zzhq = this.zza.zzk().zza;
        if (zzhq != null) {
            this.zza.zzk().zzh();
            zzhq.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhq zzhq = this.zza.zzk().zza;
        if (zzhq != null) {
            this.zza.zzk().zzh();
            zzhq.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzt zzt, long j) throws RemoteException {
        zzb();
        zzhq zzhq = this.zza.zzk().zza;
        Bundle bundle = new Bundle();
        if (zzhq != null) {
            this.zza.zzk().zzh();
            zzhq.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzt.zzb(bundle);
        } catch (RemoteException e) {
            this.zza.zzau().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzk().zza != null) {
            this.zza.zzk().zzh();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzk().zza != null) {
            this.zza.zzk().zzh();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzt zzt, long j) throws RemoteException {
        zzb();
        zzt.zzb((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzw zzw) throws RemoteException {
        zzgq zzgq;
        zzb();
        synchronized (this.zzb) {
            zzgq = this.zzb.get(Integer.valueOf(zzw.zze()));
            if (zzgq == null) {
                zzgq = new zzo(this, zzw);
                this.zzb.put(Integer.valueOf(zzw.zze()), zzgq);
            }
        }
        this.zza.zzk().zzJ(zzgq);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzF(j);
    }

    public void setConditionalUserProperty(@RecentlyNonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzau().zzb().zza("Conditional user property must not be null");
        } else {
            this.zza.zzk().zzN(bundle, j);
        }
    }

    public void setConsent(@RecentlyNonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhr zzk = this.zza.zzk();
        zzlf.zzb();
        if (zzk.zzs.zzc().zzn((String) null, zzea.zzau)) {
            zzlo.zzb();
            if (!zzk.zzs.zzc().zzn((String) null, zzea.zzaF) || TextUtils.isEmpty(zzk.zzs.zzA().zzj())) {
                zzk.zzo(bundle, 0, j);
            } else {
                zzk.zzs.zzau().zzh().zza("Using developer consent only; google app id found");
            }
        }
    }

    public void setConsentThirdParty(@RecentlyNonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhr zzk = this.zza.zzk();
        zzlf.zzb();
        if (zzk.zzs.zzc().zzn((String) null, zzea.zzav)) {
            zzk.zzo(bundle, -20, j);
        }
    }

    public void setCurrentScreen(@RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull String str, @RecentlyNonNull String str2, long j) throws RemoteException {
        zzb();
        this.zza.zzx().zzk((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzhr zzk = this.zza.zzk();
        zzk.zzb();
        zzk.zzs.zzav().zzh(new zzgu(zzk, z));
    }

    public void setDefaultEventParameters(@RecentlyNonNull Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzhr zzk = this.zza.zzk();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzk.zzs.zzav().zzh(new zzgs(zzk, bundle2));
    }

    public void setEventInterceptor(zzw zzw) throws RemoteException {
        zzb();
        zzn zzn = new zzn(this, zzw);
        if (this.zza.zzav().zzd()) {
            this.zza.zzk().zzI(zzn);
        } else {
            this.zza.zzav().zzh(new zzk(this, zzn));
        }
    }

    public void setInstanceIdProvider(zzy zzy) throws RemoteException {
        zzb();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzn(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzb();
        zzhr zzk = this.zza.zzk();
        zzk.zzs.zzav().zzh(new zzgw(zzk, j));
    }

    public void setUserId(@RecentlyNonNull String str, long j) throws RemoteException {
        zzb();
        if (!this.zza.zzc().zzn((String) null, zzea.zzaD) || str == null || str.length() != 0) {
            this.zza.zzk().zzz((String) null, "_id", str, true, j);
        } else {
            this.zza.zzau().zze().zza("User ID must be non-empty");
        }
    }

    public void setUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzk().zzz(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzw zzw) throws RemoteException {
        zzgq remove;
        zzb();
        synchronized (this.zzb) {
            remove = this.zzb.remove(Integer.valueOf(zzw.zze()));
        }
        if (remove == null) {
            remove = new zzo(this, zzw);
        }
        this.zza.zzk().zzK(remove);
    }
}
