package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbof extends zzbql {
    private final zzbgf zzc;
    private final int zzd;
    private final Context zze;
    private final zzbnn zzf;
    private final zzccx zzg;
    private boolean zzh = false;

    zzbof(zzbqk zzbqk, Context context, zzbgf zzbgf, int i, zzbnn zzbnn, zzccx zzccx) {
        super(zzbqk);
        this.zzc = zzbgf;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzbnn;
        this.zzg = zzccx;
    }

    public final void zzR() {
        super.zzR();
        zzbgf zzbgf = this.zzc;
        if (zzbgf != null) {
            zzbgf.destroy();
        }
    }

    public final void zza(zzsv zzsv) {
        zzbgf zzbgf = this.zzc;
        if (zzbgf != null) {
            zzbgf.zzax(zzsv);
        }
    }

    /* JADX WARNING: type inference failed for: r3v10, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(android.app.Activity r3, com.google.android.gms.internal.ads.zzti r4, boolean r5) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0004
            android.content.Context r3 = r2.zze
        L_0x0004:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzar
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005d
            com.google.android.gms.ads.internal.zzs.zzc()
            boolean r0 = com.google.android.gms.ads.internal.util.zzr.zzI(r3)
            if (r0 == 0) goto L_0x005d
            java.lang.String r5 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzbbk.zzi(r5)
            r5 = 11
            r0 = 0
            com.google.android.gms.internal.ads.zzym r5 = com.google.android.gms.internal.ads.zzdsb.zzd(r5, r0, r0)
            r4.zze(r5)
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzaeq.zzas
            com.google.android.gms.internal.ads.zzaeo r5 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r4 = r5.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzdzf r4 = new com.google.android.gms.internal.ads.zzdzf
            android.content.Context r3 = r3.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbl r5 = com.google.android.gms.ads.internal.zzs.zzq()
            android.os.Looper r5 = r5.zza()
            r4.<init>(r3, r5)
            com.google.android.gms.internal.ads.zzdra r3 = r2.zza
            com.google.android.gms.internal.ads.zzdqz r3 = r3.zzb
            com.google.android.gms.internal.ads.zzdqr r3 = r3.zzb
            java.lang.String r3 = r3.zzb
            r4.zza(r3)
            return
        L_0x005d:
            boolean r0 = r2.zzh
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = "App open interstitial ad is already visible."
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
        L_0x0066:
            boolean r0 = r2.zzh
            if (r0 != 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzccx r0 = r2.zzg     // Catch:{ zzccw -> 0x0073 }
            r0.zza(r5, r3)     // Catch:{ zzccw -> 0x0073 }
            r3 = 1
            r2.zzh = r3
            return
        L_0x0073:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzym r3 = com.google.android.gms.internal.ads.zzdsb.zza(r3)
            r4.zze(r3)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbof.zzb(android.app.Activity, com.google.android.gms.internal.ads.zzti, boolean):void");
    }

    public final int zzc() {
        return this.zzd;
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
