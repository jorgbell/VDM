package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzor extends zzov {
    private final AtomicReference<zzoq> zza = new AtomicReference<>(new zzoq());

    protected static boolean zza(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    private static int zzh(int i, int i2) {
        if (i == -1) {
            return i2 != -1 ? -1 : 0;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* access modifiers changed from: protected */
    public final zzop[] zzb(zziz[] zzizArr, zzol[] zzolArr, int[][][] iArr) throws zzif {
        zzos zzos;
        zzos zzos2;
        int[] iArr2;
        ArrayList arrayList;
        zzok zzok;
        boolean z;
        int i;
        int i2;
        int i3 = 2;
        zzop[] zzopArr = new zzop[2];
        zzoq zzoq = this.zza.get();
        int i4 = 0;
        boolean z2 = false;
        while (i4 < i3) {
            if (zzizArr[i4].zza() == i3) {
                if (!z2) {
                    zziz zziz = zzizArr[i4];
                    zzol zzol = zzolArr[i4];
                    int[][] iArr3 = iArr[i4];
                    int i5 = zzoq.zzd;
                    int i6 = zzoq.zze;
                    int i7 = zzoq.zzf;
                    boolean z3 = zzoq.zzc;
                    boolean z4 = zzoq.zzb;
                    int i8 = zzoq.zzi;
                    int i9 = zzoq.zzj;
                    boolean z5 = zzoq.zzk;
                    boolean z6 = zzoq.zzg;
                    boolean z7 = zzoq.zzh;
                    int i10 = 0;
                    zzok zzok2 = null;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = -1;
                    int i14 = -1;
                    while (i10 < zzol.zzb) {
                        zzok zza2 = zzol.zza(i10);
                        ArrayList arrayList2 = new ArrayList(zza2.zza);
                        for (int i15 = 0; i15 < zza2.zza; i15++) {
                            arrayList2.add(Integer.valueOf(i15));
                        }
                        int[] iArr4 = iArr3[i10];
                        int i16 = i14;
                        int i17 = 0;
                        while (i17 < zza2.zza) {
                            zzol zzol2 = zzol;
                            if (zza(iArr4[i17], true)) {
                                zzit zza3 = zza2.zza(i17);
                                if (arrayList2.contains(Integer.valueOf(i17))) {
                                    int i18 = zza3.zzj;
                                    int i19 = zza3.zzk;
                                    int i20 = zza3.zzb;
                                    zzok = zza2;
                                    z = true;
                                } else {
                                    zzok = zza2;
                                    z = false;
                                }
                                if (true != z) {
                                    arrayList = arrayList2;
                                    i = 1;
                                } else {
                                    arrayList = arrayList2;
                                    i = 2;
                                }
                                iArr2 = iArr4;
                                boolean zza4 = zza(iArr4[i17], false);
                                if (zza4) {
                                    i += 1000;
                                }
                                boolean z8 = i > i12;
                                if (i == i12) {
                                    if (zza3.zzk() != i16) {
                                        i2 = zzh(zza3.zzk(), i16);
                                    } else {
                                        i2 = zzh(zza3.zzb, i13);
                                    }
                                    z8 = !zza4 || !z ? i2 < 0 : i2 > 0;
                                }
                                if (z8) {
                                    i13 = zza3.zzb;
                                    i16 = zza3.zzk();
                                    i12 = i;
                                    i11 = i17;
                                    zzok2 = zzok;
                                }
                            } else {
                                zzok = zza2;
                                iArr2 = iArr4;
                                arrayList = arrayList2;
                            }
                            i17++;
                            zzol = zzol2;
                            zza2 = zzok;
                            arrayList2 = arrayList;
                            iArr4 = iArr2;
                        }
                        zzol zzol3 = zzol;
                        i10++;
                        i14 = i16;
                    }
                    if (zzok2 == null) {
                        zzos2 = null;
                    } else {
                        zzos2 = new zzos(zzok2, i11, 0, (Object) null);
                    }
                    zzopArr[i4] = zzos2;
                    z2 = zzos2 != null;
                }
                int i21 = zzolArr[i4].zzb;
            }
            i4++;
            i3 = 2;
        }
        int i22 = 0;
        boolean z9 = false;
        while (i22 < i3) {
            if (zzizArr[i22].zza() == 1 && !z9) {
                zzol zzol4 = zzolArr[i22];
                int[][] iArr5 = iArr[i22];
                String str = zzoq.zza;
                boolean z10 = zzoq.zzh;
                boolean z11 = zzoq.zzb;
                int i23 = -1;
                int i24 = -1;
                int i25 = 0;
                int i26 = 0;
                while (i25 < zzol4.zzb) {
                    zzok zza5 = zzol4.zza(i25);
                    int[] iArr6 = iArr5[i25];
                    int i27 = i26;
                    int i28 = i24;
                    int i29 = i23;
                    for (int i30 = 0; i30 < zza5.zza; i30++) {
                        if (zza(iArr6[i30], true)) {
                            zzit zza6 = zza5.zza(i30);
                            int i31 = iArr6[i30];
                            int i32 = 1 != (zza6.zzx & 1) ? 1 : 2;
                            if (zza(i31, false)) {
                                i32 += 1000;
                            }
                            if (i32 > i27) {
                                i28 = i30;
                                i29 = i25;
                                i27 = i32;
                            }
                        }
                    }
                    i25++;
                    i23 = i29;
                    i24 = i28;
                    i26 = i27;
                }
                if (i23 == -1) {
                    zzos = null;
                } else {
                    zzos = new zzos(zzol4.zza(i23), i24, 0, (Object) null);
                }
                zzopArr[i22] = zzos;
                z9 = zzos != null;
            }
            i22++;
            i3 = 2;
        }
        return zzopArr;
    }

    public zzor(zzow zzow) {
    }
}
