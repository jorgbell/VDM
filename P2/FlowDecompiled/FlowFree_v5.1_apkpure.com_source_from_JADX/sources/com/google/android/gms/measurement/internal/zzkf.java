package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzkf implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb = "_err";
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzkg zzd;

    zzkf(zzkg zzkg, String str, String str2, Bundle bundle) {
        this.zzd = zzkg;
        this.zza = str;
        this.zzc = bundle;
    }

    public final void run() {
        zzas zzV = this.zzd.zza.zzq().zzV(this.zza, this.zzb, this.zzc, "auto", this.zzd.zza.zzay().currentTimeMillis(), false, false);
        zzki zzki = this.zzd.zza;
        Preconditions.checkNotNull(zzV);
        zzki.zzv(zzV, this.zza);
    }
}
