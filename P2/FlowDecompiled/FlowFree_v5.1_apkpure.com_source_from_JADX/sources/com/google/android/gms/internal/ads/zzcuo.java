package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcuo {
    private int zza = 0;
    private long zzb = 0;
    private long zzc = 0;
    private long zzd = 0;
    private final Object zze = new Object();
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private final Object zzh = new Object();

    public final void zza(int i) {
        synchronized (this.zze) {
            this.zza = i;
        }
    }

    public final int zzb() {
        int i;
        synchronized (this.zze) {
            i = this.zza;
        }
        return i;
    }

    public final void zzc(long j) {
        synchronized (this.zzf) {
            this.zzb = j;
        }
    }

    public final long zzd() {
        long j;
        synchronized (this.zzf) {
            j = this.zzb;
        }
        return j;
    }

    public final synchronized void zze(long j) {
        synchronized (this.zzg) {
            this.zzc = j;
        }
    }

    public final synchronized long zzf() {
        long j;
        synchronized (this.zzg) {
            j = this.zzc;
        }
        return j;
    }

    public final synchronized void zzg(long j) {
        synchronized (this.zzh) {
            this.zzd = j;
        }
    }

    public final synchronized long zzh() {
        long j;
        synchronized (this.zzh) {
            j = this.zzd;
        }
        return j;
    }
}
