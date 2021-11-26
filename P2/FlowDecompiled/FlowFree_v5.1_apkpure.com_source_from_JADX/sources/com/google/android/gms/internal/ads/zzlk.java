package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzlk implements zzku {
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID zzd = new UUID(72057594037932032L, -9223371306706625679L);
    private boolean zzA;
    private long zzB = -1;
    private long zzC = -1;
    private long zzD = -9223372036854775807L;
    private zzpx zzE;
    private zzpx zzF;
    private boolean zzG;
    private int zzH;
    private long zzI;
    private long zzJ;
    private int zzK;
    private int zzL;
    private int[] zzM;
    private int zzN;
    private int zzO;
    private int zzP;
    private int zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private byte zzV;
    private int zzW;
    private int zzX;
    private int zzY;
    private boolean zzZ;
    private boolean zzaa;
    private zzkv zzab;
    private final zzlg zzac;
    private final zzlm zze;
    private final SparseArray<zzlj> zzf;
    private final boolean zzg;
    private final zzqc zzh;
    private final zzqc zzi;
    private final zzqc zzj;
    private final zzqc zzk;
    private final zzqc zzl;
    private final zzqc zzm;
    private final zzqc zzn;
    private final zzqc zzo;
    private final zzqc zzp;
    private ByteBuffer zzq;
    private long zzr;
    private long zzs = -1;
    private long zzt = -9223372036854775807L;
    private long zzu = -9223372036854775807L;
    private long zzv = -9223372036854775807L;
    private zzlj zzw;
    private boolean zzx;
    private int zzy;
    private long zzz;

    static final int zzl(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static final boolean zzm(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    private final void zzn(zzlj zzlj, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzlj.zza)) {
            byte[] bArr2 = this.zzn.zza;
            long j2 = this.zzJ;
            if (j2 == -9223372036854775807L) {
                bArr = zzc;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzqj.zzd(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (i3 * 1000000))) / 1000))}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzld zzld = zzlj.zzN;
            zzqc zzqc = this.zzn;
            zzld.zzb(zzqc, zzqc.zze());
            this.zzY += this.zzn.zze();
        }
        zzlj.zzN.zzc(j, this.zzP, this.zzY, 0, zzlj.zzg);
        this.zzZ = true;
        zzo();
    }

    private final void zzo() {
        this.zzQ = 0;
        this.zzY = 0;
        this.zzX = 0;
        this.zzR = false;
        this.zzS = false;
        this.zzU = false;
        this.zzW = 0;
        this.zzV = 0;
        this.zzT = false;
        this.zzm.zzc();
    }

    private static int[] zzq(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    private final void zzr(zzkt zzkt, int i) throws IOException, InterruptedException {
        if (this.zzj.zze() < i) {
            if (this.zzj.zzh() < i) {
                zzqc zzqc = this.zzj;
                byte[] bArr = zzqc.zza;
                int length = bArr.length;
                zzqc.zzb(Arrays.copyOf(bArr, Math.max(length + length, i)), this.zzj.zze());
            }
            zzqc zzqc2 = this.zzj;
            zzkt.zzb(zzqc2.zza, zzqc2.zze(), i - this.zzj.zze(), false);
            this.zzj.zzf(i);
        }
    }

    private final void zzs(zzkt zzkt, zzlj zzlj, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzlj.zza)) {
            byte[] bArr = zzb;
            int length = bArr.length;
            int i3 = i + 32;
            if (this.zzn.zzh() < i3) {
                this.zzn.zza = Arrays.copyOf(bArr, i3 + i);
            }
            byte[] bArr2 = this.zzn.zza;
            int length2 = bArr.length;
            zzkt.zzb(bArr2, 32, i, false);
            this.zzn.zzi(0);
            this.zzn.zzf(i3);
            return;
        }
        zzld zzld = zzlj.zzN;
        if (!this.zzR) {
            if (zzlj.zze) {
                this.zzP &= -1073741825;
                int i4 = 128;
                if (!this.zzS) {
                    zzkt.zzb(this.zzj.zza, 0, 1, false);
                    this.zzQ++;
                    byte b = this.zzj.zza[0];
                    if ((b & 128) != 128) {
                        this.zzV = b;
                        this.zzS = true;
                    } else {
                        throw new zziw("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.zzV;
                if ((b2 & 1) == 1) {
                    byte b3 = b2 & 2;
                    this.zzP |= 1073741824;
                    if (!this.zzT) {
                        zzkt.zzb(this.zzo.zza, 0, 8, false);
                        this.zzQ += 8;
                        this.zzT = true;
                        zzqc zzqc = this.zzj;
                        byte[] bArr3 = zzqc.zza;
                        if (b3 != 2) {
                            i4 = 0;
                        }
                        bArr3[0] = (byte) (i4 | 8);
                        zzqc.zzi(0);
                        zzld.zzb(this.zzj, 1);
                        this.zzY++;
                        this.zzo.zzi(0);
                        zzld.zzb(this.zzo, 8);
                        this.zzY += 8;
                    }
                    if (b3 == 2) {
                        if (!this.zzU) {
                            zzkt.zzb(this.zzj.zza, 0, 1, false);
                            this.zzQ++;
                            this.zzj.zzi(0);
                            this.zzW = this.zzj.zzl();
                            this.zzU = true;
                        }
                        int i5 = this.zzW * 4;
                        this.zzj.zza(i5);
                        zzkt.zzb(this.zzj.zza, 0, i5, false);
                        this.zzQ += i5;
                        int i6 = (this.zzW >> 1) + 1;
                        int i7 = (i6 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzq;
                        if (byteBuffer == null || byteBuffer.capacity() < i7) {
                            this.zzq = ByteBuffer.allocate(i7);
                        }
                        this.zzq.position(0);
                        this.zzq.putShort((short) i6);
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            i2 = this.zzW;
                            if (i8 >= i2) {
                                break;
                            }
                            int zzu2 = this.zzj.zzu();
                            if (i8 % 2 == 0) {
                                this.zzq.putShort((short) (zzu2 - i9));
                            } else {
                                this.zzq.putInt(zzu2 - i9);
                            }
                            i8++;
                            i9 = zzu2;
                        }
                        int i10 = (i - this.zzQ) - i9;
                        if ((i2 & 1) == 1) {
                            this.zzq.putInt(i10);
                        } else {
                            this.zzq.putShort((short) i10);
                            this.zzq.putInt(0);
                        }
                        this.zzp.zzb(this.zzq.array(), i7);
                        zzld.zzb(this.zzp, i7);
                        this.zzY += i7;
                    }
                }
            } else {
                byte[] bArr4 = zzlj.zzf;
                if (bArr4 != null) {
                    this.zzm.zzb(bArr4, bArr4.length);
                }
            }
            this.zzR = true;
        }
        int zze2 = i + this.zzm.zze();
        if (!"V_MPEG4/ISO/AVC".equals(zzlj.zza) && !"V_MPEGH/ISO/HEVC".equals(zzlj.zza)) {
            while (true) {
                int i11 = this.zzQ;
                if (i11 >= zze2) {
                    break;
                }
                zzt(zzkt, zzld, zze2 - i11);
            }
        } else {
            byte[] bArr5 = this.zzi.zza;
            bArr5[0] = 0;
            bArr5[1] = 0;
            bArr5[2] = 0;
            int i12 = zzlj.zzO;
            int i13 = 4 - i12;
            while (this.zzQ < zze2) {
                int i14 = this.zzX;
                if (i14 == 0) {
                    int min = Math.min(i12, this.zzm.zzd());
                    zzkt.zzb(bArr5, i13 + min, i12 - min, false);
                    if (min > 0) {
                        this.zzm.zzk(bArr5, i13, min);
                    }
                    this.zzQ += i12;
                    this.zzi.zzi(0);
                    this.zzX = this.zzi.zzu();
                    this.zzh.zzi(0);
                    zzld.zzb(this.zzh, 4);
                    this.zzY += 4;
                } else {
                    this.zzX = i14 - zzt(zzkt, zzld, i14);
                }
            }
        }
        if ("A_VORBIS".equals(zzlj.zza)) {
            this.zzk.zzi(0);
            zzld.zzb(this.zzk, 4);
            this.zzY += 4;
        }
    }

    private final int zzt(zzkt zzkt, zzld zzld, int i) throws IOException, InterruptedException {
        int i2;
        int zzd2 = this.zzm.zzd();
        if (zzd2 > 0) {
            i2 = Math.min(i, zzd2);
            zzld.zzb(this.zzm, i2);
        } else {
            i2 = zzld.zzd(zzkt, i, false);
        }
        this.zzQ += i2;
        this.zzY += i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, long j, long j2) throws zziw {
        if (i == 160) {
            this.zzaa = false;
        } else if (i == 174) {
            this.zzw = new zzlj((zzlh) null);
        } else if (i == 187) {
            this.zzG = false;
        } else if (i == 19899) {
            this.zzy = -1;
            this.zzz = -1;
        } else if (i == 20533) {
            this.zzw.zze = true;
        } else if (i == 21968) {
            this.zzw.zzq = true;
        } else if (i == 408125543) {
            long j3 = this.zzs;
            if (j3 == -1 || j3 == j) {
                this.zzs = j;
                this.zzr = j2;
                return;
            }
            throw new zziw("Multiple Segment elements not supported");
        } else if (i == 475249515) {
            this.zzE = new zzpx(32);
            this.zzF = new zzpx(32);
        } else if (i != 524531317 || this.zzx) {
        } else {
            if (!this.zzg || this.zzB == -1) {
                this.zzab.zzc(new zzla(this.zzv));
                this.zzx = true;
                return;
            }
            this.zzA = true;
        }
    }

    public final void zzd(zzkv zzkv) {
        this.zzab = zzkv;
    }

    public final void zze(long j, long j2) {
        this.zzD = -9223372036854775807L;
        this.zzH = 0;
        this.zzac.zza();
        this.zze.zza();
        zzo();
    }

    public final boolean zzf(zzkt zzkt) throws IOException, InterruptedException {
        return new zzll().zza(zzkt);
    }

    public final int zzg(zzkt zzkt, zzkz zzkz) throws IOException, InterruptedException {
        this.zzZ = false;
        while (!this.zzZ) {
            if (!this.zzac.zzc(zzkt)) {
                return -1;
            }
            long zzh2 = zzkt.zzh();
            if (this.zzA) {
                this.zzC = zzh2;
                zzkz.zza = this.zzB;
                this.zzA = false;
                return 1;
            } else if (this.zzx) {
                long j = this.zzC;
                if (j != -1) {
                    zzkz.zza = j;
                    this.zzC = -1;
                    return 1;
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i, double d) {
        if (i == 181) {
            this.zzw.zzI = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzw.zzw = (float) d;
                    return;
                case 21970:
                    this.zzw.zzx = (float) d;
                    return;
                case 21971:
                    this.zzw.zzy = (float) d;
                    return;
                case 21972:
                    this.zzw.zzz = (float) d;
                    return;
                case 21973:
                    this.zzw.zzA = (float) d;
                    return;
                case 21974:
                    this.zzw.zzB = (float) d;
                    return;
                case 21975:
                    this.zzw.zzC = (float) d;
                    return;
                case 21976:
                    this.zzw.zzD = (float) d;
                    return;
                case 21977:
                    this.zzw.zzE = (float) d;
                    return;
                case 21978:
                    this.zzw.zzF = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzu = (long) d;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(int i, String str) throws zziw {
        if (i == 134) {
            this.zzw.zza = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                String unused = this.zzw.zzP = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(str.length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zziw(sb.toString());
        }
    }

    public zzlk(int i) {
        zzlg zzlg = new zzlg();
        this.zzac = zzlg;
        zzlg.zzb(new zzli(this, (zzlh) null));
        this.zzg = true;
        this.zze = new zzlm();
        this.zzf = new SparseArray<>();
        this.zzj = new zzqc(4);
        this.zzk = new zzqc(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzl = new zzqc(4);
        this.zzh = new zzqc(zzqa.zza);
        this.zzi = new zzqc(4);
        this.zzm = new zzqc();
        this.zzn = new zzqc();
        this.zzo = new zzqc(8);
        this.zzp = new zzqc();
    }

    private final long zzp(long j) throws zziw {
        long j2 = this.zzt;
        if (j2 != -9223372036854775807L) {
            return zzqj.zzj(j, j2, 1000);
        }
        throw new zziw("Can't scale timecode prior to timecodeScale being set.");
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i, long j) throws zziw {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.zzw.zzc = (int) j;
                        return;
                    case 136:
                        zzlj zzlj = this.zzw;
                        if (j == 1) {
                            z = true;
                        }
                        zzlj.zzL = z;
                        return;
                    case 155:
                        this.zzJ = zzp(j);
                        return;
                    case 159:
                        this.zzw.zzG = (int) j;
                        return;
                    case 176:
                        this.zzw.zzj = (int) j;
                        return;
                    case 179:
                        this.zzE.zza(zzp(j));
                        return;
                    case 186:
                        this.zzw.zzk = (int) j;
                        return;
                    case 215:
                        this.zzw.zzb = (int) j;
                        return;
                    case 231:
                        this.zzD = zzp(j);
                        return;
                    case 241:
                        if (!this.zzG) {
                            this.zzF.zza(j);
                            this.zzG = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzaa = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(" not supported");
                            throw new zziw(sb.toString());
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(" not supported");
                            throw new zziw(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new zziw(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new zziw(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new zziw(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.zzz = j + this.zzs;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzw.zzp = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzw.zzp = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzw.zzp = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzw.zzp = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.zzw.zzl = (int) j;
                        return;
                    case 21682:
                        this.zzw.zzn = (int) j;
                        return;
                    case 21690:
                        this.zzw.zzm = (int) j;
                        return;
                    case 21930:
                        zzlj zzlj2 = this.zzw;
                        if (j == 1) {
                            z = true;
                        }
                        zzlj2.zzM = z;
                        return;
                    case 22186:
                        this.zzw.zzJ = j;
                        return;
                    case 22203:
                        this.zzw.zzK = j;
                        return;
                    case 25188:
                        this.zzw.zzH = (int) j;
                        return;
                    case 2352003:
                        this.zzw.zzd = (int) j;
                        return;
                    case 2807729:
                        this.zzt = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.zzw.zzt = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.zzw.zzt = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.zzw.zzs = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.zzw.zzs = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.zzw.zzs = 3;
                                return;
                            case 21947:
                                zzlj zzlj3 = this.zzw;
                                zzlj3.zzq = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    zzlj3.zzr = 1;
                                    return;
                                } else if (i5 == 9) {
                                    zzlj3.zzr = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    zzlj3.zzr = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.zzw.zzu = (int) j;
                                return;
                            case 21949:
                                this.zzw.zzv = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zziw(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(" not supported");
            throw new zziw(sb7.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01eb, code lost:
        throw new com.google.android.gms.internal.ads.zziw("EBML lacing sample size out of range.");
     */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x023a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(int r19, int r20, com.google.android.gms.internal.ads.zzkt r21) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 1
            r7 = 0
            if (r1 == r4) goto L_0x008b
            if (r1 == r5) goto L_0x008b
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0081
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0072
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0053
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x0049
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0030
            com.google.android.gms.internal.ads.zzlj r1 = r0.zzw
            byte[] r4 = new byte[r2]
            r1.zzo = r4
            r3.zzb(r4, r7, r2, r7)
            return
        L_0x0030:
            com.google.android.gms.internal.ads.zziw r2 = new com.google.android.gms.internal.ads.zziw
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 26
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0049:
            com.google.android.gms.internal.ads.zzlj r1 = r0.zzw
            byte[] r4 = new byte[r2]
            r1.zzh = r4
            r3.zzb(r4, r7, r2, r7)
            return
        L_0x0053:
            com.google.android.gms.internal.ads.zzqc r1 = r0.zzl
            byte[] r1 = r1.zza
            java.util.Arrays.fill(r1, r7)
            com.google.android.gms.internal.ads.zzqc r1 = r0.zzl
            byte[] r1 = r1.zza
            int r4 = 4 - r2
            r3.zzb(r1, r4, r2, r7)
            com.google.android.gms.internal.ads.zzqc r1 = r0.zzl
            r1.zzi(r7)
            com.google.android.gms.internal.ads.zzqc r1 = r0.zzl
            long r1 = r1.zzp()
            int r2 = (int) r1
            r0.zzy = r2
            return
        L_0x0072:
            byte[] r1 = new byte[r2]
            r3.zzb(r1, r7, r2, r7)
            com.google.android.gms.internal.ads.zzlj r2 = r0.zzw
            com.google.android.gms.internal.ads.zzlc r3 = new com.google.android.gms.internal.ads.zzlc
            r3.<init>(r6, r1)
            r2.zzg = r3
            return
        L_0x0081:
            com.google.android.gms.internal.ads.zzlj r1 = r0.zzw
            byte[] r4 = new byte[r2]
            r1.zzf = r4
            r3.zzb(r4, r7, r2, r7)
            return
        L_0x008b:
            int r4 = r0.zzH
            r8 = 8
            if (r4 != 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zzlm r4 = r0.zze
            long r9 = r4.zze(r3, r7, r6, r8)
            int r4 = (int) r9
            r0.zzN = r4
            com.google.android.gms.internal.ads.zzlm r4 = r0.zze
            int r4 = r4.zzb()
            r0.zzO = r4
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zzJ = r9
            r0.zzH = r6
            com.google.android.gms.internal.ads.zzqc r4 = r0.zzj
            r4.zzc()
        L_0x00b0:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlj> r4 = r0.zzf
            int r9 = r0.zzN
            java.lang.Object r4 = r4.get(r9)
            com.google.android.gms.internal.ads.zzlj r4 = (com.google.android.gms.internal.ads.zzlj) r4
            if (r4 != 0) goto L_0x00c6
            int r1 = r0.zzO
            int r1 = r2 - r1
            r3.zzd(r1, r7)
            r0.zzH = r7
            return
        L_0x00c6:
            int r9 = r0.zzH
            if (r9 != r6) goto L_0x0255
            r9 = 3
            r0.zzr(r3, r9)
            com.google.android.gms.internal.ads.zzqc r10 = r0.zzj
            byte[] r10 = r10.zza
            r11 = 2
            byte r10 = r10[r11]
            r10 = r10 & 6
            int r10 = r10 >> r6
            r12 = 255(0xff, float:3.57E-43)
            if (r10 != 0) goto L_0x00ef
            r0.zzL = r6
            int[] r9 = r0.zzM
            int[] r9 = zzq(r9, r6)
            r0.zzM = r9
            int r10 = r0.zzO
            int r2 = r2 - r10
            int r2 = r2 + -3
            r9[r7] = r2
            goto L_0x01fd
        L_0x00ef:
            if (r1 != r5) goto L_0x024d
            r13 = 4
            r0.zzr(r3, r13)
            com.google.android.gms.internal.ads.zzqc r14 = r0.zzj
            byte[] r14 = r14.zza
            byte r14 = r14[r9]
            r14 = r14 & r12
            int r14 = r14 + r6
            r0.zzL = r14
            int[] r15 = r0.zzM
            int[] r14 = zzq(r15, r14)
            r0.zzM = r14
            if (r10 != r11) goto L_0x0116
            int r9 = r0.zzO
            int r10 = r0.zzL
            int r2 = r2 - r9
            int r2 = r2 + -4
            int r2 = r2 / r10
            java.util.Arrays.fill(r14, r7, r10, r2)
            goto L_0x01fd
        L_0x0116:
            if (r10 != r6) goto L_0x014b
            r9 = 0
            r10 = 0
        L_0x011a:
            int r14 = r0.zzL
            int r14 = r14 + -1
            if (r9 >= r14) goto L_0x0140
            int[] r14 = r0.zzM
            r14[r9] = r7
        L_0x0124:
            int r13 = r13 + r6
            r0.zzr(r3, r13)
            com.google.android.gms.internal.ads.zzqc r14 = r0.zzj
            byte[] r14 = r14.zza
            int r15 = r13 + -1
            byte r14 = r14[r15]
            r14 = r14 & r12
            int[] r15 = r0.zzM
            r16 = r15[r9]
            int r16 = r16 + r14
            r15[r9] = r16
            if (r14 == r12) goto L_0x0124
            int r10 = r10 + r16
            int r9 = r9 + 1
            goto L_0x011a
        L_0x0140:
            int[] r9 = r0.zzM
            int r15 = r0.zzO
            int r2 = r2 - r15
            int r2 = r2 - r13
            int r2 = r2 - r10
            r9[r14] = r2
            goto L_0x01fd
        L_0x014b:
            if (r10 != r9) goto L_0x0245
            r9 = 0
            r10 = 0
        L_0x014f:
            int r14 = r0.zzL
            int r14 = r14 + -1
            if (r9 >= r14) goto L_0x01f4
            int[] r14 = r0.zzM
            r14[r9] = r7
            int r13 = r13 + 1
            r0.zzr(r3, r13)
            int r14 = r13 + -1
            com.google.android.gms.internal.ads.zzqc r15 = r0.zzj
            byte[] r15 = r15.zza
            byte r15 = r15[r14]
            if (r15 == 0) goto L_0x01ec
            r15 = 0
        L_0x0169:
            if (r15 >= r8) goto L_0x01bc
            int r16 = 7 - r15
            int r16 = r6 << r16
            com.google.android.gms.internal.ads.zzqc r5 = r0.zzj
            byte[] r5 = r5.zza
            byte r5 = r5[r14]
            r5 = r5 & r16
            if (r5 == 0) goto L_0x01b2
            int r13 = r13 + r15
            r0.zzr(r3, r13)
            int r5 = r14 + 1
            com.google.android.gms.internal.ads.zzqc r11 = r0.zzj
            byte[] r11 = r11.zza
            byte r11 = r11[r14]
            r11 = r11 & r12
            r14 = r16 ^ -1
            r11 = r11 & r14
            long r6 = (long) r11
        L_0x018a:
            if (r5 >= r13) goto L_0x01a0
            int r11 = r5 + 1
            long r6 = r6 << r8
            com.google.android.gms.internal.ads.zzqc r14 = r0.zzj
            byte[] r14 = r14.zza
            byte r5 = r14[r5]
            r5 = r5 & r12
            r17 = r13
            long r12 = (long) r5
            long r6 = r6 | r12
            r5 = r11
            r13 = r17
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x018a
        L_0x01a0:
            r17 = r13
            if (r9 <= 0) goto L_0x01af
            r11 = 1
            int r15 = r15 * 7
            int r15 = r15 + 6
            long r11 = r11 << r15
            r13 = -1
            long r11 = r11 + r13
            long r6 = r6 - r11
        L_0x01af:
            r13 = r17
            goto L_0x01be
        L_0x01b2:
            int r15 = r15 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 1
            r7 = 0
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0169
        L_0x01bc:
            r6 = 0
        L_0x01be:
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x01e4
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r5 > 0) goto L_0x01e4
            int r5 = (int) r6
            int[] r6 = r0.zzM
            if (r9 == 0) goto L_0x01d6
            int r7 = r9 + -1
            r7 = r6[r7]
            int r5 = r5 + r7
        L_0x01d6:
            r6[r9] = r5
            int r10 = r10 + r5
            int r9 = r9 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 1
            r7 = 0
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x014f
        L_0x01e4:
            com.google.android.gms.internal.ads.zziw r1 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x01ec:
            com.google.android.gms.internal.ads.zziw r1 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x01f4:
            int[] r5 = r0.zzM
            int r6 = r0.zzO
            int r2 = r2 - r6
            int r2 = r2 - r13
            int r2 = r2 - r10
            r5[r14] = r2
        L_0x01fd:
            com.google.android.gms.internal.ads.zzqc r2 = r0.zzj
            byte[] r2 = r2.zza
            r5 = 0
            byte r6 = r2[r5]
            r5 = 1
            byte r2 = r2[r5]
            long r9 = r0.zzD
            int r5 = r6 << 8
            r6 = 255(0xff, float:3.57E-43)
            r2 = r2 & r6
            r2 = r2 | r5
            long r5 = (long) r2
            long r5 = r0.zzp(r5)
            long r9 = r9 + r5
            r0.zzI = r9
            com.google.android.gms.internal.ads.zzqc r2 = r0.zzj
            byte[] r2 = r2.zza
            r5 = 2
            byte r2 = r2[r5]
            r6 = r2 & 8
            int r7 = r4.zzc
            if (r7 == r5) goto L_0x0234
            r5 = 163(0xa3, float:2.28E-43)
            if (r1 != r5) goto L_0x0232
            r1 = 128(0x80, float:1.794E-43)
            r2 = r2 & r1
            if (r2 != r1) goto L_0x0230
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x0234
        L_0x0230:
            r1 = 163(0xa3, float:2.28E-43)
        L_0x0232:
            r2 = 0
            goto L_0x0235
        L_0x0234:
            r2 = 1
        L_0x0235:
            if (r6 != r8) goto L_0x023a
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x023b
        L_0x023a:
            r5 = 0
        L_0x023b:
            r2 = r2 | r5
            r0.zzP = r2
            r2 = 2
            r0.zzH = r2
            r2 = 0
            r0.zzK = r2
            goto L_0x0255
        L_0x0245:
            com.google.android.gms.internal.ads.zziw r1 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r2 = "Unexpected lacing value: 2"
            r1.<init>(r2)
            throw r1
        L_0x024d:
            com.google.android.gms.internal.ads.zziw r1 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x0255:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x0280
        L_0x0259:
            int r1 = r0.zzK
            int r2 = r0.zzL
            if (r1 >= r2) goto L_0x027c
            int[] r2 = r0.zzM
            r1 = r2[r1]
            r0.zzs(r3, r4, r1)
            long r1 = r0.zzI
            int r5 = r0.zzK
            int r6 = r4.zzd
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.zzn(r4, r1)
            int r1 = r0.zzK
            r2 = 1
            int r1 = r1 + r2
            r0.zzK = r1
            goto L_0x0259
        L_0x027c:
            r1 = 0
            r0.zzH = r1
            return
        L_0x0280:
            r1 = 0
            int[] r2 = r0.zzM
            r1 = r2[r1]
            r0.zzs(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlk.zzk(int, int, com.google.android.gms.internal.ads.zzkt):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i) throws zziw {
        zzlb zzlb;
        zzpx zzpx;
        zzpx zzpx2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzw.zza;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    zzlj zzlj = this.zzw;
                    zzlj.zza(this.zzab, zzlj.zzb);
                    SparseArray<zzlj> sparseArray = this.zzf;
                    zzlj zzlj2 = this.zzw;
                    sparseArray.put(zzlj2.zzb, zzlj2);
                }
                this.zzw = null;
            } else if (i == 19899) {
                int i4 = this.zzy;
                if (i4 != -1) {
                    long j = this.zzz;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.zzB = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zziw("Mandatory element SeekID or SeekPosition not found");
            } else if (i == 25152) {
                zzlj zzlj3 = this.zzw;
                if (!zzlj3.zze) {
                    return;
                }
                if (zzlj3.zzg != null) {
                    zzlj3.zzi = new zzkq(new zzkp(zzie.zzb, "video/webm", this.zzw.zzg.zzb, false));
                    return;
                }
                throw new zziw("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i == 28032) {
                zzlj zzlj4 = this.zzw;
                if (zzlj4.zze && zzlj4.zzf != null) {
                    throw new zziw("Combining encryption and compression is not supported");
                }
            } else if (i == 357149030) {
                if (this.zzt == -9223372036854775807L) {
                    this.zzt = 1000000;
                }
                long j2 = this.zzu;
                if (j2 != -9223372036854775807L) {
                    this.zzv = zzp(j2);
                }
            } else if (i != 374648427) {
                if (i == 475249515 && !this.zzx) {
                    zzkv zzkv = this.zzab;
                    if (this.zzs == -1 || this.zzv == -9223372036854775807L || (zzpx = this.zzE) == null || zzpx.zzc() == 0 || (zzpx2 = this.zzF) == null || zzpx2.zzc() != this.zzE.zzc()) {
                        this.zzE = null;
                        this.zzF = null;
                        zzlb = new zzla(this.zzv);
                    } else {
                        int zzc2 = this.zzE.zzc();
                        int[] iArr = new int[zzc2];
                        long[] jArr = new long[zzc2];
                        long[] jArr2 = new long[zzc2];
                        long[] jArr3 = new long[zzc2];
                        for (int i5 = 0; i5 < zzc2; i5++) {
                            jArr3[i5] = this.zzE.zzb(i5);
                            jArr[i5] = this.zzs + this.zzF.zzb(i5);
                        }
                        while (true) {
                            i2 = zzc2 - 1;
                            if (i3 >= i2) {
                                break;
                            }
                            int i6 = i3 + 1;
                            iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                            jArr2[i3] = jArr3[i6] - jArr3[i3];
                            i3 = i6;
                        }
                        iArr[i2] = (int) ((this.zzs + this.zzr) - jArr[i2]);
                        jArr2[i2] = this.zzv - jArr3[i2];
                        this.zzE = null;
                        this.zzF = null;
                        zzlb = new zzks(iArr, jArr, jArr2, jArr3);
                    }
                    zzkv.zzc(zzlb);
                    this.zzx = true;
                }
            } else if (this.zzf.size() != 0) {
                this.zzab.zzbg();
            } else {
                throw new zziw("No valid tracks were found");
            }
        } else if (this.zzH == 2) {
            if (!this.zzaa) {
                this.zzP |= 1;
            }
            zzn(this.zzf.get(this.zzN), this.zzI);
            this.zzH = 0;
        }
    }
}
