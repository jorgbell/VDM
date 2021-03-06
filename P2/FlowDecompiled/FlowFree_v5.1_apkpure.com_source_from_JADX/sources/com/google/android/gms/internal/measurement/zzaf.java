package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzaf extends zzbh {
    final /* synthetic */ Activity zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbs zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaf(zzbs zzbs, Activity activity, String str, String str2) {
        super(zzbs, true);
        this.zzd = zzbs;
        this.zza = activity;
        this.zzb = str;
        this.zzc = str2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzd.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.setCurrentScreen(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzh);
    }
}
