package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzov extends zzoz {
    private final SparseArray<Map<zzol, zzou>> zza = new SparseArray<>();
    private final SparseBooleanArray zzb = new SparseBooleanArray();

    /* access modifiers changed from: protected */
    public abstract zzop[] zzb(zziz[] zzizArr, zzol[] zzolArr, int[][][] iArr) throws zzif;

    public final void zzc(int i, boolean z) {
        if (this.zzb.get(i) != z) {
            this.zzb.put(i, z);
            zzg();
        }
    }

    public final zzpa zzd(zziz[] zzizArr, zzol zzol) throws zzif {
        zzou zzou;
        int[] iArr;
        zziz[] zzizArr2 = zzizArr;
        zzol zzol2 = zzol;
        int[] iArr2 = new int[3];
        zzok[][] zzokArr = new zzok[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzol2.zzb;
            zzokArr[i] = new zzok[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            zzizArr2[i4].zzq();
            iArr4[i4] = 4;
        }
        int i5 = 0;
        while (i5 < zzol2.zzb) {
            zzok zza2 = zzol2.zza(i5);
            int i6 = 0;
            int i7 = 0;
            int i8 = 2;
            while (true) {
                if (i6 >= i3) {
                    i6 = i8;
                    break;
                }
                zziz zziz = zzizArr2[i6];
                for (int i9 = 0; i9 < zza2.zza; i9++) {
                    int zzG = zziz.zzG(zza2.zza(i9)) & 3;
                    if (zzG > i7) {
                        if (zzG == 3) {
                            break;
                        }
                        i8 = i6;
                        i7 = zzG;
                    }
                }
                i6++;
                i3 = 2;
            }
            if (i6 == 2) {
                iArr = new int[zza2.zza];
            } else {
                zziz zziz2 = zzizArr2[i6];
                int[] iArr5 = new int[zza2.zza];
                for (int i10 = 0; i10 < zza2.zza; i10++) {
                    iArr5[i10] = zziz2.zzG(zza2.zza(i10));
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i6];
            zzokArr[i6][i11] = zza2;
            iArr3[i6][i11] = iArr;
            iArr2[i6] = i11 + 1;
            i5++;
            i3 = 2;
        }
        zzol[] zzolArr = new zzol[2];
        int[] iArr6 = new int[2];
        int i12 = 0;
        for (int i13 = 2; i12 < i13; i13 = 2) {
            int i14 = iArr2[i12];
            zzolArr[i12] = new zzol((zzok[]) Arrays.copyOf(zzokArr[i12], i14));
            iArr3[i12] = (int[][]) Arrays.copyOf(iArr3[i12], i14);
            iArr6[i12] = zzizArr2[i12].zza();
            i12++;
        }
        zzol zzol3 = new zzol((zzok[]) Arrays.copyOf(zzokArr[2], iArr2[2]));
        zzop[] zzb2 = zzb(zzizArr2, zzolArr, iArr3);
        int i15 = 0;
        for (int i16 = 2; i15 < i16; i16 = 2) {
            if (this.zzb.get(i15)) {
                zzb2[i15] = null;
            } else {
                zzol zzol4 = zzolArr[i15];
                Map map = this.zza.get(i15);
                if (map == null) {
                    zzou = null;
                } else {
                    zzou = (zzou) map.get(zzol4);
                }
                if (zzou != null) {
                    throw null;
                }
            }
            i15++;
        }
        zzot zzot = new zzot(iArr6, zzolArr, iArr4, iArr3, zzol3);
        zzja[] zzjaArr = new zzja[2];
        for (int i17 = 0; i17 < 2; i17++) {
            zzjaArr[i17] = zzb2[i17] != null ? zzja.zza : null;
        }
        return new zzpa(zzol2, new zzox(zzb2, (byte[]) null), zzot, zzjaArr);
    }

    public final void zze(Object obj) {
        zzot zzot = (zzot) obj;
    }
}
