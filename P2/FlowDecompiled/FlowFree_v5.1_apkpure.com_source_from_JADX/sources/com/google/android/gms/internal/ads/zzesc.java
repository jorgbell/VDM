package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
class zzesc extends zzesb {
    protected final byte[] zza;

    zzesc(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzesf) || zzc() != ((zzesf) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzesc)) {
            return obj.equals(this);
        }
        zzesc zzesc = (zzesc) obj;
        int zzB = zzB();
        int zzB2 = zzesc.zzB();
        if (zzB == 0 || zzB2 == 0 || zzB == zzB2) {
            return zzh(zzesc, 0, zzc());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public int zzd() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(zzesf zzesf, int i, int i2) {
        if (i2 <= zzesf.zzc()) {
            int i3 = i + i2;
            if (i3 > zzesf.zzc()) {
                int zzc = zzesf.zzc();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(zzc);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzesf instanceof zzesc)) {
                return zzesf.zzi(i, i3).equals(zzi(0, i2));
            } else {
                zzesc zzesc = (zzesc) zzesf;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzesc.zza;
                int zzd = zzd() + i2;
                int zzd2 = zzd();
                int zzd3 = zzesc.zzd() + i;
                while (zzd2 < zzd) {
                    if (bArr[zzd2] != bArr2[zzd3]) {
                        return false;
                    }
                    zzd2++;
                    zzd3++;
                }
                return true;
            }
        } else {
            int zzc2 = zzc();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(zzc2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final zzesf zzi(int i, int i2) {
        int zzD = zzesf.zzD(i, i2, zzc());
        if (zzD == 0) {
            return zzesf.zzb;
        }
        return new zzerz(this.zza, zzd() + i, zzD);
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zzerv zzerv) throws IOException {
        ((zzesm) zzerv).zzp(this.zza, zzd(), zzc());
    }

    /* access modifiers changed from: protected */
    public final String zzk(Charset charset) {
        return new String(this.zza, zzd(), zzc(), charset);
    }

    public final boolean zzl() {
        int zzd = zzd();
        return zzewi.zzb(this.zza, zzd, zzc() + zzd);
    }

    /* access modifiers changed from: protected */
    public final int zzm(int i, int i2, int i3) {
        int zzd = zzd() + i2;
        return zzewi.zzc(i, this.zza, zzd, i3 + zzd);
    }

    /* access modifiers changed from: protected */
    public final int zzn(int i, int i2, int i3) {
        return zzetr.zzh(i, this.zza, zzd() + i2, i3);
    }

    public final zzesj zzo() {
        return zzesj.zzF(this.zza, zzd(), zzc(), true);
    }
}
