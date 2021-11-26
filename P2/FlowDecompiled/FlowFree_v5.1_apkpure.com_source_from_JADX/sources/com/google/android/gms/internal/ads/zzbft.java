package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbft extends zzbfn implements zzpt<zzpe> {
    private String zzd;
    private final zzbdo zze;
    private boolean zzf;
    private final zzbfs zzg = new zzbfs();
    private final zzbez zzh = new zzbez();
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk = new Object();
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzbft(zzbdp zzbdp, zzbdo zzbdo) {
        super(zzbdp);
        this.zze = zzbdo;
        this.zzl = zzbdp != null ? zzbdp.zzn() : "";
        this.zzm = zzbdp != null ? zzbdp.zzp() : 0;
    }

    protected static final String zzs(String str) {
        String valueOf = String.valueOf(zzbbd.zzd(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    private final void zzt() {
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round(((float) zza2) * (((float) position) / ((float) zza)));
        boolean z = round > 0;
        int zzp = zzbew.zzp();
        int zzq = zzbew.zzq();
        String str = this.zzd;
        zzi(str, zzs(str), position, zza, (long) round, (long) zza2, z, zzp, zzq);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.internal.ads.zzpi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzpi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: com.google.android.gms.internal.ads.zzbek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.google.android.gms.internal.ads.zzpi} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d0, code lost:
        if (r9.zzi.remaining() > 0) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d2, code lost:
        zzt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d9, code lost:
        if (r9.zzf != false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00db, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e3, code lost:
        if ((r12 - r16) < r4) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e5, code lost:
        zzt();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f1, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0 = new java.lang.StringBuilder(49);
        r0.append("Timeout exceeded. Limit: ");
        r0.append(r6);
        r0.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0118, code lost:
        throw new java.io.IOException(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0119, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1 = r9.zzi.limit();
        r2 = new java.lang.StringBuilder(35);
        r2.append("Precache abort at ");
        r2.append(r1);
        r2.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0140, code lost:
        throw new java.io.IOException(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0141, code lost:
        r0 = e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r27) {
        /*
            r26 = this;
            r9 = r26
            r10 = r27
            r9.zzd = r10
            java.lang.String r11 = zzs(r27)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzpi r0 = new com.google.android.gms.internal.ads.zzpi     // Catch:{ Exception -> 0x014a }
            java.lang.String r2 = r9.zzb     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzbdo r1 = r9.zze     // Catch:{ Exception -> 0x014a }
            int r5 = r1.zzd     // Catch:{ Exception -> 0x014a }
            r3 = 0
            int r6 = r1.zzf     // Catch:{ Exception -> 0x014a }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzbdo r1 = r9.zze     // Catch:{ Exception -> 0x014a }
            boolean r1 = r1.zzj     // Catch:{ Exception -> 0x014a }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzbek r8 = new com.google.android.gms.internal.ads.zzbek     // Catch:{ Exception -> 0x014a }
            android.content.Context r2 = r9.zza     // Catch:{ Exception -> 0x014a }
            java.lang.String r4 = r9.zzl     // Catch:{ Exception -> 0x014a }
            int r5 = r9.zzm     // Catch:{ Exception -> 0x014a }
            r6 = 0
            r7 = 0
            r1 = r8
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x014a }
            r0 = r8
        L_0x0036:
            android.net.Uri r16 = android.net.Uri.parse(r27)     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzpg r1 = new com.google.android.gms.internal.ads.zzpg     // Catch:{ Exception -> 0x014a }
            r17 = 0
            r18 = 0
            r20 = 0
            r22 = -1
            r24 = 0
            r25 = 0
            r15 = r1
            r15.<init>(r16, r17, r18, r20, r22, r24, r25)     // Catch:{ Exception -> 0x014a }
            r0.zza(r1)     // Catch:{ Exception -> 0x014a }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbdp> r1 = r9.zzc     // Catch:{ Exception -> 0x014a }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzbdp r1 = (com.google.android.gms.internal.ads.zzbdp) r1     // Catch:{ Exception -> 0x014a }
            if (r1 == 0) goto L_0x005c
            r1.zzu(r11, r9)     // Catch:{ Exception -> 0x014a }
        L_0x005c:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ Exception -> 0x014a }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzaeq.zzu     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzaeo r5 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ Exception -> 0x014a }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ Exception -> 0x014a }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x014a }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzaeq.zzt     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzaeo r7 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ Exception -> 0x014a }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ Exception -> 0x014a }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x014a }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzbdo r8 = r9.zze     // Catch:{ Exception -> 0x014a }
            int r8 = r8.zzc     // Catch:{ Exception -> 0x014a }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x014a }
            r9.zzi = r8     // Catch:{ Exception -> 0x014a }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x014a }
            r16 = r2
        L_0x0094:
            java.nio.ByteBuffer r14 = r9.zzi     // Catch:{ Exception -> 0x014a }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x014a }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x014a }
            int r14 = r0.zzb(r15, r13, r14)     // Catch:{ Exception -> 0x014a }
            r8 = -1
            if (r14 != r8) goto L_0x00b7
            r8 = 1
            r9.zzn = r8     // Catch:{ Exception -> 0x014a }
            com.google.android.gms.internal.ads.zzbez r0 = r9.zzh     // Catch:{ Exception -> 0x014a }
            java.nio.ByteBuffer r1 = r9.zzi     // Catch:{ Exception -> 0x014a }
            long r0 = r0.zza(r1)     // Catch:{ Exception -> 0x014a }
            int r1 = (int) r0     // Catch:{ Exception -> 0x014a }
            long r0 = (long) r1     // Catch:{ Exception -> 0x014a }
            r9.zzm(r10, r11, r0)     // Catch:{ Exception -> 0x014a }
        L_0x00b5:
            r1 = 1
            goto L_0x00d6
        L_0x00b7:
            java.lang.Object r8 = r9.zzk     // Catch:{ Exception -> 0x014a }
            monitor-enter(r8)     // Catch:{ Exception -> 0x014a }
            boolean r13 = r9.zzf     // Catch:{ all -> 0x0145 }
            if (r13 != 0) goto L_0x00c7
            java.nio.ByteBuffer r13 = r9.zzi     // Catch:{ all -> 0x0145 }
            r21 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x0143 }
            goto L_0x00c9
        L_0x00c7:
            r21 = r12
        L_0x00c9:
            monitor-exit(r8)     // Catch:{ all -> 0x0143 }
            java.nio.ByteBuffer r8 = r9.zzi     // Catch:{ Exception -> 0x0141 }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x0141 }
            if (r8 > 0) goto L_0x00d7
            r26.zzt()     // Catch:{ Exception -> 0x0141 }
            goto L_0x00b5
        L_0x00d6:
            return r1
        L_0x00d7:
            boolean r8 = r9.zzf     // Catch:{ Exception -> 0x0141 }
            if (r8 != 0) goto L_0x011b
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0141 }
            long r22 = r12 - r16
            int r8 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00ea
            r26.zzt()     // Catch:{ Exception -> 0x0141 }
            r16 = r12
        L_0x00ea:
            long r12 = r12 - r2
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r6
            int r8 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r8 > 0) goto L_0x00f9
            r12 = r21
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x0094
        L_0x00f9:
            java.lang.String r12 = "downloadTimeout"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0119 }
            r1 = 49
            r0.<init>(r1)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r0.append(r1)     // Catch:{ Exception -> 0x0119 }
            r0.append(r6)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r1 = " sec"
            r0.append(r1)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0119 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0119 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0119 }
            throw r1     // Catch:{ Exception -> 0x0119 }
        L_0x0119:
            r0 = move-exception
            goto L_0x014f
        L_0x011b:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0119 }
            java.nio.ByteBuffer r1 = r9.zzi     // Catch:{ Exception -> 0x0119 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0119 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0119 }
            r3 = 35
            r2.<init>(r3)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r3 = "Precache abort at "
            r2.append(r3)     // Catch:{ Exception -> 0x0119 }
            r2.append(r1)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r1 = " bytes"
            r2.append(r1)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0119 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0119 }
            throw r0     // Catch:{ Exception -> 0x0119 }
        L_0x0141:
            r0 = move-exception
            goto L_0x014d
        L_0x0143:
            r0 = move-exception
            goto L_0x0148
        L_0x0145:
            r0 = move-exception
            r21 = r12
        L_0x0148:
            monitor-exit(r8)     // Catch:{ all -> 0x0143 }
            throw r0     // Catch:{ Exception -> 0x0141 }
        L_0x014a:
            r0 = move-exception
            r21 = r12
        L_0x014d:
            r12 = r21
        L_0x014f:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 1
            int r2 = r2 + r5
            int r2 = r2 + r3
            r4.<init>(r2)
            r4.append(r1)
            java.lang.String r1 = ":"
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = java.lang.String.valueOf(r27)
            int r1 = r1.length()
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = r1 + 34
            int r1 = r1 + r2
            r3.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r3.append(r1)
            r3.append(r10)
            java.lang.String r1 = " Exception: "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbbk.zzi(r1)
            r9.zzn(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbft.zza(java.lang.String):boolean");
    }

    public final void zzg() {
        this.zzf = true;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, zzpg zzpg) {
        this.zzg.zzb((zzpi) obj);
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i) {
    }

    public final String zzp() {
        return this.zzd;
    }

    public final boolean zzq() {
        return this.zzn;
    }

    public final ByteBuffer zzr() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }
}
