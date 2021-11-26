package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaf {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set<zzac<?>> zzb = new HashSet();
    private final PriorityBlockingQueue<zzac<?>> zzc = new PriorityBlockingQueue<>();
    private final PriorityBlockingQueue<zzac<?>> zzd = new PriorityBlockingQueue<>();
    private final zzm zze;
    private final zzv zzf;
    private final zzw[] zzg;
    private zzo zzh;
    private final List<zzae> zzi = new ArrayList();
    private final List<zzad> zzj = new ArrayList();
    private final zzt zzk;

    public zzaf(zzm zzm, zzv zzv, int i) {
        zzt zzt = new zzt(new Handler(Looper.getMainLooper()));
        this.zze = zzm;
        this.zzf = zzv;
        this.zzg = new zzw[4];
        this.zzk = zzt;
    }

    public final void zza() {
        zzo zzo = this.zzh;
        if (zzo != null) {
            zzo.zza();
        }
        zzw[] zzwArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzw zzw = zzwArr[i];
            if (zzw != null) {
                zzw.zza();
            }
        }
        zzo zzo2 = new zzo(this.zzc, this.zzd, this.zze, this.zzk, (zzt) null);
        this.zzh = zzo2;
        zzo2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzw zzw2 = new zzw(this.zzd, this.zzf, this.zze, this.zzk, (zzt) null);
            this.zzg[i2] = zzw2;
            zzw2.start();
        }
    }

    public final <T> zzac<T> zzb(zzac<T> zzac) {
        zzac.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzac);
        }
        zzac.zzg(this.zza.incrementAndGet());
        zzac.zzc("add-to-queue");
        zzd(zzac, 0);
        this.zzc.add(zzac);
        return zzac;
    }

    /* access modifiers changed from: package-private */
    public final <T> void zzc(zzac<T> zzac) {
        synchronized (this.zzb) {
            this.zzb.remove(zzac);
        }
        synchronized (this.zzi) {
            for (zzae zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzd(zzac, 5);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzac<?> zzac, int i) {
        synchronized (this.zzj) {
            for (zzad zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }
}
