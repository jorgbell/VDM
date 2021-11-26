package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzevd extends InputStream {
    final /* synthetic */ zzeve zza;
    private zzevc zzb;
    private zzesb zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public zzevd(zzeve zzeve) {
        this.zza = zzeve;
        zzb();
    }

    private final int zza(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            zzc();
            if (this.zzc == null) {
                break;
            }
            int min = Math.min(this.zzd - this.zze, i3);
            if (bArr != null) {
                this.zzc.zzx(bArr, this.zze, i, min);
                i += min;
            }
            this.zze += min;
            i3 -= min;
        }
        return i2 - i3;
    }

    private final void zzb() {
        zzevc zzevc = new zzevc(this.zza, (zzeva) null);
        this.zzb = zzevc;
        zzesb zza2 = zzevc.next();
        this.zzc = zza2;
        this.zzd = zza2.zzc();
        this.zze = 0;
        this.zzf = 0;
    }

    private final void zzc() {
        int i;
        if (this.zzc != null && this.zze == (i = this.zzd)) {
            this.zzf += i;
            int i2 = 0;
            this.zze = 0;
            if (this.zzb.hasNext()) {
                zzesb zza2 = this.zzb.next();
                this.zzc = zza2;
                i2 = zza2.zzc();
            } else {
                this.zzc = null;
            }
            this.zzd = i2;
        }
    }

    private final int zzd() {
        return this.zza.zzc() - (this.zzf + this.zze);
    }

    public final int available() throws IOException {
        return zzd();
    }

    public final void mark(int i) {
        this.zzg = this.zzf + this.zze;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() throws IOException {
        zzc();
        zzesb zzesb = this.zzc;
        if (zzesb == null) {
            return -1;
        }
        int i = this.zze;
        this.zze = i + 1;
        return zzesb.zza(i) & Constants.UNKNOWN;
    }

    public final synchronized void reset() {
        zzb();
        zza((byte[]) null, 0, this.zzg);
    }

    public final long skip(long j) {
        if (j >= 0) {
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) zza((byte[]) null, 0, (int) j);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int read(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int zza2 = zza(bArr, i, i2);
        if (zza2 == 0) {
            return (i2 > 0 || zzd() == 0) ? -1 : 0;
        }
        return zza2;
    }
}
