package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zznx implements zznu, zznt {
    public final zznu[] zza;
    private final IdentityHashMap<zzog, Integer> zzb = new IdentityHashMap<>();
    private zznt zzc;
    private int zzd;
    private zzol zze;
    private zznu[] zzf;
    private zzoi zzg;

    public zznx(zznu... zznuArr) {
        this.zza = zznuArr;
    }

    public final long zzB(zzop[] zzopArr, boolean[] zArr, zzog[] zzogArr, boolean[] zArr2, long j) {
        int length;
        int i;
        zzop[] zzopArr2 = zzopArr;
        zzog[] zzogArr2 = zzogArr;
        int length2 = zzopArr2.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i2 = 0;
        while (true) {
            length = zzopArr2.length;
            if (i2 >= length) {
                break;
            }
            zzog zzog = zzogArr2[i2];
            if (zzog == null) {
                i = -1;
            } else {
                i = this.zzb.get(zzog).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            zzop zzop = zzopArr2[i2];
            if (zzop != null) {
                zzok zza2 = zzop.zza();
                int i3 = 0;
                while (true) {
                    zznu[] zznuArr = this.zza;
                    if (i3 >= zznuArr.length) {
                        break;
                    } else if (zznuArr[i3].zzg().zzb(zza2) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
        this.zzb.clear();
        zzog[] zzogArr3 = new zzog[length];
        zzog[] zzogArr4 = new zzog[length];
        zzop[] zzopArr3 = new zzop[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zza.length) {
            for (int i5 = 0; i5 < zzopArr2.length; i5++) {
                zzop zzop2 = null;
                zzogArr4[i5] = iArr[i5] == i4 ? zzogArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzop2 = zzopArr2[i5];
                }
                zzopArr3[i5] = zzop2;
            }
            int i6 = i4;
            zzop[] zzopArr4 = zzopArr3;
            ArrayList arrayList2 = arrayList;
            long zzB = this.zza[i4].zzB(zzopArr3, zArr, zzogArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zzB;
            } else if (zzB != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzopArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzpu.zzd(zzogArr4[i7] != null);
                    zzog zzog2 = zzogArr4[i7];
                    zzogArr3[i7] = zzog2;
                    this.zzb.put(zzog2, Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zzogArr4[i7] != null) {
                        z2 = false;
                    }
                    zzpu.zzd(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zza[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzopArr3 = zzopArr4;
            zzogArr2 = zzogArr;
        }
        zzog[] zzogArr5 = zzogArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzogArr3, 0, zzogArr5, 0, length);
        zznu[] zznuArr2 = new zznu[arrayList3.size()];
        this.zzf = zznuArr2;
        arrayList3.toArray(zznuArr2);
        this.zzg = new zzni(this.zzf);
        return j2;
    }

    public final long zza() {
        return this.zzg.zza();
    }

    public final boolean zzb(long j) {
        return this.zzg.zzb(j);
    }

    public final void zzbh(zznu zznu) {
        int i = this.zzd - 1;
        this.zzd = i;
        if (i <= 0) {
            int i2 = 0;
            for (zznu zzg2 : this.zza) {
                i2 += zzg2.zzg().zzb;
            }
            zzok[] zzokArr = new zzok[i2];
            int i3 = 0;
            for (zznu zzg3 : this.zza) {
                zzol zzg4 = zzg3.zzg();
                int i4 = zzg4.zzb;
                int i5 = 0;
                while (i5 < i4) {
                    zzokArr[i3] = zzg4.zza(i5);
                    i5++;
                    i3++;
                }
            }
            this.zze = new zzol(zzokArr);
            this.zzc.zzbh(this);
        }
    }

    public final void zze(zznt zznt, long j) {
        this.zzc = zznt;
        this.zzd = r0;
        for (zznu zze2 : this.zza) {
            zze2.zze(this, j);
        }
    }

    public final void zzf() throws IOException {
        for (zznu zzf2 : this.zza) {
            zzf2.zzf();
        }
    }

    public final zzol zzg() {
        return this.zze;
    }

    public final void zzh(long j) {
        for (zznu zzh : this.zzf) {
            zzh.zzh(j);
        }
    }

    public final long zzi() {
        long zzi = this.zza[0].zzi();
        int i = 1;
        while (true) {
            zznu[] zznuArr = this.zza;
            if (i >= zznuArr.length) {
                if (zzi != -9223372036854775807L) {
                    zznu[] zznuArr2 = this.zzf;
                    int length = zznuArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zznu zznu = zznuArr2[i2];
                        if (zznu == this.zza[0] || zznu.zzk(zzi) == zzi) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzi;
            } else if (zznuArr[i].zzi() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzj() {
        long j = Long.MAX_VALUE;
        for (zznu zzj : this.zzf) {
            long zzj2 = zzj.zzj();
            if (zzj2 != Long.MIN_VALUE) {
                j = Math.min(j, zzj2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zzk(long j) {
        long zzk = this.zzf[0].zzk(j);
        int i = 1;
        while (true) {
            zznu[] zznuArr = this.zzf;
            if (i >= zznuArr.length) {
                return zzk;
            }
            if (zznuArr[i].zzk(zzk) == zzk) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzn(zzoi zzoi) {
        zznu zznu = (zznu) zzoi;
        if (this.zze != null) {
            this.zzc.zzn(this);
        }
    }
}
