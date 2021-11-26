package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import com.mopub.common.AdType;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdvn {
    private final HashMap<String, String> zza = new HashMap<>();
    private final zzdvt zzb = new zzdvt(zzs.zzj());

    private zzdvn() {
    }

    public static zzdvn zza(String str) {
        zzdvn zzdvn = new zzdvn();
        zzdvn.zza.put("action", str);
        return zzdvn;
    }

    public static zzdvn zzb(String str) {
        zzdvn zzdvn = new zzdvn();
        zzdvn.zza.put("request_id", str);
        return zzdvn;
    }

    public final zzdvn zzc(String str, String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzdvn zzd(String str) {
        this.zzb.zza(str);
        return this;
    }

    public final zzdvn zze(String str, String str2) {
        this.zzb.zzb(str, str2);
        return this;
    }

    public final zzdvn zzf(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final zzdvn zzg(zzdra zzdra, zzbaz zzbaz) {
        zzdqz zzdqz = zzdra.zzb;
        zzh(zzdqz.zzb);
        if (!zzdqz.zza.isEmpty()) {
            switch (zzdqz.zza.get(0).zzb) {
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
                    if (zzbaz != null) {
                        this.zza.put("as", true != zzbaz.zzi() ? "0" : "1");
                        break;
                    }
                    break;
                default:
                    this.zza.put("ad_format", "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzdvn zzh(zzdqr zzdqr) {
        if (!TextUtils.isEmpty(zzdqr.zzb)) {
            this.zza.put("gqi", zzdqr.zzb);
        }
        return this;
    }

    public final zzdvn zzi(zzdqo zzdqo) {
        this.zza.put("aai", zzdqo.zzv);
        return this;
    }

    public final Map<String, String> zzj() {
        HashMap hashMap = new HashMap(this.zza);
        for (zzdvs next : this.zzb.zzc()) {
            hashMap.put(next.zza, next.zzb);
        }
        return hashMap;
    }
}
