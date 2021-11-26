package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games.zzb;
import com.google.android.gms.internal.games.zzd;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzaf extends zzb implements zzac {
    zzaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    public final void zza(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzb(5001, zza);
    }

    public final void zza(zzy zzy) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzy);
        zzb(5002, zza);
    }

    public final Bundle getConnectionHint() throws RemoteException {
        Parcel zza = zza(5004, zza());
        Bundle bundle = (Bundle) zzd.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final void zza(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(5005, zza);
    }

    public final void zzbd() throws RemoteException {
        zzb(5006, zza());
    }

    public final void zzb(zzy zzy, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzy);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzd.zza(zza, (Parcelable) bundle);
        zzb(5024, zza);
    }

    public final Intent zzaq() throws RemoteException {
        Parcel zza = zza(9005, zza());
        Intent intent = (Intent) zzd.zza(zza, Intent.CREATOR);
        zza.recycle();
        return intent;
    }

    public final void zza(zzy zzy, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzy);
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) snapshotMetadataChangeEntity);
        zzd.zza(zza, (Parcelable) contents);
        zzb(12007, zza);
    }

    public final void zza(zzy zzy, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzy);
        zza.writeString(str);
        zzd.writeBoolean(zza, z);
        zza.writeInt(i);
        zzb(15001, zza);
    }

    public final void zza(zzaa zzaa, long j) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzaa);
        zza.writeLong(j);
        zzb(15501, zza);
    }
}
