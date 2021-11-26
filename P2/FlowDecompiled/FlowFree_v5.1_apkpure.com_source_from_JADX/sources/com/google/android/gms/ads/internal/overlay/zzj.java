package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzbgf;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzj {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzj(zzbgf zzbgf) throws zzh {
        this.zzb = zzbgf.getLayoutParams();
        ViewParent parent = zzbgf.getParent();
        this.zzd = zzbgf.zzM();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzh("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzbgf.zzH());
        viewGroup.removeView(zzbgf.zzH());
        zzbgf.zzag(true);
    }
}
