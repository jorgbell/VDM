package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdes implements zzdiz<zzdet> {
    private final zzefx zza;
    private final zzclg zzb;
    private final zzcpj zzc;
    private final zzdeu zzd;

    public zzdes(zzefx zzefx, zzclg zzclg, zzcpj zzcpj, zzdeu zzdeu) {
        this.zza = zzefx;
        this.zzb = zzclg;
        this.zzc = zzcpj;
        this.zzd = zzdeu;
    }

    public final zzefw<zzdet> zza() {
        if (zzecs.zzc((String) zzaaa.zzc().zzb(zzaeq.zzaW)) || this.zzd.zzb() || !this.zzc.zze()) {
            return zzefo.zza(new zzdet(new Bundle(), (zzdeq) null));
        }
        this.zzd.zza(true);
        return this.zza.zzb(new zzder(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|(1:9)|10|11|(1:13)|14|15|21|19|1) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x005c */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053 A[Catch:{ zzdrl -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzdet zzb() throws java.lang.Exception {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzaei<java.lang.String> r0 = com.google.android.gms.internal.ads.zzaeq.zzaW
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0062
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzclg r3 = r7.zzb     // Catch:{ zzdrl -> 0x0060 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ zzdrl -> 0x0060 }
            r4.<init>()     // Catch:{ zzdrl -> 0x0060 }
            com.google.android.gms.internal.ads.zzdrx r3 = r3.zzb(r2, r4)     // Catch:{ zzdrl -> 0x0060 }
            r3.zzn()     // Catch:{ zzdrl -> 0x0060 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ zzdrl -> 0x0060 }
            r4.<init>()     // Catch:{ zzdrl -> 0x0060 }
            com.google.android.gms.internal.ads.zzasv r5 = r3.zzA()     // Catch:{ zzdrl -> 0x004d }
            if (r5 == 0) goto L_0x004d
            java.lang.String r6 = "sdk_version"
            java.lang.String r5 = r5.toString()     // Catch:{ zzdrl -> 0x004d }
            r4.putString(r6, r5)     // Catch:{ zzdrl -> 0x004d }
        L_0x004d:
            com.google.android.gms.internal.ads.zzasv r3 = r3.zzz()     // Catch:{ zzdrl -> 0x005c }
            if (r3 == 0) goto L_0x005c
            java.lang.String r5 = "adapter_version"
            java.lang.String r3 = r3.toString()     // Catch:{ zzdrl -> 0x005c }
            r4.putString(r5, r3)     // Catch:{ zzdrl -> 0x005c }
        L_0x005c:
            r1.putBundle(r2, r4)     // Catch:{ zzdrl -> 0x0060 }
            goto L_0x001f
        L_0x0060:
            goto L_0x001f
        L_0x0062:
            com.google.android.gms.internal.ads.zzdet r0 = new com.google.android.gms.internal.ads.zzdet
            r2 = 0
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdes.zzb():com.google.android.gms.internal.ads.zzdet");
    }
}
