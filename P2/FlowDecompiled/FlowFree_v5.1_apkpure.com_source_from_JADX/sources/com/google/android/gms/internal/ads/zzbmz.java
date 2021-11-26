package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmz implements zzeyl<zzre> {
    private final zzeyw<zzdqo> zza;
    private final zzeyw<zzbbq> zzb;
    private final zzeyw<JSONObject> zzc;
    private final zzeyw<String> zzd;

    public zzbmz(zzeyw<zzdqo> zzeyw, zzeyw<zzbbq> zzeyw2, zzeyw<JSONObject> zzeyw3, zzeyw<String> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        ((zzbrb) this.zza).zza();
        String zzb2 = this.zzd.zzb();
        boolean equals = "native".equals(zzb2);
        zzs.zzc();
        return new zzre(UUID.randomUUID().toString(), ((zzbir) this.zzb).zza(), zzb2, this.zzc.zzb(), false, equals);
    }
}
