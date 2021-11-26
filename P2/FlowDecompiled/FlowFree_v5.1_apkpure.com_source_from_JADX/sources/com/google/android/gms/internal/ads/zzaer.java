package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaer {
    static List<String> zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzafs.zzd("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzagb.zza);
        zzc(arrayList, zzagb.zzb);
        zzc(arrayList, zzagb.zzc);
        zzc(arrayList, zzagb.zzd);
        zzc(arrayList, zzagb.zze);
        zzc(arrayList, zzagb.zzk);
        zzc(arrayList, zzagb.zzf);
        zzc(arrayList, zzagb.zzg);
        zzc(arrayList, zzagb.zzh);
        zzc(arrayList, zzagb.zzi);
        zzc(arrayList, zzagb.zzj);
        return arrayList;
    }

    static List<String> zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzagl.zza);
        return arrayList;
    }

    private static void zzc(List<String> list, zzafs<String> zzafs) {
        String zze = zzafs.zze();
        if (!TextUtils.isEmpty(zze)) {
            list.add(zze);
        }
    }
}
