package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzgg implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgh zze;

    zzgg(zzgh zzgh, String str, String str2, String str3, long j) {
        this.zze = zzgh;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzO().zzx().zzn(this.zzb, (zzhy) null);
            return;
        }
        this.zze.zza.zzO().zzx().zzn(this.zzb, new zzhy(this.zzc, str, this.zzd));
    }
}
