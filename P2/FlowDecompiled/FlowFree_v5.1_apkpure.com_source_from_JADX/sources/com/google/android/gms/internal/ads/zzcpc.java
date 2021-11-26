package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcpc implements Runnable {
    private final zzcpj zza;
    private final Object zzb;
    private final zzbcb zzc;
    private final String zzd;
    private final long zze;

    zzcpc(zzcpj zzcpj, Object obj, zzbcb zzbcb, String str, long j) {
        this.zza = zzcpj;
        this.zzb = obj;
        this.zzc = zzbcb;
        this.zzd = str;
        this.zze = j;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
