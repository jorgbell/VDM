package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzetc implements zzeum {
    private static final zzetc zza = new zzetc();

    private zzetc() {
    }

    public static zzetc zza() {
        return zza;
    }

    public final boolean zzb(Class<?> cls) {
        return zzeth.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzeul zzc(java.lang.Class<?> r5) {
        /*
            r4 = this;
            java.lang.Class<com.google.android.gms.internal.ads.zzeth> r0 = com.google.android.gms.internal.ads.zzeth.class
            boolean r1 = r0.isAssignableFrom(r5)
            if (r1 != 0) goto L_0x0028
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.getName()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = "Unsupported message type: "
            int r2 = r5.length()
            if (r2 == 0) goto L_0x001f
            java.lang.String r5 = r1.concat(r5)
            goto L_0x0024
        L_0x001f:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1)
        L_0x0024:
            r0.<init>(r5)
            throw r0
        L_0x0028:
            java.lang.Class r0 = r5.asSubclass(r0)     // Catch:{ Exception -> 0x0039 }
            com.google.android.gms.internal.ads.zzeth r0 = com.google.android.gms.internal.ads.zzeth.zzax(r0)     // Catch:{ Exception -> 0x0039 }
            r1 = 3
            r2 = 0
            java.lang.Object r0 = r0.zzb(r1, r2, r2)     // Catch:{ Exception -> 0x0039 }
            com.google.android.gms.internal.ads.zzeul r0 = (com.google.android.gms.internal.ads.zzeul) r0     // Catch:{ Exception -> 0x0039 }
            return r0
        L_0x0039:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r5 = r5.getName()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "Unable to get message info for "
            int r3 = r5.length()
            if (r3 == 0) goto L_0x0051
            java.lang.String r5 = r2.concat(r5)
            goto L_0x0056
        L_0x0051:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r2)
        L_0x0056:
            r1.<init>(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzetc.zzc(java.lang.Class):com.google.android.gms.internal.ads.zzeul");
    }
}
