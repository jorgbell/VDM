package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhp implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhq zze;

    zzhp(zzhq zzhq, boolean z, Uri uri, String str, String str2) {
        this.zze = zzhq;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
        if (r2.zza.zzs.zzc().zzn((java.lang.String) null, com.google.android.gms.measurement.internal.zzea.zzac) == false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae A[SYNTHETIC, Splitter:B:31:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ff A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0113 A[SYNTHETIC, Splitter:B:47:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0146 A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0148 A[Catch:{ Exception -> 0x01d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzhq r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzhr r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzhr r6 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r6 = r6.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzea.zzab     // Catch:{ Exception -> 0x01d9 }
            r8 = 0
            boolean r6 = r6.zzn(r8, r7)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r9 = "Activity created with data 'referrer' without required params"
            java.lang.String r10 = "_cis"
            java.lang.String r11 = "utm_medium"
            java.lang.String r12 = "utm_source"
            java.lang.String r13 = "utm_campaign"
            java.lang.String r14 = "gclid"
            if (r6 != 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzhr r6 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r6 = r6.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzea.zzad     // Catch:{ Exception -> 0x01d9 }
            boolean r6 = r6.zzn(r8, r15)     // Catch:{ Exception -> 0x01d9 }
            if (r6 != 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzhr r6 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r6 = r6.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ Exception -> 0x01d9 }
            boolean r6 = r6.zzn(r8, r15)     // Catch:{ Exception -> 0x01d9 }
            if (r6 == 0) goto L_0x005c
        L_0x004e:
            com.google.android.gms.measurement.internal.zzhr r6 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r6 = r6.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzkp r6 = r6.zzl()     // Catch:{ Exception -> 0x01d9 }
            boolean r15 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01d9 }
            if (r15 == 0) goto L_0x005e
        L_0x005c:
            r6 = r8
            goto L_0x00a9
        L_0x005e:
            boolean r15 = r5.contains(r14)     // Catch:{ Exception -> 0x01d9 }
            if (r15 != 0) goto L_0x0084
            boolean r15 = r5.contains(r13)     // Catch:{ Exception -> 0x01d9 }
            if (r15 != 0) goto L_0x0084
            boolean r15 = r5.contains(r12)     // Catch:{ Exception -> 0x01d9 }
            if (r15 != 0) goto L_0x0084
            boolean r15 = r5.contains(r11)     // Catch:{ Exception -> 0x01d9 }
            if (r15 != 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzfp r6 = r6.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzau()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzek r6 = r6.zzj()     // Catch:{ Exception -> 0x01d9 }
            r6.zza(r9)     // Catch:{ Exception -> 0x01d9 }
            goto L_0x005c
        L_0x0084:
            java.lang.String r15 = "https://google.com/search?"
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x01d9 }
            int r16 = r8.length()     // Catch:{ Exception -> 0x01d9 }
            if (r16 == 0) goto L_0x0095
            java.lang.String r8 = r15.concat(r8)     // Catch:{ Exception -> 0x01d9 }
            goto L_0x009a
        L_0x0095:
            java.lang.String r8 = new java.lang.String     // Catch:{ Exception -> 0x01d9 }
            r8.<init>(r15)     // Catch:{ Exception -> 0x01d9 }
        L_0x009a:
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x01d9 }
            android.os.Bundle r6 = r6.zzi(r8)     // Catch:{ Exception -> 0x01d9 }
            if (r6 == 0) goto L_0x00a9
            java.lang.String r8 = "referrer"
            r6.putString(r10, r8)     // Catch:{ Exception -> 0x01d9 }
        L_0x00a9:
            java.lang.String r8 = "_cmp"
            r15 = 1
            if (r0 == 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzl()     // Catch:{ Exception -> 0x01d9 }
            android.os.Bundle r0 = r0.zzi(r3)     // Catch:{ Exception -> 0x01d9 }
            if (r0 == 0) goto L_0x0100
            java.lang.String r3 = "intent"
            r0.putString(r10, r3)     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzhr r3 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r3 = r3.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ Exception -> 0x01d9 }
            r10 = 0
            boolean r3 = r3.zzn(r10, r7)     // Catch:{ Exception -> 0x01d9 }
            if (r3 == 0) goto L_0x00f2
            boolean r3 = r0.containsKey(r14)     // Catch:{ Exception -> 0x01d9 }
            if (r3 != 0) goto L_0x00f2
            if (r6 == 0) goto L_0x00f2
            boolean r3 = r6.containsKey(r14)     // Catch:{ Exception -> 0x01d9 }
            if (r3 == 0) goto L_0x00f2
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01d9 }
            r7 = 0
            java.lang.String r10 = r6.getString(r14)     // Catch:{ Exception -> 0x01d9 }
            r3[r7] = r10     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r7 = "_cer"
            java.lang.String r10 = "gclid=%s"
            java.lang.String r3 = java.lang.String.format(r10, r3)     // Catch:{ Exception -> 0x01d9 }
            r0.putString(r7, r3)     // Catch:{ Exception -> 0x01d9 }
        L_0x00f2:
            com.google.android.gms.measurement.internal.zzhr r3 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            r3.zzs(r4, r8, r0)     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzhr r3 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzr r3 = r3.zzb     // Catch:{ Exception -> 0x01d9 }
            r3.zzb(r4, r0)     // Catch:{ Exception -> 0x01d9 }
            goto L_0x0100
        L_0x00ff:
            r0 = 0
        L_0x0100:
            com.google.android.gms.measurement.internal.zzhr r3 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r3 = r3.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzea.zzad     // Catch:{ Exception -> 0x01d9 }
            r10 = 0
            boolean r3 = r3.zzn(r10, r7)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r7 = "auto"
            if (r3 == 0) goto L_0x0140
            com.google.android.gms.measurement.internal.zzhr r3 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r3 = r3.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ Exception -> 0x01d9 }
            r15 = 0
            boolean r3 = r3.zzn(r15, r10)     // Catch:{ Exception -> 0x01d9 }
            if (r3 != 0) goto L_0x0140
            if (r6 == 0) goto L_0x0140
            boolean r3 = r6.containsKey(r14)     // Catch:{ Exception -> 0x01d9 }
            if (r3 == 0) goto L_0x0140
            if (r0 == 0) goto L_0x0134
            boolean r0 = r0.containsKey(r14)     // Catch:{ Exception -> 0x01d9 }
            if (r0 != 0) goto L_0x0140
        L_0x0134:
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r3 = "_lgclid"
            java.lang.String r10 = r6.getString(r14)     // Catch:{ Exception -> 0x01d9 }
            r15 = 1
            r0.zzy(r7, r3, r10, r15)     // Catch:{ Exception -> 0x01d9 }
        L_0x0140:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01d9 }
            if (r0 == 0) goto L_0x0148
            goto L_0x01c8
        L_0x0148:
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r5)     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ Exception -> 0x01d9 }
            r10 = 0
            boolean r0 = r0.zzn(r10, r3)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r3 = "_ldl"
            if (r0 == 0) goto L_0x0194
            if (r6 == 0) goto L_0x017b
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            r0.zzs(r4, r8, r6)     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzb     // Catch:{ Exception -> 0x01d9 }
            r0.zzb(r4, r6)     // Catch:{ Exception -> 0x01d9 }
            goto L_0x018c
        L_0x017b:
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ Exception -> 0x01d9 }
        L_0x018c:
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            r4 = 1
            r5 = 0
            r0.zzy(r7, r3, r5, r4)     // Catch:{ Exception -> 0x01d9 }
            return
        L_0x0194:
            boolean r0 = r5.contains(r14)     // Catch:{ Exception -> 0x01d9 }
            if (r0 == 0) goto L_0x01c9
            boolean r0 = r5.contains(r13)     // Catch:{ Exception -> 0x01d9 }
            if (r0 != 0) goto L_0x01bc
            boolean r0 = r5.contains(r12)     // Catch:{ Exception -> 0x01d9 }
            if (r0 != 0) goto L_0x01bc
            boolean r0 = r5.contains(r11)     // Catch:{ Exception -> 0x01d9 }
            if (r0 != 0) goto L_0x01bc
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ Exception -> 0x01d9 }
            if (r0 != 0) goto L_0x01bc
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ Exception -> 0x01d9 }
            if (r0 == 0) goto L_0x01c9
        L_0x01bc:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01d9 }
            if (r0 != 0) goto L_0x01c8
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            r4 = 1
            r0.zzy(r7, r3, r5, r4)     // Catch:{ Exception -> 0x01d9 }
        L_0x01c8:
            return
        L_0x01c9:
            com.google.android.gms.measurement.internal.zzhr r0 = r2.zza     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzs     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ Exception -> 0x01d9 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ Exception -> 0x01d9 }
            r0.zza(r9)     // Catch:{ Exception -> 0x01d9 }
            return
        L_0x01d9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhr r2 = r2.zza
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zzb(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhp.run():void");
    }
}
