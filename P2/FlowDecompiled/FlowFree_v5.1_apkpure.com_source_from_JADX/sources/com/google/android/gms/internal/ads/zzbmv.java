package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmv implements zzri, zzbuy, zzp, zzbux {
    private final zzbmq zza;
    private final zzbmr zzb;
    private final Set<zzbgf> zzc = new HashSet();
    private final zzapq<JSONObject, JSONObject> zzd;
    private final Executor zze;
    private final Clock zzf;
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    @GuardedBy("this")
    private final zzbmu zzh = new zzbmu();
    private boolean zzi = false;
    private WeakReference<?> zzj = new WeakReference<>(this);

    public zzbmv(zzapn zzapn, zzbmr zzbmr, Executor executor, zzbmq zzbmq, Clock clock) {
        this.zza = zzbmq;
        zzaoy<JSONObject> zzaoy = zzapb.zza;
        this.zzd = zzapn.zza("google.afma.activeView.handleUpdate", zzaoy, zzaoy);
        this.zzb = zzbmr;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzj() {
        for (zzbgf zzc2 : this.zzc) {
            this.zza.zzc(zzc2);
        }
        this.zza.zzd();
    }

    public final synchronized void zzb(Context context) {
        this.zzh.zzb = false;
        zzf();
    }

    public final synchronized void zzbJ() {
        this.zzh.zzb = false;
        zzf();
    }

    public final synchronized void zzbn(Context context) {
        this.zzh.zze = "u";
        zzf();
        zzj();
        this.zzi = true;
    }

    public final void zzbo() {
    }

    public final synchronized void zzbp() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zza(this);
            zzf();
        }
    }

    public final synchronized void zzbq(Context context) {
        this.zzh.zzb = true;
        zzf();
    }

    public final void zzbr() {
    }

    public final synchronized void zzbs() {
        this.zzh.zzb = true;
        zzf();
    }

    public final void zzbt(int i) {
    }

    public final synchronized void zzc(zzrh zzrh) {
        zzbmu zzbmu = this.zzh;
        zzbmu.zza = zzrh.zzj;
        zzbmu.zzf = zzrh;
        zzf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.ref.WeakReference<?> r0 = r5.zzj     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x005b
            boolean r0 = r5.zzi     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0059
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zzg     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzbmu r0 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.common.util.Clock r1 = r5.zzf     // Catch:{ Exception -> 0x0051 }
            long r1 = r1.elapsedRealtime()     // Catch:{ Exception -> 0x0051 }
            r0.zzd = r1     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzbmr r0 = r5.zzb     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzbmu r1 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            org.json.JSONObject r0 = r0.zzb(r1)     // Catch:{ Exception -> 0x0051 }
            java.util.Set<com.google.android.gms.internal.ads.zzbgf> r1 = r5.zzc     // Catch:{ Exception -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x002d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzbgf r2 = (com.google.android.gms.internal.ads.zzbgf) r2     // Catch:{ Exception -> 0x0051 }
            java.util.concurrent.Executor r3 = r5.zze     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzbmt r4 = new com.google.android.gms.internal.ads.zzbmt     // Catch:{ Exception -> 0x0051 }
            r4.<init>(r2, r0)     // Catch:{ Exception -> 0x0051 }
            r3.execute(r4)     // Catch:{ Exception -> 0x0051 }
            goto L_0x002d
        L_0x0044:
            com.google.android.gms.internal.ads.zzapq<org.json.JSONObject, org.json.JSONObject> r1 = r5.zzd     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzefw r0 = r1.zzb(r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "ActiveViewListener.callActiveViewJs"
            com.google.android.gms.internal.ads.zzbbz.zzb(r0, r1)     // Catch:{ Exception -> 0x0051 }
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            java.lang.String r1 = "Failed to call ActiveViewJS"
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r0)     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0059:
            monitor-exit(r5)
            return
        L_0x005b:
            r5.zzg()     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0060:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x0064
        L_0x0063:
            throw r0
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmv.zzf():void");
    }

    public final synchronized void zzg() {
        zzj();
        this.zzi = true;
    }

    public final synchronized void zzh(zzbgf zzbgf) {
        this.zzc.add(zzbgf);
        this.zza.zzb(zzbgf);
    }

    public final void zzi(Object obj) {
        this.zzj = new WeakReference<>(obj);
    }
}
