package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcvv implements zzauf {
    private final zzauf zza;
    private final zzauf zzb;

    public zzcvv(zzauf zzauf, zzauf zzauf2) {
        this.zza = zzauf;
        this.zzb = zzauf2;
    }

    private final zzauf zzb() {
        return ((Boolean) zzaaa.zzc().zzb(zzaeq.zzdp)).booleanValue() ? this.zza : this.zzb;
    }

    public final boolean zza(Context context) {
        return zzb().zza(context);
    }

    public final String zzc(Context context) {
        return zzb().zzc(context);
    }

    public final IObjectWrapper zzd(String str, WebView webView, String str2, String str3, String str4) {
        return zzb().zzd(str, webView, "", "javascript", str4);
    }

    public final IObjectWrapper zze(String str, WebView webView, String str2, String str3, String str4, String str5) {
        return zzb().zze(str, webView, "", "javascript", str4, str5);
    }

    public final IObjectWrapper zzf(String str, WebView webView, String str2, String str3, String str4, zzauh zzauh, zzaug zzaug, String str5) {
        return zzb().zzf(str, webView, "", "javascript", str4, zzauh, zzaug, str5);
    }

    public final IObjectWrapper zzg(String str, WebView webView, String str2, String str3, String str4, String str5, zzauh zzauh, zzaug zzaug, String str6) {
        return zzb().zzg(str, webView, "", "javascript", str4, str5, zzauh, zzaug, str6);
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        zzb().zzh(iObjectWrapper);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        zzb().zzi(iObjectWrapper);
    }

    public final void zzj(IObjectWrapper iObjectWrapper, View view) {
        zzb().zzj(iObjectWrapper, view);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, View view) {
        zzb().zzk(iObjectWrapper, view);
    }
}
