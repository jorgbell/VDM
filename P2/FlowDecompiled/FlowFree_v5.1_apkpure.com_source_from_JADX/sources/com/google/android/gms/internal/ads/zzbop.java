package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbop extends zzbom {
    private final Context zzc;
    private final View zzd;
    private final zzbgf zze;
    private final zzdqp zzf;
    private final zzbqj zzg;
    private final zzcfi zzh;
    private final zzcba zzi;
    private final zzeyf<zzdcd> zzj;
    private final Executor zzk;
    private zzyx zzl;

    zzbop(zzbqk zzbqk, Context context, zzdqp zzdqp, View view, zzbgf zzbgf, zzbqj zzbqj, zzcfi zzcfi, zzcba zzcba, zzeyf<zzdcd> zzeyf, Executor executor) {
        super(zzbqk);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzbgf;
        this.zzf = zzdqp;
        this.zzg = zzbqj;
        this.zzh = zzcfi;
        this.zzi = zzcba;
        this.zzj = zzeyf;
        this.zzk = executor;
    }

    public final void zzQ() {
        this.zzk.execute(new zzboo(this));
        super.zzQ();
    }

    public final View zza() {
        return this.zzd;
    }

    public final void zzb(ViewGroup viewGroup, zzyx zzyx) {
        zzbgf zzbgf;
        if (viewGroup != null && (zzbgf = this.zze) != null) {
            zzbgf.zzaf(zzbhv.zza(zzyx));
            viewGroup.setMinimumHeight(zzyx.zzc);
            viewGroup.setMinimumWidth(zzyx.zzf);
            this.zzl = zzyx;
        }
    }

    public final zzacj zzc() {
        try {
            return this.zzg.zza();
        } catch (zzdrl unused) {
            return null;
        }
    }

    public final zzdqp zze() {
        zzyx zzyx = this.zzl;
        if (zzyx != null) {
            return zzdrk.zzc(zzyx);
        }
        zzdqo zzdqo = this.zzb;
        if (zzdqo.zzW) {
            for (String next : zzdqo.zza) {
                if (next == null || !next.contains("FirstParty")) {
                }
            }
            return new zzdqp(this.zzd.getWidth(), this.zzd.getHeight(), false);
        }
        return zzdrk.zza(this.zzb.zzq, this.zzf);
    }

    public final zzdqp zzf() {
        return this.zzf;
    }

    public final int zzg() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfb)).booleanValue() && this.zzb.zzab) {
            if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfc)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final void zzh() {
        this.zzi.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzj() {
        if (this.zzh.zzd() != null) {
            try {
                this.zzh.zzd().zze(this.zzj.zzb(), ObjectWrapper.wrap(this.zzc));
            } catch (RemoteException e) {
                zzbbk.zzg("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
