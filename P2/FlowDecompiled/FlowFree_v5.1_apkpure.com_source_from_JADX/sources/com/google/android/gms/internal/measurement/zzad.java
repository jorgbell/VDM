package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzad extends zzbh {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzn zzc;
    final /* synthetic */ zzbs zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzad(zzbs zzbs, String str, String str2, zzn zzn) {
        super(zzbs, true);
        this.zzd = zzbs;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zzd.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zzb((Bundle) null);
    }
}
