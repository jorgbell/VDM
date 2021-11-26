package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzajt implements zzakp<zzbgf> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzbbk.zzi("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzbbk.zzi("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzs.zzj().elapsedRealtime() + (Long.parseLong(str4) - zzs.zzj().currentTimeMillis());
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbgf.zzq().zzb(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzbbk.zzj("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzbbk.zzi("No value given for CSI experiment.");
            } else {
                zzbgf.zzq().zzc().zzd("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get(MediationMetaData.KEY_NAME);
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzbbk.zzi("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzbbk.zzi("No name given for CSI extra.");
            } else {
                zzbgf.zzq().zzc().zzd(str6, str7);
            }
        }
    }
}
