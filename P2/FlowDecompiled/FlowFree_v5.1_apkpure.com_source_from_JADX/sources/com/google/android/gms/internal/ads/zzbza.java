package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbza implements Runnable {
    private final zzbzb zza;
    private final Object zzb;

    zzbza(zzbzb zzbzb, Object obj) {
        this.zza = zzbzb;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th) {
            zzs.zzg().zzh(th, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th);
        }
    }
}
