package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzsc {
    private final Object zza = new Object();
    @GuardedBy("activityTrackerLock")
    private zzsa zzb = null;
    @GuardedBy("activityTrackerLock")
    private boolean zzc = false;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            boolean r1 = r3.zzc     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0032
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x000e
            r1 = r4
        L_0x000e:
            boolean r2 = r1 instanceof android.app.Application     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0015
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x0034 }
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            if (r1 != 0) goto L_0x001f
            java.lang.String r4 = "Can not cast Context to Application"
            com.google.android.gms.internal.ads.zzbbk.zzi(r4)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x001f:
            com.google.android.gms.internal.ads.zzsa r2 = r3.zzb     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzsa r2 = new com.google.android.gms.internal.ads.zzsa     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            r3.zzb = r2     // Catch:{ all -> 0x0034 }
        L_0x002a:
            com.google.android.gms.internal.ads.zzsa r2 = r3.zzb     // Catch:{ all -> 0x0034 }
            r2.zza(r1, r4)     // Catch:{ all -> 0x0034 }
            r4 = 1
            r3.zzc = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsc.zza(android.content.Context):void");
    }

    public final void zzb(zzsb zzsb) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzsa();
            }
            this.zzb.zzb(zzsb);
        }
    }

    public final Activity zzd() {
        synchronized (this.zza) {
            zzsa zzsa = this.zzb;
            if (zzsa == null) {
                return null;
            }
            Activity zzd = zzsa.zzd();
            return zzd;
        }
    }

    public final Context zze() {
        synchronized (this.zza) {
            zzsa zzsa = this.zzb;
            if (zzsa == null) {
                return null;
            }
            Context zze = zzsa.zze();
            return zze;
        }
    }

    public final void zzc(zzsb zzsb) {
        synchronized (this.zza) {
            zzsa zzsa = this.zzb;
            if (zzsa != null) {
                zzsa.zzc(zzsb);
            }
        }
    }
}
