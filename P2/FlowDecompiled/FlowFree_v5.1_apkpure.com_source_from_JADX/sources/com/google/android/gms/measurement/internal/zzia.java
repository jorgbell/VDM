package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzia implements Runnable {
    final /* synthetic */ zzhy zza;
    final /* synthetic */ zzhy zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzif zze;

    zzia(zzif zzif, zzhy zzhy, zzhy zzhy2, long j, boolean z) {
        this.zze = zzif;
        this.zza = zzhy;
        this.zzb = zzhy2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzB(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
