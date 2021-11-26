package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdmu extends zzaat implements zzp, zzsv {
    @GuardedBy("this")
    protected zzbof zza;
    private final zzbid zzb;
    private final Context zzc;
    private AtomicBoolean zzd = new AtomicBoolean();
    private final String zze;
    private final zzdmo zzf;
    /* access modifiers changed from: private */
    public final zzdmm zzg;
    @GuardedBy("this")
    private long zzh = -1;
    @GuardedBy("this")
    private zzbnh zzi;

    public zzdmu(zzbid zzbid, Context context, String str, zzdmo zzdmo, zzdmm zzdmm) {
        this.zzb = zzbid;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzdmo;
        this.zzg = zzdmm;
        zzdmm.zzj(this);
    }

    private final synchronized void zzN(int i) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzn();
            zzbnh zzbnh = this.zzi;
            if (zzbnh != null) {
                zzs.zzf().zzc(zzbnh);
            }
            if (this.zza != null) {
                long j = -1;
                if (this.zzh != -1) {
                    j = zzs.zzj().elapsedRealtime() - this.zzh;
                }
                this.zza.zze(j, i);
            }
            zzc();
        }
    }

    public final synchronized boolean zzA() {
        return this.zzf.zzb();
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
        this.zzf.zzd(zzzd);
    }

    public final void zzI(zzte zzte) {
        this.zzg.zzg(zzte);
    }

    public final void zzJ(boolean z) {
    }

    public final void zzK() {
        this.zzb.zze().execute(new zzdmq(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzN(5);
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
        zzN(3);
    }

    public final synchronized void zzab(zzabf zzabf) {
    }

    public final IObjectWrapper zzb() {
        return null;
    }

    public final boolean zzbI() {
        return false;
    }

    public final void zzbJ() {
    }

    public final synchronized void zzbo() {
        if (this.zza != null) {
            this.zzh = zzs.zzj().elapsedRealtime();
            int zzc2 = this.zza.zzc();
            if (zzc2 > 0) {
                zzbnh zzbnh = new zzbnh(this.zzb.zzf(), zzs.zzj());
                this.zzi = zzbnh;
                zzbnh.zzb(zzc2, new zzdmr(this));
            }
        }
    }

    public final synchronized void zzbr() {
        zzbof zzbof = this.zza;
        if (zzbof != null) {
            zzbof.zze(zzs.zzj().elapsedRealtime() - this.zzh, 1);
        }
    }

    public final void zzbs() {
    }

    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbof zzbof = this.zza;
        if (zzbof != null) {
            zzbof.zzR();
        }
    }

    public final synchronized boolean zze(zzys zzys) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzs.zzc();
        if (zzr.zzJ(this.zzc)) {
            if (zzys.zzs == null) {
                zzbbk.zzf("Failed to load the ad because app ID is missing.");
                this.zzg.zzbC(zzdsb.zzd(4, (String) null, (zzym) null));
                return false;
            }
        }
        if (zzA()) {
            return false;
        }
        this.zzd = new AtomicBoolean();
        return this.zzf.zza(zzys, this.zze, new zzdms(this), new zzdmt(this));
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

    public final synchronized void zzl() {
    }

    public final synchronized void zzm() {
    }

    public final synchronized zzyx zzn() {
        return null;
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
        return this.zze;
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

    public final void zzbt(int i) {
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        } else if (i2 == 0) {
            zzN(2);
        } else if (i2 == 1) {
            zzN(4);
        } else if (i2 == 2) {
            zzN(3);
        } else if (i2 == 3) {
            zzN(6);
        }
    }
}
