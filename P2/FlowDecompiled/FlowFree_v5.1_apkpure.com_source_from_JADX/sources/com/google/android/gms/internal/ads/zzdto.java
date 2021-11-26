package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbql;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdto<AdT extends zzbql> {
    private final zzdsn zza;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzdtn zzb;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzege<zzdta<AdT>> zzc;
    @GuardedBy("this")
    private zzefw<zzdta<AdT>> zzd;
    /* access modifiers changed from: private */
    public final zzdsr zze;
    /* access modifiers changed from: private */
    public final zzdtm<AdT> zzf;
    @GuardedBy("this.pendingTopOffs")
    private final LinkedList<zzdtn> zzg;
    private final zzefk<zzdta<AdT>> zzh = new zzdtk(this);
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public int zzi = 1;

    public zzdto(zzdsr zzdsr, zzdsn zzdsn, zzdtm<AdT> zzdtm) {
        this.zze = zzdsr;
        this.zza = zzdsn;
        this.zzf = zzdtm;
        this.zzg = new LinkedList<>();
        zzdsn.zza(new zzdtj(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r4.zzb() == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r3.zze.zzc(r4.zzb()) == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r3.zzb = r4.zzc();
        r3.zzc = com.google.android.gms.internal.ads.zzege.zza();
        r0 = r3.zzf.zza(r3.zzb);
        r3.zzd = r0;
        com.google.android.gms.internal.ads.zzefo.zzo(r0, r3.zzh, r4.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        zzl((com.google.android.gms.internal.ads.zzdtn) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(com.google.android.gms.internal.ads.zzdtn r4) {
        /*
            r3 = this;
            java.util.LinkedList<com.google.android.gms.internal.ads.zzdtn> r0 = r3.zzg
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzaeq.zzet     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x008d }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x008d }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x008d }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzbav r1 = com.google.android.gms.ads.internal.zzs.zzg()     // Catch:{ all -> 0x008d }
            com.google.android.gms.ads.internal.util.zzg r1 = r1.zzl()     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzbar r1 = r1.zzn()     // Catch:{ all -> 0x008d }
            boolean r1 = r1.zzi()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            java.util.LinkedList<com.google.android.gms.internal.ads.zzdtn> r4 = r3.zzg     // Catch:{ all -> 0x008d }
            r4.clear()     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x002f:
            boolean r1 = r3.zzm()     // Catch:{ all -> 0x008d }
            if (r1 != 0) goto L_0x003e
            if (r4 == 0) goto L_0x003c
            java.util.LinkedList<com.google.android.gms.internal.ads.zzdtn> r1 = r3.zzg     // Catch:{ all -> 0x008d }
            r1.add(r4)     // Catch:{ all -> 0x008d }
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x003e:
            if (r4 != 0) goto L_0x004b
            java.util.LinkedList<com.google.android.gms.internal.ads.zzdtn> r1 = r3.zzg     // Catch:{ all -> 0x008d }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x008d }
            if (r1 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x004b:
            if (r4 != 0) goto L_0x0055
            java.util.LinkedList<com.google.android.gms.internal.ads.zzdtn> r4 = r3.zzg     // Catch:{ all -> 0x008d }
            java.lang.Object r4 = r4.pollFirst()     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzdtn r4 = (com.google.android.gms.internal.ads.zzdtn) r4     // Catch:{ all -> 0x008d }
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzdtb r0 = r4.zzb()
            if (r0 == 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzdsr r0 = r3.zze
            com.google.android.gms.internal.ads.zzdtb r1 = r4.zzb()
            boolean r0 = r0.zzc(r1)
            if (r0 == 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzdtn r0 = r4.zzc()
            r3.zzb = r0
            com.google.android.gms.internal.ads.zzege r0 = com.google.android.gms.internal.ads.zzege.zza()
            r3.zzc = r0
            com.google.android.gms.internal.ads.zzdtm<AdT> r0 = r3.zzf
            com.google.android.gms.internal.ads.zzdtn r1 = r3.zzb
            com.google.android.gms.internal.ads.zzefw r0 = r0.zza(r1)
            r3.zzd = r0
            com.google.android.gms.internal.ads.zzefk<com.google.android.gms.internal.ads.zzdta<AdT>> r1 = r3.zzh
            java.util.concurrent.Executor r4 = r4.zza()
            com.google.android.gms.internal.ads.zzefo.zzo(r0, r1, r4)
            return
        L_0x0088:
            r4 = 0
            r3.zzl(r4)
            return
        L_0x008d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdto.zzl(com.google.android.gms.internal.ads.zzdtn):void");
    }

    private final boolean zzm() {
        zzefw<zzdta<AdT>> zzefw = this.zzd;
        return zzefw == null || zzefw.isDone();
    }

    public final void zza(zzdtn zzdtn) {
        synchronized (this.zzg) {
            this.zzg.add(zzdtn);
        }
    }

    public final synchronized zzefw<zzdtl<AdT>> zzb(zzdtn zzdtn) {
        if (zzm()) {
            return null;
        }
        if (this.zzi == 2) {
            return null;
        }
        if (!(this.zzb.zzb() == null || zzdtn.zzb() == null)) {
            if (this.zzb.zzb().equals(zzdtn.zzb())) {
                this.zzi = 2;
                return zzefo.zzh(this.zzc, new zzdti(this), zzdtn.zza());
            }
        }
        this.zzi = 3;
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        synchronized (this) {
            zzl(this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzd(zzdta zzdta) throws Exception {
        zzefw zza2;
        synchronized (this) {
            zza2 = zzefo.zza(new zzdtl(zzdta, this.zzb));
        }
        return zza2;
    }
}
