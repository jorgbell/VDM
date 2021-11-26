package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzua implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzts zza;
    final /* synthetic */ zzbcb zzb;
    final /* synthetic */ zzuc zzc;

    zzua(zzuc zzuc, zzts zzts, zzbcb zzbcb) {
        this.zzc = zzuc;
        this.zza = zzts;
        this.zzb = zzbcb;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            if (!this.zzc.zzb) {
                boolean unused = this.zzc.zzb = true;
                zztr zzf = this.zzc.zza;
                if (zzf != null) {
                    zzefw<?> zza2 = zzbbw.zza.zza(new zztx(this, zzf, this.zza, this.zzb));
                    zzbcb zzbcb = this.zzb;
                    zzbcb.zze(new zzty(zzbcb, zza2), zzbbw.zzf);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
