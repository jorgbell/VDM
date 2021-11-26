package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zznq implements zznu, zzkv, zzpo, zzoe {
    private long zzA;
    private long zzB;
    private long zzC;
    private int zzD;
    private boolean zzE;
    /* access modifiers changed from: private */
    public boolean zzF;
    private final zzph zzG;
    private final Uri zza;
    private final zzpe zzb;
    private final int zzc;
    private final Handler zzd;
    /* access modifiers changed from: private */
    public final zznr zze;
    private final zznv zzf;
    /* access modifiers changed from: private */
    public final long zzg;
    private final zzps zzh = new zzps("Loader:ExtractorMediaPeriod");
    private final zzno zzi;
    private final zzpw zzj;
    private final Runnable zzk;
    /* access modifiers changed from: private */
    public final Runnable zzl;
    /* access modifiers changed from: private */
    public final Handler zzm;
    /* access modifiers changed from: private */
    public final SparseArray<zzof> zzn;
    /* access modifiers changed from: private */
    public zznt zzo;
    private zzlb zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private zzol zzv;
    private long zzw;
    private boolean[] zzx;
    private boolean[] zzy;
    private boolean zzz;

    public zznq(Uri uri, zzpe zzpe, zzku[] zzkuArr, int i, Handler handler, zznr zznr, zznv zznv, zzph zzph, String str, int i2, byte[] bArr) {
        this.zza = uri;
        this.zzb = zzpe;
        this.zzc = i;
        this.zzd = handler;
        this.zze = zznr;
        this.zzf = zznv;
        this.zzG = zzph;
        this.zzg = (long) i2;
        this.zzi = new zzno(zzkuArr, this);
        this.zzj = new zzpw();
        this.zzk = new zznj(this);
        this.zzl = new zznk(this);
        this.zzm = new Handler();
        this.zzC = -9223372036854775807L;
        this.zzn = new SparseArray<>();
        this.zzA = -1;
    }

    private final void zzC(zznn zznn) {
        if (this.zzA == -1) {
            this.zzA = zznn.zzj;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        r0 = r11.zzp;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzD() {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zznn r6 = new com.google.android.gms.internal.ads.zznn
            android.net.Uri r2 = r11.zza
            com.google.android.gms.internal.ads.zzpe r3 = r11.zzb
            com.google.android.gms.internal.ads.zzno r4 = r11.zzi
            com.google.android.gms.internal.ads.zzpw r5 = r11.zzj
            r0 = r6
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            boolean r0 = r11.zzr
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0041
            boolean r0 = r11.zzG()
            com.google.android.gms.internal.ads.zzpu.zzd(r0)
            long r3 = r11.zzw
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0032
            long r7 = r11.zzC
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x002c
            goto L_0x0032
        L_0x002c:
            r0 = 1
            r11.zzE = r0
            r11.zzC = r1
            return
        L_0x0032:
            com.google.android.gms.internal.ads.zzlb r0 = r11.zzp
            long r3 = r11.zzC
            long r3 = r0.zzc(r3)
            long r7 = r11.zzC
            r6.zza(r3, r7)
            r11.zzC = r1
        L_0x0041:
            int r0 = r11.zzE()
            r11.zzD = r0
            int r0 = r11.zzc
            r3 = -1
            r4 = 6
            r5 = 3
            if (r0 != r3) goto L_0x006a
            boolean r0 = r11.zzr
            if (r0 == 0) goto L_0x0069
            long r7 = r11.zzA
            r9 = -1
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzlb r0 = r11.zzp
            if (r0 == 0) goto L_0x0067
            long r7 = r0.zzb()
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r0 = 6
            goto L_0x006a
        L_0x0069:
            r0 = 3
        L_0x006a:
            com.google.android.gms.internal.ads.zzps r1 = r11.zzh
            r1.zza(r6, r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznq.zzD():void");
    }

    private final int zzE() {
        int size = this.zzn.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzn.valueAt(i2).zzf();
        }
        return i;
    }

    private final long zzF() {
        int size = this.zzn.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzn.valueAt(i).zzj());
        }
        return j;
    }

    private final boolean zzG() {
        return this.zzC != -9223372036854775807L;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static /* synthetic */ void zzt(com.google.android.gms.internal.ads.zznq r8) {
        /*
            boolean r0 = r8.zzF
            if (r0 != 0) goto L_0x009c
            boolean r0 = r8.zzr
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzlb r0 = r8.zzp
            if (r0 == 0) goto L_0x009c
            boolean r0 = r8.zzq
            if (r0 != 0) goto L_0x0012
            goto L_0x009c
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzof> r0 = r8.zzn
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002d
            android.util.SparseArray<com.google.android.gms.internal.ads.zzof> r3 = r8.zzn
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzof r3 = (com.google.android.gms.internal.ads.zzof) r3
            com.google.android.gms.internal.ads.zzit r3 = r3.zzi()
            if (r3 == 0) goto L_0x009c
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002d:
            com.google.android.gms.internal.ads.zzpw r2 = r8.zzj
            r2.zzb()
            com.google.android.gms.internal.ads.zzok[] r2 = new com.google.android.gms.internal.ads.zzok[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzy = r3
            boolean[] r3 = new boolean[r0]
            r8.zzx = r3
            com.google.android.gms.internal.ads.zzlb r3 = r8.zzp
            long r3 = r3.zzb()
            r8.zzw = r3
            r3 = 0
        L_0x0045:
            r4 = 1
            if (r3 >= r0) goto L_0x007b
            android.util.SparseArray<com.google.android.gms.internal.ads.zzof> r5 = r8.zzn
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzof r5 = (com.google.android.gms.internal.ads.zzof) r5
            com.google.android.gms.internal.ads.zzit r5 = r5.zzi()
            com.google.android.gms.internal.ads.zzok r6 = new com.google.android.gms.internal.ads.zzok
            com.google.android.gms.internal.ads.zzit[] r7 = new com.google.android.gms.internal.ads.zzit[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzf
            boolean r6 = com.google.android.gms.internal.ads.zzpz.zzb(r5)
            if (r6 != 0) goto L_0x006f
            boolean r5 = com.google.android.gms.internal.ads.zzpz.zza(r5)
            if (r5 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r4 = 0
        L_0x006f:
            boolean[] r5 = r8.zzy
            r5[r3] = r4
            boolean r5 = r8.zzz
            r4 = r4 | r5
            r8.zzz = r4
            int r3 = r3 + 1
            goto L_0x0045
        L_0x007b:
            com.google.android.gms.internal.ads.zzol r0 = new com.google.android.gms.internal.ads.zzol
            r0.<init>(r2)
            r8.zzv = r0
            r8.zzr = r4
            com.google.android.gms.internal.ads.zznv r0 = r8.zzf
            com.google.android.gms.internal.ads.zzoj r1 = new com.google.android.gms.internal.ads.zzoj
            long r2 = r8.zzw
            com.google.android.gms.internal.ads.zzlb r4 = r8.zzp
            boolean r4 = r4.zza()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzi(r1, r2)
            com.google.android.gms.internal.ads.zznt r0 = r8.zzo
            r0.zzbh(r8)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznq.zzt(com.google.android.gms.internal.ads.zznq):void");
    }

    public final long zzB(zzop[] zzopArr, boolean[] zArr, zzog[] zzogArr, boolean[] zArr2, long j) {
        zzop zzop;
        zzpu.zzd(this.zzr);
        for (int i = 0; i < zzopArr.length; i++) {
            zznp zznp = zzogArr[i];
            if (zznp != null && (zzopArr[i] == null || !zArr[i])) {
                int zze2 = zznp.zzb;
                zzpu.zzd(this.zzx[zze2]);
                this.zzu--;
                this.zzx[zze2] = false;
                this.zzn.valueAt(zze2).zzg();
                zzogArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzopArr.length; i2++) {
            if (zzogArr[i2] == null && (zzop = zzopArr[i2]) != null) {
                zzpu.zzd(zzop.zzb() == 1);
                zzpu.zzd(zzop.zzd(0) == 0);
                int zzb2 = this.zzv.zzb(zzop.zza());
                zzpu.zzd(!this.zzx[zzb2]);
                this.zzu++;
                this.zzx[zzb2] = true;
                zzogArr[i2] = new zznp(this, zzb2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.zzs) {
            int size = this.zzn.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.zzx[i3]) {
                    this.zzn.valueAt(i3).zzg();
                }
            }
        }
        if (this.zzu == 0) {
            this.zzt = false;
            if (this.zzh.zzb()) {
                this.zzh.zzc();
            }
        } else if (!this.zzs ? j != 0 : z) {
            j = zzk(j);
            for (int i4 = 0; i4 < zzogArr.length; i4++) {
                if (zzogArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.zzs = true;
        return j;
    }

    public final long zza() {
        if (this.zzu == 0) {
            return Long.MIN_VALUE;
        }
        return zzj();
    }

    public final boolean zzb(long j) {
        if (this.zzE) {
            return false;
        }
        if (this.zzr && this.zzu == 0) {
            return false;
        }
        boolean zza2 = this.zzj.zza();
        if (this.zzh.zzb()) {
            return zza2;
        }
        zzD();
        return true;
    }

    public final zzld zzbf(int i, int i2) {
        zzof zzof = this.zzn.get(i);
        if (zzof != null) {
            return zzof;
        }
        zzof zzof2 = new zzof(this.zzG, (byte[]) null);
        zzof2.zzn(this);
        this.zzn.put(i, zzof2);
        return zzof2;
    }

    public final void zzbg() {
        this.zzq = true;
        this.zzm.post(this.zzk);
    }

    public final void zzc(zzlb zzlb) {
        this.zzp = zzlb;
        this.zzm.post(this.zzk);
    }

    public final void zzd() {
        this.zzh.zzd(new zznl(this, this.zzi));
        this.zzm.removeCallbacksAndMessages((Object) null);
        this.zzF = true;
    }

    public final void zze(zznt zznt, long j) {
        this.zzo = zznt;
        this.zzj.zza();
        zzD();
    }

    public final void zzf() throws IOException {
        this.zzh.zze(Integer.MIN_VALUE);
    }

    public final zzol zzg() {
        return this.zzv;
    }

    public final void zzh(long j) {
    }

    public final long zzi() {
        if (!this.zzt) {
            return -9223372036854775807L;
        }
        this.zzt = false;
        return this.zzB;
    }

    public final long zzj() {
        long j;
        if (this.zzE) {
            return Long.MIN_VALUE;
        }
        if (zzG()) {
            return this.zzC;
        }
        if (this.zzz) {
            int size = this.zzn.size();
            j = Long.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (this.zzy[i]) {
                    j = Math.min(j, this.zzn.valueAt(i).zzj());
                }
            }
        } else {
            j = zzF();
        }
        return j == Long.MIN_VALUE ? this.zzB : j;
    }

    public final long zzk(long j) {
        if (true != this.zzp.zza()) {
            j = 0;
        }
        this.zzB = j;
        int size = this.zzn.size();
        boolean zzG2 = true ^ zzG();
        int i = 0;
        while (true) {
            if (zzG2) {
                if (i >= size) {
                    break;
                }
                if (this.zzx[i]) {
                    zzG2 = this.zzn.valueAt(i).zzl(j, false);
                }
                i++;
            } else {
                this.zzC = j;
                this.zzE = false;
                if (this.zzh.zzb()) {
                    this.zzh.zzc();
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        this.zzn.valueAt(i2).zze(this.zzx[i2]);
                    }
                }
            }
        }
        this.zzt = false;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl(int i) {
        return this.zzE || (!zzG() && this.zzn.valueAt(i).zzh());
    }

    /* access modifiers changed from: package-private */
    public final void zzm() throws IOException {
        this.zzh.zze(Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public final int zzn(int i, zziu zziu, zzkm zzkm, boolean z) {
        if (this.zzt || zzG()) {
            return -3;
        }
        return this.zzn.valueAt(i).zzm(zziu, zzkm, z, this.zzE, this.zzB);
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i, long j) {
        zzof valueAt = this.zzn.valueAt(i);
        if (!this.zzE || j <= valueAt.zzj()) {
            valueAt.zzl(j, true);
        } else {
            valueAt.zzk();
        }
    }

    public final void zzp(zzit zzit) {
        this.zzm.post(this.zzk);
    }

    public final /* bridge */ /* synthetic */ int zzq(zzpq zzpq, long j, long j2, IOException iOException) {
        zzlb zzlb;
        zznn zznn = (zznn) zzpq;
        zzC(zznn);
        Handler handler = this.zzd;
        if (handler != null) {
            handler.post(new zznm(this, iOException));
        }
        if (iOException instanceof zzom) {
            return 3;
        }
        int zzE2 = zzE();
        int i = this.zzD;
        if (this.zzA == -1 && ((zzlb = this.zzp) == null || zzlb.zzb() == -9223372036854775807L)) {
            this.zzB = 0;
            this.zzt = this.zzr;
            int size = this.zzn.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.zzn.valueAt(i2).zze(!this.zzr || this.zzx[i2]);
            }
            zznn.zza(0, 0);
        }
        this.zzD = zzE();
        if (zzE2 <= i) {
            return 0;
        }
        return 1;
    }

    public final /* bridge */ /* synthetic */ void zzr(zzpq zzpq, long j, long j2, boolean z) {
        zzC((zznn) zzpq);
        if (!z && this.zzu > 0) {
            int size = this.zzn.size();
            for (int i = 0; i < size; i++) {
                this.zzn.valueAt(i).zze(this.zzx[i]);
            }
            this.zzo.zzn(this);
        }
    }

    public final /* bridge */ /* synthetic */ void zzs(zzpq zzpq, long j, long j2) {
        zzC((zznn) zzpq);
        this.zzE = true;
        if (this.zzw == -9223372036854775807L) {
            long zzF2 = zzF();
            long j3 = zzF2 == Long.MIN_VALUE ? 0 : zzF2 + 10000;
            this.zzw = j3;
            this.zzf.zzi(new zzoj(j3, this.zzp.zza()), (Object) null);
        }
        this.zzo.zzn(this);
    }
}
