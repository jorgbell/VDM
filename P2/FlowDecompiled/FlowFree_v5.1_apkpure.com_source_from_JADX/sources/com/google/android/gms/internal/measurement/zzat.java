package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzat extends zzbh {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ zzbs zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzat(zzbs zzbs, String str, String str2, boolean z, zzn zzn) {
        super(zzbs, true);
        this.zze = zzbs;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzq zzP = this.zze.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zzb((Bundle) null);
    }
}
