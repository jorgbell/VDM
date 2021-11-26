package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzjz {
    private Method zzA;
    private int zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private float zzM;
    private zzji[] zzN;
    private ByteBuffer[] zzO;
    private ByteBuffer zzP;
    private ByteBuffer zzQ;
    private byte[] zzR;
    private int zzS;
    private int zzT;
    private boolean zzU;
    private boolean zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private final zzka zza;
    private final zzkg zzb;
    private final zzji[] zzc;
    private final zzjw zzd;
    /* access modifiers changed from: private */
    public final ConditionVariable zze = new ConditionVariable(true);
    private final long[] zzf;
    private final zzjs zzg;
    private final LinkedList<zzjx> zzh;
    private AudioTrack zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private int zzo;
    private long zzp;
    private zzix zzq;
    private zzix zzr;
    private long zzs;
    private long zzt;
    private int zzu;
    private int zzv;
    private long zzw;
    private long zzx;
    private boolean zzy;
    private long zzz;

    public zzjz(zzjg zzjg, zzji[] zzjiArr, zzjw zzjw) {
        this.zzd = zzjw;
        if (zzqj.zza >= 18) {
            try {
                this.zzA = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzqj.zza >= 19) {
            this.zzg = new zzjt();
        } else {
            this.zzg = new zzjs((zzjr) null);
        }
        zzka zzka = new zzka();
        this.zza = zzka;
        zzkg zzkg = new zzkg();
        this.zzb = zzkg;
        zzji[] zzjiArr2 = new zzji[3];
        this.zzc = zzjiArr2;
        zzjiArr2[0] = new zzke();
        zzjiArr2[1] = zzka;
        System.arraycopy(zzjiArr, 0, zzjiArr2, 2, 0);
        zzjiArr2[2] = zzkg;
        this.zzf = new long[10];
        this.zzM = 1.0f;
        this.zzI = 0;
        this.zzW = 0;
        this.zzr = zzix.zza;
        this.zzT = -1;
        this.zzN = new zzji[0];
        this.zzO = new ByteBuffer[0];
        this.zzh = new LinkedList<>();
    }

    private final void zzp() {
        ArrayList arrayList = new ArrayList();
        zzji[] zzjiArr = this.zzc;
        for (int i = 0; i < 3; i++) {
            zzji zzji = zzjiArr[i];
            if (zzji.zzb()) {
                arrayList.add(zzji);
            } else {
                zzji.zzi();
            }
        }
        int size = arrayList.size();
        this.zzN = (zzji[]) arrayList.toArray(new zzji[size]);
        this.zzO = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            zzji zzji2 = this.zzN[i2];
            zzji2.zzi();
            this.zzO[i2] = zzji2.zzg();
        }
    }

    private final void zzq(long j) throws zzjy {
        ByteBuffer byteBuffer;
        int length = this.zzN.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzO[i - 1];
            } else {
                byteBuffer = this.zzP;
                if (byteBuffer == null) {
                    byteBuffer = zzji.zza;
                }
            }
            if (i == length) {
                zzr(byteBuffer, j);
            } else {
                zzji zzji = this.zzN[i];
                zzji.zze(byteBuffer);
                ByteBuffer zzg2 = zzji.zzg();
                this.zzO[i] = zzg2;
                if (zzg2.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private final boolean zzr(ByteBuffer byteBuffer, long j) throws zzjy {
        int i;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.zzQ;
        if (byteBuffer2 != null) {
            zzpu.zza(byteBuffer2 == byteBuffer);
        } else {
            this.zzQ = byteBuffer;
            if (zzqj.zza < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.zzR;
                if (bArr == null || bArr.length < remaining) {
                    this.zzR = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.zzR, 0, remaining);
                byteBuffer.position(position);
                this.zzS = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (zzqj.zza < 21) {
            int zzd2 = this.zzo - ((int) (this.zzF - (this.zzg.zzd() * ((long) this.zzE))));
            if (zzd2 > 0) {
                i = this.zzi.write(this.zzR, this.zzS, Math.min(remaining2, zzd2));
                if (i > 0) {
                    this.zzS += i;
                    byteBuffer.position(byteBuffer.position() + i);
                }
            } else {
                i = 0;
            }
        } else {
            i = this.zzi.write(byteBuffer, remaining2, 1);
        }
        this.zzY = SystemClock.elapsedRealtime();
        if (i >= 0) {
            boolean z = this.zzn;
            if (!z) {
                this.zzF += (long) i;
            }
            if (i != remaining2) {
                return false;
            }
            if (z) {
                this.zzG += (long) this.zzH;
            }
            this.zzQ = null;
            return true;
        }
        throw new zzjy(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzs() throws com.google.android.gms.internal.ads.zzjy {
        /*
            r9 = this;
            int r0 = r9.zzT
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzn
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzji[] r0 = r9.zzN
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzT = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzT
            com.google.android.gms.internal.ads.zzji[] r5 = r9.zzN
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzf()
        L_0x0028:
            r9.zzq(r7)
            boolean r0 = r4.zzh()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzT
            int r0 = r0 + r2
            r9.zzT = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            r9.zzr(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzT = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjz.zzs():boolean");
    }

    private final void zzt() {
        if (zzu()) {
            if (zzqj.zza >= 21) {
                this.zzi.setVolume(this.zzM);
                return;
            }
            AudioTrack audioTrack = this.zzi;
            float f = this.zzM;
            audioTrack.setStereoVolume(f, f);
        }
    }

    private final boolean zzu() {
        return this.zzi != null;
    }

    private final long zzv(long j) {
        return (j * 1000000) / ((long) this.zzj);
    }

    private final long zzw(long j) {
        return (j * ((long) this.zzj)) / 1000000;
    }

    private final long zzx() {
        return this.zzn ? this.zzG : this.zzF / ((long) this.zzE);
    }

    private final void zzy() {
        this.zzw = 0;
        this.zzv = 0;
        this.zzu = 0;
        this.zzx = 0;
        this.zzy = false;
        this.zzz = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r4.zzm;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzz() {
        /*
            r4 = this;
            int r0 = com.google.android.gms.internal.ads.zzqj.zza
            r1 = 1
            r2 = 0
            r3 = 23
            if (r0 >= r3) goto L_0x0012
            int r0 = r4.zzm
            r3 = 5
            if (r0 == r3) goto L_0x0013
            r3 = 6
            if (r0 == r3) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            return r1
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjz.zzz():boolean");
    }

    public final long zza(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (!zzu() || this.zzI == 0) {
            return Long.MIN_VALUE;
        }
        if (this.zzi.getPlayState() == 3) {
            long zze2 = this.zzg.zze();
            if (zze2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzx >= 30000) {
                    long[] jArr = this.zzf;
                    int i = this.zzu;
                    jArr[i] = zze2 - nanoTime;
                    this.zzu = (i + 1) % 10;
                    int i2 = this.zzv;
                    if (i2 < 10) {
                        this.zzv = i2 + 1;
                    }
                    this.zzx = nanoTime;
                    this.zzw = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzv;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzw += this.zzf[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzz() && nanoTime - this.zzz >= 500000) {
                    boolean zzf2 = this.zzg.zzf();
                    this.zzy = zzf2;
                    if (zzf2) {
                        long zzg2 = this.zzg.zzg() / 1000;
                        long zzh2 = this.zzg.zzh();
                        if (zzg2 < this.zzK) {
                            this.zzy = false;
                        } else if (Math.abs(zzg2 - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzh2);
                            sb.append(", ");
                            sb.append(zzg2);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zze2);
                            Log.w("AudioTrack", sb.toString());
                            this.zzy = false;
                        } else if (Math.abs(zzv(zzh2) - zze2) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzh2);
                            sb2.append(", ");
                            sb2.append(zzg2);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(zze2);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzy = false;
                        }
                    }
                    Method method = this.zzA;
                    if (method != null && !this.zzn) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzi, (Object[]) null)).intValue()) * 1000) - this.zzp;
                            this.zzL = intValue;
                            long max = Math.max(intValue, 0);
                            this.zzL = max;
                            if (max > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(max);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzL = 0;
                            }
                        } catch (Exception unused) {
                            this.zzA = null;
                        }
                    }
                    this.zzz = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzy) {
            j = zzv(this.zzg.zzh() + zzw(nanoTime2 - (this.zzg.zzg() / 1000)));
        } else {
            j = this.zzv == 0 ? this.zzg.zze() : nanoTime2 + this.zzw;
            if (!z) {
                j -= this.zzL;
            }
        }
        long j5 = this.zzJ;
        while (!this.zzh.isEmpty() && j >= this.zzh.getFirst().zzc) {
            zzjx remove = this.zzh.remove();
            this.zzr = remove.zza;
            this.zzt = remove.zzc;
            this.zzs = remove.zzb - this.zzJ;
        }
        if (this.zzr.zzb == 1.0f) {
            j2 = (j + this.zzs) - this.zzt;
        } else {
            if (!this.zzh.isEmpty() || this.zzb.zzn() < 1024) {
                j3 = this.zzs;
                double d = (double) this.zzr.zzb;
                double d2 = (double) (j - this.zzt);
                Double.isNaN(d);
                Double.isNaN(d2);
                j4 = (long) (d * d2);
            } else {
                j3 = this.zzs;
                j4 = zzqj.zzj(j - this.zzt, this.zzb.zzm(), this.zzb.zzn());
            }
            j2 = j4 + j3;
        }
        return j5 + j2;
    }

    public final void zzc() {
        this.zzV = true;
        if (zzu()) {
            this.zzK = System.nanoTime() / 1000;
            this.zzi.play();
        }
    }

    public final void zzd() {
        if (this.zzI == 1) {
            this.zzI = 2;
        }
    }

    public final boolean zze(ByteBuffer byteBuffer, long j) throws zzjv, zzjy {
        long j2;
        int i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j;
        ByteBuffer byteBuffer3 = this.zzP;
        zzpu.zza(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!zzu()) {
            this.zze.block();
            int i2 = this.zzW;
            if (i2 == 0) {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1);
            } else {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1, i2);
            }
            int state = this.zzi.getState();
            if (state == 1) {
                int audioSessionId = this.zzi.getAudioSessionId();
                if (this.zzW != audioSessionId) {
                    this.zzW = audioSessionId;
                    ((zzkc) this.zzd).zza.zzb.zzf(audioSessionId);
                }
                this.zzg.zza(this.zzi, zzz());
                zzt();
                this.zzX = false;
                if (this.zzV) {
                    zzc();
                }
            } else {
                try {
                    this.zzi.release();
                } catch (Exception unused) {
                } finally {
                    this.zzi = null;
                }
                throw new zzjv(state, this.zzj, this.zzk, this.zzo);
            }
        }
        if (zzz()) {
            if (this.zzi.getPlayState() == 2) {
                this.zzX = false;
                return false;
            } else if (this.zzi.getPlayState() == 1 && this.zzg.zzd() != 0) {
                return false;
            }
        }
        boolean z = this.zzX;
        boolean zzh2 = zzh();
        this.zzX = zzh2;
        if (z && !zzh2 && this.zzi.getPlayState() != 1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j4 = this.zzY;
            zzjw zzjw = this.zzd;
            ((zzkc) zzjw).zza.zzb.zzd(this.zzo, zzie.zza(this.zzp), elapsedRealtime - j4);
        }
        if (this.zzP == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzn && this.zzH == 0) {
                int i3 = this.zzm;
                if (i3 == 7 || i3 == 8) {
                    int position = byteBuffer.position();
                    i = ((((byteBuffer2.get(position + 5) & 252) >> 2) | ((byteBuffer2.get(position + 4) & 1) << 6)) + 1) * 32;
                } else if (i3 == 5) {
                    int i4 = zzjf.zza;
                    i = 1536;
                } else if (i3 == 6) {
                    i = zzjf.zzc(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzH = i;
            }
            if (this.zzq != null) {
                if (!zzs()) {
                    return false;
                }
                this.zzh.add(new zzjx(this.zzq, Math.max(0, j3), zzv(zzx()), (zzjr) null));
                this.zzq = null;
                zzp();
            }
            if (this.zzI == 0) {
                this.zzJ = Math.max(0, j3);
                this.zzI = 1;
            } else {
                long j5 = this.zzJ;
                if (this.zzn) {
                    j2 = this.zzD;
                } else {
                    j2 = this.zzC / ((long) this.zzB);
                }
                long zzv2 = j5 + zzv(j2);
                if (this.zzI == 1 && Math.abs(zzv2 - j3) > 200000) {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzv2);
                    sb2.append(", got ");
                    sb2.append(j3);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    this.zzI = 2;
                }
                if (this.zzI == 2) {
                    this.zzJ += j3 - zzv2;
                    this.zzI = 1;
                    boolean unused2 = ((zzkc) this.zzd).zza.zzh = true;
                }
            }
            if (this.zzn) {
                this.zzD += (long) this.zzH;
            } else {
                this.zzC += (long) byteBuffer.remaining();
            }
            this.zzP = byteBuffer2;
        }
        if (this.zzn) {
            zzr(this.zzP, j3);
        } else {
            zzq(j3);
        }
        if (this.zzP.hasRemaining()) {
            return false;
        }
        this.zzP = null;
        return true;
    }

    public final void zzf() throws zzjy {
        if (!this.zzU && zzu() && zzs()) {
            this.zzg.zzb(zzx());
            this.zzU = true;
        }
    }

    public final boolean zzg() {
        return !zzu() || (this.zzU && !zzh());
    }

    public final boolean zzh() {
        if (zzu()) {
            if (zzx() > this.zzg.zzd()) {
                return true;
            }
            if (zzz() && this.zzi.getPlayState() == 2 && this.zzi.getPlaybackHeadPosition() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final zzix zzi(zzix zzix) {
        if (this.zzn) {
            zzix zzix2 = zzix.zza;
            this.zzr = zzix2;
            return zzix2;
        }
        float zzk2 = this.zzb.zzk(zzix.zzb);
        zzkg zzkg = this.zzb;
        float f = zzix.zzc;
        zzkg.zzl(1.0f);
        zzix zzix3 = new zzix(zzk2, 1.0f);
        zzix zzix4 = this.zzq;
        if (zzix4 == null) {
            if (!this.zzh.isEmpty()) {
                zzix4 = this.zzh.getLast().zza;
            } else {
                zzix4 = this.zzr;
            }
        }
        if (!zzix3.equals(zzix4)) {
            if (zzu()) {
                this.zzq = zzix3;
            } else {
                this.zzr = zzix3;
            }
        }
        return this.zzr;
    }

    public final zzix zzj() {
        return this.zzr;
    }

    public final void zzk(float f) {
        if (this.zzM != f) {
            this.zzM = f;
            zzt();
        }
    }

    public final void zzl() {
        this.zzV = false;
        if (zzu()) {
            zzy();
            this.zzg.zzc();
        }
    }

    public final void zzn() {
        zzm();
        zzji[] zzjiArr = this.zzc;
        for (int i = 0; i < 3; i++) {
            zzjiArr[i].zzj();
        }
        this.zzW = 0;
        this.zzV = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, int r9, int r10, int r11, int[] r12) throws com.google.android.gms.internal.ads.zzju {
        /*
            r6 = this;
            int r7 = com.google.android.gms.internal.ads.zzqj.zzp(r10, r8)
            r6.zzB = r7
            com.google.android.gms.internal.ads.zzka r7 = r6.zza
            r7.zzk(r12)
            com.google.android.gms.internal.ads.zzji[] r7 = r6.zzc
            r11 = 0
            r12 = 0
            r0 = 0
        L_0x0010:
            r1 = 3
            r2 = 2
            if (r12 >= r1) goto L_0x0033
            r1 = r7[r12]
            boolean r3 = r1.zza(r9, r8, r10)     // Catch:{ zzjh -> 0x002c }
            r0 = r0 | r3
            boolean r3 = r1.zzb()
            if (r3 == 0) goto L_0x0029
            int r8 = r1.zzc()
            r1.zzd()
            r10 = 2
        L_0x0029:
            int r12 = r12 + 1
            goto L_0x0010
        L_0x002c:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzju r8 = new com.google.android.gms.internal.ads.zzju
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x0033:
            if (r0 == 0) goto L_0x0038
            r6.zzp()
        L_0x0038:
            r7 = 252(0xfc, float:3.53E-43)
            switch(r8) {
                case 1: goto L_0x006b;
                case 2: goto L_0x0068;
                case 3: goto L_0x0065;
                case 4: goto L_0x0062;
                case 5: goto L_0x005f;
                case 6: goto L_0x005c;
                case 7: goto L_0x0059;
                case 8: goto L_0x0056;
                default: goto L_0x003d;
            }
        L_0x003d:
            com.google.android.gms.internal.ads.zzju r7 = new com.google.android.gms.internal.ads.zzju
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r10 = 38
            r9.<init>(r10)
            java.lang.String r10 = "Unsupported channel count: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x0056:
            int r12 = com.google.android.gms.internal.ads.zzie.zza
            goto L_0x006c
        L_0x0059:
            r12 = 1276(0x4fc, float:1.788E-42)
            goto L_0x006c
        L_0x005c:
            r12 = 252(0xfc, float:3.53E-43)
            goto L_0x006c
        L_0x005f:
            r12 = 220(0xdc, float:3.08E-43)
            goto L_0x006c
        L_0x0062:
            r12 = 204(0xcc, float:2.86E-43)
            goto L_0x006c
        L_0x0065:
            r12 = 28
            goto L_0x006c
        L_0x0068:
            r12 = 12
            goto L_0x006c
        L_0x006b:
            r12 = 4
        L_0x006c:
            int r3 = com.google.android.gms.internal.ads.zzqj.zza
            r4 = 23
            if (r3 > r4) goto L_0x0092
            java.lang.String r4 = com.google.android.gms.internal.ads.zzqj.zzb
            java.lang.String r5 = "foster"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0092
            java.lang.String r4 = com.google.android.gms.internal.ads.zzqj.zzc
            java.lang.String r5 = "NVIDIA"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0092
            if (r8 == r1) goto L_0x0093
            r1 = 5
            if (r8 == r1) goto L_0x0093
            r7 = 7
            if (r8 == r7) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            int r7 = com.google.android.gms.internal.ads.zzie.zza
            goto L_0x0093
        L_0x0092:
            r7 = r12
        L_0x0093:
            r12 = 25
            if (r3 > r12) goto L_0x009f
            java.lang.String r12 = com.google.android.gms.internal.ads.zzqj.zzb
            java.lang.String r1 = "fugu"
            boolean r12 = r1.equals(r12)
        L_0x009f:
            if (r0 != 0) goto L_0x00b5
            boolean r12 = r6.zzu()
            if (r12 == 0) goto L_0x00b5
            int r12 = r6.zzl
            if (r12 != r10) goto L_0x00b5
            int r12 = r6.zzj
            if (r12 != r9) goto L_0x00b5
            int r12 = r6.zzk
            if (r12 == r7) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            return
        L_0x00b5:
            r6.zzm()
            r6.zzl = r10
            r6.zzn = r11
            r6.zzj = r9
            r6.zzk = r7
            r6.zzm = r2
            int r8 = com.google.android.gms.internal.ads.zzqj.zzp(r2, r8)
            r6.zzE = r8
            int r8 = r6.zzm
            int r7 = android.media.AudioTrack.getMinBufferSize(r9, r7, r8)
            r8 = -2
            if (r7 == r8) goto L_0x00d2
            r11 = 1
        L_0x00d2:
            com.google.android.gms.internal.ads.zzpu.zzd(r11)
            int r8 = r7 * 4
            r9 = 250000(0x3d090, double:1.235164E-318)
            long r9 = r6.zzw(r9)
            int r10 = (int) r9
            int r9 = r6.zzE
            int r10 = r10 * r9
            long r11 = (long) r7
            r0 = 750000(0xb71b0, double:3.70549E-318)
            long r0 = r6.zzw(r0)
            int r7 = r6.zzE
            long r2 = (long) r7
            long r0 = r0 * r2
            long r11 = java.lang.Math.max(r11, r0)
            int r7 = (int) r11
            if (r8 >= r10) goto L_0x00f9
            r8 = r10
            goto L_0x00fc
        L_0x00f9:
            if (r8 <= r7) goto L_0x00fc
            r8 = r7
        L_0x00fc:
            r6.zzo = r8
            int r7 = r6.zzE
            int r8 = r8 / r7
            long r7 = (long) r8
            long r7 = r6.zzv(r7)
            r6.zzp = r7
            com.google.android.gms.internal.ads.zzix r7 = r6.zzr
            r6.zzi(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjz.zzb(java.lang.String, int, int, int, int, int[]):void");
    }

    public final void zzm() {
        if (zzu()) {
            this.zzC = 0;
            this.zzD = 0;
            this.zzF = 0;
            this.zzG = 0;
            this.zzH = 0;
            zzix zzix = this.zzq;
            if (zzix != null) {
                this.zzr = zzix;
                this.zzq = null;
            } else if (!this.zzh.isEmpty()) {
                this.zzr = this.zzh.getLast().zza;
            }
            this.zzh.clear();
            this.zzs = 0;
            this.zzt = 0;
            this.zzP = null;
            this.zzQ = null;
            int i = 0;
            while (true) {
                zzji[] zzjiArr = this.zzN;
                if (i >= zzjiArr.length) {
                    break;
                }
                zzji zzji = zzjiArr[i];
                zzji.zzi();
                this.zzO[i] = zzji.zzg();
                i++;
            }
            this.zzU = false;
            this.zzT = -1;
            this.zzI = 0;
            this.zzL = 0;
            zzy();
            if (this.zzi.getPlayState() == 3) {
                this.zzi.pause();
            }
            AudioTrack audioTrack = this.zzi;
            this.zzi = null;
            this.zzg.zza((AudioTrack) null, false);
            this.zze.close();
            new zzjr(this, audioTrack).start();
        }
    }
}
