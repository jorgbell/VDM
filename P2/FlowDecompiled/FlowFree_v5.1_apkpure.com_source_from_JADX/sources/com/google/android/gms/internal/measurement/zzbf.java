package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzbf extends zzbh {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzbs zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzbs zzbs, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzbs, true);
        this.zzg = zzbs;
        this.zza = l;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z;
        this.zzf = z2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        Long l = this.zza;
        long longValue = l == null ? this.zzh : l.longValue();
        zzq zzP = this.zzg.zzj;
        Preconditions.checkNotNull(zzP);
        zzP.logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, longValue);
    }
}
