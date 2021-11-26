package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdrw {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        zzbbk.zzh(sb.toString());
        zze.zzb(str, th);
        if (i != 3) {
            zzs.zzg().zzh(th, str);
        }
    }

    public static void zzb(Context context, boolean z) {
        if (z) {
            zzbbk.zzh("This request is sent from a test device.");
            return;
        }
        zzzy.zza();
        String zzt = zzbbd.zzt(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzt).length() + 102);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(zzt);
        sb.append("\")) to get test ads on this device.");
        zzbbk.zzh(sb.toString());
    }
}
