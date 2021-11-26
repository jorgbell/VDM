package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzbp;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.HashSet;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzrj implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) zzaaa.zzc().zzb(zzaeq.zzaQ)).longValue();
    BroadcastReceiver zza;
    final WeakReference<View> zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference<ViewTreeObserver> zzi;
    private zzrv zzj;
    private final zzbp zzk = new zzbp(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet<zzri> zzn = new HashSet<>();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzrj(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.zzf = windowManager;
        this.zzg = (PowerManager) applicationContext.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.zze = application;
            this.zzj = new zzrv(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzb;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference<>(view);
        if (view != null) {
            if (zzs.zze().zzg(view)) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final void zzh() {
        zzr.zza.post(new zzrf(this));
    }

    private final void zzi(Activity activity, int i) {
        Window window;
        if (this.zzb != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzb.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzm = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0100 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(int r28) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            java.util.HashSet<com.google.android.gms.internal.ads.zzri> r0 = r1.zzn
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.View> r0 = r1.zzb
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r0 = 2
            int[] r8 = new int[r0]
            int[] r0 = new int[r0]
            r9 = 1
            r10 = 0
            if (r3 == 0) goto L_0x006c
            boolean r11 = r3.getGlobalVisibleRect(r5)
            boolean r12 = r3.getLocalVisibleRect(r6)
            r3.getHitRect(r7)
            r3.getLocationOnScreen(r8)     // Catch:{ Exception -> 0x0048 }
            r3.getLocationInWindow(r0)     // Catch:{ Exception -> 0x0048 }
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            java.lang.String r13 = "Failure getting view location."
            com.google.android.gms.internal.ads.zzbbk.zzg(r13, r0)
        L_0x004e:
            r0 = r8[r10]
            r4.left = r0
            r8 = r8[r9]
            r4.top = r8
            int r8 = r3.getWidth()
            int r0 = r0 + r8
            r4.right = r0
            int r0 = r4.top
            int r8 = r3.getHeight()
            int r0 = r0 + r8
            r4.bottom = r0
            r8 = r3
            r20 = r11
            r22 = r12
            goto L_0x0072
        L_0x006c:
            r0 = 0
            r8 = r0
            r20 = 0
            r22 = 0
        L_0x0072:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzaT
            com.google.android.gms.internal.ads.zzaeo r11 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r11.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00c2
            if (r8 == 0) goto L_0x00c2
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b3 }
            r0.<init>()     // Catch:{ Exception -> 0x00b3 }
            android.view.ViewParent r11 = r8.getParent()     // Catch:{ Exception -> 0x00b3 }
        L_0x008f:
            boolean r12 = r11 instanceof android.view.View     // Catch:{ Exception -> 0x00b3 }
            if (r12 == 0) goto L_0x00c6
            r12 = r11
            android.view.View r12 = (android.view.View) r12     // Catch:{ Exception -> 0x00b3 }
            android.graphics.Rect r13 = new android.graphics.Rect     // Catch:{ Exception -> 0x00b3 }
            r13.<init>()     // Catch:{ Exception -> 0x00b3 }
            boolean r14 = r12.isScrollContainer()     // Catch:{ Exception -> 0x00b3 }
            if (r14 == 0) goto L_0x00ae
            boolean r12 = r12.getGlobalVisibleRect(r13)     // Catch:{ Exception -> 0x00b3 }
            if (r12 == 0) goto L_0x00ae
            android.graphics.Rect r12 = r1.zzc(r13)     // Catch:{ Exception -> 0x00b3 }
            r0.add(r12)     // Catch:{ Exception -> 0x00b3 }
        L_0x00ae:
            android.view.ViewParent r11 = r11.getParent()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x008f
        L_0x00b3:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbav r11 = com.google.android.gms.ads.internal.zzs.zzg()
            java.lang.String r12 = "PositionWatcher.getParentScrollViewRects"
            r11.zzg(r0, r12)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00c6
        L_0x00c2:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x00c6:
            r26 = r0
            r0 = 8
            if (r8 == 0) goto L_0x00d1
            int r11 = r8.getWindowVisibility()
            goto L_0x00d3
        L_0x00d1:
            r11 = 8
        L_0x00d3:
            int r12 = r1.zzm
            r13 = -1
            if (r12 == r13) goto L_0x00d9
            r11 = r12
        L_0x00d9:
            if (r3 == 0) goto L_0x00f0
            com.google.android.gms.ads.internal.zzs.zzc()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r12 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzr.zzU(r8, r3, r12)
            if (r3 == 0) goto L_0x00f0
            if (r20 == 0) goto L_0x00f0
            if (r22 == 0) goto L_0x00f0
            if (r11 != 0) goto L_0x00f0
            r3 = 1
            goto L_0x00f1
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            if (r2 != r9) goto L_0x0101
            com.google.android.gms.ads.internal.util.zzbp r11 = r1.zzk
            boolean r11 = r11.zza()
            if (r11 != 0) goto L_0x0101
            boolean r11 = r1.zzl
            if (r3 == r11) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            return
        L_0x0101:
            if (r3 != 0) goto L_0x010b
            boolean r11 = r1.zzl
            if (r11 != 0) goto L_0x010b
            if (r2 == r9) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            return
        L_0x010b:
            com.google.android.gms.internal.ads.zzrh r2 = new com.google.android.gms.internal.ads.zzrh
            com.google.android.gms.common.util.Clock r11 = com.google.android.gms.ads.internal.zzs.zzj()
            long r12 = r11.elapsedRealtime()
            android.os.PowerManager r11 = r1.zzg
            boolean r14 = r11.isScreenOn()
            if (r8 == 0) goto L_0x0129
            com.google.android.gms.ads.internal.util.zzac r11 = com.google.android.gms.ads.internal.zzs.zze()
            boolean r11 = r11.zzg(r8)
            if (r11 == 0) goto L_0x0129
            r15 = 1
            goto L_0x012a
        L_0x0129:
            r15 = 0
        L_0x012a:
            if (r8 == 0) goto L_0x0133
            int r0 = r8.getWindowVisibility()
            r16 = r0
            goto L_0x0135
        L_0x0133:
            r16 = 8
        L_0x0135:
            android.graphics.Rect r0 = r1.zzp
            android.graphics.Rect r17 = r1.zzc(r0)
            android.graphics.Rect r18 = r1.zzc(r4)
            android.graphics.Rect r19 = r1.zzc(r5)
            android.graphics.Rect r21 = r1.zzc(r6)
            android.graphics.Rect r23 = r1.zzc(r7)
            android.util.DisplayMetrics r0 = r1.zzo
            float r0 = r0.density
            r11 = r2
            r24 = r0
            r25 = r3
            r11.<init>(r12, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            java.util.HashSet<com.google.android.gms.internal.ads.zzri> r0 = r1.zzn
            java.util.Iterator r0 = r0.iterator()
        L_0x015d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x016d
            java.lang.Object r4 = r0.next()
            com.google.android.gms.internal.ads.zzri r4 = (com.google.android.gms.internal.ads.zzri) r4
            r4.zzc(r2)
            goto L_0x015d
        L_0x016d:
            r1.zzl = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrj.zzj(int):void");
    }

    private final int zzk(int i) {
        return (int) (((float) i) / this.zzo.density);
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzrg(this);
            zzs.zzx().zzb(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e) {
                zzbbk.zzg("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference<ViewTreeObserver> weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e) {
            zzbbk.zzg("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzbbk.zzg("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zza != null) {
            try {
                zzs.zzx().zzc(this.zzd, this.zza);
            } catch (IllegalStateException e3) {
                zzbbk.zzg("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzs.zzg().zzg(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e5) {
                zzbbk.zzg("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzh();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzh();
    }

    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzh();
    }

    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzh();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzh();
    }

    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzh();
    }

    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzh();
    }

    public final void onGlobalLayout() {
        zzj(2);
        zzh();
    }

    public final void onScrollChanged() {
        zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzh();
        zzm(view);
    }

    public final void zza(zzri zzri) {
        this.zzn.add(zzri);
        zzj(3);
    }

    public final void zzb(zzri zzri) {
        this.zzn.remove(zzri);
    }

    /* access modifiers changed from: package-private */
    public final Rect zzc(Rect rect) {
        return new Rect(zzk(rect.left), zzk(rect.top), zzk(rect.right), zzk(rect.bottom));
    }

    public final void zzd(long j) {
        this.zzk.zzb(j);
    }

    public final void zze() {
        this.zzk.zzb(zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        zzj(3);
    }
}
