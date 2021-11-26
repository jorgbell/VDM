package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzse implements ValueCallback<String> {
    final /* synthetic */ zzsf zza;

    zzse(zzsf zzsf) {
        this.zza = zzsf;
    }

    /* renamed from: zza */
    public final void onReceiveValue(String str) {
        zzsf zzsf = this.zza;
        zzsf.zze.zzd(zzsf.zzb, zzsf.zzc, str, zzsf.zzd);
    }
}
