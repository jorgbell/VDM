package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zze;
import com.google.android.gms.internal.measurement.zzf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzfd implements ServiceConnection {
    final /* synthetic */ zzfe zza;
    /* access modifiers changed from: private */
    public final String zzb;

    zzfd(zzfe zzfe, String str) {
        this.zza = zzfe;
        this.zzb = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                zzf zzb2 = zze.zzb(iBinder);
                if (zzb2 == null) {
                    this.zza.zza.zzau().zze().zza("Install Referrer Service implementation was not found");
                    return;
                }
                this.zza.zza.zzau().zzk().zza("Install Referrer Service connected");
                this.zza.zza.zzav().zzh(new zzfc(this, zzb2, this));
            } catch (Exception e) {
                this.zza.zza.zzau().zze().zzb("Exception occurred while calling Install Referrer API", e);
            }
        } else {
            this.zza.zza.zzau().zze().zza("Install Referrer connection returned with null binder");
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzau().zzk().zza("Install Referrer Service disconnected");
    }
}
