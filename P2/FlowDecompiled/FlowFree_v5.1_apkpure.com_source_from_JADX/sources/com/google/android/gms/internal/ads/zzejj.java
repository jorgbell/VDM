package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzejj extends zzeha<zzegu, zzena> {
    zzejj(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzena zzena = (zzena) obj;
        zzemx zzc = zzena.zzc().zzc();
        zzeng zza = zzc.zza();
        int zzc2 = zzeju.zzc(zza.zza());
        byte[] zzy = zzena.zzd().zzy();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, zzy), zzeqi.zzd(zzc2));
        return new zzeqd((ECPrivateKey) zzeqk.zzg.zza("EC").generatePrivate(eCPrivateKeySpec), zza.zzd().zzy(), zzeju.zzb(zza.zzc()), zzeju.zzd(zzc.zzd()), new zzejv(zzc.zzc().zza()));
    }
}
