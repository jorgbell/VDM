package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeuo;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegx<KeyFormatProtoT extends zzeuo, KeyProtoT extends zzeuo> {
    final zzegz<KeyFormatProtoT, KeyProtoT> zza;

    zzegx(zzegz<KeyFormatProtoT, KeyProtoT> zzegz) {
        this.zza = zzegz;
    }

    /* access modifiers changed from: package-private */
    public final KeyProtoT zza(zzesf zzesf) throws GeneralSecurityException, zzett {
        KeyFormatProtoT zzc = this.zza.zzc(zzesf);
        this.zza.zzb(zzc);
        return this.zza.zzd(zzc);
    }
}
