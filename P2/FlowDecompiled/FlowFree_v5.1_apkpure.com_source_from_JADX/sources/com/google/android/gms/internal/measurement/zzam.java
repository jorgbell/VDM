package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzam extends zzbh {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbs zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzbs zzbs, String str) {
        super(zzbs, true);
        this.zzb = zzbs;
        this.zza = str;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzb.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.beginAdUnitExposure(this.zza, this.zzi);
    }
}
