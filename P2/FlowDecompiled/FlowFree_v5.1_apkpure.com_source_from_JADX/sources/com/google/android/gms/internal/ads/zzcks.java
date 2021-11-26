package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzb;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcks {
    private final zzbud zza;
    /* access modifiers changed from: private */
    public final zzbvk zzb;
    private final zzbvx zzc;
    private final zzbwi zzd;
    private final zzbyp zze;
    private final Executor zzf;
    private final zzcax zzg;
    private final zzbmv zzh;
    private final zzb zzi;
    private final zzayr zzj;
    private final zzfh zzk;
    /* access modifiers changed from: private */
    public final zzbyg zzl;
    private final zzcvk zzm;
    private final zzdwg zzn;
    private final zzcni zzo;
    private final zzdvo zzp;

    public zzcks(zzbud zzbud, zzbvk zzbvk, zzbvx zzbvx, zzbwi zzbwi, zzbyp zzbyp, Executor executor, zzcax zzcax, zzbmv zzbmv, zzb zzb2, zzayr zzayr, zzfh zzfh, zzbyg zzbyg, zzcvk zzcvk, zzdwg zzdwg, zzcni zzcni, zzdvo zzdvo) {
        this.zza = zzbud;
        this.zzb = zzbvk;
        this.zzc = zzbvx;
        this.zzd = zzbwi;
        this.zze = zzbyp;
        this.zzf = executor;
        this.zzg = zzcax;
        this.zzh = zzbmv;
        this.zzi = zzb2;
        this.zzj = zzayr;
        this.zzk = zzfh;
        this.zzl = zzbyg;
        this.zzm = zzcvk;
        this.zzn = zzdwg;
        this.zzo = zzcni;
        this.zzp = zzdvo;
    }

    public static final zzefw<?> zzj(zzbgf zzbgf, String str, String str2) {
        zzbcb zzbcb = new zzbcb();
        zzbgf.zzR().zzw(new zzckq(zzbcb));
        zzbgf.zzat(str, str2, (String) null);
        return zzbcb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbgf zzbgf, zzbgf zzbgf2, Map map) {
        this.zzh.zzh(zzbgf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(View view) {
        this.zzi.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzc(View view, MotionEvent motionEvent) {
        this.zzi.zza();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzb.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(String str, String str2) {
        this.zze.zzbB(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zza.onAdClicked();
    }

    public final void zzi(zzbgf zzbgf, boolean z, zzaks zzaks) {
        zzex zzb2;
        zzbgf zzbgf2 = zzbgf;
        zzbgf.zzR().zzK(new zzckj(this), this.zzc, this.zzd, new zzckk(this), new zzckl(this), z, zzaks, this.zzi, new zzckr(this), this.zzj, this.zzm, this.zzn, this.zzo, this.zzp, (zzakq) null);
        zzbgf2.setOnTouchListener(new zzckm(this));
        zzbgf2.setOnClickListener(new zzckn(this));
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbD)).booleanValue() && (zzb2 = this.zzk.zzb()) != null) {
            zzb2.zzj((View) zzbgf2);
        }
        this.zzg.zzh(zzbgf2, this.zzf);
        this.zzg.zzh(new zzcko(zzbgf2), this.zzf);
        this.zzg.zza((View) zzbgf2);
        zzbgf2.zzab("/trackActiveViewUnit", new zzckp(this, zzbgf2));
        this.zzh.zzi(zzbgf2);
    }
}
