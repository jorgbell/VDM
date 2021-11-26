package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdah implements zzccx {
    private final Context zza;
    private final zzckt zzb;
    private final zzdrg zzc;
    private final zzbbq zzd;
    private final zzdqo zze;
    private final zzefw<zzcjx> zzf;
    private final zzbgf zzg;
    private final zzaks zzh;
    private final boolean zzi;

    /* synthetic */ zzdah(Context context, zzckt zzckt, zzdrg zzdrg, zzbbq zzbbq, zzdqo zzdqo, zzefw zzefw, zzbgf zzbgf, zzaks zzaks, boolean z, zzdae zzdae) {
        this.zza = context;
        this.zzb = zzckt;
        this.zzc = zzdrg;
        this.zzd = zzbbq;
        this.zze = zzdqo;
        this.zzf = zzefw;
        this.zzg = zzbgf;
        this.zzh = zzaks;
        this.zzi = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r22, android.content.Context r23) {
        /*
            r21 = this;
            r1 = r21
            com.google.android.gms.internal.ads.zzefw<com.google.android.gms.internal.ads.zzcjx> r0 = r1.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzefo.zzq(r0)
            com.google.android.gms.internal.ads.zzcjx r0 = (com.google.android.gms.internal.ads.zzcjx) r0
            com.google.android.gms.internal.ads.zzdqo r2 = r1.zze     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbgf r3 = r1.zzg     // Catch:{ zzbgq -> 0x00f6 }
            boolean r3 = r3.zzaA()     // Catch:{ zzbgq -> 0x00f6 }
            r4 = 1
            if (r3 != 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzbgf r2 = r1.zzg     // Catch:{ zzbgq -> 0x00f6 }
        L_0x0017:
            r11 = r2
            goto L_0x007d
        L_0x0019:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzay     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzaeo r5 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ zzbgq -> 0x00f6 }
            java.lang.Object r3 = r5.zzb(r3)     // Catch:{ zzbgq -> 0x00f6 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzbgq -> 0x00f6 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzbgq -> 0x00f6 }
            if (r3 != 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzbgf r2 = r1.zzg     // Catch:{ zzbgq -> 0x00f6 }
            goto L_0x0017
        L_0x002e:
            com.google.android.gms.internal.ads.zzckt r3 = r1.zzb     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzdrg r5 = r1.zzc     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzyx r5 = r5.zze     // Catch:{ zzbgq -> 0x00f6 }
            r6 = 0
            com.google.android.gms.internal.ads.zzbgf r3 = r3.zza(r5, r6, r6)     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzcbh r5 = r0.zzk()     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzalf.zzb(r3, r5)     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzckx r5 = new com.google.android.gms.internal.ads.zzckx     // Catch:{ zzbgq -> 0x00f6 }
            r5.<init>()     // Catch:{ zzbgq -> 0x00f6 }
            android.content.Context r7 = r1.zza     // Catch:{ zzbgq -> 0x00f6 }
            r8 = r3
            android.view.View r8 = (android.view.View) r8     // Catch:{ zzbgq -> 0x00f6 }
            r5.zza(r7, r8)     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzcks r7 = r0.zzl()     // Catch:{ zzbgq -> 0x00f6 }
            boolean r8 = r1.zzi     // Catch:{ zzbgq -> 0x00f6 }
            if (r8 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzaks r8 = r1.zzh     // Catch:{ zzbgq -> 0x00f6 }
            goto L_0x0059
        L_0x0058:
            r8 = r6
        L_0x0059:
            r7.zzi(r3, r4, r8)     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbht r7 = r3.zzR()     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzdaf r8 = new com.google.android.gms.internal.ads.zzdaf     // Catch:{ zzbgq -> 0x00f6 }
            r8.<init>(r5, r3)     // Catch:{ zzbgq -> 0x00f6 }
            r7.zzw(r8)     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbht r5 = r3.zzR()     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzbhs r7 = com.google.android.gms.internal.ads.zzdag.zza(r3)     // Catch:{ zzbgq -> 0x00f6 }
            r5.zzx(r7)     // Catch:{ zzbgq -> 0x00f6 }
            com.google.android.gms.internal.ads.zzdqt r2 = r2.zzr     // Catch:{ zzbgq -> 0x00f6 }
            java.lang.String r5 = r2.zzb     // Catch:{ zzbgq -> 0x00f6 }
            java.lang.String r2 = r2.zza     // Catch:{ zzbgq -> 0x00f6 }
            r3.zzat(r5, r2, r6)     // Catch:{ zzbgq -> 0x00f6 }
            r11 = r3
        L_0x007d:
            r11.zzag(r4)
            com.google.android.gms.ads.internal.zzj r2 = new com.google.android.gms.ads.internal.zzj
            boolean r3 = r1.zzi
            r5 = 0
            if (r3 == 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzaks r3 = r1.zzh
            boolean r3 = r3.zzc(r5)
            r13 = r3
            goto L_0x0090
        L_0x008f:
            r13 = 0
        L_0x0090:
            com.google.android.gms.ads.internal.zzs.zzc()
            android.content.Context r3 = r1.zza
            boolean r14 = com.google.android.gms.ads.internal.util.zzr.zzK(r3)
            boolean r3 = r1.zzi
            if (r3 == 0) goto L_0x00a5
            com.google.android.gms.internal.ads.zzaks r3 = r1.zzh
            boolean r3 = r3.zzd()
            r15 = r3
            goto L_0x00a6
        L_0x00a5:
            r15 = 0
        L_0x00a6:
            boolean r3 = r1.zzi
            if (r3 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzaks r3 = r1.zzh
            float r3 = r3.zze()
            r16 = r3
            goto L_0x00b6
        L_0x00b3:
            r3 = 0
            r16 = 0
        L_0x00b6:
            com.google.android.gms.internal.ads.zzdqo r3 = r1.zze
            r17 = -1
            boolean r5 = r3.zzJ
            boolean r3 = r3.zzK
            r12 = r2
            r18 = r22
            r19 = r5
            r20 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            com.google.android.gms.ads.internal.zzs.zzb()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzccm r9 = r0.zzj()
            com.google.android.gms.internal.ads.zzdqo r0 = r1.zze
            int r12 = r0.zzL
            com.google.android.gms.internal.ads.zzbbq r13 = r1.zzd
            java.lang.String r14 = r0.zzA
            com.google.android.gms.internal.ads.zzdqt r0 = r0.zzr
            r8 = 0
            r10 = 0
            java.lang.String r5 = r0.zzb
            java.lang.String r0 = r0.zza
            com.google.android.gms.internal.ads.zzdrg r6 = r1.zzc
            java.lang.String r6 = r6.zzf
            r7 = r3
            r15 = r2
            r16 = r5
            r17 = r0
            r18 = r6
            r7.<init>((com.google.android.gms.internal.ads.zzyi) r8, (com.google.android.gms.ads.internal.overlay.zzp) r9, (com.google.android.gms.ads.internal.overlay.zzw) r10, (com.google.android.gms.internal.ads.zzbgf) r11, (int) r12, (com.google.android.gms.internal.ads.zzbbq) r13, (java.lang.String) r14, (com.google.android.gms.ads.internal.zzj) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18)
            r0 = r23
            com.google.android.gms.ads.internal.overlay.zzn.zza(r0, r3, r4)
            return
        L_0x00f6:
            r0 = move-exception
            java.lang.String r2 = ""
            com.google.android.gms.internal.ads.zzbbk.zzg(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdah.zza(boolean, android.content.Context):void");
    }
}
