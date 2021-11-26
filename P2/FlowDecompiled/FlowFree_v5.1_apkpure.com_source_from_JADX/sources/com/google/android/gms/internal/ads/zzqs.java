package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzqs extends zzmn {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private long zzA;
    private int zzB;
    private final Context zzc;
    private final zzqu zzd;
    private final zzrc zze;
    private final boolean zzf;
    private final long[] zzg;
    private zzit[] zzh;
    private zzqr zzi;
    private Surface zzj;
    private Surface zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private float zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private float zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private float zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzqs(Context context, zzmp zzmp, long j, Handler handler, zzrd zzrd, int i) {
        super(2, zzmp, (zzkr) null, false);
        boolean z = false;
        this.zzc = context.getApplicationContext();
        this.zzd = new zzqu(context);
        this.zze = new zzrc(handler, zzrd);
        if (zzqj.zza <= 22 && "foster".equals(zzqj.zzb) && "NVIDIA".equals(zzqj.zzc)) {
            z = true;
        }
        this.zzf = z;
        this.zzg = new long[10];
        this.zzA = -9223372036854775807L;
        this.zzm = -9223372036854775807L;
        this.zzs = -1;
        this.zzt = -1;
        this.zzv = -1.0f;
        this.zzr = -1.0f;
        zzab();
    }

    private final boolean zzT(boolean z) {
        if (zzqj.zza < 23 || (z && !zzqp.zza(this.zzc))) {
            return false;
        }
        return true;
    }

    private final void zzab() {
        this.zzw = -1;
        this.zzx = -1;
        this.zzz = -1.0f;
        this.zzy = -1;
    }

    private final void zzac() {
        int i = this.zzw;
        int i2 = this.zzs;
        if (i != i2 || this.zzx != this.zzt || this.zzy != this.zzu || this.zzz != this.zzv) {
            this.zze.zze(i2, this.zzt, this.zzu, this.zzv);
            this.zzw = this.zzs;
            this.zzx = this.zzt;
            this.zzy = this.zzu;
            this.zzz = this.zzv;
        }
    }

    private final void zzad() {
        if (this.zzw != -1 || this.zzx != -1) {
            this.zze.zze(this.zzs, this.zzt, this.zzu, this.zzv);
        }
    }

    private final void zzae() {
        if (this.zzo > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zze.zzd(this.zzo, elapsedRealtime - this.zzn);
            this.zzo = 0;
            this.zzn = elapsedRealtime;
        }
    }

    private static boolean zzaf(long j) {
        return j < -30000;
    }

    private static int zzag(zzit zzit) {
        int i = zzit.zzg;
        if (i != -1) {
            return i;
        }
        return zzah(zzit.zzf, zzit.zzj, zzit.zzk);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzah(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x0083
            if (r9 != r0) goto L_0x0007
            goto L_0x0083
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x007b
            if (r7 == r3) goto L_0x007b
            if (r7 == r6) goto L_0x0061
            if (r7 == r5) goto L_0x007b
            if (r7 == r4) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x007e
        L_0x0061:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzqj.zzd
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzqj.zze(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzqj.zze(r9, r7)
            int r8 = r8 * r7
            int r8 = r8 * 256
            goto L_0x007d
        L_0x007b:
            int r8 = r8 * r9
        L_0x007d:
            r4 = 2
        L_0x007e:
            int r8 = r8 * 3
            int r4 = r4 + r4
            int r8 = r8 / r4
            return r8
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzah(java.lang.String, int, int):int");
    }

    private static boolean zzai(boolean z, zzit zzit, zzit zzit2) {
        if (zzit.zzf.equals(zzit2.zzf) && zzaj(zzit) == zzaj(zzit2)) {
            if (z) {
                return true;
            }
            if (zzit.zzj == zzit2.zzj && zzit.zzk == zzit2.zzk) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static int zzaj(zzit zzit) {
        int i = zzit.zzm;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public final boolean zzE() {
        Surface surface;
        if (super.zzE() && (this.zzl || (((surface = this.zzk) != null && this.zzj == surface) || zzW() == null))) {
            this.zzm = -9223372036854775807L;
            return true;
        } else if (this.zzm == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzm) {
                return true;
            }
            this.zzm = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzH(com.google.android.gms.internal.ads.zzmp r8, com.google.android.gms.internal.ads.zzit r9) throws com.google.android.gms.internal.ads.zzms {
        /*
            r7 = this;
            java.lang.String r8 = r9.zzf
            boolean r0 = com.google.android.gms.internal.ads.zzpz.zzb(r8)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.google.android.gms.internal.ads.zzkq r0 = r9.zzi
            r2 = 1
            if (r0 == 0) goto L_0x0024
            r3 = 0
            r4 = 0
        L_0x0011:
            int r5 = r0.zza
            if (r3 >= r5) goto L_0x001f
            com.google.android.gms.internal.ads.zzkp r5 = r0.zza(r3)
            boolean r5 = r5.zzc
            r4 = r4 | r5
            int r3 = r3 + 1
            goto L_0x0011
        L_0x001f:
            if (r2 == r4) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            com.google.android.gms.internal.ads.zzml r8 = com.google.android.gms.internal.ads.zzmw.zza(r8, r0)
            if (r8 != 0) goto L_0x002c
            return r2
        L_0x002c:
            java.lang.String r0 = r9.zzc
            boolean r0 = r8.zzd(r0)
            if (r0 == 0) goto L_0x0092
            int r3 = r9.zzj
            if (r3 <= 0) goto L_0x0092
            int r4 = r9.zzk
            if (r4 <= 0) goto L_0x0092
            int r0 = com.google.android.gms.internal.ads.zzqj.zza
            r5 = 21
            if (r0 < r5) goto L_0x004a
            float r9 = r9.zzl
            double r5 = (double) r9
            boolean r0 = r8.zze(r3, r4, r5)
            goto L_0x0092
        L_0x004a:
            int r3 = r3 * r4
            int r0 = com.google.android.gms.internal.ads.zzmw.zzc()
            if (r3 > r0) goto L_0x0054
            r0 = 1
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            if (r0 != 0) goto L_0x0092
            int r3 = r9.zzj
            int r9 = r9.zzk
            java.lang.String r4 = com.google.android.gms.internal.ads.zzqj.zze
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r5 = r5 + 56
            r6.<init>(r5)
            java.lang.String r5 = "FalseCheck [legacyFrameSize, "
            r6.append(r5)
            r6.append(r3)
            java.lang.String r3 = "x"
            r6.append(r3)
            r6.append(r9)
            java.lang.String r9 = "] ["
            r6.append(r9)
            r6.append(r4)
            java.lang.String r9 = "]"
            r6.append(r9)
            java.lang.String r9 = r6.toString()
            java.lang.String r3 = "MediaCodecVideoRenderer"
            android.util.Log.d(r3, r9)
        L_0x0092:
            boolean r9 = r8.zzb
            if (r2 == r9) goto L_0x0098
            r9 = 4
            goto L_0x009a
        L_0x0098:
            r9 = 8
        L_0x009a:
            boolean r8 = r8.zzc
            if (r2 == r8) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r1 = 16
        L_0x00a1:
            if (r2 == r0) goto L_0x00a5
            r8 = 2
            goto L_0x00a6
        L_0x00a5:
            r8 = 3
        L_0x00a6:
            r9 = r9 | r1
            r8 = r8 | r9
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzH(com.google.android.gms.internal.ads.zzmp, com.google.android.gms.internal.ads.zzit):int");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00eb, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzJ(com.google.android.gms.internal.ads.zzml r21, android.media.MediaCodec r22, com.google.android.gms.internal.ads.zzit r23, android.media.MediaCrypto r24) throws com.google.android.gms.internal.ads.zzms {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            com.google.android.gms.internal.ads.zzit[] r3 = r0.zzh
            int r4 = r2.zzj
            int r5 = r2.zzk
            int r6 = zzag(r23)
            int r7 = r3.length
            r8 = -1
            r10 = 1
            if (r7 != r10) goto L_0x001c
            com.google.android.gms.internal.ads.zzqr r3 = new com.google.android.gms.internal.ads.zzqr
            r3.<init>(r4, r5, r6)
            goto L_0x0125
        L_0x001c:
            r12 = 0
            r13 = 0
        L_0x001e:
            if (r12 >= r7) goto L_0x004d
            r14 = r3[r12]
            boolean r15 = r1.zzb
            boolean r15 = zzai(r15, r2, r14)
            if (r15 == 0) goto L_0x0049
            int r15 = r14.zzj
            if (r15 == r8) goto L_0x0035
            int r10 = r14.zzk
            if (r10 != r8) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r10 = 0
            goto L_0x0036
        L_0x0035:
            r10 = 1
        L_0x0036:
            r13 = r13 | r10
            int r4 = java.lang.Math.max(r4, r15)
            int r10 = r14.zzk
            int r5 = java.lang.Math.max(r5, r10)
            int r10 = zzag(r14)
            int r6 = java.lang.Math.max(r6, r10)
        L_0x0049:
            int r12 = r12 + 1
            r10 = 1
            goto L_0x001e
        L_0x004d:
            if (r13 == 0) goto L_0x0120
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r7 = 66
            r3.<init>(r7)
            java.lang.String r7 = "Resolutions unknown. Codec max resolution: "
            r3.append(r7)
            r3.append(r4)
            java.lang.String r7 = "x"
            r3.append(r7)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r10 = "MediaCodecVideoRenderer"
            android.util.Log.w(r10, r3)
            int r3 = r2.zzk
            int r12 = r2.zzj
            if (r3 <= r12) goto L_0x0077
            r13 = r3
            goto L_0x0078
        L_0x0077:
            r13 = r12
        L_0x0078:
            if (r3 > r12) goto L_0x007c
            r14 = r3
            goto L_0x007d
        L_0x007c:
            r14 = r12
        L_0x007d:
            float r15 = (float) r14
            float r9 = (float) r13
            float r15 = r15 / r9
            int[] r9 = zzb
            int r11 = r9.length
            r11 = 0
        L_0x0084:
            r8 = 9
            if (r11 >= r8) goto L_0x00eb
            r8 = r9[r11]
            r16 = r9
            float r9 = (float) r8
            float r9 = r9 * r15
            int r9 = (int) r9
            if (r8 <= r13) goto L_0x00eb
            if (r9 > r14) goto L_0x0095
            goto L_0x00eb
        L_0x0095:
            r17 = r13
            int r13 = com.google.android.gms.internal.ads.zzqj.zza
            r18 = r14
            r14 = 21
            if (r13 < r14) goto L_0x00bd
            if (r3 > r12) goto L_0x00a3
            r13 = r8
            goto L_0x00a4
        L_0x00a3:
            r13 = r9
        L_0x00a4:
            if (r3 > r12) goto L_0x00a7
            r8 = r9
        L_0x00a7:
            android.graphics.Point r8 = r1.zzf(r13, r8)
            float r9 = r2.zzl
            int r13 = r8.x
            int r14 = r8.y
            r19 = r8
            double r8 = (double) r9
            boolean r8 = r1.zze(r13, r14, r8)
            if (r8 == 0) goto L_0x00e2
            r8 = r19
            goto L_0x00ec
        L_0x00bd:
            r13 = 16
            int r8 = com.google.android.gms.internal.ads.zzqj.zze(r8, r13)
            int r8 = r8 * 16
            int r9 = com.google.android.gms.internal.ads.zzqj.zze(r9, r13)
            int r9 = r9 * 16
            int r13 = r8 * r9
            int r14 = com.google.android.gms.internal.ads.zzmw.zzc()
            if (r13 > r14) goto L_0x00e2
            if (r3 > r12) goto L_0x00d7
            r11 = r8
            goto L_0x00d8
        L_0x00d7:
            r11 = r9
        L_0x00d8:
            if (r3 > r12) goto L_0x00db
            r8 = r9
        L_0x00db:
            android.graphics.Point r3 = new android.graphics.Point
            r3.<init>(r11, r8)
            r8 = r3
            goto L_0x00ec
        L_0x00e2:
            int r11 = r11 + 1
            r9 = r16
            r13 = r17
            r14 = r18
            goto L_0x0084
        L_0x00eb:
            r8 = 0
        L_0x00ec:
            if (r8 == 0) goto L_0x0120
            int r3 = r8.x
            int r4 = java.lang.Math.max(r4, r3)
            int r3 = r8.y
            int r5 = java.lang.Math.max(r5, r3)
            java.lang.String r3 = r2.zzf
            int r3 = zzah(r3, r4, r5)
            int r6 = java.lang.Math.max(r6, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r8 = 57
            r3.<init>(r8)
            java.lang.String r8 = "Codec max resolution adjusted to: "
            r3.append(r8)
            r3.append(r4)
            r3.append(r7)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            android.util.Log.w(r10, r3)
        L_0x0120:
            com.google.android.gms.internal.ads.zzqr r3 = new com.google.android.gms.internal.ads.zzqr
            r3.<init>(r4, r5, r6)
        L_0x0125:
            r0.zzi = r3
            boolean r4 = r0.zzf
            android.media.MediaFormat r2 = r23.zzl()
            int r5 = r3.zza
            java.lang.String r6 = "max-width"
            r2.setInteger(r6, r5)
            int r5 = r3.zzb
            java.lang.String r6 = "max-height"
            r2.setInteger(r6, r5)
            int r3 = r3.zzc
            r5 = -1
            if (r3 == r5) goto L_0x0145
            java.lang.String r5 = "max-input-size"
            r2.setInteger(r5, r3)
        L_0x0145:
            if (r4 == 0) goto L_0x014d
            java.lang.String r3 = "auto-frc"
            r4 = 0
            r2.setInteger(r3, r4)
        L_0x014d:
            android.view.Surface r3 = r0.zzj
            if (r3 != 0) goto L_0x016c
            boolean r3 = r1.zzd
            boolean r3 = r0.zzT(r3)
            com.google.android.gms.internal.ads.zzpu.zzd(r3)
            android.view.Surface r3 = r0.zzk
            if (r3 != 0) goto L_0x0168
            android.content.Context r3 = r0.zzc
            boolean r1 = r1.zzd
            com.google.android.gms.internal.ads.zzqp r1 = com.google.android.gms.internal.ads.zzqp.zzb(r3, r1)
            r0.zzk = r1
        L_0x0168:
            android.view.Surface r1 = r0.zzk
            r0.zzj = r1
        L_0x016c:
            android.view.Surface r1 = r0.zzj
            r3 = r22
            r4 = 0
            r5 = 0
            r3.configure(r2, r1, r4, r5)
            int r1 = com.google.android.gms.internal.ads.zzqj.zza
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzJ(com.google.android.gms.internal.ads.zzml, android.media.MediaCodec, com.google.android.gms.internal.ads.zzit, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public final void zzK(String str, long j, long j2) {
        this.zze.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzL(zzit zzit) throws zzif {
        super.zzL(zzit);
        this.zze.zzc(zzit);
        float f = zzit.zzn;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.zzr = f;
        this.zzq = zzaj(zzit);
    }

    /* access modifiers changed from: protected */
    public final void zzM(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = false;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z = true;
        }
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzs = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzt = i2;
        float f = this.zzr;
        this.zzv = f;
        if (zzqj.zza >= 21) {
            int i3 = this.zzq;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzs;
                this.zzs = i2;
                this.zzt = i4;
                this.zzv = 1.0f / f;
            }
        } else {
            this.zzu = this.zzq;
        }
        mediaCodec.setVideoScalingMode(1);
    }

    /* access modifiers changed from: protected */
    public final void zzN(MediaCodec mediaCodec, int i, long j) {
        zzqh.zza("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzqh.zzb();
        this.zza.zze++;
    }

    /* access modifiers changed from: protected */
    public final void zzO(MediaCodec mediaCodec, int i, long j) {
        zzac();
        zzqh.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzqh.zzb();
        this.zza.zzd++;
        this.zzp = 0;
        zzS();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void zzP(MediaCodec mediaCodec, int i, long j, long j2) {
        zzac();
        zzqh.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzqh.zzb();
        this.zza.zzd++;
        this.zzp = 0;
        zzS();
    }

    /* access modifiers changed from: protected */
    public final boolean zzQ(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzB;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzg;
            long j5 = jArr[0];
            if (j4 < j5) {
                break;
            }
            this.zzA = j5;
            int i5 = i4 - 1;
            this.zzB = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j6 = j4 - this.zzA;
        if (z) {
            zzN(mediaCodec2, i3, j6);
            return true;
        }
        long j7 = j4 - j;
        if (this.zzj == this.zzk) {
            if (!zzaf(j7)) {
                return false;
            }
            zzN(mediaCodec2, i3, j6);
            return true;
        } else if (!this.zzl) {
            if (zzqj.zza >= 21) {
                zzP(mediaCodec, i, j6, System.nanoTime());
            } else {
                zzO(mediaCodec2, i3, j6);
            }
            return true;
        } else if (zze() != 2) {
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long nanoTime = System.nanoTime();
            long zzc2 = this.zzd.zzc(j4, ((j7 - ((elapsedRealtime * 1000) - j2)) * 1000) + nanoTime);
            long j8 = (zzc2 - nanoTime) / 1000;
            if (zzaf(j8)) {
                zzqh.zza("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzqh.zzb();
                zzkl zzkl = this.zza;
                zzkl.zzf++;
                this.zzo++;
                int i6 = this.zzp + 1;
                this.zzp = i6;
                zzkl.zzg = Math.max(i6, zzkl.zzg);
                if (this.zzo == -1) {
                    zzae();
                }
                return true;
            }
            if (zzqj.zza >= 21) {
                if (j8 < 50000) {
                    zzP(mediaCodec, i, j6, zzc2);
                    return true;
                }
            } else if (j8 < 30000) {
                if (j8 > 11000) {
                    try {
                        Thread.sleep((j8 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzO(mediaCodec2, i3, j6);
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzS() {
        if (!this.zzl) {
            this.zzl = true;
            this.zze.zzf(this.zzj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzV(zzml zzml) {
        return this.zzj != null || zzT(zzml.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzY() {
        try {
            super.zzY();
        } finally {
            Surface surface = this.zzk;
            if (surface != null) {
                if (this.zzj == surface) {
                    this.zzj = null;
                }
                surface.release();
                this.zzk = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzZ(zzkm zzkm) {
        int i = zzqj.zza;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaa(MediaCodec mediaCodec, boolean z, zzit zzit, zzit zzit2) {
        if (!zzai(z, zzit, zzit2)) {
            return false;
        }
        int i = zzit2.zzj;
        zzqr zzqr = this.zzi;
        return i <= zzqr.zza && zzit2.zzk <= zzqr.zzb && zzit2.zzg <= zzqr.zzc;
    }

    public final void zzr(int i, Object obj) throws zzif {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzk;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzml zzX = zzX();
                    if (zzX != null && zzT(zzX.zzd)) {
                        surface = zzqp.zzb(this.zzc, zzX.zzd);
                        this.zzk = surface;
                    }
                }
            }
            if (this.zzj != surface) {
                this.zzj = surface;
                int zze2 = zze();
                if (zze2 == 1 || zze2 == 2) {
                    MediaCodec zzW = zzW();
                    if (zzqj.zza < 23 || zzW == null || surface == null) {
                        zzY();
                        zzU();
                    } else {
                        zzW.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzk) {
                    zzab();
                    this.zzl = false;
                    int i2 = zzqj.zza;
                    return;
                }
                zzad();
                this.zzl = false;
                int i3 = zzqj.zza;
                if (zze2 == 2) {
                    this.zzm = -9223372036854775807L;
                }
            } else if (surface != null && surface != this.zzk) {
                zzad();
                if (this.zzl) {
                    this.zze.zzf(this.zzj);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzs(boolean z) throws zzif {
        super.zzs(z);
        int i = zzy().zzb;
        this.zze.zza(this.zza);
        this.zzd.zza();
    }

    /* access modifiers changed from: protected */
    public final void zzt(zzit[] zzitArr, long j) throws zzif {
        this.zzh = zzitArr;
        if (this.zzA == -9223372036854775807L) {
            this.zzA = j;
            return;
        }
        int i = this.zzB;
        if (i == 10) {
            long j2 = this.zzg[9];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j2);
            Log.w("MediaCodecVideoRenderer", sb.toString());
        } else {
            this.zzB = i + 1;
        }
        this.zzg[this.zzB - 1] = j;
    }

    /* access modifiers changed from: protected */
    public final void zzu(long j, boolean z) throws zzif {
        super.zzu(j, z);
        this.zzl = false;
        int i = zzqj.zza;
        this.zzp = 0;
        int i2 = this.zzB;
        if (i2 != 0) {
            this.zzA = this.zzg[i2 - 1];
            this.zzB = 0;
        }
        this.zzm = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void zzv() {
        this.zzo = 0;
        this.zzn = SystemClock.elapsedRealtime();
        this.zzm = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        zzae();
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        this.zzs = -1;
        this.zzt = -1;
        this.zzv = -1.0f;
        this.zzr = -1.0f;
        this.zzA = -9223372036854775807L;
        this.zzB = 0;
        zzab();
        this.zzl = false;
        int i = zzqj.zza;
        this.zzd.zzb();
        try {
            super.zzx();
        } finally {
            this.zza.zza();
            this.zze.zzg(this.zza);
        }
    }
}
