package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzaf implements Callable<Void> {
    final /* synthetic */ zzah zza;

    zzaf(zzah zzah) {
        this.zza = zzah;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object call() throws java.lang.Exception {
        /*
            r10 = this;
            com.android.billingclient.api.zzah r0 = r10.zza
            java.lang.Object r0 = r0.zzb
            monitor-enter(r0)
            com.android.billingclient.api.zzah r1 = r10.zza     // Catch:{ all -> 0x0162 }
            boolean r1 = r1.zzc     // Catch:{ all -> 0x0162 }
            r2 = 0
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0162 }
            goto L_0x0161
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0162 }
            r0 = 3
            r1 = 0
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x013a }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x013a }
            android.content.Context r3 = r3.zzf     // Catch:{ Exception -> 0x013a }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x013a }
            r4 = 16
            r5 = 16
            r6 = 3
        L_0x0027:
            if (r5 < r0) goto L_0x0040
            com.android.billingclient.api.zzah r7 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r7 = r7.zza     // Catch:{ Exception -> 0x003d }
            com.google.android.gms.internal.play_billing.zzd r7 = r7.zzg     // Catch:{ Exception -> 0x003d }
            java.lang.String r8 = "subs"
            int r6 = r7.zza(r5, r3, r8)     // Catch:{ Exception -> 0x003d }
            if (r6 != 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            int r5 = r5 + -1
            goto L_0x0027
        L_0x003d:
            r0 = r6
            goto L_0x013a
        L_0x0040:
            r5 = 0
        L_0x0041:
            com.android.billingclient.api.zzah r7 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r7 = r7.zza     // Catch:{ Exception -> 0x003d }
            r8 = 5
            r9 = 1
            if (r5 < r8) goto L_0x004b
            r8 = 1
            goto L_0x004c
        L_0x004b:
            r8 = 0
        L_0x004c:
            boolean unused = r7.zzj = r8     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r7 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r7 = r7.zza     // Catch:{ Exception -> 0x003d }
            if (r5 < r0) goto L_0x0057
            r8 = 1
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            boolean unused = r7.zzi = r8     // Catch:{ Exception -> 0x003d }
            if (r5 >= r0) goto L_0x0064
            java.lang.String r5 = "BillingClient"
            java.lang.String r7 = "In-app billing API does not support subscription on this device."
            com.google.android.gms.internal.play_billing.zza.zza(r5, r7)     // Catch:{ Exception -> 0x003d }
        L_0x0064:
            r5 = 16
        L_0x0066:
            if (r5 < r0) goto L_0x0083
            com.android.billingclient.api.zzah r7 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r7 = r7.zza     // Catch:{ Exception -> 0x003d }
            com.google.android.gms.internal.play_billing.zzd r7 = r7.zzg     // Catch:{ Exception -> 0x003d }
            java.lang.String r8 = "inapp"
            int r6 = r7.zza(r5, r3, r8)     // Catch:{ Exception -> 0x003d }
            if (r6 != 0) goto L_0x0080
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int unused = r3.zzk = r5     // Catch:{ Exception -> 0x003d }
            goto L_0x0083
        L_0x0080:
            int r5 = r5 + -1
            goto L_0x0066
        L_0x0083:
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r5 = r3.zzk     // Catch:{ Exception -> 0x003d }
            if (r5 < r4) goto L_0x008f
            r4 = 1
            goto L_0x0090
        L_0x008f:
            r4 = 0
        L_0x0090:
            boolean unused = r3.zzs = r4     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x003d }
            r5 = 15
            if (r4 < r5) goto L_0x00a1
            r4 = 1
            goto L_0x00a2
        L_0x00a1:
            r4 = 0
        L_0x00a2:
            boolean unused = r3.zzr = r4     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x003d }
            r5 = 14
            if (r4 < r5) goto L_0x00b3
            r4 = 1
            goto L_0x00b4
        L_0x00b3:
            r4 = 0
        L_0x00b4:
            boolean unused = r3.zzq = r4     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x003d }
            r5 = 12
            if (r4 < r5) goto L_0x00c5
            r4 = 1
            goto L_0x00c6
        L_0x00c5:
            r4 = 0
        L_0x00c6:
            boolean unused = r3.zzp = r4     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x003d }
            r5 = 10
            if (r4 < r5) goto L_0x00d7
            r4 = 1
            goto L_0x00d8
        L_0x00d7:
            r4 = 0
        L_0x00d8:
            boolean unused = r3.zzo = r4     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x003d }
            r5 = 9
            if (r4 < r5) goto L_0x00e9
            r4 = 1
            goto L_0x00ea
        L_0x00e9:
            r4 = 0
        L_0x00ea:
            boolean unused = r3.zzn = r4     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x003d }
            r5 = 8
            if (r4 < r5) goto L_0x00fb
            r4 = 1
            goto L_0x00fc
        L_0x00fb:
            r4 = 0
        L_0x00fc:
            boolean unused = r3.zzm = r4     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x003d }
            r5 = 6
            if (r4 < r5) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            r9 = 0
        L_0x010c:
            boolean unused = r3.zzl = r9     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r3 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza     // Catch:{ Exception -> 0x003d }
            int r3 = r3.zzk     // Catch:{ Exception -> 0x003d }
            if (r3 >= r0) goto L_0x0120
            java.lang.String r0 = "BillingClient"
            java.lang.String r3 = "In-app billing API version 3 is not supported on this device."
            com.google.android.gms.internal.play_billing.zza.zzb(r0, r3)     // Catch:{ Exception -> 0x003d }
        L_0x0120:
            if (r6 != 0) goto L_0x012b
            com.android.billingclient.api.zzah r0 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r0 = r0.zza     // Catch:{ Exception -> 0x003d }
            r3 = 2
            int unused = r0.zza = r3     // Catch:{ Exception -> 0x003d }
            goto L_0x0150
        L_0x012b:
            com.android.billingclient.api.zzah r0 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r0 = r0.zza     // Catch:{ Exception -> 0x003d }
            int unused = r0.zza = r1     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.zzah r0 = r10.zza     // Catch:{ Exception -> 0x003d }
            com.android.billingclient.api.BillingClientImpl r0 = r0.zza     // Catch:{ Exception -> 0x003d }
            com.google.android.gms.internal.play_billing.zzd unused = r0.zzg = r2     // Catch:{ Exception -> 0x003d }
            goto L_0x0150
        L_0x013a:
            java.lang.String r3 = "BillingClient"
            java.lang.String r4 = "Exception while checking if billing is supported; try to reconnect"
            com.google.android.gms.internal.play_billing.zza.zzb(r3, r4)
            com.android.billingclient.api.zzah r3 = r10.zza
            com.android.billingclient.api.BillingClientImpl r3 = r3.zza
            int unused = r3.zza = r1
            com.android.billingclient.api.zzah r1 = r10.zza
            com.android.billingclient.api.BillingClientImpl r1 = r1.zza
            com.google.android.gms.internal.play_billing.zzd unused = r1.zzg = r2
            r6 = r0
        L_0x0150:
            if (r6 != 0) goto L_0x015a
            com.android.billingclient.api.zzah r0 = r10.zza
            com.android.billingclient.api.BillingResult r1 = com.android.billingclient.api.zzam.zzp
            r0.zzf(r1)
            goto L_0x0161
        L_0x015a:
            com.android.billingclient.api.zzah r0 = r10.zza
            com.android.billingclient.api.BillingResult r1 = com.android.billingclient.api.zzam.zza
            r0.zzf(r1)
        L_0x0161:
            return r2
        L_0x0162:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0162 }
            goto L_0x0166
        L_0x0165:
            throw r1
        L_0x0166:
            goto L_0x0165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzaf.call():java.lang.Object");
    }
}
