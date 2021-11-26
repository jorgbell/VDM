package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczp<AdT> implements zzeev<zzdra, AdT> {
    private final zzdve zza;
    private final zzbuh zzb;
    private final zzdwd zzc;
    private final zzdwg zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzbqo<AdT> zzg;
    private final zzczk zzh;
    private final zzcwb zzi;

    public zzczp(zzdve zzdve, zzczk zzczk, zzbuh zzbuh, zzdwd zzdwd, zzdwg zzdwg, zzbqo<AdT> zzbqo, Executor executor, ScheduledExecutorService scheduledExecutorService, zzcwb zzcwb) {
        this.zza = zzdve;
        this.zzh = zzczk;
        this.zzb = zzbuh;
        this.zzc = zzdwd;
        this.zzd = zzdwg;
        this.zzg = zzbqo;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzcwb;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zzefw zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzdra r9 = (com.google.android.gms.internal.ads.zzdra) r9
            com.google.android.gms.internal.ads.zzdqz r0 = r9.zzb
            com.google.android.gms.internal.ads.zzdqr r0 = r0.zzb
            int r0 = r0.zze
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 == 0) goto L_0x0044
            if (r0 < r1) goto L_0x0027
            if (r0 >= r2) goto L_0x0027
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzdF
            com.google.android.gms.internal.ads.zzaeo r3 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = "No fill."
            goto L_0x0046
        L_0x0027:
            if (r0 < r2) goto L_0x0030
            r3 = 400(0x190, float:5.6E-43)
            if (r0 >= r3) goto L_0x0030
            java.lang.String r0 = "No location header to follow redirect or too many redirects."
            goto L_0x0046
        L_0x0030:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 46
            r3.<init>(r4)
            java.lang.String r4 = "Received error HTTP response code: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            goto L_0x0046
        L_0x0044:
            java.lang.String r0 = "No ad config."
        L_0x0046:
            com.google.android.gms.internal.ads.zzdqz r3 = r9.zzb
            com.google.android.gms.internal.ads.zzdqr r3 = r3.zzb
            com.google.android.gms.internal.ads.zzdqq r3 = r3.zzh
            if (r3 == 0) goto L_0x0052
            java.lang.String r0 = r3.zza()
        L_0x0052:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzfw
            com.google.android.gms.internal.ads.zzaeo r4 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = 3
            if (r3 == 0) goto L_0x007c
            com.google.android.gms.internal.ads.zzdqz r3 = r9.zzb
            com.google.android.gms.internal.ads.zzdqr r3 = r3.zzb
            int r3 = r3.zze
            if (r3 == 0) goto L_0x007c
            if (r3 < r1) goto L_0x0071
            if (r3 < r2) goto L_0x007c
        L_0x0071:
            com.google.android.gms.internal.ads.zzczn r9 = new com.google.android.gms.internal.ads.zzczn
            r9.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzefw r9 = com.google.android.gms.internal.ads.zzefo.zzb(r9)
            goto L_0x0176
        L_0x007c:
            com.google.android.gms.internal.ads.zzdve r1 = r8.zza
            com.google.android.gms.internal.ads.zzduy r2 = com.google.android.gms.internal.ads.zzduy.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzczn r3 = new com.google.android.gms.internal.ads.zzczn
            r3.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzefw r0 = com.google.android.gms.internal.ads.zzefo.zzb(r3)
            com.google.android.gms.internal.ads.zzduv r0 = com.google.android.gms.internal.ads.zzdup.zza(r0, r2, r1)
            com.google.android.gms.internal.ads.zzduk r0 = r0.zzi()
            com.google.android.gms.internal.ads.zzbuh r1 = r8.zzb
            com.google.android.gms.internal.ads.zzbmg r2 = new com.google.android.gms.internal.ads.zzbmg
            com.google.android.gms.internal.ads.zzdwg r3 = r8.zzd
            com.google.android.gms.internal.ads.zzdwd r4 = r8.zzc
            r2.<init>(r9, r3, r4)
            java.util.concurrent.Executor r3 = r8.zze
            r1.zzh(r2, r3)
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaeq.zzfx
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00fd
            com.google.android.gms.internal.ads.zzdqz r1 = r9.zzb
            java.util.List<com.google.android.gms.internal.ads.zzdqo> r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
        L_0x00bb:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00fd
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.ads.zzdqo r2 = (com.google.android.gms.internal.ads.zzdqo) r2
            com.google.android.gms.internal.ads.zzcwb r3 = r8.zzi
            r3.zza(r2)
            java.util.List<java.lang.String> r3 = r2.zza
            java.util.Iterator r3 = r3.iterator()
        L_0x00d2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00ef
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.internal.ads.zzbqo<AdT> r5 = r8.zzg
            int r6 = r2.zzb
            com.google.android.gms.internal.ads.zzcvw r4 = r5.zza(r6, r4)
            if (r4 == 0) goto L_0x00d2
            boolean r4 = r4.zza(r9, r2)
            if (r4 == 0) goto L_0x00d2
            goto L_0x00bb
        L_0x00ef:
            com.google.android.gms.internal.ads.zzcwb r3 = r8.zzi
            r4 = 0
            r6 = 1
            r7 = 0
            com.google.android.gms.internal.ads.zzym r6 = com.google.android.gms.internal.ads.zzdsb.zzd(r6, r7, r7)
            r3.zzb(r2, r4, r6)
            goto L_0x00bb
        L_0x00fd:
            com.google.android.gms.internal.ads.zzdqz r1 = r9.zzb
            java.util.List<com.google.android.gms.internal.ads.zzdqo> r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x0106:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0175
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzdqo r3 = (com.google.android.gms.internal.ads.zzdqo) r3
            java.util.List<java.lang.String> r4 = r3.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x0118:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0172
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzbqo<AdT> r6 = r8.zzg
            int r7 = r3.zzb
            com.google.android.gms.internal.ads.zzcvw r6 = r6.zza(r7, r5)
            if (r6 == 0) goto L_0x0118
            boolean r7 = r6.zza(r9, r3)
            if (r7 == 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzdve r4 = r8.zza
            com.google.android.gms.internal.ads.zzduy r7 = com.google.android.gms.internal.ads.zzduy.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzduv r0 = r4.zza(r7, r0)
            java.lang.String r4 = java.lang.String.valueOf(r5)
            int r4 = r4.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r4 = r4 + 26
            r7.<init>(r4)
            java.lang.String r4 = "render-config-"
            r7.append(r4)
            r7.append(r2)
            java.lang.String r4 = "-"
            r7.append(r4)
            r7.append(r5)
            java.lang.String r4 = r7.toString()
            com.google.android.gms.internal.ads.zzduv r0 = r0.zza(r4)
            com.google.android.gms.internal.ads.zzczo r4 = new com.google.android.gms.internal.ads.zzczo
            r4.<init>(r8, r9, r3, r6)
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.zzduv r0 = r0.zzg(r3, r4)
            com.google.android.gms.internal.ads.zzduk r0 = r0.zzi()
        L_0x0172:
            int r2 = r2 + 1
            goto L_0x0106
        L_0x0175:
            r9 = r0
        L_0x0176:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczp.zza(java.lang.Object):com.google.android.gms.internal.ads.zzefw");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzb(zzdra zzdra, zzdqo zzdqo, zzcvw zzcvw, Throwable th) throws Exception {
        zzczk zzczk = this.zzh;
        zzdqr zzdqr = zzdra.zzb.zzb;
        zzefw zzg2 = zzefo.zzg(zzcvw.zzb(zzdra, zzdqo), (long) zzdqo.zzM, TimeUnit.MILLISECONDS, this.zzf);
        zzczk.zza(zzdqr, zzdqo, zzg2);
        return zzg2;
    }
}
