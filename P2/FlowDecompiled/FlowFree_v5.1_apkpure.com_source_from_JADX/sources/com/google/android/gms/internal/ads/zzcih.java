package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcih implements zzri {
    private final zzbgf zza;

    zzcih(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    public final void zzc(zzrh zzrh) {
        zzbgf zzbgf = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", true != zzrh.zzj ? "0" : "1");
        zzbgf.zze("onAdVisibilityChanged", hashMap);
    }
}
