package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdqb implements zzddq<zzcjw> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzbid zzc;
    /* access modifiers changed from: private */
    public final zzdps zzd;
    /* access modifiers changed from: private */
    public final zzdof<zzckb, zzcjw> zze;
    private final zzdrb zzf;
    @GuardedBy("this")
    private final zzdrf zzg;
    @GuardedBy("this")
    private zzefw<zzcjw> zzh;

    public zzdqb(Context context, Executor executor, zzbid zzbid, zzdof<zzckb, zzcjw> zzdof, zzdps zzdps, zzdrf zzdrf, zzdrb zzdrb) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzbid;
        this.zze = zzdof;
        this.zzd = zzdps;
        this.zzg = zzdrf;
        this.zzf = zzdrb;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzj */
    public final zzcka zzh(zzdod zzdod) {
        zzdqa zzdqa = (zzdqa) zzdod;
        zzcka zzs = this.zzc.zzs();
        zzbtq zzbtq = new zzbtq();
        zzbtq.zza(this.zza);
        zzbtq.zzb(zzdqa.zza);
        String str = zzdqa.zzb;
        zzbtq.zze(this.zzf);
        zzs.zzb(zzbtq.zzd());
        zzs.zzc(new zzbze().zzm());
        return zzs;
    }

    public final boolean zza(zzys zzys, String str, zzddo zzddo, zzddp<? super zzcjw> zzddp) throws RemoteException {
        zzawz zzawz = new zzawz(zzys, str);
        if (zzawz.zzb == null) {
            zzbbk.zzf("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzdpv(this));
        } else {
            zzefw<zzcjw> zzefw = this.zzh;
            if (zzefw == null || zzefw.isDone()) {
                zzdrw.zzb(this.zza, zzawz.zza.zzf);
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue() && zzawz.zza.zzf) {
                    this.zzc.zzy().zzb(true);
                }
                zzdrf zzdrf = this.zzg;
                zzdrf.zzf(zzawz.zzb);
                zzdrf.zzc(zzyx.zzc());
                zzdrf.zza(zzawz.zza);
                zzdrg zzu = zzdrf.zzu();
                zzdqa zzdqa = new zzdqa((zzdpz) null);
                zzdqa.zza = zzu;
                zzdqa.zzb = null;
                zzefw<zzcjw> zzb2 = this.zze.zzb(new zzdog(zzdqa, (zzawc) null), new zzdpw(this));
                this.zzh = zzb2;
                zzefo.zzo(zzb2, new zzdpz(this, zzddp, zzdqa), this.zzb);
                return true;
            }
        }
        return false;
    }

    public final boolean zzb() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zzd.zzbC(zzdsb.zzd(6, (String) null, (zzym) null));
    }

    /* access modifiers changed from: package-private */
    public final void zzi(int i) {
        this.zzg.zzi().zza(i);
    }
}
