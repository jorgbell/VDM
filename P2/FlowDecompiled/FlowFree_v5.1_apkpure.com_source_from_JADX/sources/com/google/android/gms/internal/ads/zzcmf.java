package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcmf implements zzbww, zzbvr, zzbui, zzbux, zzyi, zzbyz {
    private final zzug zza;
    @GuardedBy("this")
    private boolean zzb = false;

    public zzcmf(zzug zzug, @Nullable zzdol zzdol) {
        this.zza = zzug;
        zzug.zzb(zzui.AD_REQUEST);
        if (zzdol != null) {
            zzug.zzb(zzui.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzb(zzui.AD_FIRST_CLICK);
            this.zzb = true;
            return;
        }
        this.zza.zzb(zzui.AD_SUBSEQUENT_CLICK);
    }

    public final void zzbC(zzym zzym) {
        switch (zzym.zza) {
            case 1:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zza.zzb(zzui.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final void zzbD() {
        this.zza.zzb(zzui.AD_LOADED);
    }

    public final synchronized void zzbp() {
        this.zza.zzb(zzui.AD_IMPRESSION);
    }

    public final void zzj(zzawc zzawc) {
    }

    public final void zzk(zzvd zzvd) {
        this.zza.zzc(new zzcmc(zzvd));
        this.zza.zzb(zzui.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzl(zzvd zzvd) {
        this.zza.zzc(new zzcmd(zzvd));
        this.zza.zzb(zzui.REQUEST_SAVED_TO_CACHE);
    }

    public final void zzm(zzvd zzvd) {
        this.zza.zzc(new zzcme(zzvd));
        this.zza.zzb(zzui.REQUEST_PREFETCH_INTERCEPTED);
    }

    public final void zzn(boolean z) {
        zzui zzui;
        zzug zzug = this.zza;
        if (z) {
            zzui = zzui.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zzui = zzui.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zzug.zzb(zzui);
    }

    public final void zzo(boolean z) {
        zzui zzui;
        zzug zzug = this.zza;
        if (z) {
            zzui = zzui.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zzui = zzui.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zzug.zzb(zzui);
    }

    public final void zzp() {
        this.zza.zzb(zzui.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzq(zzdra zzdra) {
        this.zza.zzc(new zzcmb(zzdra));
    }
}
