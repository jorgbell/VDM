package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzbx;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdlg implements Callable {
    static final Callable zza = new zzdlg();

    private zzdlg() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzaaa.zzc().zzb(zzaeq.zzF);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzaaa.zzc().zzb(zzaeq.zzG)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzbx.zza(str2));
                }
            }
        }
        return new zzdli(hashMap);
    }
}
