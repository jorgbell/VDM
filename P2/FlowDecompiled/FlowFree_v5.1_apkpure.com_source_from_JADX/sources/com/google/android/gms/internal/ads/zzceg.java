package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzceg implements zzeyl<zzre> {
    private final zzeyw<zzbbq> zza;
    private final zzeyw<String> zzb;

    public zzceg(zzeyw<zzbbq> zzeyw, zzeyw<String> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbq zza2 = ((zzbir) this.zza).zza();
        zzs.zzc();
        return new zzre(UUID.randomUUID().toString(), zza2, "native", new JSONObject(), false, true);
    }
}
