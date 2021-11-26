package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdvw {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzdvw(Context context, zzbbq zzbbq) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzbbq.zza;
    }

    public final void zza(Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzs.zzc();
        map.put("device", zzr.zzx());
        map.put("app", this.zzb);
        zzs.zzc();
        map.put("is_lite_sdk", true != zzr.zzG(this.zza) ? "0" : "1");
        List<String> zzd = zzaeq.zzd();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeT)).booleanValue()) {
            zzd.addAll(zzs.zzg().zzl().zzn().zzh());
        }
        map.put("e", TextUtils.join(",", zzd));
        map.put("sdkVersion", this.zzc);
    }
}
