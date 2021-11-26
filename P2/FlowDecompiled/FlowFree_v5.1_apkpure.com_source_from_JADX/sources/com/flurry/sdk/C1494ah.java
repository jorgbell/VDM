package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.ah */
public final class C1494ah {

    /* renamed from: a */
    public final boolean f3756a;

    /* renamed from: b */
    public final byte[] f3757b;

    /* renamed from: c */
    public final byte[] f3758c;

    /* renamed from: d */
    public final int f3759d;

    C1494ah(byte[] bArr, byte[] bArr2, boolean z, int i) {
        this.f3757b = bArr2;
        this.f3758c = bArr;
        this.f3756a = z;
        this.f3759d = i;
    }

    /* renamed from: com.flurry.sdk.ah$a */
    static class C1495a implements C1688ds<C1494ah> {
        C1495a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11274a(OutputStream outputStream, Object obj) throws IOException {
            C1494ah ahVar = (C1494ah) obj;
            if (outputStream != null && ahVar != null) {
                C14961 r0 = new DataOutputStream(outputStream) {
                    public final void close() {
                    }
                };
                r0.writeBoolean(ahVar.f3756a);
                byte[] bArr = ahVar.f3757b;
                if (bArr == null) {
                    r0.writeInt(0);
                } else {
                    r0.writeInt(bArr.length);
                    r0.write(ahVar.f3757b);
                }
                byte[] bArr2 = ahVar.f3758c;
                if (bArr2 == null) {
                    r0.writeInt(0);
                } else {
                    r0.writeInt(bArr2.length);
                    r0.write(ahVar.f3758c);
                }
                r0.writeInt(ahVar.f3759d);
                r0.flush();
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo11273a(InputStream inputStream) throws IOException {
            byte[] bArr;
            byte[] bArr2 = null;
            if (inputStream == null) {
                return null;
            }
            C14972 r1 = new DataInputStream(inputStream) {
                public final void close() {
                }
            };
            boolean readBoolean = r1.readBoolean();
            int readInt = r1.readInt();
            if (readInt > 0) {
                bArr = new byte[readInt];
                r1.read(bArr, 0, readInt);
            } else {
                bArr = null;
            }
            int readInt2 = r1.readInt();
            if (readInt2 > 0) {
                bArr2 = new byte[readInt2];
                r1.read(bArr2, 0, readInt2);
            }
            return new C1494ah(bArr2, bArr, readBoolean, r1.readInt());
        }
    }
}
