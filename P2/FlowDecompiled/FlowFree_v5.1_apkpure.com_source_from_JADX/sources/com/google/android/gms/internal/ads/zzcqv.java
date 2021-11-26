package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcqv implements zzeyl<zzefw<String>> {
    private final zzeyw<zzdve> zza;
    private final zzeyw<Context> zzb;

    public zzcqv(zzeyw<zzdve> zzeyw, zzeyw<Context> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        CookieManager zzk = zzs.zze().zzk(this.zzb.zzb());
        zzduy zzduy = zzduy.WEBVIEW_COOKIE;
        return zzdup.zzb(new zzcqr(zzk), zzduy, this.zza.zzb()).zzh(1, TimeUnit.SECONDS).zzf(Exception.class, zzcqs.zza).zzi();
    }
}
