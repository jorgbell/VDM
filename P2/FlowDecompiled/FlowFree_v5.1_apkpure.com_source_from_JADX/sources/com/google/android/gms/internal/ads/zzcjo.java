package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcjo {
    /* access modifiers changed from: private */
    public final zzcjj zza = new zzcjj((zzcje) null);
    private final zza zzb;
    private final Context zzd;
    private final zzcni zze;
    private final zzdvo zzf;
    private final Executor zzg;
    private final zzfh zzh;
    private final zzbbq zzi;
    private final zzald zzj;
    private final zzcvk zzk;
    private final zzdwg zzl;
    private zzefw<zzbgf> zzm;

    zzcjo(zzcjm zzcjm) {
        this.zzd = zzcjm.zzc;
        this.zzg = zzcjm.zzg;
        this.zzh = zzcjm.zzh;
        this.zzi = zzcjm.zzi;
        this.zzb = zzcjm.zza;
        zzbgr unused = zzcjm.zzb;
        this.zzj = new zzald();
        this.zzk = zzcjm.zzf;
        this.zzl = zzcjm.zzj;
        this.zze = zzcjm.zzd;
        this.zzf = zzcjm.zze;
    }

    public final synchronized void zza() {
        zzefw<zzbgf> zzi2 = zzefo.zzi(zzbgr.zzb(this.zzd, this.zzi, (String) zzaaa.zzc().zzb(zzaeq.zzbX), this.zzh, this.zzb), new zzcjc(this), this.zzg);
        this.zzm = zzi2;
        zzbbz.zza(zzi2, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb() {
        zzefw<zzbgf> zzefw = this.zzm;
        if (zzefw != null) {
            zzefo.zzo(zzefw, new zzcje(this), this.zzg);
            this.zzm = null;
        }
    }

    public final synchronized zzefw<JSONObject> zzc(String str, JSONObject jSONObject) {
        zzefw<zzbgf> zzefw = this.zzm;
        if (zzefw == null) {
            return zzefo.zza(null);
        }
        return zzefo.zzh(zzefw, new zzcjd(this, str, jSONObject), this.zzg);
    }

    public final synchronized void zzd(String str, zzakp<Object> zzakp) {
        zzefw<zzbgf> zzefw = this.zzm;
        if (zzefw != null) {
            zzefo.zzo(zzefw, new zzcjf(this, str, zzakp), this.zzg);
        }
    }

    public final synchronized void zze(String str, zzakp<Object> zzakp) {
        zzefw<zzbgf> zzefw = this.zzm;
        if (zzefw != null) {
            zzefo.zzo(zzefw, new zzcjg(this, str, zzakp), this.zzg);
        }
    }

    public final synchronized void zzf(String str, Map<String, ?> map) {
        zzefw<zzbgf> zzefw = this.zzm;
        if (zzefw != null) {
            zzefo.zzo(zzefw, new zzcjh(this, "sendMessageToNativeJs", map), this.zzg);
        }
    }

    public final synchronized void zzg(zzdqo zzdqo, zzdqr zzdqr) {
        zzefw<zzbgf> zzefw = this.zzm;
        if (zzefw != null) {
            zzefo.zzo(zzefw, new zzcji(this, zzdqo, zzdqr), this.zzg);
        }
    }

    public final <T> void zzh(WeakReference<T> weakReference, String str, zzakp<T> zzakp) {
        zzd(str, new zzcjn(this, weakReference, str, zzakp, (zzcje) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzi(String str, JSONObject jSONObject, zzbgf zzbgf) throws Exception {
        return this.zzj.zzc(zzbgf, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbgf zzj(zzbgf zzbgf) {
        zzbgf zzbgf2 = zzbgf;
        zzbgf2.zzab("/result", this.zzj);
        zzbht zzR = zzbgf.zzR();
        zzcjj zzcjj = this.zza;
        zzb zzb2 = new zzb(this.zzd, (zzayr) null, (zzavq) null);
        zzcvk zzcvk = this.zzk;
        zzdwg zzdwg = this.zzl;
        zzR.zzK((zzyi) null, zzcjj, zzcjj, zzcjj, zzcjj, false, (zzaks) null, zzb2, (zzatl) null, (zzayr) null, zzcvk, zzdwg, this.zze, this.zzf, (zzakq) null);
        return zzbgf2;
    }
}
