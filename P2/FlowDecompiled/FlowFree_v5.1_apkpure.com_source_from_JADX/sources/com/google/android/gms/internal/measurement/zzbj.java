package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgq;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.3 */
final class zzbj extends zzv {
    private final zzgq zza;

    zzbj(zzgq zzgq) {
        this.zza = zzgq;
    }

    public final void zzd(String str, String str2, Bundle bundle, long j) {
        this.zza.onEvent(str, str2, bundle, j);
    }

    public final int zze() {
        return System.identityHashCode(this.zza);
    }
}
