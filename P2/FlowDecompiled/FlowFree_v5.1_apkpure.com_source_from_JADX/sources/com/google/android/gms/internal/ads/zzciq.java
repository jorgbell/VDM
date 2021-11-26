package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzciq extends zzamx implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzagt {
    private View zza;
    private zzacj zzb;
    private zzces zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzciq(zzces zzces, zzcex zzcex) {
        this.zza = zzcex.zzF();
        this.zzb = zzcex.zzu();
        this.zzc = zzces;
        if (zzcex.zzO() != null) {
            zzcex.zzO().zzaw(this);
        }
    }

    private final void zzg() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private final void zzh() {
        View view;
        zzces zzces = this.zzc;
        if (zzces != null && (view = this.zza) != null) {
            zzces.zzp(view, Collections.emptyMap(), Collections.emptyMap(), zzces.zzz(this.zza));
        }
    }

    private static final void zzi(zzanb zzanb, int i) {
        try {
            zzanb.zzf(i);
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onGlobalLayout() {
        zzh();
    }

    public final void onScrollChanged() {
        zzh();
    }

    public final void zza() {
        zzr.zza.post(new zzcio(this));
    }

    public final zzacj zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzbbk.zzf("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzg();
        zzces zzces = this.zzc;
        if (zzces != null) {
            zzces.zzR();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zzd(IObjectWrapper iObjectWrapper, zzanb zzanb) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzbbk.zzf("Instream ad can not be shown after destroy().");
            zzi(zzanb, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            String str = view == null ? "can not get video view." : "can not get video controller.";
            zzbbk.zzf(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zzi(zzanb, 0);
        } else if (this.zze) {
            zzbbk.zzf("Instream ad should not be used again.");
            zzi(zzanb, 1);
        } else {
            this.zze = true;
            zzg();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzs.zzz();
            zzbcj.zza(this.zza, this);
            zzs.zzz();
            zzbcj.zzb(this.zza, this);
            zzh();
            try {
                zzanb.zze();
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzd(iObjectWrapper, new zzcip(this));
    }

    public final zzahh zzf() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzbbk.zzf("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzces zzces = this.zzc;
        if (zzces == null || zzces.zzF() == null) {
            return null;
        }
        return this.zzc.zzF().zza();
    }
}
