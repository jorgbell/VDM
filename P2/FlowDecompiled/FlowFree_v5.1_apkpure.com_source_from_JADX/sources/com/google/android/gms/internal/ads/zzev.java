package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzev implements Runnable {
    final /* synthetic */ zzew zza;

    zzev(zzew zzew) {
        this.zza = zzew;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:8|9|10|(2:14|15)|16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzew r0 = r7.zza
            java.lang.Boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            android.os.ConditionVariable r0 = com.google.android.gms.internal.ads.zzew.zzd
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzew r1 = r7.zza     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r1 = r1.zzb     // Catch:{ all -> 0x0049 }
            if (r1 != 0) goto L_0x0047
            r1 = 0
            com.google.android.gms.internal.ads.zzafs<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzaeq.zzby     // Catch:{ IllegalStateException -> 0x0020 }
            java.lang.Object r2 = r2.zze()     // Catch:{ IllegalStateException -> 0x0020 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ IllegalStateException -> 0x0020 }
            boolean r2 = r2.booleanValue()     // Catch:{ IllegalStateException -> 0x0020 }
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzeba r3 = new com.google.android.gms.internal.ads.zzeba     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzew r4 = r7.zza     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzge r4 = r4.zzc     // Catch:{ all -> 0x0036 }
            android.content.Context r4 = r4.zza     // Catch:{ all -> 0x0036 }
            java.lang.String r5 = "ADSHIELD"
            r6 = 0
            r3.<init>(r4, r5, r6)     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzew.zza = r3     // Catch:{ all -> 0x0036 }
        L_0x0035:
            r1 = r2
        L_0x0036:
            com.google.android.gms.internal.ads.zzew r2 = r7.zza     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0049 }
            r2.zzb = r1     // Catch:{ all -> 0x0049 }
            android.os.ConditionVariable r1 = com.google.android.gms.internal.ads.zzew.zzd     // Catch:{ all -> 0x0049 }
            r1.open()     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0049:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzev.run():void");
    }
}
