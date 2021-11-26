package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrz extends zzcrx {
    public zzcrz(Context context) {
        this.zzf = new zzavn(context, zzs.zzq().zza(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, new zzcrw(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzcsk(1));
                } catch (Throwable th) {
                    zzs.zzg().zzg(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zzd(new zzcsk(1));
                }
            }
        }
    }
}
