package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeu implements zzex {
    private static zzeu zzb;
    volatile long zza = 0;
    private final Context zzc;
    private final zzean zzd;
    private final zzeau zze;
    private final zzeaw zzf;
    private final zzfy zzg;
    /* access modifiers changed from: private */
    public final zzdyu zzh;
    private final Executor zzi;
    private final zzhp zzj;
    private final zzeat zzk;
    /* access modifiers changed from: private */
    public final Object zzl = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzm;
    private volatile boolean zzn = false;

    zzeu(Context context, zzdyu zzdyu, zzean zzean, zzeau zzeau, zzeaw zzeaw, zzfy zzfy, Executor executor, zzdyq zzdyq, zzhp zzhp) {
        this.zzc = context;
        this.zzh = zzdyu;
        this.zzd = zzean;
        this.zze = zzeau;
        this.zzf = zzeaw;
        this.zzg = zzfy;
        this.zzi = executor;
        this.zzj = zzhp;
        this.zzk = new zzes(this, zzdyq);
    }

    public static synchronized zzeu zza(String str, Context context, boolean z, boolean z2) {
        zzeu zzeu;
        synchronized (zzeu.class) {
            if (zzb == null) {
                zzdyv zzd2 = zzdyw.zzd();
                zzd2.zza(str);
                zzd2.zzb(z);
                zzdyw zzd3 = zzd2.zzd();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzeu zzs = zzs(context, zzdyu.zzb(context, newCachedThreadPool, z2), zzd3, newCachedThreadPool);
                zzb = zzs;
                zzs.zzd();
                zzb.zzm();
            }
            zzeu = zzb;
        }
        return zzeu;
    }

    static zzeu zzb(Context context, zzdyu zzdyu, zzdyw zzdyw) {
        return zzs(context, zzdyu, zzdyw, Executors.newCachedThreadPool());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        if (r4.zza().zzc().equals(r5.zzc()) != false) goto L_0x00f4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void zzq(com.google.android.gms.internal.ads.zzeu r12) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            com.google.android.gms.internal.ads.zzeam r3 = r12.zzt(r2)
            r4 = 0
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzhv r4 = r3.zza()
            java.lang.String r4 = r4.zza()
            com.google.android.gms.internal.ads.zzhv r3 = r3.zza()
            java.lang.String r3 = r3.zzc()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001f:
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzett -> 0x011b }
            r6 = 1
            com.google.android.gms.internal.ads.zzhp r7 = r12.zzj     // Catch:{ zzett -> 0x011b }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzdyu r11 = r12.zzh     // Catch:{ zzett -> 0x011b }
            com.google.android.gms.internal.ads.zzear r3 = com.google.android.gms.internal.ads.zzdze.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzett -> 0x011b }
            byte[] r4 = r3.zzb     // Catch:{ zzett -> 0x011b }
            if (r4 == 0) goto L_0x010e
            int r5 = r4.length     // Catch:{ zzett -> 0x011b }
            if (r5 != 0) goto L_0x0037
            goto L_0x010e
        L_0x0037:
            com.google.android.gms.internal.ads.zzesf r4 = com.google.android.gms.internal.ads.zzesf.zzs(r4)     // Catch:{ NullPointerException -> 0x0101 }
            com.google.android.gms.internal.ads.zzest r5 = com.google.android.gms.internal.ads.zzest.zza()     // Catch:{ NullPointerException -> 0x0101 }
            com.google.android.gms.internal.ads.zzhs r4 = com.google.android.gms.internal.ads.zzhs.zze(r4, r5)     // Catch:{ NullPointerException -> 0x0101 }
            com.google.android.gms.internal.ads.zzhv r5 = r4.zza()     // Catch:{ zzett -> 0x011b }
            java.lang.String r5 = r5.zza()     // Catch:{ zzett -> 0x011b }
            boolean r5 = r5.isEmpty()     // Catch:{ zzett -> 0x011b }
            if (r5 != 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzhv r5 = r4.zza()     // Catch:{ zzett -> 0x011b }
            java.lang.String r5 = r5.zzc()     // Catch:{ zzett -> 0x011b }
            boolean r5 = r5.isEmpty()     // Catch:{ zzett -> 0x011b }
            if (r5 != 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzesf r5 = r4.zzd()     // Catch:{ zzett -> 0x011b }
            byte[] r5 = r5.zzy()     // Catch:{ zzett -> 0x011b }
            int r5 = r5.length     // Catch:{ zzett -> 0x011b }
            if (r5 != 0) goto L_0x006c
            goto L_0x00f4
        L_0x006c:
            com.google.android.gms.internal.ads.zzeam r5 = r12.zzt(r2)     // Catch:{ zzett -> 0x011b }
            if (r5 != 0) goto L_0x0073
            goto L_0x009b
        L_0x0073:
            com.google.android.gms.internal.ads.zzhv r5 = r5.zza()     // Catch:{ zzett -> 0x011b }
            com.google.android.gms.internal.ads.zzhv r6 = r4.zza()     // Catch:{ zzett -> 0x011b }
            java.lang.String r6 = r6.zza()     // Catch:{ zzett -> 0x011b }
            java.lang.String r7 = r5.zza()     // Catch:{ zzett -> 0x011b }
            boolean r6 = r6.equals(r7)     // Catch:{ zzett -> 0x011b }
            if (r6 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzhv r6 = r4.zza()     // Catch:{ zzett -> 0x011b }
            java.lang.String r6 = r6.zzc()     // Catch:{ zzett -> 0x011b }
            java.lang.String r5 = r5.zzc()     // Catch:{ zzett -> 0x011b }
            boolean r5 = r6.equals(r5)     // Catch:{ zzett -> 0x011b }
            if (r5 != 0) goto L_0x00f4
        L_0x009b:
            com.google.android.gms.internal.ads.zzeat r5 = r12.zzk     // Catch:{ zzett -> 0x011b }
            int r3 = r3.zzc     // Catch:{ zzett -> 0x011b }
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzaeq.zzbo     // Catch:{ zzett -> 0x011b }
            com.google.android.gms.internal.ads.zzaeo r7 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ zzett -> 0x011b }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ zzett -> 0x011b }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzett -> 0x011b }
            boolean r6 = r6.booleanValue()     // Catch:{ zzett -> 0x011b }
            if (r6 == 0) goto L_0x00c5
            r6 = 3
            if (r3 != r6) goto L_0x00bb
            com.google.android.gms.internal.ads.zzeau r3 = r12.zze     // Catch:{ zzett -> 0x011b }
            boolean r3 = r3.zzb(r4)     // Catch:{ zzett -> 0x011b }
            goto L_0x00cb
        L_0x00bb:
            r6 = 4
            if (r3 != r6) goto L_0x00cd
            com.google.android.gms.internal.ads.zzeau r3 = r12.zze     // Catch:{ zzett -> 0x011b }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzett -> 0x011b }
            goto L_0x00cb
        L_0x00c5:
            com.google.android.gms.internal.ads.zzean r3 = r12.zzd     // Catch:{ zzett -> 0x011b }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzett -> 0x011b }
        L_0x00cb:
            if (r3 != 0) goto L_0x00da
        L_0x00cd:
            com.google.android.gms.internal.ads.zzdyu r2 = r12.zzh     // Catch:{ zzett -> 0x011b }
            r3 = 4009(0xfa9, float:5.618E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzett -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzett -> 0x011b }
            return
        L_0x00da:
            com.google.android.gms.internal.ads.zzeam r3 = r12.zzt(r2)     // Catch:{ zzett -> 0x011b }
            if (r3 == 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzeaw r4 = r12.zzf     // Catch:{ zzett -> 0x011b }
            boolean r3 = r4.zza(r3)     // Catch:{ zzett -> 0x011b }
            if (r3 == 0) goto L_0x00ea
            r12.zzn = r2     // Catch:{ zzett -> 0x011b }
        L_0x00ea:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzett -> 0x011b }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.zza = r2     // Catch:{ zzett -> 0x011b }
        L_0x00f3:
            return
        L_0x00f4:
            com.google.android.gms.internal.ads.zzdyu r2 = r12.zzh     // Catch:{ zzett -> 0x011b }
            r3 = 5010(0x1392, float:7.02E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzett -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzett -> 0x011b }
            return
        L_0x0101:
            com.google.android.gms.internal.ads.zzdyu r2 = r12.zzh     // Catch:{ zzett -> 0x011b }
            r3 = 2030(0x7ee, float:2.845E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzett -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzett -> 0x011b }
            return
        L_0x010e:
            com.google.android.gms.internal.ads.zzdyu r2 = r12.zzh     // Catch:{ zzett -> 0x011b }
            r3 = 5009(0x1391, float:7.019E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzett -> 0x011b }
            long r4 = r4 - r0
            r2.zzc(r3, r4)     // Catch:{ zzett -> 0x011b }
            return
        L_0x011b:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzdyu r12 = r12.zzh
            r3 = 4002(0xfa2, float:5.608E-42)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            r12.zzd(r3, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeu.zzq(com.google.android.gms.internal.ads.zzeu):void");
    }

    private static zzeu zzs(Context context, zzdyu zzdyu, zzdyw zzdyw, Executor executor) {
        zzdzn zza2 = zzdzn.zza(context, executor, zzdyu, zzdyw);
        zzfx zzfx = new zzfx(context);
        zzfy zzfy = new zzfy(zzdyw, zza2, new zzgl(context, zzfx), zzfx);
        zzhp zzb2 = zzeaa.zzb(context, zzdyu);
        zzdyq zzdyq = new zzdyq();
        return new zzeu(context, zzdyu, new zzean(context, zzb2), new zzeau(context, zzb2, new zzer(zzdyu), ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbq)).booleanValue()), new zzeaw(context, zzfy, zzdyu, zzdyq), zzfy, executor, zzdyq, zzb2);
    }

    private final zzeam zzt(int i) {
        if (!zzeaa.zza(this.zzj)) {
            return null;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbo)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    public final synchronized boolean zzc() {
        return this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd() {
        long currentTimeMillis = System.currentTimeMillis();
        zzeam zzt = zzt(1);
        if (zzt == null) {
            this.zzh.zzc(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zza(zzt)) {
            this.zzn = true;
        }
    }

    public final void zze() {
        if (zzeaa.zza(this.zzj)) {
            this.zzi.execute(new zzet(this));
        }
    }

    public final void zzf(MotionEvent motionEvent) {
        zzdyx zzb2 = this.zzf.zzb();
        if (zzb2 != null) {
            try {
                zzb2.zzd((String) null, motionEvent);
            } catch (zzeav e) {
                this.zzh.zzd(e.zza(), -1, e);
            }
        }
    }

    public final void zzg(int i, int i2, int i3) {
    }

    public final String zzh(Context context, String str, View view, Activity activity) {
        zzm();
        zzdyx zzb2 = this.zzf.zzb();
        if (zzb2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zzb2.zzc(context, (String) null, str, view, activity);
        this.zzh.zze(5000, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map<String, String>) null);
        return zzc2;
    }

    public final String zzi(Context context, String str, View view) {
        return zzh(context, str, view, (Activity) null);
    }

    public final void zzj(View view) {
        this.zzg.zza(view);
    }

    public final String zzk(Context context, View view, Activity activity) {
        zzm();
        zzdyx zzb2 = this.zzf.zzb();
        if (zzb2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb3 = zzb2.zzb(context, (String) null, view, (Activity) null);
        this.zzh.zze(5002, System.currentTimeMillis() - currentTimeMillis, zzb3, (Map<String, String>) null);
        return zzb3;
    }

    public final String zzl(Context context) {
        zzm();
        zzdyx zzb2 = this.zzf.zzb();
        if (zzb2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza2 = zzb2.zza(context, (String) null);
        this.zzh.zze(5001, System.currentTimeMillis() - currentTimeMillis, zza2, (Map<String, String>) null);
        return zza2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzm() {
        /*
            r6 = this;
            boolean r0 = r6.zzm
            if (r0 != 0) goto L_0x0033
            java.lang.Object r0 = r6.zzl
            monitor-enter(r0)
            boolean r1 = r6.zzm     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.zza     // Catch:{ all -> 0x0030 }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzeaw r1 = r6.zzf     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzeam r1 = r1.zzc()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zze(r3)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
        L_0x002b:
            r6.zze()     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeu.zzm():void");
    }
}
