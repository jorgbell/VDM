package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzesi extends zzesj {
    private final InputStream zzc;
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;

    /* synthetic */ zzesi(InputStream inputStream, int i, zzesg zzesg) {
        super((zzesg) null);
        zzetr.zzb(inputStream, "input");
        this.zzc = inputStream;
        this.zzd = new byte[4096];
        this.zze = 0;
        this.zzg = 0;
        this.zzi = 0;
    }

    private final void zzI() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i2 = this.zzi + i;
        int i3 = this.zzj;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzf = i4;
            this.zze = i - i4;
            return;
        }
        this.zzf = 0;
    }

    private final void zzJ(int i) throws IOException {
        if (zzK(i)) {
            return;
        }
        if (i > (Integer.MAX_VALUE - this.zzi) - this.zzg) {
            throw zzett.zzh();
        }
        throw zzett.zzb();
    }

    private final boolean zzK(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zze;
        if (i2 + i > i3) {
            int i4 = this.zzi;
            if (i > (Integer.MAX_VALUE - i4) - i2 || i4 + i2 + i > this.zzj) {
                return false;
            }
            if (i2 > 0) {
                if (i3 > i2) {
                    byte[] bArr = this.zzd;
                    System.arraycopy(bArr, i2, bArr, 0, i3 - i2);
                }
                i4 = this.zzi + i2;
                this.zzi = i4;
                i3 = this.zze - i2;
                this.zze = i3;
                this.zzg = 0;
            }
            int read = this.zzc.read(this.zzd, i3, Math.min(4096 - i3, (Integer.MAX_VALUE - i4) - i3));
            if (read == 0 || read < -1 || read > 4096) {
                String valueOf = String.valueOf(this.zzc.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zze += read;
                zzI();
                if (this.zze >= i) {
                    return true;
                }
                return zzK(i);
            }
        } else {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
    }

    private final byte[] zzL(int i, boolean z) throws IOException {
        byte[] zzM = zzM(i);
        if (zzM != null) {
            return zzM;
        }
        int i2 = this.zzg;
        int i3 = this.zze;
        int i4 = i3 - i2;
        this.zzi += i3;
        this.zzg = 0;
        this.zze = 0;
        List<byte[]> zzN = zzN(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzd, i2, bArr, 0, i4);
        for (byte[] next : zzN) {
            int length = next.length;
            System.arraycopy(next, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzM(int i) throws IOException {
        if (i == 0) {
            return zzetr.zzc;
        }
        if (i >= 0) {
            int i2 = this.zzi;
            int i3 = this.zzg;
            int i4 = i2 + i3 + i;
            if (-2147483647 + i4 <= 0) {
                int i5 = this.zzj;
                if (i4 <= i5) {
                    int i6 = this.zze - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096 && i7 > this.zzc.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.zzd, this.zzg, bArr, 0, i6);
                    this.zzi += this.zze;
                    this.zzg = 0;
                    this.zze = 0;
                    while (i6 < i) {
                        int read = this.zzc.read(bArr, i6, i - i6);
                        if (read != -1) {
                            this.zzi += read;
                            i6 += read;
                        } else {
                            throw zzett.zzb();
                        }
                    }
                    return bArr;
                }
                zzE((i5 - i2) - i3);
                throw zzett.zzb();
            }
            throw zzett.zzh();
        }
        throw zzett.zzc();
    }

    private final List<byte[]> zzN(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzc.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzi += read;
                    i2 += read;
                } else {
                    throw zzett.zzb();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final void zzA(int i) {
        this.zzj = i;
        zzI();
    }

    public final boolean zzB() throws IOException {
        return this.zzg == this.zze && !zzK(1);
    }

    public final int zzC() {
        return this.zzi + this.zzg;
    }

    public final byte zzD() throws IOException {
        if (this.zzg == this.zze) {
            zzJ(1);
        }
        byte[] bArr = this.zzd;
        int i = this.zzg;
        this.zzg = i + 1;
        return bArr[i];
    }

    public final int zza() throws IOException {
        if (zzB()) {
            this.zzh = 0;
            return 0;
        }
        int zzu = zzu();
        this.zzh = zzu;
        if ((zzu >>> 3) != 0) {
            return zzu;
        }
        throw zzett.zze();
    }

    public final void zzb(int i) throws zzett {
        if (this.zzh != i) {
            throw zzett.zzf();
        }
    }

    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    public final long zzf() throws IOException {
        return zzv();
    }

    public final long zzg() throws IOException {
        return zzv();
    }

    public final int zzh() throws IOException {
        return zzu();
    }

    public final long zzi() throws IOException {
        return zzy();
    }

    public final int zzj() throws IOException {
        return zzx();
    }

    public final boolean zzk() throws IOException {
        return zzv() != 0;
    }

    public final String zzl() throws IOException {
        int zzu = zzu();
        if (zzu > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (zzu <= i - i2) {
                String str = new String(this.zzd, i2, zzu, zzetr.zza);
                this.zzg += zzu;
                return str;
            }
        }
        if (zzu == 0) {
            return "";
        }
        if (zzu > this.zze) {
            return new String(zzL(zzu, false), zzetr.zza);
        }
        zzJ(zzu);
        String str2 = new String(this.zzd, this.zzg, zzu, zzetr.zza);
        this.zzg += zzu;
        return str2;
    }

    public final String zzm() throws IOException {
        byte[] bArr;
        int zzu = zzu();
        int i = this.zzg;
        int i2 = this.zze;
        if (zzu <= i2 - i && zzu > 0) {
            bArr = this.zzd;
            this.zzg = i + zzu;
        } else if (zzu == 0) {
            return "";
        } else {
            if (zzu <= i2) {
                zzJ(zzu);
                bArr = this.zzd;
                this.zzg = zzu;
            } else {
                bArr = zzL(zzu, false);
            }
            i = 0;
        }
        return zzewi.zzf(bArr, i, zzu);
    }

    public final zzesf zzn() throws IOException {
        int zzu = zzu();
        int i = this.zze;
        int i2 = this.zzg;
        if (zzu <= i - i2 && zzu > 0) {
            zzesf zzr = zzesf.zzr(this.zzd, i2, zzu);
            this.zzg += zzu;
            return zzr;
        } else if (zzu == 0) {
            return zzesf.zzb;
        } else {
            byte[] zzM = zzM(zzu);
            if (zzM != null) {
                return zzesf.zzs(zzM);
            }
            int i3 = this.zzg;
            int i4 = this.zze;
            int i5 = i4 - i3;
            this.zzi += i4;
            this.zzg = 0;
            this.zze = 0;
            List<byte[]> zzN = zzN(zzu - i5);
            byte[] bArr = new byte[zzu];
            System.arraycopy(this.zzd, i3, bArr, 0, i5);
            for (byte[] next : zzN) {
                int length = next.length;
                System.arraycopy(next, 0, bArr, i5, length);
                i5 += length;
            }
            return zzesf.zzt(bArr);
        }
    }

    public final int zzo() throws IOException {
        return zzu();
    }

    public final int zzp() throws IOException {
        return zzu();
    }

    public final int zzq() throws IOException {
        return zzx();
    }

    public final long zzr() throws IOException {
        return zzy();
    }

    public final int zzs() throws IOException {
        return zzesj.zzG(zzu());
    }

    public final long zzt() throws IOException {
        return zzesj.zzH(zzv());
    }

    /* access modifiers changed from: package-private */
    public final long zzw() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzD = zzD();
            j |= ((long) (zzD & Byte.MAX_VALUE)) << i;
            if ((zzD & 128) == 0) {
                return j;
            }
        }
        throw zzett.zzd();
    }

    public final int zzx() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 4) {
            zzJ(4);
            i = this.zzg;
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 4;
        return ((bArr[i + 3] & Constants.UNKNOWN) << 24) | (bArr[i] & Constants.UNKNOWN) | ((bArr[i + 1] & Constants.UNKNOWN) << 8) | ((bArr[i + 2] & Constants.UNKNOWN) << 16);
    }

    public final long zzy() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 8) {
            zzJ(8);
            i = this.zzg;
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int zzz(int i) throws zzett {
        if (i >= 0) {
            int i2 = i + this.zzi + this.zzg;
            int i3 = this.zzj;
            if (i2 <= i3) {
                this.zzj = i2;
                zzI();
                return i3;
            }
            throw zzett.zzb();
        }
        throw zzett.zzc();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        throw new java.lang.IllegalStateException(r5.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzE(int r9) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.zze
            int r1 = r8.zzg
            int r0 = r0 - r1
            if (r9 > r0) goto L_0x000e
            if (r9 >= 0) goto L_0x000a
            goto L_0x000e
        L_0x000a:
            int r1 = r1 + r9
            r8.zzg = r1
            return
        L_0x000e:
            if (r9 < 0) goto L_0x00ab
            int r2 = r8.zzi
            int r3 = r2 + r1
            int r4 = r8.zzj
            int r5 = r3 + r9
            if (r5 > r4) goto L_0x00a1
            r8.zzi = r3
            r1 = 0
            r8.zze = r1
            r8.zzg = r1
        L_0x0021:
            if (r0 >= r9) goto L_0x007b
            int r1 = r9 - r0
            java.io.InputStream r2 = r8.zzc     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            long r1 = r2.skip(r3)     // Catch:{ all -> 0x0071 }
            r5 = 0
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x003e
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x003e
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x003b
            goto L_0x007b
        L_0x003b:
            int r2 = (int) r1     // Catch:{ all -> 0x0071 }
            int r0 = r0 + r2
            goto L_0x0021
        L_0x003e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0071 }
            java.io.InputStream r3 = r8.zzc     // Catch:{ all -> 0x0071 }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0071 }
            int r4 = r4.length()     // Catch:{ all -> 0x0071 }
            int r4 = r4 + 92
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r5.<init>(r4)     // Catch:{ all -> 0x0071 }
            r5.append(r3)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = "#skip returned invalid result: "
            r5.append(r3)     // Catch:{ all -> 0x0071 }
            r5.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "\nThe InputStream implementation is buggy."
            r5.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0071 }
            r9.<init>(r1)     // Catch:{ all -> 0x0071 }
            throw r9     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r9 = move-exception
            int r1 = r8.zzi
            int r1 = r1 + r0
            r8.zzi = r1
            r8.zzI()
            throw r9
        L_0x007b:
            int r1 = r8.zzi
            int r1 = r1 + r0
            r8.zzi = r1
            r8.zzI()
            if (r0 >= r9) goto L_0x00a0
            int r0 = r8.zze
            int r1 = r8.zzg
            int r1 = r0 - r1
            r8.zzg = r0
            r0 = 1
            r8.zzJ(r0)
        L_0x0091:
            int r2 = r9 - r1
            int r3 = r8.zze
            if (r2 <= r3) goto L_0x009e
            int r1 = r1 + r3
            r8.zzg = r3
            r8.zzJ(r0)
            goto L_0x0091
        L_0x009e:
            r8.zzg = r2
        L_0x00a0:
            return
        L_0x00a1:
            int r4 = r4 - r2
            int r4 = r4 - r1
            r8.zzE(r4)
            com.google.android.gms.internal.ads.zzett r9 = com.google.android.gms.internal.ads.zzett.zzb()
            throw r9
        L_0x00ab:
            com.google.android.gms.internal.ads.zzett r9 = com.google.android.gms.internal.ads.zzett.zzc()
            goto L_0x00b1
        L_0x00b0:
            throw r9
        L_0x00b1:
            goto L_0x00b0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzesi.zzE(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] >= 0) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzu() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzg
            int r1 = r5.zze
            if (r1 != r0) goto L_0x0007
            goto L_0x006c
        L_0x0007:
            byte[] r2 = r5.zzd
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzg = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0069
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x0069
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0069
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006c
        L_0x0069:
            r5.zzg = r1
            return r0
        L_0x006c:
            long r0 = r5.zzw()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzesi.zzu():int");
    }

    public final boolean zzc(int i) throws IOException {
        int zza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zze - this.zzg >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzg;
                    this.zzg = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzett.zzd();
            }
            while (i3 < 10) {
                if (zzD() < 0) {
                    i3++;
                }
            }
            throw zzett.zzd();
            return true;
        } else if (i2 == 1) {
            zzE(8);
            return true;
        } else if (i2 == 2) {
            zzE(zzu());
            return true;
        } else if (i2 == 3) {
            do {
                zza = zza();
                if (zza == 0 || !zzc(zza)) {
                    zzb(((i >>> 3) << 3) | 4);
                }
                zza = zza();
                break;
            } while (!zzc(zza));
            zzb(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzE(4);
                return true;
            }
            throw zzett.zzg();
        }
    }

    public final long zzv() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        byte b;
        int i = this.zzg;
        int i2 = this.zze;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzg = i3;
                return (long) b2;
            } else if (i2 - i3 >= 9) {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ Byte.MIN_VALUE;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << 14);
                    if (b4 >= 0) {
                        j2 = (long) (b4 ^ 16256);
                    } else {
                        i4 = i5 + 1;
                        byte b5 = b4 ^ (bArr[i5] << 21);
                        if (b5 < 0) {
                            b = b5 ^ -2080896;
                        } else {
                            i5 = i4 + 1;
                            long j5 = (((long) bArr[i4]) << 28) ^ ((long) b5);
                            if (j5 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i6 = i5 + 1;
                                long j6 = j5 ^ (((long) bArr[i5]) << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i5 = i6 + 1;
                                    j5 = j6 ^ (((long) bArr[i6]) << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i5 + 1;
                                        j6 = j5 ^ (((long) bArr[i5]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i5 = i6 + 1;
                                            j2 = (j6 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                i6 = i5 + 1;
                                                if (((long) bArr[i5]) >= 0) {
                                                    j = j2;
                                                    i4 = i6;
                                                    this.zzg = i4;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j3 ^ j6;
                                i4 = i6;
                                this.zzg = i4;
                                return j;
                            }
                            j2 = j5 ^ j4;
                        }
                    }
                    i4 = i5;
                    j = j2;
                    this.zzg = i4;
                    return j;
                }
                j = (long) b;
                this.zzg = i4;
                return j;
            }
        }
        return zzw();
    }
}
