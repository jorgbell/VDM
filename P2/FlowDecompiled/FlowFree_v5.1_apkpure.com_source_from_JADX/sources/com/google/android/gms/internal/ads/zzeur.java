package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeur<T> implements zzevf<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzewd.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzeuo zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzeuc zzn;
    private final zzevt<?, ?> zzo;
    private final zzesu<?> zzp;
    private final zzeuj zzr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.ads.zzeuo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.ads.zzeuj} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzesu, com.google.android.gms.internal.ads.zzesu<?>] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [int] */
    /* JADX WARNING: type inference failed for: r3v11, types: [com.google.android.gms.internal.ads.zzeuc] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.ads.zzevt<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzeur(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzeuo r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.ads.zzeut r17, com.google.android.gms.internal.ads.zzeuc r18, com.google.android.gms.internal.ads.zzevt<?, ?> r19, com.google.android.gms.internal.ads.zzesu<?> r20, com.google.android.gms.internal.ads.zzeuj r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            boolean r3 = r1 instanceof com.google.android.gms.internal.ads.zzeth
            r0.zzi = r3
            r3 = r11
            r0.zzj = r3
            r3 = 0
            if (r2 == 0) goto L_0x0024
            boolean r4 = r2.zza(r10)
            if (r4 == 0) goto L_0x0024
            r3 = 1
        L_0x0024:
            r0.zzh = r3
            r3 = r13
            r0.zzk = r3
            r3 = r14
            r0.zzl = r3
            r3 = r15
            r0.zzm = r3
            r3 = r17
            r0.zzn = r3
            r3 = r18
            r0.zzo = r3
            r0.zzp = r2
            r0.zzg = r1
            r1 = r20
            r0.zzr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.ads.zzeuo, boolean, boolean, int[], int, int, com.google.android.gms.internal.ads.zzeut, com.google.android.gms.internal.ads.zzeuc, com.google.android.gms.internal.ads.zzevt, com.google.android.gms.internal.ads.zzesu, com.google.android.gms.internal.ads.zzeuj, byte[]):void");
    }

    private final <UT, UB> UB zzA(Object obj, int i, UB ub, zzevt<UT, UB> zzevt) {
        int i2 = this.zzc[i];
        Object zzn2 = zzewd.zzn(obj, (long) (zzD(i) & 1048575));
        if (zzn2 == null || zzy(i) == null) {
            return ub;
        }
        zzeui zzeui = (zzeui) zzn2;
        zzeuh zzeuh = (zzeuh) zzx(i);
        throw null;
    }

    private static boolean zzB(Object obj, int i, zzevf zzevf) {
        return zzevf.zzk(zzewd.zzn(obj, (long) (i & 1048575)));
    }

    private final void zzC(Object obj, int i, zzeuz zzeuz) throws IOException {
        if (zzG(i)) {
            zzewd.zzo(obj, (long) (i & 1048575), zzeuz.zzn());
        } else if (this.zzi) {
            zzewd.zzo(obj, (long) (i & 1048575), zzeuz.zzm());
        } else {
            zzewd.zzo(obj, (long) (i & 1048575), zzeuz.zzq());
        }
    }

    private final int zzD(int i) {
        return this.zzc[i + 1];
    }

    private final int zzE(int i) {
        return this.zzc[i + 2];
    }

    private static int zzF(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzG(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzH(T t, long j) {
        return ((Double) zzewd.zzn(t, j)).doubleValue();
    }

    private static <T> float zzI(T t, long j) {
        return ((Float) zzewd.zzn(t, j)).floatValue();
    }

    private static <T> int zzJ(T t, long j) {
        return ((Integer) zzewd.zzn(t, j)).intValue();
    }

    private static <T> long zzK(T t, long j) {
        return ((Long) zzewd.zzn(t, j)).longValue();
    }

    private static <T> boolean zzL(T t, long j) {
        return ((Boolean) zzewd.zzn(t, j)).booleanValue();
    }

    private final boolean zzM(T t, T t2, int i) {
        return zzO(t, i) == zzO(t2, i);
    }

    private final boolean zzN(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzO(T t, int i) {
        int zzE = zzE(i);
        long j = (long) (zzE & 1048575);
        if (j != 1048575) {
            return (zzewd.zzd(t, j) & (1 << (zzE >>> 20))) != 0;
        }
        int zzD = zzD(i);
        long j2 = (long) (zzD & 1048575);
        switch (zzF(zzD)) {
            case 0:
                return zzewd.zzl(t, j2) != 0.0d;
            case 1:
                return zzewd.zzj(t, j2) != 0.0f;
            case 2:
                return zzewd.zzf(t, j2) != 0;
            case 3:
                return zzewd.zzf(t, j2) != 0;
            case 4:
                return zzewd.zzd(t, j2) != 0;
            case 5:
                return zzewd.zzf(t, j2) != 0;
            case 6:
                return zzewd.zzd(t, j2) != 0;
            case 7:
                return zzewd.zzh(t, j2);
            case 8:
                Object zzn2 = zzewd.zzn(t, j2);
                if (zzn2 instanceof String) {
                    return !((String) zzn2).isEmpty();
                }
                if (zzn2 instanceof zzesf) {
                    return !zzesf.zzb.equals(zzn2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzewd.zzn(t, j2) != null;
            case 10:
                return !zzesf.zzb.equals(zzewd.zzn(t, j2));
            case 11:
                return zzewd.zzd(t, j2) != 0;
            case 12:
                return zzewd.zzd(t, j2) != 0;
            case 13:
                return zzewd.zzd(t, j2) != 0;
            case 14:
                return zzewd.zzf(t, j2) != 0;
            case 15:
                return zzewd.zzd(t, j2) != 0;
            case 16:
                return zzewd.zzf(t, j2) != 0;
            case 17:
                return zzewd.zzn(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzP(T t, int i) {
        int zzE = zzE(i);
        long j = (long) (1048575 & zzE);
        if (j != 1048575) {
            zzewd.zze(t, j, (1 << (zzE >>> 20)) | zzewd.zzd(t, j));
        }
    }

    private final boolean zzQ(T t, int i, int i2) {
        return zzewd.zzd(t, (long) (zzE(i2) & 1048575)) == i;
    }

    private final void zzR(T t, int i, int i2) {
        zzewd.zze(t, (long) (zzE(i2) & 1048575), i);
    }

    private final int zzS(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, 0);
    }

    private final int zzT(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, i2);
    }

    private final int zzU(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final void zzV(T t, zzesp zzesp) throws IOException {
        int i;
        T t2 = t;
        zzesp zzesp2 = zzesp;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i2 = 1048575;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1048575;
            while (i3 < length) {
                int zzD = zzD(i3);
                int i6 = this.zzc[i3];
                int zzF = zzF(zzD);
                if (zzF <= 17) {
                    int i7 = this.zzc[i3 + 2];
                    int i8 = i7 & i2;
                    if (i8 != i5) {
                        i4 = unsafe.getInt(t2, (long) i8);
                        i5 = i8;
                    }
                    i = 1 << (i7 >>> 20);
                } else {
                    i = 0;
                }
                long j = (long) (zzD & i2);
                switch (zzF) {
                    case 0:
                        if ((i4 & i) == 0) {
                            break;
                        } else {
                            zzesp2.zzf(i6, zzewd.zzl(t2, j));
                            continue;
                        }
                    case 1:
                        if ((i4 & i) != 0) {
                            zzesp2.zze(i6, zzewd.zzj(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i4 & i) != 0) {
                            zzesp2.zzc(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i4 & i) != 0) {
                            zzesp2.zzh(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i4 & i) != 0) {
                            zzesp2.zzi(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i4 & i) != 0) {
                            zzesp2.zzj(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i4 & i) != 0) {
                            zzesp2.zzk(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i4 & i) != 0) {
                            zzesp2.zzl(i6, zzewd.zzh(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i4 & i) != 0) {
                            zzX(i6, unsafe.getObject(t2, j), zzesp2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i4 & i) != 0) {
                            zzesp2.zzr(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i4 & i) != 0) {
                            zzesp2.zzn(i6, (zzesf) unsafe.getObject(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i4 & i) != 0) {
                            zzesp2.zzo(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i4 & i) != 0) {
                            zzesp2.zzg(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i4 & i) != 0) {
                            zzesp2.zzb(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i4 & i) != 0) {
                            zzesp2.zzd(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i4 & i) != 0) {
                            zzesp2.zzp(i6, unsafe.getInt(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i4 & i) != 0) {
                            zzesp2.zzq(i6, unsafe.getLong(t2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i4 & i) != 0) {
                            zzesp2.zzs(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzevh.zzJ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 19:
                        zzevh.zzK(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 20:
                        zzevh.zzL(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 21:
                        zzevh.zzM(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 22:
                        zzevh.zzQ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 23:
                        zzevh.zzO(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 24:
                        zzevh.zzT(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 25:
                        zzevh.zzW(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        continue;
                    case 26:
                        zzevh.zzX(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2);
                        break;
                    case 27:
                        zzevh.zzZ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, zzw(i3));
                        break;
                    case 28:
                        zzevh.zzY(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2);
                        break;
                    case 29:
                        zzevh.zzR(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        break;
                    case 30:
                        zzevh.zzV(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        break;
                    case 31:
                        zzevh.zzU(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        break;
                    case 32:
                        zzevh.zzP(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        break;
                    case 33:
                        zzevh.zzS(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        break;
                    case 34:
                        zzevh.zzN(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, false);
                        break;
                    case 35:
                        zzevh.zzJ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 36:
                        zzevh.zzK(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 37:
                        zzevh.zzL(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 38:
                        zzevh.zzM(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 39:
                        zzevh.zzQ(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 40:
                        zzevh.zzO(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 41:
                        zzevh.zzT(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 42:
                        zzevh.zzW(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 43:
                        zzevh.zzR(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 44:
                        zzevh.zzV(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 45:
                        zzevh.zzU(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 46:
                        zzevh.zzP(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 47:
                        zzevh.zzS(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 48:
                        zzevh.zzN(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, true);
                        break;
                    case 49:
                        zzevh.zzaa(this.zzc[i3], (List) unsafe.getObject(t2, j), zzesp2, zzw(i3));
                        break;
                    case 50:
                        zzW(zzesp2, i6, unsafe.getObject(t2, j), i3);
                        break;
                    case 51:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzf(i6, zzH(t2, j));
                            break;
                        }
                        break;
                    case 52:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zze(i6, zzI(t2, j));
                            break;
                        }
                        break;
                    case 53:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzc(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 54:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzh(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 55:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzi(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 56:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzj(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 57:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzk(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 58:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzl(i6, zzL(t2, j));
                            break;
                        }
                        break;
                    case 59:
                        if (zzQ(t2, i6, i3)) {
                            zzX(i6, unsafe.getObject(t2, j), zzesp2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzr(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        }
                        break;
                    case 61:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzn(i6, (zzesf) unsafe.getObject(t2, j));
                            break;
                        }
                        break;
                    case 62:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzo(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 63:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzg(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 64:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzb(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 65:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzd(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 66:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzp(i6, zzJ(t2, j));
                            break;
                        }
                        break;
                    case 67:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzq(i6, zzK(t2, j));
                            break;
                        }
                        break;
                    case 68:
                        if (zzQ(t2, i6, i3)) {
                            zzesp2.zzs(i6, unsafe.getObject(t2, j), zzw(i3));
                            break;
                        }
                        break;
                }
                i3 += 3;
                i2 = 1048575;
            }
            zzevt<?, ?> zzevt = this.zzo;
            zzevt.zzr(zzevt.zzj(t2), zzesp2);
            return;
        }
        this.zzp.zzb(t2);
        throw null;
    }

    private final <K, V> void zzW(zzesp zzesp, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzeuh zzeuh = (zzeuh) zzx(i2);
            throw null;
        }
    }

    private static final void zzX(int i, Object obj, zzesp zzesp) throws IOException {
        if (obj instanceof String) {
            zzesp.zzm(i, (String) obj);
        } else {
            zzesp.zzn(i, (zzesf) obj);
        }
    }

    static zzevu zzg(Object obj) {
        zzeth zzeth = (zzeth) obj;
        zzevu zzevu = zzeth.zzc;
        if (zzevu != zzevu.zza()) {
            return zzevu;
        }
        zzevu zzb2 = zzevu.zzb();
        zzeth.zzc = zzb2;
        return zzb2;
    }

    static <T> zzeur<T> zzl(Class<T> cls, zzeul zzeul, zzeut zzeut, zzeuc zzeuc, zzevt<?, ?> zzevt, zzesu<?> zzesu, zzeuj zzeuj) {
        if (zzeul instanceof zzeuy) {
            return zzm((zzeuy) zzeul, zzeut, zzeuc, zzevt, zzesu, zzeuj);
        }
        zzevq zzevq = (zzevq) zzeul;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.ads.zzeur<T> zzm(com.google.android.gms.internal.ads.zzeuy r34, com.google.android.gms.internal.ads.zzeut r35, com.google.android.gms.internal.ads.zzeuc r36, com.google.android.gms.internal.ads.zzevt<?, ?> r37, com.google.android.gms.internal.ads.zzesu<?> r38, com.google.android.gms.internal.ads.zzeuj r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.ads.zzeuo r18 = r34.zzb()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0193:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a5
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0193
        L_0x01a5:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ad
        L_0x01ab:
            r2 = r24
        L_0x01ad:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01da
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d4
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bb
        L_0x01d4:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r3
            r3 = r24
        L_0x01de:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0222
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0226
        L_0x0222:
            r32 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzo(r1, r12)
            r17[r3] = r12
        L_0x0268:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r3 = r3 + 1
            r7 = r17[r3]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzo(r1, r7)
            r17[r3] = r7
        L_0x0283:
            r3 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r30 = r0
            r7 = r1
            r1 = r8
            r29 = r11
            r25 = 1
            r8 = r3
            r3 = 0
            goto L_0x0391
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzo(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0354
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r3 = r3 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r3 = r3 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r3 / 32
            int r7 = r7 + r26
            r11 = r17[r7]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzo(r1, r11)
            r17[r7] = r11
        L_0x036f:
            r7 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r1 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0378:
            r30 = r0
            r7 = r1
            r27 = r3
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r3 = 0
        L_0x0381:
            r0 = 18
            if (r5 < r0) goto L_0x038f
            r0 = 49
            if (r5 > r0) goto L_0x038f
            int r0 = r23 + 1
            r13[r23] = r8
            r23 = r0
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r0 = r9 + 1
            r31[r9] = r4
            int r4 = r0 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r8
            r31[r0] = r2
            int r9 = r4 + 1
            int r0 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r7
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.ads.zzeur r0 = new com.google.android.gms.internal.ads.zzeur
            r4 = r0
            com.google.android.gms.internal.ads.zzeuo r9 = r34.zzb()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzm(com.google.android.gms.internal.ads.zzeuy, com.google.android.gms.internal.ads.zzeut, com.google.android.gms.internal.ads.zzeuc, com.google.android.gms.internal.ads.zzevt, com.google.android.gms.internal.ads.zzesu, com.google.android.gms.internal.ads.zzeuj):com.google.android.gms.internal.ads.zzeur");
    }

    private static Field zzo(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzp(T t, T t2, int i) {
        long zzD = (long) (zzD(i) & 1048575);
        if (zzO(t2, i)) {
            Object zzn2 = zzewd.zzn(t, zzD);
            Object zzn3 = zzewd.zzn(t2, zzD);
            if (zzn2 != null && zzn3 != null) {
                zzewd.zzo(t, zzD, zzetr.zzi(zzn2, zzn3));
                zzP(t, i);
            } else if (zzn3 != null) {
                zzewd.zzo(t, zzD, zzn3);
                zzP(t, i);
            }
        }
    }

    private final void zzq(T t, T t2, int i) {
        int zzD = zzD(i);
        int i2 = this.zzc[i];
        long j = (long) (zzD & 1048575);
        if (zzQ(t2, i2, i)) {
            Object zzn2 = zzQ(t, i2, i) ? zzewd.zzn(t, j) : null;
            Object zzn3 = zzewd.zzn(t2, j);
            if (zzn2 != null && zzn3 != null) {
                zzewd.zzo(t, j, zzetr.zzi(zzn2, zzn3));
                zzR(t, i2, i);
            } else if (zzn3 != null) {
                zzewd.zzo(t, j, zzn3);
                zzR(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0304, code lost:
        r8 = r8 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x046b, code lost:
        r8 = r8 + (r9 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04b5, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04e0, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04e1, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0508, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0515, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0523, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0527, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x000c:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x052b
            int r7 = r14.zzD(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzF(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0037
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r1
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0038
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r7 = r7 & r1
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0519;
                case 1: goto L_0x050b;
                case 2: goto L_0x04f6;
                case 3: goto L_0x04e3;
                case 4: goto L_0x04ce;
                case 5: goto L_0x04c3;
                case 6: goto L_0x04b8;
                case 7: goto L_0x04ab;
                case 8: goto L_0x0481;
                case 9: goto L_0x046f;
                case 10: goto L_0x0453;
                case 11: goto L_0x043f;
                case 12: goto L_0x042b;
                case 13: goto L_0x041f;
                case 14: goto L_0x0413;
                case 15: goto L_0x03fa;
                case 16: goto L_0x03e2;
                case 17: goto L_0x03cf;
                case 18: goto L_0x03c2;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03ac;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0396;
                case 23: goto L_0x038b;
                case 24: goto L_0x0380;
                case 25: goto L_0x0375;
                case 26: goto L_0x036a;
                case 27: goto L_0x035b;
                case 28: goto L_0x034f;
                case 29: goto L_0x0343;
                case 30: goto L_0x0337;
                case 31: goto L_0x032b;
                case 32: goto L_0x031f;
                case 33: goto L_0x0313;
                case 34: goto L_0x0307;
                case 35: goto L_0x02f0;
                case 36: goto L_0x02db;
                case 37: goto L_0x02c6;
                case 38: goto L_0x02b1;
                case 39: goto L_0x029c;
                case 40: goto L_0x0287;
                case 41: goto L_0x0271;
                case 42: goto L_0x025b;
                case 43: goto L_0x0245;
                case 44: goto L_0x022f;
                case 45: goto L_0x0219;
                case 46: goto L_0x0203;
                case 47: goto L_0x01ed;
                case 48: goto L_0x01d7;
                case 49: goto L_0x01c7;
                case 50: goto L_0x01ba;
                case 51: goto L_0x01ac;
                case 52: goto L_0x019e;
                case 53: goto L_0x0188;
                case 54: goto L_0x0172;
                case 55: goto L_0x015c;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0132;
                case 59: goto L_0x0104;
                case 60: goto L_0x00f0;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00be;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x0071;
                case 67: goto L_0x0057;
                case 68: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0527
        L_0x0041:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzeuo r7 = (com.google.android.gms.internal.ads.zzeuo) r7
            com.google.android.gms.internal.ads.zzevf r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzE(r8, r7, r9)
            goto L_0x03cc
        L_0x0057:
            boolean r9 = r14.zzQ(r15, r8, r3)
            if (r9 == 0) goto L_0x0527
            long r9 = zzK(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.ads.zzeso.zzx(r9)
            goto L_0x04e0
        L_0x0071:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x04e0
        L_0x008c:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0523
        L_0x009a:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0515
        L_0x00a8:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzv(r7)
            goto L_0x04e0
        L_0x00be:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x04e0
        L_0x00d4:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzesf r7 = (com.google.android.gms.internal.ads.zzesf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x046b
        L_0x00f0:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzevf r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzevh.zzw(r8, r7, r9)
            goto L_0x03cc
        L_0x0104:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.ads.zzesf
            if (r9 == 0) goto L_0x0124
            com.google.android.gms.internal.ads.zzesf r7 = (com.google.android.gms.internal.ads.zzesf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x046b
        L_0x0124:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzy(r7)
            goto L_0x04e0
        L_0x0132:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x04b5
        L_0x0140:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0515
        L_0x014e:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0523
        L_0x015c:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzJ(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzv(r7)
            goto L_0x04e0
        L_0x0172:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            long r9 = zzK(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzeso.zzx(r9)
            goto L_0x0508
        L_0x0188:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            long r9 = zzK(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzeso.zzx(r9)
            goto L_0x0508
        L_0x019e:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0515
        L_0x01ac:
            boolean r7 = r14.zzQ(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0523
        L_0x01ba:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzx(r3)
            com.google.android.gms.internal.ads.zzeuj.zza(r8, r7, r9)
            goto L_0x0527
        L_0x01c7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzevf r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzevh.zzz(r8, r7, r9)
            goto L_0x03cc
        L_0x01d7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzf(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x01ed:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzn(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x0203:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzr(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x0219:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzp(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x022f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzh(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x0245:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzl(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x025b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzt(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x0271:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzp(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x0287:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzr(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x029c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzj(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x02b1:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzd(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x02c6:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzb(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x02db:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzp(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0304
        L_0x02f0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzr(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.ads.zzeso.zzu(r8)
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
        L_0x0304:
            int r8 = r8 + r9
            goto L_0x04e0
        L_0x0307:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzg(r8, r7, r2)
            goto L_0x03cc
        L_0x0313:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzo(r8, r7, r2)
            goto L_0x03cc
        L_0x031f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzs(r8, r7, r2)
            goto L_0x03cc
        L_0x032b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzq(r8, r7, r2)
            goto L_0x03cc
        L_0x0337:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzi(r8, r7, r2)
            goto L_0x03cc
        L_0x0343:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzm(r8, r7, r2)
            goto L_0x03cc
        L_0x034f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzy(r8, r7)
            goto L_0x03cc
        L_0x035b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzevf r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzevh.zzx(r8, r7, r9)
            goto L_0x03cc
        L_0x036a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzv(r8, r7)
            goto L_0x03cc
        L_0x0375:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzu(r8, r7, r2)
            goto L_0x03cc
        L_0x0380:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzq(r8, r7, r2)
            goto L_0x03cc
        L_0x038b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzs(r8, r7, r2)
            goto L_0x03cc
        L_0x0396:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzk(r8, r7, r2)
            goto L_0x03cc
        L_0x03a1:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zze(r8, r7, r2)
            goto L_0x03cc
        L_0x03ac:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzc(r8, r7, r2)
            goto L_0x03cc
        L_0x03b7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzq(r8, r7, r2)
            goto L_0x03cc
        L_0x03c2:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzevh.zzs(r8, r7, r2)
        L_0x03cc:
            int r4 = r4 + r7
            goto L_0x0527
        L_0x03cf:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzeuo r7 = (com.google.android.gms.internal.ads.zzeuo) r7
            com.google.android.gms.internal.ads.zzevf r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzE(r8, r7, r9)
            goto L_0x03cc
        L_0x03e2:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0527
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.ads.zzeso.zzx(r9)
            goto L_0x04e0
        L_0x03fa:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x04e0
        L_0x0413:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0523
        L_0x041f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0515
        L_0x042b:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzv(r7)
            goto L_0x04e0
        L_0x043f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x04e0
        L_0x0453:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzesf r7 = (com.google.android.gms.internal.ads.zzesf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
        L_0x046b:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04e1
        L_0x046f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzevf r9 = r14.zzw(r3)
            int r7 = com.google.android.gms.internal.ads.zzevh.zzw(r8, r7, r9)
            goto L_0x03cc
        L_0x0481:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.ads.zzesf
            if (r9 == 0) goto L_0x049e
            com.google.android.gms.internal.ads.zzesf r7 = (com.google.android.gms.internal.ads.zzesf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = r7.zzc()
            int r9 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x046b
        L_0x049e:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzy(r7)
            goto L_0x04e0
        L_0x04ab:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
        L_0x04b5:
            int r7 = r7 + r11
            goto L_0x03cc
        L_0x04b8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0515
        L_0x04c3:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            goto L_0x0523
        L_0x04ce:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzeso.zzw(r8)
            int r7 = com.google.android.gms.internal.ads.zzeso.zzv(r7)
        L_0x04e0:
            int r8 = r8 + r7
        L_0x04e1:
            int r4 = r4 + r8
            goto L_0x0527
        L_0x04e3:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzeso.zzx(r9)
            goto L_0x0508
        L_0x04f6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
            int r8 = com.google.android.gms.internal.ads.zzeso.zzx(r9)
        L_0x0508:
            int r7 = r7 + r8
            goto L_0x03cc
        L_0x050b:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
        L_0x0515:
            int r7 = r7 + 4
            goto L_0x03cc
        L_0x0519:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzeso.zzw(r7)
        L_0x0523:
            int r7 = r7 + 8
            goto L_0x03cc
        L_0x0527:
            int r3 = r3 + 3
            goto L_0x000c
        L_0x052b:
            com.google.android.gms.internal.ads.zzevt<?, ?> r0 = r14.zzo
            java.lang.Object r1 = r0.zzj(r15)
            int r0 = r0.zzq(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzh
            if (r0 != 0) goto L_0x053b
            return r4
        L_0x053b:
            com.google.android.gms.internal.ads.zzesu<?> r0 = r14.zzp
            r0.zzb(r15)
            r15 = 0
            goto L_0x0543
        L_0x0542:
            throw r15
        L_0x0543:
            goto L_0x0542
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzr(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzs(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzD(r2)
            int r5 = zzF(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.ads.zzesz r4 = com.google.android.gms.internal.ads.zzesz.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.ads.zzesz r4 = com.google.android.gms.internal.ads.zzesz.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzeuo r4 = (com.google.android.gms.internal.ads.zzeuo) r4
            com.google.android.gms.internal.ads.zzevf r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzE(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzQ(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzK(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzeso.zzx(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzesf r4 = (com.google.android.gms.internal.ads.zzesf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzevf r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzevh.zzw(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzesf
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.ads.zzesf r4 = (com.google.android.gms.internal.ads.zzesf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzJ(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzK(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzx(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzK(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzx(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzQ(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.lang.Object r5 = r11.zzx(r2)
            com.google.android.gms.internal.ads.zzeuj.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzevf r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzevh.zzz(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzf(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzp(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzh(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzp(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzj(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzd(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzp(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzeso.zzu(r6)
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzg(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzo(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzi(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzy(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzevf r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzevh.zzx(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzv(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzu(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zze(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzc(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzevh.zzs(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzeuo r4 = (com.google.android.gms.internal.ads.zzeuo) r4
            com.google.android.gms.internal.ads.zzevf r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzE(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzO(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.ads.zzewd.zzf(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzeso.zzx(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzewd.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzewd.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzewd.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzesf r4 = (com.google.android.gms.internal.ads.zzesf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            com.google.android.gms.internal.ads.zzevf r5 = r11.zzw(r2)
            int r4 = com.google.android.gms.internal.ads.zzevh.zzw(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzesf
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.ads.zzesf r4 = (com.google.android.gms.internal.ads.zzesf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = r4.zzc()
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzewd.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzeso.zzw(r5)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.ads.zzewd.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzx(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.ads.zzewd.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzeso.zzw(r6)
            int r4 = com.google.android.gms.internal.ads.zzeso.zzx(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzeso.zzw(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.ads.zzevt<?, ?> r0 = r11.zzo
            java.lang.Object r12 = r0.zzj(r12)
            int r12 = r0.zzq(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzs(java.lang.Object):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x044f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzt(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzers r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzetq r12 = (com.google.android.gms.internal.ads.zzetq) r12
            boolean r13 = r12.zza()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.ads.zzetq r12 = r12.zze(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.ads.zzevf r1 = r15.zzw(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzert.zzj(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.ads.zzeud r12 = (com.google.android.gms.internal.ads.zzeud) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.ads.zzert.zzc(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.ads.zzesj.zzH(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzeud r12 = (com.google.android.gms.internal.ads.zzeud) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zzc(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzesj.zzH(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.ads.zzert.zzc(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzesj.zzH(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.ads.zzeti r12 = (com.google.android.gms.internal.ads.zzeti) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzesj.zzG(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzeti r12 = (com.google.android.gms.internal.ads.zzeti) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzesj.zzG(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzesj.zzG(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.ads.zzert.zzl(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.zzert.zzk(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.ads.zzeth r1 = (com.google.android.gms.internal.ads.zzeth) r1
            com.google.android.gms.internal.ads.zzevu r3 = r1.zzc
            com.google.android.gms.internal.ads.zzevu r4 = com.google.android.gms.internal.ads.zzevu.zza()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.ads.zzetl r4 = r15.zzy(r8)
            com.google.android.gms.internal.ads.zzevt<?, ?> r5 = r0.zzo
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzevh.zzG(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.ads.zzevu r3 = (com.google.android.gms.internal.ads.zzevu) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.ads.zzesf r4 = com.google.android.gms.internal.ads.zzesf.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.ads.zzesf r6 = com.google.android.gms.internal.ads.zzesf.zzr(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.ads.zzesf r4 = com.google.android.gms.internal.ads.zzesf.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.ads.zzesf r6 = com.google.android.gms.internal.ads.zzesf.zzr(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzc()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzc()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.ads.zzevf r1 = r15.zzw(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.ads.zzert.zzm(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x01fa
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f5
            if (r6 != 0) goto L_0x01c2
            r12.add(r1)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzetr.zza
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
        L_0x01cc:
            int r4 = r4 + r6
        L_0x01cd:
            if (r4 >= r5) goto L_0x044f
            int r6 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x044f
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f0
            if (r6 != 0) goto L_0x01e5
            r12.add(r1)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzetr.zza
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzc()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzc()
            throw r1
        L_0x01fa:
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0255
            if (r6 != 0) goto L_0x0208
            r12.add(r1)
            goto L_0x021b
        L_0x0208:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzewi.zzb(r3, r4, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzetr.zza
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
        L_0x021a:
            r4 = r8
        L_0x021b:
            if (r4 >= r5) goto L_0x044f
            int r6 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x044f
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024b
            if (r6 != 0) goto L_0x0233
            r12.add(r1)
            goto L_0x021b
        L_0x0233:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzewi.zzb(r3, r4, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzetr.zza
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzj()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzc()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzj()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzc()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.ads.zzeru r12 = (com.google.android.gms.internal.ads.zzeru) r12
            int r2 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.ads.zzert.zzc(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0274
            r5 = 1
            goto L_0x0275
        L_0x0274:
            r5 = 0
        L_0x0275:
            r12.zzd(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzeru r12 = (com.google.android.gms.internal.ads.zzeru) r12
            int r4 = com.google.android.gms.internal.ads.zzert.zzc(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = 1
            goto L_0x0294
        L_0x0293:
            r6 = 0
        L_0x0294:
            r12.zzd(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.ads.zzert.zzc(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r12.zzd(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.ads.zzeti r12 = (com.google.android.gms.internal.ads.zzeti) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.ads.zzert.zzd(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.ads.zzeti r12 = (com.google.android.gms.internal.ads.zzeti) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zzd(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.ads.zzert.zzd(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.ads.zzeud r12 = (com.google.android.gms.internal.ads.zzeud) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.ads.zzert.zze(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.ads.zzeud r12 = (com.google.android.gms.internal.ads.zzeud) r12
            long r8 = com.google.android.gms.internal.ads.zzert.zze(r17, r18)
            r12.zzg(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.ads.zzert.zze(r3, r4)
            r12.zzg(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.ads.zzert.zzl(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.ads.zzert.zzk(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.ads.zzeud r12 = (com.google.android.gms.internal.ads.zzeud) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.ads.zzert.zzc(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzeud r12 = (com.google.android.gms.internal.ads.zzeud) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zzc(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.ads.zzert.zzc(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.ads.zzeta r12 = (com.google.android.gms.internal.ads.zzeta) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.ads.zzert.zzd(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zzd(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.ads.zzeta r12 = (com.google.android.gms.internal.ads.zzeta) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zzd(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zzd(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.ads.zzert.zzd(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zzd(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.ads.zzesq r12 = (com.google.android.gms.internal.ads.zzesq) r12
            int r1 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.ads.zzert.zze(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.ads.zzett r1 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.ads.zzesq r12 = (com.google.android.gms.internal.ads.zzesq) r12
            long r8 = com.google.android.gms.internal.ads.zzert.zze(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zzd(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.ads.zzert.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.ads.zzert.zze(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zzd(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.ads.zzert.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzert.zzj(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzers):int");
    }

    private final <K, V> int zzu(T t, byte[] bArr, int i, int i2, int i3, long j, zzers zzers) throws IOException {
        Unsafe unsafe = zzb;
        Object zzx = zzx(i3);
        Object object = unsafe.getObject(t, j);
        if (zzeuj.zzb(object)) {
            zzeui zzc2 = zzeui.zza().zzc();
            zzeuj.zzc(zzc2, object);
            unsafe.putObject(t, j, zzc2);
        }
        zzeuh zzeuh = (zzeuh) zzx;
        throw null;
    }

    private final int zzv(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzers zzers) throws IOException {
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzers zzers2 = zzers;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(Double.longBitsToDouble(zzert.zze(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(Float.intBitsToFloat(zzert.zzd(bArr, i))));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzc2 = zzert.zzc(bArr2, i9, zzers2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzers2.zzb));
                    unsafe.putInt(t2, j3, i11);
                    return zzc2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zza2 = zzert.zza(bArr2, i9, zzers2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzers2.zza));
                    unsafe.putInt(t2, j3, i11);
                    return zza2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzert.zze(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzert.zzd(bArr, i)));
                    unsafe.putInt(t2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzc3 = zzert.zzc(bArr2, i9, zzers2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzers2.zzb != 0));
                    unsafe.putInt(t2, j3, i11);
                    return zzc3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zza3 = zzert.zza(bArr2, i9, zzers2);
                    int i14 = zzers2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzewi.zzb(bArr2, zza3, zza3 + i14)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza3, i14, zzetr.zza));
                        zza3 += i14;
                    } else {
                        throw zzett.zzj();
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zza3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzi2 = zzert.zzi(zzw(i13), bArr2, i9, i2, zzers2);
                    Object object = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzers2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzetr.zzi(object, zzers2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzi2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zzh2 = zzert.zzh(bArr2, i9, zzers2);
                    unsafe.putObject(t2, j2, zzers2.zzc);
                    unsafe.putInt(t2, j3, i11);
                    return zzh2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zza4 = zzert.zza(bArr2, i9, zzers2);
                    int i15 = zzers2.zza;
                    zzetl zzy = zzy(i13);
                    if (zzy == null || zzy.zza(i15)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i15));
                        unsafe.putInt(t2, j3, i11);
                    } else {
                        zzg(t).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zza4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zza5 = zzert.zza(bArr2, i9, zzers2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzesj.zzG(zzers2.zza)));
                    unsafe.putInt(t2, j3, i11);
                    return zza5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzc4 = zzert.zzc(bArr2, i9, zzers2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzesj.zzH(zzers2.zzb)));
                    unsafe.putInt(t2, j3, i11);
                    return zzc4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzj2 = zzert.zzj(zzw(i13), bArr, i, i2, (i10 & -8) | 4, zzers);
                    Object object2 = unsafe.getInt(t2, j3) == i11 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzers2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzetr.zzi(object2, zzers2.zzc));
                    }
                    unsafe.putInt(t2, j3, i11);
                    return zzj2;
                }
                break;
        }
        return i9;
    }

    private final zzevf zzw(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzevf zzevf = (zzevf) this.zzd[i3];
        if (zzevf != null) {
            return zzevf;
        }
        zzevf zzb2 = zzeuw.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzx(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzetl zzy(int i) {
        int i2 = i / 3;
        return (zzetl) this.zzd[i2 + i2 + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02a8, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02be, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0312, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017d, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r1 = r20;
        r8 = 1048575;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d2, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0207, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020a, code lost:
        r2 = r4;
        r28 = r10;
        r19 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzz(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.ads.zzers r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x033b
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.ads.zzert.zzb(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002f
        L_0x002c:
            r17 = r0
            r4 = r3
        L_0x002f:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzT(r5, r2)
            goto L_0x0040
        L_0x003c:
            int r0 = r15.zzS(r5)
        L_0x0040:
            r2 = r0
            if (r2 != r10) goto L_0x004e
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = -1
            r19 = 0
            goto L_0x0315
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzF(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x0213
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            if (r10 == r7) goto L_0x0090
            r23 = r1
            r20 = r2
            if (r7 == r13) goto L_0x0081
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0083
        L_0x0081:
            r7 = r19
        L_0x0083:
            if (r10 == r13) goto L_0x008a
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x008a:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0096
        L_0x0090:
            r23 = r1
            r20 = r2
            r10 = r19
        L_0x0096:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01f1;
                case 1: goto L_0x01da;
                case 2: goto L_0x01bc;
                case 3: goto L_0x01bc;
                case 4: goto L_0x01a9;
                case 5: goto L_0x018d;
                case 6: goto L_0x0169;
                case 7: goto L_0x014c;
                case 8: goto L_0x012b;
                case 9: goto L_0x00f9;
                case 10: goto L_0x00e7;
                case 11: goto L_0x01a9;
                case 12: goto L_0x00d6;
                case 13: goto L_0x0169;
                case 14: goto L_0x018d;
                case 15: goto L_0x00c1;
                case 16: goto L_0x00a3;
                default: goto L_0x009a;
            }
        L_0x009a:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            goto L_0x020a
        L_0x00a3:
            if (r3 != 0) goto L_0x00bc
            int r17 = com.google.android.gms.internal.ads.zzert.zzc(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.ads.zzesj.zzH(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            r0.putLong(r1, r2, r4)
            goto L_0x01d2
        L_0x00bc:
            r13 = r20
            r20 = r33
            goto L_0x0126
        L_0x00c1:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0126
            int r0 = com.google.android.gms.internal.ads.zzert.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.ads.zzesj.zzG(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x00d6:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0126
            int r0 = com.google.android.gms.internal.ads.zzert.zza(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x00e7:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0126
            int r0 = com.google.android.gms.internal.ads.zzert.zzh(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0207
        L_0x00f9:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0124
            com.google.android.gms.internal.ads.zzevf r0 = r15.zzw(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.ads.zzert.zzi(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x011a
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x011a:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzetr.zzi(r1, r3)
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x0124:
            r2 = r34
        L_0x0126:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x020a
        L_0x012b:
            r2 = r34
            r13 = r20
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r0) goto L_0x020a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0142
            int r0 = com.google.android.gms.internal.ads.zzert.zzf(r12, r4, r11)
            goto L_0x0146
        L_0x0142:
            int r0 = com.google.android.gms.internal.ads.zzert.zzg(r12, r4, r11)
        L_0x0146:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x014c:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzert.zzc(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r5 = 0
        L_0x0165:
            com.google.android.gms.internal.ads.zzewd.zzi(r14, r8, r5)
            goto L_0x017d
        L_0x0169:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzert.zzd(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x017d:
            r6 = r6 | r21
            r9 = r10
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x001a
        L_0x018d:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x020a
            long r22 = com.google.android.gms.internal.ads.zzert.zze(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0207
        L_0x01a9:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzert.zza(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x01bc:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r17 = com.google.android.gms.internal.ads.zzert.zzc(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
        L_0x01d2:
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x0257
        L_0x01da:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x020a
            int r0 = com.google.android.gms.internal.ads.zzert.zzd(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzewd.zzk(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0207
        L_0x01f1:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x020a
            long r0 = com.google.android.gms.internal.ads.zzert.zze(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzewd.zzm(r14, r8, r0)
            int r0 = r4 + 8
        L_0x0207:
            r6 = r6 | r21
            goto L_0x0255
        L_0x020a:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x0315
        L_0x0213:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x026e
            r1 = 2
            if (r3 != r1) goto L_0x0261
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.ads.zzetq r0 = (com.google.android.gms.internal.ads.zzetq) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0241
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0239
            r1 = 10
            goto L_0x023a
        L_0x0239:
            int r1 = r1 + r1
        L_0x023a:
            com.google.android.gms.internal.ads.zzetq r0 = r0.zze(r1)
            r10.putObject(r14, r8, r0)
        L_0x0241:
            r5 = r0
            com.google.android.gms.internal.ads.zzevf r0 = r15.zzw(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.ads.zzert.zzm(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0255:
            r9 = r10
            r2 = r13
        L_0x0257:
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x001a
        L_0x0261:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02de
        L_0x026e:
            r1 = 49
            if (r0 > r1) goto L_0x02c0
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02be
        L_0x02aa:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            goto L_0x0333
        L_0x02be:
            r2 = r0
            goto L_0x02df
        L_0x02c0:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02f8
            r7 = r33
            r0 = 2
            if (r7 == r0) goto L_0x02e4
        L_0x02de:
            r2 = r15
        L_0x02df:
            r6 = r24
            r7 = r25
            goto L_0x0315
        L_0x02e4:
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            r0.zzu(r1, r2, r3, r4, r5, r6, r8)
            r0 = 0
            throw r0
        L_0x02f8:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02be
            goto L_0x02aa
        L_0x0315:
            com.google.android.gms.internal.ads.zzevu r4 = zzg(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzert.zzn(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
        L_0x0333:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001a
        L_0x033b:
            r24 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x034e
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x034e:
            r1 = r34
            if (r0 != r1) goto L_0x0353
            return r0
        L_0x0353:
            com.google.android.gms.internal.ads.zzett r0 = com.google.android.gms.internal.ads.zzett.zzi()
            goto L_0x0359
        L_0x0358:
            throw r0
        L_0x0359:
            goto L_0x0358
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzz(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzers):int");
    }

    public final T zza() {
        return ((zzeth) this.zzg).zzb(4, (Object) null, (Object) null);
    }

    public final boolean zzb(T t, T t2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzD = zzD(i);
            long j = (long) (zzD & 1048575);
            switch (zzF(zzD)) {
                case 0:
                    if (zzM(t, t2, i) && Double.doubleToLongBits(zzewd.zzl(t, j)) == Double.doubleToLongBits(zzewd.zzl(t2, j))) {
                        continue;
                    }
                case 1:
                    if (zzM(t, t2, i) && Float.floatToIntBits(zzewd.zzj(t, j)) == Float.floatToIntBits(zzewd.zzj(t2, j))) {
                        continue;
                    }
                case 2:
                    if (zzM(t, t2, i) && zzewd.zzf(t, j) == zzewd.zzf(t2, j)) {
                        continue;
                    }
                case 3:
                    if (zzM(t, t2, i) && zzewd.zzf(t, j) == zzewd.zzf(t2, j)) {
                        continue;
                    }
                case 4:
                    if (zzM(t, t2, i) && zzewd.zzd(t, j) == zzewd.zzd(t2, j)) {
                        continue;
                    }
                case 5:
                    if (zzM(t, t2, i) && zzewd.zzf(t, j) == zzewd.zzf(t2, j)) {
                        continue;
                    }
                case 6:
                    if (zzM(t, t2, i) && zzewd.zzd(t, j) == zzewd.zzd(t2, j)) {
                        continue;
                    }
                case 7:
                    if (zzM(t, t2, i) && zzewd.zzh(t, j) == zzewd.zzh(t2, j)) {
                        continue;
                    }
                case 8:
                    if (zzM(t, t2, i) && zzevh.zzD(zzewd.zzn(t, j), zzewd.zzn(t2, j))) {
                        continue;
                    }
                case 9:
                    if (zzM(t, t2, i) && zzevh.zzD(zzewd.zzn(t, j), zzewd.zzn(t2, j))) {
                        continue;
                    }
                case 10:
                    if (zzM(t, t2, i) && zzevh.zzD(zzewd.zzn(t, j), zzewd.zzn(t2, j))) {
                        continue;
                    }
                case 11:
                    if (zzM(t, t2, i) && zzewd.zzd(t, j) == zzewd.zzd(t2, j)) {
                        continue;
                    }
                case 12:
                    if (zzM(t, t2, i) && zzewd.zzd(t, j) == zzewd.zzd(t2, j)) {
                        continue;
                    }
                case 13:
                    if (zzM(t, t2, i) && zzewd.zzd(t, j) == zzewd.zzd(t2, j)) {
                        continue;
                    }
                case 14:
                    if (zzM(t, t2, i) && zzewd.zzf(t, j) == zzewd.zzf(t2, j)) {
                        continue;
                    }
                case 15:
                    if (zzM(t, t2, i) && zzewd.zzd(t, j) == zzewd.zzd(t2, j)) {
                        continue;
                    }
                case 16:
                    if (zzM(t, t2, i) && zzewd.zzf(t, j) == zzewd.zzf(t2, j)) {
                        continue;
                    }
                case 17:
                    if (zzM(t, t2, i) && zzevh.zzD(zzewd.zzn(t, j), zzewd.zzn(t2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzevh.zzD(zzewd.zzn(t, j), zzewd.zzn(t2, j));
                    break;
                case 50:
                    z = zzevh.zzD(zzewd.zzn(t, j), zzewd.zzn(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzE = (long) (zzE(i) & 1048575);
                    if (zzewd.zzd(t, zzE) == zzewd.zzd(t2, zzE) && zzevh.zzD(zzewd.zzn(t, j), zzewd.zzn(t2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzo.zzj(t).equals(this.zzo.zzj(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zzb(t);
        this.zzp.zzb(t2);
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzD(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzF(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzL(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zzf(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzJ(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzK(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzI(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzQ(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzH(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzewd.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzewd.zzd(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzewd.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzewd.zzd(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzewd.zzd(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzewd.zzd(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzewd.zzn(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.ads.zzewd.zzh(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zzf(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzewd.zzd(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzewd.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzewd.zzd(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzewd.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzewd.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.ads.zzewd.zzj(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.ads.zzewd.zzl(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzetr.zze(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzevt<?, ?> r0 = r8.zzo
            java.lang.Object r0 = r0.zzj(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.ads.zzesu<?> r0 = r8.zzp
            r0.zzb(r9)
            r9 = 0
            goto L_0x0245
        L_0x0244:
            throw r9
        L_0x0245:
            goto L_0x0244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzc(java.lang.Object):int");
    }

    public final int zze(T t) {
        return this.zzj ? zzs(t) : zzr(t);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zzf(T r13, com.google.android.gms.internal.ads.zzeuz r14, com.google.android.gms.internal.ads.zzest r15) throws java.io.IOException {
        /*
            r12 = this;
            java.util.Objects.requireNonNull(r15)
            com.google.android.gms.internal.ads.zzevt<?, ?> r7 = r12.zzo
            com.google.android.gms.internal.ads.zzesu<?> r8 = r12.zzp
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x000a:
            int r1 = r14.zzb()     // Catch:{ all -> 0x0076 }
            int r2 = r12.zzS(r1)     // Catch:{ all -> 0x0076 }
            if (r2 >= 0) goto L_0x0079
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.zzl
        L_0x001b:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzA(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x0029:
            if (r10 == 0) goto L_0x05bc
            r7.zzl(r13, r10)
            return
        L_0x002f:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x0076 }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.ads.zzeuo r2 = r12.zzg     // Catch:{ all -> 0x0076 }
            java.lang.Object r1 = r8.zzf(r15, r2, r1)     // Catch:{ all -> 0x0076 }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzesy r0 = r8.zzc(r13)     // Catch:{ all -> 0x0076 }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zze(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0076 }
            r0 = r11
            goto L_0x000a
        L_0x0051:
            r7.zza(r14)     // Catch:{ all -> 0x0076 }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r7.zzk(r13)     // Catch:{ all -> 0x0076 }
        L_0x005a:
            boolean r1 = r7.zzn(r10, r14)     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0062:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0070
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzA(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0070:
            if (r10 == 0) goto L_0x05bc
            r7.zzl(r13, r10)
            return
        L_0x0076:
            r14 = move-exception
            goto L_0x05bd
        L_0x0079:
            int r3 = r12.zzD(r2)     // Catch:{ all -> 0x0076 }
            int r4 = zzF(r3)     // Catch:{ zzets -> 0x0597 }
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x056e;
                case 1: goto L_0x055f;
                case 2: goto L_0x0550;
                case 3: goto L_0x0541;
                case 4: goto L_0x0532;
                case 5: goto L_0x0523;
                case 6: goto L_0x0514;
                case 7: goto L_0x0505;
                case 8: goto L_0x04fd;
                case 9: goto L_0x04cc;
                case 10: goto L_0x04bd;
                case 11: goto L_0x04ae;
                case 12: goto L_0x048c;
                case 13: goto L_0x047d;
                case 14: goto L_0x046e;
                case 15: goto L_0x045f;
                case 16: goto L_0x0450;
                case 17: goto L_0x041f;
                case 18: goto L_0x0411;
                case 19: goto L_0x0403;
                case 20: goto L_0x03f5;
                case 21: goto L_0x03e7;
                case 22: goto L_0x03d9;
                case 23: goto L_0x03cb;
                case 24: goto L_0x03bd;
                case 25: goto L_0x03af;
                case 26: goto L_0x0385;
                case 27: goto L_0x0373;
                case 28: goto L_0x0365;
                case 29: goto L_0x0357;
                case 30: goto L_0x0342;
                case 31: goto L_0x0334;
                case 32: goto L_0x0326;
                case 33: goto L_0x0318;
                case 34: goto L_0x030a;
                case 35: goto L_0x02fc;
                case 36: goto L_0x02ee;
                case 37: goto L_0x02e0;
                case 38: goto L_0x02d2;
                case 39: goto L_0x02c4;
                case 40: goto L_0x02b6;
                case 41: goto L_0x02a8;
                case 42: goto L_0x029a;
                case 43: goto L_0x028c;
                case 44: goto L_0x0277;
                case 45: goto L_0x0269;
                case 46: goto L_0x025b;
                case 47: goto L_0x024d;
                case 48: goto L_0x023f;
                case 49: goto L_0x022d;
                case 50: goto L_0x01f7;
                case 51: goto L_0x01e5;
                case 52: goto L_0x01d3;
                case 53: goto L_0x01c1;
                case 54: goto L_0x01af;
                case 55: goto L_0x019d;
                case 56: goto L_0x018b;
                case 57: goto L_0x0179;
                case 58: goto L_0x0167;
                case 59: goto L_0x015f;
                case 60: goto L_0x012e;
                case 61: goto L_0x0120;
                case 62: goto L_0x010e;
                case 63: goto L_0x00e9;
                case 64: goto L_0x00d7;
                case 65: goto L_0x00c5;
                case 66: goto L_0x00b3;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x0087;
            }     // Catch:{ zzets -> 0x0597 }
        L_0x0087:
            if (r10 != 0) goto L_0x057d
            java.lang.Object r10 = r7.zzg()     // Catch:{ zzets -> 0x0597 }
            goto L_0x057d
        L_0x008f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r5 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r5 = r14.zzp(r5, r15)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x00a1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzw()     // Catch:{ zzets -> 0x0597 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x00b3:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            int r5 = r14.zzv()     // Catch:{ zzets -> 0x0597 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x00c5:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzu()     // Catch:{ zzets -> 0x0597 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x00d7:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            int r5 = r14.zzt()     // Catch:{ zzets -> 0x0597 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x00e9:
            int r4 = r14.zzs()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzetl r6 = r12.zzy(r2)     // Catch:{ zzets -> 0x0597 }
            if (r6 == 0) goto L_0x0100
            boolean r6 = r6.zza(r4)     // Catch:{ zzets -> 0x0597 }
            if (r6 == 0) goto L_0x00fa
            goto L_0x0100
        L_0x00fa:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzevh.zzH(r1, r4, r10, r7)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0100:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzets -> 0x0597 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r5, r3)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x010e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            int r5 = r14.zzr()     // Catch:{ zzets -> 0x0597 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0120:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzesf r5 = r14.zzq()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x012e:
            boolean r4 = r12.zzQ(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            if (r4 == 0) goto L_0x014a
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzewd.zzn(r13, r3)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r6 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r6 = r14.zzo(r6, r15)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzetr.zzi(r5, r6)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            goto L_0x015a
        L_0x014a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r5 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r5 = r14.zzo(r5, r15)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
        L_0x015a:
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x015f:
            r12.zzC(r13, r3, r14)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0167:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            boolean r5 = r14.zzl()     // Catch:{ zzets -> 0x0597 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0179:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            int r5 = r14.zzk()     // Catch:{ zzets -> 0x0597 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x018b:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzj()     // Catch:{ zzets -> 0x0597 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x019d:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            int r5 = r14.zzi()     // Catch:{ zzets -> 0x0597 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x01af:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzg()     // Catch:{ zzets -> 0x0597 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x01c1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzh()     // Catch:{ zzets -> 0x0597 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x01d3:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            float r5 = r14.zzf()     // Catch:{ zzets -> 0x0597 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x01e5:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzets -> 0x0597 }
            double r5 = r14.zze()     // Catch:{ zzets -> 0x0597 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzR(r13, r1, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x01f7:
            java.lang.Object r1 = r12.zzx(r2)     // Catch:{ zzets -> 0x0597 }
            int r2 = r12.zzD(r2)     // Catch:{ zzets -> 0x0597 }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzewd.zzn(r13, r2)     // Catch:{ zzets -> 0x0597 }
            if (r4 == 0) goto L_0x021d
            boolean r5 = com.google.android.gms.internal.ads.zzeuj.zzb(r4)     // Catch:{ zzets -> 0x0597 }
            if (r5 == 0) goto L_0x0228
            com.google.android.gms.internal.ads.zzeui r5 = com.google.android.gms.internal.ads.zzeui.zza()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzeui r5 = r5.zzc()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzeuj.zzc(r5, r4)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r2, r5)     // Catch:{ zzets -> 0x0597 }
            r4 = r5
            goto L_0x0228
        L_0x021d:
            com.google.android.gms.internal.ads.zzeui r4 = com.google.android.gms.internal.ads.zzeui.zza()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzeui r4 = r4.zzc()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r2, r4)     // Catch:{ zzets -> 0x0597 }
        L_0x0228:
            com.google.android.gms.internal.ads.zzeui r4 = (com.google.android.gms.internal.ads.zzeui) r4     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzeuh r1 = (com.google.android.gms.internal.ads.zzeuh) r1     // Catch:{ zzets -> 0x0597 }
            throw r9     // Catch:{ zzets -> 0x0597 }
        L_0x022d:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r1 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzeuc r2 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzets -> 0x0597 }
            r14.zzH(r2, r1, r15)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x023f:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzO(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x024d:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzN(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x025b:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzM(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0269:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzL(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0277:
            com.google.android.gms.internal.ads.zzeuc r4 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzets -> 0x0597 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzets -> 0x0597 }
            r14.zzK(r3)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzetl r2 = r12.zzy(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzevh.zzG(r1, r3, r2, r10, r7)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x028c:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzJ(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x029a:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzE(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x02a8:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzD(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x02b6:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzC(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x02c4:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzB(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x02d2:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzz(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x02e0:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzA(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x02ee:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzy(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x02fc:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzx(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x030a:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzO(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0318:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzN(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0326:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzM(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0334:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzL(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0342:
            com.google.android.gms.internal.ads.zzeuc r4 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzets -> 0x0597 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzets -> 0x0597 }
            r14.zzK(r3)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzetl r2 = r12.zzy(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzevh.zzG(r1, r3, r2, r10, r7)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0357:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzJ(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0365:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzI(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0373:
            com.google.android.gms.internal.ads.zzevf r1 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzeuc r4 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzG(r2, r1, r15)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0385:
            boolean r1 = zzG(r3)     // Catch:{ zzets -> 0x0597 }
            if (r1 == 0) goto L_0x039d
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r2 = r14
            com.google.android.gms.internal.ads.zzesk r2 = (com.google.android.gms.internal.ads.zzesk) r2     // Catch:{ zzets -> 0x0597 }
            r3 = 1
            r2.zzF(r1, r3)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x039d:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r2 = r14
            com.google.android.gms.internal.ads.zzesk r2 = (com.google.android.gms.internal.ads.zzesk) r2     // Catch:{ zzets -> 0x0597 }
            r3 = 0
            r2.zzF(r1, r3)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x03af:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzE(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x03bd:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzD(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x03cb:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzC(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x03d9:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzB(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x03e7:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzz(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x03f5:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzA(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0403:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzy(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0411:
            com.google.android.gms.internal.ads.zzeuc r1 = r12.zzn     // Catch:{ zzets -> 0x0597 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzets -> 0x0597 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzets -> 0x0597 }
            r14.zzx(r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x041f:
            boolean r1 = r12.zzO(r13, r2)     // Catch:{ zzets -> 0x0597 }
            if (r1 == 0) goto L_0x043d
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzewd.zzn(r13, r3)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r2 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r2 = r14.zzp(r2, r15)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzetr.zzi(r1, r2)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x043d:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r1 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r1 = r14.zzp(r1, r15)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0450:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzw()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzg(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x045f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            int r1 = r14.zzv()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zze(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x046e:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzu()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzg(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x047d:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            int r1 = r14.zzt()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zze(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x048c:
            int r4 = r14.zzs()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzetl r6 = r12.zzy(r2)     // Catch:{ zzets -> 0x0597 }
            if (r6 == 0) goto L_0x04a3
            boolean r6 = r6.zza(r4)     // Catch:{ zzets -> 0x0597 }
            if (r6 == 0) goto L_0x049d
            goto L_0x04a3
        L_0x049d:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzevh.zzH(r1, r4, r10, r7)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x04a3:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zze(r13, r5, r4)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x04ae:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            int r1 = r14.zzr()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zze(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x04bd:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzesf r1 = r14.zzq()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x04cc:
            boolean r1 = r12.zzO(r13, r2)     // Catch:{ zzets -> 0x0597 }
            if (r1 == 0) goto L_0x04ea
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzewd.zzn(r13, r3)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r2 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r2 = r14.zzo(r2, r15)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzetr.zzi(r1, r2)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x04ea:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzevf r1 = r12.zzw(r2)     // Catch:{ zzets -> 0x0597 }
            java.lang.Object r1 = r14.zzo(r1, r15)     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzo(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x04fd:
            r12.zzC(r13, r3, r14)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0505:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            boolean r1 = r14.zzl()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzi(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0514:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            int r1 = r14.zzk()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zze(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0523:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzj()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzg(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0532:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            int r1 = r14.zzi()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zze(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0541:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzg()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzg(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x0550:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            long r5 = r14.zzh()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzg(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x055f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            float r1 = r14.zzf()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzk(r13, r3, r1)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x056e:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzets -> 0x0597 }
            double r5 = r14.zze()     // Catch:{ zzets -> 0x0597 }
            com.google.android.gms.internal.ads.zzewd.zzm(r13, r3, r5)     // Catch:{ zzets -> 0x0597 }
            r12.zzP(r13, r2)     // Catch:{ zzets -> 0x0597 }
            goto L_0x000a
        L_0x057d:
            boolean r1 = r7.zzn(r10, r14)     // Catch:{ zzets -> 0x0597 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0585:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0593
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzA(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0585
        L_0x0593:
            r7.zzl(r13, r10)
            return
        L_0x0597:
            r7.zza(r14)     // Catch:{ all -> 0x0076 }
            if (r10 != 0) goto L_0x05a1
            java.lang.Object r1 = r7.zzk(r13)     // Catch:{ all -> 0x0076 }
            r10 = r1
        L_0x05a1:
            boolean r1 = r7.zzn(r10, r14)     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x05a9:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x05b7
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzA(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05a9
        L_0x05b7:
            if (r10 == 0) goto L_0x05bc
            r7.zzl(r13, r10)
        L_0x05bc:
            return
        L_0x05bd:
            int r15 = r12.zzl
        L_0x05bf:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x05cd
            int[] r0 = r12.zzk
            r0 = r0[r15]
            r12.zzA(r13, r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05bf
        L_0x05cd:
            if (r10 == 0) goto L_0x05d2
            r7.zzl(r13, r10)
        L_0x05d2:
            goto L_0x05d4
        L_0x05d3:
            throw r14
        L_0x05d4:
            goto L_0x05d3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzf(java.lang.Object, com.google.android.gms.internal.ads.zzeuz, com.google.android.gms.internal.ads.zzest):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x020c, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0247, code lost:
        r5 = r6 | r24;
        r3 = r7;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0284, code lost:
        r5 = r6 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0286, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0287, code lost:
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x029e, code lost:
        r18 = r6;
        r19 = r7;
        r26 = r10;
        r8 = r11;
        r24 = r20;
        r6 = r25;
        r14 = null;
        r7 = r33;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzh(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.ads.zzers r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x0425
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.ads.zzert.zzb(r0, r12, r1, r9)
            int r1 = r9.zza
            goto L_0x002d
        L_0x0028:
            r27 = r1
            r1 = r0
            r0 = r27
        L_0x002d:
            int r7 = r1 >>> 3
            r8 = r1 & 7
            r4 = 3
            if (r7 <= r2) goto L_0x003a
            int r3 = r3 / r4
            int r2 = r15.zzT(r7, r3)
            goto L_0x003e
        L_0x003a:
            int r2 = r15.zzS(r7)
        L_0x003e:
            r3 = -1
            if (r2 != r3) goto L_0x0051
            r2 = r0
            r8 = r1
            r18 = r5
            r24 = r7
            r26 = r10
            r7 = r11
            r14 = 0
            r17 = -1
            r19 = 0
            goto L_0x03b7
        L_0x0051:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r3 = r3[r19]
            int r4 = zzF(r3)
            r20 = r1
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r3 & r17
            r21 = r0
            long r0 = (long) r1
            r22 = r0
            r0 = 17
            if (r4 > r0) goto L_0x02ae
            int[] r0 = r15.zzc
            int r24 = r2 + 2
            r0 = r0[r24]
            int r24 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r24
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r11
            if (r0 == r6) goto L_0x008c
            r17 = r2
            if (r6 == r11) goto L_0x0084
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x0084:
            long r1 = (long) r0
            int r5 = r10.getInt(r14, r1)
            r25 = r0
            goto L_0x0090
        L_0x008c:
            r17 = r2
            r25 = r6
        L_0x0090:
            r6 = r5
            r0 = 5
            switch(r4) {
                case 0: goto L_0x0268;
                case 1: goto L_0x024c;
                case 2: goto L_0x0228;
                case 3: goto L_0x0228;
                case 4: goto L_0x020f;
                case 5: goto L_0x01eb;
                case 6: goto L_0x01d2;
                case 7: goto L_0x01b0;
                case 8: goto L_0x018c;
                case 9: goto L_0x015b;
                case 10: goto L_0x0141;
                case 11: goto L_0x020f;
                case 12: goto L_0x010c;
                case 13: goto L_0x01d2;
                case 14: goto L_0x01eb;
                case 15: goto L_0x00ef;
                case 16: goto L_0x00c3;
                default: goto L_0x0095;
            }
        L_0x0095:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 3
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029e
            com.google.android.gms.internal.ads.zzevf r0 = r15.zzw(r7)
            int r1 = r20 << 3
            r8 = r1 | 4
            r1 = r30
            r3 = r32
            r12 = r4
            r4 = r8
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzert.zzj(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x028a
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x0297
        L_0x00c3:
            if (r8 != 0) goto L_0x00e3
            r1 = r21
            int r8 = com.google.android.gms.internal.ads.zzert.zzc(r12, r1, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.ads.zzesj.zzH(r0)
            r2 = r22
            r0 = r10
            r11 = r20
            r1 = r29
            r20 = r7
            r7 = r17
            r17 = -1
            r0.putLong(r1, r2, r4)
            goto L_0x0247
        L_0x00e3:
            r11 = r20
            r20 = r7
            r7 = r17
            r17 = -1
            r2 = r21
            goto L_0x029e
        L_0x00ef:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020c
            int r0 = com.google.android.gms.internal.ads.zzert.zza(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.ads.zzesj.zzG(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0284
        L_0x010c:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020c
            int r0 = com.google.android.gms.internal.ads.zzert.zza(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.ads.zzetl r4 = r15.zzy(r7)
            if (r4 == 0) goto L_0x013c
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x012d
            goto L_0x013c
        L_0x012d:
            com.google.android.gms.internal.ads.zzevu r2 = zzg(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            goto L_0x0286
        L_0x013c:
            r10.putInt(r14, r2, r1)
            goto L_0x0284
        L_0x0141:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020c
            int r0 = com.google.android.gms.internal.ads.zzert.zzh(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0284
        L_0x015b:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020c
            com.google.android.gms.internal.ads.zzevf r0 = r15.zzw(r7)
            int r0 = com.google.android.gms.internal.ads.zzert.zzi(r0, r12, r1, r13, r9)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x017d
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0284
        L_0x017d:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzetr.zzi(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0284
        L_0x018c:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 2
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020c
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x01a5
            int r0 = com.google.android.gms.internal.ads.zzert.zzf(r12, r1, r9)
            goto L_0x01a9
        L_0x01a5:
            int r0 = com.google.android.gms.internal.ads.zzert.zzg(r12, r1, r9)
        L_0x01a9:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0284
        L_0x01b0:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x020c
            int r0 = com.google.android.gms.internal.ads.zzert.zzc(r12, r1, r9)
            long r1 = r9.zzb
            r21 = 0
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x01cc
            r1 = 1
            goto L_0x01cd
        L_0x01cc:
            r1 = 0
        L_0x01cd:
            com.google.android.gms.internal.ads.zzewd.zzi(r14, r4, r1)
            goto L_0x0284
        L_0x01d2:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020c
            int r0 = com.google.android.gms.internal.ads.zzert.zzd(r12, r1)
            r10.putInt(r14, r4, r0)
            int r0 = r1 + 4
            goto L_0x0284
        L_0x01eb:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 1
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x020c
            long r21 = com.google.android.gms.internal.ads.zzert.zze(r12, r1)
            r8 = r1
            r0 = r10
            r1 = r29
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0284
        L_0x020c:
            r2 = r1
            goto L_0x029e
        L_0x020f:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x029e
            int r0 = com.google.android.gms.internal.ads.zzert.zza(r12, r2, r9)
            int r1 = r9.zza
            r10.putInt(r14, r4, r1)
            goto L_0x0284
        L_0x0228:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x029e
            int r8 = com.google.android.gms.internal.ads.zzert.zzc(r12, r2, r9)
            long r2 = r9.zzb
            r0 = r10
            r1 = r29
            r21 = r2
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x0247:
            r5 = r6 | r24
            r3 = r7
            r0 = r8
            goto L_0x0287
        L_0x024c:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029e
            int r0 = com.google.android.gms.internal.ads.zzert.zzd(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzewd.zzk(r14, r4, r0)
            int r0 = r2 + 4
            goto L_0x0284
        L_0x0268:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 1
            r20 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x029e
            long r0 = com.google.android.gms.internal.ads.zzert.zze(r12, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzewd.zzm(r14, r4, r0)
            int r0 = r2 + 8
        L_0x0284:
            r5 = r6 | r24
        L_0x0286:
            r3 = r7
        L_0x0287:
            r1 = r11
            goto L_0x02fa
        L_0x028a:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzetr.zzi(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x0297:
            r5 = r6 | r24
            r12 = r30
            r13 = r32
            goto L_0x0286
        L_0x029e:
            r18 = r6
            r19 = r7
            r26 = r10
            r8 = r11
            r24 = r20
            r6 = r25
            r14 = 0
            r7 = r33
            goto L_0x03b7
        L_0x02ae:
            r11 = r20
            r12 = r22
            r17 = -1
            r20 = r7
            r7 = r2
            r2 = r21
            r0 = 27
            if (r4 != r0) goto L_0x0311
            r0 = 2
            if (r8 != r0) goto L_0x0302
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.ads.zzetq r0 = (com.google.android.gms.internal.ads.zzetq) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x02dd
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d5
            r1 = 10
            goto L_0x02d6
        L_0x02d5:
            int r1 = r1 + r1
        L_0x02d6:
            com.google.android.gms.internal.ads.zzetq r0 = r0.zze(r1)
            r10.putObject(r14, r12, r0)
        L_0x02dd:
            r8 = r0
            com.google.android.gms.internal.ads.zzevf r0 = r15.zzw(r7)
            r1 = r11
            r3 = r2
            r2 = r30
            r4 = r32
            r18 = r5
            r5 = r8
            r25 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.ads.zzert.zzm(r0, r1, r2, r3, r4, r5, r6)
            r12 = r30
            r13 = r32
            r3 = r7
            r5 = r18
        L_0x02fa:
            r2 = r20
            r6 = r25
            r11 = r33
            goto L_0x0019
        L_0x0302:
            r18 = r5
            r25 = r6
            r15 = r2
            r19 = r7
            r26 = r10
            r24 = r20
            r20 = r11
            goto L_0x0377
        L_0x0311:
            r18 = r5
            r25 = r6
            r6 = r2
            r0 = 49
            if (r4 > r0) goto L_0x0363
            long r2 = (long) r3
            r0 = r28
            r1 = r29
            r21 = r2
            r2 = r30
            r3 = r6
            r5 = r4
            r15 = 0
            r4 = r32
            r31 = r5
            r5 = r11
            r15 = r6
            r6 = r20
            r19 = r7
            r24 = r20
            r7 = r8
            r8 = r19
            r26 = r10
            r9 = r21
            r20 = r11
            r11 = r31
            r14 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x035f
        L_0x0345:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r5 = r18
            r3 = r19
            r1 = r20
            r2 = r24
            r6 = r25
            r10 = r26
            goto L_0x0019
        L_0x035f:
            r7 = r33
            r2 = r0
            goto L_0x037a
        L_0x0363:
            r31 = r4
            r15 = r6
            r19 = r7
            r26 = r10
            r24 = r20
            r20 = r11
            r0 = 50
            r9 = r31
            if (r9 != r0) goto L_0x0393
            r0 = 2
            if (r8 == r0) goto L_0x0380
        L_0x0377:
            r7 = r33
            r2 = r15
        L_0x037a:
            r8 = r20
            r6 = r25
            r14 = 0
            goto L_0x03b7
        L_0x0380:
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r19
            r6 = r12
            r8 = r34
            r0.zzu(r1, r2, r3, r4, r5, r6, r8)
            r14 = 0
            throw r14
        L_0x0393:
            r14 = 0
            r0 = r28
            r1 = r29
            r2 = r30
            r10 = r3
            r3 = r15
            r4 = r32
            r5 = r20
            r6 = r24
            r7 = r8
            r8 = r10
            r10 = r12
            r12 = r19
            r13 = r34
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x03b0
            goto L_0x0345
        L_0x03b0:
            r7 = r33
            r2 = r0
            r8 = r20
            r6 = r25
        L_0x03b7:
            if (r8 != r7) goto L_0x03c6
            if (r7 == 0) goto L_0x03c6
            r9 = r28
            r12 = r29
            r0 = r2
            r1 = r8
            r3 = r14
            r5 = r18
            goto L_0x042f
        L_0x03c6:
            r9 = r28
            r3 = r14
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x03fe
            r10 = r34
            com.google.android.gms.internal.ads.zzest r0 = r10.zzd
            com.google.android.gms.internal.ads.zzest r1 = com.google.android.gms.internal.ads.zzest.zza()
            if (r0 == r1) goto L_0x03fb
            com.google.android.gms.internal.ads.zzeuo r0 = r9.zzg
            com.google.android.gms.internal.ads.zzest r1 = r10.zzd
            r11 = r24
            com.google.android.gms.internal.ads.zzetf r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x03f5
            com.google.android.gms.internal.ads.zzevu r4 = zzg(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzert.zzn(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x0413
        L_0x03f5:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.ads.zzete r0 = (com.google.android.gms.internal.ads.zzete) r0
            throw r3
        L_0x03fb:
            r12 = r29
            goto L_0x0402
        L_0x03fe:
            r12 = r29
            r10 = r34
        L_0x0402:
            r11 = r24
            com.google.android.gms.internal.ads.zzevu r4 = zzg(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzert.zzn(r0, r1, r2, r3, r4, r5)
        L_0x0413:
            r13 = r32
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r5 = r18
            r3 = r19
            r10 = r26
            r12 = r30
            r11 = r7
            goto L_0x0019
        L_0x0425:
            r18 = r5
            r25 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            r3 = 0
        L_0x042f:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x043a
            long r10 = (long) r6
            r2 = r26
            r2.putInt(r12, r10, r5)
        L_0x043a:
            int r2 = r9.zzl
        L_0x043c:
            int r4 = r9.zzm
            if (r2 >= r4) goto L_0x044c
            int[] r4 = r9.zzk
            r4 = r4[r2]
            com.google.android.gms.internal.ads.zzevt<?, ?> r5 = r9.zzo
            r9.zzA(r12, r4, r3, r5)
            int r2 = r2 + 1
            goto L_0x043c
        L_0x044c:
            if (r7 != 0) goto L_0x0458
            r2 = r32
            if (r0 != r2) goto L_0x0453
            goto L_0x045e
        L_0x0453:
            com.google.android.gms.internal.ads.zzett r0 = com.google.android.gms.internal.ads.zzett.zzi()
            throw r0
        L_0x0458:
            r2 = r32
            if (r0 > r2) goto L_0x045f
            if (r1 != r7) goto L_0x045f
        L_0x045e:
            return r0
        L_0x045f:
            com.google.android.gms.internal.ads.zzett r0 = com.google.android.gms.internal.ads.zzett.zzi()
            goto L_0x0465
        L_0x0464:
            throw r0
        L_0x0465:
            goto L_0x0464
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeur.zzh(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzers):int");
    }

    public final void zzi(T t, byte[] bArr, int i, int i2, zzers zzers) throws IOException {
        if (this.zzj) {
            zzz(t, bArr, i, i2, zzers);
        } else {
            zzh(t, bArr, i, i2, 0, zzers);
        }
    }

    public final void zzj(T t) {
        int i;
        int i2 = this.zzl;
        while (true) {
            i = this.zzm;
            if (i2 >= i) {
                break;
            }
            long zzD = (long) (zzD(this.zzk[i2]) & 1048575);
            Object zzn2 = zzewd.zzn(t, zzD);
            if (zzn2 != null) {
                ((zzeui) zzn2).zzd();
                zzewd.zzo(t, zzD, zzn2);
            }
            i2++;
        }
        int length = this.zzk.length;
        while (i < length) {
            this.zzn.zzb(t, (long) this.zzk[i]);
            i++;
        }
        this.zzo.zzm(t);
        if (this.zzh) {
            this.zzp.zzd(t);
        }
    }

    public final boolean zzk(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzl) {
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzD = zzD(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzD) != 0 && !zzN(t, i6, i2, i, i10)) {
                return false;
            }
            int zzF = zzF(zzD);
            if (zzF != 9 && zzF != 17) {
                if (zzF != 27) {
                    if (zzF == 60 || zzF == 68) {
                        if (zzQ(t2, i7, i6) && !zzB(t2, zzD, zzw(i6))) {
                            return false;
                        }
                    } else if (zzF != 49) {
                        if (zzF == 50 && !((zzeui) zzewd.zzn(t2, (long) (zzD & 1048575))).isEmpty()) {
                            zzeuh zzeuh = (zzeuh) zzx(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzewd.zzn(t2, (long) (zzD & 1048575));
                if (!list.isEmpty()) {
                    zzevf zzw = zzw(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzw.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzN(t, i6, i2, i, i10) && !zzB(t2, zzD, zzw(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zzb(t2);
        throw null;
    }

    public final void zzn(T t, zzesp zzesp) throws IOException {
        if (!this.zzj) {
            zzV(t, zzesp);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzD = zzD(i);
                int i2 = this.zzc[i];
                switch (zzF(zzD)) {
                    case 0:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzf(i2, zzewd.zzl(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zze(i2, zzewd.zzj(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzc(i2, zzewd.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzh(i2, zzewd.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzi(i2, zzewd.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzj(i2, zzewd.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzk(i2, zzewd.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzl(i2, zzewd.zzh(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzX(i2, zzewd.zzn(t, (long) (zzD & 1048575)), zzesp);
                            break;
                        }
                    case 9:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzr(i2, zzewd.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 10:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzn(i2, (zzesf) zzewd.zzn(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzo(i2, zzewd.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzg(i2, zzewd.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzb(i2, zzewd.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzd(i2, zzewd.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzp(i2, zzewd.zzd(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzq(i2, zzewd.zzf(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzO(t, i)) {
                            break;
                        } else {
                            zzesp.zzs(i2, zzewd.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 18:
                        zzevh.zzJ(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 19:
                        zzevh.zzK(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 20:
                        zzevh.zzL(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 21:
                        zzevh.zzM(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 22:
                        zzevh.zzQ(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 23:
                        zzevh.zzO(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 24:
                        zzevh.zzT(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 25:
                        zzevh.zzW(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 26:
                        zzevh.zzX(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp);
                        break;
                    case 27:
                        zzevh.zzZ(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, zzw(i));
                        break;
                    case 28:
                        zzevh.zzY(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp);
                        break;
                    case 29:
                        zzevh.zzR(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 30:
                        zzevh.zzV(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 31:
                        zzevh.zzU(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 32:
                        zzevh.zzP(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 33:
                        zzevh.zzS(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 34:
                        zzevh.zzN(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, false);
                        break;
                    case 35:
                        zzevh.zzJ(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 36:
                        zzevh.zzK(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 37:
                        zzevh.zzL(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 38:
                        zzevh.zzM(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 39:
                        zzevh.zzQ(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 40:
                        zzevh.zzO(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 41:
                        zzevh.zzT(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 42:
                        zzevh.zzW(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 43:
                        zzevh.zzR(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 44:
                        zzevh.zzV(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 45:
                        zzevh.zzU(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 46:
                        zzevh.zzP(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 47:
                        zzevh.zzS(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 48:
                        zzevh.zzN(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, true);
                        break;
                    case 49:
                        zzevh.zzaa(this.zzc[i], (List) zzewd.zzn(t, (long) (zzD & 1048575)), zzesp, zzw(i));
                        break;
                    case 50:
                        zzW(zzesp, i2, zzewd.zzn(t, (long) (zzD & 1048575)), i);
                        break;
                    case 51:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzf(i2, zzH(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zze(i2, zzI(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzc(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzh(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzi(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzj(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzk(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzl(i2, zzL(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzX(i2, zzewd.zzn(t, (long) (zzD & 1048575)), zzesp);
                            break;
                        }
                    case 60:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzr(i2, zzewd.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                    case 61:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzn(i2, (zzesf) zzewd.zzn(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzo(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzg(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzb(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzd(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzp(i2, zzJ(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzq(i2, zzK(t, (long) (zzD & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzQ(t, i2, i)) {
                            break;
                        } else {
                            zzesp.zzs(i2, zzewd.zzn(t, (long) (zzD & 1048575)), zzw(i));
                            break;
                        }
                }
            }
            zzevt<?, ?> zzevt = this.zzo;
            zzevt.zzr(zzevt.zzj(t), zzesp);
        } else {
            this.zzp.zzb(t);
            throw null;
        }
    }

    public final void zzd(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzD = zzD(i);
            long j = (long) (1048575 & zzD);
            int i2 = this.zzc[i];
            switch (zzF(zzD)) {
                case 0:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzm(t, j, zzewd.zzl(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 1:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzk(t, j, zzewd.zzj(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 2:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzg(t, j, zzewd.zzf(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 3:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzg(t, j, zzewd.zzf(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 4:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zze(t, j, zzewd.zzd(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 5:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzg(t, j, zzewd.zzf(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 6:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zze(t, j, zzewd.zzd(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 7:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzi(t, j, zzewd.zzh(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 8:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzo(t, j, zzewd.zzn(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 9:
                    zzp(t, t2, i);
                    break;
                case 10:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzo(t, j, zzewd.zzn(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 11:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zze(t, j, zzewd.zzd(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 12:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zze(t, j, zzewd.zzd(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 13:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zze(t, j, zzewd.zzd(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 14:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzg(t, j, zzewd.zzf(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 15:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zze(t, j, zzewd.zzd(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 16:
                    if (!zzO(t2, i)) {
                        break;
                    } else {
                        zzewd.zzg(t, j, zzewd.zzf(t2, j));
                        zzP(t, i);
                        break;
                    }
                case 17:
                    zzp(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzn.zzc(t, t2, j);
                    break;
                case 50:
                    zzevh.zzI(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzQ(t2, i2, i)) {
                        break;
                    } else {
                        zzewd.zzo(t, j, zzewd.zzn(t2, j));
                        zzR(t, i2, i);
                        break;
                    }
                case 60:
                    zzq(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzQ(t2, i2, i)) {
                        break;
                    } else {
                        zzewd.zzo(t, j, zzewd.zzn(t2, j));
                        zzR(t, i2, i);
                        break;
                    }
                case 68:
                    zzq(t, t2, i);
                    break;
            }
        }
        zzevh.zzF(this.zzo, t, t2);
        if (this.zzh) {
            zzevh.zzE(this.zzp, t, t2);
            throw null;
        }
    }
}
