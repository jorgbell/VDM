package com.google.android.gms.internal.measurement;

import com.flurry.android.Constants;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzgg {
    static int zza(byte[] bArr, int i, zzgf zzgf) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzgf);
        }
        zzgf.zza = b;
        return i2;
    }

    static int zzb(int i, byte[] bArr, int i2, zzgf zzgf) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgf.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzgf.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgf.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgf.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzgf.zza = i11;
                return i12;
            }
        }
    }

    static int zzc(byte[] bArr, int i, zzgf zzgf) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j < 0) {
            int i3 = i2 + 1;
            byte b = bArr[i2];
            long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
            int i4 = 7;
            while (b < 0) {
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                i4 += 7;
                j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
                int i6 = i5;
                b = b2;
                i3 = i6;
            }
            zzgf.zzb = j2;
            return i3;
        }
        zzgf.zzb = j;
        return i2;
    }

    static int zzd(byte[] bArr, int i) {
        return ((bArr[i + 3] & Constants.UNKNOWN) << 24) | (bArr[i] & Constants.UNKNOWN) | ((bArr[i + 1] & Constants.UNKNOWN) << 8) | ((bArr[i + 2] & Constants.UNKNOWN) << 16);
    }

    static long zze(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static int zzf(byte[] bArr, int i, zzgf zzgf) throws zzib {
        int zza = zza(bArr, i, zzgf);
        int i2 = zzgf.zza;
        if (i2 < 0) {
            throw zzib.zzb();
        } else if (i2 == 0) {
            zzgf.zzc = "";
            return zza;
        } else {
            zzgf.zzc = new String(bArr, zza, i2, zzhz.zza);
            return zza + i2;
        }
    }

    static int zzg(byte[] bArr, int i, zzgf zzgf) throws zzib {
        int zza = zza(bArr, i, zzgf);
        int i2 = zzgf.zza;
        if (i2 < 0) {
            throw zzib.zzb();
        } else if (i2 == 0) {
            zzgf.zzc = "";
            return zza;
        } else {
            zzgf.zzc = zzkk.zze(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzgf zzgf) throws zzib {
        int zza = zza(bArr, i, zzgf);
        int i2 = zzgf.zza;
        if (i2 < 0) {
            throw zzib.zzb();
        } else if (i2 > bArr.length - zza) {
            throw zzib.zza();
        } else if (i2 == 0) {
            zzgf.zzc = zzgr.zzb;
            return zza;
        } else {
            zzgf.zzc = zzgr.zzj(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzi(com.google.android.gms.internal.measurement.zzjh r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.zzgf r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzb(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zza()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzh(r1, r2, r3, r4, r5)
            r6.zzi(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.zzib r6 = com.google.android.gms.internal.measurement.zzib.zza()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgg.zzi(com.google.android.gms.internal.measurement.zzjh, byte[], int, int, com.google.android.gms.internal.measurement.zzgf):int");
    }

    static int zzj(zzjh zzjh, byte[] bArr, int i, int i2, int i3, zzgf zzgf) throws IOException {
        zziz zziz = (zziz) zzjh;
        Object zza = zziz.zza();
        int zzg = zziz.zzg(zza, bArr, i, i2, i3, zzgf);
        zziz.zzi(zza);
        zzgf.zzc = zza;
        return zzg;
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzhy<?> zzhy, zzgf zzgf) {
        zzhs zzhs = (zzhs) zzhy;
        int zza = zza(bArr, i2, zzgf);
        zzhs.zzh(zzgf.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgf);
            if (i != zzgf.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzgf);
            zzhs.zzh(zzgf.zza);
        }
        return zza;
    }

    static int zzl(byte[] bArr, int i, zzhy<?> zzhy, zzgf zzgf) throws IOException {
        zzhs zzhs = (zzhs) zzhy;
        int zza = zza(bArr, i, zzgf);
        int i2 = zzgf.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzgf);
            zzhs.zzh(zzgf.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzib.zza();
    }

    static int zzm(zzjh<?> zzjh, int i, byte[] bArr, int i2, int i3, zzhy<?> zzhy, zzgf zzgf) throws IOException {
        int zzi = zzi(zzjh, bArr, i2, i3, zzgf);
        zzhy.add(zzgf.zzc);
        while (zzi < i3) {
            int zza = zza(bArr, zzi, zzgf);
            if (i != zzgf.zza) {
                break;
            }
            zzi = zzi(zzjh, bArr, zza, i3, zzgf);
            zzhy.add(zzgf.zzc);
        }
        return zzi;
    }

    static int zzn(int i, byte[] bArr, int i2, int i3, zzjw zzjw, zzgf zzgf) throws zzib {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzgf);
                zzjw.zzh(i, Long.valueOf(zzgf.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzjw.zzh(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzgf);
                int i5 = zzgf.zza;
                if (i5 < 0) {
                    throw zzib.zzb();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzjw.zzh(i, zzgr.zzb);
                    } else {
                        zzjw.zzh(i, zzgr.zzj(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzib.zza();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzjw zzb = zzjw.zzb();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzgf);
                    int i8 = zzgf.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzn(i8, bArr, zza2, i3, zzb, zzgf);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzib.zze();
                }
                zzjw.zzh(i, zzb);
                return i2;
            } else if (i4 == 5) {
                zzjw.zzh(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzib.zzc();
            }
        } else {
            throw zzib.zzc();
        }
    }
}
