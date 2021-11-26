package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzmj {
    public zzlx zza;
    public long zzb;
    public long zzc;
    public int zzd;
    public int zze;
    public long[] zzf;
    public int[] zzg;
    public int[] zzh;
    public int[] zzi;
    public long[] zzj;
    public boolean[] zzk;
    public boolean zzl;
    public boolean[] zzm;
    public zzmi zzn;
    public int zzo;
    public zzqc zzp;
    public boolean zzq;
    public long zzr;

    zzmj() {
    }

    public final void zza(int i) {
        zzqc zzqc = this.zzp;
        if (zzqc == null || zzqc.zze() < i) {
            this.zzp = new zzqc(i);
        }
        this.zzo = i;
        this.zzl = true;
        this.zzq = true;
    }
}
