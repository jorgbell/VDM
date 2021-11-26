package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzkg implements zzko {
    final /* synthetic */ zzki zza;

    zzkg(zzki zzki) {
        this.zza = zzki;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzav().zzh(new zzkf(this, str, "_err", bundle));
        } else if (this.zza.zzm != null) {
            this.zza.zzm.zzau().zzb().zzb("AppId not known when logging event", "_err");
        }
    }
}
