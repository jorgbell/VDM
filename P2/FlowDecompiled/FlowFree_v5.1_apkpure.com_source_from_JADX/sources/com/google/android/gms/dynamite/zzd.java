package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
final class zzd implements DynamiteModule.VersionPolicy {
    zzd() {
    }

    public final zzn zza(Context context, String str, zzm zzm) throws DynamiteModule.LoadingException {
        zzn zzn = new zzn();
        int zza = zzm.zza(context, str, true);
        zzn.zzb = zza;
        if (zza != 0) {
            zzn.zzc = 1;
        } else {
            int zzb = zzm.zzb(context, str);
            zzn.zza = zzb;
            if (zzb != 0) {
                zzn.zzc = -1;
            }
        }
        return zzn;
    }
}
