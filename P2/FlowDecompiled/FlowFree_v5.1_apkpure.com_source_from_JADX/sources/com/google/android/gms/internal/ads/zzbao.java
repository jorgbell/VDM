package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbao {
    public final zzefw<AdvertisingIdClient.Info> zza(Context context, int i) {
        zzbcb zzbcb = new zzbcb();
        zzzy.zza();
        if (zzbbd.zzo(context)) {
            zzbbw.zza.execute(new zzban(this, context, zzbcb));
        }
        return zzbcb;
    }
}
