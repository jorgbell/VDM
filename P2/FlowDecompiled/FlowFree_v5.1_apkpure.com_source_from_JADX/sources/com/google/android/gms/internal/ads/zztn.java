package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zztn implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzto zza;

    zztn(zzto zzto) {
        this.zza = zzto;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzb) {
            zztu unused = this.zza.zze = null;
            if (this.zza.zzc != null) {
                zztr unused2 = this.zza.zzc = null;
            }
            this.zza.zzb.notifyAll();
        }
    }
}
