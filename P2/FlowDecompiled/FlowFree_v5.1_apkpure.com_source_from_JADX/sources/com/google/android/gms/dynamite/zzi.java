package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
final class zzi implements DynamiteModule.VersionPolicy {
    zzi() {
    }

    public final zzn zza(Context context, String str, zzm zzm) throws DynamiteModule.LoadingException {
        zzn zzn = new zzn();
        zzn.zza = zzm.zzb(context, str);
        int zza = zzm.zza(context, str, true);
        zzn.zzb = zza;
        int i = zzn.zza;
        if (i == 0) {
            if (zza == 0) {
                zzn.zzc = 0;
                return zzn;
            }
            i = 0;
        }
        if (zza >= i) {
            zzn.zzc = 1;
        } else {
            zzn.zzc = -1;
        }
        return zzn;
    }
}
