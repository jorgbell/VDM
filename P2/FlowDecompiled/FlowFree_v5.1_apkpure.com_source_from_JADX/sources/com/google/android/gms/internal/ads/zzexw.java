package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzexw implements Iterator<zzbp>, Closeable, zzbq {
    private static final zzbp zza = new zzexv("eof ");
    protected zzbm zzc;
    protected zzexx zzd;
    zzbp zze = null;
    long zzf = 0;
    long zzg = 0;
    private final List<zzbp> zzh = new ArrayList();

    static {
        zzeyd.zzb(zzexw.class);
    }

    public void close() throws IOException {
    }

    public final boolean hasNext() {
        zzbp zzbp = this.zze;
        if (zzbp == zza) {
            return false;
        }
        if (zzbp != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzh.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzh.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public final List<zzbp> zzd() {
        return (this.zzd == null || this.zze == zza) ? this.zzh : new zzeyc(this.zzh, this);
    }

    public final void zze(zzexx zzexx, long j, zzbm zzbm) throws IOException {
        this.zzd = zzexx;
        this.zzf = zzexx.zzc();
        zzexx.zzd(zzexx.zzc() + j);
        this.zzg = zzexx.zzc();
        this.zzc = zzbm;
    }

    /* renamed from: zzf */
    public final zzbp next() {
        zzbp zzb;
        zzbp zzbp = this.zze;
        if (zzbp == null || zzbp == zza) {
            zzexx zzexx = this.zzd;
            if (zzexx == null || this.zzf >= this.zzg) {
                this.zze = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzexx) {
                    this.zzd.zzd(this.zzf);
                    zzb = this.zzc.zzb(this.zzd, this);
                    this.zzf = this.zzd.zzc();
                }
                return zzb;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zze = null;
            return zzbp;
        }
    }
}
