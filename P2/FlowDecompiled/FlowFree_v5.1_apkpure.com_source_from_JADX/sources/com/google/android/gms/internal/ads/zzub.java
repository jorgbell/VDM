package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzub implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbcb zza;
    final /* synthetic */ zzuc zzb;

    zzub(zzuc zzuc, zzbcb zzbcb) {
        this.zzb = zzuc;
        this.zza = zzbcb;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
