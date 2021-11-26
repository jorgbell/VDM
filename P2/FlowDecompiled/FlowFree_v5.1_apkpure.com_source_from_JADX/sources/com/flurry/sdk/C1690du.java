package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.du */
public final class C1690du<T> implements C1688ds<T> {

    /* renamed from: a */
    private final String f4283a;

    /* renamed from: b */
    private final int f4284b;

    /* renamed from: c */
    private final C1693dv<T> f4285c;

    public C1690du(String str, int i, C1693dv<T> dvVar) {
        this.f4283a = str;
        this.f4284b = i;
        this.f4285c = dvVar;
    }

    /* renamed from: a */
    public final void mo11274a(OutputStream outputStream, T t) throws IOException {
        if (outputStream != null && this.f4285c != null) {
            C16911 r0 = new DataOutputStream(outputStream) {
                public final void close() {
                }
            };
            r0.writeUTF(this.f4283a);
            r0.writeInt(this.f4284b);
            this.f4285c.mo11281a(this.f4284b).mo11274a(r0, t);
            r0.flush();
        }
    }

    /* renamed from: a */
    public final T mo11273a(InputStream inputStream) throws IOException {
        if (inputStream == null || this.f4285c == null) {
            return null;
        }
        C16922 r0 = new DataInputStream(inputStream) {
            public final void close() {
            }
        };
        String readUTF = r0.readUTF();
        if (this.f4283a.equals(readUTF)) {
            return this.f4285c.mo11281a(r0.readInt()).mo11273a(r0);
        }
        throw new IOException("Signature: " + readUTF + " is invalid");
    }
}
