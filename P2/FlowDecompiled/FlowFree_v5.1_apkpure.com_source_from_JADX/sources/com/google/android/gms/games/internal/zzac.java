package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public interface zzac extends IInterface {
    Bundle getConnectionHint() throws RemoteException;

    void zza(long j) throws RemoteException;

    void zza(IBinder iBinder, Bundle bundle) throws RemoteException;

    void zza(zzaa zzaa, long j) throws RemoteException;

    void zza(zzy zzy) throws RemoteException;

    void zza(zzy zzy, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void zza(zzy zzy, String str, boolean z, int i) throws RemoteException;

    Intent zzaq() throws RemoteException;

    void zzb(zzy zzy, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzbd() throws RemoteException;
}
