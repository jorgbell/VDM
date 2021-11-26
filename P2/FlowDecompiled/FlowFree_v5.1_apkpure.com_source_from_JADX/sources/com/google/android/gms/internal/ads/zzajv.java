package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzajv implements zzakp {
    static final zzakp zza = new zzajv();

    private zzajv() {
    }

    public final void zza(Object obj, Map map) {
        zzbhh zzbhh = (zzbhh) obj;
        zzakp<zzbgf> zzakp = zzako.zza;
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfs)).booleanValue()) {
            zzbbk.zzi("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzbbk.zzi("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(zzbhh.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
        hashMap.put(str, valueOf);
        String valueOf2 = String.valueOf(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(valueOf2).length());
        sb.append("/canOpenApp;");
        sb.append(str);
        sb.append(";");
        sb.append(valueOf2);
        zze.zza(sb.toString());
        ((zzang) zzbhh).zze("openableApp", hashMap);
    }
}
