package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbdg {
    private final Context zza;
    private final zzbdp zzb;
    private final ViewGroup zzc;
    private zzbdf zzd;

    public zzbdg(Context context, ViewGroup viewGroup, zzbgf zzbgf) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzbgf;
        this.zzd = null;
    }

    public final void zza(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbdf zzbdf = this.zzd;
        if (zzbdf != null) {
            zzbdf.zzl(i, i2, i3, i4);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4, int i5, boolean z, zzbdo zzbdo) {
        if (this.zzd == null) {
            zzaex.zza(this.zzb.zzq().zzc(), this.zzb.zzi(), "vpr2");
            Context context = this.zza;
            zzbdp zzbdp = this.zzb;
            zzbdf zzbdf = new zzbdf(context, zzbdp, i5, z, zzbdp.zzq().zzc(), zzbdo);
            this.zzd = zzbdf;
            this.zzc.addView(zzbdf, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzd.zzl(i, i2, i3, i4);
            this.zzb.zzg(false);
        }
    }

    public final zzbdf zzc() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzd;
    }

    public final void zzd() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbdf zzbdf = this.zzd;
        if (zzbdf != null) {
            zzbdf.zzp();
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbdf zzbdf = this.zzd;
        if (zzbdf != null) {
            zzbdf.zzC();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf(int i) {
        Preconditions.checkMainThread("setPlayerBackgroundColor must be called from the UI thread.");
        zzbdf zzbdf = this.zzd;
        if (zzbdf != null) {
            zzbdf.zzk(i);
        }
    }
}
