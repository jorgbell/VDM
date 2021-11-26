package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
abstract class zzk extends zzi {
    private static final WeakReference<byte[]> zzb = new WeakReference<>((Object) null);
    private WeakReference<byte[]> zza = zzb;

    zzk(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] zzb();

    /* access modifiers changed from: package-private */
    public final byte[] zzc() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zza.get();
            if (bArr == null) {
                bArr = zzb();
                this.zza = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
