package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeuo;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzehb<KeyProtoT extends zzeuo> {
    private final Class<KeyProtoT> zza;
    private final Map<Class<?>, zzeha<?, KeyProtoT>> zzb;
    private final Class<?> zzc;

    @SafeVarargs
    protected zzehb(Class<KeyProtoT> cls, zzeha<?, KeyProtoT>... zzehaArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i <= 0) {
            zzeha<?, KeyProtoT> zzeha = zzehaArr[i];
            if (hashMap.containsKey(zzeha.zza())) {
                String valueOf = String.valueOf(zzeha.zza().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzeha.zza(), zzeha);
                i++;
            }
        }
        this.zzc = zzehaArr[0].zza();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public final Class<KeyProtoT> zza() {
        return this.zza;
    }

    public abstract String zzb();

    public abstract zzenx zzc();

    public abstract KeyProtoT zzd(zzesf zzesf) throws zzett;

    public abstract void zze(KeyProtoT keyprotot) throws GeneralSecurityException;

    public final <P> P zzf(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzeha zzeha = this.zzb.get(cls);
        if (zzeha != null) {
            return zzeha.zzb(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Set<Class<?>> zzg() {
        return this.zzb.keySet();
    }

    /* access modifiers changed from: package-private */
    public final Class<?> zzh() {
        return this.zzc;
    }

    public zzegz<?, KeyProtoT> zzi() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
