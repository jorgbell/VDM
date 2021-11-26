package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfs extends zzahn implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcgr {
    public static final zzede<String> zza = zzede.zzk("2011", "1009", "3010");
    private final String zzb;
    @GuardedBy("this")
    private Map<String, WeakReference<View>> zzc = new HashMap();
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzefx zzf;
    private View zzg;
    private final int zzh;
    @GuardedBy("this")
    private zzces zzi;
    private zzrj zzj;
    private IObjectWrapper zzk = null;
    private zzahh zzl;
    private boolean zzm;
    private boolean zzn = false;

    public zzcfs(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        this.zzh = 210890000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        String str = "3012";
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            boolean equals = "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
        }
        this.zzb = str;
        zzs.zzz();
        zzbcj.zza(frameLayout, this);
        zzs.zzz();
        zzbcj.zzb(frameLayout, this);
        this.zzf = zzbbw.zze;
        this.zzj = new zzrj(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzr() {
        this.zzf.execute(new zzcfr(this));
    }

    public final synchronized void onClick(View view) {
        zzces zzces = this.zzi;
        if (zzces != null) {
            zzces.zzt();
            this.zzi.zzj(view, this.zzd, zzj(), zzk(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzces zzces = this.zzi;
        if (zzces != null) {
            zzces.zzp(this.zzd, zzj(), zzk(), zzces.zzz(this.zzd));
        }
    }

    public final synchronized void onScrollChanged() {
        zzces zzces = this.zzi;
        if (zzces != null) {
            zzces.zzp(this.zzd, zzj(), zzk(), zzces.zzz(this.zzd));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzces zzces = this.zzi;
        if (zzces != null) {
            zzces.zzk(view, motionEvent, this.zzd);
        }
        return false;
    }

    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zzi(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final FrameLayout zzbu() {
        return this.zze;
    }

    public final synchronized void zzbv(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            this.zzk = iObjectWrapper;
        }
    }

    public final void zzbw(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzbx(zzahh zzahh) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzahh;
            zzces zzces = this.zzi;
            if (zzces != null) {
                zzces.zzF().zzb(zzahh);
            }
        }
    }

    public final /* bridge */ /* synthetic */ View zzby() {
        return this.zzd;
    }

    public final synchronized IObjectWrapper zzc(String str) {
        return ObjectWrapper.wrap(zzm(str));
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof zzces)) {
                zzbbk.zzi("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzces zzces = this.zzi;
            if (zzces != null) {
                zzces.zzh(this);
            }
            zzr();
            zzces zzces2 = (zzces) unwrap;
            this.zzi = zzces2;
            zzces2.zzg(this);
            this.zzi.zzD(this.zzd);
            this.zzi.zzE(this.zze);
            if (this.zzm) {
                this.zzi.zzF().zzb(this.zzl);
            }
        }
    }

    public final synchronized void zze() {
        if (!this.zzn) {
            zzces zzces = this.zzi;
            if (zzces != null) {
                zzces.zzh(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper) {
        this.zzi.zzr((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final zzrj zzh() {
        return this.zzj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzn     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzc     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzc     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzh     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbn.zza(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.zzi(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized Map<String, WeakReference<View>> zzj() {
        return this.zzc;
    }

    public final synchronized Map<String, WeakReference<View>> zzk() {
        return this.zzc;
    }

    public final synchronized Map<String, WeakReference<View>> zzl() {
        return null;
    }

    public final synchronized View zzm(String str) {
        if (this.zzn) {
            return null;
        }
        WeakReference weakReference = this.zzc.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized String zzn() {
        return this.zzb;
    }

    public final IObjectWrapper zzo() {
        return this.zzk;
    }

    public final synchronized JSONObject zzp() {
        zzces zzces = this.zzi;
        if (zzces == null) {
            return null;
        }
        return zzces.zzq(this.zzd, zzj(), zzk());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq() {
        if (this.zzg == null) {
            View view = new View(this.zzd.getContext());
            this.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
