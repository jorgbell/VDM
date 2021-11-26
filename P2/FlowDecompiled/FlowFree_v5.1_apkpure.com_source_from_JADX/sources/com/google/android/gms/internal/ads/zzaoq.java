package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzas;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzs;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaoq {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final zzbbq zzd;
    private final zzas<zzanl> zzf;
    /* access modifiers changed from: private */
    public zzaop zzg;
    /* access modifiers changed from: private */
    public int zzh = 1;

    public zzaoq(Context context, zzbbq zzbbq, String str, zzas<zzanl> zzas, zzas<zzanl> zzas2) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = zzbbq;
        this.zzf = zzas2;
    }

    /* access modifiers changed from: protected */
    public final zzaop zza(zzfh zzfh) {
        zzaop zzaop = new zzaop(this.zzf);
        zzbbw.zze.execute(new zzanv(this, (zzfh) null, zzaop));
        zzaop.zze(new zzaof(this, zzaop), new zzaog(this, zzaop));
        return zzaop;
    }

    public final zzaok zzb(zzfh zzfh) {
        synchronized (this.zza) {
            synchronized (this.zza) {
                zzaop zzaop = this.zzg;
                if (zzaop != null && this.zzh == 0) {
                    zzaop.zze(new zzanw(this), zzanx.zza);
                }
            }
            zzaop zzaop2 = this.zzg;
            if (zzaop2 != null) {
                if (zzaop2.zzh() != -1) {
                    int i = this.zzh;
                    if (i == 0) {
                        zzaok zza2 = this.zzg.zza();
                        return zza2;
                    } else if (i == 1) {
                        this.zzh = 2;
                        zza((zzfh) null);
                        zzaok zza3 = this.zzg.zza();
                        return zza3;
                    } else {
                        zzaok zza4 = this.zzg.zza();
                        return zza4;
                    }
                }
            }
            this.zzh = 2;
            zzaop zza5 = zza((zzfh) null);
            this.zzg = zza5;
            zzaok zza6 = zza5.zza();
            return zza6;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzanl zzanl) {
        if (zzanl.zzj()) {
            this.zzh = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfh zzfh, zzaop zzaop) {
        try {
            zzant zzant = new zzant(this.zzb, this.zzd, (zzfh) null, (zza) null);
            zzant.zzh(new zzany(this, zzaop, zzant));
            zzant.zzl("/jsLoaded", new zzaob(this, zzaop, zzant));
            zzbq zzbq = new zzbq();
            zzaoc zzaoc = new zzaoc(this, (zzfh) null, zzant, zzbq);
            zzbq.zzb(zzaoc);
            zzant.zzl("/requestReload", zzaoc);
            if (this.zzc.endsWith(".js")) {
                zzant.zzc(this.zzc);
            } else if (this.zzc.startsWith("<html>")) {
                zzant.zzg(this.zzc);
            } else {
                zzant.zzf(this.zzc);
            }
            zzr.zza.postDelayed(new zzaoe(this, zzaop, zzant), 60000);
        } catch (Throwable th) {
            zzbbk.zzg("Error creating webview.", th);
            zzs.zzg().zzg(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzaop.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zze(com.google.android.gms.internal.ads.zzaop r4, com.google.android.gms.internal.ads.zzanl r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            int r1 = r4.zzh()     // Catch:{ all -> 0x0027 }
            r2 = -1
            if (r1 == r2) goto L_0x0025
            int r1 = r4.zzh()     // Catch:{ all -> 0x0027 }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0025
        L_0x0012:
            r4.zzg()     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzefx r4 = com.google.android.gms.internal.ads.zzbbw.zze     // Catch:{ all -> 0x0027 }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzaoa.zza(r5)     // Catch:{ all -> 0x0027 }
            r4.execute(r5)     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoq.zze(com.google.android.gms.internal.ads.zzaop, com.google.android.gms.internal.ads.zzanl):void");
    }
}
