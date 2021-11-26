package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzum {
    zzib zza;
    boolean zzb;

    public zzum() {
    }

    public zzum(Context context) {
        zzaeq.zza(context);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdc)).booleanValue()) {
            try {
                this.zza = (zzib) zzbbo.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzuj.zza);
                ObjectWrapper.wrap(context);
                this.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzb = true;
            } catch (RemoteException | zzbbn | NullPointerException unused) {
                zzbbk.zzd("Cannot dynamite load clearcut");
            }
        }
    }
}
