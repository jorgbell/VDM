package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzps {
    /* access modifiers changed from: private */
    public final ExecutorService zza = zzqj.zzb("Loader:ExtractorMediaPeriod");
    /* access modifiers changed from: private */
    public zzpp<? extends zzpq> zzb;
    /* access modifiers changed from: private */
    public IOException zzc;

    public zzps(String str) {
    }

    public final <T extends zzpq> long zza(T t, zzpo<T> zzpo, int i) {
        Looper myLooper = Looper.myLooper();
        zzpu.zzd(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzpp(this, myLooper, t, zzpo, i, elapsedRealtime).zzb(0);
        return elapsedRealtime;
    }

    public final boolean zzb() {
        return this.zzb != null;
    }

    public final void zzc() {
        this.zzb.zzc(false);
    }

    public final void zzd(Runnable runnable) {
        zzpp<? extends zzpq> zzpp = this.zzb;
        if (zzpp != null) {
            zzpp.zzc(true);
        }
        this.zza.execute(runnable);
        this.zza.shutdown();
    }

    public final void zze(int i) throws IOException {
        IOException iOException = this.zzc;
        if (iOException == null) {
            zzpp<? extends zzpq> zzpp = this.zzb;
            if (zzpp != null) {
                zzpp.zza(zzpp.zza);
                return;
            }
            return;
        }
        throw iOException;
    }
}
