package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

/* renamed from: com.flurry.sdk.j */
public final class C1877j extends MessageDigest {

    /* renamed from: a */
    private CRC32 f4615a = new CRC32();

    public C1877j() {
        super("CRC");
    }

    /* access modifiers changed from: protected */
    public final void engineUpdate(byte b) {
        this.f4615a.update(b);
    }

    /* access modifiers changed from: protected */
    public final void engineUpdate(byte[] bArr, int i, int i2) {
        this.f4615a.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public final byte[] engineDigest() {
        long value = this.f4615a.getValue();
        return new byte[]{(byte) ((int) ((-16777216 & value) >> 24)), (byte) ((int) ((16711680 & value) >> 16)), (byte) ((int) ((65280 & value) >> 8)), (byte) ((int) ((value & 255) >> 0))};
    }

    /* access modifiers changed from: protected */
    public final void engineReset() {
        this.f4615a.reset();
    }

    /* renamed from: a */
    public final int mo11552a() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }
}
