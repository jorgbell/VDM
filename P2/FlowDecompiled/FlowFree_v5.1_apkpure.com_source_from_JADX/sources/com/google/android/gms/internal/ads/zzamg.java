package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzamg implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbcb zza;
    final /* synthetic */ zzami zzb;

    zzamg(zzami zzami, zzbcb zzbcb) {
        this.zzb = zzami;
        this.zza = zzbcb;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzbcb zzbcb = this.zza;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbcb.zzd(new RuntimeException(sb.toString()));
    }
}
