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
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfq extends zzahr implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcgr {
    private final WeakReference<View> zza;
    private final Map<String, WeakReference<View>> zzb = new HashMap();
    private final Map<String, WeakReference<View>> zzc = new HashMap();
    private final Map<String, WeakReference<View>> zzd = new HashMap();
    @GuardedBy("this")
    private zzces zze;
    private zzrj zzf;

    public zzcfq(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzs.zzz();
        zzbcj.zza(view, this);
        zzs.zzz();
        zzbcj.zzb(view, this);
        this.zza = new WeakReference<>(view);
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View view2 = (View) next.getValue();
            if (view2 != null) {
                this.zzb.put(str, new WeakReference(view2));
                if (!"1098".equals(str) && !"3011".equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzd.putAll(this.zzb);
        for (Map.Entry next2 : hashMap2.entrySet()) {
            View view3 = (View) next2.getValue();
            if (view3 != null) {
                this.zzc.put((String) next2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzd.putAll(this.zzc);
        this.zzf = new zzrj(view.getContext(), view);
    }

    public final synchronized void onClick(View view) {
        zzces zzces = this.zze;
        if (zzces != null) {
            zzces.zzj(view, zzby(), zzj(), zzk(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzces zzces = this.zze;
        if (zzces != null) {
            zzces.zzp(zzby(), zzj(), zzk(), zzces.zzz(zzby()));
        }
    }

    public final synchronized void onScrollChanged() {
        zzces zzces = this.zze;
        if (zzces != null) {
            zzces.zzp(zzby(), zzj(), zzk(), zzces.zzz(zzby()));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzces zzces = this.zze;
        if (zzces != null) {
            zzces.zzk(view, motionEvent, zzby());
        }
        return false;
    }

    public final synchronized void zzb(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzces)) {
            zzbbk.zzi("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzces zzces = this.zze;
        if (zzces != null) {
            zzces.zzh(this);
        }
        zzces zzces2 = (zzces) unwrap;
        if (zzces2.zzA()) {
            this.zze = zzces2;
            zzces2.zzg(this);
            this.zze.zzD(zzby());
            return;
        }
        zzbbk.zzf("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    public final FrameLayout zzbu() {
        return null;
    }

    public final View zzby() {
        return (View) this.zza.get();
    }

    public final synchronized void zzc() {
        zzces zzces = this.zze;
        if (zzces != null) {
            zzces.zzh(this);
            this.zze = null;
        }
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper) {
        if (this.zze != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzbbk.zzi("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zze.zzr((View) unwrap);
        }
    }

    public final zzrj zzh() {
        return this.zzf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzd     // Catch:{ all -> 0x0034 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0034 }
            r0.<init>(r3)     // Catch:{ all -> 0x0034 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0034 }
            if (r4 != 0) goto L_0x0032
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x001c
            goto L_0x0032
        L_0x001c:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzb     // Catch:{ all -> 0x0034 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0034 }
            r0.<init>(r3)     // Catch:{ all -> 0x0034 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0034 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0034 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0034 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r1)
            return
        L_0x0032:
            monitor-exit(r1)
            return
        L_0x0034:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfq.zzi(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized Map<String, WeakReference<View>> zzj() {
        return this.zzd;
    }

    public final synchronized Map<String, WeakReference<View>> zzk() {
        return this.zzb;
    }

    public final synchronized Map<String, WeakReference<View>> zzl() {
        return this.zzc;
    }

    public final synchronized View zzm(String str) {
        WeakReference weakReference = this.zzd.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized String zzn() {
        return "1007";
    }

    public final synchronized IObjectWrapper zzo() {
        return null;
    }

    public final synchronized JSONObject zzp() {
        return null;
    }
}
