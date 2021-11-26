package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmk implements zzbuf, zzbvr, zzbux, zzyi, zzbut {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzdra zzd;
    /* access modifiers changed from: private */
    public final zzdqo zze;
    /* access modifiers changed from: private */
    public final zzdwd zzf;
    /* access modifiers changed from: private */
    public final zzdrq zzg;
    private final zzfh zzh;
    private final zzafp zzi;
    private final WeakReference<View> zzj;
    @GuardedBy("this")
    private boolean zzk;
    @GuardedBy("this")
    private boolean zzl;

    public zzbmk(Context context, Executor executor, ScheduledExecutorService scheduledExecutorService, zzdra zzdra, zzdqo zzdqo, zzdwd zzdwd, zzdrq zzdrq, View view, zzfh zzfh, zzafp zzafp, zzafr zzafr, byte[] bArr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
        this.zzd = zzdra;
        this.zze = zzdqo;
        this.zzf = zzdwd;
        this.zzg = zzdrq;
        this.zzh = zzfh;
        this.zzj = new WeakReference<>(view);
        this.zzi = zzafp;
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzaaa.zzc().zzb(zzaeq.zzai)).booleanValue() || !this.zzd.zzb.zzb.zzg) && zzagc.zzd.zze().booleanValue()) {
            zzefo.zzo(zzefo.zze(zzeff.zzw(this.zzi.zzb()), Throwable.class, zzbmh.zza, zzbbw.zzf), new zzbmi(this), this.zzb);
            return;
        }
        zzdrq zzdrq = this.zzg;
        zzdwd zzdwd = this.zzf;
        zzdra zzdra = this.zzd;
        zzdqo zzdqo = this.zze;
        List<String> zza2 = zzdwd.zza(zzdra, zzdqo, zzdqo.zzc);
        zzs.zzc();
        int i = 1;
        if (true == zzr.zzH(this.zza)) {
            i = 2;
        }
        zzdrq.zzb(zza2, i);
    }

    public final synchronized void zzbD() {
        if (this.zzk) {
            ArrayList arrayList = new ArrayList(this.zze.zzd);
            arrayList.addAll(this.zze.zzf);
            this.zzg.zza(this.zzf.zzb(this.zzd, this.zze, true, (String) null, (String) null, arrayList));
        } else {
            zzdrq zzdrq = this.zzg;
            zzdwd zzdwd = this.zzf;
            zzdra zzdra = this.zzd;
            zzdqo zzdqo = this.zze;
            zzdrq.zza(zzdwd.zza(zzdra, zzdqo, zzdqo.zzm));
            zzdrq zzdrq2 = this.zzg;
            zzdwd zzdwd2 = this.zzf;
            zzdra zzdra2 = this.zzd;
            zzdqo zzdqo2 = this.zze;
            zzdrq2.zza(zzdwd2.zza(zzdra2, zzdqo2, zzdqo2.zzf));
        }
        this.zzk = true;
    }

    public final synchronized void zzbp() {
        if (!this.zzl) {
            String zzk2 = ((Boolean) zzaaa.zzc().zzb(zzaeq.zzbS)).booleanValue() ? this.zzh.zzb().zzk(this.zza, (View) this.zzj.get(), (Activity) null) : null;
            if ((!((Boolean) zzaaa.zzc().zzb(zzaeq.zzai)).booleanValue() || !this.zzd.zzb.zzb.zzg) && zzagc.zzg.zze().booleanValue()) {
                zzefo.zzo((zzeff) zzefo.zzg(zzeff.zzw(zzefo.zza(null)), ((Long) zzaaa.zzc().zzb(zzaeq.zzaG)).longValue(), TimeUnit.MILLISECONDS, this.zzc), new zzbmj(this, zzk2), this.zzb);
                this.zzl = true;
                return;
            }
            zzdrq zzdrq = this.zzg;
            zzdwd zzdwd = this.zzf;
            zzdra zzdra = this.zzd;
            zzdqo zzdqo = this.zze;
            zzdrq.zza(zzdwd.zzb(zzdra, zzdqo, false, zzk2, (String) null, zzdqo.zzd));
            this.zzl = true;
        }
    }

    public final void zzc() {
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    public final void zzf(zzaws zzaws, String str, String str2) {
        zzdrq zzdrq = this.zzg;
        zzdwd zzdwd = this.zzf;
        zzdqo zzdqo = this.zze;
        zzdrq.zza(zzdwd.zzc(zzdqo, zzdqo.zzh, zzaws));
    }

    public final void zzg() {
        zzdrq zzdrq = this.zzg;
        zzdwd zzdwd = this.zzf;
        zzdra zzdra = this.zzd;
        zzdqo zzdqo = this.zze;
        zzdrq.zza(zzdwd.zza(zzdra, zzdqo, zzdqo.zzg));
    }

    public final void zzh() {
        zzdrq zzdrq = this.zzg;
        zzdwd zzdwd = this.zzf;
        zzdra zzdra = this.zzd;
        zzdqo zzdqo = this.zze;
        zzdrq.zza(zzdwd.zza(zzdra, zzdqo, zzdqo.zzi));
    }

    public final void zzi(zzym zzym) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaZ)).booleanValue()) {
            this.zzg.zza(this.zzf.zza(this.zzd, this.zze, zzdwd.zzd(2, zzym.zza, this.zze.zzn)));
        }
    }
}
