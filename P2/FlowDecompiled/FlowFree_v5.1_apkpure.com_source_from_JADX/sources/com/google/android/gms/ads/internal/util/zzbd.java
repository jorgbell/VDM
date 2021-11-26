package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzac;
import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzbbj;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzy;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbd extends zzac<zzy> {
    private final zzbcb<zzy> zza;
    private final zzbbj zzb;

    public zzbd(String str, Map<String, String> map, zzbcb<zzy> zzbcb) {
        super(0, str, new zzbc(zzbcb));
        this.zza = zzbcb;
        zzbbj zzbbj = new zzbbj((String) null);
        this.zzb = zzbbj;
        zzbbj.zzb(str, "GET", (Map<String, ?>) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzai<zzy> zzr(zzy zzy) {
        return zzai.zza(zzy, zzaz.zza(zzy));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzs(Object obj) {
        zzy zzy = (zzy) obj;
        this.zzb.zzd(zzy.zzc, zzy.zza);
        zzbbj zzbbj = this.zzb;
        byte[] bArr = zzy.zzb;
        if (zzbbj.zzj() && bArr != null) {
            zzbbj.zzf(bArr);
        }
        this.zza.zzc(zzy);
    }
}
