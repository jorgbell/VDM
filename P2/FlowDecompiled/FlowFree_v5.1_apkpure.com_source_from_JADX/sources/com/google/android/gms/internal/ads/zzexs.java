package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzexs implements zzbp {
    private static final zzeyd zza = zzeyd.zzb(zzexs.class);
    protected final String zzb;
    boolean zzc;
    boolean zzd;
    long zze;
    long zzf = -1;
    zzexx zzg;
    private ByteBuffer zzi;

    protected zzexs(String str) {
        this.zzb = str;
        this.zzd = true;
        this.zzc = true;
    }

    private final synchronized void zzd() {
        if (!this.zzd) {
            try {
                zzeyd zzeyd = zza;
                String str = this.zzb;
                zzeyd.zza(str.length() != 0 ? "mem mapping ".concat(str) : new String("mem mapping "));
                this.zzi = this.zzg.zze(this.zze, this.zzf);
                this.zzd = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void zza(zzbq zzbq) {
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(zzexx zzexx, ByteBuffer byteBuffer, long j, zzbm zzbm) throws IOException {
        this.zze = zzexx.zzc();
        byteBuffer.remaining();
        this.zzf = j;
        this.zzg = zzexx;
        zzexx.zzd(zzexx.zzc() + j);
        this.zzd = false;
        this.zzc = false;
        zzg();
    }

    /* access modifiers changed from: protected */
    public abstract void zzf(ByteBuffer byteBuffer);

    public final synchronized void zzg() {
        zzd();
        zzeyd zzeyd = zza;
        String str = this.zzb;
        zzeyd.zza(str.length() != 0 ? "parsing details of ".concat(str) : new String("parsing details of "));
        ByteBuffer byteBuffer = this.zzi;
        if (byteBuffer != null) {
            this.zzc = true;
            byteBuffer.rewind();
            zzf(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                byteBuffer.slice();
            }
            this.zzi = null;
        }
    }
}
