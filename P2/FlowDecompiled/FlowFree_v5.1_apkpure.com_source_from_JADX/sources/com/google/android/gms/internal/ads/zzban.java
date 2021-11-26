package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzban implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbcb zzb;

    zzban(zzbao zzbao, Context context, zzbcb zzbcb) {
        this.zza = context;
        this.zzb = zzbcb;
    }

    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzb.zzd(e);
            zzbbk.zzg("Exception while getting advertising Id info", e);
        }
    }
}
