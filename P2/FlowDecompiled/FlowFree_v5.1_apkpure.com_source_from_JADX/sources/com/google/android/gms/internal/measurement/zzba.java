package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzba extends zzbh {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzbs zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzba(zzbs zzbs, boolean z) {
        super(zzbs, true);
        this.zzb = zzbs;
        this.zza = z;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzb.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.setDataCollectionEnabled(this.zza);
    }
}
