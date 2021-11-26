package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxh {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzdxh zza = new zzdxh();
    private Context zzb;

    private zzdxh() {
    }

    public static zzdxh zza() {
        return zza;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zzb = context != null ? context.getApplicationContext() : null;
    }
}
