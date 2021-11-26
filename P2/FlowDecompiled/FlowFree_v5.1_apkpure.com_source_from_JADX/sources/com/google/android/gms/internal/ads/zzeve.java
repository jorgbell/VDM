package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeve extends zzesf {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    /* access modifiers changed from: private */
    public final zzesf zzd;
    /* access modifiers changed from: private */
    public final zzesf zze;
    private final int zzf;
    private final int zzg;

    private zzeve(zzesf zzesf, zzesf zzesf2) {
        this.zzd = zzesf;
        this.zze = zzesf2;
        int zzc2 = zzesf.zzc();
        this.zzf = zzc2;
        this.zzc = zzc2 + zzesf2.zzc();
        this.zzg = Math.max(zzesf.zzf(), zzesf2.zzf()) + 1;
    }

    private static zzesf zzG(zzesf zzesf, zzesf zzesf2) {
        int zzc2 = zzesf.zzc();
        int zzc3 = zzesf2.zzc();
        byte[] bArr = new byte[(zzc2 + zzc3)];
        zzesf.zzx(bArr, 0, 0, zzc2);
        zzesf2.zzx(bArr, 0, zzc2, zzc3);
        return new zzesc(bArr);
    }

    static zzesf zzd(zzesf zzesf, zzesf zzesf2) {
        if (zzesf2.zzc() == 0) {
            return zzesf;
        }
        if (zzesf.zzc() == 0) {
            return zzesf2;
        }
        int zzc2 = zzesf.zzc() + zzesf2.zzc();
        if (zzc2 < 128) {
            return zzG(zzesf, zzesf2);
        }
        if (zzesf instanceof zzeve) {
            zzeve zzeve = (zzeve) zzesf;
            if (zzeve.zze.zzc() + zzesf2.zzc() < 128) {
                return new zzeve(zzeve.zzd, zzG(zzeve.zze, zzesf2));
            } else if (zzeve.zzd.zzf() > zzeve.zze.zzf() && zzeve.zzg > zzesf2.zzf()) {
                return new zzeve(zzeve.zzd, new zzeve(zzeve.zze, zzesf2));
            }
        }
        if (zzc2 >= zzh(Math.max(zzesf.zzf(), zzesf2.zzf()) + 1)) {
            return new zzeve(zzesf, zzesf2);
        }
        return zzevb.zza(new zzevb((zzeva) null), zzesf, zzesf2);
    }

    static int zzh(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzesf)) {
            return false;
        }
        zzesf zzesf = (zzesf) obj;
        if (this.zzc != zzesf.zzc()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzB = zzB();
        int zzB2 = zzesf.zzB();
        if (zzB != 0 && zzB2 != 0 && zzB != zzB2) {
            return false;
        }
        zzevc zzevc = new zzevc(this, (zzeva) null);
        zzesb zza2 = zzevc.next();
        zzevc zzevc2 = new zzevc(zzesf, (zzeva) null);
        zzesb zza3 = zzevc2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int zzc2 = zza2.zzc() - i;
            int zzc3 = zza3.zzc() - i2;
            int min = Math.min(zzc2, zzc3);
            if (i == 0) {
                z = zza2.zzh(zza3, i2, min);
            } else {
                z = zza3.zzh(zza2, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zzc;
            if (i3 < i4) {
                if (min == zzc2) {
                    zza2 = zzevc.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == zzc3) {
                    zza3 = zzevc2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzeva(this);
    }

    public final byte zza(int i) {
        zzesf.zzC(i, this.zzc);
        return zzb(i);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i) {
        int i2 = this.zzf;
        if (i < i2) {
            return this.zzd.zzb(i);
        }
        return this.zze.zzb(i - i2);
    }

    public final int zzc() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.zzf;
        if (i + i3 <= i4) {
            this.zzd.zze(bArr, i, i2, i3);
        } else if (i >= i4) {
            this.zze.zze(bArr, i - i4, i2, i3);
        } else {
            int i5 = i4 - i;
            this.zzd.zze(bArr, i, i2, i5);
            this.zze.zze(bArr, 0, i2 + i5, i3 - i5);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final boolean zzg() {
        return this.zzc >= zzh(this.zzg);
    }

    public final zzesf zzi(int i, int i2) {
        int zzD = zzesf.zzD(i, i2, this.zzc);
        if (zzD == 0) {
            return zzesf.zzb;
        }
        if (zzD == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzi(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzi(i - i3, i2 - i3);
        }
        zzesf zzesf = this.zzd;
        return new zzeve(zzesf.zzi(i, zzesf.zzc()), this.zze.zzi(0, i2 - this.zzf));
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zzerv zzerv) throws IOException {
        this.zzd.zzj(zzerv);
        this.zze.zzj(zzerv);
    }

    /* access modifiers changed from: protected */
    public final String zzk(Charset charset) {
        return new String(zzy(), charset);
    }

    public final boolean zzl() {
        int zzm = this.zzd.zzm(0, 0, this.zzf);
        zzesf zzesf = this.zze;
        if (zzesf.zzm(zzm, 0, zzesf.zzc()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int zzm(int i, int i2, int i3) {
        int i4 = this.zzf;
        if (i2 + i3 <= i4) {
            return this.zzd.zzm(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.zze.zzm(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.zze.zzm(this.zzd.zzm(i, i2, i5), 0, i3 - i5);
    }

    /* access modifiers changed from: protected */
    public final int zzn(int i, int i2, int i3) {
        int i4 = this.zzf;
        if (i2 + i3 <= i4) {
            return this.zzd.zzn(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.zze.zzn(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.zze.zzn(this.zzd.zzn(i, i2, i5), 0, i3 - i5);
    }

    public final zzesj zzo() {
        return new zzesi(new zzevd(this), 4096, (zzesg) null);
    }

    public final zzesa zzp() {
        return new zzeva(this);
    }

    /* synthetic */ zzeve(zzesf zzesf, zzesf zzesf2, zzeva zzeva) {
        this(zzesf, zzesf2);
    }
}
