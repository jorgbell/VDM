package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbk extends ThreadLocal<ByteBuffer> {
    zzbk(zzbl zzbl) {
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
