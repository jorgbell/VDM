package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaff;
import com.google.android.gms.internal.ads.zzafp;
import com.google.android.gms.internal.ads.zzajq;
import com.google.android.gms.internal.ads.zzajs;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzatl;
import com.google.android.gms.internal.ads.zzauk;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzcni;
import com.google.android.gms.internal.ads.zzcvk;
import com.google.android.gms.internal.ads.zzcvs;
import com.google.android.gms.internal.ads.zzdqo;
import com.google.android.gms.internal.ads.zzdqr;
import com.google.android.gms.internal.ads.zzdvo;
import com.google.android.gms.internal.ads.zzdwg;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfh;
import com.google.android.gms.internal.ads.zzug;
import com.google.android.gms.internal.ads.zzyi;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzm extends zzauk implements zzaa {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzbgf zzd;
    zzj zze;
    zzr zzf;
    boolean zzg = false;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    boolean zzj = false;
    boolean zzk = false;
    zzi zzl;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private final Object zzp = new Object();
    private Runnable zzq;
    private Runnable zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu = false;
    private boolean zzv = false;
    private boolean zzw = true;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzH(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzc
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzj r0 = r0.zzo
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzac r3 = com.google.android.gms.ads.internal.zzs.zze()
            android.app.Activity r4 = r5.zzb
            boolean r6 = r3.zzo(r4, r6)
            boolean r3 = r5.zzk
            r4 = 19
            if (r3 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0037
        L_0x0023:
            if (r6 != 0) goto L_0x0037
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r4) goto L_0x0038
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzc
            if (r6 == 0) goto L_0x0038
            com.google.android.gms.ads.internal.zzj r6 = r6.zzo
            if (r6 == 0) goto L_0x0038
            boolean r6 = r6.zzg
            if (r6 == 0) goto L_0x0038
            r2 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            android.app.Activity r6 = r5.zzb
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzaL
            com.google.android.gms.internal.ads.zzaeo r3 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0068
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0068
            android.view.View r6 = r6.getDecorView()
            if (r1 == 0) goto L_0x0062
            if (r2 == 0) goto L_0x005f
            r0 = 5894(0x1706, float:8.259E-42)
            goto L_0x0064
        L_0x005f:
            r0 = 5380(0x1504, float:7.539E-42)
            goto L_0x0064
        L_0x0062:
            r0 = 256(0x100, float:3.59E-43)
        L_0x0064:
            r6.setSystemUiVisibility(r0)
            return
        L_0x0068:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0084
            r6.addFlags(r0)
            r6.clearFlags(r3)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0083
            if (r2 == 0) goto L_0x0083
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
        L_0x0083:
            return
        L_0x0084:
            r6.addFlags(r3)
            r6.clearFlags(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzH(android.content.res.Configuration):void");
    }

    private static final void zzI(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper != null && view != null) {
            zzs.zzr().zzj(iObjectWrapper, view);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzbgf zzbgf;
        zzp zzp2;
        if (!this.zzv) {
            this.zzv = true;
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcX)).booleanValue()) {
                synchronized (this.zzp) {
                    if (!this.zzd.zzaa() || this.zzs) {
                        zzB();
                    } else {
                        zzf zzf2 = new zzf(this);
                        this.zzr = zzf2;
                        zzr.zza.postDelayed(zzf2, ((Long) zzaaa.zzc().zzb(zzaeq.zzaI)).longValue());
                    }
                }
            } else {
                zzB();
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
                zzp2.zzbt(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzbgf = adOverlayInfoParcel2.zzd) != null) {
                zzI(zzbgf.zzV(), this.zzc.zzd.zzH());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        zzbgf zzbgf = this.zzd;
        if (zzbgf != null) {
            this.zzl.removeView(zzbgf.zzH());
            zzj zzj2 = this.zze;
            if (zzj2 != null) {
                this.zzd.zzai(zzj2.zzd);
                this.zzd.zzag(false);
                ViewGroup viewGroup = this.zze.zzc;
                View zzH = this.zzd.zzH();
                zzj zzj3 = this.zze;
                viewGroup.addView(zzH, zzj3.zza, zzj3.zzb);
                this.zze = null;
            } else if (this.zzb.getApplicationContext() != null) {
                this.zzd.zzai(this.zzb.getApplicationContext());
            }
            this.zzd = null;
        }
    }

    public final void zzC() {
        if (this.zzm) {
            this.zzm = false;
            zzD();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzD() {
        this.zzd.zzK();
    }

    public final void zzE() {
        this.zzl.zzb = true;
    }

    public final void zzF() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcX)).booleanValue()) {
            synchronized (this.zzp) {
                this.zzs = true;
                Runnable runnable = this.zzr;
                if (runnable != null) {
                    zzebq zzebq = zzr.zza;
                    zzebq.removeCallbacks(runnable);
                    zzebq.post(this.zzr);
                }
            }
            return;
        }
        synchronized (this.zzo) {
            this.zzs = true;
            Runnable runnable2 = this.zzq;
            if (runnable2 != null) {
                zzebq zzebq2 = zzr.zza;
                zzebq2.removeCallbacks(runnable2);
                zzebq2.post(this.zzq);
            }
        }
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    public final void zzc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzw(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzt = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzd() {
        this.zzn = 2;
        this.zzb.finish();
    }

    public final void zze() {
        this.zzn = 1;
    }

    public final void zzf() {
        zzp zzp2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzp2 = adOverlayInfoParcel.zzc) != null) {
            zzp2.zzbr();
        }
    }

    public final boolean zzg() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzZ = this.zzd.zzZ();
            if (!zzZ) {
                this.zzd.zze("onbackblocked", Collections.emptyMap());
            }
            return zzZ;
        }
        this.zzd.goBack();
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A[Catch:{ zzh -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2 A[Catch:{ zzh -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d7 A[Catch:{ zzh -> 0x00e3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzh(android.os.Bundle r9) {
        /*
            r8 = this;
            android.app.Activity r0 = r8.zzb
            r1 = 1
            r0.requestWindowFeature(r1)
            r0 = 0
            if (r9 == 0) goto L_0x0013
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r9.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            r8.zzj = r2
            r2 = 4
            android.app.Activity r3 = r8.zzb     // Catch:{ zzh -> 0x00e3 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzh -> 0x00e3 }
            r8.zzc = r3     // Catch:{ zzh -> 0x00e3 }
            if (r3 == 0) goto L_0x00db
            com.google.android.gms.internal.ads.zzbbq r3 = r3.zzm     // Catch:{ zzh -> 0x00e3 }
            int r3 = r3.zzc     // Catch:{ zzh -> 0x00e3 }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x0030
            r8.zzn = r2     // Catch:{ zzh -> 0x00e3 }
        L_0x0030:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzh -> 0x00e3 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzh -> 0x00e3 }
            if (r3 == 0) goto L_0x0046
            android.app.Activity r3 = r8.zzb     // Catch:{ zzh -> 0x00e3 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzh -> 0x00e3 }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzh -> 0x00e3 }
            r8.zzw = r3     // Catch:{ zzh -> 0x00e3 }
        L_0x0046:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.ads.internal.zzj r4 = r3.zzo     // Catch:{ zzh -> 0x00e3 }
            r5 = 5
            if (r4 == 0) goto L_0x0054
            boolean r6 = r4.zza     // Catch:{ zzh -> 0x00e3 }
            r8.zzk = r6     // Catch:{ zzh -> 0x00e3 }
            if (r6 == 0) goto L_0x006f
            goto L_0x005a
        L_0x0054:
            int r6 = r3.zzk     // Catch:{ zzh -> 0x00e3 }
            if (r6 != r5) goto L_0x006d
            r8.zzk = r1     // Catch:{ zzh -> 0x00e3 }
        L_0x005a:
            int r3 = r3.zzk     // Catch:{ zzh -> 0x00e3 }
            if (r3 == r5) goto L_0x006f
            int r3 = r4.zzf     // Catch:{ zzh -> 0x00e3 }
            r4 = -1
            if (r3 == r4) goto L_0x006f
            com.google.android.gms.ads.internal.overlay.zzl r3 = new com.google.android.gms.ads.internal.overlay.zzl     // Catch:{ zzh -> 0x00e3 }
            r4 = 0
            r3.<init>(r8, r4)     // Catch:{ zzh -> 0x00e3 }
            r3.zzb()     // Catch:{ zzh -> 0x00e3 }
            goto L_0x006f
        L_0x006d:
            r8.zzk = r0     // Catch:{ zzh -> 0x00e3 }
        L_0x006f:
            if (r9 != 0) goto L_0x008b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.ads.internal.overlay.zzp r9 = r9.zzc     // Catch:{ zzh -> 0x00e3 }
            if (r9 == 0) goto L_0x007e
            boolean r3 = r8.zzw     // Catch:{ zzh -> 0x00e3 }
            if (r3 == 0) goto L_0x007e
            r9.zzbo()     // Catch:{ zzh -> 0x00e3 }
        L_0x007e:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzh -> 0x00e3 }
            int r3 = r9.zzk     // Catch:{ zzh -> 0x00e3 }
            if (r3 == r1) goto L_0x008b
            com.google.android.gms.internal.ads.zzyi r9 = r9.zzb     // Catch:{ zzh -> 0x00e3 }
            if (r9 == 0) goto L_0x008b
            r9.onAdClicked()     // Catch:{ zzh -> 0x00e3 }
        L_0x008b:
            com.google.android.gms.ads.internal.overlay.zzi r9 = new com.google.android.gms.ads.internal.overlay.zzi     // Catch:{ zzh -> 0x00e3 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r8.zzc     // Catch:{ zzh -> 0x00e3 }
            java.lang.String r6 = r4.zzn     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.internal.ads.zzbbq r7 = r4.zzm     // Catch:{ zzh -> 0x00e3 }
            java.lang.String r7 = r7.zza     // Catch:{ zzh -> 0x00e3 }
            java.lang.String r4 = r4.zzw     // Catch:{ zzh -> 0x00e3 }
            r9.<init>(r3, r6, r7, r4)     // Catch:{ zzh -> 0x00e3 }
            r8.zzl = r9     // Catch:{ zzh -> 0x00e3 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9.setId(r3)     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.ads.internal.util.zzac r9 = com.google.android.gms.ads.internal.zzs.zze()     // Catch:{ zzh -> 0x00e3 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzh -> 0x00e3 }
            r9.zzr(r3)     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzh -> 0x00e3 }
            int r3 = r9.zzk     // Catch:{ zzh -> 0x00e3 }
            if (r3 == r1) goto L_0x00d7
            r4 = 2
            if (r3 == r4) goto L_0x00ca
            r9 = 3
            if (r3 == r9) goto L_0x00c6
            if (r3 != r5) goto L_0x00be
            r8.zzy(r0)     // Catch:{ zzh -> 0x00e3 }
            return
        L_0x00be:
            com.google.android.gms.ads.internal.overlay.zzh r9 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzh -> 0x00e3 }
            java.lang.String r0 = "Could not determine ad overlay type."
            r9.<init>(r0)     // Catch:{ zzh -> 0x00e3 }
            throw r9     // Catch:{ zzh -> 0x00e3 }
        L_0x00c6:
            r8.zzy(r1)     // Catch:{ zzh -> 0x00e3 }
            return
        L_0x00ca:
            com.google.android.gms.ads.internal.overlay.zzj r1 = new com.google.android.gms.ads.internal.overlay.zzj     // Catch:{ zzh -> 0x00e3 }
            com.google.android.gms.internal.ads.zzbgf r9 = r9.zzd     // Catch:{ zzh -> 0x00e3 }
            r1.<init>(r9)     // Catch:{ zzh -> 0x00e3 }
            r8.zze = r1     // Catch:{ zzh -> 0x00e3 }
            r8.zzy(r0)     // Catch:{ zzh -> 0x00e3 }
            return
        L_0x00d7:
            r8.zzy(r0)     // Catch:{ zzh -> 0x00e3 }
            return
        L_0x00db:
            com.google.android.gms.ads.internal.overlay.zzh r9 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzh -> 0x00e3 }
            java.lang.String r0 = "Could not get info for ad overlay."
            r9.<init>(r0)     // Catch:{ zzh -> 0x00e3 }
            throw r9     // Catch:{ zzh -> 0x00e3 }
        L_0x00e3:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.google.android.gms.internal.ads.zzbbk.zzi(r9)
            r8.zzn = r2
            android.app.Activity r9 = r8.zzb
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzh(android.os.Bundle):void");
    }

    public final void zzi() {
    }

    public final void zzj() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcZ)).booleanValue()) {
            zzbgf zzbgf = this.zzd;
            if (zzbgf == null || zzbgf.zzX()) {
                zzbbk.zzi("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzk() {
        zzp zzp2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
            zzp2.zzbJ();
        }
        zzH(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzcZ)).booleanValue()) {
            zzbgf zzbgf = this.zzd;
            if (zzbgf == null || zzbgf.zzX()) {
                zzbbk.zzi("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzl() {
        zzp zzp2;
        zzc();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
            zzp2.zzbs();
        }
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzcZ)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzz();
    }

    public final void zzm(int i, int i2, Intent intent) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        zzH((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzo(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzp() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcZ)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzz();
    }

    public final void zzq() {
        zzbgf zzbgf = this.zzd;
        if (zzbgf != null) {
            try {
                this.zzl.removeView(zzbgf.zzH());
            } catch (NullPointerException unused) {
            }
        }
        zzz();
    }

    public final void zzr(boolean z) {
        int intValue = ((Integer) zzaaa.zzc().zzb(zzaeq.zzdb)).intValue();
        zzq zzq2 = new zzq();
        zzq2.zzd = 50;
        int i = 0;
        zzq2.zza = true != z ? 0 : intValue;
        if (true != z) {
            i = intValue;
        }
        zzq2.zzb = i;
        zzq2.zzc = intValue;
        this.zzf = new zzr(this.zzb, zzq2, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z ? 9 : 11);
        zzt(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    public final void zzs() {
        this.zzt = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = (r0 = r6.zzc).zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzt(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzaJ
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzc
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.zzj r0 = r0.zzo
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.zzh
            if (r0 == 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzaK
            com.google.android.gms.internal.ads.zzaeo r4 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzc
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.zzj r3 = r3.zzo
            if (r3 == 0) goto L_0x0043
            boolean r3 = r3.zzi
            if (r3 == 0) goto L_0x0043
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzatk r7 = new com.google.android.gms.internal.ads.zzatk
            com.google.android.gms.internal.ads.zzbgf r4 = r6.zzd
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzf(r4)
        L_0x005a:
            com.google.android.gms.ads.internal.overlay.zzr r7 = r6.zzf
            if (r7 == 0) goto L_0x0069
            if (r3 != 0) goto L_0x0066
            if (r8 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            r7.zza(r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzt(boolean, boolean):void");
    }

    public final void zzu(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(-16777216);
        }
    }

    public final void zzv() {
        this.zzl.removeView(this.zzf);
        zzr(true);
    }

    public final void zzw(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzed)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzaaa.zzc().zzb(zzaeq.zzee)).intValue()) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzef)).intValue()) {
                    if (i2 <= ((Integer) zzaaa.zzc().zzb(zzaeq.zzeg)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzs.zzg().zzh(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzx(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzt = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* access modifiers changed from: protected */
    public final void zzy(boolean z) throws zzh {
        if (!this.zzt) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window != null) {
            zzbgf zzbgf = this.zzc.zzd;
            zzb zzb2 = null;
            zzbht zzR = zzbgf != null ? zzbgf.zzR() : null;
            boolean z2 = false;
            boolean z3 = zzR != null && zzR.zzc();
            this.zzm = false;
            if (z3) {
                int i = this.zzc.zzj;
                if (i == 6) {
                    if (this.zzb.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzm = z2;
                } else if (i == 7) {
                    if (this.zzb.getResources().getConfiguration().orientation == 2) {
                        z2 = true;
                    }
                    this.zzm = z2;
                }
            }
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z2);
            zzbbk.zzd(sb.toString());
            zzw(this.zzc.zzj);
            window.setFlags(16777216, 16777216);
            zzbbk.zzd("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzk) {
                this.zzl.setBackgroundColor(-16777216);
            } else {
                this.zzl.setBackgroundColor(zza);
            }
            this.zzb.setContentView(this.zzl);
            this.zzt = true;
            if (z) {
                try {
                    zzs.zzd();
                    Activity activity = this.zzb;
                    zzbgf zzbgf2 = this.zzc.zzd;
                    zzbhv zzP = zzbgf2 != null ? zzbgf2.zzP() : null;
                    zzbgf zzbgf3 = this.zzc.zzd;
                    String zzQ = zzbgf3 != null ? zzbgf3.zzQ() : null;
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                    zzbbq zzbbq = adOverlayInfoParcel.zzm;
                    zzbgf zzbgf4 = adOverlayInfoParcel.zzd;
                    zzbgf zza2 = zzbgr.zza(activity, zzP, zzQ, true, z3, (zzfh) null, (zzafp) null, zzbbq, (zzaff) null, (zzl) null, zzbgf4 != null ? zzbgf4.zzk() : null, zzug.zza(), (zzdqo) null, (zzdqr) null);
                    this.zzd = zza2;
                    zzbht zzR2 = zza2.zzR();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                    zzajq zzajq = adOverlayInfoParcel2.zzp;
                    zzajs zzajs = adOverlayInfoParcel2.zze;
                    zzw zzw2 = adOverlayInfoParcel2.zzi;
                    zzbgf zzbgf5 = adOverlayInfoParcel2.zzd;
                    if (zzbgf5 != null) {
                        zzb2 = zzbgf5.zzR().zzb();
                    }
                    zzR2.zzK((zzyi) null, zzajq, (zzp) null, zzajs, zzw2, true, (zzaks) null, zzb2, (zzatl) null, (zzayr) null, (zzcvk) null, (zzdwg) null, (zzcni) null, (zzdvo) null, (zzakq) null);
                    this.zzd.zzR().zzw(new zzd(this));
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                    String str = adOverlayInfoParcel3.zzl;
                    if (str != null) {
                        this.zzd.loadUrl(str);
                    } else {
                        String str2 = adOverlayInfoParcel3.zzh;
                        if (str2 != null) {
                            this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str2, "text/html", "UTF-8", (String) null);
                        } else {
                            throw new zzh("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzbgf zzbgf6 = this.zzc.zzd;
                    if (zzbgf6 != null) {
                        zzbgf6.zzam(this);
                    }
                } catch (Exception e) {
                    zzbbk.zzg("Error obtaining webview.", e);
                    throw new zzh("Could not obtain webview for the overlay.");
                }
            } else {
                zzbgf zzbgf7 = this.zzc.zzd;
                this.zzd = zzbgf7;
                zzbgf7.zzai(this.zzb);
            }
            this.zzd.zzae(this);
            zzbgf zzbgf8 = this.zzc.zzd;
            if (zzbgf8 != null) {
                zzI(zzbgf8.zzV(), this.zzl);
            }
            if (this.zzc.zzk != 5) {
                ViewParent parent = this.zzd.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.zzd.zzH());
                }
                if (this.zzk) {
                    this.zzd.zzas();
                }
                this.zzl.addView(this.zzd.zzH(), -1, -1);
            }
            if (!z && !this.zzm) {
                zzD();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            if (adOverlayInfoParcel4.zzk != 5) {
                zzr(z3);
                if (this.zzd.zzT()) {
                    zzt(z3, true);
                    return;
                }
                return;
            }
            zzcvs.zzc(this.zzb, this, adOverlayInfoParcel4.zzu, adOverlayInfoParcel4.zzr, adOverlayInfoParcel4.zzs, adOverlayInfoParcel4.zzt, adOverlayInfoParcel4.zzq, adOverlayInfoParcel4.zzv);
            return;
        }
        throw new zzh("Invalid activity, no window available.");
    }

    /* access modifiers changed from: protected */
    public final void zzz() {
        if (this.zzb.isFinishing() && !this.zzu) {
            this.zzu = true;
            zzbgf zzbgf = this.zzd;
            if (zzbgf != null) {
                int i = this.zzn;
                if (i != 0) {
                    zzbgf.zzJ(i - 1);
                    if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzcX)).booleanValue()) {
                        synchronized (this.zzo) {
                            if (!this.zzs && this.zzd.zzaa()) {
                                zze zze2 = new zze(this);
                                this.zzq = zze2;
                                zzr.zza.postDelayed(zze2, ((Long) zzaaa.zzc().zzb(zzaeq.zzaI)).longValue());
                                return;
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
            zzA();
        }
    }
}
