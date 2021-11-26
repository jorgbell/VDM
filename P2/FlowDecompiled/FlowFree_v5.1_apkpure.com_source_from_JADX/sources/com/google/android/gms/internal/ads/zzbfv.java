package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.List;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbfv extends zzbfn implements zzbev {
    private zzbew zze;
    private String zzf;
    private boolean zzg;
    private Exception zzh;
    private boolean zzi;

    public zzbfv(zzbdp zzbdp, zzbdo zzbdo) {
        super(zzbdp);
        zzbew zzbew = new zzbew(zzbdp.getContext(), zzbdo, (zzbdp) this.zzc.get());
        this.zze = zzbew;
        zzbew.zzr(this);
    }

    protected static final String zzk(String str) {
        String valueOf = String.valueOf(zzbbd.zzd(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    private final void zzp(String str) {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str2 = this.zzf;
        if (str2 != null) {
            String zzk = zzk(str2);
            Exception exc = this.zzh;
            if (exc != null) {
                zzn(this.zzf, zzk, "badUrl", zzq(str, exc));
            } else {
                zzn(this.zzf, zzk, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    private static String zzq(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    public final void release() {
        zzbew zzbew = this.zze;
        if (zzbew != null) {
            zzbew.zzr((zzbev) null);
            this.zze.zzv();
        }
    }

    public final void zzA(int i) {
    }

    public final void zzB(int i, int i2) {
    }

    public final void zzC(String str, Exception exc) {
        String str2 = (String) zzaaa.zzc().zzb(zzaeq.zzl);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzh = exc;
        zzbbk.zzj("Precache error", exc);
        zzp(str);
    }

    public final void zzD(String str, Exception exc) {
        zzbbk.zzj("Precache exception", exc);
    }

    public final boolean zza(String str) {
        return zzb(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0096, code lost:
        r0 = r15.zzh;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0098, code lost:
        if (r0 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a6, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a8, code lost:
        r17 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b6, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014c, code lost:
        r5 = r45;
        r6 = r46;
        r7 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r5.zzm(r6, r7, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(java.lang.String r46, java.lang.String[] r47) {
        /*
            r45 = this;
            r15 = r45
            r13 = r46
            r0 = r47
            r15.zzf = r13
            java.lang.String r14 = zzk(r46)
            java.lang.String r17 = "error"
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01d1 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01d1 }
            r2 = 0
        L_0x0014:
            int r3 = r0.length     // Catch:{ Exception -> 0x01d1 }
            if (r2 >= r3) goto L_0x0022
            r3 = r0[r2]     // Catch:{ Exception -> 0x01d1 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x01d1 }
            r1[r2] = r3     // Catch:{ Exception -> 0x01d1 }
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0022:
            com.google.android.gms.internal.ads.zzbew r0 = r15.zze     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r2 = r15.zzb     // Catch:{ Exception -> 0x01d1 }
            r0.zzt(r1, r2)     // Catch:{ Exception -> 0x01d1 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbdp> r0 = r15.zzc     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbdp r0 = (com.google.android.gms.internal.ads.zzbdp) r0     // Catch:{ Exception -> 0x01d1 }
            if (r0 == 0) goto L_0x0036
            r0.zzu(r14, r15)     // Catch:{ Exception -> 0x01d1 }
        L_0x0036:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ Exception -> 0x01d1 }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzaeq.zzu     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d1 }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzaeq.zzt     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d1 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01d1 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzaeq.zzs     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01d1 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01d1 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaeq.zzbj     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01d1 }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01d1 }
            r22 = -1
            r1 = r22
        L_0x0087:
            monitor-enter(r45)     // Catch:{ Exception -> 0x01d1 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x01ca }
            long r3 = r3 - r19
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x019d
            boolean r3 = r15.zzg     // Catch:{ all -> 0x01ca }
            if (r3 == 0) goto L_0x00af
            java.lang.Exception r0 = r15.zzh     // Catch:{ all -> 0x01ca }
            if (r0 == 0) goto L_0x009d
            java.lang.String r1 = "badUrl"
            throw r0     // Catch:{ all -> 0x00a7 }
        L_0x009d:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x00a7 }
            throw r0     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r0 = move-exception
            r17 = r1
        L_0x00aa:
            r6 = r13
            r7 = r14
            r5 = r15
            goto L_0x01cd
        L_0x00af:
            boolean r3 = r15.zzi     // Catch:{ all -> 0x01ca }
            r24 = 1
            if (r3 == 0) goto L_0x00b9
            monitor-exit(r45)     // Catch:{ all -> 0x01ca }
            r5 = r15
            goto L_0x016c
        L_0x00b9:
            com.google.android.gms.internal.ads.zzbew r3 = r15.zze     // Catch:{ all -> 0x01ca }
            com.google.android.gms.internal.ads.zzij r3 = r3.zzo()     // Catch:{ all -> 0x01ca }
            if (r3 == 0) goto L_0x0190
            long r4 = r3.zzl()     // Catch:{ all -> 0x01ca }
            r25 = 0
            int r8 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r8 <= 0) goto L_0x0170
            long r27 = r3.zzn()     // Catch:{ all -> 0x01ca }
            int r3 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x013f
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x00d9
            r8 = 1
            goto L_0x00da
        L_0x00d9:
            r8 = 0
        L_0x00da:
            if (r21 == 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzbew r1 = r15.zze     // Catch:{ all -> 0x01ca }
            long r1 = r1.zzx()     // Catch:{ all -> 0x01ca }
            r29 = r1
            goto L_0x00e7
        L_0x00e5:
            r29 = r22
        L_0x00e7:
            if (r21 == 0) goto L_0x00f2
            com.google.android.gms.internal.ads.zzbew r1 = r15.zze     // Catch:{ all -> 0x01ca }
            long r1 = r1.zzy()     // Catch:{ all -> 0x01ca }
            r31 = r1
            goto L_0x00f4
        L_0x00f2:
            r31 = r22
        L_0x00f4:
            if (r21 == 0) goto L_0x00ff
            com.google.android.gms.internal.ads.zzbew r1 = r15.zze     // Catch:{ all -> 0x01ca }
            long r1 = r1.zzz()     // Catch:{ all -> 0x01ca }
            r33 = r1
            goto L_0x0101
        L_0x00ff:
            r33 = r22
        L_0x0101:
            int r16 = com.google.android.gms.internal.ads.zzbew.zzp()     // Catch:{ all -> 0x0137 }
            int r35 = com.google.android.gms.internal.ads.zzbew.zzq()     // Catch:{ all -> 0x0137 }
            r1 = r45
            r2 = r46
            r3 = r14
            r36 = r4
            r4 = r27
            r38 = r6
            r6 = r36
            r40 = r9
            r9 = r29
            r42 = r11
            r11 = r31
            r44 = r14
            r13 = r33
            r15 = r16
            r16 = r35
            r1.zzh(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x012e }
            r1 = r27
            r3 = r36
            goto L_0x0148
        L_0x012e:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r44
            goto L_0x01cd
        L_0x0137:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r14
            goto L_0x01cd
        L_0x013f:
            r38 = r6
            r40 = r9
            r42 = r11
            r44 = r14
            r3 = r4
        L_0x0148:
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0157
            r5 = r45
            r6 = r46
            r7 = r44
            r5.zzm(r6, r7, r3)     // Catch:{ all -> 0x01c8 }
            monitor-exit(r45)     // Catch:{ all -> 0x01c8 }
            goto L_0x016c
        L_0x0157:
            r5 = r45
            r6 = r46
            r7 = r44
            com.google.android.gms.internal.ads.zzbew r3 = r5.zze     // Catch:{ all -> 0x01c8 }
            long r3 = r3.zzw()     // Catch:{ all -> 0x01c8 }
            int r8 = (r3 > r38 ? 1 : (r3 == r38 ? 0 : -1))
            if (r8 < 0) goto L_0x016d
            int r3 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x016d
            monitor-exit(r45)     // Catch:{ all -> 0x01c8 }
        L_0x016c:
            return r24
        L_0x016d:
            r3 = r42
            goto L_0x0178
        L_0x0170:
            r38 = r6
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            r3 = r11
        L_0x0178:
            r5.wait(r3)     // Catch:{ InterruptedException -> 0x0186 }
            monitor-exit(r45)     // Catch:{ all -> 0x01c8 }
            r11 = r3
            r15 = r5
            r13 = r6
            r14 = r7
            r6 = r38
            r9 = r40
            goto L_0x0087
        L_0x0186:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x0190:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x019d:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r3 = 47
            r2.<init>(r3)     // Catch:{ all -> 0x01c4 }
            java.lang.String r3 = "Timeout reached. Limit: "
            r2.append(r3)     // Catch:{ all -> 0x01c4 }
            r3 = r40
            r2.append(r3)     // Catch:{ all -> 0x01c4 }
            java.lang.String r3 = " ms"
            r2.append(r3)     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01c4 }
            r0.<init>(r2)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x01c4:
            r0 = move-exception
            r17 = r1
            goto L_0x01cd
        L_0x01c8:
            r0 = move-exception
            goto L_0x01cd
        L_0x01ca:
            r0 = move-exception
            goto L_0x00aa
        L_0x01cd:
            monitor-exit(r45)     // Catch:{ all -> 0x01c8 }
            throw r0     // Catch:{ Exception -> 0x01cf }
        L_0x01cf:
            r0 = move-exception
            goto L_0x01d5
        L_0x01d1:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01d5:
            r1 = r17
            java.lang.String r2 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r46)
            int r3 = r3.length()
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r3 = r3 + 34
            int r3 = r3 + r4
            r8.<init>(r3)
            java.lang.String r3 = "Failed to preload url "
            r8.append(r3)
            r8.append(r6)
            java.lang.String r3 = " Exception: "
            r8.append(r3)
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            com.google.android.gms.internal.ads.zzbbk.zzi(r2)
            r45.release()
            java.lang.String r0 = zzq(r1, r0)
            r5.zzn(r6, r7, r1, r0)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfv.zzb(java.lang.String, java.lang.String[]):boolean");
    }

    public final void zzc(int i) {
        this.zze.zzs().zzh(i);
    }

    public final void zzd(int i) {
        this.zze.zzs().zzg(i);
    }

    public final void zze(int i) {
        this.zze.zzs().zzi(i);
    }

    public final void zzf(int i) {
        this.zze.zzs().zzj(i);
    }

    public final void zzg() {
        zzp((String) null);
    }

    public final zzbew zzj() {
        synchronized (this) {
            this.zzi = true;
            notify();
        }
        this.zze.zzr((zzbev) null);
        zzbew zzbew = this.zze;
        this.zze = null;
        return zzbew;
    }

    public final void zzt(boolean z, long j) {
        zzbdp zzbdp = (zzbdp) this.zzc.get();
        if (zzbdp != null) {
            zzbbw.zze.execute(new zzbfu(zzbdp, z, j));
        }
    }
}
