package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbbu implements Executor {
    private final Handler zza = new zzf(Looper.getMainLooper());

    zzbbu() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzs.zzc();
                zzr.zzM(zzs.zzg().zzm(), th);
                throw th;
            }
        } else {
            this.zza.post(runnable);
        }
    }
}
