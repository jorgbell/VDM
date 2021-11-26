package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzkg implements zzji {
    private int zzb = -1;
    private int zzc = -1;
    private zzkf zzd;
    private float zze = 1.0f;
    private float zzf = 1.0f;
    private ByteBuffer zzg;
    private ShortBuffer zzh;
    private ByteBuffer zzi;
    private long zzj;
    private long zzk;
    private boolean zzl;

    public zzkg() {
        ByteBuffer byteBuffer = zzji.zza;
        this.zzg = byteBuffer;
        this.zzh = byteBuffer.asShortBuffer();
        this.zzi = byteBuffer;
    }

    public final boolean zza(int i, int i2, int i3) throws zzjh {
        if (i3 != 2) {
            throw new zzjh(i, i2, i3);
        } else if (this.zzc == i && this.zzb == i2) {
            return false;
        } else {
            this.zzc = i;
            this.zzb = i2;
            return true;
        }
    }

    public final boolean zzb() {
        return Math.abs(this.zze + -1.0f) >= 0.01f || Math.abs(this.zzf + -1.0f) >= 0.01f;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return 2;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzj += (long) remaining;
            this.zzd.zzc(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzf2 = this.zzd.zzf() * this.zzb;
        int i = zzf2 + zzf2;
        if (i > 0) {
            if (this.zzg.capacity() < i) {
                ByteBuffer order = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                this.zzg = order;
                this.zzh = order.asShortBuffer();
            } else {
                this.zzg.clear();
                this.zzh.clear();
            }
            this.zzd.zzd(this.zzh);
            this.zzk += (long) i;
            this.zzg.limit(i);
            this.zzi = this.zzg;
        }
    }

    public final void zzf() {
        this.zzd.zze();
        this.zzl = true;
    }

    public final ByteBuffer zzg() {
        ByteBuffer byteBuffer = this.zzi;
        this.zzi = zzji.zza;
        return byteBuffer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r3.zzd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzh() {
        /*
            r3 = this;
            boolean r0 = r3.zzl
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzkf r0 = r3.zzd
            if (r0 == 0) goto L_0x0013
            int r0 = r0.zzf()
            if (r0 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            return r1
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkg.zzh():boolean");
    }

    public final void zzi() {
        zzkf zzkf = new zzkf(this.zzc, this.zzb);
        this.zzd = zzkf;
        zzkf.zza(this.zze);
        this.zzd.zzb(this.zzf);
        this.zzi = zzji.zza;
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = false;
    }

    public final void zzj() {
        this.zzd = null;
        ByteBuffer byteBuffer = zzji.zza;
        this.zzg = byteBuffer;
        this.zzh = byteBuffer.asShortBuffer();
        this.zzi = byteBuffer;
        this.zzb = -1;
        this.zzc = -1;
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = false;
    }

    public final float zzk(float f) {
        float zzg2 = zzqj.zzg(f, 0.1f, 8.0f);
        this.zze = zzg2;
        return zzg2;
    }

    public final float zzl(float f) {
        this.zzf = zzqj.zzg(1.0f, 0.1f, 8.0f);
        return 1.0f;
    }

    public final long zzm() {
        return this.zzj;
    }

    public final long zzn() {
        return this.zzk;
    }
}
