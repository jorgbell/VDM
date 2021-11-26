package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcsx implements Callable {
    private final zzefw zza;
    private final zzefw zzb;

    zzcsx(zzefw zzefw, zzefw zzefw2) {
        this.zza = zzefw;
        this.zzb = zzefw2;
    }

    public final Object call() {
        zzefw zzefw = this.zza;
        zzefw zzefw2 = this.zzb;
        return new zzctj((zzctn) zzefw.get(), ((zzcth) zzefw2.get()).zzb, ((zzcth) zzefw2.get()).zza);
    }
}
