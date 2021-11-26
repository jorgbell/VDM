package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzbp extends zzbh {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzn zzb;
    final /* synthetic */ zzbr zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbp(zzbr zzbr, Activity activity, zzn zzn) {
        super(zzbr.zza, true);
        this.zzc = zzbr;
        this.zza = activity;
        this.zzb = zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzc.zza.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zza), this.zzb, this.zzi);
    }
}
