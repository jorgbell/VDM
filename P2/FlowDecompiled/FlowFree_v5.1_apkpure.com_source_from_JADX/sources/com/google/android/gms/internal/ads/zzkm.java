package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzkm extends zzkh {
    public final zzkk zza = new zzkk();
    public ByteBuffer zzb;
    public long zzc;

    public zzkm(int i) {
    }

    private final ByteBuffer zzj(int i) {
        ByteBuffer byteBuffer = this.zzb;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    public final void zza() {
        super.zza();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean zzi() {
        return zzg(1073741824);
    }

    public final void zzh(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            int capacity = byteBuffer.capacity();
            int position = this.zzb.position() + i;
            if (capacity < position) {
                zzj(position);
                throw null;
            }
            return;
        }
        zzj(i);
        throw null;
    }
}
