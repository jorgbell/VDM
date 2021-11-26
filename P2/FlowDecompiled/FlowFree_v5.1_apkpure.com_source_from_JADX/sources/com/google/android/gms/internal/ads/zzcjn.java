package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcjn<T> implements zzakp<Object> {
    final /* synthetic */ zzcjo zza;
    private final WeakReference<T> zzb;
    private final String zzc;
    private final zzakp<T> zzd;

    /* synthetic */ zzcjn(zzcjo zzcjo, WeakReference weakReference, String str, zzakp zzakp, zzcje zzcje) {
        this.zza = zzcjo;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzakp;
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zze(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
