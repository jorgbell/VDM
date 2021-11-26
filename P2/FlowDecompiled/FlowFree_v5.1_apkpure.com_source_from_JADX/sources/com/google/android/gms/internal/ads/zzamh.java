package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzamh implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbcb zza;

    zzamh(zzami zzami, zzbcb zzbcb) {
        this.zza = zzbcb;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zza.zzd(new RuntimeException("Connection failed."));
    }
}
