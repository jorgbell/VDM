package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzawi implements Callable<zzawh> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzawk zzb;

    zzawi(zzawk zzawk, Context context) {
        this.zzb = zzawk;
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzawh zzawh;
        zzawj zzawj = (zzawj) this.zzb.zza.get(this.zza);
        if (zzawj == null || zzawj.zza + zzafv.zza.zze().longValue() < zzs.zzj().currentTimeMillis()) {
            zzawh = new zzawg(this.zza).zza();
        } else {
            zzawh = new zzawg(this.zza, zzawj.zzb).zza();
        }
        this.zzb.zza.put(this.zza, new zzawj(this.zzb, zzawh));
        return zzawh;
    }
}
