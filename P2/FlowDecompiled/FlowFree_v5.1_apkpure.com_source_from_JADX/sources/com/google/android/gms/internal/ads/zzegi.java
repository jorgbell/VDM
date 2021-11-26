package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegi<V> extends zzefe<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public zzefw<V> zza;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> zzb;

    private zzegi(zzefw<V> zzefw) {
        Objects.requireNonNull(zzefw);
        this.zza = zzefw;
    }

    static <V> zzefw<V> zza(zzefw<V> zzefw, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzegi zzegi = new zzegi(zzefw);
        zzegg zzegg = new zzegg(zzegi);
        zzegi.zzb = scheduledExecutorService.schedule(zzegg, j, timeUnit);
        zzefw.zze(zzegg, zzefc.INSTANCE);
        return zzegi;
    }

    /* access modifiers changed from: protected */
    public final String zzc() {
        zzefw<V> zzefw = this.zza;
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (zzefw == null) {
            return null;
        }
        String valueOf = String.valueOf(zzefw);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zzl(this.zza);
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
