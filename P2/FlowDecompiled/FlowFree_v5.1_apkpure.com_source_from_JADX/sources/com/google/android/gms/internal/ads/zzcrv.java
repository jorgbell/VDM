package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrv extends zzcrx {
    public zzcrv(Context context) {
        this.zzf = new zzavn(context, zzs.zzq().zza(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zze(this.zze, new zzcrw(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzcsk(1));
                } catch (Throwable th) {
                    zzs.zzg().zzg(th, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zzd(new zzcsk(1));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbbk.zzd("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzcsk(1));
    }
}
