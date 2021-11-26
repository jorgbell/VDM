package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.bq */
public final class C1585bq {

    /* renamed from: a */
    String f4000a;

    /* synthetic */ C1585bq(byte b) {
        this();
    }

    private C1585bq() {
    }

    public C1585bq(String str) {
        this.f4000a = str;
    }

    /* renamed from: com.flurry.sdk.bq$a */
    public static class C1586a implements C1688ds<C1585bq> {
        /* renamed from: a */
        public final /* synthetic */ void mo11274a(OutputStream outputStream, Object obj) throws IOException {
            C1585bq bqVar = (C1585bq) obj;
            if (outputStream != null && bqVar != null) {
                C15871 r0 = new DataOutputStream(outputStream) {
                    public final void close() {
                    }
                };
                r0.writeUTF(bqVar.f4000a);
                r0.flush();
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo11273a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C15882 r0 = new DataInputStream(inputStream) {
                public final void close() {
                }
            };
            C1585bq bqVar = new C1585bq((byte) 0);
            bqVar.f4000a = r0.readUTF();
            return bqVar;
        }
    }
}
