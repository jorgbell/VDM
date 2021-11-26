package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbbp;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbo extends zzb {
    private final zzbbp zza;
    private final String zzb;

    public zzbo(Context context, String str, String str2) {
        this.zza = new zzbbp(zzs.zzc().zze(context, str));
        this.zzb = str2;
    }

    public final void zza() {
        this.zza.zza(this.zzb);
    }
}
