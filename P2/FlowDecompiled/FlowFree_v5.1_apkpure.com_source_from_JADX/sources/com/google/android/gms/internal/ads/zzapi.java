package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzapi<I, O> implements zzaou<I, O> {
    /* access modifiers changed from: private */
    public final zzaow<O> zza;
    private final zzaox<I> zzb;
    private final zzaoq zzc;
    private final String zzd;

    zzapi(zzaoq zzaoq, String str, zzaox<I> zzaox, zzaow<O> zzaow) {
        this.zzc = zzaoq;
        this.zzd = str;
        this.zzb = zzaox;
        this.zza = zzaow;
    }

    static /* synthetic */ void zzc(zzapi zzapi, zzaok zzaok, zzaor zzaor, Object obj, zzbcb zzbcb) {
        try {
            zzs.zzc();
            String uuid = UUID.randomUUID().toString();
            zzako.zzp.zzb(uuid, new zzaph(zzapi, zzaok, zzbcb));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzapi.zzb.zzb(obj));
            zzaor.zzr(zzapi.zzd, jSONObject);
        } catch (Exception e) {
            zzbcb.zzd(e);
            zzbbk.zzg("Unable to invokeJavascript", e);
            zzaok.zza();
        } catch (Throwable th) {
            zzaok.zza();
            throw th;
        }
    }

    public final zzefw<O> zza(I i) throws Exception {
        return zzb(i);
    }

    public final zzefw<O> zzb(I i) {
        zzbcb zzbcb = new zzbcb();
        zzaok zzb2 = this.zzc.zzb((zzfh) null);
        zzb2.zze(new zzapf(this, zzb2, i, zzbcb), new zzapg(this, zzbcb, zzb2));
        return zzbcb;
    }
}
