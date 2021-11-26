package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzof implements zzld {
    private final zzoc zza = new zzoc();
    private final zzob zzb = new zzob();
    private final zzqc zzc = new zzqc(32);
    private final AtomicInteger zzd = new AtomicInteger();
    private zzod zze;
    private zzod zzf;
    private zzit zzg;
    private long zzi;
    private int zzj = 65536;
    private zzoe zzk;
    private final zzph zzl;

    public zzof(zzph zzph, byte[] bArr) {
        this.zzl = zzph;
        zzod zzod = new zzod(0, 65536);
        this.zze = zzod;
        this.zzf = zzod;
    }

    private final void zzo(long j, byte[] bArr, int i) {
        zzp(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zze.zza);
            int min = Math.min(i - i2, 65536 - i3);
            zzpb zzpb = this.zze.zzd;
            System.arraycopy(zzpb.zza, i3, bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.zze.zzb) {
                this.zzl.zzd(zzpb);
                zzod zzod = this.zze;
                zzod.zzd = null;
                this.zze = zzod.zze;
            }
        }
    }

    private final void zzp(long j) {
        while (true) {
            zzod zzod = this.zze;
            if (j >= zzod.zzb) {
                this.zzl.zzd(zzod.zzd);
                zzod zzod2 = this.zze;
                zzod2.zzd = null;
                this.zze = zzod2.zze;
            } else {
                return;
            }
        }
    }

    private final boolean zzq() {
        return this.zzd.compareAndSet(0, 1);
    }

    private final void zzr() {
        if (!this.zzd.compareAndSet(1, 0)) {
            zzs();
        }
    }

    private final void zzs() {
        this.zza.zza();
        zzod zzod = this.zze;
        if (zzod.zzc) {
            zzod zzod2 = this.zzf;
            int i = (zzod2.zzc ? 1 : 0) + (((int) (zzod2.zza - zzod.zza)) / 65536);
            zzpb[] zzpbArr = new zzpb[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzpbArr[i2] = zzod.zzd;
                zzod.zzd = null;
                zzod = zzod.zze;
            }
            this.zzl.zze(zzpbArr);
        }
        zzod zzod3 = new zzod(0, 65536);
        this.zze = zzod3;
        this.zzf = zzod3;
        this.zzi = 0;
        this.zzj = 65536;
        this.zzl.zzf();
    }

    private final int zzt(int i) {
        if (this.zzj == 65536) {
            this.zzj = 0;
            zzod zzod = this.zzf;
            if (zzod.zzc) {
                this.zzf = zzod.zze;
            }
            zzod zzod2 = this.zzf;
            zzpb zzc2 = this.zzl.zzc();
            zzod zzod3 = new zzod(this.zzf.zzb, 65536);
            zzod2.zzd = zzc2;
            zzod2.zze = zzod3;
            zzod2.zzc = true;
        }
        return Math.min(i, 65536 - this.zzj);
    }

    public final void zza(zzit zzit) {
        if (zzit == null) {
            zzit = null;
        }
        boolean zzj2 = this.zza.zzj(zzit);
        zzoe zzoe = this.zzk;
        if (zzoe != null && zzj2) {
            zzoe.zzp(zzit);
        }
    }

    public final void zzb(zzqc zzqc, int i) {
        if (zzq()) {
            while (i > 0) {
                int zzt = zzt(i);
                zzqc.zzk(this.zzf.zzd.zza, this.zzj, zzt);
                this.zzj += zzt;
                this.zzi += (long) zzt;
                i -= zzt;
            }
            zzr();
            return;
        }
        zzqc.zzj(i);
    }

    public final void zzc(long j, int i, int i2, int i3, zzlc zzlc) {
        if (zzq()) {
            try {
                this.zza.zzk(j, i, this.zzi - ((long) i2), i2, zzlc);
            } finally {
                zzr();
            }
        } else {
            long j2 = j;
            this.zza.zzl(j);
        }
    }

    public final int zzd(zzkt zzkt, int i, boolean z) throws IOException, InterruptedException {
        if (!zzq()) {
            int zzc2 = zzkt.zzc(i);
            if (zzc2 != -1) {
                return zzc2;
            }
            throw new EOFException();
        }
        try {
            int zza2 = zzkt.zza(this.zzf.zzd.zza, this.zzj, zzt(i));
            if (zza2 != -1) {
                this.zzj += zza2;
                this.zzi += (long) zza2;
                return zza2;
            }
            throw new EOFException();
        } finally {
            zzr();
        }
    }

    public final void zze(boolean z) {
        int andSet = this.zzd.getAndSet(true != z ? 2 : 0);
        zzs();
        this.zza.zzb();
        if (andSet == 2) {
            this.zzg = null;
        }
    }

    public final int zzf() {
        return this.zza.zzc();
    }

    public final void zzg() {
        if (this.zzd.getAndSet(2) == 0) {
            zzs();
        }
    }

    public final boolean zzh() {
        return this.zza.zzd();
    }

    public final zzit zzi() {
        return this.zza.zze();
    }

    public final long zzj() {
        return this.zza.zzf();
    }

    public final void zzk() {
        long zzh = this.zza.zzh();
        if (zzh != -1) {
            zzp(zzh);
        }
    }

    public final boolean zzl(long j, boolean z) {
        long zzi2 = this.zza.zzi(j, z);
        if (zzi2 == -1) {
            return false;
        }
        zzp(zzi2);
        return true;
    }

    public final int zzm(zziu zziu, zzkm zzkm, boolean z, boolean z2, long j) {
        int i;
        zzkm zzkm2 = zzkm;
        int zzg2 = this.zza.zzg(zziu, zzkm, z, z2, this.zzg, this.zzb);
        if (zzg2 == -5) {
            this.zzg = zziu.zza;
            return -5;
        } else if (zzg2 != -4) {
            return -3;
        } else {
            if (!zzkm.zzc()) {
                if (zzkm2.zzc < j) {
                    zzkm2.zzf(Integer.MIN_VALUE);
                }
                if (zzkm.zzi()) {
                    zzob zzob = this.zzb;
                    long j2 = zzob.zzb;
                    this.zzc.zza(1);
                    zzo(j2, this.zzc.zza, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzc.zza[0];
                    byte b2 = b & 128;
                    byte b3 = b & Byte.MAX_VALUE;
                    zzkk zzkk = zzkm2.zza;
                    if (zzkk.zza == null) {
                        zzkk.zza = new byte[16];
                    }
                    zzo(j3, zzkk.zza, b3);
                    long j4 = j3 + ((long) b3);
                    if (b2 != 0) {
                        this.zzc.zza(2);
                        zzo(j4, this.zzc.zza, 2);
                        j4 += 2;
                        i = this.zzc.zzm();
                    } else {
                        i = 1;
                    }
                    zzkk zzkk2 = zzkm2.zza;
                    int[] iArr = zzkk2.zzd;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzkk2.zze;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (b2 != 0) {
                        int i2 = i * 6;
                        this.zzc.zza(i2);
                        zzo(j4, this.zzc.zza, i2);
                        j4 += (long) i2;
                        this.zzc.zzi(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr2[i3] = this.zzc.zzm();
                            iArr4[i3] = this.zzc.zzu();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zzob.zza - ((int) (j4 - zzob.zzb));
                    }
                    zzlc zzlc = zzob.zzd;
                    zzkk zzkk3 = zzkm2.zza;
                    byte[] bArr = zzlc.zzb;
                    byte[] bArr2 = zzkk3.zza;
                    int i4 = zzlc.zza;
                    zzkk3.zza(i, iArr2, iArr4, bArr, bArr2, 1);
                    long j5 = zzob.zzb;
                    int i5 = (int) (j4 - j5);
                    zzob.zzb = j5 + ((long) i5);
                    zzob.zza -= i5;
                }
                zzkm2.zzh(this.zzb.zza);
                zzob zzob2 = this.zzb;
                long j6 = zzob2.zzb;
                ByteBuffer byteBuffer = zzkm2.zzb;
                int i6 = zzob2.zza;
                zzp(j6);
                while (i6 > 0) {
                    int i7 = (int) (j6 - this.zze.zza);
                    int min = Math.min(i6, 65536 - i7);
                    zzpb zzpb = this.zze.zzd;
                    byteBuffer.put(zzpb.zza, i7, min);
                    j6 += (long) min;
                    i6 -= min;
                    if (j6 == this.zze.zzb) {
                        this.zzl.zzd(zzpb);
                        zzod zzod = this.zze;
                        zzod.zzd = null;
                        this.zze = zzod.zze;
                    }
                }
                zzp(this.zzb.zzc);
            }
            return -4;
        }
    }

    public final void zzn(zzoe zzoe) {
        this.zzk = zzoe;
    }
}
