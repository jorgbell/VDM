package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzid implements zziy, zziz {
    private final int zza;
    private zzja zzb;
    private int zzc;
    private int zzd;
    private zzog zze;
    private long zzf;
    private boolean zzg = true;
    private boolean zzh;

    public zzid(int i) {
        this.zza = i;
    }

    /* access modifiers changed from: protected */
    public final int zzA(zziu zziu, zzkm zzkm, boolean z) {
        zziu zziu2 = zziu;
        zzkm zzkm2 = zzkm;
        int zzc2 = this.zze.zzc(zziu2, zzkm2, z);
        if (zzc2 == -4) {
            if (zzkm.zzc()) {
                this.zzg = true;
                return this.zzh ? -4 : -3;
            }
            zzkm2.zzc += this.zzf;
        } else if (zzc2 == -5) {
            zzit zzit = zziu2.zza;
            long j = zzit.zzw;
            if (j != Long.MAX_VALUE) {
                zziu2.zza = new zzit(zzit.zza, zzit.zze, zzit.zzf, zzit.zzc, zzit.zzb, zzit.zzg, zzit.zzj, zzit.zzk, zzit.zzl, zzit.zzm, zzit.zzn, zzit.zzp, zzit.zzo, zzit.zzq, zzit.zzr, zzit.zzs, zzit.zzt, zzit.zzu, zzit.zzv, zzit.zzx, zzit.zzy, zzit.zzz, j + this.zzf, zzit.zzh, zzit.zzi, zzit.zzd);
                return -5;
            }
        }
        return zzc2;
    }

    /* access modifiers changed from: protected */
    public final void zzB(long j) {
        this.zze.zzd(j - this.zzf);
    }

    /* access modifiers changed from: protected */
    public final boolean zzC() {
        return this.zzg ? this.zzh : this.zze.zza();
    }

    public final int zza() {
        return this.zza;
    }

    public final zziz zzb() {
        return this;
    }

    public final void zzc(int i) {
        this.zzc = i;
    }

    public zzpy zzd() {
        return null;
    }

    public final int zze() {
        return this.zzd;
    }

    public final void zzf(zzja zzja, zzit[] zzitArr, zzog zzog, long j, boolean z, long j2) throws zzif {
        zzpu.zzd(this.zzd == 0);
        this.zzb = zzja;
        this.zzd = 1;
        zzs(z);
        zzh(zzitArr, zzog, j2);
        zzu(j, z);
    }

    public final void zzg() throws zzif {
        boolean z = true;
        if (this.zzd != 1) {
            z = false;
        }
        zzpu.zzd(z);
        this.zzd = 2;
        zzv();
    }

    public final void zzh(zzit[] zzitArr, zzog zzog, long j) throws zzif {
        zzpu.zzd(!this.zzh);
        this.zze = zzog;
        this.zzg = false;
        this.zzf = j;
        zzt(zzitArr, j);
    }

    public final zzog zzi() {
        return this.zze;
    }

    public final boolean zzj() {
        return this.zzg;
    }

    public final void zzk() {
        this.zzh = true;
    }

    public final boolean zzl() {
        return this.zzh;
    }

    public final void zzm() throws IOException {
        this.zze.zzb();
    }

    public final void zzn(long j) throws zzif {
        this.zzh = false;
        this.zzg = false;
        zzu(j, false);
    }

    public final void zzo() throws zzif {
        zzpu.zzd(this.zzd == 2);
        this.zzd = 1;
        zzw();
    }

    public final void zzp() {
        boolean z = true;
        if (this.zzd != 1) {
            z = false;
        }
        zzpu.zzd(z);
        this.zzd = 0;
        this.zze = null;
        this.zzh = false;
        zzx();
    }

    /* access modifiers changed from: protected */
    public abstract void zzs(boolean z) throws zzif;

    /* access modifiers changed from: protected */
    public void zzt(zzit[] zzitArr, long j) throws zzif {
    }

    /* access modifiers changed from: protected */
    public abstract void zzu(long j, boolean z) throws zzif;

    /* access modifiers changed from: protected */
    public abstract void zzv() throws zzif;

    /* access modifiers changed from: protected */
    public abstract void zzw() throws zzif;

    /* access modifiers changed from: protected */
    public abstract void zzx();

    /* access modifiers changed from: protected */
    public final zzja zzy() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final int zzz() {
        return this.zzc;
    }
}
