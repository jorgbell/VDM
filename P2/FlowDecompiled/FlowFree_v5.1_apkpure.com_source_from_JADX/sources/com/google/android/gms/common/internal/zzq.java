package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzh;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
final class zzq extends GmsClientSupervisor {
    /* access modifiers changed from: private */
    @GuardedBy("connectionStatus")
    public final HashMap<zzm, zzo> zza = new HashMap<>();
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final Handler zzc;
    /* access modifiers changed from: private */
    public final ConnectionTracker zzd;
    private final long zze;
    /* access modifiers changed from: private */
    public final long zzf;

    zzq(Context context) {
        this.zzb = context.getApplicationContext();
        this.zzc = new zzh(context.getMainLooper(), new zzp(this, (zzn) null));
        this.zzd = ConnectionTracker.getInstance();
        this.zze = 5000;
        this.zzf = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzm zzm, ServiceConnection serviceConnection, String str) {
        boolean zze2;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zza) {
            zzo zzo = this.zza.get(zzm);
            if (zzo == null) {
                zzo = new zzo(this, zzm);
                zzo.zzc(serviceConnection, serviceConnection, str);
                zzo.zza(str);
                this.zza.put(zzm, zzo);
            } else {
                this.zzc.removeMessages(0, zzm);
                if (!zzo.zzg(serviceConnection)) {
                    zzo.zzc(serviceConnection, serviceConnection, str);
                    int zzf2 = zzo.zzf();
                    if (zzf2 == 1) {
                        serviceConnection.onServiceConnected(zzo.zzj(), zzo.zzi());
                    } else if (zzf2 == 2) {
                        zzo.zza(str);
                    }
                } else {
                    String valueOf = String.valueOf(zzm);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            zze2 = zzo.zze();
        }
        return zze2;
    }

    /* access modifiers changed from: protected */
    public final void zzc(zzm zzm, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zza) {
            zzo zzo = this.zza.get(zzm);
            if (zzo == null) {
                String valueOf = String.valueOf(zzm);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zzo.zzg(serviceConnection)) {
                zzo.zzd(serviceConnection, str);
                if (zzo.zzh()) {
                    this.zzc.sendMessageDelayed(this.zzc.obtainMessage(0, zzm), this.zze);
                }
            } else {
                String valueOf2 = String.valueOf(zzm);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
