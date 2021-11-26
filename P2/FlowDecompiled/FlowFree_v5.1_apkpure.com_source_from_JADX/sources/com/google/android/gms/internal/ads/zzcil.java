package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcil {
    private final zzdrg zza;
    private final Executor zzb;
    private final zzckt zzc;

    public zzcil(zzdrg zzdrg, Executor executor, zzckt zzckt) {
        this.zza = zzdrg;
        this.zzb = executor;
        this.zzc = zzckt;
    }

    private final void zzh(zzbgf zzbgf) {
        zzbgf.zzab("/video", zzako.zzm);
        zzbgf.zzab("/videoMeta", zzako.zzn);
        zzbgf.zzab("/precache", new zzbfo());
        zzbgf.zzab("/delayPageLoaded", zzako.zzq);
        zzbgf.zzab("/instrument", zzako.zzo);
        zzbgf.zzab("/log", zzako.zzh);
        zzbgf.zzab("/videoClicked", zzako.zzi);
        zzbgf.zzR().zzE(true);
        zzbgf.zzab("/click", zzako.zzd);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbZ)).booleanValue()) {
            zzbgf.zzab("/getNativeAdViewSignals", zzako.zzt);
        }
        if (this.zza.zzb != null) {
            zzbgf.zzR().zzF(true);
            zzbgf.zzab("/open", new zzala((zzb) null, (zzate) null, (zzcvk) null, (zzcni) null, (zzdvo) null));
        } else {
            zzbgf.zzR().zzF(false);
        }
        if (zzs.zzA().zzb(zzbgf.getContext())) {
            zzbgf.zzab("/logScionEvent", new zzakv(zzbgf.getContext()));
        }
    }

    public final zzefw<zzbgf> zza(JSONObject jSONObject) {
        return zzefo.zzh(zzefo.zzh(zzefo.zza(null), new zzcic(this), this.zzb), new zzcia(this, jSONObject), this.zzb);
    }

    public final zzefw<zzbgf> zzb(String str, String str2) {
        return zzefo.zzh(zzefo.zza(null), new zzcib(this, str, str2), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(Object obj) throws Exception {
        zzbgf zza2 = this.zzc.zza(zzyx.zzb(), (zzdqo) null, (zzdqr) null);
        zzbca zza3 = zzbca.zza(zza2);
        zzh(zza2);
        zza2.zzR().zzx(new zzcid(zza3));
        zza2.loadUrl((String) zzaaa.zzc().zzb(zzaeq.zzbY));
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzd(String str, String str2, Object obj) throws Exception {
        zzbgf zza2 = this.zzc.zza(zzyx.zzb(), (zzdqo) null, (zzdqr) null);
        zzbca zza3 = zzbca.zza(zza2);
        zzh(zza2);
        if (this.zza.zzb != null) {
            zza2.zzaf(zzbhv.zze());
        } else {
            zza2.zzaf(zzbhv.zzd());
        }
        zza2.zzR().zzw(new zzcie(this, zza2, zza3));
        zza2.zzat(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbgf zzbgf, zzbca zzbca, boolean z) {
        if (z) {
            if (!(this.zza.zza == null || zzbgf.zzh() == null)) {
                zzbgf.zzh().zzc(this.zza.zza);
            }
            zzbca.zzb();
            return;
        }
        zzbca.zzd(new zzczn(1, "Instream video Web View failed to load."));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzf(JSONObject jSONObject, zzbgf zzbgf) throws Exception {
        zzbca zza2 = zzbca.zza(zzbgf);
        if (this.zza.zzb != null) {
            zzbgf.zzaf(zzbhv.zze());
        } else {
            zzbgf.zzaf(zzbhv.zzd());
        }
        zzbgf.zzR().zzw(new zzcif(this, zzbgf, zza2));
        zzbgf.zzr("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzbgf zzbgf, zzbca zzbca, boolean z) {
        if (!(this.zza.zza == null || zzbgf.zzh() == null)) {
            zzbgf.zzh().zzc(this.zza.zza);
        }
        zzbca.zzb();
    }
}
