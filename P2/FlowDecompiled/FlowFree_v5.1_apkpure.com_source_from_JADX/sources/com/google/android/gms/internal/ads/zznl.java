package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zznl implements Runnable {
    final /* synthetic */ zzno zza;
    final /* synthetic */ zznq zzb;

    zznl(zznq zznq, zzno zzno) {
        this.zzb = zznq;
        this.zza = zzno;
    }

    public final void run() {
        this.zza.zza();
        int size = this.zzb.zzn.size();
        for (int i = 0; i < size; i++) {
            ((zzof) this.zzb.zzn.valueAt(i)).zzg();
        }
    }
}
