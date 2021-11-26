package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.util.Pair;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdda implements zzbww, zzbvr, zzbui, zzbux, zzyi, zzbuf, zzbwn, zzic, zzbut {
    final BlockingQueue<Pair<String, String>> zza = new ArrayBlockingQueue(((Integer) zzaaa.zzc().zzb(zzaeq.zzfM)).intValue());
    private final AtomicReference<zzaah> zzb = new AtomicReference<>();
    private final AtomicReference<zzabb> zzc = new AtomicReference<>();
    private final AtomicReference<zzacd> zzd = new AtomicReference<>();
    private final AtomicReference<zzaak> zze = new AtomicReference<>();
    private final AtomicReference<zzabi> zzf = new AtomicReference<>();
    private final AtomicBoolean zzg = new AtomicBoolean(true);
    private final AtomicBoolean zzh = new AtomicBoolean(false);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final zzdvo zzj;

    public zzdda(zzdvo zzdvo) {
        this.zzj = zzdvo;
    }

    @TargetApi(5)
    private final void zzt() {
        if (this.zzh.get() && this.zzi.get()) {
            for (Pair zzdcq : this.zza) {
                zzdnu.zza(this.zzc, new zzdcq(zzdcq));
            }
            this.zza.clear();
            this.zzg.set(false);
        }
    }

    public final void onAdClicked() {
        zzdnu.zza(this.zzb, zzdcl.zza);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return;
     */
    @android.annotation.TargetApi(5)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzg     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0036
            java.util.concurrent.BlockingQueue<android.util.Pair<java.lang.String, java.lang.String>> r0 = r3.zza     // Catch:{ all -> 0x0042 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0034
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.internal.ads.zzbbk.zzd(r0)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzdvo r0 = r3.zzj     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0034
            java.lang.String r1 = "dae_action"
            com.google.android.gms.internal.ads.zzdvn r1 = com.google.android.gms.internal.ads.zzdvn.zza(r1)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "dae_name"
            r1.zzc(r2, r4)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = "dae_data"
            r1.zzc(r4, r5)     // Catch:{ all -> 0x0042 }
            r0.zza(r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzabb> r0 = r3.zzc     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzdco r1 = new com.google.android.gms.internal.ads.zzdco     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzdnu.zza(r0, r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdda.zza(java.lang.String, java.lang.String):void");
    }

    public final void zzbC(zzym zzym) {
        zzdnu.zza(this.zzb, new zzdcs(zzym));
        zzdnu.zza(this.zzb, new zzdct(zzym));
        zzdnu.zza(this.zze, new zzdcu(zzym));
        this.zzg.set(false);
        this.zza.clear();
    }

    public final synchronized void zzbD() {
        zzdnu.zza(this.zzb, zzdcw.zza);
        zzdnu.zza(this.zze, zzdcx.zza);
        this.zzi.set(true);
        zzt();
    }

    public final void zzbp() {
        zzdnu.zza(this.zzb, zzdcm.zza);
    }

    public final void zzc() {
        zzdnu.zza(this.zzb, zzdcy.zza);
        zzdnu.zza(this.zzf, zzdcz.zza);
        zzdnu.zza(this.zzf, zzdck.zza);
    }

    public final void zzd() {
        zzdnu.zza(this.zzb, zzdcj.zza);
        zzdnu.zza(this.zzf, zzdcr.zza);
    }

    public final void zze() {
        zzdnu.zza(this.zzb, zzdcv.zza);
    }

    public final void zzf(zzaws zzaws, String str, String str2) {
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi(zzym zzym) {
        zzdnu.zza(this.zzf, new zzdcp(zzym));
    }

    public final void zzj(zzawc zzawc) {
    }

    public final void zzk(zzyz zzyz) {
        zzdnu.zza(this.zzd, new zzdcn(zzyz));
    }

    public final synchronized zzaah zzl() {
        return this.zzb.get();
    }

    public final synchronized zzabb zzm() {
        return this.zzc.get();
    }

    public final void zzn(zzaah zzaah) {
        this.zzb.set(zzaah);
    }

    public final void zzo(zzabb zzabb) {
        this.zzc.set(zzabb);
        this.zzh.set(true);
        zzt();
    }

    public final void zzp(zzacd zzacd) {
        this.zzd.set(zzacd);
    }

    public final void zzq(zzdra zzdra) {
        this.zzg.set(true);
        this.zzi.set(false);
    }

    public final void zzr(zzaak zzaak) {
        this.zze.set(zzaak);
    }

    public final void zzs(zzabi zzabi) {
        this.zzf.set(zzabi);
    }
}
