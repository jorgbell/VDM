package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.BaseGmsClient;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzto {
    private final Runnable zza = new zztk(this);
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public zztr zzc;
    @GuardedBy("lock")
    private Context zzd;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public zztu zze;

    static /* synthetic */ void zzf(zzto zzto) {
        synchronized (zzto.zzb) {
            zztr zztr = zzto.zzc;
            if (zztr != null) {
                if (zztr.isConnected() || zzto.zzc.isConnecting()) {
                    zzto.zzc.disconnect();
                }
                zzto.zzc = null;
                zzto.zze = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzb
            monitor-enter(r0)
            android.content.Context r1 = r3.zzd     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zztr r1 = r3.zzc     // Catch:{ all -> 0x0022 }
            if (r1 != 0) goto L_0x0020
            com.google.android.gms.internal.ads.zztm r1 = new com.google.android.gms.internal.ads.zztm     // Catch:{ all -> 0x0022 }
            r1.<init>(r3)     // Catch:{ all -> 0x0022 }
            com.google.android.gms.internal.ads.zztn r2 = new com.google.android.gms.internal.ads.zztn     // Catch:{ all -> 0x0022 }
            r2.<init>(r3)     // Catch:{ all -> 0x0022 }
            com.google.android.gms.internal.ads.zztr r1 = r3.zze(r1, r2)     // Catch:{ all -> 0x0022 }
            r3.zzc = r1     // Catch:{ all -> 0x0022 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzto.zzl():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.zzb
            monitor-enter(r0)
            android.content.Context r1 = r2.zzd     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zzd = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzct     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.zzl()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzcs     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zztl r3 = new com.google.android.gms.internal.ads.zztl     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzsc r1 = com.google.android.gms.ads.internal.zzs.zzf()     // Catch:{ all -> 0x0048 }
            r1.zzb(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzto.zza(android.content.Context):void");
    }

    public final void zzb() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzcu)).booleanValue()) {
            synchronized (this.zzb) {
                zzl();
                zzebq zzebq = zzr.zza;
                zzebq.removeCallbacks(this.zza);
                zzebq.postDelayed(this.zza, ((Long) zzaaa.zzc().zzb(zzaeq.zzcv)).longValue());
            }
        }
    }

    public final zztp zzc(zzts zzts) {
        synchronized (this.zzb) {
            if (this.zze == null) {
                zztp zztp = new zztp();
                return zztp;
            }
            try {
                if (this.zzc.zzp()) {
                    zztp zzf = this.zze.zzf(zzts);
                    return zzf;
                }
                zztp zze2 = this.zze.zze(zzts);
                return zze2;
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call into cache service.", e);
                return new zztp();
            }
        }
    }

    public final long zzd(zzts zzts) {
        synchronized (this.zzb) {
            if (this.zze == null) {
                return -2;
            }
            if (this.zzc.zzp()) {
                try {
                    long zzg = this.zze.zzg(zzts);
                    return zzg;
                } catch (RemoteException e) {
                    zzbbk.zzg("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized zztr zze(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zztr(this.zzd, zzs.zzq().zza(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }
}
