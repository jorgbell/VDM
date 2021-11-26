package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbly implements zzblr {
    private final Context zza;
    private final zzg zzb = zzs.zzg().zzl();

    public zzbly(Context context) {
        this.zza = context;
    }

    public final void zza(Map<String, String> map) {
        if (!map.isEmpty()) {
            String str = map.get("gad_idless");
            if (str != null) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                map.remove("gad_idless");
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzao)).booleanValue()) {
                    this.zzb.zzA(parseBoolean);
                    if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue() && parseBoolean) {
                        this.zza.deleteDatabase("OfflineUpload.db");
                    }
                }
            }
            Bundle bundle = new Bundle();
            for (Map.Entry next : map.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaj)).booleanValue()) {
                zzs.zzA().zze(bundle);
            }
        }
    }
}
