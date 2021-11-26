package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeuo;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzegz<KeyFormatProtoT extends zzeuo, KeyT> {
    private final Class<KeyFormatProtoT> zza;

    public zzegz(Class<KeyFormatProtoT> cls) {
        this.zza = cls;
    }

    public final Class<KeyFormatProtoT> zza() {
        return this.zza;
    }

    public abstract void zzb(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzc(zzesf zzesf) throws zzett;

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
}
