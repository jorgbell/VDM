package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegg<V> implements Runnable {
    @NullableDecl
    zzegi<V> zza;

    zzegg(zzegi<V> zzegi) {
        this.zza = zzegi;
    }

    public final void run() {
        zzefw zzb;
        String str;
        zzegi<V> zzegi = this.zza;
        if (zzegi != null && (zzb = zzegi.zza) != null) {
            this.zza = null;
            if (zzb.isDone()) {
                zzegi.zzj(zzb);
                return;
            }
            try {
                ScheduledFuture zzx = zzegi.zzb;
                ScheduledFuture unused = zzegi.zzb = null;
                str = "Timed out";
                if (zzx != null) {
                    long abs = Math.abs(zzx.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        StringBuilder sb = new StringBuilder(75);
                        sb.append(str);
                        sb.append(" (timeout delayed by ");
                        sb.append(abs);
                        sb.append(" ms after scheduled time)");
                        str = sb.toString();
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zzb);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                zzegi.zzi(new zzegh(sb2.toString(), (zzegf) null));
                zzb.cancel(true);
            } catch (Throwable th) {
                zzb.cancel(true);
                throw th;
            }
        }
    }
}
