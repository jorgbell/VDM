package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdzf {
    private final Context zza;
    private final Looper zzb;

    public zzdzf(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzdzv zza2 = zzdzz.zza();
        zza2.zzb(this.zza.getPackageName());
        zza2.zza(zzdzy.BLOCKED_IMPRESSION);
        zzdzs zza3 = zzdzt.zza();
        zza3.zzb(str);
        zza3.zza(zzdzr.BLOCKED_REASON_BACKGROUND);
        zza2.zzc(zza3);
        new zzdzg(this.zza, this.zzb, (zzdzz) zza2.zzah()).zza();
    }
}
