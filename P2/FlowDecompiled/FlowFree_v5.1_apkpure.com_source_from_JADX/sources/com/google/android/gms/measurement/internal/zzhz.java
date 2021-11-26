package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhz implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhy zzb;
    final /* synthetic */ zzhy zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzif zze;

    zzhz(zzif zzif, Bundle bundle, zzhy zzhy, zzhy zzhy2, long j) {
        this.zze = zzif;
        this.zza = bundle;
        this.zzb = zzhy;
        this.zzc = zzhy2;
        this.zzd = j;
    }

    public final void run() {
        zzif.zzu(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
