package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzbo extends zzbh {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbo(zzbr zzbr, Activity activity) {
        super(zzbr.zza, true);
        this.zzb = zzbr;
        this.zza = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzb.zza.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.onActivityStopped(ObjectWrapper.wrap(this.zza), this.zzi);
    }
}
