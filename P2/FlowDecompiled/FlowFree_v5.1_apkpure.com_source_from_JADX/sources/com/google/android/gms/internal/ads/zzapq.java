package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzapq<I, O> implements zzeev<I, O> {
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final zzefw<zzaor> zzd;

    zzapq(zzefw<zzaor> zzefw, String str, zzaox<I> zzaox, zzaow<O> zzaow) {
        this.zzd = zzefw;
    }

    public final zzefw<O> zza(I i) throws Exception {
        return zzb(i);
    }

    public final zzefw<O> zzb(I i) {
        return zzefo.zzh(this.zzd, new zzapo(this, i), zzbbw.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzc(Object obj, zzaor zzaor) throws Exception {
        zzbcb zzbcb = new zzbcb();
        zzs.zzc();
        String uuid = UUID.randomUUID().toString();
        zzako.zzp.zzb(uuid, new zzapp(this, zzbcb));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzaor.zzr(this.zzc, jSONObject);
        return zzbcb;
    }
}
