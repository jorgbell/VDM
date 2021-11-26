package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzir implements Handler.Callback, zznt, zzoy, zznv {
    private zzip zzA;
    private long zzB;
    private zzin zzC;
    private zzin zzD;
    private zzin zzE;
    private zzje zzF;
    private boolean zzG;
    private volatile int zzH;
    private volatile int zzI;
    private final zzbel zzJ;
    private final zziy[] zza;
    private final zziz[] zzb;
    private final zzoz zzc;
    private final zzqf zzd;
    private final Handler zze;
    private final HandlerThread zzf;
    private final Handler zzg;
    private final zzij zzh;
    private final zzjd zzi;
    private final zzjc zzj;
    private zzio zzk;
    private zzix zzl;
    private zziy zzm;
    private zzpy zzn;
    private zznw zzo;
    private zziy[] zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private int zzv = 0;
    private int zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    public zzir(zziy[] zziyArr, zzoz zzoz, zzbel zzbel, boolean z, int i, Handler handler, zzio zzio, zzij zzij, byte[] bArr) {
        this.zza = zziyArr;
        this.zzc = zzoz;
        this.zzJ = zzbel;
        this.zzr = z;
        this.zzg = handler;
        this.zzu = 1;
        this.zzk = zzio;
        this.zzh = zzij;
        this.zzb = new zziz[2];
        for (int i2 = 0; i2 < 2; i2++) {
            zziyArr[i2].zzc(i2);
            this.zzb[i2] = zziyArr[i2].zzb();
        }
        this.zzd = new zzqf();
        this.zzp = new zziy[0];
        this.zzi = new zzjd();
        this.zzj = new zzjc();
        zzoz.zzf(this);
        this.zzl = zzix.zza;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzf = handlerThread;
        handlerThread.start();
        this.zze = new Handler(handlerThread.getLooper(), this);
    }

    private final void zzA(Object obj, int i) {
        this.zzk = new zzio(0, 0);
        zzB(obj, i);
        this.zzk = new zzio(0, -9223372036854775807L);
        zzo(4);
        zzx(false);
    }

    private final void zzB(Object obj, int i) {
        this.zzg.obtainMessage(6, new zziq(this.zzF, obj, this.zzk, i)).sendToTarget();
    }

    private final int zzC(int i, zzje zzje, zzje zzje2) {
        int zzc2 = zzje.zzc();
        int i2 = -1;
        for (int i3 = 0; i3 < zzc2 && i2 == -1; i3++) {
            i = zzje.zzh(i, this.zzj, this.zzi, this.zzv);
            i2 = zzje2.zze(zzje.zzd(i, this.zzj, true).zzb);
        }
        return i2;
    }

    private final boolean zzD(int i) {
        this.zzF.zzd(i, this.zzj, false);
        this.zzF.zzg(0, this.zzi, false);
        if (this.zzF.zzh(i, this.zzj, this.zzi, this.zzv) == -1) {
            return true;
        }
        return false;
    }

    private final Pair<Integer, Long> zzE(zzip zzip) {
        zzje zzje = zzip.zza;
        if (zzje.zzf()) {
            zzje = this.zzF;
        }
        try {
            int i = zzip.zzb;
            Pair<Integer, Long> zzG2 = zzG(zzje, 0, zzip.zzc);
            zzje zzje2 = this.zzF;
            if (zzje2 == zzje) {
                return zzG2;
            }
            if (zzje2.zze(zzje.zzd(((Integer) zzG2.first).intValue(), this.zzj, true).zzb) != -1) {
                return Pair.create(0, (Long) zzG2.second);
            }
            if (zzC(((Integer) zzG2.first).intValue(), zzje, this.zzF) == -1) {
                return null;
            }
            this.zzF.zzd(0, this.zzj, false);
            return zzF(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            zzje zzje3 = this.zzF;
            int i2 = zzip.zzb;
            throw new zziv(zzje3, 0, zzip.zzc);
        }
    }

    private final Pair<Integer, Long> zzF(int i, long j) {
        return zzG(this.zzF, 0, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzG(zzje zzje, int i, long j) {
        return zzH(zzje, 0, j, 0);
    }

    private final Pair<Integer, Long> zzH(zzje zzje, int i, long j, long j2) {
        zzpu.zzc(0, 0, zzje.zza());
        zzje.zzb(0, this.zzi, false, j2);
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j3 = zzje.zzd(0, this.zzj, false).zzc;
        if (j3 != -9223372036854775807L) {
            int i2 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j));
    }

    private final void zzI() {
        long j;
        zzin zzin = this.zzC;
        if (!zzin.zzj) {
            j = 0;
        } else {
            j = zzin.zza.zza();
        }
        if (j == Long.MIN_VALUE) {
            zzp(false);
            return;
        }
        zzin zzin2 = this.zzC;
        long j2 = this.zzB - (zzin2.zzf - zzin2.zzh);
        boolean zzf2 = this.zzJ.zzf(j - j2);
        zzp(zzf2);
        if (zzf2) {
            this.zzC.zza.zzb(j2);
        }
    }

    private final void zzJ(zzin zzin) throws zzif {
        if (this.zzE != zzin) {
            boolean[] zArr = new boolean[2];
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                zziy zziy = this.zza[i2];
                zArr[i2] = zziy.zze() != 0;
                zzop zza2 = zzin.zzm.zzb.zza(i2);
                if (zza2 != null) {
                    i++;
                }
                if (zArr[i2] && (zza2 == null || (zziy.zzl() && zziy.zzi() == this.zzE.zzd[i2]))) {
                    if (zziy == this.zzm) {
                        this.zzd.zzd(this.zzn);
                        this.zzn = null;
                        this.zzm = null;
                    }
                    zzL(zziy);
                    zziy.zzp();
                }
            }
            this.zzE = zzin;
            this.zzg.obtainMessage(3, zzin.zzm).sendToTarget();
            zzK(zArr, i);
        }
    }

    private final void zzK(boolean[] zArr, int i) throws zzif {
        int i2;
        int i3;
        this.zzp = new zziy[i];
        int i4 = 0;
        int i5 = 0;
        while (i4 < 2) {
            zziy zziy = this.zza[i4];
            zzop zza2 = this.zzE.zzm.zzb.zza(i4);
            if (zza2 != null) {
                int i6 = i5 + 1;
                this.zzp[i5] = zziy;
                if (zziy.zze() == 0) {
                    zzja zzja = this.zzE.zzm.zzd[i4];
                    boolean z = this.zzr && this.zzu == 3;
                    boolean z2 = !zArr[i4] && z;
                    int zzb2 = zza2.zzb();
                    zzit[] zzitArr = new zzit[zzb2];
                    for (int i7 = 0; i7 < zzb2; i7++) {
                        zzitArr[i7] = zza2.zzc(i7);
                    }
                    zzin zzin = this.zzE;
                    i3 = i6;
                    i2 = i4;
                    zziy.zzf(zzja, zzitArr, zzin.zzd[i4], this.zzB, z2, zzin.zzf - zzin.zzh);
                    zzpy zzd2 = zziy.zzd();
                    if (zzd2 != null) {
                        if (this.zzn == null) {
                            this.zzn = zzd2;
                            this.zzm = zziy;
                            zzd2.zzO(this.zzl);
                        } else {
                            throw zzif.zzc(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zziy.zzg();
                    }
                } else {
                    i2 = i4;
                    i3 = i6;
                }
                i5 = i3;
            } else {
                i2 = i4;
            }
            i4 = i2 + 1;
        }
    }

    private static final void zzL(zziy zziy) throws zzif {
        if (zziy.zze() == 2) {
            zziy.zzo();
        }
    }

    private static final void zzM(zzin zzin) {
        while (zzin != null) {
            zzin.zze();
            zzin = zzin.zzl;
        }
    }

    private final void zzo(int i) {
        if (this.zzu != i) {
            this.zzu = i;
            this.zzg.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzp(boolean z) {
        if (this.zzt != z) {
            this.zzt = z;
            this.zzg.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzq() throws zzif {
        this.zzs = false;
        this.zzd.zza();
        for (zziy zzg2 : this.zzp) {
            zzg2.zzg();
        }
    }

    private final void zzr() throws zzif {
        this.zzd.zzb();
        for (zziy zzL : this.zzp) {
            zzL(zzL);
        }
    }

    private final void zzs() throws zzif {
        long j;
        zzin zzin = this.zzE;
        if (zzin != null) {
            long zzi2 = zzin.zza.zzi();
            if (zzi2 != -9223372036854775807L) {
                zzv(zzi2);
            } else {
                zziy zziy = this.zzm;
                if (zziy == null || zziy.zzF()) {
                    this.zzB = this.zzd.zzN();
                } else {
                    long zzN = this.zzn.zzN();
                    this.zzB = zzN;
                    this.zzd.zzc(zzN);
                }
                zzin zzin2 = this.zzE;
                zzi2 = this.zzB - (zzin2.zzf - zzin2.zzh);
            }
            this.zzk.zzc = zzi2;
            this.zzy = SystemClock.elapsedRealtime() * 1000;
            if (this.zzp.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzE.zza.zzj();
            }
            zzio zzio = this.zzk;
            if (j == Long.MIN_VALUE) {
                j = this.zzF.zzd(this.zzE.zzg, this.zzj, false).zzc;
            }
            zzio.zzd = j;
        }
    }

    private final void zzt(long j, long j2) {
        this.zze.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.zze.sendEmptyMessage(2);
        } else {
            this.zze.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long zzu(int i, long j) throws zzif {
        zzin zzin;
        zzr();
        this.zzs = false;
        zzo(2);
        zzin zzin2 = this.zzE;
        if (zzin2 == null) {
            zzin zzin3 = this.zzC;
            if (zzin3 != null) {
                zzin3.zze();
            }
            zzin = null;
        } else {
            zzin = null;
            while (zzin2 != null) {
                if (zzin2.zzg != i || !zzin2.zzj) {
                    zzin2.zze();
                } else {
                    zzin = zzin2;
                }
                zzin2 = zzin2.zzl;
            }
        }
        zzin zzin4 = this.zzE;
        if (!(zzin4 == zzin && zzin4 == this.zzD)) {
            for (zziy zzp2 : this.zzp) {
                zzp2.zzp();
            }
            this.zzp = new zziy[0];
            this.zzn = null;
            this.zzm = null;
            this.zzE = null;
        }
        if (zzin != null) {
            zzin.zzl = null;
            this.zzC = zzin;
            this.zzD = zzin;
            zzJ(zzin);
            zzin zzin5 = this.zzE;
            if (zzin5.zzk) {
                j = zzin5.zza.zzk(j);
            }
            zzv(j);
            zzI();
        } else {
            this.zzC = null;
            this.zzD = null;
            this.zzE = null;
            zzv(j);
        }
        this.zze.sendEmptyMessage(2);
        return j;
    }

    private final void zzw() {
        zzx(true);
        this.zzJ.zzc();
        zzo(1);
    }

    private final void zzx(boolean z) {
        this.zze.removeMessages(2);
        this.zzs = false;
        this.zzd.zzb();
        this.zzn = null;
        this.zzm = null;
        this.zzB = 60000000;
        for (zziy zziy : this.zzp) {
            try {
                zzL(zziy);
                zziy.zzp();
            } catch (zzif | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzp = new zziy[0];
        zzin zzin = this.zzE;
        if (zzin == null) {
            zzin = this.zzC;
        }
        zzM(zzin);
        this.zzC = null;
        this.zzD = null;
        this.zzE = null;
        zzp(false);
        if (z) {
            zznw zznw = this.zzo;
            if (zznw != null) {
                zznw.zzd();
                this.zzo = null;
            }
            this.zzF = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r6 = r5.zzE.zzl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzy(long r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzio r2 = r5.zzk
            long r2 = r2.zzc
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzin r6 = r5.zzE
            com.google.android.gms.internal.ads.zzin r6 = r6.zzl
            if (r6 == 0) goto L_0x0020
            boolean r6 = r6.zzj
            if (r6 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            return r0
        L_0x001f:
            r0 = 1
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzir.zzy(long):boolean");
    }

    private final void zzz() throws IOException {
        zzin zzin = this.zzC;
        if (zzin != null && !zzin.zzj) {
            zzin zzin2 = this.zzD;
            if (zzin2 == null || zzin2.zzl == zzin) {
                zziy[] zziyArr = this.zzp;
                int length = zziyArr.length;
                int i = 0;
                while (i < length) {
                    if (zziyArr[i].zzj()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzC.zza.zzf();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:432:0x0799, code lost:
        if (zzy(r1) != false) goto L_0x079b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x087f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:495:0x0880, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r8.zzg.obtainMessage(8, com.google.android.gms.internal.ads.zzif.zzc(r1)).sendToTarget();
        zzw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:496:0x089b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:497:0x089c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:498:0x089d, code lost:
        r1 = true;
        r3 = 8;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:501:0x08b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:502:0x08ba, code lost:
        r1 = true;
        r3 = 8;
        r2 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0268 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x026c A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0271 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04ea A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x04f1 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0508 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x050b A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0546 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0558 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0572 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }, LOOP:8: B:317:0x0572->B:321:0x0582, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x06c8 A[Catch:{ all -> 0x0416, all -> 0x0364, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x087f A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r34) {
        /*
            r33 = this;
            r8 = r33
            r1 = r34
            r10 = 1
            int r2 = r1.what     // Catch:{ zzif -> 0x08b9, IOException -> 0x089c, RuntimeException -> 0x087f }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x083e;
                case 1: goto L_0x080f;
                case 2: goto L_0x0429;
                case 3: goto L_0x038a;
                case 4: goto L_0x036c;
                case 5: goto L_0x0368;
                case 6: goto L_0x0351;
                case 7: goto L_0x01f6;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b6;
                case 10: goto L_0x00da;
                case 11: goto L_0x009c;
                case 12: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r1 = 0
            return r1
        L_0x001a:
            int r1 = r1.arg1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzv = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0024:
            if (r2 != 0) goto L_0x0028
            goto L_0x009b
        L_0x0028:
            com.google.android.gms.internal.ads.zzin r3 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzin r4 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != r4) goto L_0x0035
            r4 = 1
            goto L_0x0036
        L_0x0035:
            r4 = 0
        L_0x0036:
            com.google.android.gms.internal.ads.zzje r11 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r12 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r13 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjd r14 = r8.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r11 = r11.zzh(r12, r13, r14, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0042:
            com.google.android.gms.internal.ads.zzin r12 = r2.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r12 == 0) goto L_0x0068
            if (r11 == r5) goto L_0x0068
            int r13 = r12.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r13 != r11) goto L_0x0068
            com.google.android.gms.internal.ads.zzin r2 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r12 != r2) goto L_0x0052
            r2 = 1
            goto L_0x0053
        L_0x0052:
            r2 = 0
        L_0x0053:
            r3 = r3 | r2
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r12 != r2) goto L_0x005a
            r2 = 1
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            r4 = r4 | r2
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r11 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjd r14 = r8.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r11 = r2.zzh(r13, r11, r14, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = r12
            goto L_0x0042
        L_0x0068:
            if (r12 == 0) goto L_0x006f
            zzM(r12)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzl = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x006f:
            int r5 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r5 = r8.zzD(r5)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzi = r5     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r4 != 0) goto L_0x007b
            r8.zzC = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x007b:
            if (r3 != 0) goto L_0x0092
            com.google.android.gms.internal.ads.zzin r2 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x0092
            int r2 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r3 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r3.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r8.zzu(r2, r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r5 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r5.<init>(r2, r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r5     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0092:
            int r2 = r8.zzu     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != r15) goto L_0x009b
            if (r1 == 0) goto L_0x009b
            r8.zzo(r7)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x009b:
            return r10
        L_0x009c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzii[] r1 = (com.google.android.gms.internal.ads.zzii[]) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r1.length     // Catch:{ all -> 0x00c9 }
        L_0x00a1:
            if (r9 >= r2) goto L_0x00b1
            r3 = r1[r9]     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzih r4 = r3.zza     // Catch:{ all -> 0x00c9 }
            int r5 = r3.zzb     // Catch:{ all -> 0x00c9 }
            java.lang.Object r3 = r3.zzc     // Catch:{ all -> 0x00c9 }
            r4.zzr(r5, r3)     // Catch:{ all -> 0x00c9 }
            int r9 = r9 + 1
            goto L_0x00a1
        L_0x00b1:
            com.google.android.gms.internal.ads.zznw r1 = r8.zzo     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00ba
            android.os.Handler r1 = r8.zze     // Catch:{ all -> 0x00c9 }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00c9 }
        L_0x00ba:
            monitor-enter(r33)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = r8.zzx     // Catch:{ all -> 0x00c5 }
            int r1 = r1 + r10
            r8.zzx = r1     // Catch:{ all -> 0x00c5 }
            r33.notifyAll()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            return r10
        L_0x00c5:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            throw r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x00c9:
            r0 = move-exception
            r1 = r0
            monitor-enter(r33)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r8.zzx     // Catch:{ all -> 0x00d6 }
            int r2 = r2 + r10
            r8.zzx = r2     // Catch:{ all -> 0x00d6 }
            r33.notifyAll()     // Catch:{ all -> 0x00d6 }
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x00d6:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x00da:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x01b5
            r2 = 1
        L_0x00df:
            if (r1 == 0) goto L_0x01b5
            boolean r3 = r1.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 != 0) goto L_0x00e7
            goto L_0x01b5
        L_0x00e7:
            boolean r3 = r1.zzb()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x01a9
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzin r2 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r3 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == r3) goto L_0x00f7
            r2 = 1
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            com.google.android.gms.internal.ads.zzin r3 = r3.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            zzM(r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r3 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zzl = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzC = r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzD = r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean[] r4 = new boolean[r7]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r5 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r11 = r5.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r2 = r3.zzd(r11, r2, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r5 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r11 = r5.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzio r5 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r5.zzc = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzv(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x011e:
            boolean[] r2 = new boolean[r7]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3 = 0
            r5 = 0
        L_0x0122:
            if (r3 >= r7) goto L_0x0169
            com.google.android.gms.internal.ads.zziy[] r11 = r8.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r11 = r11[r3]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r12 = r11.zze()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r12 == 0) goto L_0x0130
            r12 = 1
            goto L_0x0131
        L_0x0130:
            r12 = 0
        L_0x0131:
            r2[r3] = r12     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r13 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzog[] r13 = r13.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r13 = r13[r3]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r13 == 0) goto L_0x013d
            int r5 = r5 + 1
        L_0x013d:
            if (r12 == 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzog r12 = r11.zzi()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r13 == r12) goto L_0x015d
            com.google.android.gms.internal.ads.zziy r12 = r8.zzm     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r11 != r12) goto L_0x0156
            if (r13 != 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzqf r12 = r8.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzpy r13 = r8.zzn     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r12.zzd(r13)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0152:
            r8.zzn = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzm = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0156:
            zzL(r11)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r11.zzp()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0166
        L_0x015d:
            boolean r12 = r4[r3]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r12 == 0) goto L_0x0166
            long r12 = r8.zzB     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r11.zzn(r12)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0166:
            int r3 = r3 + 1
            goto L_0x0122
        L_0x0169:
            android.os.Handler r3 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzpa r1 = r1.zzm     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendToTarget()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzK(r2, r5)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x019d
        L_0x0178:
            r8.zzC = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r1.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x017c:
            if (r1 == 0) goto L_0x0184
            r1.zze()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r1.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x017c
        L_0x0184:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.zzl = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r2 = r1.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x019d
            long r2 = r1.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r4 = r8.zzB     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r11 = r1.zzf     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r11 = r11 - r2
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r2, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r3 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zzc(r1, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x019d:
            r33.zzI()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r33.zzs()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r1 = r8.zze     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendEmptyMessage(r7)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x01b5
        L_0x01a9:
            com.google.android.gms.internal.ads.zzin r3 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 != r3) goto L_0x01af
            r3 = 0
            goto L_0x01b0
        L_0x01af:
            r3 = 1
        L_0x01b0:
            r2 = r2 & r3
            com.google.android.gms.internal.ads.zzin r1 = r1.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x00df
        L_0x01b5:
            return r10
        L_0x01b6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zznu r1 = (com.google.android.gms.internal.ads.zznu) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x01c5
            com.google.android.gms.internal.ads.zznu r2 = r2.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != r1) goto L_0x01c5
            r33.zzI()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x01c5:
            return r10
        L_0x01c6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zznu r1 = (com.google.android.gms.internal.ads.zznu) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x01f5
            com.google.android.gms.internal.ads.zznu r3 = r2.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == r1) goto L_0x01d3
            goto L_0x01f5
        L_0x01d3:
            r2.zzj = r10     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzb()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r2.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r2.zzc(r3, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzh = r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 != 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzin r1 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzD = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r1 = r1.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzv(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzJ(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x01f2:
            r33.zzI()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x01f5:
            return r10
        L_0x01f6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r3 = r1.first     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r3 = (com.google.android.gms.internal.ads.zzje) r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzF = r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r1 = r1.second     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x0263
            int r4 = r8.zzz     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r4 <= 0) goto L_0x0235
            com.google.android.gms.internal.ads.zzip r3 = r8.zzA     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.util.Pair r3 = r8.zzE(r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r4 = r8.zzz     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzz = r9     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzA = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 != 0) goto L_0x021d
            r8.zzA(r1, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0350
        L_0x021d:
            com.google.android.gms.internal.ads.zzio r7 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r11 = r3.first     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r11 = r11.intValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r3 = r3.second     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r3.longValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r7.<init>(r11, r14)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r7     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0264
        L_0x0235:
            com.google.android.gms.internal.ads.zzio r4 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r4.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r4 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x0263
            boolean r3 = r3.zzf()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x0248
            r8.zzA(r1, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0350
        L_0x0248:
            android.util.Pair r3 = r8.zzF(r9, r12)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r4 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r7 = r3.first     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r7 = r7.intValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r3 = r3.second     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r3.longValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r4.<init>(r7, r14)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r4     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0263:
            r4 = 0
        L_0x0264:
            com.google.android.gms.internal.ads.zzin r3 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 != 0) goto L_0x026a
            com.google.android.gms.internal.ads.zzin r3 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x026a:
            if (r3 != 0) goto L_0x0271
            r8.zzB(r1, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0350
        L_0x0271:
            com.google.android.gms.internal.ads.zzje r7 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r11 = r3.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r7 = r7.zze(r11)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r7 != r5) goto L_0x02d4
            int r6 = r3.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r7 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r8.zzC(r6, r2, r7)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != r5) goto L_0x028a
            r8.zzA(r1, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0350
        L_0x028a:
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r6 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzd(r9, r6, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.util.Pair r2 = r8.zzF(r9, r12)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r6 = r2.first     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r6 = r6.intValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r2 = r2.second     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r11 = r2.longValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r7 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzd(r6, r7, r10)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r2 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r2 = r2.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zzg = r5     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x02b2:
            com.google.android.gms.internal.ads.zzin r3 = r3.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x02c4
            java.lang.Object r7 = r3.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r7 = r7.equals(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r10 == r7) goto L_0x02c0
            r7 = -1
            goto L_0x02c1
        L_0x02c0:
            r7 = r6
        L_0x02c1:
            r3.zzg = r7     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x02b2
        L_0x02c4:
            long r2 = r8.zzu(r6, r11)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r5 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r5.<init>(r6, r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r5     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzB(r1, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0350
        L_0x02d4:
            boolean r2 = r8.zzD(r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zzg = r9     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zzi = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 != r2) goto L_0x02e2
            r2 = 1
            goto L_0x02e3
        L_0x02e2:
            r2 = 0
        L_0x02e3:
            com.google.android.gms.internal.ads.zzio r11 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r12 = r11.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r12 == 0) goto L_0x02fa
            com.google.android.gms.internal.ads.zzio r12 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r11.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r12.<init>(r9, r13)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r11.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r12.zzc = r13     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r11.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r12.zzd = r13     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r12     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x02fa:
            com.google.android.gms.internal.ads.zzin r11 = r3.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r11 == 0) goto L_0x034d
            com.google.android.gms.internal.ads.zzje r12 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r13 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjd r14 = r8.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r15 = r8.zzv     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r7 = r12.zzh(r7, r13, r14, r15)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r7 == r5) goto L_0x0330
            java.lang.Object r12 = r11.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r13 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r14 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r13 = r13.zzd(r7, r14, r10)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r13 = r13.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r12 = r12.equals(r13)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r12 == 0) goto L_0x0330
            boolean r3 = r8.zzD(r7)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r11.zzg = r7     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r11.zzi = r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r3 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r11 != r3) goto L_0x032c
            r3 = 1
            goto L_0x032d
        L_0x032c:
            r3 = 0
        L_0x032d:
            r2 = r2 | r3
            r3 = r11
            goto L_0x02fa
        L_0x0330:
            if (r2 != 0) goto L_0x0346
            com.google.android.gms.internal.ads.zzin r2 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r3 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r5 = r3.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r5 = r8.zzu(r2, r5)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r3 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.<init>(r2, r5)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x034d
        L_0x0346:
            r8.zzC = r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zzl = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            zzM(r11)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x034d:
            r8.zzB(r1, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0350:
            return r10
        L_0x0351:
            r8.zzx(r10)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzbel r1 = r8.zzJ     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.zzd()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzo(r10)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            monitor-enter(r33)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzq = r10     // Catch:{ all -> 0x0364 }
            r33.notifyAll()     // Catch:{ all -> 0x0364 }
            monitor-exit(r33)     // Catch:{ all -> 0x0364 }
            return r10
        L_0x0364:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x0364 }
            throw r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0368:
            r33.zzw()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            return r10
        L_0x036c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzix r1 = (com.google.android.gms.internal.ads.zzix) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzpy r2 = r8.zzn     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x0379
            com.google.android.gms.internal.ads.zzix r1 = r2.zzO(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x037e
        L_0x0379:
            com.google.android.gms.internal.ads.zzqf r2 = r8.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzO(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x037e:
            r8.zzl = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendToTarget()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            return r10
        L_0x038a:
            java.lang.Object r1 = r1.obj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzip r1 = (com.google.android.gms.internal.ads.zzip) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x039b
            int r2 = r8.zzz     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2 + r10
            r8.zzz = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzA = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0415
        L_0x039b:
            android.util.Pair r2 = r8.zzE(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x03bf
            com.google.android.gms.internal.ads.zzio r1 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.<init>(r9, r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Message r1 = r2.obtainMessage(r15, r10, r9, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendToTarget()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r1 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.<init>(r9, r12)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzo(r15)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzx(r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0415
        L_0x03bf:
            long r3 = r1.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03c7
            r1 = 1
            goto L_0x03c8
        L_0x03c7:
            r1 = 0
        L_0x03c8:
            java.lang.Object r3 = r2.first     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r3 = r3.intValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r2 = r2.second     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r4 = r2.longValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r2 = r8.zzk     // Catch:{ all -> 0x0416 }
            int r6 = r2.zza     // Catch:{ all -> 0x0416 }
            if (r3 != r6) goto L_0x03fb
            r16 = 1000(0x3e8, double:4.94E-321)
            long r6 = r4 / r16
            long r11 = r2.zzc     // Catch:{ all -> 0x0416 }
            long r11 = r11 / r16
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x03fb
            com.google.android.gms.internal.ads.zzio r2 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.<init>(r3, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x03f7:
            r1.sendToTarget()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0415
        L_0x03fb:
            long r6 = r8.zzu(r3, r4)     // Catch:{ all -> 0x0416 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0405
            r2 = 1
            goto L_0x0406
        L_0x0405:
            r2 = 0
        L_0x0406:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzio r2 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.<init>(r3, r6)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x03f7
        L_0x0415:
            return r10
        L_0x0416:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzio r6 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r6.<init>(r3, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r6     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r6)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendToTarget()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            throw r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0429:
            r16 = 1000(0x3e8, double:4.94E-321)
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r1 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 != 0) goto L_0x043b
            com.google.android.gms.internal.ads.zznw r1 = r8.zzo     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.zzb()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r11 = r5
            goto L_0x0678
        L_0x043b:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 != 0) goto L_0x0444
            com.google.android.gms.internal.ads.zzio r1 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = r1.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0479
        L_0x0444:
            int r2 = r1.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r7 = r1.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r7 != 0) goto L_0x0553
            boolean r1 = r1.zza()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x0553
            com.google.android.gms.internal.ads.zzje r1 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r7 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r1 = r1.zzd(r2, r7, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r1.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0553
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x046d
            com.google.android.gms.internal.ads.zzin r7 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r7 = r7.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = r1.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r7 = r7 - r1
            r1 = 100
            if (r7 == r1) goto L_0x0553
        L_0x046d:
            com.google.android.gms.internal.ads.zzje r1 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r7 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjd r14 = r8.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r15 = r8.zzv     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = r1.zzh(r2, r7, r14, r15)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0479:
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2.zzc()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 < r2) goto L_0x0488
            com.google.android.gms.internal.ads.zznw r1 = r8.zzo     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.zzb()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0553
        L_0x0488:
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x0493
            com.google.android.gms.internal.ads.zzio r2 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r2.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0490:
            r11 = r5
            r15 = 2
            goto L_0x04e6
        L_0x0493:
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r7 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzd(r1, r7, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjd r7 = r8.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzg(r9, r7, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x04a4
            goto L_0x0490
        L_0x04a4:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r1.zzf     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r11 = r1.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r14 - r11
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = r1.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r7 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r1 = r2.zzd(r1, r7, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r1 = r1.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r14 + r1
            long r1 = r8.zzB     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r14 = r14 - r1
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r7 = 0
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r13 = java.lang.Math.max(r3, r14)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1 = r33
            r3 = r7
            r6 = r5
            r4 = r11
            r11 = r6
            r15 = 2
            r6 = r13
            android.util.Pair r1 = r1.zzH(r2, r3, r4, r6)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x0554
            java.lang.Object r2 = r1.first     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2.intValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r1 = r1.second     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r1.longValue()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1 = r2
        L_0x04e6:
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x04f1
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x04ee:
            r21 = r5
            goto L_0x0504
        L_0x04f1:
            long r5 = r2.zzf     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r2.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r5 = r5 - r13
            com.google.android.gms.internal.ads.zzje r7 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r13 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r2 = r7.zzd(r2, r13, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r2.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r5 = r5 + r13
            goto L_0x04ee
        L_0x0504:
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x050b
            r27 = 0
            goto L_0x0510
        L_0x050b:
            int r2 = r2.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2 + r10
            r27 = r2
        L_0x0510:
            boolean r29 = r8.zzD(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzje r2 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r5 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzd(r1, r5, r10)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = new com.google.android.gms.internal.ads.zzin     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zziy[] r5 = r8.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zziz[] r6 = r8.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzoz r7 = r8.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzbel r13 = r8.zzJ     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zznw r14 = r8.zzo     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r15 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            java.lang.Object r15 = r15.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r32 = 0
            r18 = r2
            r19 = r5
            r20 = r6
            r23 = r7
            r24 = r13
            r25 = r14
            r26 = r15
            r28 = r1
            r30 = r3
            r18.<init>(r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r32)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x0548
            r1.zzl = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0548:
            r8.zzC = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zznu r1 = r2.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.zze(r8, r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzp(r10)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0554
        L_0x0553:
            r11 = r5
        L_0x0554:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x056b
            boolean r1 = r1.zza()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x055f
            goto L_0x056b
        L_0x055f:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x056e
            boolean r1 = r8.zzt     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 != 0) goto L_0x056e
            r33.zzI()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x056e
        L_0x056b:
            r8.zzp(r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x056e:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x0678
        L_0x0572:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == r2) goto L_0x05a9
            long r3 = r8.zzB     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r5 = r1.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r5 = r5.zzf     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x05a9
            r1.zze()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r1.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzJ(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r1 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r3 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r4 = r2.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.<init>(r3, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r33.zzs()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r1 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 5
            com.google.android.gms.internal.ads.zzio r3 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendToTarget()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0572
        L_0x05a9:
            boolean r1 = r2.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x05cf
            r1 = 0
        L_0x05ae:
            r2 = 2
            if (r1 >= r2) goto L_0x0678
            com.google.android.gms.internal.ads.zziy[] r2 = r8.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = r2[r1]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r3 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzog[] r3 = r3.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3 = r3[r1]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x05cc
            com.google.android.gms.internal.ads.zzog r4 = r2.zzi()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r4 != r3) goto L_0x05cc
            boolean r3 = r2.zzj()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x05cc
            r2.zzk()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x05cc:
            int r1 = r1 + 1
            goto L_0x05ae
        L_0x05cf:
            r1 = 0
        L_0x05d0:
            r2 = 2
            if (r1 >= r2) goto L_0x05ee
            com.google.android.gms.internal.ads.zziy[] r2 = r8.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = r2[r1]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r3 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzog[] r3 = r3.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3 = r3[r1]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzog r4 = r2.zzi()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r4 != r3) goto L_0x0678
            if (r3 == 0) goto L_0x05eb
            boolean r2 = r2.zzj()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x0678
        L_0x05eb:
            int r1 = r1 + 1
            goto L_0x05d0
        L_0x05ee:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r1.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x0678
            boolean r3 = r2.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x0678
            com.google.android.gms.internal.ads.zzpa r1 = r1.zzm     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzD = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzpa r3 = r2.zzm     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zznu r2 = r2.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r4 = r2.zzi()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 0
            r6 = 2
        L_0x0606:
            if (r2 >= r6) goto L_0x0678
            com.google.android.gms.internal.ads.zziy[] r6 = r8.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r6 = r6[r2]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzox r7 = r1.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzop r7 = r7.zza(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r7 != 0) goto L_0x0619
        L_0x0614:
            r19 = r3
            r20 = r4
            goto L_0x066e
        L_0x0619:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x0626
            r6.zzk()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0614
        L_0x0626:
            boolean r7 = r6.zzl()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r7 != 0) goto L_0x0614
            com.google.android.gms.internal.ads.zzox r7 = r3.zzb     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzop r7 = r7.zza(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzja[] r13 = r1.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r13 = r13[r2]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzja[] r14 = r3.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r14 = r14[r2]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r7 == 0) goto L_0x0667
            boolean r13 = r14.equals(r13)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r13 == 0) goto L_0x0667
            int r13 = r7.zzb()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzit[] r14 = new com.google.android.gms.internal.ads.zzit[r13]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r15 = 0
        L_0x0649:
            if (r15 >= r13) goto L_0x0654
            com.google.android.gms.internal.ads.zzit r18 = r7.zzc(r15)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r14[r15] = r18     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r15 = r15 + 1
            goto L_0x0649
        L_0x0654:
            com.google.android.gms.internal.ads.zzin r7 = r8.zzD     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzog[] r13 = r7.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r13 = r13[r2]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r9 = r7.zzf     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r19 = r3
            r20 = r4
            long r3 = r7.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r9 = r9 - r3
            r6.zzh(r14, r13, r9)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x066e
        L_0x0667:
            r19 = r3
            r20 = r4
            r6.zzk()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x066e:
            int r2 = r2 + 1
            r3 = r19
            r4 = r20
            r6 = 2
            r9 = 0
            r10 = 1
            goto L_0x0606
        L_0x0678:
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 10
            if (r1 != 0) goto L_0x0687
            r33.zzz()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzt(r11, r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0684:
            r1 = 1
            goto L_0x080e
        L_0x0687:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzqh.zza(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r33.zzs()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r1 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zznu r1 = r1.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r4 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r4 = r4.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.zzh(r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zziy[] r1 = r8.zzp     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r4 = r1.length     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r5 = 1
            r6 = 1
            r7 = 0
        L_0x06a0:
            if (r7 >= r4) goto L_0x06d7
            r9 = r1[r7]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r8.zzB     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r2 = r8.zzy     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r9.zzD(r13, r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r6 == 0) goto L_0x06b5
            boolean r2 = r9.zzF()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x06b5
            r6 = 1
            goto L_0x06b6
        L_0x06b5:
            r6 = 0
        L_0x06b6:
            boolean r2 = r9.zzE()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x06c5
            boolean r2 = r9.zzF()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 == 0) goto L_0x06c3
            goto L_0x06c5
        L_0x06c3:
            r2 = 0
            goto L_0x06c6
        L_0x06c5:
            r2 = 1
        L_0x06c6:
            if (r2 != 0) goto L_0x06cb
            r9.zzm()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x06cb:
            if (r5 == 0) goto L_0x06d1
            if (r2 == 0) goto L_0x06d1
            r5 = 1
            goto L_0x06d2
        L_0x06d1:
            r5 = 0
        L_0x06d2:
            int r7 = r7 + 1
            r2 = 10
            goto L_0x06a0
        L_0x06d7:
            if (r5 != 0) goto L_0x06dc
            r33.zzz()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x06dc:
            com.google.android.gms.internal.ads.zzpy r1 = r8.zzn     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x06ff
            com.google.android.gms.internal.ads.zzix r1 = r1.zzP()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzix r2 = r8.zzl     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r2 = r1.equals(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r2 != 0) goto L_0x06ff
            r8.zzl = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzqf r2 = r8.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzpy r3 = r8.zzn     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.zzd(r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendToTarget()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x06ff:
            com.google.android.gms.internal.ads.zzje r1 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r3 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r4 = 0
            com.google.android.gms.internal.ads.zzjc r1 = r1.zzd(r2, r3, r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r1 = r1.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r6 == 0) goto L_0x0730
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0721
            com.google.android.gms.internal.ads.zzio r3 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r3.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0730
        L_0x0721:
            com.google.android.gms.internal.ads.zzin r3 = r8.zzE     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r3 = r3.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x0730
            r3 = 4
            r8.zzo(r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r33.zzr()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x07c1
        L_0x0730:
            int r3 = r8.zzu     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r4 = 2
            if (r3 != r4) goto L_0x07a7
            com.google.android.gms.internal.ads.zziy[] r3 = r8.zzp     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r3 = r3.length     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 <= 0) goto L_0x0795
            if (r5 == 0) goto L_0x07c1
            boolean r1 = r8.zzs     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r3 = r2.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 != 0) goto L_0x0747
            long r2 = r2.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x074d
        L_0x0747:
            com.google.android.gms.internal.ads.zznu r2 = r2.zza     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r2 = r2.zzj()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x074d:
            r4 = -9223372036854775808
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0767
            com.google.android.gms.internal.ads.zzin r2 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r3 = r2.zzi     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 == 0) goto L_0x075a
            goto L_0x079b
        L_0x075a:
            com.google.android.gms.internal.ads.zzje r3 = r8.zzF     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r2.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzjc r4 = r8.zzj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r5 = 0
            com.google.android.gms.internal.ads.zzjc r2 = r3.zzd(r2, r4, r5)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r2 = r2.zzc     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0767:
            boolean r4 = r8.zzG     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r4 == 0) goto L_0x0781
            com.google.android.gms.internal.ads.zzbel r2 = r8.zzJ     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzio r3 = r8.zzk     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r3 = r3.zzd     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r5 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r6 = r8.zzB     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r9 = r5.zzf     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r5.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r3 = r3 - r6
            boolean r1 = r2.zze(r3, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0792
        L_0x0781:
            com.google.android.gms.internal.ads.zzbel r4 = r8.zzJ     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzin r5 = r8.zzC     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r6 = r8.zzB     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r9 = r5.zzf     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r13 = r5.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r2 = r2 - r6
            boolean r1 = r4.zze(r2, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0792:
            if (r1 == 0) goto L_0x07c1
            goto L_0x079b
        L_0x0795:
            boolean r1 = r8.zzy(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x07c1
        L_0x079b:
            r1 = 3
            r8.zzo(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            boolean r1 = r8.zzr     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x07c1
            r33.zzq()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x07c1
        L_0x07a7:
            r4 = 3
            if (r3 != r4) goto L_0x07c1
            com.google.android.gms.internal.ads.zziy[] r3 = r8.zzp     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r3 = r3.length     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r3 <= 0) goto L_0x07b0
            goto L_0x07b4
        L_0x07b0:
            boolean r5 = r8.zzy(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x07b4:
            if (r5 != 0) goto L_0x07c1
            boolean r1 = r8.zzr     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzs = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1 = 2
            r8.zzo(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r33.zzr()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x07c1:
            int r1 = r8.zzu     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 2
            if (r1 != r2) goto L_0x07d4
            com.google.android.gms.internal.ads.zziy[] r1 = r8.zzp     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r2 = r1.length     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r9 = 0
        L_0x07ca:
            if (r9 >= r2) goto L_0x07d4
            r3 = r1[r9]     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zzm()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r9 = r9 + 1
            goto L_0x07ca
        L_0x07d4:
            boolean r1 = r8.zzr     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x07dd
            int r1 = r8.zzu     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 3
            if (r1 == r2) goto L_0x07e2
        L_0x07dd:
            int r1 = r8.zzu     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 2
            if (r1 != r2) goto L_0x07f0
        L_0x07e2:
            int r1 = r8.zzH     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 <= 0) goto L_0x07ea
            int r1 = r8.zzH     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r2 = (long) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x07ec
        L_0x07ea:
            r2 = 10
        L_0x07ec:
            r8.zzt(r11, r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0809
        L_0x07f0:
            com.google.android.gms.internal.ads.zziy[] r1 = r8.zzp     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = r1.length     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x0803
            int r1 = r8.zzI     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 <= 0) goto L_0x07fd
            int r1 = r8.zzI     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            long r1 = (long) r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x07ff
        L_0x07fd:
            r1 = r16
        L_0x07ff:
            r8.zzt(r11, r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0809
        L_0x0803:
            android.os.Handler r1 = r8.zze     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 2
            r1.removeMessages(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0809:
            com.google.android.gms.internal.ads.zzqh.zzb()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0684
        L_0x080e:
            return r1
        L_0x080f:
            int r1 = r1.arg1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x0815
            r1 = 1
            goto L_0x0816
        L_0x0815:
            r1 = 0
        L_0x0816:
            r2 = 0
            r8.zzs = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzr = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 != 0) goto L_0x0825
            r33.zzr()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r33.zzs()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0823:
            r1 = 1
            goto L_0x083d
        L_0x0825:
            int r1 = r8.zzu     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 3
            if (r1 != r2) goto L_0x0834
            r33.zzq()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r1 = r8.zze     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2 = 2
            r1.sendEmptyMessage(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0823
        L_0x0834:
            r2 = 2
            if (r1 != r2) goto L_0x0823
            android.os.Handler r1 = r8.zze     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1.sendEmptyMessage(r2)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            goto L_0x0823
        L_0x083d:
            return r1
        L_0x083e:
            java.lang.Object r2 = r1.obj     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zznw r2 = (com.google.android.gms.internal.ads.zznw) r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            int r1 = r1.arg1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r4 = 0
            r3.sendEmptyMessage(r4)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3 = 1
            r8.zzx(r3)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzbel r3 = r8.zzJ     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3.zza()     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            if (r1 == 0) goto L_0x0861
            com.google.android.gms.internal.ads.zzio r1 = new com.google.android.gms.internal.ads.zzio     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r4, r5)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r8.zzk = r1     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
        L_0x0861:
            r8.zzo = r2     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            com.google.android.gms.internal.ads.zzij r1 = r8.zzh     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r3 = 1
            r2.zza(r1, r3, r8)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r1 = 2
            r8.zzo(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            android.os.Handler r2 = r8.zze     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            r2.sendEmptyMessage(r1)     // Catch:{ zzif -> 0x0879, IOException -> 0x0873, RuntimeException -> 0x087f }
            return r3
        L_0x0873:
            r0 = move-exception
            r2 = r0
            r1 = 1
            r3 = 8
            goto L_0x08a1
        L_0x0879:
            r0 = move-exception
            r2 = r0
            r1 = 1
            r3 = 8
            goto L_0x08be
        L_0x087f:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.zzg
            com.google.android.gms.internal.ads.zzif r1 = com.google.android.gms.internal.ads.zzif.zzc(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r33.zzw()
            r1 = 1
            return r1
        L_0x089c:
            r0 = move-exception
            r1 = 1
            r3 = 8
            r2 = r0
        L_0x08a1:
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r5 = "Source error."
            android.util.Log.e(r4, r5, r2)
            android.os.Handler r4 = r8.zzg
            com.google.android.gms.internal.ads.zzif r2 = com.google.android.gms.internal.ads.zzif.zzb(r2)
            android.os.Message r2 = r4.obtainMessage(r3, r2)
            r2.sendToTarget()
            r33.zzw()
            return r1
        L_0x08b9:
            r0 = move-exception
            r1 = 1
            r3 = 8
            r2 = r0
        L_0x08be:
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r5 = "Renderer error."
            android.util.Log.e(r4, r5, r2)
            android.os.Handler r4 = r8.zzg
            android.os.Message r2 = r4.obtainMessage(r3, r2)
            r2.sendToTarget()
            r33.zzw()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzir.handleMessage(android.os.Message):boolean");
    }

    public final void zza() {
        this.zzG = true;
    }

    public final void zzb(zznw zznw, boolean z) {
        this.zze.obtainMessage(0, 1, 0, zznw).sendToTarget();
    }

    public final void zzbh(zznu zznu) {
        this.zze.obtainMessage(8, zznu).sendToTarget();
    }

    public final void zzc(boolean z) {
        this.zze.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zzd(zzje zzje, int i, long j) {
        this.zze.obtainMessage(3, new zzip(zzje, 0, j)).sendToTarget();
    }

    public final void zze() {
        this.zze.sendEmptyMessage(5);
    }

    public final void zzf(zzii... zziiArr) {
        if (this.zzq) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzw++;
        this.zze.obtainMessage(11, zziiArr).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg(com.google.android.gms.internal.ads.zzii... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.zzw     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.zzw = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.zze     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.zzx     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0035
        L_0x0034:
            throw r4
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzir.zzg(com.google.android.gms.internal.ads.zzii[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.zze     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzf     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0028
        L_0x0027:
            throw r0
        L_0x0028:
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzir.zzh():void");
    }

    public final void zzi(zzje zzje, Object obj) {
        this.zze.obtainMessage(7, Pair.create(zzje, (Object) null)).sendToTarget();
    }

    public final void zzk() {
        this.zze.sendEmptyMessage(10);
    }

    public final void zzl(int i) {
        this.zzH = i;
    }

    public final void zzm(int i) {
        this.zzI = i;
    }

    public final /* bridge */ /* synthetic */ void zzn(zzoi zzoi) {
        this.zze.obtainMessage(9, (zznu) zzoi).sendToTarget();
    }

    private final void zzv(long j) throws zzif {
        zzin zzin = this.zzE;
        long j2 = zzin == null ? j + 60000000 : j + (zzin.zzf - zzin.zzh);
        this.zzB = j2;
        this.zzd.zzc(j2);
        for (zziy zzn2 : this.zzp) {
            zzn2.zzn(this.zzB);
        }
    }
}
