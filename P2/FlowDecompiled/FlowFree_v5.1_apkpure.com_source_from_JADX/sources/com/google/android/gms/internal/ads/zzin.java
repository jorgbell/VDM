package com.google.android.gms.internal.ads;

import android.util.Log;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzin {
    public final zznu zza;
    public final Object zzb;
    public final int zzc;
    public final zzog[] zzd = new zzog[2];
    public final boolean[] zze = new boolean[2];
    public final long zzf;
    public int zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public zzin zzl;
    public zzpa zzm;
    private final zziy[] zzn;
    private final zziz[] zzo;
    private final zzoz zzp;
    private final zznw zzq;
    private zzpa zzr;
    private final zzbel zzs;

    public final boolean zza() {
        return this.zzj && (!this.zzk || this.zza.zzj() == Long.MIN_VALUE);
    }

    public final boolean zzb() throws zzif {
        zzpa zzd2 = this.zzp.zzd(this.zzo, this.zza.zzg());
        zzpa zzpa = this.zzr;
        if (zzpa != null) {
            int i = 0;
            while (i < 2) {
                if (zzd2.zza(zzpa, i)) {
                    i++;
                }
            }
            return false;
        }
        this.zzm = zzd2;
        return true;
    }

    public final long zzc(long j, boolean z) {
        return zzd(j, false, new boolean[2]);
    }

    public final long zzd(long j, boolean z, boolean[] zArr) {
        zzox zzox = this.zzm.zzb;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= 2) {
                break;
            }
            boolean[] zArr2 = this.zze;
            if (z || !this.zzm.zza(this.zzr, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zzB = this.zza.zzB(zzox.zzb(), this.zze, this.zzd, zArr, j);
        this.zzr = this.zzm;
        this.zzk = false;
        int i2 = 0;
        while (true) {
            zzog[] zzogArr = this.zzd;
            if (i2 < 2) {
                if (zzogArr[i2] != null) {
                    zzpu.zzd(zzox.zza(i2) != null);
                    this.zzk = true;
                } else {
                    zzpu.zzd(zzox.zza(i2) == null);
                }
                i2++;
            } else {
                this.zzs.zzb(this.zzn, this.zzm.zza, zzox);
                return zzB;
            }
        }
    }

    public final void zze() {
        try {
            this.zzq.zzc(this.zza);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }

    public zzin(zziy[] zziyArr, zziz[] zzizArr, long j, zzoz zzoz, zzbel zzbel, zznw zznw, Object obj, int i, int i2, boolean z, long j2, byte[] bArr) {
        this.zzn = zziyArr;
        this.zzo = zzizArr;
        this.zzf = j;
        this.zzp = zzoz;
        this.zzs = zzbel;
        this.zzq = zznw;
        Objects.requireNonNull(obj);
        this.zzb = obj;
        this.zzc = i;
        this.zzg = i2;
        this.zzi = z;
        this.zzh = j2;
        this.zza = zznw.zze(i2, zzbel.zzl());
    }
}
