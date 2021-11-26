package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzas extends zzbh {
    final /* synthetic */ zzn zza;
    final /* synthetic */ zzbs zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzas(zzbs zzbs, zzn zzn) {
        super(zzbs, true);
        this.zzb = zzbs;
        this.zza = zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzb.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.getCurrentScreenClass(this.zza);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zza.zzb((Bundle) null);
    }
}
