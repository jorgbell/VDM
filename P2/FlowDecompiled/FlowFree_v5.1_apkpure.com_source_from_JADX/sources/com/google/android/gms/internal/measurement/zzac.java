package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzac extends zzbh {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzbs zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzac(zzbs zzbs, String str, String str2, Bundle bundle) {
        super(zzbs, true);
        this.zzd = zzbs;
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzd.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
    }
}
