package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaet {
    private final String zza = zzafy.zzb.zze();
    private final Map<String, String> zzb;
    private final Context zzc;
    private final String zzd;

    public zzaet(Context context, String str) {
        String str2;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        zzs.zzc();
        linkedHashMap.put("device", zzr.zzx());
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        linkedHashMap.put("app", str2);
        zzs.zzc();
        linkedHashMap.put("is_lite_sdk", true != zzr.zzG(context) ? "0" : "1");
        Future<zzawh> zza2 = zzs.zzn().zza(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(zza2.get().zzk));
            linkedHashMap.put("network_fine", Integer.toString(zza2.get().zzl));
        } catch (Exception e) {
            zzs.zzg().zzg(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Context zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzd() {
        return this.zzb;
    }
}
