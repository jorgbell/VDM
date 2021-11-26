package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzfk<V> extends FutureTask<V> implements Comparable<zzfk<V>> {
    final boolean zza;
    final /* synthetic */ zzfm zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfk(zzfm zzfm, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzb = zzfm;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfm.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfm.zzs.zzau().zzb().zza("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfk zzfk = (zzfk) obj;
        boolean z = this.zza;
        if (z != zzfk.zza) {
            return !z ? 1 : -1;
        }
        long j = this.zzc;
        long j2 = zzfk.zzc;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzb.zzs.zzau().zzc().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzb.zzs.zzau().zzb().zzb(this.zzd, th);
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfk(zzfm zzfm, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzb = zzfm;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzfm.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfm.zzs.zzau().zzb().zza("Tasks index overflow");
        }
    }
}
