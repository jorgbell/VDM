package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzau extends zzbh {
    final /* synthetic */ String zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzbs zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzbs zzbs, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(zzbs, false);
        this.zzc = zzbs;
        this.zza = str;
        this.zzb = obj;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzc.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.logHealthData(5, this.zza, ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
    }
}
