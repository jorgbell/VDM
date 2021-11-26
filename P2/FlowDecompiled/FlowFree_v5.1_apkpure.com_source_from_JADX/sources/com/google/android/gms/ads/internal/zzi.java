package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzdyu;
import com.google.android.gms.internal.ads.zzeaa;
import com.google.android.gms.internal.ads.zzeau;
import com.google.android.gms.internal.ads.zzeu;
import com.google.android.gms.internal.ads.zzex;
import com.google.android.gms.internal.ads.zzfg;
import com.google.android.gms.internal.ads.zzzy;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzi implements Runnable, zzex {
    final CountDownLatch zza = new CountDownLatch(1);
    private final List<Object[]> zzb = new Vector();
    private final AtomicReference<zzex> zzc = new AtomicReference<>();
    private final AtomicReference<zzex> zzd = new AtomicReference<>();
    private final boolean zze;
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    /* access modifiers changed from: private */
    public final zzdyu zzi;
    private Context zzj;
    private final Context zzk;
    private zzbbq zzl;
    private final zzbbq zzm;
    private final boolean zzn;
    private int zzo;

    public zzi(Context context, zzbbq zzbbq) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = zzbbq;
        this.zzm = zzbbq;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.zzh = newCachedThreadPool;
        boolean booleanValue = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbt)).booleanValue();
        this.zzn = booleanValue;
        zzdyu zzb2 = zzdyu.zzb(context, newCachedThreadPool, booleanValue);
        this.zzi = zzb2;
        this.zzf = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbp)).booleanValue();
        this.zzg = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbu)).booleanValue();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbs)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        Context context2 = this.zzj;
        zzh zzh2 = new zzh(this);
        this.zze = new zzeau(this.zzj, zzeaa.zzb(context2, zzb2), zzh2, ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbq)).booleanValue()).zzd(1);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbL)).booleanValue()) {
            zzbbw.zza.execute(this);
            return;
        }
        zzzy.zza();
        if (zzbbd.zzp()) {
            zzbbw.zza.execute(this);
        } else {
            run();
        }
    }

    private final void zze() {
        zzex zzn2 = zzn();
        if (!this.zzb.isEmpty() && zzn2 != null) {
            for (Object[] next : this.zzb) {
                int length = next.length;
                if (length == 1) {
                    zzn2.zzf((MotionEvent) next[0]);
                } else if (length == 3) {
                    zzn2.zzg(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzb.clear();
        }
    }

    private final void zzm(boolean z) {
        this.zzc.set(zzfg.zzv(this.zzl.zza, zzo(this.zzj), z, this.zzo));
    }

    private final zzex zzn() {
        if (zzd() == 2) {
            return this.zzd.get();
        }
        return this.zzc.get();
    }

    private static final Context zzo(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final void run() {
        boolean z;
        long currentTimeMillis;
        try {
            boolean z2 = this.zzl.zzd;
            z = false;
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzaH)).booleanValue() && z2) {
                z = true;
            }
            if (zzd() == 1) {
                zzm(z);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzg(this, z));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzeu zza2 = zzeu.zza(this.zzl.zza, zzo(this.zzj), z, this.zzn);
                this.zzd.set(zza2);
                if (this.zzg && !zza2.zzc()) {
                    this.zzo = 1;
                    zzm(z);
                }
            }
        } catch (NullPointerException e) {
            this.zzo = 1;
            zzm(z);
            this.zzi.zzd(2031, System.currentTimeMillis() - currentTimeMillis, e);
        } catch (Throwable th) {
            this.zza.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
        this.zza.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    /* access modifiers changed from: protected */
    public final boolean zza() {
        try {
            this.zza.await();
            return true;
        } catch (InterruptedException e) {
            zzbbk.zzj("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzeu.zza(this.zzm.zza, zzo(this.zzk), z, this.zzn).zzm();
        } catch (NullPointerException e) {
            this.zzi.zzd(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzd() {
        if (!this.zzf || this.zze) {
            return this.zzo;
        }
        return 1;
    }

    public final void zzf(MotionEvent motionEvent) {
        zzex zzn2 = zzn();
        if (zzn2 != null) {
            zze();
            zzn2.zzf(motionEvent);
            return;
        }
        this.zzb.add(new Object[]{motionEvent});
    }

    public final void zzg(int i, int i2, int i3) {
        zzex zzn2 = zzn();
        if (zzn2 != null) {
            zze();
            zzn2.zzg(i, i2, i3);
            return;
        }
        this.zzb.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final String zzh(Context context, String str, View view, Activity activity) {
        zzex zzn2;
        if (!zza() || (zzn2 = zzn()) == null) {
            return "";
        }
        zze();
        return zzn2.zzh(zzo(context), str, view, activity);
    }

    public final String zzi(Context context, String str, View view) {
        return zzh(context, str, view, (Activity) null);
    }

    public final void zzj(View view) {
        zzex zzn2 = zzn();
        if (zzn2 != null) {
            zzn2.zzj(view);
        }
    }

    public final String zzk(Context context, View view, Activity activity) {
        zzex zzn2 = zzn();
        return zzn2 != null ? zzn2.zzk(context, view, (Activity) null) : "";
    }

    public final String zzl(Context context) {
        zzex zzn2;
        if (!zza() || (zzn2 = zzn()) == null) {
            return "";
        }
        zze();
        return zzn2.zzl(zzo(context));
    }
}
