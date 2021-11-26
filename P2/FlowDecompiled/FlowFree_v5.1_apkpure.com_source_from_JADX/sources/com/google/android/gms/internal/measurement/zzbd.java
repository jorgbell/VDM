package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzbd extends zzbh {
    final /* synthetic */ zzbj zza;
    final /* synthetic */ zzbs zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbd(zzbs zzbs, zzbj zzbj) {
        super(zzbs, true);
        this.zzb = zzbs;
        this.zza = zzbj;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzb.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.registerOnMeasurementEventListener(this.zza);
    }
}
