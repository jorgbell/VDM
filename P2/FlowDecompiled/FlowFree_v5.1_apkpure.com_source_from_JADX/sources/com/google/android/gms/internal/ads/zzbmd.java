package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmd implements zzblr {
    private final zzcpz zza;

    zzbmd(zzcpz zzcpz) {
        this.zza = zzcpz;
    }

    public final void zza(Map<String, String> map) {
        String str = map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzb(str.equals("true"));
        }
    }
}
