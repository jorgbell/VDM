package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwq {
    private final zzdwx zza;
    private final WebView zzb;
    private final List<zzdwy> zzc = new ArrayList();
    private final Map<String, zzdwy> zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzdwr zzg;

    private zzdwq(zzdwx zzdwx, WebView webView, String str, List<zzdwy> list, String str2, String str3, zzdwr zzdwr) {
        this.zza = zzdwx;
        this.zzb = webView;
        this.zzg = zzdwr;
        this.zzf = str2;
        this.zze = "";
    }

    @Deprecated
    public static zzdwq zza(zzdwx zzdwx, WebView webView, String str) {
        return new zzdwq(zzdwx, webView, (String) null, (List<zzdwy>) null, (String) null, "", zzdwr.HTML);
    }

    public static zzdwq zzb(zzdwx zzdwx, WebView webView, String str, String str2) {
        return new zzdwq(zzdwx, webView, (String) null, (List<zzdwy>) null, str, "", zzdwr.HTML);
    }

    public static zzdwq zzc(zzdwx zzdwx, WebView webView, String str, String str2) {
        return new zzdwq(zzdwx, webView, (String) null, (List<zzdwy>) null, str, "", zzdwr.JAVASCRIPT);
    }

    public final zzdwx zzd() {
        return this.zza;
    }

    public final List<zzdwy> zze() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map<String, zzdwy> zzf() {
        return Collections.unmodifiableMap(this.zzd);
    }

    public final WebView zzg() {
        return this.zzb;
    }

    public final String zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zze;
    }

    public final zzdwr zzj() {
        return this.zzg;
    }
}
