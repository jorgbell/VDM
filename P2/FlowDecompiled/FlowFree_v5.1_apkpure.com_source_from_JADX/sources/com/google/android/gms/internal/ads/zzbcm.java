package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzbcm {
    private final WeakReference<View> zza;

    public zzbcm(View view) {
        this.zza = new WeakReference<>(view);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    public abstract void zzb(ViewTreeObserver viewTreeObserver);

    public final void zzc() {
        ViewTreeObserver zze = zze();
        if (zze != null) {
            zza(zze);
        }
    }

    public final void zzd() {
        ViewTreeObserver zze = zze();
        if (zze != null) {
            zzb(zze);
        }
    }

    /* access modifiers changed from: protected */
    public final ViewTreeObserver zze() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zza.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
