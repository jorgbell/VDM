package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzavh implements Runnable {
    private final zzbbp zza;
    private final String zzb;

    zzavh(zzbbp zzbbp, String str) {
        this.zza = zzbbp;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
