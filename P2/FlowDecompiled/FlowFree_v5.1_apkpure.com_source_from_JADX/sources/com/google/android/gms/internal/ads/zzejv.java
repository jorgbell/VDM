package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzejv implements zzeqc {
    private final String zza;
    private final int zzb;
    private zzelr zzc;
    private zzekt zzd;
    private int zze;
    private zzemd zzf;

    zzejv(zzeod zzeod) throws GeneralSecurityException {
        String zza2 = zzeod.zza();
        this.zza = zza2;
        if (zza2.equals(zzehv.zzb)) {
            try {
                zzelu zzc2 = zzelu.zzc(zzeod.zzc(), zzest.zza());
                this.zzc = (zzelr) zzeht.zzh(zzeod);
                this.zzb = zzc2.zza();
            } catch (zzett e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zza2.equals(zzehv.zza)) {
            try {
                zzekw zzd2 = zzekw.zzd(zzeod.zzc(), zzest.zza());
                this.zzd = (zzekt) zzeht.zzh(zzeod);
                this.zze = zzd2.zza().zzc();
                this.zzb = this.zze + zzd2.zzc().zzc();
            } catch (zzett e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else if (zza2.equals(zzejg.zza)) {
            try {
                zzemg zzc3 = zzemg.zzc(zzeod.zzc(), zzest.zza());
                this.zzf = (zzemd) zzeht.zzh(zzeod);
                this.zzb = zzc3.zza();
            } catch (zzett e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            String valueOf = String.valueOf(zza2);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzejw zzb(byte[] bArr) throws GeneralSecurityException {
        Class<zzegq> cls = zzegq.class;
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zza.equals(zzehv.zzb)) {
            zzelq zze2 = zzelr.zze();
            zze2.zzai(this.zzc);
            zze2.zzb(zzesf.zzr(bArr, 0, this.zzb));
            return new zzejw((zzegq) zzeht.zzi(this.zza, (zzelr) zze2.zzah(), cls));
        } else if (this.zza.equals(zzehv.zza)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            zzeky zzf2 = zzekz.zzf();
            zzf2.zzai(this.zzd.zzc());
            zzf2.zzc(zzesf.zzs(copyOfRange));
            zzenm zzf3 = zzenn.zzf();
            zzf3.zzai(this.zzd.zzd());
            zzf3.zzc(zzesf.zzs(copyOfRange2));
            zzeks zzf4 = zzekt.zzf();
            zzf4.zza(this.zzd.zza());
            zzf4.zzb((zzekz) zzf2.zzah());
            zzf4.zzc((zzenn) zzf3.zzah());
            return new zzejw((zzegq) zzeht.zzi(this.zza, (zzekt) zzf4.zzah(), cls));
        } else if (this.zza.equals(zzejg.zza)) {
            zzemc zze3 = zzemd.zze();
            zze3.zzai(this.zzf);
            zze3.zzb(zzesf.zzr(bArr, 0, this.zzb));
            return new zzejw((zzegt) zzeht.zzi(this.zza, (zzemd) zze3.zzah(), zzegt.class));
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
