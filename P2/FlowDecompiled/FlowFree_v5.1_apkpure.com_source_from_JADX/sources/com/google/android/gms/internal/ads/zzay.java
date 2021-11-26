package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzay implements zzm {
    private final Map<String, zzav> zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final zzax zzc;
    private final int zzd;

    public zzay(zzax zzax, int i) {
        this.zzc = zzax;
        this.zzd = 5242880;
    }

    static void zzh(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int zzi(InputStream inputStream) throws IOException {
        return (zzp(inputStream) << 24) | zzp(inputStream) | (zzp(inputStream) << 8) | (zzp(inputStream) << 16);
    }

    static void zzj(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long zzk(InputStream inputStream) throws IOException {
        return (((long) zzp(inputStream)) & 255) | ((((long) zzp(inputStream)) & 255) << 8) | ((((long) zzp(inputStream)) & 255) << 16) | ((((long) zzp(inputStream)) & 255) << 24) | ((((long) zzp(inputStream)) & 255) << 32) | ((((long) zzp(inputStream)) & 255) << 40) | ((((long) zzp(inputStream)) & 255) << 48) | ((255 & ((long) zzp(inputStream))) << 56);
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzj(outputStream, (long) length);
        outputStream.write(bytes, 0, length);
    }

    static String zzm(zzaw zzaw) throws IOException {
        return new String(zzg(zzaw, zzk(zzaw)), "UTF-8");
    }

    private final void zzn(String str, zzav zzav) {
        if (!this.zza.containsKey(str)) {
            this.zzb += zzav.zza;
        } else {
            this.zzb += zzav.zza - this.zza.get(str).zza;
        }
        this.zza.put(str, zzav);
    }

    private final void zzo(String str) {
        zzav remove = this.zza.remove(str);
        if (remove != null) {
            this.zzb -= remove.zza;
        }
    }

    private static int zzp(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final synchronized zzl zza(String str) {
        zzaw zzaw;
        zzav zzav = this.zza.get(str);
        if (zzav == null) {
            return null;
        }
        File zzf = zzf(str);
        try {
            zzaw = new zzaw(new BufferedInputStream(new FileInputStream(zzf)), zzf.length());
            zzav zza2 = zzav.zza(zzaw);
            if (!TextUtils.equals(str, zza2.zzb)) {
                zzao.zzb("%s: key=%s, found=%s", zzf.getAbsolutePath(), str, zza2.zzb);
                zzo(str);
                zzaw.close();
                return null;
            }
            byte[] zzg = zzg(zzaw, zzaw.zza());
            zzl zzl = new zzl();
            zzl.zza = zzg;
            zzl.zzb = zzav.zzc;
            zzl.zzc = zzav.zzd;
            zzl.zzd = zzav.zze;
            zzl.zze = zzav.zzf;
            zzl.zzf = zzav.zzg;
            List<zzu> list = zzav.zzh;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzu next : list) {
                treeMap.put(next.zza(), next.zzb());
            }
            zzl.zzg = treeMap;
            zzl.zzh = Collections.unmodifiableList(zzav.zzh);
            zzaw.close();
            return zzl;
        } catch (IOException e) {
            zzao.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
            zze(str);
            return null;
        } catch (Throwable th) {
            zzaw.close();
            throw th;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x016c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(java.lang.String r16, com.google.android.gms.internal.ads.zzl r17) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            monitor-enter(r15)
            long r3 = r1.zzb     // Catch:{ all -> 0x01a2 }
            byte[] r5 = r2.zza     // Catch:{ all -> 0x01a2 }
            int r5 = r5.length     // Catch:{ all -> 0x01a2 }
            int r6 = r1.zzd     // Catch:{ all -> 0x01a2 }
            long r7 = (long) r5
            long r3 = r3 + r7
            long r7 = (long) r6
            r9 = 1063675494(0x3f666666, float:0.9)
            int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0022
            float r3 = (float) r5
            float r4 = (float) r6
            float r4 = r4 * r9
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            monitor-exit(r15)
            return
        L_0x0022:
            java.io.File r3 = r15.zzf(r16)     // Catch:{ all -> 0x01a2 }
            r4 = 1
            r5 = 0
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x016c }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x016c }
            r7.<init>(r3)     // Catch:{ IOException -> 0x016c }
            r6.<init>(r7)     // Catch:{ IOException -> 0x016c }
            com.google.android.gms.internal.ads.zzav r7 = new com.google.android.gms.internal.ads.zzav     // Catch:{ IOException -> 0x016c }
            r7.<init>(r0, r2)     // Catch:{ IOException -> 0x016c }
            r8 = 538247942(0x20150306, float:1.2621791E-19)
            zzh(r6, r8)     // Catch:{ IOException -> 0x0148 }
            java.lang.String r8 = r7.zzb     // Catch:{ IOException -> 0x0148 }
            zzl(r6, r8)     // Catch:{ IOException -> 0x0148 }
            java.lang.String r8 = r7.zzc     // Catch:{ IOException -> 0x0148 }
            if (r8 != 0) goto L_0x0048
            java.lang.String r8 = ""
        L_0x0048:
            zzl(r6, r8)     // Catch:{ IOException -> 0x0148 }
            long r10 = r7.zzd     // Catch:{ IOException -> 0x0148 }
            zzj(r6, r10)     // Catch:{ IOException -> 0x0148 }
            long r10 = r7.zze     // Catch:{ IOException -> 0x0148 }
            zzj(r6, r10)     // Catch:{ IOException -> 0x0148 }
            long r10 = r7.zzf     // Catch:{ IOException -> 0x0148 }
            zzj(r6, r10)     // Catch:{ IOException -> 0x0148 }
            long r10 = r7.zzg     // Catch:{ IOException -> 0x0148 }
            zzj(r6, r10)     // Catch:{ IOException -> 0x0148 }
            java.util.List<com.google.android.gms.internal.ads.zzu> r8 = r7.zzh     // Catch:{ IOException -> 0x0148 }
            if (r8 == 0) goto L_0x0089
            int r10 = r8.size()     // Catch:{ IOException -> 0x0148 }
            zzh(r6, r10)     // Catch:{ IOException -> 0x0148 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x0148 }
        L_0x006e:
            boolean r10 = r8.hasNext()     // Catch:{ IOException -> 0x0148 }
            if (r10 == 0) goto L_0x008c
            java.lang.Object r10 = r8.next()     // Catch:{ IOException -> 0x0148 }
            com.google.android.gms.internal.ads.zzu r10 = (com.google.android.gms.internal.ads.zzu) r10     // Catch:{ IOException -> 0x0148 }
            java.lang.String r11 = r10.zza()     // Catch:{ IOException -> 0x0148 }
            zzl(r6, r11)     // Catch:{ IOException -> 0x0148 }
            java.lang.String r10 = r10.zzb()     // Catch:{ IOException -> 0x0148 }
            zzl(r6, r10)     // Catch:{ IOException -> 0x0148 }
            goto L_0x006e
        L_0x0089:
            zzh(r6, r5)     // Catch:{ IOException -> 0x0148 }
        L_0x008c:
            r6.flush()     // Catch:{ IOException -> 0x0148 }
            byte[] r2 = r2.zza     // Catch:{ IOException -> 0x016c }
            r6.write(r2)     // Catch:{ IOException -> 0x016c }
            r6.close()     // Catch:{ IOException -> 0x016c }
            long r10 = r3.length()     // Catch:{ IOException -> 0x016c }
            r7.zza = r10     // Catch:{ IOException -> 0x016c }
            r15.zzn(r0, r7)     // Catch:{ IOException -> 0x016c }
            long r6 = r1.zzb     // Catch:{ IOException -> 0x016c }
            int r0 = r1.zzd     // Catch:{ IOException -> 0x016c }
            long r10 = (long) r0     // Catch:{ IOException -> 0x016c }
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x01a0
            boolean r0 = com.google.android.gms.internal.ads.zzao.zzb     // Catch:{ IOException -> 0x016c }
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = "Pruning old cache entries."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x016c }
            com.google.android.gms.internal.ads.zzao.zza(r0, r2)     // Catch:{ IOException -> 0x016c }
        L_0x00b4:
            long r6 = r1.zzb     // Catch:{ IOException -> 0x016c }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x016c }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.zzav> r0 = r1.zza     // Catch:{ IOException -> 0x016c }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x016c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x016c }
            r2 = 0
        L_0x00c5:
            boolean r8 = r0.hasNext()     // Catch:{ IOException -> 0x016c }
            r12 = 2
            if (r8 == 0) goto L_0x011c
            java.lang.Object r8 = r0.next()     // Catch:{ IOException -> 0x016c }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ IOException -> 0x016c }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x016c }
            com.google.android.gms.internal.ads.zzav r8 = (com.google.android.gms.internal.ads.zzav) r8     // Catch:{ IOException -> 0x016c }
            java.lang.String r13 = r8.zzb     // Catch:{ IOException -> 0x016c }
            java.io.File r13 = r15.zzf(r13)     // Catch:{ IOException -> 0x016c }
            boolean r13 = r13.delete()     // Catch:{ IOException -> 0x016c }
            if (r13 == 0) goto L_0x00ee
            long r13 = r1.zzb     // Catch:{ IOException -> 0x016c }
            r16 = r10
            long r9 = r8.zza     // Catch:{ IOException -> 0x016c }
            long r13 = r13 - r9
            r1.zzb = r13     // Catch:{ IOException -> 0x016c }
            goto L_0x0101
        L_0x00ee:
            r16 = r10
            java.lang.String r9 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r10 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x016c }
            java.lang.String r8 = r8.zzb     // Catch:{ IOException -> 0x016c }
            r10[r5] = r8     // Catch:{ IOException -> 0x016c }
            java.lang.String r8 = zzq(r8)     // Catch:{ IOException -> 0x016c }
            r10[r4] = r8     // Catch:{ IOException -> 0x016c }
            com.google.android.gms.internal.ads.zzao.zzb(r9, r10)     // Catch:{ IOException -> 0x016c }
        L_0x0101:
            r0.remove()     // Catch:{ IOException -> 0x016c }
            int r2 = r2 + 1
            long r8 = r1.zzb     // Catch:{ IOException -> 0x016c }
            float r8 = (float) r8     // Catch:{ IOException -> 0x016c }
            int r9 = r1.zzd     // Catch:{ IOException -> 0x016c }
            float r9 = (float) r9     // Catch:{ IOException -> 0x016c }
            r10 = 1063675494(0x3f666666, float:0.9)
            float r9 = r9 * r10
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x0116
            goto L_0x011e
        L_0x0116:
            r10 = r16
            r9 = 1063675494(0x3f666666, float:0.9)
            goto L_0x00c5
        L_0x011c:
            r16 = r10
        L_0x011e:
            boolean r0 = com.google.android.gms.internal.ads.zzao.zzb     // Catch:{ IOException -> 0x016c }
            if (r0 == 0) goto L_0x01a0
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x016c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x016c }
            r0[r5] = r2     // Catch:{ IOException -> 0x016c }
            long r8 = r1.zzb     // Catch:{ IOException -> 0x016c }
            long r8 = r8 - r6
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ IOException -> 0x016c }
            r0[r4] = r2     // Catch:{ IOException -> 0x016c }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x016c }
            r8 = r16
            long r6 = r6 - r8
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x016c }
            r0[r12] = r2     // Catch:{ IOException -> 0x016c }
            java.lang.String r2 = "pruned %d files, %d bytes, %d ms"
            com.google.android.gms.internal.ads.zzao.zza(r2, r0)     // Catch:{ IOException -> 0x016c }
            monitor-exit(r15)
            return
        L_0x0148:
            r0 = move-exception
            java.lang.String r2 = "%s"
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x016c }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x016c }
            r7[r5] = r0     // Catch:{ IOException -> 0x016c }
            com.google.android.gms.internal.ads.zzao.zzb(r2, r7)     // Catch:{ IOException -> 0x016c }
            r6.close()     // Catch:{ IOException -> 0x016c }
            java.lang.String r0 = "Failed to write header for %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x016c }
            java.lang.String r6 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x016c }
            r2[r5] = r6     // Catch:{ IOException -> 0x016c }
            com.google.android.gms.internal.ads.zzao.zzb(r0, r2)     // Catch:{ IOException -> 0x016c }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x016c }
            r0.<init>()     // Catch:{ IOException -> 0x016c }
            throw r0     // Catch:{ IOException -> 0x016c }
        L_0x016c:
            boolean r0 = r3.delete()     // Catch:{ all -> 0x01a2 }
            if (r0 != 0) goto L_0x017f
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x01a2 }
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ all -> 0x01a2 }
            r0[r5] = r2     // Catch:{ all -> 0x01a2 }
            java.lang.String r2 = "Could not clean up file %s"
            com.google.android.gms.internal.ads.zzao.zzb(r2, r0)     // Catch:{ all -> 0x01a2 }
        L_0x017f:
            com.google.android.gms.internal.ads.zzax r0 = r1.zzc     // Catch:{ all -> 0x01a2 }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x01a2 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x01a2 }
            if (r0 != 0) goto L_0x01a0
            java.lang.String r0 = "Re-initializing cache after external clearing."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x01a2 }
            com.google.android.gms.internal.ads.zzao.zzb(r0, r2)     // Catch:{ all -> 0x01a2 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.zzav> r0 = r1.zza     // Catch:{ all -> 0x01a2 }
            r0.clear()     // Catch:{ all -> 0x01a2 }
            r2 = 0
            r1.zzb = r2     // Catch:{ all -> 0x01a2 }
            r15.zzc()     // Catch:{ all -> 0x01a2 }
            monitor-exit(r15)
            return
        L_0x01a0:
            monitor-exit(r15)
            return
        L_0x01a2:
            r0 = move-exception
            monitor-exit(r15)
            goto L_0x01a6
        L_0x01a5:
            throw r0
        L_0x01a6:
            goto L_0x01a5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzay.zzb(java.lang.String, com.google.android.gms.internal.ads.zzl):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzc() {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzax r0 = r9.zzc     // Catch:{ all -> 0x0062 }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x0062 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x0062 }
            r2 = 0
            if (r1 != 0) goto L_0x0026
            boolean r1 = r0.mkdirs()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0024
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0062 }
            r1[r2] = r0     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = "Unable to create cache dir %s"
            com.google.android.gms.internal.ads.zzao.zzc(r0, r1)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return
        L_0x0024:
            monitor-exit(r9)
            return
        L_0x0026:
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)
            return
        L_0x002e:
            int r1 = r0.length     // Catch:{ all -> 0x0062 }
        L_0x002f:
            if (r2 >= r1) goto L_0x0060
            r3 = r0[r2]     // Catch:{ all -> 0x0062 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.ads.zzaw r6 = new com.google.android.gms.internal.ads.zzaw     // Catch:{ IOException -> 0x005a }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005a }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005a }
            r8.<init>(r3)     // Catch:{ IOException -> 0x005a }
            r7.<init>(r8)     // Catch:{ IOException -> 0x005a }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.ads.zzav r7 = com.google.android.gms.internal.ads.zzav.zza(r6)     // Catch:{ all -> 0x0055 }
            r7.zza = r4     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r7.zzb     // Catch:{ all -> 0x0055 }
            r9.zzn(r4, r7)     // Catch:{ all -> 0x0055 }
            r6.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005d
        L_0x0055:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x005a }
            throw r4     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            r3.delete()     // Catch:{ all -> 0x0062 }
        L_0x005d:
            int r2 = r2 + 1
            goto L_0x002f
        L_0x0060:
            monitor-exit(r9)
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r9)
            goto L_0x0066
        L_0x0065:
            throw r0
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzay.zzc():void");
    }

    public final synchronized void zzd(String str, boolean z) {
        zzl zza2 = zza(str);
        if (zza2 != null) {
            zza2.zzf = 0;
            zza2.zze = 0;
            zzb(str, zza2);
        }
    }

    public final synchronized void zze(String str) {
        boolean delete = zzf(str).delete();
        zzo(str);
        if (!delete) {
            zzao.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
        }
    }

    public final File zzf(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public zzay(File file, int i) {
        this.zzc = new zzau(this, file);
        this.zzd = 20971520;
    }

    static byte[] zzg(zzaw zzaw, long j) throws IOException {
        long zza2 = zzaw.zza();
        if (j >= 0 && j <= zza2) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzaw).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(zza2);
        throw new IOException(sb.toString());
    }
}
