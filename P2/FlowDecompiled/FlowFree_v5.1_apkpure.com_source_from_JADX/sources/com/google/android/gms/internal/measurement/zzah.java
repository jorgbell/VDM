package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzah extends zzbh {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzbs zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzah(zzbs zzbs, Bundle bundle) {
        super(zzbs, true);
        this.zzb = zzbs;
        this.zza = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzb.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.setConsent(this.zza, this.zzh);
    }
}
