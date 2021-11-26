package com.google.android.gms.games.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.games.zzfg;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzae implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    private boolean zzdm = false;
    private zzf zzes;
    private zzfg zzet;
    private WeakReference<View> zzeu;

    public static zzae zza(zzf zzf, int i) {
        return new zzae(zzf, i);
    }

    private zzae(zzf zzf, int i) {
        this.zzes = zzf;
        this.zzet = new zzfg(i, (IBinder) null);
    }

    public final Bundle zzbl() {
        return this.zzet.zzce();
    }

    public final IBinder zzbm() {
        return this.zzet.zzjn;
    }

    public final zzfg zzbn() {
        return this.zzet;
    }

    @TargetApi(16)
    public final void zzb(View view) {
        this.zzes.zzbd();
        WeakReference<View> weakReference = this.zzeu;
        if (weakReference != null) {
            View view2 = (View) weakReference.get();
            Context context = this.zzes.getContext();
            if (view2 == null && (context instanceof Activity)) {
                view2 = ((Activity) context).getWindow().getDecorView();
            }
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.zzeu = null;
        Context context2 = this.zzes.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            try {
                view = activity.findViewById(16908290);
            } catch (IllegalStateException unused) {
            }
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzz.m4853w("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view != null) {
            zzc(view);
            this.zzeu = new WeakReference<>(view);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            return;
        }
        zzz.m4851e("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }

    public final void zzbo() {
        zzfg zzfg = this.zzet;
        IBinder iBinder = zzfg.zzjn;
        if (iBinder != null) {
            this.zzes.zza(iBinder, zzfg.zzce());
            this.zzdm = false;
            return;
        }
        this.zzdm = true;
    }

    public final void onViewAttachedToWindow(View view) {
        zzc(view);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzes.zzbd();
        view.removeOnAttachStateChangeListener(this);
    }

    public final void onGlobalLayout() {
        View view;
        WeakReference<View> weakReference = this.zzeu;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            zzc(view);
        }
    }

    @TargetApi(17)
    private final void zzc(View view) {
        Display display;
        int i = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            i = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        zzfg zzfg = this.zzet;
        zzfg.zzjo = i;
        zzfg.zzjn = windowToken;
        zzfg.left = iArr[0];
        zzfg.top = iArr[1];
        zzfg.right = iArr[0] + width;
        zzfg.bottom = iArr[1] + height;
        if (this.zzdm) {
            zzbo();
        }
    }
}
