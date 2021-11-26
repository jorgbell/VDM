package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyr implements zzcyl<zzces> {
    private final zzcdl zza;
    private final zzefx zzb;
    private final zzchj zzc;
    private final zzdry<zzcjo> zzd;

    public zzcyr(zzcdl zzcdl, zzefx zzefx, zzchj zzchj, zzdry<zzcjo> zzdry) {
        this.zza = zzcdl;
        this.zzb = zzefx;
        this.zzc = zzchj;
        this.zzd = zzdry;
    }

    private final zzefw<zzces> zzg(zzdra zzdra, zzdqo zzdqo, JSONObject jSONObject) {
        zzefw<zzcjo> zzb2 = this.zzd.zzb();
        zzefw<zzcex> zza2 = this.zzc.zza(zzdra, zzdqo, jSONObject);
        return zzefo.zzm(zzb2, zza2).zza(new zzcyq(this, zza2, zzb2, zzdra, zzdqo, jSONObject), this.zzb);
    }

    public final boolean zza(zzdra zzdra, zzdqo zzdqo) {
        zzdqt zzdqt = zzdqo.zzr;
        return (zzdqt == null || zzdqt.zzc == null) ? false : true;
    }

    public final zzefw<List<zzefw<zzces>>> zzb(zzdra zzdra, zzdqo zzdqo) {
        return zzefo.zzh(zzefo.zzh(this.zzd.zzb(), new zzcym(this, zzdqo), this.zzb), new zzcyn(this, zzdra, zzdqo), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzces zzc(zzefw zzefw, zzefw zzefw2, zzdra zzdra, zzdqo zzdqo, JSONObject jSONObject) throws Exception {
        zzcex zzcex = (zzcex) zzefw.get();
        zzcjo zzcjo = (zzcjo) zzefw2.get();
        zzcey zzc2 = this.zza.zzc(new zzbra(zzdra, zzdqo, (String) null), new zzcfj(zzcex), new zzcdz(jSONObject, zzcjo));
        zzc2.zzi().zzb();
        zzc2.zzj().zza(zzcjo);
        zzc2.zzk().zza(zzcex.zzO());
        return zzc2.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzd(zzcjo zzcjo, JSONObject jSONObject) throws Exception {
        this.zzd.zzc(zzefo.zza(zzcjo));
        if (jSONObject.optBoolean("success")) {
            return zzefo.zza(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzaot("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zze(zzdra zzdra, zzdqo zzdqo, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzefo.zzb(new zzcql(3));
        }
        if (zzdra.zza.zza.zzk <= 1) {
            return zzefo.zzi(zzg(zzdra, zzdqo, jSONArray.getJSONObject(0)), zzcyp.zza, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zza(Math.min(length, zzdra.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzdra.zza.zza.zzk);
        for (int i = 0; i < zzdra.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzdra, zzdqo, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzefo.zzb(new zzcql(3)));
            }
        }
        return zzefo.zza(arrayList);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzf(zzdqo zzdqo, zzcjo zzcjo) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfF)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzdqo.zzr.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzefo.zzh(zzcjo.zzc("google.afma.nativeAds.preProcessJson", jSONObject2), new zzcyo(this, zzcjo), this.zzb);
    }
}
