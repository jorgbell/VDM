package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeen implements Runnable {
    final /* synthetic */ zzedb zza;
    final /* synthetic */ zzeeo zzb;

    zzeen(zzeeo zzeeo, zzedb zzedb) {
        this.zzb = zzeeo;
        this.zza = zzedb;
    }

    public final void run() {
        zzeeo.zzA(this.zzb, this.zza);
    }
}
