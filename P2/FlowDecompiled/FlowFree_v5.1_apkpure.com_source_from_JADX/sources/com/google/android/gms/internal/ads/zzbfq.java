package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbfq extends zzbfn {
    public static final /* synthetic */ int zzd = 0;
    private static final Set<String> zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzbfq(zzbdp zzbdp) {
        super(zzbdp);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            zzbbk.zzi("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String valueOf = String.valueOf(this.zzg.getAbsolutePath());
            zzbbk.zzi(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzg = null;
        } else if (!this.zzg.setReadable(true, false) || !this.zzg.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzg.getAbsolutePath());
            zzbbk.zzi(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzg = null;
        }
    }

    private final File zzj(File file) {
        return new File(this.zzg, String.valueOf(file.getName()).concat(".done"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02a1, code lost:
        r19 = r5.read(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02a5, code lost:
        if (r19 < 0) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02a7, code lost:
        r13 = r13 + r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a9, code lost:
        if (r13 <= r6) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02ab, code lost:
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02bb, code lost:
        if (r1.length() == 0) goto L_0x02c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02bd, code lost:
        r11 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02c8, code lost:
        r11 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02d0, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02d1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02d4, code lost:
        r2 = r11;
        r1 = r14;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02d9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02dc, code lost:
        r11 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        r2.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02e7, code lost:
        if (r3.write(r2) > 0) goto L_0x02e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02e9, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02f8, code lost:
        if ((r16.currentTimeMillis() - r17) > (1000 * r10)) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02fa, code lost:
        r19 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02fe, code lost:
        if (r8.zzh != false) goto L_0x035e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0304, code lost:
        if (r1.zza() == false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0306, code lost:
        r20 = r12.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x030c, code lost:
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0310, code lost:
        r23 = r1;
        r1 = r1;
        r24 = r14;
        r14 = com.google.android.gms.internal.ads.zzbbd.zza;
        r25 = r3;
        r26 = r4;
        r4 = r20;
        r20 = r5;
        r27 = r6;
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzbfh(r29, r30, r4, r13, r7, false);
        r14.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0333, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0335, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0336, code lost:
        r26 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x033a, code lost:
        r23 = r1;
        r25 = r3;
        r26 = r4;
        r20 = r5;
        r27 = r6;
        r28 = r7;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x034a, code lost:
        r2 = r19;
        r5 = r20;
        r15 = r21;
        r1 = r23;
        r14 = r24;
        r3 = r25;
        r4 = r26;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x035e, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x036d, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x036e, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r0 = java.lang.Long.toString(r10);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03a1, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03a2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03a5, code lost:
        r2 = r2.toString();
        r1 = r24;
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03af, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03b6, code lost:
        r26 = r4;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03ba, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03bd, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r26.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03cb, code lost:
        if (com.google.android.gms.internal.ads.zzbbk.zzm(3) == false) goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03cd, code lost:
        r1 = zzf.format((long) r13);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r30).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r9);
        com.google.android.gms.internal.ads.zzbbk.zzd(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0403, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x040c, code lost:
        if (r0.isFile() == false) goto L_0x0416;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x040e, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        zzl(r9, r12.getAbsolutePath(), r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0422, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        zze.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0427, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0429, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x042d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x042f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0430, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0433, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0436, code lost:
        r26 = r4;
        r1 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x043b, code lost:
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x043d, code lost:
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x043f, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0441, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0444, code lost:
        r1 = r14;
        r15 = r15;
        r2 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x044d, code lost:
        if ((r0 instanceof java.lang.RuntimeException) != false) goto L_0x044f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x044f, code lost:
        com.google.android.gms.ads.internal.zzs.zzg().zzg(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x045f, code lost:
        if (r8.zzh == false) goto L_0x0485;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0461, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r30).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r9);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzbbk.zzh(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0485, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r30).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r9);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzbbk.zzj(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04b4, code lost:
        r0 = java.lang.String.valueOf(r12.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04c2, code lost:
        if (r0.length() == 0) goto L_0x04c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04c4, code lost:
        r0 = "Could not delete partial cache file at ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04c9, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04ce, code lost:
        com.google.android.gms.internal.ads.zzbbk.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04d1, code lost:
        zzn(r9, r12.getAbsolutePath(), r15, r2);
        zze.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0124, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r2 = com.google.android.gms.internal.ads.zzebe.zza().zzb(new com.google.android.gms.internal.ads.zzbfp(r9), 265, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0138, code lost:
        if ((r2 instanceof java.net.HttpURLConnection) == false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013a, code lost:
        r3 = r2.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0140, code lost:
        if (r3 < 400) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0142, code lost:
        r15 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0152, code lost:
        if (r1.length() == 0) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0154, code lost:
        r1 = "HTTP request failed. Code: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015a, code lost:
        r1 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r30).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r3);
        r4.append(" at ");
        r4.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0187, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0188, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018b, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0190, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0191, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r7 = r2.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0198, code lost:
        if (r7 >= 0) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019a, code lost:
        r2 = java.lang.String.valueOf(r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a4, code lost:
        if (r2.length() == 0) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a6, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ab, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b1, code lost:
        com.google.android.gms.internal.ads.zzbbk.zzi(r0);
        zzn(r9, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        r1.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c0, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c1, code lost:
        r3 = zzf.format((long) r7);
        r6 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzaaa.zzc().zzb(com.google.android.gms.internal.ads.zzaeq.zzr)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d8, code lost:
        if (r7 <= r6) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01da, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r3).length() + 33) + java.lang.String.valueOf(r30).length());
        r2.append("Content length ");
        r2.append(r3);
        r2.append(" exceeds limit at ");
        r2.append(r9);
        com.google.android.gms.internal.ads.zzbbk.zzi(r2.toString());
        r2 = java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0213, code lost:
        if (r2.length() == 0) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0215, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x021a, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0220, code lost:
        zzn(r9, r12.getAbsolutePath(), "sizeExceeded", r0);
        r1.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x022c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x022d, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r3).length() + 20) + java.lang.String.valueOf(r30).length());
        r4.append("Caching ");
        r4.append(r3);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzbbk.zzd(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r2.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r3 = r4.getChannel();
        r2 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzs.zzj();
        r17 = r16.currentTimeMillis();
        r1 = new com.google.android.gms.ads.internal.util.zzbp(((java.lang.Long) com.google.android.gms.internal.ads.zzaaa.zzc().zzb(com.google.android.gms.internal.ads.zzaeq.zzu)).longValue());
        r10 = ((java.lang.Long) com.google.android.gms.internal.ads.zzaaa.zzc().zzb(com.google.android.gms.internal.ads.zzaeq.zzt)).longValue();
        r13 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x0419 */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x042d A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r21 r24 r26 
      PHI: (r21v6 java.lang.String) = (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v15 java.lang.String), (r21v15 java.lang.String) binds: [B:160:0x03c3, B:169:0x0419, B:170:?, B:167:0x0416, B:168:?, B:131:0x030e, B:134:0x032c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 java.lang.String) = (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v8 java.lang.String), (r24v10 java.lang.String) binds: [B:160:0x03c3, B:169:0x0419, B:170:?, B:167:0x0416, B:168:?, B:131:0x030e, B:134:0x032c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r26v7 java.io.FileOutputStream) = (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v13 java.io.FileOutputStream), (r26v16 java.io.FileOutputStream) binds: [B:160:0x03c3, B:169:0x0419, B:170:?, B:167:0x0416, B:168:?, B:131:0x030e, B:134:0x032c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:134:0x032c] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x044f  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r30) {
        /*
            r29 = this;
            r8 = r29
            r9 = r30
            java.io.File r0 = r8.zzg
            r10 = 0
            r11 = 0
            if (r0 == 0) goto L_0x04e2
        L_0x000a:
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0010
            r3 = 0
            goto L_0x002c
        L_0x0010:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0017:
            if (r2 >= r1) goto L_0x002c
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x0029
            int r3 = r3 + 1
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x002c:
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzaeq.zzq
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0090
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0043
            goto L_0x0085
        L_0x0043:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = r11
            r4 = 0
        L_0x004f:
            if (r4 >= r1) goto L_0x006c
            r6 = r0[r4]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0069
            long r12 = r6.lastModified()
            int r7 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0069
            r5 = r6
            r2 = r12
        L_0x0069:
            int r4 = r4 + 1
            goto L_0x004f
        L_0x006c:
            if (r5 == 0) goto L_0x0082
            boolean r0 = r5.delete()
            java.io.File r1 = r8.zzj(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0083
            boolean r1 = r1.delete()
            r0 = r0 & r1
            goto L_0x0083
        L_0x0082:
            r0 = 0
        L_0x0083:
            if (r0 != 0) goto L_0x000a
        L_0x0085:
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
            java.lang.String r0 = "expireFailed"
            r8.zzn(r9, r11, r0, r11)
            return r10
        L_0x0090:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzbbd.zzd(r30)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.zzg
            r12.<init>(r1, r0)
            java.io.File r0 = r8.zzj(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00d2
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00d2
            long r0 = r12.length()
            int r1 = (int) r0
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r2 = "Stream cache hit at "
            int r3 = r0.length()
            if (r3 == 0) goto L_0x00c2
            java.lang.String r0 = r2.concat(r0)
            goto L_0x00c7
        L_0x00c2:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x00c7:
            com.google.android.gms.internal.ads.zzbbk.zzd(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zzl(r9, r0, r1)
            return r13
        L_0x00d2:
            java.io.File r1 = r8.zzg
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r30)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00ec
            java.lang.String r1 = r1.concat(r2)
            r14 = r1
            goto L_0x00f2
        L_0x00ec:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r14 = r2
        L_0x00f2:
            java.util.Set<java.lang.String> r1 = zze
            monitor-enter(r1)
            boolean r2 = r1.contains(r14)     // Catch:{ all -> 0x04df }
            if (r2 == 0) goto L_0x0120
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r30)     // Catch:{ all -> 0x04df }
            int r3 = r2.length()     // Catch:{ all -> 0x04df }
            if (r3 == 0) goto L_0x010c
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x04df }
            goto L_0x0112
        L_0x010c:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x04df }
            r2.<init>(r0)     // Catch:{ all -> 0x04df }
            r0 = r2
        L_0x0112:
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)     // Catch:{ all -> 0x04df }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x04df }
            java.lang.String r2 = "inProgress"
            r8.zzn(r9, r0, r2, r11)     // Catch:{ all -> 0x04df }
            monitor-exit(r1)     // Catch:{ all -> 0x04df }
            return r10
        L_0x0120:
            r1.add(r14)     // Catch:{ all -> 0x04df }
            monitor-exit(r1)     // Catch:{ all -> 0x04df }
            java.lang.String r15 = "error"
            com.google.android.gms.internal.ads.zzebl r2 = com.google.android.gms.internal.ads.zzebe.zza()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            com.google.android.gms.internal.ads.zzbfp r3 = new com.google.android.gms.internal.ads.zzbfp     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r3.<init>(r9)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r4 = 265(0x109, float:3.71E-43)
            r5 = -1
            java.net.HttpURLConnection r2 = r2.zzb(r3, r4, r5)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            boolean r3 = r2 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            if (r3 == 0) goto L_0x0194
            int r3 = r2.getResponseCode()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r4 = 400(0x190, float:5.6E-43)
            if (r3 < r4) goto L_0x0194
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r1 = java.lang.Integer.toString(r3)     // Catch:{ IOException -> 0x018f, RuntimeException -> 0x018d }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x018f, RuntimeException -> 0x018d }
            int r2 = r1.length()     // Catch:{ IOException -> 0x018f, RuntimeException -> 0x018d }
            if (r2 == 0) goto L_0x015a
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x018f, RuntimeException -> 0x018d }
            r1 = r0
            goto L_0x015f
        L_0x015a:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x018f, RuntimeException -> 0x018d }
            r1.<init>(r0)     // Catch:{ IOException -> 0x018f, RuntimeException -> 0x018d }
        L_0x015f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            java.lang.String r2 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            int r2 = r2 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            java.lang.String r2 = "HTTP status code "
            r4.append(r2)     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            r4.append(r3)     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            java.lang.String r2 = " at "
            r4.append(r2)     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            r4.append(r9)     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
            throw r0     // Catch:{ IOException -> 0x018a, RuntimeException -> 0x0188 }
        L_0x0188:
            r0 = move-exception
            goto L_0x018b
        L_0x018a:
            r0 = move-exception
        L_0x018b:
            r2 = r1
            goto L_0x0191
        L_0x018d:
            r0 = move-exception
            goto L_0x0190
        L_0x018f:
            r0 = move-exception
        L_0x0190:
            r2 = r11
        L_0x0191:
            r1 = r14
            goto L_0x044b
        L_0x0194:
            int r7 = r2.getContentLength()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            if (r7 >= 0) goto L_0x01c1
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r2 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            if (r3 == 0) goto L_0x01ab
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            goto L_0x01b1
        L_0x01ab:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r0 = r2
        L_0x01b1:
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r2 = "contentLengthMissing"
            r8.zzn(r9, r0, r2, r11)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r1.remove(r14)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            return r10
        L_0x01c1:
            java.text.DecimalFormat r3 = zzf     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            long r4 = (long) r7     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r3 = r3.format(r4)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r4 = com.google.android.gms.internal.ads.zzaeq.zzr     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            com.google.android.gms.internal.ads.zzaeo r5 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r6 = r4.intValue()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            if (r7 <= r6) goto L_0x022d
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r0 = r0.length()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r0 = r0 + 33
            java.lang.String r2 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r0 = "Content length "
            r2.append(r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r2.append(r3)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r0 = " exceeds limit at "
            r2.append(r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r2.append(r9)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            if (r3 == 0) goto L_0x021a
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            goto L_0x0220
        L_0x021a:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r0 = r2
        L_0x0220:
            java.lang.String r2 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r3 = "sizeExceeded"
            r8.zzn(r9, r2, r3, r0)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r1.remove(r14)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            return r10
        L_0x022d:
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r1 = r1 + 20
            java.lang.String r4 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            int r1 = r1 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r1 = "Caching "
            r4.append(r1)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r4.append(r3)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r4.append(r9)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            com.google.android.gms.internal.ads.zzbbk.zzd(r1)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            r4.<init>(r12)     // Catch:{ IOException -> 0x0443, RuntimeException -> 0x0441 }
            java.nio.channels.FileChannel r3 = r4.getChannel()     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzaeq.zzu     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            com.google.android.gms.internal.ads.zzaeo r11 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            java.lang.Object r1 = r11.zzb(r1)     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            long r10 = r1.longValue()     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            com.google.android.gms.ads.internal.util.zzbp r1 = new com.google.android.gms.ads.internal.util.zzbp     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            r1.<init>(r10)     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Long> r10 = com.google.android.gms.internal.ads.zzaeq.zzt     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            com.google.android.gms.internal.ads.zzaeo r11 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            java.lang.Object r10 = r11.zzb(r10)     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            long r10 = r10.longValue()     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            r13 = 0
        L_0x02a1:
            int r19 = r5.read(r2)     // Catch:{ IOException -> 0x0435, RuntimeException -> 0x0433 }
            if (r19 < 0) goto L_0x03bd
            int r13 = r13 + r19
            if (r13 <= r6) goto L_0x02e0
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r13)     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            if (r2 == 0) goto L_0x02c3
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            r11 = r0
            goto L_0x02c9
        L_0x02c3:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            r11 = r1
        L_0x02c9:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x02d3, RuntimeException -> 0x02d1 }
            java.lang.String r1 = "stream cache file size limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x02d3, RuntimeException -> 0x02d1 }
            throw r0     // Catch:{ IOException -> 0x02d3, RuntimeException -> 0x02d1 }
        L_0x02d1:
            r0 = move-exception
            goto L_0x02d4
        L_0x02d3:
            r0 = move-exception
        L_0x02d4:
            r2 = r11
            r1 = r14
            r11 = r4
            goto L_0x044b
        L_0x02d9:
            r0 = move-exception
            goto L_0x02dc
        L_0x02db:
            r0 = move-exception
        L_0x02dc:
            r11 = r4
            r1 = r14
            goto L_0x043f
        L_0x02e0:
            r2.flip()     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
        L_0x02e3:
            int r19 = r3.write(r2)     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
            if (r19 > 0) goto L_0x02e3
            r2.clear()     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
            long r19 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
            long r19 = r19 - r17
            r21 = 1000(0x3e8, double:4.94E-321)
            long r21 = r21 * r10
            int r23 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r23 > 0) goto L_0x036e
            r19 = r2
            boolean r2 = r8.zzh     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
            if (r2 != 0) goto L_0x035e
            boolean r2 = r1.zza()     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
            if (r2 == 0) goto L_0x033a
            java.lang.String r20 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
            android.os.Handler r2 = com.google.android.gms.internal.ads.zzbbd.zza     // Catch:{ IOException -> 0x03b5, RuntimeException -> 0x03b3 }
            r21 = r15
            com.google.android.gms.internal.ads.zzbfh r15 = new com.google.android.gms.internal.ads.zzbfh     // Catch:{ IOException -> 0x0335, RuntimeException -> 0x0333 }
            r22 = 0
            r23 = r1
            r1 = r15
            r24 = r14
            r14 = r2
            r2 = r29
            r25 = r3
            r3 = r30
            r26 = r4
            r4 = r20
            r20 = r5
            r5 = r13
            r27 = r6
            r6 = r7
            r28 = r7
            r7 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r14.post(r15)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            goto L_0x034a
        L_0x0333:
            r0 = move-exception
            goto L_0x0336
        L_0x0335:
            r0 = move-exception
        L_0x0336:
            r26 = r4
            goto L_0x03ba
        L_0x033a:
            r23 = r1
            r25 = r3
            r26 = r4
            r20 = r5
            r27 = r6
            r28 = r7
            r24 = r14
            r21 = r15
        L_0x034a:
            r2 = r19
            r5 = r20
            r15 = r21
            r1 = r23
            r14 = r24
            r3 = r25
            r4 = r26
            r6 = r27
            r7 = r28
            goto L_0x02a1
        L_0x035e:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            throw r0     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
        L_0x036e:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r10)     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            int r1 = r1.length()     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            r2.<init>(r1)     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            r2.append(r0)     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            java.lang.String r11 = r2.toString()     // Catch:{ IOException -> 0x03ae, RuntimeException -> 0x03ac }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03a2 }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03a2 }
            throw r0     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03a2 }
        L_0x03a2:
            r0 = move-exception
            goto L_0x03a5
        L_0x03a4:
            r0 = move-exception
        L_0x03a5:
            r2 = r11
            r1 = r24
            r11 = r26
            goto L_0x044b
        L_0x03ac:
            r0 = move-exception
            goto L_0x03af
        L_0x03ae:
            r0 = move-exception
        L_0x03af:
            r1 = r24
            goto L_0x043d
        L_0x03b3:
            r0 = move-exception
            goto L_0x03b6
        L_0x03b5:
            r0 = move-exception
        L_0x03b6:
            r26 = r4
            r21 = r15
        L_0x03ba:
            r1 = r14
            goto L_0x043b
        L_0x03bd:
            r26 = r4
            r24 = r14
            r21 = r15
            r26.close()     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r1 = 3
            boolean r1 = com.google.android.gms.internal.ads.zzbbk.zzm(r1)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            if (r1 == 0) goto L_0x0403
            java.text.DecimalFormat r1 = zzf     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            long r2 = (long) r13     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            int r2 = r2.length()     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            int r3 = r3.length()     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r3.<init>(r2)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            java.lang.String r2 = "Preloaded "
            r3.append(r2)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r3.append(r1)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            java.lang.String r1 = " bytes from "
            r3.append(r1)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r3.append(r9)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            com.google.android.gms.internal.ads.zzbbk.zzd(r1)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
        L_0x0403:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            if (r1 == 0) goto L_0x0416
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            goto L_0x0419
        L_0x0416:
            r0.createNewFile()     // Catch:{ IOException -> 0x0419, RuntimeException -> 0x042d }
        L_0x0419:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r8.zzl(r9, r0, r13)     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            java.util.Set<java.lang.String> r0 = zze     // Catch:{ IOException -> 0x042f, RuntimeException -> 0x042d }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x042b, RuntimeException -> 0x0429 }
            r0 = 1
            return r0
        L_0x0429:
            r0 = move-exception
            goto L_0x043b
        L_0x042b:
            r0 = move-exception
            goto L_0x043b
        L_0x042d:
            r0 = move-exception
            goto L_0x0430
        L_0x042f:
            r0 = move-exception
        L_0x0430:
            r1 = r24
            goto L_0x043b
        L_0x0433:
            r0 = move-exception
            goto L_0x0436
        L_0x0435:
            r0 = move-exception
        L_0x0436:
            r26 = r4
            r1 = r14
            r21 = r15
        L_0x043b:
            r15 = r21
        L_0x043d:
            r11 = r26
        L_0x043f:
            r2 = 0
            goto L_0x044b
        L_0x0441:
            r0 = move-exception
            goto L_0x0444
        L_0x0443:
            r0 = move-exception
        L_0x0444:
            r1 = r14
            r21 = r15
            r15 = r21
            r2 = 0
            r11 = 0
        L_0x044b:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0458
            com.google.android.gms.internal.ads.zzbav r3 = com.google.android.gms.ads.internal.zzs.zzg()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zzg(r0, r4)
        L_0x0458:
            r11.close()     // Catch:{ IOException | NullPointerException -> 0x045c }
            goto L_0x045d
        L_0x045c:
        L_0x045d:
            boolean r3 = r8.zzh
            if (r3 == 0) goto L_0x0485
            java.lang.String r0 = java.lang.String.valueOf(r30)
            int r0 = r0.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r0 = r0 + 26
            r3.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r3.append(r0)
            r3.append(r9)
            java.lang.String r0 = "\""
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzbbk.zzh(r0)
            goto L_0x04a8
        L_0x0485:
            java.lang.String r3 = java.lang.String.valueOf(r30)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r3 = r3 + 25
            r4.<init>(r3)
            java.lang.String r3 = "Preload failed for URL \""
            r4.append(r3)
            r4.append(r9)
            java.lang.String r3 = "\""
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.google.android.gms.internal.ads.zzbbk.zzj(r3, r0)
        L_0x04a8:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x04d1
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x04d1
            java.lang.String r0 = r12.getAbsolutePath()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Could not delete partial cache file at "
            int r4 = r0.length()
            if (r4 == 0) goto L_0x04c9
            java.lang.String r0 = r3.concat(r0)
            goto L_0x04ce
        L_0x04c9:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x04ce:
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
        L_0x04d1:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zzn(r9, r0, r15, r2)
            java.util.Set<java.lang.String> r0 = zze
            r0.remove(r1)
        L_0x04dd:
            r1 = 0
            return r1
        L_0x04df:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x04df }
            throw r0
        L_0x04e2:
            java.lang.String r0 = "noCacheDir"
            r1 = 0
            r8.zzn(r9, r1, r0, r1)
            goto L_0x04dd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfq.zza(java.lang.String):boolean");
    }

    public final void zzg() {
        this.zzh = true;
    }
}
