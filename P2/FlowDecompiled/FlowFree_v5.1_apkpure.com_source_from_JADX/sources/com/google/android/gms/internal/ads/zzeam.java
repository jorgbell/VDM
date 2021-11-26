package com.google.android.gms.internal.ads;

import java.io.File;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeam {
    private final zzhv zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzeam(zzhv zzhv, File file, File file2, File file3) {
        this.zza = zzhv;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzhv zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzb;
    }

    public final File zzc() {
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzd() {
        /*
            r3 = this;
            byte[] r0 = r3.zze
            r1 = 0
            if (r0 != 0) goto L_0x0027
            java.io.File r0 = r3.zzd
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0020, all -> 0x001b }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0020, all -> 0x001b }
            com.google.android.gms.internal.ads.zzesf r0 = com.google.android.gms.internal.ads.zzesf.zzv(r2)     // Catch:{ IOException -> 0x0021, all -> 0x0018 }
            byte[] r0 = r0.zzy()     // Catch:{ IOException -> 0x0021, all -> 0x0018 }
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            goto L_0x0025
        L_0x0018:
            r0 = move-exception
            r1 = r2
            goto L_0x001c
        L_0x001b:
            r0 = move-exception
        L_0x001c:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            throw r0
        L_0x0020:
            r2 = r1
        L_0x0021:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r2)
            r0 = r1
        L_0x0025:
            r3.zze = r0
        L_0x0027:
            byte[] r0 = r3.zze
            if (r0 != 0) goto L_0x002c
            return r1
        L_0x002c:
            int r1 = r0.length
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeam.zzd():byte[]");
    }

    public final boolean zze(long j) {
        return this.zza.zzd() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
