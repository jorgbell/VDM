package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzduw<E> {
    /* access modifiers changed from: private */
    public static final zzefw<?> zza = zzefo.zza(null);
    /* access modifiers changed from: private */
    public final zzefx zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzdux<E> zzd;

    public zzduw(zzefx zzefx, ScheduledExecutorService scheduledExecutorService, zzdux<E> zzdux) {
        this.zzb = zzefx;
        this.zzc = scheduledExecutorService;
        this.zzd = zzdux;
    }

    public final <I> zzduv<I> zza(E e, zzefw<I> zzefw) {
        return new zzduv(this, e, (String) null, zzefw, Collections.singletonList(zzefw), zzefw, (zzdul) null);
    }

    public final zzdun zzb(E e, zzefw<?>... zzefwArr) {
        return new zzdun(this, e, Arrays.asList(zzefwArr), (zzdul) null);
    }

    /* access modifiers changed from: protected */
    public abstract String zzc(E e);
}
