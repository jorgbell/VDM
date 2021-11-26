package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzbbj;
import com.google.android.gms.internal.ads.zzbh;
import com.google.android.gms.internal.ads.zzk;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzaz extends zzbh {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzbbj zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzbe zzbe, int i, String str, zzah zzah, zzag zzag, byte[] bArr, Map map, zzbbj zzbbj) {
        super(i, str, zzah, zzag);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzbbj;
    }

    public final Map<String, String> zzm() throws zzk {
        Map<String, String> map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    public final byte[] zzn() throws zzk {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzs(Object obj) {
        zzz((String) obj);
    }

    /* access modifiers changed from: protected */
    public final void zzz(String str) {
        this.zzc.zze(str);
        super.zzz(str);
    }
}
