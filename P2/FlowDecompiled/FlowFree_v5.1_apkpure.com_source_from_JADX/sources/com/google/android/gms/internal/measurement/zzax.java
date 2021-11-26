package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzax extends zzbh {
    final /* synthetic */ String zza;
    final /* synthetic */ zzn zzb;
    final /* synthetic */ zzbs zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzbs zzbs, String str, zzn zzn) {
        super(zzbs, true);
        this.zzc = zzbs;
        this.zza = str;
        this.zzb = zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzc.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.getMaxUserProperties(this.zza, this.zzb);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzb.zzb((Bundle) null);
    }
}
