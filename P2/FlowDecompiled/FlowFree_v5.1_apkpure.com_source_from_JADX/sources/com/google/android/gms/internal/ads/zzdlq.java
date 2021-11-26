package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdlq extends zzaat implements zzaa, zzsv, zzbwc {
    @GuardedBy("this")
    protected zzbnv zza;
    private final zzbid zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final ViewGroup zzd;
    private AtomicBoolean zze = new AtomicBoolean();
    private final String zzf;
    private final zzdlk zzg;
    /* access modifiers changed from: private */
    public final zzdmm zzh;
    /* access modifiers changed from: private */
    public final zzbbq zzi;
    private long zzj = -1;
    private zzbnh zzk;

    public zzdlq(zzbid zzbid, Context context, String str, zzdlk zzdlk, zzdmm zzdmm, zzbbq zzbbq) {
        this.zzd = new FrameLayout(context);
        this.zzb = zzbid;
        this.zzc = context;
        this.zzf = str;
        this.zzg = zzdlk;
        this.zzh = zzdmm;
        zzdmm.zzi(this);
        this.zzi = zzbbq;
    }

    static /* synthetic */ zzr zzT(zzdlq zzdlq, zzbnv zzbnv) {
        boolean zzf2 = zzbnv.zzf();
        int intValue = ((Integer) zzaaa.zzc().zzb(zzaeq.zzdb)).intValue();
        zzq zzq = new zzq();
        zzq.zzd = 50;
        int i = 0;
        zzq.zza = true != zzf2 ? 0 : intValue;
        if (true != zzf2) {
            i = intValue;
        }
        zzq.zzb = i;
        zzq.zzc = intValue;
        return new zzr(zzdlq.zzc, zzq, zzdlq);
    }

    private final synchronized void zzW(int i) {
        if (this.zze.compareAndSet(false, true)) {
            zzbnv zzbnv = this.zza;
            if (!(zzbnv == null || zzbnv.zzk() == null)) {
                this.zzh.zzp(this.zza.zzk());
            }
            this.zzh.zzn();
            this.zzd.removeAllViews();
            zzbnh zzbnh = this.zzk;
            if (zzbnh != null) {
                zzs.zzf().zzc(zzbnh);
            }
            if (this.zza != null) {
                long j = -1;
                if (this.zzj != -1) {
                    j = zzs.zzj().elapsedRealtime() - this.zzj;
                }
                this.zza.zzi(j, i);
            }
            zzc();
        }
    }

    public final synchronized boolean zzA() {
        return this.zzg.zzb();
    }

    public final void zzB(zzawy zzawy) {
    }

    public final void zzC(String str) {
    }

    public final void zzD(String str) {
    }

    public final synchronized zzacj zzE() {
        return null;
    }

    public final synchronized void zzF(zzady zzady) {
    }

    public final void zzG(zzacn zzacn) {
    }

    public final void zzH(zzzd zzzd) {
        this.zzg.zzd(zzzd);
    }

    public final void zzI(zzte zzte) {
        this.zzh.zzg(zzte);
    }

    public final void zzJ(boolean z) {
    }

    public final void zzK() {
        if (this.zza != null) {
            this.zzj = zzs.zzj().elapsedRealtime();
            int zzc2 = this.zza.zzc();
            if (zzc2 > 0) {
                zzbnh zzbnh = new zzbnh(this.zzb.zzf(), zzs.zzj());
                this.zzk = zzbnh;
                zzbnh.zzb(zzc2, new zzdln(this));
            }
        }
    }

    public final void zzL() {
        zzzy.zza();
        if (zzbbd.zzp()) {
            zzW(5);
        } else {
            this.zzb.zze().execute(new zzdlm(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzW(5);
    }

    public final void zzO(zzacd zzacd) {
    }

    public final void zzP(zzys zzys, zzaak zzaak) {
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzR(zzabi zzabi) {
    }

    public final void zza() {
        zzW(3);
    }

    public final synchronized void zzab(zzabf zzabf) {
    }

    public final IObjectWrapper zzb() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzd);
    }

    public final boolean zzbI() {
        return false;
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbnv zzbnv = this.zza;
        if (zzbnv != null) {
            zzbnv.zzR();
        }
    }

    public final void zzd() {
        zzW(4);
    }

    public final synchronized boolean zze(zzys zzys) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzs.zzc();
        if (com.google.android.gms.ads.internal.util.zzr.zzJ(this.zzc)) {
            if (zzys.zzs == null) {
                zzbbk.zzf("Failed to load the ad because app ID is missing.");
                this.zzh.zzbC(zzdsb.zzd(4, (String) null, (zzym) null));
                return false;
            }
        }
        if (zzA()) {
            return false;
        }
        this.zze = new AtomicBoolean();
        return this.zzg.zza(zzys, this.zzf, new zzdlo(this), new zzdlp(this));
    }

    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzh(zzaah zzaah) {
    }

    public final void zzi(zzabb zzabb) {
    }

    public final void zzj(zzaay zzaay) {
    }

    public final Bundle zzk() {
        return new Bundle();
    }

    public final void zzl() {
    }

    public final synchronized void zzm() {
    }

    public final synchronized zzyx zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzbnv zzbnv = this.zza;
        if (zzbnv == null) {
            return null;
        }
        return zzdrk.zzb(this.zzc, Collections.singletonList(zzbnv.zza()));
    }

    public final synchronized void zzo(zzyx zzyx) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zzp(zzaus zzaus) {
    }

    public final void zzq(zzauv zzauv, String str) {
    }

    public final synchronized String zzr() {
        return null;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized zzacg zzt() {
        return null;
    }

    public final synchronized String zzu() {
        return this.zzf;
    }

    public final zzabb zzv() {
        return null;
    }

    public final zzaah zzw() {
        return null;
    }

    public final synchronized void zzx(zzafl zzafl) {
    }

    public final void zzy(zzaae zzaae) {
    }

    public final synchronized void zzz(boolean z) {
    }
}
