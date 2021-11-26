package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeuo;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzegy<PrimitiveT, KeyProtoT extends zzeuo> implements zzegw<PrimitiveT> {
    private final zzehb<KeyProtoT> zza;
    private final Class<PrimitiveT> zzb;

    public zzegy(zzehb<KeyProtoT> zzehb, Class<PrimitiveT> cls) {
        if (zzehb.zzg().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzehb;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzehb.toString(), cls.getName()}));
    }

    private final PrimitiveT zzg(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzb)) {
            this.zza.zze(keyprotot);
            return this.zza.zzf(keyprotot, this.zzb);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    private final zzegx<?, KeyProtoT> zzh() {
        return new zzegx<>(this.zza.zzi());
    }

    public final PrimitiveT zza(zzesf zzesf) throws GeneralSecurityException {
        try {
            return zzg(this.zza.zzd(zzesf));
        } catch (zzett e) {
            String valueOf = String.valueOf(this.zza.zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final PrimitiveT zzb(zzeuo zzeuo) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zza.zza().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.zza.zza().isInstance(zzeuo)) {
            return zzg(zzeuo);
        }
        throw new GeneralSecurityException(concat);
    }

    public final zzeuo zzc(zzesf zzesf) throws GeneralSecurityException {
        try {
            return zzh().zza(zzesf);
        } catch (zzett e) {
            String valueOf = String.valueOf(this.zza.zzi().zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final String zzd() {
        return this.zza.zzb();
    }

    public final Class<PrimitiveT> zze() {
        return this.zzb;
    }

    public final zzeny zzf(zzesf zzesf) throws GeneralSecurityException {
        try {
            zzeuo zza2 = zzh().zza(zzesf);
            zzenv zze = zzeny.zze();
            zze.zza(this.zza.zzb());
            zze.zzb(zza2.zzan());
            zze.zzc(this.zza.zzc());
            return (zzeny) zze.zzah();
        } catch (zzett e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
