package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrt {
    private final Context zza;
    private final zzbbq zzb;
    private final zzdrg zzc;
    private final Executor zzd;

    public zzcrt(Context context, zzbbq zzbbq, zzdrg zzdrg, Executor executor) {
        this.zza = context;
        this.zzb = zzbbq;
        this.zzc = zzdrg;
        this.zzd = executor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0053, code lost:
        if (r2.equals(r4) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzefw<com.google.android.gms.internal.ads.zzdra> zza() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzaov r0 = com.google.android.gms.ads.internal.zzs.zzp()
            android.content.Context r1 = r6.zza
            com.google.android.gms.internal.ads.zzbbq r2 = r6.zzb
            com.google.android.gms.internal.ads.zzape r0 = r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zzaoy<org.json.JSONObject> r1 = com.google.android.gms.internal.ads.zzapb.zza
            java.lang.String r2 = "google.afma.response.normalize"
            com.google.android.gms.internal.ads.zzaou r0 = r0.zza(r2, r1, r1)
            com.google.android.gms.internal.ads.zzdrg r1 = r6.zzc
            com.google.android.gms.internal.ads.zzys r1 = r1.zzd
            com.google.android.gms.internal.ads.zzyk r1 = r1.zzs
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzaeq.zzeU
            com.google.android.gms.internal.ads.zzaeo r3 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x002f
            goto L_0x0056
        L_0x002f:
            if (r1 == 0) goto L_0x007c
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007c }
            java.lang.String r4 = r1.zza     // Catch:{ JSONException -> 0x007c }
            r2.<init>(r4)     // Catch:{ JSONException -> 0x007c }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007c }
            java.lang.String r5 = r1.zzb     // Catch:{ JSONException -> 0x007c }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x007c }
            java.lang.String r5 = "request_id"
            java.lang.String r2 = r2.optString(r5, r3)
            java.lang.String r4 = r4.optString(r5, r3)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x007c
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0056
            goto L_0x007c
        L_0x0056:
            com.google.android.gms.internal.ads.zzefw r2 = com.google.android.gms.internal.ads.zzefo.zza(r3)
            com.google.android.gms.internal.ads.zzcrq r3 = new com.google.android.gms.internal.ads.zzcrq
            r3.<init>(r6, r1)
            java.util.concurrent.Executor r1 = r6.zzd
            com.google.android.gms.internal.ads.zzefw r1 = com.google.android.gms.internal.ads.zzefo.zzh(r2, r3, r1)
            com.google.android.gms.internal.ads.zzcrr r2 = new com.google.android.gms.internal.ads.zzcrr
            r2.<init>(r0)
            java.util.concurrent.Executor r0 = r6.zzd
            com.google.android.gms.internal.ads.zzefw r0 = com.google.android.gms.internal.ads.zzefo.zzh(r1, r2, r0)
            com.google.android.gms.internal.ads.zzcrs r1 = new com.google.android.gms.internal.ads.zzcrs
            r1.<init>(r6)
            java.util.concurrent.Executor r2 = r6.zzd
            com.google.android.gms.internal.ads.zzefw r0 = com.google.android.gms.internal.ads.zzefo.zzh(r0, r1, r2)
            return r0
        L_0x007c:
            com.google.android.gms.internal.ads.zzczn r0 = new com.google.android.gms.internal.ads.zzczn
            r1 = 14
            java.lang.String r2 = "Mismatch request IDs."
            r0.<init>(r1, r2)
            com.google.android.gms.internal.ads.zzefw r0 = com.google.android.gms.internal.ads.zzefo.zzb(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrt.zza():com.google.android.gms.internal.ads.zzefw");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzb(JSONObject jSONObject) throws Exception {
        return zzefo.zza(new zzdra(new zzdqx(this.zzc), zzdqz.zza(new StringReader(jSONObject.toString()))));
    }
}
