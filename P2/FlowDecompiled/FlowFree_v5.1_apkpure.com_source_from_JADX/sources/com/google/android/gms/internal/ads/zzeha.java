package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzeha<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zza;

    public zzeha(Class<PrimitiveT> cls) {
        this.zza = cls;
    }

    /* access modifiers changed from: package-private */
    public final Class<PrimitiveT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zzb(KeyT keyt) throws GeneralSecurityException;
}
