package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdyg implements zzdxl {
    private static final zzdyg zza = new zzdyg();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzj = new zzdyc();
    /* access modifiers changed from: private */
    public static final Runnable zzk = new zzdyd();
    private final List<zzdyf> zzd = new ArrayList();
    private int zze;
    private final zzdxn zzf = new zzdxn();
    private final zzdxz zzg = new zzdxz();
    /* access modifiers changed from: private */
    public final zzdya zzh = new zzdya(new zzdyj());
    private long zzi;

    zzdyg() {
    }

    public static zzdyg zzb() {
        return zza;
    }

    static /* synthetic */ void zzg(zzdyg zzdyg) {
        zzdyg.zze = 0;
        zzdyg.zzi = System.nanoTime();
        zzdyg.zzg.zzd();
        long nanoTime = System.nanoTime();
        zzdxm zza2 = zzdyg.zzf.zza();
        if (zzdyg.zzg.zzb().size() > 0) {
            Iterator<String> it = zzdyg.zzg.zzb().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject zzb2 = zzdxu.zzb(0, 0, 0, 0);
                View zzh2 = zzdyg.zzg.zzh(next);
                zzdxm zzb3 = zzdyg.zzf.zzb();
                String zzc2 = zzdyg.zzg.zzc(next);
                if (zzc2 != null) {
                    JSONObject zza3 = zzb3.zza(zzh2);
                    zzdxu.zzd(zza3, next);
                    zzdxu.zze(zza3, zzc2);
                    zzdxu.zzg(zzb2, zza3);
                }
                zzdxu.zzh(zzb2);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                zzdyg.zzh.zzb(zzb2, hashSet, nanoTime);
            }
        }
        if (zzdyg.zzg.zza().size() > 0) {
            JSONObject zzb4 = zzdxu.zzb(0, 0, 0, 0);
            zzdyg.zzk((View) null, zza2, zzb4, 1);
            zzdxu.zzh(zzb4);
            zzdyg.zzh.zza(zzb4, zzdyg.zzg.zza(), nanoTime);
        } else {
            zzdyg.zzh.zzc();
        }
        zzdyg.zzg.zze();
        long nanoTime2 = System.nanoTime() - zzdyg.zzi;
        if (zzdyg.zzd.size() > 0) {
            for (zzdyf next2 : zzdyg.zzd) {
                int i = zzdyg.zze;
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                next2.zzb();
                if (next2 instanceof zzdye) {
                    int i2 = zzdyg.zze;
                    ((zzdye) next2).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzdxm zzdxm, JSONObject jSONObject, int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        zzdxm.zzb(view, jSONObject, this, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zzk);
            zzc = null;
        }
    }

    public final void zza(View view, zzdxm zzdxm, JSONObject jSONObject) {
        int zzj2;
        if (zzdxx.zzb(view) == null && (zzj2 = this.zzg.zzj(view)) != 3) {
            JSONObject zza2 = zzdxm.zza(view);
            zzdxu.zzg(jSONObject, zza2);
            String zzg2 = this.zzg.zzg(view);
            if (zzg2 != null) {
                zzdxu.zzd(zza2, zzg2);
                this.zzg.zzf();
            } else {
                zzdxy zzi2 = this.zzg.zzi(view);
                if (zzi2 != null) {
                    zzdxu.zzf(zza2, zzi2);
                }
                zzk(view, zzdxm, zza2, zzj2);
            }
            this.zze++;
        }
    }

    public final void zzc() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzj);
            zzc.postDelayed(zzk, 200);
        }
    }

    public final void zzd() {
        zzl();
        this.zzd.clear();
        zzb.post(new zzdyb(this));
    }

    public final void zze() {
        zzl();
    }
}
