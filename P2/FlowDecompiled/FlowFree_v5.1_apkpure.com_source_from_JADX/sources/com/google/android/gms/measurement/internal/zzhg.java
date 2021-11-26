package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhg implements zzko {
    final /* synthetic */ zzhr zza;

    zzhg(zzhr zzhr) {
        this.zza = zzhr;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzs("auto", "_err", bundle);
        } else {
            zzfp.zzP();
            throw null;
        }
    }
}
