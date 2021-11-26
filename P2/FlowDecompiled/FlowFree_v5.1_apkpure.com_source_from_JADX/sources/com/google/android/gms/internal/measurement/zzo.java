package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public final class zzo extends zza implements zzq {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(23, zza);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzc(9, zza);
    }

    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(24, zza);
    }

    public final void generateEventId(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzt);
        zzc(22, zza);
    }

    public final void getCachedAppInstanceId(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzt);
        zzc(19, zza);
    }

    public final void getConditionalUserProperties(String str, String str2, zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, zzt);
        zzc(10, zza);
    }

    public final void getCurrentScreenClass(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzt);
        zzc(17, zza);
    }

    public final void getCurrentScreenName(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzt);
        zzc(16, zza);
    }

    public final void getGmpAppId(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzt);
        zzc(21, zza);
    }

    public final void getMaxUserProperties(String str, zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zze(zza, zzt);
        zzc(6, zza);
    }

    public final void getUserProperties(String str, String str2, boolean z, zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzb(zza, z);
        zzc.zze(zza, zzt);
        zzc(5, zza);
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzz zzz, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zzd(zza, zzz);
        zza.writeLong(j);
        zzc(1, zza);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzc.zzb(zza, z);
        zzc.zzb(zza, z2);
        zza.writeLong(j);
        zzc(2, zza);
    }

    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, iObjectWrapper2);
        zzc.zze(zza, iObjectWrapper3);
        zzc(33, zza);
    }

    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(27, zza);
    }

    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(28, zza);
    }

    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(29, zza);
    }

    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(30, zza);
    }

    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzt zzt, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzt);
        zza.writeLong(j);
        zzc(31, zza);
    }

    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(25, zza);
    }

    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(26, zza);
    }

    public final void performAction(Bundle bundle, zzt zzt, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc.zze(zza, zzt);
        zza.writeLong(j);
        zzc(32, zza);
    }

    public final void registerOnMeasurementEventListener(zzw zzw) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzw);
        zzc(35, zza);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(8, zza);
    }

    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(44, zza);
    }

    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(15, zza);
    }

    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(39, zza);
    }

    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, iObjectWrapper);
        zzc.zzb(zza, z);
        zza.writeLong(j);
        zzc(4, zza);
    }
}
