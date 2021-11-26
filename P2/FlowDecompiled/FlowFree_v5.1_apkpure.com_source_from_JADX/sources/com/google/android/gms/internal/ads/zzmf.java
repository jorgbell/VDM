package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzmf implements zzku, zzlb {
    private static final int zzb = zzqj.zzl("qt  ");
    private final zzqc zzc = new zzqc(zzqa.zza);
    private final zzqc zzd = new zzqc(4);
    private final zzqc zze = new zzqc(16);
    private final Stack<zzln> zzf = new Stack<>();
    private int zzg;
    private int zzh;
    private long zzi;
    private int zzj;
    private zzqc zzk;
    private int zzl;
    private int zzm;
    private zzkv zzn;
    private zzme[] zzo;
    private long zzp;
    private boolean zzq;

    private final void zzh() {
        this.zzg = 0;
        this.zzj = 0;
    }

    private final void zzi(long j) throws zziw {
        zzmz zzmz;
        zzmz zzmz2;
        zzky zzky;
        zzmh zza;
        while (!this.zzf.isEmpty() && this.zzf.peek().zza == j) {
            zzln pop = this.zzf.pop();
            if (pop.zzaR == zzlp.zzE) {
                ArrayList arrayList = new ArrayList();
                zzky zzky2 = new zzky();
                zzlo zzc2 = pop.zzc(zzlp.zzaC);
                if (zzc2 != null) {
                    zzmz = zzlw.zzc(zzc2, this.zzq);
                    if (zzmz != null) {
                        zzky2.zza(zzmz);
                    }
                } else {
                    zzmz = null;
                }
                long j2 = -9223372036854775807L;
                long j3 = Long.MAX_VALUE;
                int i = 0;
                while (i < pop.zzc.size()) {
                    zzln zzln = pop.zzc.get(i);
                    if (zzln.zzaR == zzlp.zzG && (zza = zzlw.zza(zzln, pop.zzc(zzlp.zzF), -9223372036854775807L, (zzkq) null, this.zzq)) != null) {
                        zzmk zzb2 = zzlw.zzb(zza, zzln.zzd(zzlp.zzH).zzd(zzlp.zzI).zzd(zzlp.zzJ), zzky2);
                        if (zzb2.zza != 0) {
                            zzme zzme = new zzme(zza, zzb2, this.zzn.zzbf(i, zza.zzb));
                            zzit zzg2 = zza.zzf.zzg(zzb2.zzd + 30);
                            if (zza.zzb == 1) {
                                if (zzky2.zzb()) {
                                    zzg2 = zzg2.zzh(zzky2.zzb, zzky2.zzc);
                                }
                                if (zzmz != null) {
                                    zzg2 = zzg2.zzj(zzmz);
                                }
                            }
                            zzme.zzc.zza(zzg2);
                            zzky = zzky2;
                            zzmz2 = zzmz;
                            long max = Math.max(j2, zza.zze);
                            arrayList.add(zzme);
                            long j4 = zzb2.zzb[0];
                            if (j4 < j3) {
                                j2 = max;
                                j3 = j4;
                            } else {
                                j2 = max;
                            }
                            i++;
                            zzky2 = zzky;
                            zzmz = zzmz2;
                        }
                    }
                    zzky = zzky2;
                    zzmz2 = zzmz;
                    i++;
                    zzky2 = zzky;
                    zzmz = zzmz2;
                }
                this.zzp = j2;
                this.zzo = (zzme[]) arrayList.toArray(new zzme[arrayList.size()]);
                this.zzn.zzbg();
                this.zzn.zzc(this);
                this.zzf.clear();
                this.zzg = 2;
            } else if (!this.zzf.isEmpty()) {
                this.zzf.peek().zzb(pop);
            }
        }
        if (this.zzg != 2) {
            zzh();
        }
    }

    public final boolean zza() {
        return true;
    }

    public final long zzb() {
        return this.zzp;
    }

    public final long zzc(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzme zzme : this.zzo) {
            zzmk zzmk = zzme.zzb;
            int zza = zzmk.zza(j);
            if (zza == -1) {
                zza = zzmk.zzb(j);
            }
            long j3 = zzmk.zzb[zza];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public final void zzd(zzkv zzkv) {
        this.zzn = zzkv;
    }

    public final void zze(long j, long j2) {
        this.zzf.clear();
        this.zzj = 0;
        this.zzl = 0;
        this.zzm = 0;
        if (j == 0) {
            zzh();
            return;
        }
        zzme[] zzmeArr = this.zzo;
        if (zzmeArr != null) {
            for (zzme zzme : zzmeArr) {
                zzmk zzmk = zzme.zzb;
                int zza = zzmk.zza(j2);
                if (zza == -1) {
                    zza = zzmk.zzb(j2);
                }
                zzme.zzd = zza;
            }
        }
    }

    public final boolean zzf(zzkt zzkt) throws IOException, InterruptedException {
        return zzmg.zzb(zzkt);
    }

    public final int zzg(zzkt zzkt, zzkz zzkz) throws IOException, InterruptedException {
        zzme[] zzmeArr;
        boolean z;
        boolean z2;
        zzkt zzkt2 = zzkt;
        zzkz zzkz2 = zzkz;
        while (true) {
            int i = this.zzg;
            if (i == 0) {
                if (this.zzj == 0) {
                    if (!zzkt2.zzb(this.zze.zza, 0, 8, true)) {
                        return -1;
                    }
                    this.zzj = 8;
                    this.zze.zzi(0);
                    this.zzi = this.zze.zzp();
                    this.zzh = this.zze.zzr();
                }
                if (this.zzi == 1) {
                    zzkt2.zzb(this.zze.zza, 8, 8, false);
                    this.zzj += 8;
                    this.zzi = this.zze.zzv();
                }
                int i2 = this.zzh;
                if (i2 == zzlp.zzE || i2 == zzlp.zzG || i2 == zzlp.zzH || i2 == zzlp.zzI || i2 == zzlp.zzJ || i2 == zzlp.zzS) {
                    long zzh2 = (zzkt.zzh() + this.zzi) - ((long) this.zzj);
                    this.zzf.add(new zzln(this.zzh, zzh2));
                    if (this.zzi == ((long) this.zzj)) {
                        zzi(zzh2);
                    } else {
                        zzh();
                    }
                } else {
                    if (i2 == zzlp.zzU || i2 == zzlp.zzF || i2 == zzlp.zzV || i2 == zzlp.zzW || i2 == zzlp.zzao || i2 == zzlp.zzap || i2 == zzlp.zzaq || i2 == zzlp.zzT || i2 == zzlp.zzar || i2 == zzlp.zzas || i2 == zzlp.zzat || i2 == zzlp.zzau || i2 == zzlp.zzav || i2 == zzlp.zzR || i2 == zzlp.zzd || i2 == zzlp.zzaC) {
                        zzpu.zzd(this.zzj == 8);
                        zzpu.zzd(this.zzi <= 2147483647L);
                        zzqc zzqc = new zzqc((int) this.zzi);
                        this.zzk = zzqc;
                        System.arraycopy(this.zze.zza, 0, zzqc.zza, 0, 8);
                    } else {
                        this.zzk = null;
                    }
                    this.zzg = 1;
                }
            } else if (i != 1) {
                long j = Long.MAX_VALUE;
                int i3 = 0;
                int i4 = -1;
                while (true) {
                    zzmeArr = this.zzo;
                    if (i3 >= zzmeArr.length) {
                        break;
                    }
                    zzme zzme = zzmeArr[i3];
                    int i5 = zzme.zzd;
                    zzmk zzmk = zzme.zzb;
                    if (i5 != zzmk.zza) {
                        long j2 = zzmk.zzb[i5];
                        if (j2 < j) {
                            i4 = i3;
                            j = j2;
                        }
                    }
                    i3++;
                }
                if (i4 == -1) {
                    return -1;
                }
                zzme zzme2 = zzmeArr[i4];
                zzld zzld = zzme2.zzc;
                int i6 = zzme2.zzd;
                zzmk zzmk2 = zzme2.zzb;
                long j3 = zzmk2.zzb[i6];
                int i7 = zzmk2.zzc[i6];
                if (zzme2.zza.zzg == 1) {
                    j3 += 8;
                    i7 -= 8;
                }
                long zzh3 = (j3 - zzkt.zzh()) + ((long) this.zzl);
                if (zzh3 < 0 || zzh3 >= 262144) {
                    zzkz2.zza = j3;
                    return 1;
                }
                int i8 = (int) zzh3;
                boolean z3 = false;
                zzkt2.zzd(i8, false);
                int i9 = zzme2.zza.zzk;
                if (i9 == 0) {
                    while (true) {
                        int i10 = this.zzl;
                        if (i10 >= i7) {
                            break;
                        }
                        int zzd2 = zzld.zzd(zzkt2, i7 - i10, false);
                        this.zzl += zzd2;
                        this.zzm -= zzd2;
                    }
                } else {
                    byte[] bArr = this.zzd.zza;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i11 = 4 - i9;
                    while (this.zzl < i7) {
                        int i12 = this.zzm;
                        if (i12 == 0) {
                            zzkt2.zzb(this.zzd.zza, i11, i9, z3);
                            this.zzd.zzi(z3 ? 1 : 0);
                            this.zzm = this.zzd.zzu();
                            this.zzc.zzi(z3);
                            zzld.zzb(this.zzc, 4);
                            this.zzl += 4;
                            i7 += i11;
                        } else {
                            int zzd3 = zzld.zzd(zzkt2, i12, z3);
                            this.zzl += zzd3;
                            this.zzm -= zzd3;
                            z3 = false;
                        }
                    }
                }
                int i13 = i7;
                zzmk zzmk3 = zzme2.zzb;
                zzld.zzc(zzmk3.zze[i6], zzmk3.zzf[i6], i13, 0, (zzlc) null);
                zzme2.zzd++;
                this.zzl = 0;
                this.zzm = 0;
                return 0;
            } else {
                long j4 = this.zzi - ((long) this.zzj);
                long zzh4 = zzkt.zzh() + j4;
                zzqc zzqc2 = this.zzk;
                if (zzqc2 != null) {
                    zzkt2.zzb(zzqc2.zza, this.zzj, (int) j4, false);
                    if (this.zzh == zzlp.zzd) {
                        zzqc zzqc3 = this.zzk;
                        zzqc3.zzi(8);
                        if (zzqc3.zzr() == zzb) {
                            z2 = true;
                        } else {
                            zzqc3.zzj(4);
                            while (true) {
                                if (zzqc3.zzd() > 0) {
                                    if (zzqc3.zzr() == zzb) {
                                        break;
                                    }
                                } else {
                                    z2 = false;
                                    break;
                                }
                            }
                            z2 = true;
                        }
                        this.zzq = z2;
                    } else if (!this.zzf.isEmpty()) {
                        this.zzf.peek().zza(new zzlo(this.zzh, this.zzk));
                    }
                } else if (j4 < 262144) {
                    zzkt2.zzd((int) j4, false);
                } else {
                    zzkz2.zza = zzkt.zzh() + j4;
                    z = true;
                    zzi(zzh4);
                    if (z && this.zzg != 2) {
                        return 1;
                    }
                }
                z = false;
                zzi(zzh4);
                return 1;
            }
        }
    }
}
