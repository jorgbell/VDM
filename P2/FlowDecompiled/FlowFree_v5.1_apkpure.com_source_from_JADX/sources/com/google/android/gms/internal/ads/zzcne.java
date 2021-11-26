package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.AdType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcne {
    private final ConcurrentHashMap<String, String> zza;
    private final zzbaz zzb;

    public zzcne(zzcnn zzcnn, zzbaz zzbaz) {
        this.zza = new ConcurrentHashMap<>(zzcnn.zzb);
        this.zzb = zzbaz;
    }

    public final void zza(zzdra zzdra) {
        if (zzdra.zzb.zza.size() > 0) {
            switch (zzdra.zzb.zza.get(0).zzb) {
                case 1:
                    this.zza.put("ad_format", "banner");
                    break;
                case 2:
                    this.zza.put("ad_format", AdType.INTERSTITIAL);
                    break;
                case 3:
                    this.zza.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zza.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zza.put("ad_format", "rewarded");
                    break;
                case 6:
                    this.zza.put("ad_format", "app_open_ad");
                    this.zza.put("as", true != this.zzb.zzi() ? "0" : "1");
                    break;
                default:
                    this.zza.put("ad_format", "unknown");
                    break;
            }
        }
        if (!TextUtils.isEmpty(zzdra.zzb.zzb.zzb)) {
            this.zza.put("gqi", zzdra.zzb.zzb.zzb);
        }
    }

    public final void zzb(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzc() {
        return this.zza;
    }
}
