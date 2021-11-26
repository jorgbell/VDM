package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzbbo {
    public static <T> T zza(Context context, String str, zzbbm<IBinder, T> zzbbm) throws zzbbn {
        try {
            return zzbbm.zza(zzc(context).instantiate(str));
        } catch (Exception e) {
            throw new zzbbn(e);
        }
    }

    public static Context zzb(Context context) throws zzbbn {
        return zzc(context).getModuleContext();
    }

    private static DynamiteModule zzc(Context context) throws zzbbn {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzbbn(e);
        }
    }
}
